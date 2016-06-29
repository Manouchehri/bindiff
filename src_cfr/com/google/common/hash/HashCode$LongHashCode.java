/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashCode;
import java.io.Serializable;

final class HashCode$LongHashCode
extends HashCode
implements Serializable {
    final long hash;
    private static final long serialVersionUID = 0;

    HashCode$LongHashCode(long l2) {
        this.hash = l2;
    }

    @Override
    public int bits() {
        return 64;
    }

    @Override
    public byte[] asBytes() {
        return new byte[]{(byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24), (byte)(this.hash >> 32), (byte)(this.hash >> 40), (byte)(this.hash >> 48), (byte)(this.hash >> 56)};
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
    void writeBytesToImpl(byte[] arrby, int n2, int n3) {
        int n4 = 0;
        while (n4 < n3) {
            arrby[n2 + n4] = (byte)(this.hash >> n4 * 8);
            ++n4;
        }
    }

    @Override
    boolean equalsSameBits(HashCode hashCode) {
        if (this.hash != hashCode.asLong()) return false;
        return true;
    }
}

