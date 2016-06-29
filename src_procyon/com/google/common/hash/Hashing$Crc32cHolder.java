package com.google.common.hash;

final class Hashing$Crc32cHolder
{
    static final HashFunction CRC_32_C;
    
    static {
        CRC_32_C = new Crc32cHashFunction();
    }
}
