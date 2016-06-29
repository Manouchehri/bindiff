package com.google.common.hash;

import com.google.common.annotations.*;

@GoogleInternal
class Hashing$CityHash128Holder
{
    static final HashFunction CITY_HASH_128;
    
    static {
        CITY_HASH_128 = new CityHash128HashFunction();
    }
}
