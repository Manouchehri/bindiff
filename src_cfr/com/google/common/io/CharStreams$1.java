/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import java.io.Closeable;
import java.io.Reader;
import java.nio.CharBuffer;

final class CharStreams$1
extends Reader {
    final /* synthetic */ Readable val$readable;

    CharStreams$1(Readable readable) {
        this.val$readable = readable;
    }

    @Override
    public int read(char[] arrc, int n2, int n3) {
        return this.read(CharBuffer.wrap(arrc, n2, n3));
    }

    @Override
    public int read(CharBuffer charBuffer) {
        return this.val$readable.read(charBuffer);
    }

    @Override
    public void close() {
        if (!(this.val$readable instanceof Closeable)) return;
        ((Closeable)((Object)this.val$readable)).close();
    }
}

