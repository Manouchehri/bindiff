/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.GoogleLegacy32HashFunction$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;
import com.google.common.hash.GoogleLegacy32HashFunction$GoogleLegacy32Mixer;
import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;

final class GoogleLegacy32HashFunction$GoogleLegacy32Hasher
extends AbstractStreamingHashFunction$AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 12;
    private final GoogleLegacy32HashFunction$GoogleLegacy32Mixer mixer;
    private final GoogleLegacy32HashFunction$FingerprintStrategy fingerprintStrategy;
    private int length = 0;

    private GoogleLegacy32HashFunction$GoogleLegacy32Hasher(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32Mixer, GoogleLegacy32HashFunction$FingerprintStrategy googleLegacy32HashFunction$FingerprintStrategy) {
        super(12);
        this.mixer = googleLegacy32Mixer;
        this.fingerprintStrategy = googleLegacy32HashFunction$FingerprintStrategy;
    }

    @Override
    protected void process(ByteBuffer byteBuffer) {
        this.length += 12;
        GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer = this.mixer;
        GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(googleLegacy32HashFunction$GoogleLegacy32Mixer) + this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt()));
        googleLegacy32HashFunction$GoogleLegacy32Mixer = this.mixer;
        GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(googleLegacy32HashFunction$GoogleLegacy32Mixer) + this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt()));
        googleLegacy32HashFunction$GoogleLegacy32Mixer = this.mixer;
        GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(googleLegacy32HashFunction$GoogleLegacy32Mixer) + this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt()));
        GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$500(this.mixer);
    }

    @Override
    protected void processRemaining(ByteBuffer byteBuffer) {
        this.length += byteBuffer.remaining();
        switch (byteBuffer.remaining()) {
            GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer;
            GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer2;
            GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer3;
            case 11: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer3 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(googleLegacy32HashFunction$GoogleLegacy32Mixer3, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(googleLegacy32HashFunction$GoogleLegacy32Mixer3) + (byteBuffer.get(10) << 24));
            }
            case 10: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer3 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(googleLegacy32HashFunction$GoogleLegacy32Mixer3, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(googleLegacy32HashFunction$GoogleLegacy32Mixer3) + (UnsignedBytes.toInt(byteBuffer.get(9)) << 16));
            }
            case 9: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer3 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(googleLegacy32HashFunction$GoogleLegacy32Mixer3, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(googleLegacy32HashFunction$GoogleLegacy32Mixer3) + (UnsignedBytes.toInt(byteBuffer.get(8)) << 8));
            }
            case 8: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer3 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(googleLegacy32HashFunction$GoogleLegacy32Mixer3, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(googleLegacy32HashFunction$GoogleLegacy32Mixer3) + this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt()));
                googleLegacy32HashFunction$GoogleLegacy32Mixer3 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(googleLegacy32HashFunction$GoogleLegacy32Mixer3, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(googleLegacy32HashFunction$GoogleLegacy32Mixer3) + this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt()));
                return;
            }
            case 7: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer2 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(googleLegacy32HashFunction$GoogleLegacy32Mixer2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(googleLegacy32HashFunction$GoogleLegacy32Mixer2) + (UnsignedBytes.toInt(byteBuffer.get(6)) << 16));
            }
            case 6: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer2 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(googleLegacy32HashFunction$GoogleLegacy32Mixer2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(googleLegacy32HashFunction$GoogleLegacy32Mixer2) + (UnsignedBytes.toInt(byteBuffer.get(5)) << 8));
            }
            case 5: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer2 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$302(googleLegacy32HashFunction$GoogleLegacy32Mixer2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$300(googleLegacy32HashFunction$GoogleLegacy32Mixer2) + UnsignedBytes.toInt(byteBuffer.get(4)));
            }
            case 4: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer2 = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(googleLegacy32HashFunction$GoogleLegacy32Mixer2, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(googleLegacy32HashFunction$GoogleLegacy32Mixer2) + this.fingerprintStrategy.maybeAddSignCruft(byteBuffer.getInt()));
                return;
            }
            case 3: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(googleLegacy32HashFunction$GoogleLegacy32Mixer) + (UnsignedBytes.toInt(byteBuffer.get(2)) << 16));
            }
            case 2: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(googleLegacy32HashFunction$GoogleLegacy32Mixer) + (UnsignedBytes.toInt(byteBuffer.get(1)) << 8));
            }
            case 1: {
                googleLegacy32HashFunction$GoogleLegacy32Mixer = this.mixer;
                GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$202(googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$200(googleLegacy32HashFunction$GoogleLegacy32Mixer) + UnsignedBytes.toInt(byteBuffer.get(0)));
                return;
            }
        }
        throw new AssertionError((Object)"Should never get here.");
    }

    @Override
    public HashCode makeHash() {
        GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer = this.mixer;
        GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$402(googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$GoogleLegacy32Mixer.access$400(googleLegacy32HashFunction$GoogleLegacy32Mixer) + this.length);
        return this.mixer.makeHash();
    }

    /* synthetic */ GoogleLegacy32HashFunction$GoogleLegacy32Hasher(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer, GoogleLegacy32HashFunction$FingerprintStrategy googleLegacy32HashFunction$FingerprintStrategy, GoogleLegacy32HashFunction$1 googleLegacy32HashFunction$1) {
        this(googleLegacy32HashFunction$GoogleLegacy32Mixer, googleLegacy32HashFunction$FingerprintStrategy);
    }
}

