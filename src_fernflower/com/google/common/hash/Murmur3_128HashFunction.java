package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Murmur3_128HashFunction$Murmur3_128Hasher;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Murmur3_128HashFunction extends AbstractStreamingHashFunction implements Serializable {
   private final int seed;
   private static final long serialVersionUID = 0L;

   Murmur3_128HashFunction(int var1) {
      this.seed = var1;
   }

   public int bits() {
      return 128;
   }

   public Hasher newHasher() {
      return new Murmur3_128HashFunction$Murmur3_128Hasher(this.seed);
   }

   public String toString() {
      int var1 = this.seed;
      return (new StringBuilder(32)).append("Hashing.murmur3_128(").append(var1).append(")").toString();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Murmur3_128HashFunction) {
         Murmur3_128HashFunction var2 = (Murmur3_128HashFunction)var1;
         return this.seed == var2.seed;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.getClass().hashCode() ^ this.seed;
   }
}
