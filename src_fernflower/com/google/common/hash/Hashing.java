package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.ChecksumHashFunction;
import com.google.common.hash.CityHash128HashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing$1;
import com.google.common.hash.Hashing$Adler32Holder;
import com.google.common.hash.Hashing$ChecksumType;
import com.google.common.hash.Hashing$CityHash128Holder;
import com.google.common.hash.Hashing$ConcatenatedHashFunction;
import com.google.common.hash.Hashing$Crc32Holder;
import com.google.common.hash.Hashing$Crc32cHolder;
import com.google.common.hash.Hashing$Crc8Holder;
import com.google.common.hash.Hashing$Fingerprint2011Holder;
import com.google.common.hash.Hashing$LinearCongruentialGenerator;
import com.google.common.hash.Hashing$Md5Holder;
import com.google.common.hash.Hashing$Murmur3_128Holder;
import com.google.common.hash.Hashing$Murmur3_32Holder;
import com.google.common.hash.Hashing$Sha1Holder;
import com.google.common.hash.Hashing$Sha256Holder;
import com.google.common.hash.Hashing$Sha384Holder;
import com.google.common.hash.Hashing$Sha512Holder;
import com.google.common.hash.Hashing$SipHash24Holder;
import com.google.common.hash.MacHashFunction;
import com.google.common.hash.Murmur3_128HashFunction;
import com.google.common.hash.Murmur3_32HashFunction;
import com.google.common.hash.SipHashFunction;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.crypto.spec.SecretKeySpec;

@CheckReturnValue
@Beta
public final class Hashing {
   private static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
   @GoogleInternal
   private static final long COMBINE_ORDERED_2011_MUL1 = -4132994306676758123L;
   @GoogleInternal
   private static final long COMBINE_ORDERED_2011_MUL2 = 155523078386399043L;

   public static HashFunction goodFastHash(int var0) {
      int var1 = checkPositiveAndMakeMultipleOf32(var0);
      if(var1 == 32) {
         return Hashing$Murmur3_32Holder.GOOD_FAST_HASH_FUNCTION_32;
      } else if(var1 <= 128) {
         return Hashing$Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
      } else {
         int var2 = (var1 + 127) / 128;
         HashFunction[] var3 = new HashFunction[var2];
         var3[0] = Hashing$Murmur3_128Holder.GOOD_FAST_HASH_FUNCTION_128;
         int var4 = GOOD_FAST_HASH_SEED;

         for(int var5 = 1; var5 < var2; ++var5) {
            var4 += 1500450271;
            var3[var5] = murmur3_128(var4);
         }

         return new Hashing$ConcatenatedHashFunction(var3, (Hashing$1)null);
      }
   }

   public static HashFunction murmur3_32(int var0) {
      return new Murmur3_32HashFunction(var0);
   }

   public static HashFunction murmur3_32() {
      return Hashing$Murmur3_32Holder.MURMUR3_32;
   }

   public static HashFunction murmur3_128(int var0) {
      return new Murmur3_128HashFunction(var0);
   }

   public static HashFunction murmur3_128() {
      return Hashing$Murmur3_128Holder.MURMUR3_128;
   }

   public static HashFunction sipHash24() {
      return Hashing$SipHash24Holder.SIP_HASH_24;
   }

   public static HashFunction sipHash24(long var0, long var2) {
      return new SipHashFunction(2, 4, var0, var2);
   }

   public static HashFunction md5() {
      return Hashing$Md5Holder.MD5;
   }

   public static HashFunction sha1() {
      return Hashing$Sha1Holder.SHA_1;
   }

   public static HashFunction sha256() {
      return Hashing$Sha256Holder.SHA_256;
   }

   public static HashFunction sha384() {
      return Hashing$Sha384Holder.SHA_384;
   }

   public static HashFunction sha512() {
      return Hashing$Sha512Holder.SHA_512;
   }

   @GoogleInternal
   public static HashFunction hmacMd5(Key var0) {
      return new MacHashFunction("HmacMD5", var0, hmacToString("hmacMd5", var0));
   }

   @GoogleInternal
   public static HashFunction hmacMd5(byte[] var0) {
      return hmacMd5((Key)(new SecretKeySpec((byte[])Preconditions.checkNotNull(var0), "HmacMD5")));
   }

   @GoogleInternal
   public static HashFunction hmacSha1(Key var0) {
      return new MacHashFunction("HmacSHA1", var0, hmacToString("hmacSha1", var0));
   }

   @GoogleInternal
   public static HashFunction hmacSha1(byte[] var0) {
      return hmacSha1((Key)(new SecretKeySpec((byte[])Preconditions.checkNotNull(var0), "HmacSHA1")));
   }

   @GoogleInternal
   public static HashFunction hmacSha256(Key var0) {
      return new MacHashFunction("HmacSHA256", var0, hmacToString("hmacSha256", var0));
   }

   @GoogleInternal
   public static HashFunction hmacSha256(byte[] var0) {
      return hmacSha256((Key)(new SecretKeySpec((byte[])Preconditions.checkNotNull(var0), "HmacSHA256")));
   }

   @GoogleInternal
   public static HashFunction hmacSha512(Key var0) {
      return new MacHashFunction("HmacSHA512", var0, hmacToString("hmacSha512", var0));
   }

   @GoogleInternal
   public static HashFunction hmacSha512(byte[] var0) {
      return hmacSha512((Key)(new SecretKeySpec((byte[])Preconditions.checkNotNull(var0), "HmacSHA512")));
   }

   @GoogleInternal
   private static String hmacToString(String var0, Key var1) {
      return String.format("Hashing.%s(Key[algorithm=%s, format=%s])", new Object[]{var0, var1.getAlgorithm(), var1.getFormat()});
   }

   @GoogleInternal
   public static HashFunction crc8() {
      return Hashing$Crc8Holder.CRC_8;
   }

   public static HashFunction crc32c() {
      return Hashing$Crc32cHolder.CRC_32_C;
   }

   public static HashFunction crc32() {
      return Hashing$Crc32Holder.CRC_32;
   }

   public static HashFunction adler32() {
      return Hashing$Adler32Holder.ADLER_32;
   }

   private static HashFunction checksumHashFunction(Hashing$ChecksumType var0, String var1) {
      return new ChecksumHashFunction(var0, Hashing$ChecksumType.access$300(var0), var1);
   }

   @GoogleInternal
   public static HashFunction fingerprint2011() {
      return Hashing$Fingerprint2011Holder.FINGERPRINT_2011;
   }

   @GoogleInternal
   public static HashFunction cityHash128() {
      return Hashing$CityHash128Holder.CITY_HASH_128;
   }

   @GoogleInternal
   public static HashFunction cityHash128(long var0, long var2) {
      return new CityHash128HashFunction(var0, var2);
   }

   public static int consistentHash(HashCode var0, int var1) {
      return consistentHash(var0.padToLong(), var1);
   }

   public static int consistentHash(long var0, int var2) {
      Preconditions.checkArgument(var2 > 0, "buckets must be positive: %s", new Object[]{Integer.valueOf(var2)});
      Hashing$LinearCongruentialGenerator var3 = new Hashing$LinearCongruentialGenerator(var0);
      int var4 = 0;

      while(true) {
         int var5 = (int)((double)(var4 + 1) / var3.nextDouble());
         if(var5 < 0 || var5 >= var2) {
            return var4;
         }

         var4 = var5;
      }
   }

   @GoogleInternal
   public static int weightedConsistentHash(HashCode var0, double[] var1) {
      return weightedConsistentHash(var0.padToLong(), var1);
   }

   @GoogleInternal
   public static int weightedConsistentHash(long var0, double[] var2) {
      Preconditions.checkArgument(var2.length > 0, "bucketWeights must not be empty.");
      Hashing$LinearCongruentialGenerator var3 = new Hashing$LinearCongruentialGenerator(var0);
      double var4 = Double.NEGATIVE_INFINITY;
      int var6 = -1;

      for(int var7 = 0; var7 < var2.length; ++var7) {
         double var8 = var2[var7];
         double var10 = var3.nextDouble();
         Preconditions.checkArgument(var8 >= 0.0D, "Weights must be non-negative. index=%s", new Object[]{Integer.valueOf(var7)});
         if(var8 != 0.0D) {
            double var12 = Math.log(var10) / var8;
            if(var12 > var4) {
               var6 = var7;
               var4 = var12;
            }
         }
      }

      Preconditions.checkArgument(var6 >= 0, "There must be at least one positive weight.");
      return var6;
   }

   public static HashCode combineOrdered(Iterable var0) {
      Iterator var1 = var0.iterator();
      Preconditions.checkArgument(var1.hasNext(), "Must be at least 1 hash code to combine.");
      int var2 = ((HashCode)var1.next()).bits();
      byte[] var3 = new byte[var2 / 8];
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         HashCode var5 = (HashCode)var4.next();
         byte[] var6 = var5.asBytes();
         Preconditions.checkArgument(var6.length == var3.length, "All hashcodes must have the same bit length.");

         for(int var7 = 0; var7 < var6.length; ++var7) {
            var3[var7] = (byte)(var3[var7] * 37 ^ var6[var7]);
         }
      }

      return HashCode.fromBytesNoCopy(var3);
   }

   public static HashCode combineUnordered(Iterable var0) {
      Iterator var1 = var0.iterator();
      Preconditions.checkArgument(var1.hasNext(), "Must be at least 1 hash code to combine.");
      byte[] var2 = new byte[((HashCode)var1.next()).bits() / 8];
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         HashCode var4 = (HashCode)var3.next();
         byte[] var5 = var4.asBytes();
         Preconditions.checkArgument(var5.length == var2.length, "All hashcodes must have the same bit length.");

         for(int var6 = 0; var6 < var5.length; ++var6) {
            var2[var6] += var5[var6];
         }
      }

      return HashCode.fromBytesNoCopy(var2);
   }

   static int checkPositiveAndMakeMultipleOf32(int var0) {
      Preconditions.checkArgument(var0 > 0, "Number of bits must be positive");
      return var0 + 31 & -32;
   }

   public static HashFunction concatenating(HashFunction var0, HashFunction var1, HashFunction... var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var0);
      var3.add(var1);
      HashFunction[] var4 = var2;
      int var5 = var2.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         HashFunction var7 = var4[var6];
         var3.add(var7);
      }

      return new Hashing$ConcatenatedHashFunction((HashFunction[])var3.toArray(new HashFunction[0]), (Hashing$1)null);
   }

   public static HashFunction concatenating(Iterable var0) {
      Preconditions.checkNotNull(var0);
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         HashFunction var3 = (HashFunction)var2.next();
         var1.add(var3);
      }

      Preconditions.checkArgument(var1.size() > 0, "number of hash functions (%s) must be > 0", new Object[]{Integer.valueOf(var1.size())});
      return new Hashing$ConcatenatedHashFunction((HashFunction[])var1.toArray(new HashFunction[0]), (Hashing$1)null);
   }

   @GoogleInternal
   public static HashCode combineOrdered2011(HashCode var0, HashCode var1) {
      Preconditions.checkArgument(var0.bits() >= 64, "fp1 must have at least 64 bits, but was only %s", new Object[]{Integer.valueOf(var0.bits())});
      Preconditions.checkArgument(var1.bits() >= 64, "fp2 must have at least 64 bits, but was only %s", new Object[]{Integer.valueOf(var1.bits())});
      long var2 = var0.asLong() * -4132994306676758123L + var1.asLong() * 155523078386399043L;
      return HashCode.fromLong(var2 + (~var2 >>> 47));
   }

   // $FF: synthetic method
   static int access$100() {
      return GOOD_FAST_HASH_SEED;
   }

   // $FF: synthetic method
   static HashFunction access$200(Hashing$ChecksumType var0, String var1) {
      return checksumHashFunction(var0, var1);
   }
}
