package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
@GoogleInternal
public final class TopKSelector {
   private final int k;
   private final Comparator comparator;
   private final Object[] buffer;
   private int bufferSize;
   private Object threshold;

   public static TopKSelector least(int var0) {
      return least(var0, Ordering.natural());
   }

   public static TopKSelector greatest(int var0) {
      return greatest(var0, Ordering.natural());
   }

   public static TopKSelector least(int var0, Comparator var1) {
      return new TopKSelector(var1, var0);
   }

   public static TopKSelector greatest(int var0, Comparator var1) {
      return new TopKSelector(Ordering.from(var1).reverse(), var0);
   }

   private TopKSelector(Comparator var1, int var2) {
      this.comparator = (Comparator)Preconditions.checkNotNull(var1, "comparator");
      this.k = var2;
      Preconditions.checkArgument(var2 >= 0, "k must be nonnegative, was %s", new Object[]{Integer.valueOf(var2)});
      this.buffer = (Object[])(new Object[var2 * 2]);
      this.bufferSize = 0;
      this.threshold = null;
   }

   public void offer(@Nullable Object var1) {
      if(this.k != 0) {
         if(this.bufferSize == 0) {
            this.buffer[0] = var1;
            this.threshold = var1;
            this.bufferSize = 1;
         } else if(this.bufferSize < this.k) {
            this.buffer[this.bufferSize++] = var1;
            if(this.comparator.compare(var1, this.threshold) > 0) {
               this.threshold = var1;
            }
         } else if(this.comparator.compare(var1, this.threshold) < 0) {
            this.buffer[this.bufferSize++] = var1;
            if(this.bufferSize == 2 * this.k) {
               this.trim();
            }
         }

      }
   }

   private void trim() {
      int var1 = 0;
      int var2 = 2 * this.k - 1;
      int var3 = 0;

      int var4;
      while(var1 < var2) {
         var4 = var1 + var2 + 1 >>> 1;
         int var5 = this.partition(var1, var2, var4);
         if(var5 > this.k) {
            var2 = var5 - 1;
         } else {
            if(var5 >= this.k) {
               break;
            }

            var1 = Math.max(var5, var1 + 1);
            var3 = var5;
         }
      }

      this.bufferSize = this.k;
      this.threshold = this.buffer[var3];

      for(var4 = var3 + 1; var4 < this.k; ++var4) {
         if(this.comparator.compare(this.buffer[var4], this.threshold) > 0) {
            this.threshold = this.buffer[var4];
         }
      }

   }

   private int partition(int var1, int var2, int var3) {
      Object var4 = this.buffer[var3];
      this.buffer[var3] = this.buffer[var2];
      int var5 = var1;

      for(int var6 = var1; var6 < var2; ++var6) {
         if(this.comparator.compare(this.buffer[var6], var4) < 0) {
            this.swap(var5, var6);
            ++var5;
         }
      }

      this.buffer[var2] = this.buffer[var5];
      this.buffer[var5] = var4;
      return var5;
   }

   private void swap(int var1, int var2) {
      Object var3 = this.buffer[var1];
      this.buffer[var1] = this.buffer[var2];
      this.buffer[var2] = var3;
   }

   public void offerAll(Iterable var1) {
      this.offerAll(var1.iterator());
   }

   public void offerAll(Iterator var1) {
      while(var1.hasNext()) {
         this.offer(var1.next());
      }

   }

   public List topK() {
      Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
      if(this.bufferSize > this.k) {
         Arrays.fill(this.buffer, this.k, this.buffer.length, (Object)null);
         this.bufferSize = this.k;
         this.threshold = this.buffer[this.k - 1];
      }

      return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
   }
}
