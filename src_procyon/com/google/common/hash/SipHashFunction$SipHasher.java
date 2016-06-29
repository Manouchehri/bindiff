package com.google.common.hash;

import java.nio.*;

final class SipHashFunction$SipHasher extends AbstractStreamingHashFunction$AbstractStreamingHasher
{
    private static final int CHUNK_SIZE = 8;
    private final int c;
    private final int d;
    private long v0;
    private long v1;
    private long v2;
    private long v3;
    private long b;
    private long finalM;
    
    SipHashFunction$SipHasher(final int c, final int d, final long n, final long n2) {
        super(8);
        this.v0 = 8317987319222330741L;
        this.v1 = 7237128888997146477L;
        this.v2 = 7816392313619706465L;
        this.v3 = 8387220255154660723L;
        this.b = 0L;
        this.finalM = 0L;
        this.c = c;
        this.d = d;
        this.v0 ^= n;
        this.v1 ^= n2;
        this.v2 ^= n;
        this.v3 ^= n2;
    }
    
    @Override
    protected void process(final ByteBuffer byteBuffer) {
        this.b += 8L;
        this.processM(byteBuffer.getLong());
    }
    
    @Override
    protected void processRemaining(final ByteBuffer byteBuffer) {
        this.b += byteBuffer.remaining();
        int n = 0;
        while (byteBuffer.hasRemaining()) {
            this.finalM ^= (byteBuffer.get() & 0xFFL) << n;
            n += 8;
        }
    }
    
    public HashCode makeHash() {
        this.processM(this.finalM ^= this.b << 56);
        this.v2 ^= 0xFFL;
        this.sipRound(this.d);
        return HashCode.fromLong(this.v0 ^ this.v1 ^ this.v2 ^ this.v3);
    }
    
    private void processM(final long n) {
        this.v3 ^= n;
        this.sipRound(this.c);
        this.v0 ^= n;
    }
    
    private void sipRound(final int n) {
        for (int i = 0; i < n; ++i) {
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
        }
    }
}
