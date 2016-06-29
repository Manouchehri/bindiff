package com.google.common.hash;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.security.*;
import javax.crypto.spec.*;
import com.google.common.base.*;
import java.util.*;

class Hashing$Murmur3_32Holder
{
    static final HashFunction MURMUR3_32;
    static final HashFunction GOOD_FAST_HASH_FUNCTION_32;
    
    static {
        MURMUR3_32 = new Murmur3_32HashFunction(0);
        GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(Hashing.GOOD_FAST_HASH_SEED);
    }
}
