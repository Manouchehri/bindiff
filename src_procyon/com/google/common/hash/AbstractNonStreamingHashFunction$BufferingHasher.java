package com.google.common.hash;

import java.io.*;

final class AbstractNonStreamingHashFunction$BufferingHasher extends AbstractHasher
{
    final AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream stream;
    static final int BOTTOM_BYTE = 255;
    final /* synthetic */ AbstractNonStreamingHashFunction this$0;
    
    AbstractNonStreamingHashFunction$BufferingHasher(final AbstractNonStreamingHashFunction this$0, final int n) {
        this.this$0 = this$0;
        this.stream = new AbstractNonStreamingHashFunction$ExposedByteArrayOutputStream(n);
    }
    
    @Override
    public Hasher putByte(final byte b) {
        this.stream.write(b);
        return this;
    }
    
    @Override
    public Hasher putBytes(final byte[] array) {
        try {
            this.stream.write(array);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return this;
    }
    
    @Override
    public Hasher putBytes(final byte[] array, final int n, final int n2) {
        this.stream.write(array, n, n2);
        return this;
    }
    
    @Override
    public Hasher putShort(final short n) {
        this.stream.write(n & 0xFF);
        this.stream.write(n >>> 8 & 0xFF);
        return this;
    }
    
    @Override
    public Hasher putInt(final int n) {
        this.stream.write(n & 0xFF);
        this.stream.write(n >>> 8 & 0xFF);
        this.stream.write(n >>> 16 & 0xFF);
        this.stream.write(n >>> 24 & 0xFF);
        return this;
    }
    
    @Override
    public Hasher putLong(final long n) {
        for (int i = 0; i < 64; i += 8) {
            this.stream.write((byte)(n >>> i & 0xFFL));
        }
        return this;
    }
    
    @Override
    public Hasher putChar(final char c) {
        this.stream.write(c & '\u00ff');
        this.stream.write(c >>> 8 & '\u00ff');
        return this;
    }
    
    @Override
    public Hasher putObject(final Object o, final Funnel funnel) {
        funnel.funnel(o, this);
        return this;
    }
    
    @Override
    public HashCode hash() {
        return this.this$0.hashBytes(this.stream.byteArray(), 0, this.stream.length());
    }
}
