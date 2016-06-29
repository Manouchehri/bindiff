package org.ibex.nestedvm;

import java.io.*;

public class Runtime$InputOutputStreamFD extends Runtime$FD
{
    private final InputStream is;
    private final OutputStream os;
    
    public Runtime$InputOutputStreamFD(final InputStream inputStream) {
        this(inputStream, null);
    }
    
    public Runtime$InputOutputStreamFD(final OutputStream outputStream) {
        this(null, outputStream);
    }
    
    public Runtime$InputOutputStreamFD(final InputStream is, final OutputStream os) {
        this.is = is;
        this.os = os;
        if (is == null && os == null) {
            throw new IllegalArgumentException("at least one stream must be supplied");
        }
    }
    
    public int flags() {
        if (this.is != null && this.os != null) {
            return 2;
        }
        if (this.is != null) {
            return 0;
        }
        if (this.os != null) {
            return 1;
        }
        throw new Error("should never happen");
    }
    
    public void _close() {
        if (this.is != null) {
            try {
                this.is.close();
            }
            catch (IOException ex) {}
        }
        if (this.os != null) {
            try {
                this.os.close();
            }
            catch (IOException ex2) {}
        }
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        if (this.is == null) {
            return super.read(array, n, n2);
        }
        try {
            final int read = this.is.read(array, n, n2);
            return (read < 0) ? 0 : read;
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        if (this.os == null) {
            return super.write(array, n, n2);
        }
        try {
            this.os.write(array, n, n2);
            return n2;
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    public Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }
}
