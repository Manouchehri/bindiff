package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.Crc8HashFunction;
import com.google.common.hash.HashFunction;

@GoogleInternal
final class Hashing$Crc8Holder {
   static final HashFunction CRC_8 = new Crc8HashFunction();
}
