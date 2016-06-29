package com.google.common.hash;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.security.*;
import javax.crypto.spec.*;
import com.google.common.base.*;
import java.util.*;

class Hashing$Murmur3_128Holder
{
    static final HashFunction MURMUR3_128;
    static final HashFunction GOOD_FAST_HASH_FUNCTION_128;
    
    static {
        MURMUR3_128 = new Murmur3_128HashFunction(0);
        GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(Hashing.GOOD_FAST_HASH_SEED);
    }
}
