/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHasher;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class AbstractByteHasher
extends AbstractHasher {
    private final ByteBuffer scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    AbstractByteHasher() {
    }

    protected abstract void update(byte var1);

    protected void update(byte[] arrby) {
        this.update(arrby, 0, arrby.length);
    }

    protected void update(byte[] arrby, int n2, int n3) {
        int n4 = n2;
        while (n4 < n2 + n3) {
            this.update(arrby[n4]);
            ++n4;
        }
    }

    @Override
    public Hasher putByte(byte by2) {
        this.update(by2);
        return this;
    }

    @Override
    public Hasher putBytes(byte[] arrby) {
        Preconditions.checkNotNull(arrby);
        this.update(arrby);
        return this;
    }

    @Override
    public Hasher putBytes(byte[] arrby, int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        this.update(arrby, n2, n3);
        return this;
    }

    private Hasher update(int n2) {
        try {
            this.update(this.scratch.array(), 0, n2);
            return this;
        }
        finally {
            this.scratch.clear();
        }
    }

    @Override
    public Hasher putShort(short s2) {
        this.scratch.putShort(s2);
        return this.update(2);
    }

    @Override
    public Hasher putInt(int n2) {
        this.scratch.putInt(n2);
        return this.update(4);
    }

    @Override
    public Hasher putLong(long l2) {
        this.scratch.putLong(l2);
        return this.update(8);
    }

    @Override
    public Hasher putChar(char c2) {
        this.scratch.putChar(c2);
        return this.update(2);
    }

    @Override
    public Hasher putObject(Object object, Funnel funnel) {
        funnel.funnel(object, this);
        return this;
    }
}

