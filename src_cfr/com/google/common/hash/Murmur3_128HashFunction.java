/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Murmur3_128HashFunction$Murmur3_128Hasher;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Murmur3_128HashFunction
extends AbstractStreamingHashFunction
implements Serializable {
    private final int seed;
    private static final long serialVersionUID = 0;

    Murmur3_128HashFunction(int n2) {
        this.seed = n2;
    }

    @Override
    public int bits() {
        return 128;
    }

    @Override
    public Hasher newHasher() {
        return new Murmur3_128HashFunction$Murmur3_128Hasher(this.seed);
    }

    public String toString() {
        int n2 = this.seed;
        return new StringBuilder(32).append("Hashing.murmur3_128(").append(n2).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Murmur3_128HashFunction)) return false;
        Murmur3_128HashFunction murmur3_128HashFunction = (Murmur3_128HashFunction)object;
        if (this.seed != murmur3_128HashFunction.seed) return false;
        return true;
    }

    public int hashCode() {
        return this.getClass().hashCode() ^ this.seed;
    }
}

