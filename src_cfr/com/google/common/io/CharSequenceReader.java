/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

final class CharSequenceReader
extends Reader {
    private CharSequence seq;
    private int pos;
    private int mark;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence)Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() {
        if (this.seq != null) return;
        throw new IOException("reader closed");
    }

    private boolean hasRemaining() {
        if (this.remaining() <= 0) return false;
        return true;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    @Override
    public synchronized int read(CharBuffer charBuffer) {
        Preconditions.checkNotNull(charBuffer);
        this.checkOpen();
        if (!this.hasRemaining()) {
            return -1;
        }
        int n2 = Math.min(charBuffer.remaining(), this.remaining());
        int n3 = 0;
        while (n3 < n2) {
            charBuffer.put(this.seq.charAt(this.pos++));
            ++n3;
        }
        return n2;
    }

    @Override
    public synchronized int read() {
        this.checkOpen();
        if (!this.hasRemaining()) return -1;
        int n2 = this.seq.charAt(this.pos++);
        return n2;
    }

    @Override
    public synchronized int read(char[] arrc, int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrc.length);
        this.checkOpen();
        if (!this.hasRemaining()) {
            return -1;
        }
        int n4 = Math.min(n3, this.remaining());
        int n5 = 0;
        while (n5 < n4) {
            arrc[n2 + n5] = this.seq.charAt(this.pos++);
            ++n5;
        }
        return n4;
    }

    @Override
    public synchronized long skip(long l2) {
        Preconditions.checkArgument(l2 >= 0, "n (%s) may not be negative", l2);
        this.checkOpen();
        int n2 = (int)Math.min((long)this.remaining(), l2);
        this.pos += n2;
        return n2;
    }

    @Override
    public synchronized boolean ready() {
        this.checkOpen();
        return true;
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public synchronized void mark(int n2) {
        Preconditions.checkArgument(n2 >= 0, "readAheadLimit (%s) may not be negative", n2);
        this.checkOpen();
        this.mark = this.pos;
    }

    @Override
    public synchronized void reset() {
        this.checkOpen();
        this.pos = this.mark;
    }

    @Override
    public synchronized void close() {
        this.seq = null;
    }
}

