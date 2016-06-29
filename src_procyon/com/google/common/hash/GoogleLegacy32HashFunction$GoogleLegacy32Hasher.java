package com.google.common.hash;

import java.nio.*;
import com.google.common.primitives.*;

final class GoogleLegacy32HashFunction$GoogleLegacy32Hasher extends AbstractStreamingHashFunction$AbstractStreamingHasher
{
    private static final int CHUNK_SIZE = 12;
    private final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer;
    private final GoogleLegacy32HashFunction$FingerprintStrategy fingerprintStrategy;
    private int length;
    
    private GoogleLegacy32HashFunction$GoogleLegacy32Hasher(final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer, final GoogleLegacy32HashFunction$FingerprintStrategy fingerprintStrategy) {
        super(12);
        this.length = 0;
        this.mixer = mixer;
        this.fingerprintStrategy = fingerprintStrategy;
    }
    
    @Override
    protected void process(final ByteBuffer byteBuffer) {
        this.length += 12;
        final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer = this.mixer;
        mixer.a += this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt());
        final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer2 = this.mixer;
        mixer2.b += this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt());
        final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer3 = this.mixer;
        mixer3.c += this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt());
        this.mixer.mix();
    }
    
    @Override
    protected void processRemaining(final ByteBuffer byteBuffer) {
        this.length += byteBuffer.remaining();
        switch (byteBuffer.remaining()) {
            case 11: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer = this.mixer;
                mixer.c += byteBuffer.get(10) << 24;
            }
            case 10: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer2 = this.mixer;
                mixer2.c += UnsignedBytes.toInt(byteBuffer.get(9)) << 16;
            }
            case 9: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer3 = this.mixer;
                mixer3.c += UnsignedBytes.toInt(byteBuffer.get(8)) << 8;
            }
            case 8: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer4 = this.mixer;
                mixer4.a += this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt());
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer5 = this.mixer;
                mixer5.b += this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt());
                break;
            }
            case 7: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer6 = this.mixer;
                mixer6.b += UnsignedBytes.toInt(byteBuffer.get(6)) << 16;
            }
            case 6: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer7 = this.mixer;
                mixer7.b += UnsignedBytes.toInt(byteBuffer.get(5)) << 8;
            }
            case 5: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer8 = this.mixer;
                mixer8.b += UnsignedBytes.toInt(byteBuffer.get(4));
            }
            case 4: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer9 = this.mixer;
                mixer9.a += this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt());
                break;
            }
            case 3: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer10 = this.mixer;
                mixer10.a += UnsignedBytes.toInt(byteBuffer.get(2)) << 16;
            }
            case 2: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer11 = this.mixer;
                mixer11.a += UnsignedBytes.toInt(byteBuffer.get(1)) << 8;
            }
            case 1: {
                final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer12 = this.mixer;
                mixer12.a += UnsignedBytes.toInt(byteBuffer.get(0));
                break;
            }
            default: {
                throw new AssertionError((Object)"Should never get here.");
            }
        }
    }
    
    public HashCode makeHash() {
        final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer = this.mixer;
        mixer.c += this.length;
        return this.mixer.makeHash();
    }
}
