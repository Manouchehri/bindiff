/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

final class AbstractMessageLite$Builder$LimitedInputStream
extends FilterInputStream {
    private int limit;

    AbstractMessageLite$Builder$LimitedInputStream(InputStream inputStream, int n2) {
        super(inputStream);
        this.limit = n2;
    }

    @Override
    public int available() {
        return Math.min(super.available(), this.limit);
    }

    @Override
    public int read() {
        if (this.limit <= 0) {
            return -1;
        }
        int n2 = super.read();
        if (n2 < 0) return n2;
        --this.limit;
        return n2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (this.limit <= 0) {
            return -1;
        }
        int n4 = super.read(arrby, n2, n3 = Math.min(n3, this.limit));
        if (n4 < 0) return n4;
        this.limit -= n4;
        return n4;
    }

    @Override
    public long skip(long l2) {
        long l3 = super.skip(Math.min(l2, (long)this.limit));
        if (l3 < 0) return l3;
        this.limit = (int)((long)this.limit - l3);
        return l3;
    }
}

