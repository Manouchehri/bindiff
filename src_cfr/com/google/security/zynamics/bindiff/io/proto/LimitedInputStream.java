/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.io.proto;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class LimitedInputStream
extends FilterInputStream {
    private int readLimit;

    public LimitedInputStream(InputStream inputStream, int n2) {
        super(inputStream);
        this.readLimit = n2;
    }

    @Override
    public int available() {
        return Math.min(super.available(), this.readLimit);
    }

    @Override
    public int read() {
        if (this.readLimit <= 0) {
            return -1;
        }
        int n2 = super.read();
        if (n2 < 0) return n2;
        --this.readLimit;
        return n2;
    }

    @Override
    public int read(byte[] arrby, int n2, int n3) {
        if (this.readLimit <= 0) {
            return -1;
        }
        int n4 = super.read(arrby, n2, n3 = Math.min(n3, this.readLimit));
        if (n4 < 0) return n4;
        this.readLimit -= n4;
        return n4;
    }
}

