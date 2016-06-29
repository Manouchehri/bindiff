package com.google.common.hash;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.nio.charset.*;

@GoogleInternal
final class GoogleLegacy32HashFunction extends AbstractStreamingHashFunction
{
    private final int seed;
    private final GoogleLegacy32HashFunction$FingerprintStrategy fingerprintStrategy;
    
    GoogleLegacy32HashFunction(final int seed, final GoogleLegacy32HashFunction$FingerprintStrategy googleLegacy32HashFunction$FingerprintStrategy) {
        this.seed = seed;
        this.fingerprintStrategy = (GoogleLegacy32HashFunction$FingerprintStrategy)Preconditions.checkNotNull(googleLegacy32HashFunction$FingerprintStrategy);
    }
    
    @Override
    public int bits() {
        return 32;
    }
    
    @Override
    public Hasher newHasher() {
        return new GoogleLegacy32HashFunction$GoogleLegacy32Hasher(new GoogleLegacy32HashFunction$GoogleLegacy32Mixer(this.seed), this.fingerprintStrategy, null);
    }
    
    @Override
    public String toString() {
        return new StringBuilder(39).append("LegacyHashing.googleHash32(").append(this.seed).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof GoogleLegacy32HashFunction) {
            final GoogleLegacy32HashFunction googleLegacy32HashFunction = (GoogleLegacy32HashFunction)o;
            return this.seed == googleLegacy32HashFunction.seed && this.fingerprintStrategy == googleLegacy32HashFunction.fingerprintStrategy;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.seed ^ this.fingerprintStrategy.hashCode() ^ this.getClass().hashCode();
    }
    
    @Override
    public HashCode hashLong(final long n) {
        return HashCode.fromInt(mix32(-1640531527 + (byte)n + ((byte)(n >> 8) << 8) + ((byte)(n >> 16) << 16) + ((byte)(n >> 24) << 24), -1640531527 + (byte)(n >> 32) + ((byte)(n >> 40) << 8) + ((byte)(n >> 48) << 16) + ((byte)(n >> 56) << 24), this.seed + 8));
    }
    
    @Override
    public HashCode hashInt(final int n) {
        return HashCode.fromInt(mix32(-1640531527 + (byte)n + ((byte)(n >> 8) << 8) + ((byte)(n >> 16) << 16) + ((byte)(n >> 24) << 24), -1640531527, this.seed + 4));
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
        int n3 = -1640531527;
        int n4 = -1640531527;
        int seed = this.seed;
        int i;
        for (i = n2; i >= 12; i -= 12, n += 12) {
            final int n5 = n3 + this.fingerprintStrategy.word32At(array, n);
            final int n6 = n4 + this.fingerprintStrategy.word32At(array, n + 4);
            final int n7 = seed + this.fingerprintStrategy.word32At(array, n + 8);
            final int n8 = n5 - n6 - n7 ^ n7 >>> 13;
            final int n9 = n6 - n7 - n8 ^ n8 << 8;
            final int n10 = n7 - n8 - n9 ^ n9 >>> 13;
            final int n11 = n8 - n9 - n10 ^ n10 >>> 12;
            final int n12 = n9 - n10 - n11 ^ n11 << 16;
            final int n13 = n10 - n11 - n12 ^ n12 >>> 5;
            n3 = (n11 - n12 - n13 ^ n13 >>> 3);
            n4 = (n12 - n13 - n3 ^ n3 << 10);
            seed = (n13 - n3 - n4 ^ n4 >>> 15);
        }
        int n14 = seed + n2;
        switch (i) {
            case 11: {
                n14 += array[n + 10] << 24;
            }
            case 10: {
                n14 += (array[n + 9] & 0xFF) << 16;
            }
            case 9: {
                n14 += (array[n + 8] & 0xFF) << 8;
            }
            case 8: {
                n4 += this.fingerprintStrategy.word32At(array, n + 4);
                n3 += this.fingerprintStrategy.word32At(array, n);
                break;
            }
            case 7: {
                n4 += (array[n + 6] & 0xFF) << 16;
            }
            case 6: {
                n4 += (array[n + 5] & 0xFF) << 8;
            }
            case 5: {
                n4 += (array[n + 4] & 0xFF);
            }
            case 4: {
                n3 += this.fingerprintStrategy.word32At(array, n);
                break;
            }
            case 3: {
                n3 += (array[n + 2] & 0xFF) << 16;
            }
            case 2: {
                n3 += (array[n + 1] & 0xFF) << 8;
            }
            case 1: {
                n3 += (array[n + 0] & 0xFF);
            }
            case 0: {
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return HashCode.fromInt(mix32(n3, n4, n14));
    }
    
    static int mix32(int n, int n2, int n3) {
        n -= n2;
        n -= n3;
        n ^= n3 >>> 13;
        n2 -= n3;
        n2 -= n;
        n2 ^= n << 8;
        n3 -= n;
        n3 -= n2;
        n3 ^= n2 >>> 13;
        n -= n2;
        n -= n3;
        n ^= n3 >>> 12;
        n2 -= n3;
        n2 -= n;
        n2 ^= n << 16;
        n3 -= n;
        n3 -= n2;
        n3 ^= n2 >>> 5;
        n -= n2;
        n -= n3;
        n ^= n3 >>> 3;
        n2 -= n3;
        n2 -= n;
        n2 ^= n << 10;
        n3 -= n;
        n3 -= n2;
        n3 ^= n2 >>> 15;
        return n3;
    }
}
