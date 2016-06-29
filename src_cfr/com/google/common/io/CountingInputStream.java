/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class CountingInputStream
extends FilterInputStream {
    private long count;
    private long mark = -1;

    public CountingInputStream(InputStream inputStream) {
        super((InputStream)Preconditions.checkNotNull(inputStream));
    }

    public long getCount() {
        return this.count;
    }

    @Override
    public int read() {
        int n2 = this.in.read();
        if (n2 == -1) return n2;
        ++this.count;
        return n2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        int n4 = this.in.read(arrby, n2, n3);
        if (n4 == -1) return n4;
        this.count += (long)n4;
        return n4;
    }

    @Override
    public long skip(long l2) {
        long l3 = this.in.skip(l2);
        this.count += l3;
        return l3;
    }

    @Override
    public synchronized void mark(int n2) {
        this.in.mark(n2);
        this.mark = this.count;
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
        this.count = this.mark;
    }
}

