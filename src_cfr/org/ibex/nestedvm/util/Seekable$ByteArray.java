/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.IOException;
import org.ibex.nestedvm.util.Seekable;

public class Seekable$ByteArray
extends Seekable {
    protected byte[] data;
    protected int pos;
    private final boolean writable;

    public Seekable$ByteArray(byte[] arrby, boolean bl2) {
        this.data = arrby;
        this.pos = 0;
        this.writable = bl2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if ((n3 = Math.min(n3, this.data.length - this.pos)) <= 0) {
            return -1;
        }
        System.arraycopy(this.data, this.pos, arrby, n2, n3);
        this.pos += n3;
        return n3;
    }

    @Override
    public int write(byte[] arrby, int n2, int n3) {
        if (!this.writable) {
            throw new IOException("read-only data");
        }
        if ((n3 = Math.min(n3, this.data.length - this.pos)) <= 0) {
            throw new IOException("no space");
        }
        System.arraycopy(arrby, n2, this.data, this.pos, n3);
        this.pos += n3;
        return n3;
    }

    @Override
    public int length() {
        return this.data.length;
    }

    @Override
    public int pos() {
        return this.pos;
    }

    @Override
    public void seek(int n2) {
        this.pos = n2;
    }

    @Override
    public void close() {
    }
}

