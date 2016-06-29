/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.IOException;
import org.ibex.nestedvm.util.Seekable$Lock;

public abstract class Seekable {
    public abstract int read(byte[] var1, int var2, int var3);

    public abstract int write(byte[] var1, int var2, int var3);

    public abstract int length();

    public abstract void seek(int var1);

    public abstract void close();

    public abstract int pos();

    public void sync() {
        throw new IOException(new StringBuffer().append("sync not implemented for ").append(this.getClass()).toString());
    }

    public void resize(long l2) {
        throw new IOException(new StringBuffer().append("resize not implemented for ").append(this.getClass()).toString());
    }

    public Seekable$Lock lock(long l2, long l3, boolean bl2) {
        throw new IOException(new StringBuffer().append("lock not implemented for ").append(this.getClass()).toString());
    }

    public int read() {
        byte[] arrby = new byte[1];
        int n2 = this.read(arrby, 0, 1);
        if (n2 == -1) {
            return -1;
        }
        int n3 = arrby[0] & 255;
        return n3;
    }

    public int tryReadFully(byte[] arrby, int n2, int n3) {
        int n4;
        int n5 = 0;
        while (n3 > 0 && (n4 = this.read(arrby, n2, n3)) != -1) {
            n2 += n4;
            n3 -= n4;
            n5 += n4;
        }
        if (n5 == 0) {
            return -1;
        }
        int n6 = n5;
        return n6;
    }
}

