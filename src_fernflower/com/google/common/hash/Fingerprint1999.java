package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;

@GoogleInternal
final class Fingerprint1999 extends AbstractCompositeHashFunction {
   private final String toString;

   Fingerprint1999(HashFunction var1, HashFunction var2, String var3) {
      super(new HashFunction[]{var1, var2});
      this.toString = (String)Preconditions.checkNotNull(var3);
   }

   public int bits() {
      return 64;
   }

   public String toString() {
      return this.toString;
   }

   HashCode makeHash(Hasher[] var1) {
      return combineFingerprintHalves(var1[0].hash().asInt(), var1[1].hash().asInt());
   }

   @VisibleForTesting
   static HashCode combineFingerprintHalves(int var0, int var1) {
      return var0 == 0 && var1 == 0?HashCode.fromLong(1373487864664336680L):(var0 == 0 && var1 == 1?HashCode.fromLong(1373487864664336681L):HashCode.fromLong((long)var0 << 32 | (long)var1 & 4294967295L));
   }
}
