package com.google.common.hash;

import java.io.*;
import javax.annotation.*;

final class Murmur3_32HashFunction extends AbstractStreamingHashFunction implements Serializable
{
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private final int seed;
    private static final long serialVersionUID = 0L;
    
    Murmur3_32HashFunction(final int seed) {
        this.seed = seed;
    }
    
    @Override
    public int bits() {
        return 32;
    }
    
    @Override
    public Hasher newHasher() {
        return new Murmur3_32HashFunction$Murmur3_32Hasher(this.seed);
    }
    
    @Override
    public String toString() {
        return new StringBuilder(31).append("Hashing.murmur3_32(").append(this.seed).append(")").toString();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Murmur3_32HashFunction && this.seed == ((Murmur3_32HashFunction)o).seed;
    }
    
    @Override
    public int hashCode() {
        return this.getClass().hashCode() ^ this.seed;
    }
    
    @Override
    public HashCode hashInt(final int n) {
        return fmix(mixH1(this.seed, mixK1(n)), 4);
    }
    
    @Override
    public HashCode hashLong(final long n) {
        return fmix(mixH1(mixH1(this.seed, mixK1((int)n)), mixK1((int)(n >>> 32))), 8);
    }
    
    @Override
    public HashCode hashString(final CharSequence charSequence) {
        return this.hashUnencodedChars(charSequence);
    }
    
    @Override
    public HashCode hashUnencodedChars(final CharSequence charSequence) {
        int n = this.seed;
        for (int i = 1; i < charSequence.length(); i += 2) {
            n = mixH1(n, mixK1(charSequence.charAt(i - 1) | charSequence.charAt(i) << 16));
        }
        if ((charSequence.length() & 0x1) == 0x1) {
            n ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(n, 2 * charSequence.length());
    }
    
    private static int mixK1(int rotateLeft) {
        rotateLeft *= -862048943;
        rotateLeft = Integer.rotateLeft(rotateLeft, 15);
        rotateLeft *= 461845907;
        return rotateLeft;
    }
    
    private static int mixH1(int rotateLeft, final int n) {
        rotateLeft ^= n;
        rotateLeft = Integer.rotateLeft(rotateLeft, 13);
        rotateLeft = rotateLeft * 5 - 430675100;
        return rotateLeft;
    }
    
    private static HashCode fmix(int n, final int n2) {
        n ^= n2;
        n ^= n >>> 16;
        n *= -2048144789;
        n ^= n >>> 13;
        n *= -1028477387;
        n ^= n >>> 16;
        return HashCode.fromInt(n);
    }
}
