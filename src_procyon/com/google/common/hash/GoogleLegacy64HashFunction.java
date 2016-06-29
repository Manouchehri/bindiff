package com.google.common.hash;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.nio.charset.*;
import com.google.common.base.*;

@GoogleInternal
final class GoogleLegacy64HashFunction extends AbstractStreamingHashFunction
{
    private final long seed;
    
    GoogleLegacy64HashFunction(final long seed) {
        this.seed = seed;
    }
    
    @Override
    public int bits() {
        return 64;
    }
    
    @Override
    public Hasher newHasher() {
        return new GoogleLegacy64HashFunction$GoogleLegacy64Hasher(new GoogleLegacy64HashFunction$GoogleLegacy64Mixer(this.seed), null);
    }
    
    @Override
    public String toString() {
        return new StringBuilder(48).append("LegacyHashing.googleHash64(").append(this.seed).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof GoogleLegacy64HashFunction && this.seed == ((GoogleLegacy64HashFunction)o).seed;
    }
    
    @Override
    public int hashCode() {
        return (int)(this.seed ^ this.getClass().hashCode());
    }
    
    @Override
    public HashCode hashLong(final long n) {
        return HashCode.fromLong(mix64(-2266404186210603134L + (n & 0xFFL) + (n & 0xFF00L) + (n & 0xFF0000L) + (n & 0xFF000000L) + (n & 0xFF00000000L) + (n & 0xFF0000000000L) + (n & 0xFF000000000000L) + (n & 0xFF00000000000000L), -2266404186210603134L, this.seed + 8L));
    }
    
    @Override
    public HashCode hashInt(final int n) {
        return HashCode.fromLong(mix64(-2266404186210603134L + (n & 0xFFL) + (n & 0xFF00L) + (n & 0xFF0000L) + (n & 0xFF000000L), -2266404186210603134L, this.seed + 4L));
    }
    
    @Override
    public HashCode hashString(final CharSequence charSequence, final Charset charset) {
        return this.hashBytes(charSequence.toString().getBytes(charset));
    }
    
    @Override
    public HashCode hashBytes(final byte[] array) {
        return this.hashBytes(array, 0, array.length);
    }
    
    @Override
    public HashCode hashBytes(final byte[] array, int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
        long n3 = -2266404186210603134L;
        long n4 = -2266404186210603134L;
        long seed = this.seed;
        int i;
        for (i = n2; i >= 24; i -= 24, n += 24) {
            final long n5 = n3 + word64At(array, n);
            final long n6 = n4 + word64At(array, n + 8);
            final long n7 = seed + word64At(array, n + 16);
            final long n8 = n5 - n6 - n7 ^ n7 >>> 43;
            final long n9 = n6 - n7 - n8 ^ n8 << 9;
            final long n10 = n7 - n8 - n9 ^ n9 >>> 8;
            final long n11 = n8 - n9 - n10 ^ n10 >>> 38;
            final long n12 = n9 - n10 - n11 ^ n11 << 23;
            final long n13 = n10 - n11 - n12 ^ n12 >>> 5;
            final long n14 = n11 - n12 - n13 ^ n13 >>> 35;
            final long n15 = n12 - n13 - n14 ^ n14 << 49;
            final long n16 = n13 - n14 - n15 ^ n15 >>> 11;
            n3 = (n14 - n15 - n16 ^ n16 >>> 12);
            n4 = (n15 - n16 - n3 ^ n3 << 18);
            seed = (n16 - n3 - n4 ^ n4 >>> 22);
        }
        long n17 = seed + n2;
        switch (i) {
            case 23: {
                n17 += array[n + 22] << 56;
            }
            case 22: {
                n17 += (array[n + 21] & 0xFFL) << 48;
            }
            case 21: {
                n17 += (array[n + 20] & 0xFFL) << 40;
            }
            case 20: {
                n17 += (array[n + 19] & 0xFFL) << 32;
            }
            case 19: {
                n17 += (array[n + 18] & 0xFFL) << 24;
            }
            case 18: {
                n17 += (array[n + 17] & 0xFFL) << 16;
            }
            case 17: {
                n17 += (array[n + 16] & 0xFFL) << 8;
            }
            case 16: {
                n4 += word64At(array, n + 8);
                n3 += word64At(array, n);
                break;
            }
            case 15: {
                n4 += (array[n + 14] & 0xFFL) << 48;
            }
            case 14: {
                n4 += (array[n + 13] & 0xFFL) << 40;
            }
            case 13: {
                n4 += (array[n + 12] & 0xFFL) << 32;
            }
            case 12: {
                n4 += (array[n + 11] & 0xFFL) << 24;
            }
            case 11: {
                n4 += (array[n + 10] & 0xFFL) << 16;
            }
            case 10: {
                n4 += (array[n + 9] & 0xFFL) << 8;
            }
            case 9: {
                n4 += (array[n + 8] & 0xFFL);
            }
            case 8: {
                n3 += word64At(array, n);
                break;
            }
            case 7: {
                n3 += (array[n + 6] & 0xFFL) << 48;
            }
            case 6: {
                n3 += (array[n + 5] & 0xFFL) << 40;
            }
            case 5: {
                n3 += (array[n + 4] & 0xFFL) << 32;
            }
            case 4: {
                n3 += (array[n + 3] & 0xFFL) << 24;
            }
            case 3: {
                n3 += (array[n + 2] & 0xFFL) << 16;
            }
            case 2: {
                n3 += (array[n + 1] & 0xFFL) << 8;
            }
            case 1: {
                n3 += (array[n + 0] & 0xFFL);
            }
            case 0: {
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return HashCode.fromLong(mix64(n3, n4, n17));
    }
    
    static long mix64(long n, long n2, long n3) {
        n -= n2;
        n -= n3;
        n ^= n3 >>> 43;
        n2 -= n3;
        n2 -= n;
        n2 ^= n << 9;
        n3 -= n;
        n3 -= n2;
        n3 ^= n2 >>> 8;
        n -= n2;
        n -= n3;
        n ^= n3 >>> 38;
        n2 -= n3;
        n2 -= n;
        n2 ^= n << 23;
        n3 -= n;
        n3 -= n2;
        n3 ^= n2 >>> 5;
        n -= n2;
        n -= n3;
        n ^= n3 >>> 35;
        n2 -= n3;
        n2 -= n;
        n2 ^= n << 49;
        n3 -= n;
        n3 -= n2;
        n3 ^= n2 >>> 11;
        n -= n2;
        n -= n3;
        n ^= n3 >>> 12;
        n2 -= n3;
        n2 -= n;
        n2 ^= n << 18;
        n3 -= n;
        n3 -= n2;
        n3 ^= n2 >>> 22;
        return n3;
    }
    
    private static long word64At(final byte[] array, final int n) {
        return (array[n + 0] & 0xFFL) + ((array[n + 1] & 0xFFL) << 8) + ((array[n + 2] & 0xFFL) << 16) + ((array[n + 3] & 0xFFL) << 24) + ((array[n + 4] & 0xFFL) << 32) + ((array[n + 5] & 0xFFL) << 40) + ((array[n + 6] & 0xFFL) << 48) + ((array[n + 7] & 0xFFL) << 56);
    }
}
