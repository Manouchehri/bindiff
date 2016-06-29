package com.google.common.hash;

final class GoogleLegacy32HashFunction$GoogleLegacy32Mixer
{
    private int a;
    private int b;
    private int c;
    
    GoogleLegacy32HashFunction$GoogleLegacy32Mixer(final int c) {
        this.a = -1640531527;
        this.b = -1640531527;
        this.c = c;
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
        return this.c ^= this.b >>> 15;
    }
}
