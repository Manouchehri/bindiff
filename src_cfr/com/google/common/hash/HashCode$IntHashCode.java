/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;

final class HashCode$IntHashCode
extends HashCode
implements Serializable {
    final int hash;
    private static final long serialVersionUID = 0;

    HashCode$IntHashCode(int n2) {
        this.hash = n2;
    }

    @Override
    public int bits() {
        return 32;
    }

    @Override
    public byte[] asBytes() {
        return new byte[]{(byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24)};
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
    void writeBytesToImpl(byte[] arrby, int n2, int n3) {
        int n4 = 0;
        while (n4 < n3) {
            arrby[n2 + n4] = (byte)(this.hash >> n4 * 8);
            ++n4;
        }
    }

    @Override
    boolean equalsSameBits(HashCode hashCode) {
        if (this.hash != hashCode.asInt()) return false;
        return true;
    }
}

