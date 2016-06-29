package com.google.common.hash;

import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

final class Hashing$ConcatenatedHashFunction extends AbstractCompositeHashFunction
{
    private final int bits;
    
    private Hashing$ConcatenatedHashFunction(final HashFunction... array) {
        super(array);
        int bits = 0;
        for (final HashFunction hashFunction : array) {
            bits += hashFunction.bits();
            Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), hashFunction);
        }
        this.bits = bits;
    }
    
    @Override
    HashCode makeHash(final Hasher[] array) {
        final byte[] array2 = new byte[this.bits / 8];
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            final HashCode hash = array[i].hash();
            n += hash.writeBytesTo(array2, n, hash.bits() / 8);
        }
        return HashCode.fromBytesNoCopy(array2);
    }
    
    @Override
    public int bits() {
        return this.bits;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Hashing$ConcatenatedHashFunction && Arrays.equals(this.functions, ((Hashing$ConcatenatedHashFunction)o).functions);
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.functions) * 31 + this.bits;
    }
}
