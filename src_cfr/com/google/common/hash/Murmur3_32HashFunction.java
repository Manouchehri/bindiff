/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Murmur3_32HashFunction$Murmur3_32Hasher;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Murmur3_32HashFunction
extends AbstractStreamingHashFunction
implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private final int seed;
    private static final long serialVersionUID = 0;

    Murmur3_32HashFunction(int n2) {
        this.seed = n2;
    }

    @Override
    public int bits() {
        return 32;
    }

    @Override
    public Hasher newHasher() {
        return new Murmur3_32HashFunction$Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        int n2 = this.seed;
        return new StringBuilder(31).append("Hashing.murmur3_32(").append(n2).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Murmur3_32HashFunction)) return false;
        Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction)object;
        if (this.seed != murmur3_32HashFunction.seed) return false;
        return true;
    }

    public int hashCode() {
        return this.getClass().hashCode() ^ this.seed;
    }

    @Override
    public HashCode hashInt(int n2) {
        int n3 = Murmur3_32HashFunction.mixK1(n2);
        int n4 = Murmur3_32HashFunction.mixH1(this.seed, n3);
        return Murmur3_32HashFunction.fmix(n4, 4);
    }

    @Override
    public HashCode hashLong(long l2) {
        int n2 = (int)l2;
        int n3 = (int)(l2 >>> 32);
        int n4 = Murmur3_32HashFunction.mixK1(n2);
        int n5 = Murmur3_32HashFunction.mixH1(this.seed, n4);
        n4 = Murmur3_32HashFunction.mixK1(n3);
        n5 = Murmur3_32HashFunction.mixH1(n5, n4);
        return Murmur3_32HashFunction.fmix(n5, 8);
    }

    @Override
    public HashCode hashString(CharSequence charSequence) {
        return this.hashUnencodedChars(charSequence);
    }

    @Override
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int n2 = this.seed;
        int n3 = 1;
        do {
            if (n3 >= charSequence.length()) {
                if ((charSequence.length() & 1) != 1) return Murmur3_32HashFunction.fmix(n2, 2 * charSequence.length());
                n3 = charSequence.charAt(charSequence.length() - 1);
                n3 = Murmur3_32HashFunction.mixK1(n3);
                n2 ^= n3;
                return Murmur3_32HashFunction.fmix(n2, 2 * charSequence.length());
            }
            int n4 = charSequence.charAt(n3 - 1) | charSequence.charAt(n3) << 16;
            n4 = Murmur3_32HashFunction.mixK1(n4);
            n2 = Murmur3_32HashFunction.mixH1(n2, n4);
            n3 += 2;
        } while (true);
    }

    private static int mixK1(int n2) {
        n2 *= -862048943;
        n2 = Integer.rotateLeft(n2, 15);
        return n2 *= 461845907;
    }

    private static int mixH1(int n2, int n3) {
        n2 ^= n3;
        n2 = Integer.rotateLeft(n2, 13);
        return n2 * 5 + -430675100;
    }

    private static HashCode fmix(int n2, int n3) {
        n2 ^= n3;
        n2 ^= n2 >>> 16;
        n2 *= -2048144789;
        n2 ^= n2 >>> 13;
        n2 *= -1028477387;
        n2 ^= n2 >>> 16;
        return HashCode.fromInt(n2);
    }

    static /* synthetic */ int access$000(int n2) {
        return Murmur3_32HashFunction.mixK1(n2);
    }

    static /* synthetic */ int access$100(int n2, int n3) {
        return Murmur3_32HashFunction.mixH1(n2, n3);
    }

    static /* synthetic */ HashCode access$200(int n2, int n3) {
        return Murmur3_32HashFunction.fmix(n2, n3);
    }
}

