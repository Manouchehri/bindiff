package com.google.common.hash;

import java.nio.*;

final class GoogleLegacy64HashFunction$GoogleLegacy64Hasher extends AbstractStreamingHashFunction$AbstractStreamingHasher
{
    private static final int CHUNK_SIZE = 24;
    private final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer;
    private int length;
    
    private GoogleLegacy64HashFunction$GoogleLegacy64Hasher(final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer) {
        super(24);
        this.length = 0;
        this.mixer = mixer;
    }
    
    @Override
    protected void process(final ByteBuffer byteBuffer) {
        this.length += 24;
        final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer = this.mixer;
        mixer.a += byteBuffer.getLong();
        final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer2 = this.mixer;
        mixer2.b += byteBuffer.getLong();
        final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer3 = this.mixer;
        mixer3.c += byteBuffer.getLong();
        this.mixer.mix();
    }
    
    @Override
    protected void processRemaining(final ByteBuffer byteBuffer) {
        this.length += byteBuffer.remaining();
        switch (byteBuffer.remaining()) {
            case 23: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer = this.mixer;
                mixer.c += byteBuffer.get(22) << 56;
            }
            case 22: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer2 = this.mixer;
                mixer2.c += (byteBuffer.get(21) & 0xFFL) << 48;
            }
            case 21: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer3 = this.mixer;
                mixer3.c += (byteBuffer.get(20) & 0xFFL) << 40;
            }
            case 20: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer4 = this.mixer;
                mixer4.c += (byteBuffer.get(19) & 0xFFL) << 32;
            }
            case 19: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer5 = this.mixer;
                mixer5.c += (byteBuffer.get(18) & 0xFFL) << 24;
            }
            case 18: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer6 = this.mixer;
                mixer6.c += (byteBuffer.get(17) & 0xFFL) << 16;
            }
            case 17: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer7 = this.mixer;
                mixer7.c += (byteBuffer.get(16) & 0xFFL) << 8;
            }
            case 16: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer8 = this.mixer;
                mixer8.a += byteBuffer.getLong();
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer9 = this.mixer;
                mixer9.b += byteBuffer.getLong();
                break;
            }
            case 15: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer10 = this.mixer;
                mixer10.b += (byteBuffer.get(14) & 0xFFL) << 48;
            }
            case 14: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer11 = this.mixer;
                mixer11.b += (byteBuffer.get(13) & 0xFFL) << 40;
            }
            case 13: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer12 = this.mixer;
                mixer12.b += (byteBuffer.get(12) & 0xFFL) << 32;
            }
            case 12: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer13 = this.mixer;
                mixer13.b += (byteBuffer.get(11) & 0xFFL) << 24;
            }
            case 11: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer14 = this.mixer;
                mixer14.b += (byteBuffer.get(10) & 0xFFL) << 16;
            }
            case 10: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer15 = this.mixer;
                mixer15.b += (byteBuffer.get(9) & 0xFFL) << 8;
            }
            case 9: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer16 = this.mixer;
                mixer16.b += (byteBuffer.get(8) & 0xFFL);
            }
            case 8: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer17 = this.mixer;
                mixer17.a += byteBuffer.getLong();
                break;
            }
            case 7: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer18 = this.mixer;
                mixer18.a += (byteBuffer.get(6) & 0xFFL) << 48;
            }
            case 6: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer19 = this.mixer;
                mixer19.a += (byteBuffer.get(5) & 0xFFL) << 40;
            }
            case 5: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer20 = this.mixer;
                mixer20.a += (byteBuffer.get(4) & 0xFFL) << 32;
            }
            case 4: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer21 = this.mixer;
                mixer21.a += (byteBuffer.get(3) & 0xFFL) << 24;
            }
            case 3: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer22 = this.mixer;
                mixer22.a += (byteBuffer.get(2) & 0xFFL) << 16;
            }
            case 2: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer23 = this.mixer;
                mixer23.a += (byteBuffer.get(1) & 0xFFL) << 8;
            }
            case 1: {
                final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer24 = this.mixer;
                mixer24.a += (byteBuffer.get(0) & 0xFFL);
                break;
            }
            default: {
                throw new AssertionError((Object)"Should never get here.");
            }
        }
    }
    
    public HashCode makeHash() {
        final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer = this.mixer;
        mixer.c += this.length;
        return this.mixer.makeHash();
    }
}
