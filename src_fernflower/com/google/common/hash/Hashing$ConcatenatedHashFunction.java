package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing$1;
import java.util.Arrays;
import javax.annotation.Nullable;

final class Hashing$ConcatenatedHashFunction extends AbstractCompositeHashFunction {
   private final int bits;

   private Hashing$ConcatenatedHashFunction(HashFunction... var1) {
      super(var1);
      int var2 = 0;
      HashFunction[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         HashFunction var6 = var3[var5];
         var2 += var6.bits();
         Preconditions.checkArgument(var6.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", new Object[]{Integer.valueOf(var6.bits()), var6});
      }

      this.bits = var2;
   }

   HashCode makeHash(Hasher[] var1) {
      byte[] var2 = new byte[this.bits / 8];
      int var3 = 0;
      Hasher[] var4 = var1;
      int var5 = var1.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Hasher var7 = var4[var6];
         HashCode var8 = var7.hash();
         var3 += var8.writeBytesTo(var2, var3, var8.bits() / 8);
      }

      return HashCode.fromBytesNoCopy(var2);
   }

   public int bits() {
      return this.bits;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Hashing$ConcatenatedHashFunction) {
         Hashing$ConcatenatedHashFunction var2 = (Hashing$ConcatenatedHashFunction)var1;
         return Arrays.equals(this.functions, var2.functions);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Arrays.hashCode(this.functions) * 31 + this.bits;
   }

   // $FF: synthetic method
   Hashing$ConcatenatedHashFunction(HashFunction[] var1, Hashing$1 var2) {
      this(var1);
   }
}
