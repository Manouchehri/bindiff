package org.ibex.nestedvm.util;

import java.io.*;

public abstract class Seekable
{
    public abstract int read(final byte[] p0, final int p1, final int p2);
    
    public abstract int write(final byte[] p0, final int p1, final int p2);
    
    public abstract int length();
    
    public abstract void seek(final int p0);
    
    public abstract void close();
    
    public abstract int pos();
    
    public void sync() {
        throw new IOException("sync not implemented for " + this.getClass());
    }
    
    public void resize(final long n) {
        throw new IOException("resize not implemented for " + this.getClass());
    }
    
    public Seekable$Lock lock(final long n, final long n2, final boolean b) {
        throw new IOException("lock not implemented for " + this.getClass());
    }
    
    public int read() {
        final byte[] array = { 0 };
        return (this.read(array, 0, 1) == -1) ? -1 : (array[0] & 0xFF);
    }
    
    public int tryReadFully(final byte[] array, int n, int i) {
        int n2;
        int read;
        for (n2 = 0; i > 0; i -= read, n2 += read) {
            read = this.read(array, n, i);
            if (read == -1) {
                break;
            }
            n += read;
        }
        return (n2 == 0) ? -1 : n2;
    }
}
