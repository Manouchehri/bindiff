/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashCode;

final class GoogleLegacy32HashFunction$GoogleLegacy32Mixer {
    private int a = -1640531527;
    private int b = -1640531527;
    private int c;

    GoogleLegacy32HashFunction$GoogleLegacy32Mixer(int n2) {
        this.c = n2;
    }

    HashCode makeHash() {
        return HashCode.fromInt(this.mix());
    }

    private int mix() {
        this.a -= this.b;
        this.a -= this.c;
        this.a ^= this.c >>> 13;
        this.b -= this.c;
        this.b -= this.a;
        this.b ^= this.a << 8;
        this.c -= this.a;
        this.c -= this.b;
        this.c ^= this.b >>> 13;
        this.a -= this.b;
        this.a -= this.c;
        this.a ^= this.c >>> 12;
        this.b -= this.c;
        this.b -= this.a;
        this.b ^= this.a << 16;
        this.c -= this.a;
        this.c -= this.b;
        this.c ^= this.b >>> 5;
        this.a -= this.b;
        this.a -= this.c;
        this.a ^= this.c >>> 3;
        this.b -= this.c;
        this.b -= this.a;
        this.b ^= this.a << 10;
        this.c -= this.a;
        this.c -= this.b;
        this.c ^= this.b >>> 15;
        return this.c;
    }

    static /* synthetic */ int access$200(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer) {
        return googleLegacy32HashFunction$GoogleLegacy32Mixer.a;
    }

    static /* synthetic */ int access$202(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer, int n2) {
        googleLegacy32HashFunction$GoogleLegacy32Mixer.a = n2;
        return googleLegacy32HashFunction$GoogleLegacy32Mixer.a;
    }

    static /* synthetic */ int access$300(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer) {
        return googleLegacy32HashFunction$GoogleLegacy32Mixer.b;
    }

    static /* synthetic */ int access$302(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer, int n2) {
        googleLegacy32HashFunction$GoogleLegacy32Mixer.b = n2;
        return googleLegacy32HashFunction$GoogleLegacy32Mixer.b;
    }

    static /* synthetic */ int access$400(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer) {
        return googleLegacy32HashFunction$GoogleLegacy32Mixer.c;
    }

    static /* synthetic */ int access$402(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer, int n2) {
        googleLegacy32HashFunction$GoogleLegacy32Mixer.c = n2;
        return googleLegacy32HashFunction$GoogleLegacy32Mixer.c;
    }

    static /* synthetic */ int access$500(GoogleLegacy32HashFunction$GoogleLegacy32Mixer googleLegacy32HashFunction$GoogleLegacy32Mixer) {
        return googleLegacy32HashFunction$GoogleLegacy32Mixer.mix();
    }
}

