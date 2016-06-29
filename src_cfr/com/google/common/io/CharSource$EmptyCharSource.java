/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.io.CharSource$CharSequenceCharSource;

final class CharSource$EmptyCharSource
extends CharSource$CharSequenceCharSource {
    private static final CharSource$EmptyCharSource INSTANCE = new CharSource$EmptyCharSource();

    private CharSource$EmptyCharSource() {
        super("");
    }

    @Override
    public String toString() {
        return "CharSource.empty()";
    }

    static /* synthetic */ CharSource$EmptyCharSource access$000() {
        return INSTANCE;
    }
}

