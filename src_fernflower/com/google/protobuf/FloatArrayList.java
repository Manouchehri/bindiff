package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal$FloatList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class FloatArrayList extends AbstractProtobufList implements Internal$FloatList, RandomAccess {
   private static final int DEFAULT_CAPACITY = 10;
   private static final FloatArrayList EMPTY_LIST = new FloatArrayList();
   private float[] array;
   private int size;

   public static FloatArrayList emptyList() {
      return EMPTY_LIST;
   }

   FloatArrayList() {
      this.array = new float[10];
      this.size = 0;
   }

   FloatArrayList(List var1) {
      if(var1 instanceof FloatArrayList) {
         FloatArrayList var2 = (FloatArrayList)var1;
         this.array = (float[])var2.array.clone();
         this.size = var2.size;
      } else {
         this.size = var1.size();
         this.array = new float[this.size];

         for(int var3 = 0; var3 < this.size; ++var3) {
            this.array[var3] = ((Float)var1.get(var3)).floatValue();
         }
      }

   }

   public Float get(int var1) {
      return Float.valueOf(this.getFloat(var1));
   }

   public float getFloat(int var1) {
      this.ensureIndexInRange(var1);
      return this.array[var1];
   }

   public int size() {
      return this.size;
   }

   public Float set(int var1, Float var2) {
      return Float.valueOf(this.setFloat(var1, var2.floatValue()));
   }

   public float setFloat(int var1, float var2) {
      this.ensureIsMutable();
      this.ensureIndexInRange(var1);
      float var3 = this.array[var1];
      this.array[var1] = var2;
      return var3;
   }

   public void add(int var1, Float var2) {
      this.addFloat(var1, var2.floatValue());
   }

   public void addFloat(float var1) {
      this.addFloat(this.size, var1);
   }

   private void addFloat(int var1, float var2) {
      this.ensureIsMutable();
      if(var1 >= 0 && var1 <= this.size) {
         if(this.size < this.array.length) {
            System.arraycopy(this.array, var1, this.array, var1 + 1, this.size - var1);
         } else {
            int var3 = this.size * 3 / 2 + 1;
            float[] var4 = new float[var3];
            System.arraycopy(this.array, 0, var4, 0, var1);
            System.arraycopy(this.array, var1, var4, var1 + 1, this.size - var1);
            this.array = var4;
         }

         this.array[var1] = var2;
         ++this.size;
         ++this.modCount;
      } else {
         throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(var1));
      }
   }

   public boolean addAll(Collection var1) {
      this.ensureIsMutable();
      if(var1 == null) {
         throw new NullPointerException();
      } else if(!(var1 instanceof FloatArrayList)) {
         return super.addAll(var1);
      } else {
         FloatArrayList var2 = (FloatArrayList)var1;
         if(var2.size == 0) {
            return false;
         } else {
            int var3 = Integer.MAX_VALUE - this.size;
            if(var3 < var2.size) {
               throw new OutOfMemoryError();
            } else {
               int var4 = this.size + var2.size;
               if(var4 > this.array.length) {
                  this.array = Arrays.copyOf(this.array, var4);
               }

               System.arraycopy(var2.array, 0, this.array, this.size, var2.size);
               this.size = var4;
               ++this.modCount;
               return true;
            }
         }
      }
   }

   public boolean remove(Object var1) {
      this.ensureIsMutable();

      for(int var2 = 0; var2 < this.size; ++var2) {
         if(var1.equals(Float.valueOf(this.array[var2]))) {
            System.arraycopy(this.array, var2 + 1, this.array, var2, this.size - var2);
            --this.size;
            ++this.modCount;
            return true;
         }
      }

      return false;
   }

   public Float remove(int var1) {
      this.ensureIsMutable();
      this.ensureIndexInRange(var1);
      float var2 = this.array[var1];
      System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
      --this.size;
      ++this.modCount;
      return Float.valueOf(var2);
   }

   private void ensureIndexInRange(int var1) {
      if(var1 < 0 || var1 >= this.size) {
         throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(var1));
      }
   }

   private String makeOutOfBoundsExceptionMessage(int var1) {
      int var3 = this.size;
      return (new StringBuilder(35)).append("Index:").append(var1).append(", Size:").append(var3).toString();
   }

   static {
      EMPTY_LIST.makeImmutable();
   }
}
