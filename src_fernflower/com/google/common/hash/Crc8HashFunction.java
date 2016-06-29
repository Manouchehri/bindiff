package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Crc8HashFunction$1;
import com.google.common.hash.Crc8HashFunction$Crc8Hasher;
import com.google.common.hash.Hasher;

@GoogleInternal
final class Crc8HashFunction extends AbstractStreamingHashFunction {
   public int bits() {
      return 8;
   }

   public Hasher newHasher() {
      return new Crc8HashFunction$Crc8Hasher((Crc8HashFunction$1)null);
   }

   public String toString() {
      return "Hashing.crc8()";
   }
}
