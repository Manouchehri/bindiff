/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.Nullable;

final class MultiInputStream
extends InputStream {
    private Iterator it;
    private InputStream in;

    public MultiInputStream(Iterator iterator) {
        this.it = (Iterator)Preconditions.checkNotNull(iterator);
        this.advance();
    }

    @Override
    public void close() {
        if (this.in == null) return;
        try {
            this.in.close();
            return;
        }
        finally {
            this.in = null;
        }
    }

    private void advance() {
        this.close();
        if (!this.it.hasNext()) return;
        this.in = ((ByteSource)this.it.next()).openStream();
    }

    @Override
    public int available() {
        if (this.in != null) return this.in.available();
        return 0;
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() {
        if (this.in == null) {
            return -1;
        }
        int n2 = this.in.read();
        if (n2 != -1) return n2;
        this.advance();
        return this.read();
    }

    @Override
    public int read(@Nullable byte[] arrby, int n2, int n3) {
        if (this.in == null) {
            return -1;
        }
        int n4 = this.in.read(arrby, n2, n3);
        if (n4 != -1) return n4;
        this.advance();
        return this.read(arrby, n2, n3);
    }

    @Override
    public long skip(long l2) {
        if (this.in == null) return 0;
        if (l2 <= 0) {
            return 0;
        }
        long l3 = this.in.skip(l2);
        if (l3 != 0) {
            return l3;
        }
        if (this.read() != -1) return 1 + this.in.skip(l2 - 1);
        return 0;
    }
}

