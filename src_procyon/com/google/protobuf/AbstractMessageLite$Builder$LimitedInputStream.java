package com.google.protobuf;

import java.io.*;

final class AbstractMessageLite$Builder$LimitedInputStream extends FilterInputStream
{
    private int limit;
    
    AbstractMessageLite$Builder$LimitedInputStream(final InputStream inputStream, final int limit) {
        super(inputStream);
        this.limit = limit;
    }
    
    public int available() {
        return Math.min(super.available(), this.limit);
    }
    
    public int read() {
        if (this.limit <= 0) {
            return -1;
        }
        final int read = super.read();
        if (read >= 0) {
            --this.limit;
        }
        return read;
    }
    
    public int read(final byte[] array, final int n, int min) {
        if (this.limit <= 0) {
            return -1;
        }
        min = Math.min(min, this.limit);
        final int read = super.read(array, n, min);
        if (read >= 0) {
            this.limit -= read;
        }
        return read;
    }
    
    public long skip(final long n) {
        final long skip = super.skip(Math.min(n, this.limit));
        if (skip >= 0L) {
            this.limit -= (int)skip;
        }
        return skip;
    }
}
