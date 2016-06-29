/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction$AbstractStreamingHasher;
import com.google.common.hash.GoogleLegacy64HashFunction$1;
import com.google.common.hash.GoogleLegacy64HashFunction$GoogleLegacy64Mixer;
import com.google.common.hash.HashCode;
import java.nio.ByteBuffer;

final class GoogleLegacy64HashFunction$GoogleLegacy64Hasher
extends AbstractStreamingHashFunction$AbstractStreamingHasher {
    private static final int CHUNK_SIZE = 24;
    private final GoogleLegacy64HashFunction$GoogleLegacy64Mixer mixer;
    private int length = 0;

    private GoogleLegacy64HashFunction$GoogleLegacy64Hasher(GoogleLegacy64HashFunction$GoogleLegacy64Mixer googleLegacy64Mixer) {
        super(24);
        this.mixer = googleLegacy64Mixer;
    }

    @Override
    protected void process(ByteBuffer byteBuffer) {
        this.length += 24;
        GoogleLegacy64HashFunction$GoogleLegacy64Mixer googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
        GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + byteBuffer.getLong());
        googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
        GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer) + byteBuffer.getLong());
        googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
        GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer) + byteBuffer.getLong());
        GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$400(this.mixer);
    }

    @Override
    protected void processRemaining(ByteBuffer byteBuffer) {
        this.length += byteBuffer.remaining();
        switch (byteBuffer.remaining()) {
            GoogleLegacy64HashFunction$GoogleLegacy64Mixer googleLegacy64HashFunction$GoogleLegacy64Mixer;
            GoogleLegacy64HashFunction$GoogleLegacy64Mixer googleLegacy64HashFunction$GoogleLegacy64Mixer2;
            GoogleLegacy64HashFunction$GoogleLegacy64Mixer googleLegacy64HashFunction$GoogleLegacy64Mixer3;
            case 23: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + ((long)byteBuffer.get(22) << 56));
            }
            case 22: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + (((long)byteBuffer.get(21) & 255) << 48));
            }
            case 21: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + (((long)byteBuffer.get(20) & 255) << 40));
            }
            case 20: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + (((long)byteBuffer.get(19) & 255) << 32));
            }
            case 19: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + (((long)byteBuffer.get(18) & 255) << 24));
            }
            case 18: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + (((long)byteBuffer.get(17) & 255) << 16));
            }
            case 17: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + (((long)byteBuffer.get(16) & 255) << 8));
            }
            case 16: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + byteBuffer.getLong());
                googleLegacy64HashFunction$GoogleLegacy64Mixer3 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer3, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer3) + byteBuffer.getLong());
                return;
            }
            case 15: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + (((long)byteBuffer.get(14) & 255) << 48));
            }
            case 14: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + (((long)byteBuffer.get(13) & 255) << 40));
            }
            case 13: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + (((long)byteBuffer.get(12) & 255) << 32));
            }
            case 12: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + (((long)byteBuffer.get(11) & 255) << 24));
            }
            case 11: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + (((long)byteBuffer.get(10) & 255) << 16));
            }
            case 10: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + (((long)byteBuffer.get(9) & 255) << 8));
            }
            case 9: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$202(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$200(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + ((long)byteBuffer.get(8) & 255));
            }
            case 8: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer2 = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer2, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer2) + byteBuffer.getLong());
                return;
            }
            case 7: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + (((long)byteBuffer.get(6) & 255) << 48));
            }
            case 6: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + (((long)byteBuffer.get(5) & 255) << 40));
            }
            case 5: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + (((long)byteBuffer.get(4) & 255) << 32));
            }
            case 4: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + (((long)byteBuffer.get(3) & 255) << 24));
            }
            case 3: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + (((long)byteBuffer.get(2) & 255) << 16));
            }
            case 2: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + (((long)byteBuffer.get(1) & 255) << 8));
            }
            case 1: {
                googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
                GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$102(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$100(googleLegacy64HashFunction$GoogleLegacy64Mixer) + ((long)byteBuffer.get(0) & 255));
                return;
            }
        }
        throw new AssertionError((Object)"Should never get here.");
    }

    @Override
    public HashCode makeHash() {
        GoogleLegacy64HashFunction$GoogleLegacy64Mixer googleLegacy64HashFunction$GoogleLegacy64Mixer = this.mixer;
        GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$302(googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$GoogleLegacy64Mixer.access$300(googleLegacy64HashFunction$GoogleLegacy64Mixer) + (long)this.length);
        return this.mixer.makeHash();
    }

    /* synthetic */ GoogleLegacy64HashFunction$GoogleLegacy64Hasher(GoogleLegacy64HashFunction$GoogleLegacy64Mixer googleLegacy64HashFunction$GoogleLegacy64Mixer, GoogleLegacy64HashFunction$1 googleLegacy64HashFunction$1) {
        this(googleLegacy64HashFunction$GoogleLegacy64Mixer);
    }
}

