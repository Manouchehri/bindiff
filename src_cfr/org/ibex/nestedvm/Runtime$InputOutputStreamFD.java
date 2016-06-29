/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.Runtime$SocketFStat;

public class Runtime$InputOutputStreamFD
extends Runtime$FD {
    private final InputStream is;
    private final OutputStream os;

    public Runtime$InputOutputStreamFD(InputStream inputStream) {
        this(inputStream, null);
    }

    public Runtime$InputOutputStreamFD(OutputStream outputStream) {
        this(null, outputStream);
    }

    public Runtime$InputOutputStreamFD(InputStream inputStream, OutputStream outputStream) {
        this.is = inputStream;
        this.os = outputStream;
        if (inputStream != null) return;
        if (outputStream != null) return;
        throw new IllegalArgumentException("at least one stream must be supplied");
    }

    @Override
    public int flags() {
        if (this.is != null && this.os != null) {
            return 2;
        }
        if (this.is != null) {
            return 0;
        }
        if (this.os == null) throw new Error("should never happen");
        return 1;
    }

    @Override
    public void _close() {
        if (this.is != null) {
            try {
                this.is.close();
            }
            catch (IOException var1_1) {
                // empty catch block
            }
        }
        if (this.os == null) return;
        try {
            this.os.close();
            return;
        }
        catch (IOException var1_2) {
            // empty catch block
        }
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (this.is == null) {
            return super.read(arrby, n2, n3);
        }
        try {
            int n4 = this.is.read(arrby, n2, n3);
            if (n4 < 0) {
                return 0;
            }
            int n5 = n4;
            return n5;
        }
        catch (IOException var4_5) {
            throw new Runtime$ErrnoException(5);
        }
    }

    @Override
    public int write(byte[] arrby, int n2, int n3) {
        if (this.os == null) {
            return super.write(arrby, n2, n3);
        }
        try {
            this.os.write(arrby, n2, n3);
            return n3;
        }
        catch (IOException var4_4) {
            throw new Runtime$ErrnoException(5);
        }
    }

    @Override
    public Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }
}

