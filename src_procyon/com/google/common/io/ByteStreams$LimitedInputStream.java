package com.google.common.io;

import com.google.common.base.*;
import java.io.*;

final class ByteStreams$LimitedInputStream extends FilterInputStream
{
    private long left;
    private long mark;
    
    ByteStreams$LimitedInputStream(final InputStream inputStream, final long left) {
        super(inputStream);
        this.mark = -1L;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkArgument(left >= 0L, (Object)"limit must be non-negative");
        this.left = left;
    }
    
    @Override
    public int available() {
        return (int)Math.min(this.in.available(), this.left);
    }
    
    @Override
    public synchronized void mark(final int n) {
        this.in.mark(n);
        this.mark = this.left;
    }
    
    @Override
    public int read() {
        if (this.left == 0L) {
            return -1;
        }
        final int read = this.in.read();
        if (read != -1) {
            --this.left;
        }
        return read;
    }
    
    @Override
    public int read(final byte[] array, final int n, int n2) {
        if (this.left == 0L) {
            return -1;
        }
        n2 = (int)Math.min(n2, this.left);
        final int read = this.in.read(array, n, n2);
        if (read != -1) {
            this.left -= read;
        }
        return read;
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
        this.left = this.mark;
    }
    
    @Override
    public long skip(long min) {
        min = Math.min(min, this.left);
        final long skip = this.in.skip(min);
        this.left -= skip;
        return skip;
    }
}
