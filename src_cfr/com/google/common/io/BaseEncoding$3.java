/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.CharMatcher;
import java.io.Reader;

final class BaseEncoding$3
extends Reader {
    final /* synthetic */ Reader val$delegate;
    final /* synthetic */ CharMatcher val$toIgnore;

    BaseEncoding$3(Reader reader, CharMatcher charMatcher) {
        this.val$delegate = reader;
        this.val$toIgnore = charMatcher;
    }

    @Override
    public int read() {
        int n2;
        do {
            if ((n2 = this.val$delegate.read()) == -1) return n2;
        } while (this.val$toIgnore.matches((char)n2));
        return n2;
    }

    @Override
    public int read(char[] arrc, int n2, int n3) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        this.val$delegate.close();
    }
}

