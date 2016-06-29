/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.HashCode;
import com.google.common.hash.Murmur3_32HashFunction;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

final class Murmur3_32HashFunction$Murmur3_32Hasher
extends AbstractStreamingHashFunction$AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 4;
    private int h1;
    private int length;

    Murmur3_32HashFunction$Murmur3_32Hasher(int n2) {
        super(4);
        this.h1 = n2;
        this.length = 0;
    }

    @Override
    protected void process(ByteBuffer byteBuffer) {
        int n2 = Murmur3_32HashFunction.access$000(byteBuffer.getInt());
        this.h1 = Murmur3_32HashFunction.access$100(this.h1, n2);
        this.length += 4;
    }

    @Override
    protected void processRemaining(ByteBuffer byteBuffer) {
        this.length += byteBuffer.remaining();
        int n2 = 0;
        int n3 = 0;
        do {
            if (!byteBuffer.hasRemaining()) {
                this.h1 ^= Murmur3_32HashFunction.access$000(n2);
                return;
            }
            n2 ^= UnsignedBytes.toInt(byteBuffer.get()) << n3;
            n3 += 8;
        } while (true);
    }

    @Override
    public HashCode makeHash() {
        return Murmur3_32HashFunction.access$200(this.h1, this.length);
    }
}

