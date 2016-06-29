package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.Hashing$ChecksumType;

class Hashing$Adler32Holder {
   static final HashFunction ADLER_32;

   static {
      ADLER_32 = Hashing.access$200(Hashing$ChecksumType.ADLER_32, "Hashing.adler32()");
   }
}
