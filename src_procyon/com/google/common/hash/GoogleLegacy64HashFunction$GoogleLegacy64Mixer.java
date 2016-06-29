package com.google.common.hash;

final class GoogleLegacy64HashFunction$GoogleLegacy64Mixer
{
    private long a;
    private long b;
    private long c;
    
    GoogleLegacy64HashFunction$GoogleLegacy64Mixer(final long c) {
        this.a = -2266404186210603134L;
        this.b = -2266404186210603134L;
        this.c = c;
    }
    
    HashCode makeHash() {
        return HashCode.fromLong(this.mix());
    }
    
    private long mix() {
        this.a -= this.b;
        this.a -= this.c;
        this.a ^= this.c >>> 43;
        this.b -= this.c;
        this.b -= this.a;
        this.b ^= this.a << 9;
        this.c -= this.a;
        this.c -= this.b;
        this.c ^= this.b >>> 8;
        this.a -= this.b;
        this.a -= this.c;
        this.a ^= this.c >>> 38;
        this.b -= this.c;
        this.b -= this.a;
        this.b ^= this.a << 23;
        this.c -= this.a;
        this.c -= this.b;
        this.c ^= this.b >>> 5;
        this.a -= this.b;
        this.a -= this.c;
        this.a ^= this.c >>> 35;
        this.b -= this.c;
        this.b -= this.a;
        this.b ^= this.a << 49;
        this.c -= this.a;
        this.c -= this.b;
        this.c ^= this.b >>> 11;
        this.a -= this.b;
        this.a -= this.c;
        this.a ^= this.c >>> 12;
        this.b -= this.c;
        this.b -= this.a;
        this.b ^= this.a << 18;
        this.c -= this.a;
        this.c -= this.b;
        return this.c ^= this.b >>> 22;
    }
}
