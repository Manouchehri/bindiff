package com.google.common.io;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.io.*;

@Beta
public final class CountingInputStream extends FilterInputStream
{
    private long count;
    private long mark;
    
    public CountingInputStream(final InputStream inputStream) {
        super((InputStream)Preconditions.checkNotNull(inputStream));
        this.mark = -1L;
    }
    
    public long getCount() {
        return this.count;
    }
    
    @Override
    public int read() {
        final int read = this.in.read();
        if (read != -1) {
            ++this.count;
        }
        return read;
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) {
        final int read = this.in.read(array, n, n2);
        if (read != -1) {
            this.count += read;
        }
        return read;
    }
    
    @Override
    public long skip(final long n) {
        final long skip = this.in.skip(n);
        this.count += skip;
        return skip;
    }
    
    @Override
    public synchronized void mark(final int n) {
        this.in.mark(n);
        this.mark = this.count;
    }
    
    @Override
    public synchronized void reset() {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.mark == -1L) {
            throw new IOException("Mark not set");
        }
        this.in.reset();
        this.count = this.mark;
    }
}
