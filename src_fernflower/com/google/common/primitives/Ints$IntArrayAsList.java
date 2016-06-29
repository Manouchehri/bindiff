package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
class Ints$IntArrayAsList extends AbstractList implements Serializable, RandomAccess {
   final int[] array;
   final int start;
   final int end;
   private static final long serialVersionUID = 0L;

   Ints$IntArrayAsList(int[] var1) {
      this(var1, 0, var1.length);
   }

   Ints$IntArrayAsList(int[] var1, int var2, int var3) {
      this.array = var1;
      this.start = var2;
      this.end = var3;
   }

   public int size() {
      return this.end - this.start;
   }

   public boolean isEmpty() {
      return false;
   }

   public Integer get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      return Integer.valueOf(this.array[this.start + var1]);
   }

   public boolean contains(Object var1) {
      return var1 instanceof Integer && Ints.access$000(this.array, ((Integer)var1).intValue(), this.start, this.end) != -1;
   }

   public int indexOf(Object var1) {
      if(var1 instanceof Integer) {
         int var2 = Ints.access$000(this.array, ((Integer)var1).intValue(), this.start, this.end);
         if(var2 >= 0) {
            return var2 - this.start;
         }
      }

      return -1;
   }

   public int lastIndexOf(Object var1) {
      if(var1 instanceof Integer) {
         int var2 = Ints.access$100(this.array, ((Integer)var1).intValue(), this.start, this.end);
         if(var2 >= 0) {
            return var2 - this.start;
         }
      }

      return -1;
   }

   public Integer set(int var1, Integer var2) {
      Preconditions.checkElementIndex(var1, this.size());
      int var3 = this.array[this.start + var1];
      this.array[this.start + var1] = ((Integer)Preconditions.checkNotNull(var2)).intValue();
      return Integer.valueOf(var3);
   }

   public List subList(int var1, int var2) {
      int var3 = this.size();
      Preconditions.checkPositionIndexes(var1, var2, var3);
      return (List)(var1 == var2?Collections.emptyList():new Ints$IntArrayAsList(this.array, this.start + var1, this.start + var2));
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof Ints$IntArrayAsList) {
         Ints$IntArrayAsList var2 = (Ints$IntArrayAsList)var1;
         int var3 = this.size();
         if(var2.size() != var3) {
            return false;
         } else {
            for(int var4 = 0; var4 < var3; ++var4) {
               if(this.array[this.start + var4] != var2.array[var2.start + var4]) {
                  return false;
               }
            }

            return true;
         }
      } else {
         return super.equals(var1);
      }
   }

   public int hashCode() {
      int var1 = 1;

      for(int var2 = this.start; var2 < this.end; ++var2) {
         var1 = 31 * var1 + Ints.hashCode(this.array[var2]);
      }

      return var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(this.size() * 5);
      var1.append('[').append(this.array[this.start]);

      for(int var2 = this.start + 1; var2 < this.end; ++var2) {
         var1.append(", ").append(this.array[var2]);
      }

      return var1.append(']').toString();
   }

   int[] toIntArray() {
      int var1 = this.size();
      int[] var2 = new int[var1];
      System.arraycopy(this.array, this.start, var2, 0, var1);
      return var2;
   }
}
