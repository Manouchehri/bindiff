package com.google.common.hash;

import com.google.common.annotations.*;

@GoogleInternal
final class Hashing$Crc8Holder
{
    static final HashFunction CRC_8;
    
    static {
        CRC_8 = new Crc8HashFunction();
    }
}
