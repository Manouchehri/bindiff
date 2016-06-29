package org.ibex.nestedvm.util;

import java.io.*;

public class Seekable$ByteArray extends Seekable
{
    protected byte[] data;
    protected int pos;
    private final boolean writable;
    
    public Seekable$ByteArray(final byte[] data, final boolean writable) {
        this.data = data;
        this.pos = 0;
        this.writable = writable;
    }
    
    public int read(final byte[] array, final int n, int min) {
        min = Math.min(min, this.data.length - this.pos);
        if (min <= 0) {
            return -1;
        }
        System.arraycopy(this.data, this.pos, array, n, min);
        this.pos += min;
        return min;
    }
    
    public int write(final byte[] array, final int n, int min) {
        if (!this.writable) {
            throw new IOException("read-only data");
        }
        min = Math.min(min, this.data.length - this.pos);
        if (min <= 0) {
            throw new IOException("no space");
        }
        System.arraycopy(array, n, this.data, this.pos, min);
        this.pos += min;
        return min;
    }
    
    public int length() {
        return this.data.length;
    }
    
    public int pos() {
        return this.pos;
    }
    
    public void seek(final int pos) {
        this.pos = pos;
    }
    
    public void close() {
    }
}
