package org.ibex.nestedvm.util;

import java.io.*;

public class Seekable$File extends Seekable
{
    private final File file;
    private final RandomAccessFile raf;
    
    public Seekable$File(final String s) {
        this(s, false);
    }
    
    public Seekable$File(final String s, final boolean b) {
        this(new File(s), b, false);
    }
    
    public Seekable$File(final File file, final boolean b, final boolean b2) {
        this.file = file;
        this.raf = new RandomAccessFile(file, b ? "rw" : "r");
        if (b2) {
            Platform.setFileLength(this.raf, 0);
        }
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        return this.raf.read(array, n, n2);
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        this.raf.write(array, n, n2);
        return n2;
    }
    
    public void sync() {
        this.raf.getFD().sync();
    }
    
    public void seek(final int n) {
        this.raf.seek(n);
    }
    
    public int pos() {
        return (int)this.raf.getFilePointer();
    }
    
    public int length() {
        return (int)this.raf.length();
    }
    
    public void close() {
        this.raf.close();
    }
    
    public void resize(final long n) {
        Platform.setFileLength(this.raf, (int)n);
    }
    
    public boolean equals(final Object o) {
        return o != null && o instanceof Seekable$File && this.file.equals(((Seekable$File)o).file);
    }
    
    public Seekable$Lock lock(final long n, final long n2, final boolean b) {
        return Platform.lockFile(this, this.raf, n, n2, b);
    }
}
