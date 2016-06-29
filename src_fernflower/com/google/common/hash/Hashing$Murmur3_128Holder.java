package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.Murmur3_128HashFunction;

class Hashing$Murmur3_128Holder {
   static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
   static final HashFunction GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(Hashing.access$100());
}
