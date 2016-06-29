package com.google.common.hash;

import com.google.common.annotations.*;

@GoogleInternal
final class Crc8HashFunction extends AbstractStreamingHashFunction
{
    @Override
    public int bits() {
        return 8;
    }
    
    @Override
    public Hasher newHasher() {
        return new Crc8HashFunction$Crc8Hasher(null);
    }
    
    @Override
    public String toString() {
        return "Hashing.crc8()";
    }
}
