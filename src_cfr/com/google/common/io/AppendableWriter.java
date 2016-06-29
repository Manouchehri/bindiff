/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.Nullable;

class AppendableWriter
extends Writer {
    private final Appendable target;
    private boolean closed;

    AppendableWriter(Appendable appendable) {
        this.target = (Appendable)Preconditions.checkNotNull(appendable);
    }

    @Override
    public void write(char[] arrc, int n2, int n3) {
        this.checkNotClosed();
        this.target.append(new String(arrc, n2, n3));
    }

    @Override
    public void flush() {
        this.checkNotClosed();
        if (!(this.target instanceof Flushable)) return;
        ((Flushable)((Object)this.target)).flush();
    }

    @Override
    public void close() {
        this.closed = true;
        if (!(this.target instanceof Closeable)) return;
        ((Closeable)((Object)this.target)).close();
    }

    @Override
    public void write(int n2) {
        this.checkNotClosed();
        this.target.append((char)n2);
    }

    @Override
    public void write(@Nullable String string) {
        this.checkNotClosed();
        this.target.append(string);
    }

    @Override
    public void write(@Nullable String string, int n2, int n3) {
        this.checkNotClosed();
        this.target.append(string, n2, n2 + n3);
    }

    @Override
    public Writer append(char c2) {
        this.checkNotClosed();
        this.target.append(c2);
        return this;
    }

    @Override
    public Writer append(@Nullable CharSequence charSequence) {
        this.checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    @Override
    public Writer append(@Nullable CharSequence charSequence, int n2, int n3) {
        this.checkNotClosed();
        this.target.append(charSequence, n2, n3);
        return this;
    }

    private void checkNotClosed() {
        if (!this.closed) return;
        throw new IOException("Cannot write to a closed writer.");
    }
}

