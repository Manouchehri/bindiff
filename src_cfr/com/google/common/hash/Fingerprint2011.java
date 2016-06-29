/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.hash.AbstractNonStreamingHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.LittleEndianByteArray;
import java.nio.charset.Charset;

@GoogleInternal
final class Fingerprint2011
extends AbstractNonStreamingHashFunction {
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4132994306676758123L;

    Fingerprint2011() {
    }

    @Override
    public HashCode hashBytes(byte[] arrby) {
        return HashCode.fromLong(Fingerprint2011.fingerprint(arrby, 0, arrby.length));
    }

    @Override
    public HashCode hashBytes(byte[] arrby, int n2, int n3) {
        if (n3 < 0) throw new IndexOutOfBoundsException();
        if (n2 < 0) throw new IndexOutOfBoundsException();
        if (n2 + n3 <= arrby.length) return HashCode.fromLong(Fingerprint2011.fingerprint(arrby, n2, n3));
        throw new IndexOutOfBoundsException();
    }

    @Override
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return this.hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override
    public HashCode hashLong(long l2) {
        return this.newHasher(8).putLong(l2).hash();
    }

    @Override
    public HashCode hashInt(int n2) {
        return this.newHasher(4).putInt(n2).hash();
    }

    @Override
    public int bits() {
        return 64;
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }

    @VisibleForTesting
    static long fingerprint(byte[] arrby, int n2, int n3) {
        long l2;
        long l3;
        long l4 = n3 <= 32 ? Fingerprint2011.murmurHash64WithSeed(arrby, n2, n3, -1397348546323613475L) : (n3 <= 64 ? Fingerprint2011.hashLength33To64(arrby, n2, n3) : Fingerprint2011.fullFingerprint(arrby, n2, n3));
        long l5 = n3 >= 9 ? LittleEndianByteArray.load64(arrby, n2 + n3 - 8) : -6505348102511208375L;
        if ((l4 = Fingerprint2011.hash128to64(l4 + l5, l3 = n3 >= 8 ? LittleEndianByteArray.load64(arrby, n2) : -6505348102511208375L)) != 0 && l4 != 1) {
            l2 = l4;
            return l2;
        }
        l2 = l4 + -2;
        return l2;
    }

    private static long shiftMix(long l2) {
        return l2 ^ l2 >>> 47;
    }

    @VisibleForTesting
    static long hash128to64(long l2, long l3) {
        long l4 = (l3 ^ l2) * -4132994306676758123L;
        l4 ^= l4 >>> 47;
        long l5 = (l2 ^ l4) * -4132994306676758123L;
        l5 ^= l5 >>> 47;
        return l5 *= -4132994306676758123L;
    }

    private static void weakHashLength32WithSeeds(byte[] arrby, int n2, long l2, long l3, long[] arrl) {
        long l4 = LittleEndianByteArray.load64(arrby, n2);
        long l5 = LittleEndianByteArray.load64(arrby, n2 + 8);
        long l6 = LittleEndianByteArray.load64(arrby, n2 + 16);
        long l7 = LittleEndianByteArray.load64(arrby, n2 + 24);
        l3 = Long.rotateRight(l3 + (l2 += l4) + l7, 51);
        long l8 = l2;
        l2 += l5;
        arrl[0] = l2 + l7;
        arrl[1] = (l3 += Long.rotateRight(l2 += l6, 23)) + l8;
    }

    private static long fullFingerprint(byte[] arrby, int n2, int n3) {
        long l2 = LittleEndianByteArray.load64(arrby, n2);
        long l3 = LittleEndianByteArray.load64(arrby, n2 + n3 - 16) ^ -8261664234251669945L;
        long l4 = LittleEndianByteArray.load64(arrby, n2 + n3 - 56) ^ -6505348102511208375L;
        long[] arrl = new long[2];
        long[] arrl2 = new long[2];
        Fingerprint2011.weakHashLength32WithSeeds(arrby, n2 + n3 - 64, n3, l3, arrl);
        Fingerprint2011.weakHashLength32WithSeeds(arrby, n2 + n3 - 32, (long)n3 * -8261664234251669945L, -6505348102511208375L, arrl2);
        l2 = Long.rotateRight((l4 += Fingerprint2011.shiftMix(arrl[1]) * -8261664234251669945L) + l2, 39) * -8261664234251669945L;
        l3 = Long.rotateRight(l3, 33) * -8261664234251669945L;
        n3 = n3 - 1 & -64;
        do {
            l2 = Long.rotateRight(l2 + l3 + arrl[0] + LittleEndianByteArray.load64(arrby, n2 + 16), 37) * -8261664234251669945L;
            l3 = Long.rotateRight(l3 + arrl[1] + LittleEndianByteArray.load64(arrby, n2 + 48), 42) * -8261664234251669945L;
            l4 = Long.rotateRight(l4 ^ arrl2[0], 33);
            Fingerprint2011.weakHashLength32WithSeeds(arrby, n2, arrl[1] * -8261664234251669945L, (l2 ^= arrl2[1]) + arrl2[0], arrl);
            Fingerprint2011.weakHashLength32WithSeeds(arrby, n2 + 32, l4 + arrl2[1], l3 ^= arrl[0], arrl2);
            long l5 = l4;
            l4 = l2;
            l2 = l5;
            n2 += 64;
        } while ((n3 -= 64) != 0);
        return Fingerprint2011.hash128to64(Fingerprint2011.hash128to64(arrl[0], arrl2[0]) + Fingerprint2011.shiftMix(l3) * -8261664234251669945L + l4, Fingerprint2011.hash128to64(arrl[1], arrl2[1]) + l2);
    }

    private static long hashLength33To64(byte[] arrby, int n2, int n3) {
        long l2 = LittleEndianByteArray.load64(arrby, n2 + 24);
        long l3 = LittleEndianByteArray.load64(arrby, n2) + ((long)n3 + LittleEndianByteArray.load64(arrby, n2 + n3 - 16)) * -6505348102511208375L;
        long l4 = Long.rotateRight(l3 + l2, 52);
        long l5 = Long.rotateRight(l3, 37);
        long l6 = (l3 += LittleEndianByteArray.load64(arrby, n2 + 16)) + l2;
        long l7 = l4 + Long.rotateRight(l3, 31) + (l5 += Long.rotateRight(l3 += LittleEndianByteArray.load64(arrby, n2 + 8), 7));
        l3 = LittleEndianByteArray.load64(arrby, n2 + 16) + LittleEndianByteArray.load64(arrby, n2 + n3 - 32);
        l2 = LittleEndianByteArray.load64(arrby, n2 + n3 - 8);
        l4 = Long.rotateRight(l3 + l2, 52);
        l5 = Long.rotateRight(l3, 37);
        long l8 = (l3 += LittleEndianByteArray.load64(arrby, n2 + n3 - 16)) + l2;
        long l9 = l4 + Long.rotateRight(l3, 31) + (l5 += Long.rotateRight(l3 += LittleEndianByteArray.load64(arrby, n2 + n3 - 24), 7));
        long l10 = Fingerprint2011.shiftMix((l6 + l9) * -4288712594273399085L + (l8 + l7) * -6505348102511208375L);
        return Fingerprint2011.shiftMix(l10 * -6505348102511208375L + l7) * -4288712594273399085L;
    }

    @VisibleForTesting
    static long murmurHash64WithSeed(byte[] arrby, int n2, int n3, long l2) {
        int n4 = n3 & -8;
        int n5 = n3 & 7;
        long l3 = l2 ^ (long)n3 * -4132994306676758123L;
        for (int i2 = 0; i2 < n4; l3 *= -4132994306676758123L, i2 += 8) {
            long l4 = LittleEndianByteArray.load64(arrby, n2 + i2);
            long l5 = Fingerprint2011.shiftMix(l4 * -4132994306676758123L) * -4132994306676758123L;
            l3 ^= l5;
        }
        if (n5 != 0) {
            long l6 = LittleEndianByteArray.load64Safely(arrby, n2 + n4, n5);
            l3 ^= l6;
            l3 *= -4132994306676758123L;
        }
        l3 = Fingerprint2011.shiftMix(l3) * -4132994306676758123L;
        return Fingerprint2011.shiftMix(l3);
    }
}

