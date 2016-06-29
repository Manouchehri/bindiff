package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.Fingerprint1999;
import com.google.common.hash.GoogleLegacy32HashFunction;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;
import com.google.common.hash.GoogleLegacy64HashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.hash.Murmur2_64AHashFunction;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
public final class LegacyHashing {
   private static final int FINGERPRINT_SEED = 102072;
   static final int SEED32 = 314159265;
   static final int CONSTANT32 = -1640531527;
   static final long SEED64 = 3141592653589793238L;
   static final long CONSTANT64 = -2266404186210603134L;
   private static final HashFunction GOOGLE_LEGACY_32;
   private static final HashFunction GOOGLE_LEGACY_64;
   private static final HashFunction FPRINT_96;
   private static final HashFunction FINGERPRINT_1999;
   private static final HashFunction BROKEN_FINGERPRINT_1999;
   private static final HashFunction MURMUR_HASH_2_64;
   private static final char[] hexDigits;

   public static HashFunction googleHash32() {
      return GOOGLE_LEGACY_32;
   }

   public static HashFunction googleHash32(int var0) {
      return new GoogleLegacy32HashFunction(var0, GoogleLegacy32HashFunction$FingerprintStrategy.WORKING);
   }

   public static HashFunction googleHash64() {
      return GOOGLE_LEGACY_64;
   }

   public static HashFunction googleHash64(long var0) {
      return new GoogleLegacy64HashFunction(var0);
   }

   public static HashFunction fprint96() {
      return FPRINT_96;
   }

   public static HashFunction fingerprint1999() {
      return FINGERPRINT_1999;
   }

   public static HashFunction brokenFingerprint1999() {
      return BROKEN_FINGERPRINT_1999;
   }

   public static HashCode mix32(int var0) {
      return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(var0, -1640531527, 314159265));
   }

   public static HashCode mix32(int var0, int var1) {
      return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(var0, -1640531527, var1));
   }

   public static HashCode mix64(long var0) {
      return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(var0, -2266404186210603134L, 3141592653589793238L));
   }

   public static HashCode mix64(long var0, long var2) {
      return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(var0, -2266404186210603134L, var2));
   }

   public static HashFunction murmur2_64() {
      return MURMUR_HASH_2_64;
   }

   public static HashFunction murmur2_64(long var0) {
      return new Murmur2_64AHashFunction(var0);
   }

   public static HashCode stringHash64(CharSequence var0) {
      long var1 = -2266404186210603134L;
      long var3 = var1;
      long var5 = 3141592653589793238L;
      int var7 = 0;

      int var8;
      for(var8 = var0.length(); var8 >= 12; var7 += 12) {
         var1 += word64CharAt(var0, var7);
         var3 += word64CharAt(var0, var7 + 4);
         var5 += word64CharAt(var0, var7 + 8);
         var1 -= var3;
         var1 -= var5;
         var1 ^= var5 >>> 43;
         var3 -= var5;
         var3 -= var1;
         var3 ^= var1 << 9;
         var5 -= var1;
         var5 -= var3;
         var5 ^= var3 >>> 8;
         var1 -= var3;
         var1 -= var5;
         var1 ^= var5 >>> 38;
         var3 -= var5;
         var3 -= var1;
         var3 ^= var1 << 23;
         var5 -= var1;
         var5 -= var3;
         var5 ^= var3 >>> 5;
         var1 -= var3;
         var1 -= var5;
         var1 ^= var5 >>> 35;
         var3 -= var5;
         var3 -= var1;
         var3 ^= var1 << 49;
         var5 -= var1;
         var5 -= var3;
         var5 ^= var3 >>> 11;
         var1 -= var3;
         var1 -= var5;
         var1 ^= var5 >>> 12;
         var3 -= var5;
         var3 -= var1;
         var3 ^= var1 << 18;
         var5 -= var1;
         var5 -= var3;
         var5 ^= var3 >>> 22;
         var8 -= 12;
      }

      var5 += (long)var0.length();
      switch(var8) {
      case 0:
         break;
      case 3:
         var1 += ((long)var0.charAt(var7 + 2) & 65535L) << 32;
      case 2:
         var1 += ((long)var0.charAt(var7 + 1) & 65535L) << 16;
      case 1:
         var1 += (long)var0.charAt(var7) & 65535L;
         break;
      case 7:
         var3 += ((long)var0.charAt(var7 + 6) & 65535L) << 32;
      case 6:
         var3 += ((long)var0.charAt(var7 + 5) & 65535L) << 16;
      case 5:
         var3 += (long)var0.charAt(var7 + 4) & 65535L;
      case 4:
         var1 += word64CharAt(var0, var7);
         break;
      case 11:
         var5 += ((long)var0.charAt(var7 + 10) & 65535L) << 40;
      case 10:
         var5 += ((long)var0.charAt(var7 + 9) & 65535L) << 24;
      case 9:
         var5 += ((long)var0.charAt(var7 + 8) & 65535L) << 8;
      case 8:
         var3 += word64CharAt(var0, var7 + 4);
         var1 += word64CharAt(var0, var7);
         break;
      default:
         throw new AssertionError();
      }

      return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(var1, var3, var5));
   }

   private static long word64CharAt(CharSequence var0, int var1) {
      return ((long)var0.charAt(var1) & 65535L) + (((long)var0.charAt(var1 + 1) & 65535L) << 16) + (((long)var0.charAt(var1 + 2) & 65535L) << 32) + (((long)var0.charAt(var1 + 3) & 65535L) << 48);
   }

   public static String toSeparatedString(HashCode var0) {
      Preconditions.checkArgument(var0.bits() % 32 == 0, "HashCode must have a multiple of 32 bits, but had %s bits.", new Object[]{Integer.valueOf(var0.bits())});
      byte[] var1 = var0.asBytes();
      StringBuilder var2 = new StringBuilder(2 * var1.length + var1.length / 4);

      for(int var3 = 0; var3 < var1.length; var3 += 4) {
         for(int var4 = 0; var4 < 4; ++var4) {
            byte var5 = var1[var3 + var4];
            var2.append(hexDigits[var5 >> 4 & 15]).append(hexDigits[var5 & 15]);
         }

         var2.append('_');
      }

      return var2.deleteCharAt(var2.length() - 1).toString();
   }

   public static String toBrokenString(HashCode var0) {
      byte[] var1 = var0.asBytes();
      char[] var2 = new char[var1.length];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         var2[var3] = (char)(var1[var3] & 255);
      }

      return new String(var2);
   }

   static {
      GOOGLE_LEGACY_32 = new GoogleLegacy32HashFunction(314159265, GoogleLegacy32HashFunction$FingerprintStrategy.WORKING);
      GOOGLE_LEGACY_64 = new GoogleLegacy64HashFunction(3141592653589793238L);
      FPRINT_96 = new MessageDigestHashFunction("SHA-1", 12, "LegacyHashing.fprint96()");
      FINGERPRINT_1999 = new Fingerprint1999(googleHash32(0), googleHash32(102072), "LegacyHashing.fingerprint1999()");
      BROKEN_FINGERPRINT_1999 = new Fingerprint1999(new GoogleLegacy32HashFunction(0, GoogleLegacy32HashFunction$FingerprintStrategy.BROKEN), new GoogleLegacy32HashFunction(102072, GoogleLegacy32HashFunction$FingerprintStrategy.BROKEN), "LegacyHashing.brokenFingerprint1999()");
      MURMUR_HASH_2_64 = murmur2_64(0L);
      hexDigits = "0123456789ABCDEF".toCharArray();
   }
}
