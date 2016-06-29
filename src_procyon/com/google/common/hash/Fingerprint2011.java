package com.google.common.hash;

import java.nio.charset.*;
import com.google.common.annotations.*;

@GoogleInternal
final class Fingerprint2011 extends AbstractNonStreamingHashFunction
{
    private static final long K0 = -6505348102511208375L;
    private static final long K1 = -8261664234251669945L;
    private static final long K2 = -4288712594273399085L;
    private static final long K3 = -4132994306676758123L;
    
    @Override
    public HashCode hashBytes(final byte[] array) {
        return HashCode.fromLong(fingerprint(array, 0, array.length));
    }
    
    @Override
    public HashCode hashBytes(final byte[] array, final int n, final int n2) {
        if (n2 < 0 || n < 0 || n + n2 > array.length) {
            throw new IndexOutOfBoundsException();
        }
        return HashCode.fromLong(fingerprint(array, n, n2));
    }
    
    @Override
    public HashCode hashString(final CharSequence charSequence, final Charset charset) {
        return this.hashBytes(charSequence.toString().getBytes(charset));
    }
    
    @Override
    public HashCode hashLong(final long n) {
        return this.newHasher(8).putLong(n).hash();
    }
    
    @Override
    public HashCode hashInt(final int n) {
        return this.newHasher(4).putInt(n).hash();
    }
    
    @Override
    public int bits() {
        return 64;
    }
    
    @Override
    public String toString() {
        return "Hashing.fingerprint2011()";
    }
    
    @VisibleForTesting
    static long fingerprint(final byte[] array, final int n, final int n2) {
        long n3;
        if (n2 <= 32) {
            n3 = murmurHash64WithSeed(array, n, n2, -1397348546323613475L);
        }
        else if (n2 <= 64) {
            n3 = hashLength33To64(array, n, n2);
        }
        else {
            n3 = fullFingerprint(array, n, n2);
        }
        final long hash128to64 = hash128to64(n3 + ((n2 >= 9) ? LittleEndianByteArray.load64(array, n + n2 - 8) : -6505348102511208375L), (n2 >= 8) ? LittleEndianByteArray.load64(array, n) : -6505348102511208375L);
        return (hash128to64 == 0L || hash128to64 == 1L) ? (hash128to64 - 2L) : hash128to64;
    }
    
    private static long shiftMix(final long n) {
        return n ^ n >>> 47;
    }
    
    @VisibleForTesting
    static long hash128to64(final long n, final long n2) {
        final long n3 = (n2 ^ n) * -4132994306676758123L;
        final long n4 = (n ^ (n3 ^ n3 >>> 47)) * -4132994306676758123L;
        return (n4 ^ n4 >>> 47) * -4132994306676758123L;
    }
    
    private static void weakHashLength32WithSeeds(final byte[] array, final int n, long n2, long rotateRight, final long[] array2) {
        final long load64 = LittleEndianByteArray.load64(array, n);
        final long load65 = LittleEndianByteArray.load64(array, n + 8);
        final long load66 = LittleEndianByteArray.load64(array, n + 16);
        final long load67 = LittleEndianByteArray.load64(array, n + 24);
        n2 += load64;
        rotateRight = Long.rotateRight(rotateRight + n2 + load67, 51);
        final long n3 = n2;
        n2 += load65;
        n2 += load66;
        rotateRight += Long.rotateRight(n2, 23);
        array2[0] = n2 + load67;
        array2[1] = rotateRight + n3;
    }
    
    private static long fullFingerprint(final byte[] array, int n, int i) {
        final long load64 = LittleEndianByteArray.load64(array, n);
        final long n2 = LittleEndianByteArray.load64(array, n + i - 16) ^ 0x8D58AC26AFE12E47L;
        final long n3 = LittleEndianByteArray.load64(array, n + i - 56) ^ 0xA5B85C5E198ED849L;
        final long[] array2 = new long[2];
        final long[] array3 = new long[2];
        weakHashLength32WithSeeds(array, n + i - 64, i, n2, array2);
        weakHashLength32WithSeeds(array, n + i - 32, i * -8261664234251669945L, -6505348102511208375L, array3);
        long n4 = n3 + shiftMix(array2[1]) * -8261664234251669945L;
        long n5 = Long.rotateRight(n4 + load64, 39) * -8261664234251669945L;
        long n6 = Long.rotateRight(n2, 33) * -8261664234251669945L;
        i = (i - 1 & 0xFFFFFFC0);
        do {
            final long n7 = Long.rotateRight(n5 + n6 + array2[0] + LittleEndianByteArray.load64(array, n + 16), 37) * -8261664234251669945L;
            final long n8 = Long.rotateRight(n6 + array2[1] + LittleEndianByteArray.load64(array, n + 48), 42) * -8261664234251669945L;
            final long n9 = n7 ^ array3[1];
            n6 = (n8 ^ array2[0]);
            final long rotateRight = Long.rotateRight(n4 ^ array3[0], 33);
            weakHashLength32WithSeeds(array, n, array2[1] * -8261664234251669945L, n9 + array3[0], array2);
            weakHashLength32WithSeeds(array, n + 32, rotateRight + array3[1], n6, array3);
            final long n10 = rotateRight;
            n4 = n9;
            n5 = n10;
            n += 64;
            i -= 64;
        } while (i != 0);
        return hash128to64(hash128to64(array2[0], array3[0]) + shiftMix(n6) * -8261664234251669945L + n4, hash128to64(array2[1], array3[1]) + n5);
    }
    
    private static long hashLength33To64(final byte[] array, final int n, final int n2) {
        final long load64 = LittleEndianByteArray.load64(array, n + 24);
        final long n3 = LittleEndianByteArray.load64(array, n) + (n2 + LittleEndianByteArray.load64(array, n + n2 - 16)) * -6505348102511208375L;
        final long rotateRight = Long.rotateRight(n3 + load64, 52);
        final long rotateRight2 = Long.rotateRight(n3, 37);
        final long n4 = n3 + LittleEndianByteArray.load64(array, n + 8);
        final long n5 = rotateRight2 + Long.rotateRight(n4, 7);
        final long n6 = n4 + LittleEndianByteArray.load64(array, n + 16);
        final long n7 = n6 + load64;
        final long n8 = rotateRight + Long.rotateRight(n6, 31) + n5;
        final long n9 = LittleEndianByteArray.load64(array, n + 16) + LittleEndianByteArray.load64(array, n + n2 - 32);
        final long load65 = LittleEndianByteArray.load64(array, n + n2 - 8);
        final long rotateRight3 = Long.rotateRight(n9 + load65, 52);
        final long rotateRight4 = Long.rotateRight(n9, 37);
        final long n10 = n9 + LittleEndianByteArray.load64(array, n + n2 - 24);
        final long n11 = rotateRight4 + Long.rotateRight(n10, 7);
        final long n12 = n10 + LittleEndianByteArray.load64(array, n + n2 - 16);
        return shiftMix(shiftMix((n7 + (rotateRight3 + Long.rotateRight(n12, 31) + n11)) * -4288712594273399085L + (n12 + load65 + n8) * -6505348102511208375L) * -6505348102511208375L + n8) * -4288712594273399085L;
    }
    
    @VisibleForTesting
    static long murmurHash64WithSeed(final byte[] array, final int n, final int n2, final long n3) {
        final int n4 = n2 & 0xFFFFFFF8;
        final int n5 = n2 & 0x7;
        long n6 = n3 ^ n2 * -4132994306676758123L;
        for (int i = 0; i < n4; i += 8) {
            n6 = (n6 ^ shiftMix(LittleEndianByteArray.load64(array, n + i) * -4132994306676758123L) * -4132994306676758123L) * -4132994306676758123L;
        }
        if (n5 != 0) {
            n6 = (n6 ^ LittleEndianByteArray.load64Safely(array, n + n4, n5)) * -4132994306676758123L;
        }
        return shiftMix(shiftMix(n6) * -4132994306676758123L);
    }
}
