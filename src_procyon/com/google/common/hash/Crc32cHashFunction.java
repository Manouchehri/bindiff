package com.google.common.hash;

final class Crc32cHashFunction extends AbstractStreamingHashFunction
{
    @Override
    public int bits() {
        return 32;
    }
    
    @Override
    public Hasher newHasher() {
        return new Crc32cHashFunction$Crc32cHasher();
    }
    
    @Override
    public String toString() {
        return "Hashing.crc32c()";
    }
}
