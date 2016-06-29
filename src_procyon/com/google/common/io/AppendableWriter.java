package com.google.common.io;

import com.google.common.base.*;
import javax.annotation.*;
import java.io.*;

class AppendableWriter extends Writer
{
    private final Appendable target;
    private boolean closed;
    
    AppendableWriter(final Appendable appendable) {
        this.target = (Appendable)Preconditions.checkNotNull(appendable);
    }
    
    @Override
    public void write(final char[] array, final int n, final int n2) {
        this.checkNotClosed();
        this.target.append(new String(array, n, n2));
    }
    
    @Override
    public void flush() {
        this.checkNotClosed();
        if (this.target instanceof Flushable) {
            ((Flushable)this.target).flush();
        }
    }
    
    @Override
    public void close() {
        this.closed = true;
        if (this.target instanceof Closeable) {
            ((Closeable)this.target).close();
        }
    }
    
    @Override
    public void write(final int n) {
        this.checkNotClosed();
        this.target.append((char)n);
    }
    
    @Override
    public void write(@Nullable final String s) {
        this.checkNotClosed();
        this.target.append(s);
    }
    
    @Override
    public void write(@Nullable final String s, final int n, final int n2) {
        this.checkNotClosed();
        this.target.append(s, n, n + n2);
    }
    
    @Override
    public Writer append(final char c) {
        this.checkNotClosed();
        this.target.append(c);
        return this;
    }
    
    @Override
    public Writer append(@Nullable final CharSequence charSequence) {
        this.checkNotClosed();
        this.target.append(charSequence);
        return this;
    }
    
    @Override
    public Writer append(@Nullable final CharSequence charSequence, final int n, final int n2) {
        this.checkNotClosed();
        this.target.append(charSequence, n, n2);
        return this;
    }
    
    private void checkNotClosed() {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }
}
