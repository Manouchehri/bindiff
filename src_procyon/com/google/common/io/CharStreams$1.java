package com.google.common.io;

import java.nio.*;
import java.io.*;

final class CharStreams$1 extends Reader
{
    final /* synthetic */ Readable val$readable;
    
    CharStreams$1(final Readable val$readable) {
        this.val$readable = val$readable;
    }
    
    @Override
    public int read(final char[] array, final int n, final int n2) {
        return this.read(CharBuffer.wrap(array, n, n2));
    }
    
    @Override
    public int read(final CharBuffer charBuffer) {
        return this.val$readable.read(charBuffer);
    }
    
    @Override
    public void close() {
        if (this.val$readable instanceof Closeable) {
            ((Closeable)this.val$readable).close();
        }
    }
}
