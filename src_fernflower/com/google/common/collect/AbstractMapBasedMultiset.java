package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultiset$1;
import com.google.common.collect.AbstractMapBasedMultiset$MapBasedMultisetIterator;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Count;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
abstract class AbstractMapBasedMultiset extends AbstractMultiset implements Serializable {
   private transient Map backingMap;
   private transient long size;
   @GwtIncompatible("not needed in emulated source.")
   private static final long serialVersionUID = -2250766705698539974L;

   protected AbstractMapBasedMultiset(Map var1) {
      this.backingMap = (Map)Preconditions.checkNotNull(var1);
      this.size = (long)super.size();
   }

   void setBackingMap(Map var1) {
      this.backingMap = var1;
   }

   public Set entrySet() {
      return super.entrySet();
   }

   Iterator entryIterator() {
      Iterator var1 = this.backingMap.entrySet().iterator();
      return new AbstractMapBasedMultiset$1(this, var1);
   }

   public void clear() {
      Iterator var1 = this.backingMap.values().iterator();

      while(var1.hasNext()) {
         Count var2 = (Count)var1.next();
         var2.set(0);
      }

      this.backingMap.clear();
      this.size = 0L;
   }

   int distinctElements() {
      return this.backingMap.size();
   }

   public int size() {
      return Ints.saturatedCast(this.size);
   }

   public Iterator iterator() {
      return new AbstractMapBasedMultiset$MapBasedMultisetIterator(this);
   }

   public int count(@Nullable Object var1) {
      Count var2 = (Count)Maps.safeGet(this.backingMap, var1);
      return var2 == null?0:var2.get();
   }

   public int add(@Nullable Object var1, int var2) {
      if(var2 == 0) {
         return this.count(var1);
      } else {
         Preconditions.checkArgument(var2 > 0, "occurrences cannot be negative: %s", new Object[]{Integer.valueOf(var2)});
         Count var3 = (Count)this.backingMap.get(var1);
         int var4;
         if(var3 == null) {
            var4 = 0;
            this.backingMap.put(var1, new Count(var2));
         } else {
            var4 = var3.get();
            long var5 = (long)var4 + (long)var2;
            Preconditions.checkArgument(var5 <= 2147483647L, "too many occurrences: %s", new Object[]{Long.valueOf(var5)});
            var3.getAndAdd(var2);
         }

         this.size += (long)var2;
         return var4;
      }
   }

   public int remove(@Nullable Object var1, int var2) {
      if(var2 == 0) {
         return this.count(var1);
      } else {
         Preconditions.checkArgument(var2 > 0, "occurrences cannot be negative: %s", new Object[]{Integer.valueOf(var2)});
         Count var3 = (Count)this.backingMap.get(var1);
         if(var3 == null) {
            return 0;
         } else {
            int var4 = var3.get();
            int var5;
            if(var4 > var2) {
               var5 = var2;
            } else {
               var5 = var4;
               this.backingMap.remove(var1);
            }

            var3.addAndGet(-var5);
            this.size -= (long)var5;
            return var4;
         }
      }
   }

   public int setCount(@Nullable Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "count");
      Count var3;
      int var4;
      if(var2 == 0) {
         var3 = (Count)this.backingMap.remove(var1);
         var4 = getAndSet(var3, var2);
      } else {
         var3 = (Count)this.backingMap.get(var1);
         var4 = getAndSet(var3, var2);
         if(var3 == null) {
            this.backingMap.put(var1, new Count(var2));
         }
      }

      this.size += (long)(var2 - var4);
      return var4;
   }

   private static int getAndSet(Count var0, int var1) {
      return var0 == null?0:var0.getAndSet(var1);
   }

   @GwtIncompatible("java.io.ObjectStreamException")
   private void readObjectNoData() {
      throw new InvalidObjectException("Stream data required");
   }

   // $FF: synthetic method
   static Map access$000(AbstractMapBasedMultiset var0) {
      return var0.backingMap;
   }

   // $FF: synthetic method
   static long access$100(AbstractMapBasedMultiset var0) {
      return var0.size;
   }

   // $FF: synthetic method
   static long access$102(AbstractMapBasedMultiset var0, long var1) {
      return var0.size = var1;
   }

   // $FF: synthetic method
   static long access$110(AbstractMapBasedMultiset var0) {
      return (long)(var0.size--);
   }
}
