package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$LittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray;
import java.nio.ByteOrder;

@GoogleInternal
final class LittleEndianByteArray {
   private static final LittleEndianByteArray$LittleEndianBytes byteArray;

   static long load64(byte[] var0, int var1) {
      assert var0.length >= var1 + 8;

      return byteArray.getLongLittleEndian(var0, var1);
   }

   static long load64Safely(byte[] var0, int var1, int var2) {
      long var3 = 0L;
      int var5 = Math.min(var2, 8);

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 |= ((long)var0[var1 + var6] & 255L) << var6 * 8;
      }

      return var3;
   }

   static void store64(byte[] var0, int var1, long var2) {
      if($assertionsDisabled || var1 >= 0 && var1 + 8 <= var0.length) {
         byteArray.putLongLittleEndian(var0, var1, var2);
      } else {
         throw new AssertionError();
      }
   }

   static int load32(byte[] var0, int var1) {
      return var0[var1] & 255 | (var0[var1 + 1] & 255) << 8 | (var0[var1 + 2] & 255) << 16 | (var0[var1 + 3] & 255) << 24;
   }

   static boolean usingUnsafe() {
      return byteArray instanceof LittleEndianByteArray$UnsafeByteArray;
   }

   static {
      Object var0;
      try {
         var0 = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)?LittleEndianByteArray$UnsafeByteArray.UNSAFE_LITTLE_ENDIAN:LittleEndianByteArray$UnsafeByteArray.UNSAFE_BIG_ENDIAN;
      } catch (Throwable var2) {
         var0 = LittleEndianByteArray$JavaLittleEndianBytes.INSTANCE;
      }

      byteArray = (LittleEndianByteArray$LittleEndianBytes)var0;
   }
}
