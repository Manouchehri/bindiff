package com.google.common.hash;

import java.io.*;
import com.google.common.primitives.*;

final class HashCode$IntHashCode extends HashCode implements Serializable
{
    final int hash;
    private static final long serialVersionUID = 0L;
    
    HashCode$IntHashCode(final int hash) {
        this.hash = hash;
    }
    
    @Override
    public int bits() {
        return 32;
    }
    
    @Override
    public byte[] asBytes() {
        return new byte[] { (byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24) };
    }
    
    @Override
    public int asInt() {
        return this.hash;
    }
    
    @Override
    public long asLong() {
        throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
    }
    
    @Override
    public long padToLong() {
        return UnsignedInts.toLong(this.hash);
    }
    
    @Override
    void writeBytesToImpl(final byte[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            array[n + i] = (byte)(this.hash >> i * 8);
        }
    }
    
    @Override
    boolean equalsSameBits(final HashCode hashCode) {
        return this.hash == hashCode.asInt();
    }
}
