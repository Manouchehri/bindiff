/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@Beta
public final class CountingOutputStream
extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super((OutputStream)Preconditions.checkNotNull(outputStream));
    }

    public long getCount() {
        return this.count;
    }

    @Override
    public void write(byte[] arrby, int n2, int n3) {
        this.out.write(arrby, n2, n3);
        this.count += (long)n3;
    }

    @Override
    public void write(int n2) {
        this.out.write(n2);
        ++this.count;
    }

    @Override
    public void close() {
        this.out.close();
    }
}

