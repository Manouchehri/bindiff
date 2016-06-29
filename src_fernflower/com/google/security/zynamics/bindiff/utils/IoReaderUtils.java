package com.google.security.zynamics.bindiff.utils;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;

public class IoReaderUtils {
   public static synchronized byte[] readByteArray(InputStream var0, int var1) {
      byte[] var2 = new byte[var1];
      int var3 = ByteStreams.read(var0, var2, 0, var1);
      if(var3 < var1) {
         throw new IOException("Unexpected end of file");
      } else {
         return var2;
      }
   }

   public static int readIntegerValue(InputStream var0, int var1) {
      Preconditions.checkArgument(var1 >= 1 && var1 <= 4, "Illegal length (not in range 1 to 4)");
      byte[] var2 = readByteArray(var0, var1);
      int var3 = 0;

      for(int var4 = 0; var4 < var1; ++var4) {
         byte var5 = var2[var4];
         int var6 = var5 & 255;
         var3 |= var6 << var4 * 8;
      }

      return var3;
   }

   public static long readLongValue(InputStream var0, int var1) {
      Preconditions.checkArgument(var1 >= 1 && var1 <= 8, "Illegal length (not in range 1 to 8)");
      byte[] var2 = readByteArray(var0, var1);
      long var3 = 0L;

      for(int var5 = 0; var5 < var1; ++var5) {
         long var6 = (long)var2[var5];
         var6 &= 255L;
         var6 <<= var5 * 8;
         var3 |= var6;
      }

      return var3;
   }

   public static long readUnsignedIntegerValue(InputStream var0, int var1) {
      Preconditions.checkArgument(var1 >= 1 && var1 <= 4, "Illegal length (not in range 1 to 4)");
      return readLongValue(var0, var1);
   }

   public static long skip(InputStream var0, int var1) {
      if(var1 == 0) {
         return 0L;
      } else {
         long var2 = var0.skip((long)var1);
         if(var2 != (long)var1) {
            var2 += var0.skip((long)var1 - var2);
         }

         return var2;
      }
   }
}
