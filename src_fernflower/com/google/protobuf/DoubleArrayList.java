package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal$DoubleList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList implements Internal$DoubleList, RandomAccess {
   private static final int DEFAULT_CAPACITY = 10;
   private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList();
   private double[] array;
   private int size;

   public static DoubleArrayList emptyList() {
      return EMPTY_LIST;
   }

   DoubleArrayList() {
      this.array = new double[10];
      this.size = 0;
   }

   DoubleArrayList(List var1) {
      if(var1 instanceof DoubleArrayList) {
         DoubleArrayList var2 = (DoubleArrayList)var1;
         this.array = (double[])var2.array.clone();
         this.size = var2.size;
      } else {
         this.size = var1.size();
         this.array = new double[this.size];

         for(int var3 = 0; var3 < this.size; ++var3) {
            this.array[var3] = ((Double)var1.get(var3)).doubleValue();
         }
      }

   }

   public Double get(int var1) {
      return Double.valueOf(this.getDouble(var1));
   }

   public double getDouble(int var1) {
      this.ensureIndexInRange(var1);
      return this.array[var1];
   }

   public int size() {
      return this.size;
   }

   public Double set(int var1, Double var2) {
      return Double.valueOf(this.setDouble(var1, var2.doubleValue()));
   }

   public double setDouble(int var1, double var2) {
      this.ensureIsMutable();
      this.ensureIndexInRange(var1);
      double var4 = this.array[var1];
      this.array[var1] = var2;
      return var4;
   }

   public void add(int var1, Double var2) {
      this.addDouble(var1, var2.doubleValue());
   }

   public void addDouble(double var1) {
      this.addDouble(this.size, var1);
   }

   private void addDouble(int var1, double var2) {
      this.ensureIsMutable();
      if(var1 >= 0 && var1 <= this.size) {
         if(this.size < this.array.length) {
            System.arraycopy(this.array, var1, this.array, var1 + 1, this.size - var1);
         } else {
            int var4 = this.size * 3 / 2 + 1;
            double[] var5 = new double[var4];
            System.arraycopy(this.array, 0, var5, 0, var1);
            System.arraycopy(this.array, var1, var5, var1 + 1, this.size - var1);
            this.array = var5;
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
      } else if(!(var1 instanceof DoubleArrayList)) {
         return super.addAll(var1);
      } else {
         DoubleArrayList var2 = (DoubleArrayList)var1;
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
         if(var1.equals(Double.valueOf(this.array[var2]))) {
            System.arraycopy(this.array, var2 + 1, this.array, var2, this.size - var2);
            --this.size;
            ++this.modCount;
            return true;
         }
      }

      return false;
   }

   public Double remove(int var1) {
      this.ensureIsMutable();
      this.ensureIndexInRange(var1);
      double var2 = this.array[var1];
      System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
      --this.size;
      ++this.modCount;
      return Double.valueOf(var2);
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
