/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractHasher;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import java.io.IOException;

final class AbstractNonStreamingHashFunction$BufferingHasher
extends AbstractHasher {
    final AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream stream;
    static final int BOTTOM_BYTE = 255;
    final /* synthetic */ AbstractNonStreamingHashFunction this$0;

    AbstractNonStreamingHashFunction$BufferingHasher(AbstractNonStreamingHashFunction abstractNonStreamingHashFunction, int n2) {
        this.this$0 = abstractNonStreamingHashFunction;
        this.stream = new AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(n2);
    }

    @Override
    public Hasher putByte(byte by2) {
        this.stream.write(by2);
        return this;
    }

    @Override
    public Hasher putBytes(byte[] arrby) {
        try {
            this.stream.write(arrby);
            return this;
        }
        catch (IOException var2_2) {
            throw new RuntimeException(var2_2);
        }
    }

    @Override
    public Hasher putBytes(byte[] arrby, int n2, int n3) {
        this.stream.write(arrby, n2, n3);
        return this;
    }

    @Override
    public Hasher putShort(short s2) {
        this.stream.write(s2 & 255);
        this.stream.write(s2 >>> 8 & 255);
        return this;
    }

    @Override
    public Hasher putInt(int n2) {
        this.stream.write(n2 & 255);
        this.stream.write(n2 >>> 8 & 255);
        this.stream.write(n2 >>> 16 & 255);
        this.stream.write(n2 >>> 24 & 255);
        return this;
    }

    @Override
    public Hasher putLong(long l2) {
        int n2 = 0;
        while (n2 < 64) {
            this.stream.write((byte)(l2 >>> n2 & 255));
            n2 += 8;
        }
        return this;
    }

    @Override
    public Hasher putChar(char c2) {
        this.stream.write(c2 & 255);
        this.stream.write(c2 >>> 8 & 255);
        return this;
    }

    @Override
    public Hasher putObject(Object object, Funnel funnel) {
        funnel.funnel(object, this);
        return this;
    }

    @Override
    public HashCode hash() {
        return this.this$0.hashBytes(this.stream.byteArray(), 0, this.stream.length());
    }
}

