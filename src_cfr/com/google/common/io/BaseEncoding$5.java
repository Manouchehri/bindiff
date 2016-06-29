/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import java.io.Writer;

final class BaseEncoding$5
extends Writer {
    final /* synthetic */ Appendable val$seperatingAppendable;
    final /* synthetic */ Writer val$delegate;

    BaseEncoding$5(Appendable appendable, Writer writer) {
        this.val$seperatingAppendable = appendable;
        this.val$delegate = writer;
    }

    @Override
    public void write(int n2) {
        this.val$seperatingAppendable.append((char)n2);
    }

    @Override
    public void write(char[] arrc, int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void flush() {
        this.val$delegate.flush();
    }

    @Override
    public void close() {
        this.val$delegate.close();
    }
}

