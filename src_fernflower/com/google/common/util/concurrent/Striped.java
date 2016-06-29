package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.Striped$1;
import com.google.common.util.concurrent.Striped$2;
import com.google.common.util.concurrent.Striped$3;
import com.google.common.util.concurrent.Striped$4;
import com.google.common.util.concurrent.Striped$5;
import com.google.common.util.concurrent.Striped$CompactStriped;
import com.google.common.util.concurrent.Striped$LargeLazyStriped;
import com.google.common.util.concurrent.Striped$SmallLazyStriped;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Beta
public abstract class Striped {
   private static final int LARGE_LAZY_CUTOFF = 1024;
   private static final Supplier READ_WRITE_LOCK_SUPPLIER = new Striped$5();
   private static final int ALL_SET = -1;

   private Striped() {
   }

   public abstract Object get(Object var1);

   public abstract Object getAt(int var1);

   abstract int indexFor(Object var1);

   public abstract int size();

   public Iterable bulkGet(Iterable var1) {
      Object[] var2 = Iterables.toArray(var1, Object.class);
      if(var2.length == 0) {
         return ImmutableList.of();
      } else {
         int[] var3 = new int[var2.length];

         int var4;
         for(var4 = 0; var4 < var2.length; ++var4) {
            var3[var4] = this.indexFor(var2[var4]);
         }

         Arrays.sort(var3);
         var4 = var3[0];
         var2[0] = this.getAt(var4);

         for(int var5 = 1; var5 < var2.length; ++var5) {
            int var6 = var3[var5];
            if(var6 == var4) {
               var2[var5] = var2[var5 - 1];
            } else {
               var2[var5] = this.getAt(var6);
               var4 = var6;
            }
         }

         List var7 = Arrays.asList(var2);
         return Collections.unmodifiableList(var7);
      }
   }

   public static Striped lock(int var0) {
      return new Striped$CompactStriped(var0, new Striped$1(), (Striped$1)null);
   }

   public static Striped lazyWeakLock(int var0) {
      return lazy(var0, new Striped$2());
   }

   private static Striped lazy(int var0, Supplier var1) {
      return (Striped)(var0 < 1024?new Striped$SmallLazyStriped(var0, var1):new Striped$LargeLazyStriped(var0, var1));
   }

   public static Striped semaphore(int var0, int var1) {
      return new Striped$CompactStriped(var0, new Striped$3(var1), (Striped$1)null);
   }

   public static Striped lazyWeakSemaphore(int var0, int var1) {
      return lazy(var0, new Striped$4(var1));
   }

   public static Striped readWriteLock(int var0) {
      return new Striped$CompactStriped(var0, READ_WRITE_LOCK_SUPPLIER, (Striped$1)null);
   }

   public static Striped lazyWeakReadWriteLock(int var0) {
      return lazy(var0, READ_WRITE_LOCK_SUPPLIER);
   }

   private static int ceilToPowerOfTwo(int var0) {
      return 1 << IntMath.log2(var0, RoundingMode.CEILING);
   }

   private static int smear(int var0) {
      var0 ^= var0 >>> 20 ^ var0 >>> 12;
      return var0 ^ var0 >>> 7 ^ var0 >>> 4;
   }

   // $FF: synthetic method
   Striped(Striped$1 var1) {
      this();
   }

   // $FF: synthetic method
   static int access$200(int var0) {
      return ceilToPowerOfTwo(var0);
   }

   // $FF: synthetic method
   static int access$300(int var0) {
      return smear(var0);
   }
}
