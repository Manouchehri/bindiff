/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class ByteStreams$LimitedInputStream
extends FilterInputStream {
    private long left;
    private long mark = -1;

    ByteStreams$LimitedInputStream(InputStream inputStream, long l2) {
        super(inputStream);
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkArgument(l2 >= 0, "limit must be non-negative");
        this.left = l2;
    }

    @Override
    public int available() {
        return (int)Math.min((long)this.in.available(), this.left);
    }

    @Override
    public synchronized void mark(int n2) {
        this.in.mark(n2);
        this.mark = this.left;
    }

    @Override
    public int read() {
        if (this.left == 0) {
            return -1;
        }
        int n2 = this.in.read();
        if (n2 == -1) return n2;
        --this.left;
        return n2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (this.left == 0) {
            return -1;
        }
        int n4 = this.in.read(arrby, n2, n3 = (int)Math.min((long)n3, this.left));
        if (n4 == -1) return n4;
        this.left -= (long)n4;
        return n4;
    }

    @Override
    public synchronized void reset() {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.mark == -1) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.left = this.mark;
    }

    @Override
    public long skip(long l2) {
        l2 = Math.min(l2, this.left);
        long l3 = this.in.skip(l2);
        this.left -= l3;
        return l3;
    }
}

