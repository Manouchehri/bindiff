/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;

final class SipHashFunction$SipHasher
extends AbstractStreamingHashFunction$AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 8;
    private final int c;
    private final int d;
    private long v0 = 8317987319222330741L;
    private long v1 = 7237128888997146477L;
    private long v2 = 7816392313619706465L;
    private long v3 = 8387220255154660723L;
    private long b = 0;
    private long finalM = 0;

    SipHashFunction$SipHasher(int n2, int n3, long l2, long l3) {
        super(8);
        this.c = n2;
        this.d = n3;
        this.v0 ^= l2;
        this.v1 ^= l3;
        this.v2 ^= l2;
        this.v3 ^= l3;
    }

    @Override
    protected void process(ByteBuffer byteBuffer) {
        this.b += 8;
        this.processM(byteBuffer.getLong());
    }

    @Override
    protected void processRemaining(ByteBuffer byteBuffer) {
        this.b += (long)byteBuffer.remaining();
        int n2 = 0;
        while (byteBuffer.hasRemaining()) {
            this.finalM ^= ((long)byteBuffer.get() & 255) << n2;
            n2 += 8;
        }
    }

    @Override
    public HashCode makeHash() {
        this.finalM ^= this.b << 56;
        this.processM(this.finalM);
        this.v2 ^= 255;
        this.sipRound(this.d);
        return HashCode.fromLong(this.v0 ^ this.v1 ^ this.v2 ^ this.v3);
    }

    private void processM(long l2) {
        this.v3 ^= l2;
        this.sipRound(this.c);
        this.v0 ^= l2;
    }

    private void sipRound(int n2) {
        int n3 = 0;
        while (n3 < n2) {
            this.v0 += this.v1;
            this.v2 += this.v3;
            this.v1 = Long.rotateLeft(this.v1, 13);
            this.v3 = Long.rotateLeft(this.v3, 16);
            this.v1 ^= this.v0;
            this.v3 ^= this.v2;
            this.v0 = Long.rotateLeft(this.v0, 32);
            this.v2 += this.v1;
            this.v0 += this.v3;
            this.v1 = Long.rotateLeft(this.v1, 17);
            this.v3 = Long.rotateLeft(this.v3, 21);
            this.v1 ^= this.v2;
            this.v3 ^= this.v0;
            this.v2 = Long.rotateLeft(this.v2, 32);
            ++n3;
        }
    }
}

