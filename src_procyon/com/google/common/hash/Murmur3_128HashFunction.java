package com.google.common.hash;

import java.io.*;
import javax.annotation.*;

final class Murmur3_128HashFunction extends AbstractStreamingHashFunction implements Serializable
{
    private final int seed;
    private static final long serialVersionUID = 0L;
    
    Murmur3_128HashFunction(final int seed) {
        this.seed = seed;
    }
    
    @Override
    public int bits() {
        return 128;
    }
    
    @Override
    public Hasher newHasher() {
        return new Murmur3_128HashFunction$Murmur3_128Hasher(this.seed);
    }
    
    @Override
    public String toString() {
        return new StringBuilder(32).append("Hashing.murmur3_128(").append(this.seed).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Murmur3_128HashFunction && this.seed == ((Murmur3_128HashFunction)o).seed;
    }
    
    @Override
    public int hashCode() {
        return this.getClass().hashCode() ^ this.seed;
    }
}
