package com.google.security.zynamics.zylib.general;

import java.util.Iterator;
import java.util.List;

public final class ByteHelpers {
   public static byte[] combine(List var0) {
      int var1 = 0;

      byte[] var3;
      for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 += var3.length) {
         var3 = (byte[])var2.next();
      }

      byte[] var6 = new byte[var1];
      int var7 = 0;

      byte[] var5;
      for(Iterator var4 = var0.iterator(); var4.hasNext(); var7 += var5.length) {
         var5 = (byte[])var4.next();
         System.arraycopy(var5, 0, var6, var7, var5.length);
      }

      return var6;
   }

   public static long readDwordBigEndian(byte[] var0, int var1) {
      return ((long)var0[var1 + 0] & 255L) * 256L * 256L * 256L + ((long)var0[var1 + 1] & 255L) * 256L * 256L + ((long)var0[var1 + 2] & 255L) * 256L + ((long)var0[var1 + 3] & 255L);
   }

   public static long readDwordLittleEndian(byte[] var0, int var1) {
      return ((long)var0[var1 + 3] & 255L) * 256L * 256L * 256L + ((long)var0[var1 + 2] & 255L) * 256L * 256L + ((long)var0[var1 + 1] & 255L) * 256L + ((long)var0[var1 + 0] & 255L);
   }

   public static long readQwordBigEndian(byte[] var0, int var1) {
      return ((long)var0[var1 + 0] & 255L) * 256L * 256L * 256L * 256L * 256L * 256L * 256L + ((long)var0[var1 + 1] & 255L) * 256L * 256L * 256L * 256L * 256L * 256L + ((long)var0[var1 + 2] & 255L) * 256L * 256L * 256L * 256L * 256L + ((long)var0[var1 + 3] & 255L) * 256L * 256L * 256L * 256L + ((long)var0[var1 + 4] & 255L) * 256L * 256L * 256L + ((long)var0[var1 + 5] & 255L) * 256L * 256L + ((long)var0[var1 + 6] & 255L) * 256L + ((long)var0[var1 + 7] & 255L);
   }

   public static long readQwordLittleEndian(byte[] var0, int var1) {
      return ((long)var0[var1 + 7] & 255L) * 256L * 256L * 256L * 256L * 256L * 256L * 256L + ((long)var0[var1 + 6] & 255L) * 256L * 256L * 256L * 256L * 256L * 256L + ((long)var0[var1 + 5] & 255L) * 256L * 256L * 256L * 256L * 256L + ((long)var0[var1 + 4] & 255L) * 256L * 256L * 256L * 256L + ((long)var0[var1 + 3] & 255L) * 256L * 256L * 256L + ((long)var0[var1 + 2] & 255L) * 256L * 256L + ((long)var0[var1 + 1] & 255L) * 256L + ((long)var0[var1 + 0] & 255L);
   }

   public static long readWordBigEndian(byte[] var0, int var1) {
      return ((long)var0[var1 + 0] & 255L) * 256L + ((long)var0[var1 + 1] & 255L);
   }

   public static long readWordLittleEndian(byte[] var0, int var1) {
      return ((long)var0[var1 + 1] & 255L) * 256L + ((long)var0[var1 + 0] & 255L);
   }

   public static byte[] toArray(List var0) {
      byte[] var1 = new byte[var0.size()];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = ((Byte)var0.get(var2)).byteValue();
      }

      return var1;
   }

   public static byte[] toBigEndianDword(long var0) {
      return new byte[]{(byte)((int)((var0 & 4278190080L) >>> 24)), (byte)((int)((var0 & 16711680L) >>> 16)), (byte)((int)((var0 & 65280L) >>> 8)), (byte)((int)(var0 & 255L))};
   }

   public static byte[] toBigEndianWord(long var0) {
      return new byte[]{(byte)((int)((var0 & 65280L) >>> 8)), (byte)((int)(var0 & 255L))};
   }

   public static byte[] toLittleEndianDword(long var0) {
      return new byte[]{(byte)((int)(var0 & 255L)), (byte)((int)((var0 & 65280L) >>> 8)), (byte)((int)((var0 & 16711680L) >>> 16)), (byte)((int)((var0 & 4278190080L) >>> 24))};
   }

   public static byte[] toLittleEndianWord(long var0) {
      return new byte[]{(byte)((int)(var0 & 255L)), (byte)((int)((var0 & 65280L) >>> 8))};
   }
}
