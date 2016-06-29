package org.ibex.nestedvm;

import org.ibex.nestedvm.util.*;
import java.io.*;

public abstract class Runtime$SeekableFD extends Runtime$FD
{
    private final int flags;
    private final Seekable data;
    
    Runtime$SeekableFD(final Seekable data, final int flags) {
        this.data = data;
        this.flags = flags;
    }
    
    protected abstract Runtime$FStat _fstat();
    
    public int flags() {
        return this.flags;
    }
    
    Seekable seekable() {
        return this.data;
    }
    
    public int seek(int n, final int n2) {
        try {
            switch (n2) {
                case 0: {
                    break;
                }
                case 1: {
                    n += this.data.pos();
                    break;
                }
                case 2: {
                    n += this.data.length();
                    break;
                }
                default: {
                    return -1;
                }
            }
            this.data.seek(n);
            return n;
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(29);
        }
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        if ((this.flags & 0x3) == 0x0) {
            throw new Runtime$ErrnoException(81);
        }
        if ((this.flags & 0x8) != 0x0) {
            this.seek(0, 2);
        }
        try {
            return this.data.write(array, n, n2);
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        if ((this.flags & 0x3) == 0x1) {
            throw new Runtime$ErrnoException(81);
        }
        try {
            final int read = this.data.read(array, n, n2);
            return (read < 0) ? 0 : read;
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    protected void _close() {
        try {
            this.data.close();
        }
        catch (IOException ex) {}
    }
}
