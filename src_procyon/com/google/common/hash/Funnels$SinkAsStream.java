package com.google.common.hash;

import java.io.*;
import com.google.common.base.*;

class Funnels$SinkAsStream extends OutputStream
{
    final PrimitiveSink sink;
    
    Funnels$SinkAsStream(final PrimitiveSink primitiveSink) {
        this.sink = (PrimitiveSink)Preconditions.checkNotNull(primitiveSink);
    }
    
    @Override
    public void write(final int n) {
        this.sink.putByte((byte)n);
    }
    
    @Override
    public void write(final byte[] array) {
        this.sink.putBytes(array);
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        this.sink.putBytes(array, n, n2);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.sink);
        return new StringBuilder(24 + String.valueOf(value).length()).append("Funnels.asOutputStream(").append(value).append(")").toString();
    }
}
