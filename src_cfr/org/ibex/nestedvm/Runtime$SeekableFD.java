/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.IOException;
import org.ibex.nestedvm.Runtime$ErrnoException;
import org.ibex.nestedvm.Runtime$FD;
import org.ibex.nestedvm.Runtime$FStat;
import org.ibex.nestedvm.util.Seekable;

public abstract class Runtime$SeekableFD
extends Runtime$FD {
    private final int flags;
    private final Seekable data;

    Runtime$SeekableFD(Seekable seekable, int n2) {
        this.data = seekable;
        this.flags = n2;
    }

    @Override
    protected abstract Runtime$FStat _fstat();

    @Override
    public int flags() {
        return this.flags;
    }

    @Override
    Seekable seekable() {
        return this.data;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public int seek(int var1_1, int var2_2) {
        try {
            switch (var2_2) {
                case 0: {
                    ** break;
                }
                case 1: {
                    var1_1 += this.data.pos();
                    ** break;
                }
                case 2: {
                    var1_1 += this.data.length();
                    ** break;
                }
            }
            return -1;
lbl12: // 3 sources:
            this.data.seek(var1_1);
            return var1_1;
        }
        catch (IOException var3_3) {
            throw new Runtime$ErrnoException(29);
        }
    }

    @Override
    public int write(byte[] arrby, int n2, int n3) {
        if ((this.flags & 3) == 0) {
            throw new Runtime$ErrnoException(81);
        }
        if ((this.flags & 8) != 0) {
            this.seek(0, 2);
        }
        try {
            return this.data.write(arrby, n2, n3);
        }
        catch (IOException var4_4) {
            throw new Runtime$ErrnoException(5);
        }
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if ((this.flags & 3) == 1) {
            throw new Runtime$ErrnoException(81);
        }
        try {
            int n4 = this.data.read(arrby, n2, n3);
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
    protected void _close() {
        try {
            this.data.close();
            return;
        }
        catch (IOException var1_1) {
            // empty catch block
        }
    }
}

