package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.Nullable;

@GoogleInternal
final class Murmur2_64AHashFunction extends AbstractNonStreamingHashFunction {
   private static final long M = -4132994306676758123L;
   private static final int R = 47;
   private final long seed;

   Murmur2_64AHashFunction(long var1) {
      this.seed = var1;
   }

   public HashCode hashBytes(byte[] var1, int var2, int var3) {
      ByteBuffer var4 = ByteBuffer.wrap(var1, var2, var3).order(ByteOrder.LITTLE_ENDIAN);

      long var5;
      for(var5 = this.seed ^ (long)var4.remaining() * -4132994306676758123L; var4.remaining() >= 8; var5 *= -4132994306676758123L) {
         long var7 = var4.getLong();
         var7 *= -4132994306676758123L;
         var7 ^= var7 >>> 47;
         var7 *= -4132994306676758123L;
         var5 ^= var7;
      }

      if(var4.hasRemaining()) {
         for(int var9 = 0; var4.hasRemaining(); var9 += 8) {
            var5 ^= ((long)var4.get() & 255L) << var9;
         }

         var5 *= -4132994306676758123L;
      }

      var5 ^= var5 >>> 47;
      var5 *= -4132994306676758123L;
      var5 ^= var5 >>> 47;
      return HashCode.fromLong(var5);
   }

   public int bits() {
      return 64;
   }

   public String toString() {
      long var1 = this.seed;
      return (new StringBuilder(46)).append("LegacyHashing.murmur2_64(").append(var1).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Murmur2_64AHashFunction) {
         Murmur2_64AHashFunction var2 = (Murmur2_64AHashFunction)var1;
         return this.seed == var2.seed;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return (int)(this.seed ^ (long)this.getClass().hashCode());
   }
}
