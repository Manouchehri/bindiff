/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import java.io.Serializable;

final class HashCode$BytesHashCode
extends HashCode
implements Serializable {
    final byte[] bytes;
    private static final long serialVersionUID = 0;

    HashCode$BytesHashCode(byte[] arrby) {
        this.bytes = (byte[])Preconditions.checkNotNull(arrby);
    }

    @Override
    public int bits() {
        return this.bytes.length * 8;
    }

    @Override
    public byte[] asBytes() {
        return (byte[])this.bytes.clone();
    }

    @Override
    public int asInt() {
        Preconditions.checkState(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
        return this.bytes[0] & 255 | (this.bytes[1] & 255) << 8 | (this.bytes[2] & 255) << 16 | (this.bytes[3] & 255) << 24;
    }

    @Override
    public long asLong() {
        Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
        return this.padToLong();
    }

    @Override
    public long padToLong() {
        long l2 = this.bytes[0] & 255;
        int n2 = 1;
        while (n2 < Math.min(this.bytes.length, 8)) {
            l2 |= ((long)this.bytes[n2] & 255) << n2 * 8;
            ++n2;
        }
        return l2;
    }

    @Override
    void writeBytesToImpl(byte[] arrby, int n2, int n3) {
        System.arraycopy(this.bytes, 0, arrby, n2, n3);
    }

    @Override
    byte[] getBytesInternal() {
        return this.bytes;
    }

    @Override
    boolean equalsSameBits(HashCode hashCode) {
        if (this.bytes.length != hashCode.getBytesInternal().length) {
            return false;
        }
        boolean bl2 = true;
        int n2 = 0;
        while (n2 < this.bytes.length) {
            bl2 &= this.bytes[n2] == hashCode.getBytesInternal()[n2];
            ++n2;
        }
        return bl2;
    }
}

