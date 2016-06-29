package com.google.common.primitives;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1;
import com.google.common.primitives.UnsignedLongs;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Comparator;
import sun.misc.Unsafe;

@VisibleForTesting
enum UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator implements Comparator {
   INSTANCE;

   static final boolean BIG_ENDIAN;
   static final Unsafe theUnsafe;
   static final int BYTE_ARRAY_BASE_OFFSET;

   private static Unsafe getUnsafe() {
      try {
         return Unsafe.getUnsafe();
      } catch (SecurityException var2) {
         try {
            return (Unsafe)AccessController.doPrivileged(new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1());
         } catch (PrivilegedActionException var1) {
            throw new RuntimeException("Could not initialize intrinsics", var1.getCause());
         }
      }
   }

   public int compare(byte[] var1, byte[] var2) {
      int var3 = Math.min(var1.length, var2.length);
      int var4 = var3 / 8;

      int var5;
      for(var5 = 0; var5 < var4 * 8; var5 += 8) {
         long var6 = theUnsafe.getLong(var1, (long)BYTE_ARRAY_BASE_OFFSET + (long)var5);
         long var8 = theUnsafe.getLong(var2, (long)BYTE_ARRAY_BASE_OFFSET + (long)var5);
         if(var6 != var8) {
            if(BIG_ENDIAN) {
               return UnsignedLongs.compare(var6, var8);
            }

            int var10 = Long.numberOfTrailingZeros(var6 ^ var8) & -8;
            return (int)((var6 >>> var10 & 255L) - (var8 >>> var10 & 255L));
         }
      }

      for(var5 = var4 * 8; var5 < var3; ++var5) {
         int var11 = UnsignedBytes.compare(var1[var5], var2[var5]);
         if(var11 != 0) {
            return var11;
         }
      }

      return var1.length - var2.length;
   }

   static {
      BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
      theUnsafe = getUnsafe();
      BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
      if(theUnsafe.arrayIndexScale(byte[].class) != 1) {
         throw new AssertionError();
      }
   }
}
