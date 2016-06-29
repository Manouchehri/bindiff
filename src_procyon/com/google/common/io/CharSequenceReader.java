package com.google.common.io;

import com.google.common.base.*;
import java.io.*;
import java.nio.*;

final class CharSequenceReader extends Reader
{
    private CharSequence seq;
    private int pos;
    private int mark;
    
    public CharSequenceReader(final CharSequence charSequence) {
        this.seq = (CharSequence)Preconditions.checkNotNull(charSequence);
    }
    
    private void checkOpen() {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }
    
    private boolean hasRemaining() {
        return this.remaining() > 0;
    }
    
    private int remaining() {
        return this.seq.length() - this.pos;
    }
    
    @Override
    public synchronized int read(final CharBuffer charBuffer) {
        Preconditions.checkNotNull(charBuffer);
        this.checkOpen();
        if (!this.hasRemaining()) {
            return -1;
        }
        final int min = Math.min(charBuffer.remaining(), this.remaining());
        for (int i = 0; i < min; ++i) {
            charBuffer.put(this.seq.charAt(this.pos++));
        }
        return min;
    }
    
    @Override
    public synchronized int read() {
        this.checkOpen();
        return this.hasRemaining() ? this.seq.charAt(this.pos++) : -1;
    }
    
    @Override
    public synchronized int read(final char[] array, final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        this.checkOpen();
        if (!this.hasRemaining()) {
            return -1;
        }
        final int min = Math.min(n2, this.remaining());
        for (int i = 0; i < min; ++i) {
            array[n + i] = this.seq.charAt(this.pos++);
        }
        return min;
    }
    
    @Override
    public synchronized long skip(final long n) {
        Preconditions.checkArgument(n >= 0L, "n (%s) may not be negative", n);
        this.checkOpen();
        final int n2 = (int)Math.min(this.remaining(), n);
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
    public synchronized void mark(final int n) {
        Preconditions.checkArgument(n >= 0, "readAheadLimit (%s) may not be negative", n);
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
