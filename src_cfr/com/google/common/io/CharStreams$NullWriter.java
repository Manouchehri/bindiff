/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Writer;

final class CharStreams$NullWriter
extends Writer {
    private static final CharStreams$NullWriter INSTANCE = new CharStreams$NullWriter();

    private CharStreams$NullWriter() {
    }

    @Override
    public void write(int n2) {
    }

    @Override
    public void write(char[] arrc) {
        Preconditions.checkNotNull(arrc);
    }

    @Override
    public void write(char[] arrc, int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrc.length);
    }

    @Override
    public void write(String string) {
        Preconditions.checkNotNull(string);
    }

    @Override
    public void write(String string, int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n2 + n3, string.length());
    }

    @Override
    public Writer append(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return this;
    }

    @Override
    public Writer append(CharSequence charSequence, int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n3, charSequence.length());
        return this;
    }

    @Override
    public Writer append(char c2) {
        return this;
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }

    public String toString() {
        return "CharStreams.nullWriter()";
    }

    static /* synthetic */ CharStreams$NullWriter access$000() {
        return INSTANCE;
    }
}

