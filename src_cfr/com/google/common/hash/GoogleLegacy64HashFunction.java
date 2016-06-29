/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.GoogleLegacy64HashFunction$1;
import com.google.common.hash.GoogleLegacy64HashFunction$GoogleLegacy64Hasher;
import com.google.common.hash.GoogleLegacy64HashFunction$GoogleLegacy64Mixer;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

@GoogleInternal
final class GoogleLegacy64HashFunction
extends AbstractStreamingHashFunction {
    private final long seed;

    GoogleLegacy64HashFunction(long l2) {
        this.seed = l2;
    }

    @Override
    public int bits() {
        return 64;
    }

    @Override
    public Hasher newHasher() {
        return new GoogleLegacy64HashFunction$GoogleLegacy64Hasher(new GoogleLegacy64HashFunction$GoogleLegacy64Mixer(this.seed), null);
    }

    public String toString() {
        long l2 = this.seed;
        return new StringBuilder(48).append("LegacyHashing.googleHash64(").append(l2).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof GoogleLegacy64HashFunction)) return false;
        GoogleLegacy64HashFunction googleLegacy64HashFunction = (GoogleLegacy64HashFunction)object;
        if (this.seed != googleLegacy64HashFunction.seed) return false;
        return true;
    }

    public int hashCode() {
        return (int)(this.seed ^ (long)this.getClass().hashCode());
    }

    @Override
    public HashCode hashLong(long l2) {
        long l3 = -2266404186210603134L + (l2 & 255) + (l2 & 65280) + (l2 & 0xFF0000) + (l2 & 0xFF000000L) + (l2 & 0xFF00000000L) + (l2 & 0xFF0000000000L) + (l2 & 0xFF000000000000L) + (l2 & -72057594037927936L);
        return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l3, -2266404186210603134L, this.seed + 8));
    }

    @Override
    public HashCode hashInt(int n2) {
        long l2 = -2266404186210603134L + ((long)n2 & 255) + ((long)n2 & 65280) + ((long)n2 & 0xFF0000) + ((long)n2 & 0xFF000000L);
        return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2, -2266404186210603134L, this.seed + 4));
    }

    @Override
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return this.hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override
    public HashCode hashBytes(byte[] arrby) {
        return this.hashBytes(arrby, 0, arrby.length);
    }

    @Override
    public HashCode hashBytes(byte[] arrby, int n2, int n3) {
        int n4;
        Preconditions.checkPositionIndexes(n2, n2 + n3, arrby.length);
        long l2 = -2266404186210603134L;
        long l3 = -2266404186210603134L;
        long l4 = this.seed;
        for (n4 = n3; n4 >= 24; l2 -= (l4 ^= l3 >>> 11), l3 -= (l2 ^= l4 >>> 12), l4 ^= l3 >>> 22, n4 -= 24, n2 += 24) {
            l2 += GoogleLegacy64HashFunction.word64At(arrby, n2);
            l2 -= (l3 += GoogleLegacy64HashFunction.word64At(arrby, n2 + 8));
            l2 -= (l4 += GoogleLegacy64HashFunction.word64At(arrby, n2 + 16));
            l3 -= l4;
            l3 -= (l2 ^= l4 >>> 43);
            l4 -= l2;
            l4 -= (l3 ^= l2 << 9);
            l2 -= l3;
            l2 -= (l4 ^= l3 >>> 8);
            l3 -= l4;
            l3 -= (l2 ^= l4 >>> 38);
            l4 -= l2;
            l4 -= (l3 ^= l2 << 23);
            l2 -= l3;
            l2 -= (l4 ^= l3 >>> 5);
            l3 -= l4;
            l3 -= (l2 ^= l4 >>> 35);
            l4 -= l2;
            l4 -= (l3 ^= l2 << 49);
            l2 -= l3;
            l3 -= l4;
            l4 -= l2;
            l4 -= (l3 ^= l2 << 18);
        }
        l4 += (long)n3;
        switch (n4) {
            case 23: {
                l4 += (long)arrby[n2 + 22] << 56;
            }
            case 22: {
                l4 += ((long)arrby[n2 + 21] & 255) << 48;
            }
            case 21: {
                l4 += ((long)arrby[n2 + 20] & 255) << 40;
            }
            case 20: {
                l4 += ((long)arrby[n2 + 19] & 255) << 32;
            }
            case 19: {
                l4 += ((long)arrby[n2 + 18] & 255) << 24;
            }
            case 18: {
                l4 += ((long)arrby[n2 + 17] & 255) << 16;
            }
            case 17: {
                l4 += ((long)arrby[n2 + 16] & 255) << 8;
            }
            case 16: {
                return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2 += GoogleLegacy64HashFunction.word64At(arrby, n2), l3 += GoogleLegacy64HashFunction.word64At(arrby, n2 + 8), l4));
            }
            case 15: {
                l3 += ((long)arrby[n2 + 14] & 255) << 48;
            }
            case 14: {
                l3 += ((long)arrby[n2 + 13] & 255) << 40;
            }
            case 13: {
                l3 += ((long)arrby[n2 + 12] & 255) << 32;
            }
            case 12: {
                l3 += ((long)arrby[n2 + 11] & 255) << 24;
            }
            case 11: {
                l3 += ((long)arrby[n2 + 10] & 255) << 16;
            }
            case 10: {
                l3 += ((long)arrby[n2 + 9] & 255) << 8;
            }
            case 9: {
                l3 += (long)arrby[n2 + 8] & 255;
            }
            case 8: {
                return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2 += GoogleLegacy64HashFunction.word64At(arrby, n2), l3, l4));
            }
            case 7: {
                l2 += ((long)arrby[n2 + 6] & 255) << 48;
            }
            case 6: {
                l2 += ((long)arrby[n2 + 5] & 255) << 40;
            }
            case 5: {
                l2 += ((long)arrby[n2 + 4] & 255) << 32;
            }
            case 4: {
                l2 += ((long)arrby[n2 + 3] & 255) << 24;
            }
            case 3: {
                l2 += ((long)arrby[n2 + 2] & 255) << 16;
            }
            case 2: {
                l2 += ((long)arrby[n2 + 1] & 255) << 8;
            }
            case 1: {
                l2 += (long)arrby[n2 + 0] & 255;
            }
            case 0: {
                return HashCode.fromLong(GoogleLegacy64HashFunction.mix64(l2, l3, l4));
            }
        }
        throw new AssertionError();
    }

    static long mix64(long l2, long l3, long l4) {
        l2 -= l3;
        l2 -= l4;
        l3 -= l4;
        l3 -= (l2 ^= l4 >>> 43);
        l4 -= l2;
        l4 -= (l3 ^= l2 << 9);
        l2 -= l3;
        l2 -= (l4 ^= l3 >>> 8);
        l3 -= l4;
        l3 -= (l2 ^= l4 >>> 38);
        l4 -= l2;
        l4 -= (l3 ^= l2 << 23);
        l2 -= l3;
        l2 -= (l4 ^= l3 >>> 5);
        l3 -= l4;
        l3 -= (l2 ^= l4 >>> 35);
        l4 -= l2;
        l4 -= (l3 ^= l2 << 49);
        l2 -= l3;
        l2 -= (l4 ^= l3 >>> 11);
        l3 -= l4;
        l3 -= (l2 ^= l4 >>> 12);
        l4 -= l2;
        l4 -= (l3 ^= l2 << 18);
        return l4 ^= l3 >>> 22;
    }

    private static long word64At(byte[] arrby, int n2) {
        return ((long)arrby[n2 + 0] & 255) + (((long)arrby[n2 + 1] & 255) << 8) + (((long)arrby[n2 + 2] & 255) << 16) + (((long)arrby[n2 + 3] & 255) << 24) + (((long)arrby[n2 + 4] & 255) << 32) + (((long)arrby[n2 + 5] & 255) << 40) + (((long)arrby[n2 + 6] & 255) << 48) + (((long)arrby[n2 + 7] & 255) << 56);
    }
}

