package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.Murmur3_32HashFunction;

class Hashing$Murmur3_32Holder {
   static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
   static final HashFunction GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(Hashing.access$100());
}
