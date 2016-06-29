/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

final class Hashing$LinearCongruentialGenerator {
    private long state;

    public Hashing$LinearCongruentialGenerator(long l2) {
        this.state = l2;
    }

    public double nextDouble() {
        this.state = 2862933555777941757L * this.state + 1;
        return (double)((int)(this.state >>> 33) + 1) / 2.147483648E9;
    }
}

