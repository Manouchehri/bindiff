package com.google.common.io;

import java.nio.*;
import java.io.*;

final class ByteBuffers$1 extends ByteSource
{
    final /* synthetic */ ByteBuffer val$buf;
    
    ByteBuffers$1(final ByteBuffer val$buf) {
        this.val$buf = val$buf;
    }
    
    @Override
    public InputStream openStream() {
        return ByteBuffers.newConsumingInputStream(this.val$buf.slice());
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.val$buf);
        return new StringBuilder(26 + String.valueOf(value).length()).append("ByteBuffers.asByteSource(").append(value).append(")").toString();
    }
}
