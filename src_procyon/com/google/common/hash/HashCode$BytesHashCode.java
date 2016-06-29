package com.google.common.hash;

import java.io.*;
import com.google.common.base.*;

final class HashCode$BytesHashCode extends HashCode implements Serializable
{
    final byte[] bytes;
    private static final long serialVersionUID = 0L;
    
    HashCode$BytesHashCode(final byte[] array) {
        this.bytes = (byte[])Preconditions.checkNotNull(array);
    }
    
    @Override
    public int bits() {
        return this.bytes.length * 8;
    }
    
    @Override
    public byte[] asBytes() {
        return this.bytes.clone();
    }
    
    @Override
    public int asInt() {
        Preconditions.checkState(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
        return (this.bytes[0] & 0xFF) | (this.bytes[1] & 0xFF) << 8 | (this.bytes[2] & 0xFF) << 16 | (this.bytes[3] & 0xFF) << 24;
    }
    
    @Override
    public long asLong() {
        Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
        return this.padToLong();
    }
    
    @Override
    public long padToLong() {
        long n = this.bytes[0] & 0xFF;
        for (int i = 1; i < Math.min(this.bytes.length, 8); ++i) {
            n |= (this.bytes[i] & 0xFFL) << i * 8;
        }
        return n;
    }
    
    @Override
    void writeBytesToImpl(final byte[] array, final int n, final int n2) {
        System.arraycopy(this.bytes, 0, array, n, n2);
    }
    
    @Override
    byte[] getBytesInternal() {
        return this.bytes;
    }
    
    @Override
    boolean equalsSameBits(final HashCode hashCode) {
        if (this.bytes.length != hashCode.getBytesInternal().length) {
            return false;
        }
        boolean b = true;
        for (int i = 0; i < this.bytes.length; ++i) {
            b &= (this.bytes[i] == hashCode.getBytesInternal()[i]);
        }
        return b;
    }
}
