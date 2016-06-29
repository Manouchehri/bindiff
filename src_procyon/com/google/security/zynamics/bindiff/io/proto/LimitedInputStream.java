package com.google.security.zynamics.bindiff.io.proto;

import java.io.*;

public final class LimitedInputStream extends FilterInputStream
{
    private int readLimit;
    
    public LimitedInputStream(final InputStream inputStream, final int readLimit) {
        super(inputStream);
        this.readLimit = readLimit;
    }
    
    @Override
    public int available() {
        return Math.min(super.available(), this.readLimit);
    }
    
    @Override
    public int read() {
        if (this.readLimit <= 0) {
            return -1;
        }
        final int read = super.read();
        if (read >= 0) {
            --this.readLimit;
        }
        return read;
    }
    
    @Override
    public int read(final byte[] array, final int n, int min) {
        if (this.readLimit <= 0) {
            return -1;
        }
        min = Math.min(min, this.readLimit);
        final int read = super.read(array, n, min);
        if (read >= 0) {
            this.readLimit -= read;
        }
        return read;
    }
}
