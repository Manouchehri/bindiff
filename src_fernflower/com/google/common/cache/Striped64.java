package com.google.common.cache;

import com.google.common.cache.Striped64$1;
import com.google.common.cache.Striped64$Cell;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64 extends Number {
   static final ThreadLocal threadHashCode = new ThreadLocal();
   static final Random rng = new Random();
   static final int NCPU = Runtime.getRuntime().availableProcessors();
   transient volatile Striped64$Cell[] cells;
   transient volatile long base;
   transient volatile int busy;
   private static final Unsafe UNSAFE;
   private static final long baseOffset;
   private static final long busyOffset;

   final boolean casBase(long var1, long var3) {
      return UNSAFE.compareAndSwapLong(this, baseOffset, var1, var3);
   }

   final boolean casBusy() {
      return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
   }

   abstract long fn(long var1, long var3);

   final void retryUpdate(long var1, int[] var3, boolean var4) {
      int var5;
      if(var3 == null) {
         threadHashCode.set(var3 = new int[1]);
         int var6 = rng.nextInt();
         var5 = var3[0] = var6 == 0?1:var6;
      } else {
         var5 = var3[0];
      }

      boolean var32 = false;

      while(true) {
         Striped64$Cell[] var7 = this.cells;
         int var9;
         long var10;
         if(this.cells != null && (var9 = var7.length) > 0) {
            Striped64$Cell var8;
            if((var8 = var7[var9 - 1 & var5]) == null) {
               if(this.busy == 0) {
                  Striped64$Cell var33 = new Striped64$Cell(var1);
                  if(this.busy == 0 && this.casBusy()) {
                     boolean var34 = false;

                     try {
                        Striped64$Cell[] var14 = this.cells;
                        int var15;
                        int var16;
                        if(this.cells != null && (var15 = var14.length) > 0 && var14[var16 = var15 - 1 & var5] == null) {
                           var14[var16] = var33;
                           var34 = true;
                        }
                     } finally {
                        this.busy = 0;
                     }

                     if(var34) {
                        break;
                     }
                     continue;
                  }
               }

               var32 = false;
            } else if(!var4) {
               var4 = true;
            } else {
               if(var8.cas(var10 = var8.value, this.fn(var10, var1))) {
                  break;
               }

               if(var9 < NCPU && this.cells == var7) {
                  if(!var32) {
                     var32 = true;
                  } else if(this.busy == 0 && this.casBusy()) {
                     try {
                        if(this.cells == var7) {
                           Striped64$Cell[] var35 = new Striped64$Cell[var9 << 1];

                           for(int var36 = 0; var36 < var9; ++var36) {
                              var35[var36] = var7[var36];
                           }

                           this.cells = var35;
                        }
                     } finally {
                        this.busy = 0;
                     }

                     var32 = false;
                     continue;
                  }
               } else {
                  var32 = false;
               }
            }

            var5 ^= var5 << 13;
            var5 ^= var5 >>> 17;
            var5 ^= var5 << 5;
            var3[0] = var5;
         } else if(this.busy == 0 && this.cells == var7 && this.casBusy()) {
            boolean var12 = false;

            try {
               if(this.cells == var7) {
                  Striped64$Cell[] var13 = new Striped64$Cell[2];
                  var13[var5 & 1] = new Striped64$Cell(var1);
                  this.cells = var13;
                  var12 = true;
               }
            } finally {
               this.busy = 0;
            }

            if(var12) {
               break;
            }
         } else if(this.casBase(var10 = this.base, this.fn(var10, var1))) {
            break;
         }
      }

   }

   final void internalReset(long var1) {
      Striped64$Cell[] var3 = this.cells;
      this.base = var1;
      if(var3 != null) {
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Striped64$Cell var6 = var3[var5];
            if(var6 != null) {
               var6.value = var1;
            }
         }
      }

   }

   private static Unsafe getUnsafe() {
      try {
         return Unsafe.getUnsafe();
      } catch (SecurityException var2) {
         try {
            return (Unsafe)AccessController.doPrivileged(new Striped64$1());
         } catch (PrivilegedActionException var1) {
            throw new RuntimeException("Could not initialize intrinsics", var1.getCause());
         }
      }
   }

   // $FF: synthetic method
   static Unsafe access$000() {
      return getUnsafe();
   }

   static {
      try {
         UNSAFE = getUnsafe();
         Class var0 = Striped64.class;
         baseOffset = UNSAFE.objectFieldOffset(var0.getDeclaredField("base"));
         busyOffset = UNSAFE.objectFieldOffset(var0.getDeclaredField("busy"));
      } catch (Exception var1) {
         throw new Error(var1);
      }
   }
}
