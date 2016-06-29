package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.LongAddable;
import com.google.common.cache.Striped64;
import com.google.common.cache.Striped64$Cell;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@GwtCompatible(
   emulated = true
)
final class LongAdder extends Striped64 implements LongAddable, Serializable {
   private static final long serialVersionUID = 7249069246863182397L;

   final long fn(long var1, long var3) {
      return var1 + var3;
   }

   public void add(long var1) {
      Striped64$Cell[] var3 = this.cells;
      if(this.cells == null) {
         long var4 = this.base;
         if(this.casBase(this.base, var4 + var1)) {
            return;
         }
      }

      boolean var11 = true;
      int[] var8;
      Striped64$Cell var9;
      int var10;
      if((var8 = (int[])threadHashCode.get()) != null && var3 != null && (var10 = var3.length) >= 1 && (var9 = var3[var10 - 1 & var8[0]]) != null) {
         long var6 = var9.value;
         if(var11 = var9.cas(var9.value, var6 + var1)) {
            return;
         }
      }

      this.retryUpdate(var1, var8, var11);
   }

   public void increment() {
      this.add(1L);
   }

   public void decrement() {
      this.add(-1L);
   }

   public long sum() {
      long var1 = this.base;
      Striped64$Cell[] var3 = this.cells;
      if(var3 != null) {
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Striped64$Cell var6 = var3[var5];
            if(var6 != null) {
               var1 += var6.value;
            }
         }
      }

      return var1;
   }

   public void reset() {
      this.internalReset(0L);
   }

   public long sumThenReset() {
      long var1 = this.base;
      Striped64$Cell[] var3 = this.cells;
      this.base = 0L;
      if(var3 != null) {
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Striped64$Cell var6 = var3[var5];
            if(var6 != null) {
               var1 += var6.value;
               var6.value = 0L;
            }
         }
      }

      return var1;
   }

   public String toString() {
      return Long.toString(this.sum());
   }

   public long longValue() {
      return this.sum();
   }

   public int intValue() {
      return (int)this.sum();
   }

   public float floatValue() {
      return (float)this.sum();
   }

   public double doubleValue() {
      return (double)this.sum();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeLong(this.sum());
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.busy = 0;
      this.cells = null;
      this.base = var1.readLong();
   }
}
