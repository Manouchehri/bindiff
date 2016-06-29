package com.google.common.hash;

import java.nio.*;
import com.google.common.primitives.*;
import java.io.*;
import javax.annotation.*;

final class Murmur3_32HashFunction$Murmur3_32Hasher extends AbstractStreamingHashFunction$AbstractStreamingHasher
{
    private static final int CHUNK_SIZE = 4;
    private int h1;
    private int length;
    
    Murmur3_32HashFunction$Murmur3_32Hasher(final int h1) {
        super(4);
        this.h1 = h1;
        this.length = 0;
    }
    
    @Override
    protected void process(final ByteBuffer byteBuffer) {
        this.h1 = mixH1(this.h1, mixK1(byteBuffer.getInt()));
        this.length += 4;
    }
    
    @Override
    protected void processRemaining(final ByteBuffer byteBuffer) {
        this.length += byteBuffer.remaining();
        int n = 0;
        int n2 = 0;
        while (byteBuffer.hasRemaining()) {
            n ^= UnsignedBytes.toInt(byteBuffer.get()) << n2;
            n2 += 8;
        }
        this.h1 ^= mixK1(n);
    }
    
    public HashCode makeHash() {
        return fmix(this.h1, this.length);
    }
}
