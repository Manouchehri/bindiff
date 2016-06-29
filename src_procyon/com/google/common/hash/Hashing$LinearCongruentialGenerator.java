package com.google.common.hash;

final class Hashing$LinearCongruentialGenerator
{
    private long state;
    
    public Hashing$LinearCongruentialGenerator(final long state) {
        this.state = state;
    }
    
    public double nextDouble() {
        this.state = 2862933555777941757L * this.state + 1L;
        return ((int)(this.state >>> 33) + 1) / 2.147483648E9;
    }
}
