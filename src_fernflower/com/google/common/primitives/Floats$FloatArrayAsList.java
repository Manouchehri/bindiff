package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Floats;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
class Floats$FloatArrayAsList extends AbstractList implements Serializable, RandomAccess {
   final float[] array;
   final int start;
   final int end;
   private static final long serialVersionUID = 0L;

   Floats$FloatArrayAsList(float[] var1) {
      this(var1, 0, var1.length);
   }

   Floats$FloatArrayAsList(float[] var1, int var2, int var3) {
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

   public Float get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      return Float.valueOf(this.array[this.start + var1]);
   }

   public boolean contains(Object var1) {
      return var1 instanceof Float && Floats.access$000(this.array, ((Float)var1).floatValue(), this.start, this.end) != -1;
   }

   public int indexOf(Object var1) {
      if(var1 instanceof Float) {
         int var2 = Floats.access$000(this.array, ((Float)var1).floatValue(), this.start, this.end);
         if(var2 >= 0) {
            return var2 - this.start;
         }
      }

      return -1;
   }

   public int lastIndexOf(Object var1) {
      if(var1 instanceof Float) {
         int var2 = Floats.access$100(this.array, ((Float)var1).floatValue(), this.start, this.end);
         if(var2 >= 0) {
            return var2 - this.start;
         }
      }

      return -1;
   }

   public Float set(int var1, Float var2) {
      Preconditions.checkElementIndex(var1, this.size());
      float var3 = this.array[this.start + var1];
      this.array[this.start + var1] = ((Float)Preconditions.checkNotNull(var2)).floatValue();
      return Float.valueOf(var3);
   }

   public List subList(int var1, int var2) {
      int var3 = this.size();
      Preconditions.checkPositionIndexes(var1, var2, var3);
      return (List)(var1 == var2?Collections.emptyList():new Floats$FloatArrayAsList(this.array, this.start + var1, this.start + var2));
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof Floats$FloatArrayAsList) {
         Floats$FloatArrayAsList var2 = (Floats$FloatArrayAsList)var1;
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
         var1 = 31 * var1 + Floats.hashCode(this.array[var2]);
      }

      return var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(this.size() * 12);
      var1.append('[').append(this.array[this.start]);

      for(int var2 = this.start + 1; var2 < this.end; ++var2) {
         var1.append(", ").append(this.array[var2]);
      }

      return var1.append(']').toString();
   }

   float[] toFloatArray() {
      int var1 = this.size();
      float[] var2 = new float[var1];
      System.arraycopy(this.array, this.start, var2, 0, var1);
      return var2;
   }
}
