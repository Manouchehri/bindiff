package com.google.common.io;

import com.google.common.primitives.*;
import java.io.*;
import java.nio.*;

final class ByteBuffers$2 extends InputStream
{
    final /* synthetic */ ByteBuffer val$buf;
    
    ByteBuffers$2(final ByteBuffer val$buf) {
        this.val$buf = val$buf;
    }
    
    @Override
    public int read() {
        try {
            return UnsignedBytes.toInt(this.val$buf.get());
        }
        catch (BufferUnderflowException ex) {
            return -1;
        }
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) {
        if (this.val$buf.hasRemaining()) {
            final int min = Math.min(n2, this.val$buf.remaining());
            this.val$buf.get(array, n, min);
            return min;
        }
        return -1;
    }
    
    @Override
    public long skip(final long n) {
        if (n <= 0L) {
            return 0L;
        }
        final int n2 = (int)Math.min(this.val$buf.remaining(), n);
        this.val$buf.position(n2 + this.val$buf.position());
        return n2;
    }
    
    @Override
    public int available() {
        return this.val$buf.remaining();
    }
    
    @Override
    public boolean markSupported() {
        return true;
    }
    
    @Override
    public synchronized void mark(final int n) {
        this.val$buf.mark();
    }
    
    @Override
    public synchronized void reset() {
        try {
            this.val$buf.reset();
        }
        catch (InvalidMarkException ex) {
            throw new IOException(ex);
        }
    }
}
