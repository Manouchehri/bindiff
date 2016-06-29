package org.ibex.nestedvm;

import java.io.*;

class Runtime$Win32ConsoleIS extends InputStream
{
    private int pushedBack;
    private final InputStream parent;
    
    public Runtime$Win32ConsoleIS(final InputStream parent) {
        this.pushedBack = -1;
        this.parent = parent;
    }
    
    public int read() {
        if (this.pushedBack != -1) {
            final int pushedBack = this.pushedBack;
            this.pushedBack = -1;
            return pushedBack;
        }
        int pushedBack2 = this.parent.read();
        if (pushedBack2 == 13 && (pushedBack2 = this.parent.read()) != 10) {
            this.pushedBack = pushedBack2;
            return 13;
        }
        return pushedBack2;
    }
    
    public int read(final byte[] array, int n, int n2) {
        int n3 = 0;
        if (this.pushedBack != -1 && n2 > 0) {
            array[0] = (byte)this.pushedBack;
            this.pushedBack = -1;
            ++n;
            --n2;
            n3 = 1;
        }
        int read = this.parent.read(array, n, n2);
        if (read == -1) {
            return (n3 != 0) ? 1 : -1;
        }
        for (int i = 0; i < read; ++i) {
            if (array[n + i] == 13) {
                if (i == read - 1) {
                    final int read2 = this.parent.read();
                    if (read2 == 10) {
                        array[n + i] = 10;
                    }
                    else {
                        this.pushedBack = read2;
                    }
                }
                else if (array[n + i + 1] == 10) {
                    System.arraycopy(array, n + i + 1, array, n + i, n2 - i - 1);
                    --read;
                }
            }
        }
        return read + n3;
    }
}
