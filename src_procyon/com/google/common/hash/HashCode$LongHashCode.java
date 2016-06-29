package com.google.common.hash;

import java.io.*;

final class HashCode$LongHashCode extends HashCode implements Serializable
{
    final long hash;
    private static final long serialVersionUID = 0L;
    
    HashCode$LongHashCode(final long hash) {
        this.hash = hash;
    }
    
    @Override
    public int bits() {
        return 64;
    }
    
    @Override
    public byte[] asBytes() {
        return new byte[] { (byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24), (byte)(this.hash >> 32), (byte)(this.hash >> 40), (byte)(this.hash >> 48), (byte)(this.hash >> 56) };
    }
    
    @Override
    public int asInt() {
        return (int)this.hash;
    }
    
    @Override
    public long asLong() {
        return this.hash;
    }
    
    @Override
    public long padToLong() {
        return this.hash;
    }
    
    @Override
    void writeBytesToImpl(final byte[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            array[n + i] = (byte)(this.hash >> i * 8);
        }
    }
    
    @Override
    boolean equalsSameBits(final HashCode hashCode) {
        return this.hash == hashCode.asLong();
    }
}
