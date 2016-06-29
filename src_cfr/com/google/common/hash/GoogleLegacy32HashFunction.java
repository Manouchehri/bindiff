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
import com.google.common.hash.GoogleLegacy32HashFunction$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;
import com.google.common.hash.GoogleLegacy32HashFunction$GoogleLegacy32Hasher;
import com.google.common.hash.GoogleLegacy32HashFunction$GoogleLegacy32Mixer;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

@GoogleInternal
final class GoogleLegacy32HashFunction
extends AbstractStreamingHashFunction {
    private final int seed;
    private final GoogleLegacy32HashFunction$FingerprintStrategy fingerprintStrategy;

    GoogleLegacy32HashFunction(int n2, GoogleLegacy32HashFunction$FingerprintStrategy googleLegacy32HashFunction$FingerprintStrategy) {
        this.seed = n2;
        this.fingerprintStrategy = (GoogleLegacy32HashFunction$FingerprintStrategy)((Object)Preconditions.checkNotNull((Object)googleLegacy32HashFunction$FingerprintStrategy));
    }

    @Override
    public int bits() {
        return 32;
    }

    @Override
    public Hasher newHasher() {
        return new GoogleLegacy32HashFunction$GoogleLegacy32Hasher(new GoogleLegacy32HashFunction$GoogleLegacy32Mixer(this.seed), this.fingerprintStrategy, null);
    }

    public String toString() {
        int n2 = this.seed;
        return new StringBuilder(39).append("LegacyHashing.googleHash32(").append(n2).append(")").toString();
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof GoogleLegacy32HashFunction)) return false;
        GoogleLegacy32HashFunction googleLegacy32HashFunction = (GoogleLegacy32HashFunction)object;
        if (this.seed != googleLegacy32HashFunction.seed) return false;
        if (this.fingerprintStrategy != googleLegacy32HashFunction.fingerprintStrategy) return false;
        return true;
    }

    public int hashCode() {
        return this.seed ^ this.fingerprintStrategy.hashCode() ^ this.getClass().hashCode();
    }

    @Override
    public HashCode hashLong(long l2) {
        int n2 = -1640531527 + (byte)l2 + ((byte)(l2 >> 8) << 8) + ((byte)(l2 >> 16) << 16) + ((byte)(l2 >> 24) << 24);
        int n3 = -1640531527 + (byte)(l2 >> 32) + ((byte)(l2 >> 40) << 8) + ((byte)(l2 >> 48) << 16) + ((byte)(l2 >> 56) << 24);
        return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n2, n3, this.seed + 8));
    }

    @Override
    public HashCode hashInt(int n2) {
        int n3 = -1640531527 + (byte)n2 + ((byte)(n2 >> 8) << 8) + ((byte)(n2 >> 16) << 16) + ((byte)(n2 >> 24) << 24);
        return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n3, -1640531527, this.seed + 4));
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
        int n5 = -1640531527;
        int n6 = -1640531527;
        int n7 = this.seed;
        for (n4 = n3; n4 >= 12; n5 -= (n7 ^= n6 >>> 5), n6 -= (n5 ^= n7 >>> 3), n7 ^= n6 >>> 15, n4 -= 12, n2 += 12) {
            n5 += this.fingerprintStrategy.word32At(arrby, n2);
            n5 -= (n6 += this.fingerprintStrategy.word32At(arrby, n2 + 4));
            n5 -= (n7 += this.fingerprintStrategy.word32At(arrby, n2 + 8));
            n6 -= n7;
            n6 -= (n5 ^= n7 >>> 13);
            n7 -= n5;
            n7 -= (n6 ^= n5 << 8);
            n5 -= n6;
            n5 -= (n7 ^= n6 >>> 13);
            n6 -= n7;
            n6 -= (n5 ^= n7 >>> 12);
            n7 -= n5;
            n7 -= (n6 ^= n5 << 16);
            n5 -= n6;
            n6 -= n7;
            n7 -= n5;
            n7 -= (n6 ^= n5 << 10);
        }
        n7 += n3;
        switch (n4) {
            case 11: {
                n7 += arrby[n2 + 10] << 24;
            }
            case 10: {
                n7 += (arrby[n2 + 9] & 255) << 16;
            }
            case 9: {
                n7 += (arrby[n2 + 8] & 255) << 8;
            }
            case 8: {
                return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n5 += this.fingerprintStrategy.word32At(arrby, n2), n6 += this.fingerprintStrategy.word32At(arrby, n2 + 4), n7));
            }
            case 7: {
                n6 += (arrby[n2 + 6] & 255) << 16;
            }
            case 6: {
                n6 += (arrby[n2 + 5] & 255) << 8;
            }
            case 5: {
                n6 += arrby[n2 + 4] & 255;
            }
            case 4: {
                return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n5 += this.fingerprintStrategy.word32At(arrby, n2), n6, n7));
            }
            case 3: {
                n5 += (arrby[n2 + 2] & 255) << 16;
            }
            case 2: {
                n5 += (arrby[n2 + 1] & 255) << 8;
            }
            case 1: {
                n5 += arrby[n2 + 0] & 255;
            }
            case 0: {
                return HashCode.fromInt(GoogleLegacy32HashFunction.mix32(n5, n6, n7));
            }
        }
        throw new AssertionError();
    }

    static int mix32(int n2, int n3, int n4) {
        n2 -= n3;
        n2 -= n4;
        n3 -= n4;
        n3 -= (n2 ^= n4 >>> 13);
        n4 -= n2;
        n4 -= (n3 ^= n2 << 8);
        n2 -= n3;
        n2 -= (n4 ^= n3 >>> 13);
        n3 -= n4;
        n3 -= (n2 ^= n4 >>> 12);
        n4 -= n2;
        n4 -= (n3 ^= n2 << 16);
        n2 -= n3;
        n2 -= (n4 ^= n3 >>> 5);
        n3 -= n4;
        n3 -= (n2 ^= n4 >>> 3);
        n4 -= n2;
        n4 -= (n3 ^= n2 << 10);
        return n4 ^= n3 >>> 15;
    }
}

