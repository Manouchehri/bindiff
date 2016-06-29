package com.google.common.hash;

import com.google.common.base.*;
import com.google.common.annotations.*;

@GoogleInternal
final class Fingerprint1999 extends AbstractCompositeHashFunction
{
    private final String toString;
    
    Fingerprint1999(final HashFunction hashFunction, final HashFunction hashFunction2, final String s) {
        super(new HashFunction[] { hashFunction, hashFunction2 });
        this.toString = (String)Preconditions.checkNotNull(s);
    }
    
    @Override
    public int bits() {
        return 64;
    }
    
    @Override
    public String toString() {
        return this.toString;
    }
    
    @Override
    HashCode makeHash(final Hasher[] array) {
        return combineFingerprintHalves(array[0].hash().asInt(), array[1].hash().asInt());
    }
    
    @VisibleForTesting
    static HashCode combineFingerprintHalves(final int n, final int n2) {
        if (n == 0 && n2 == 0) {
            return HashCode.fromLong(1373487864664336680L);
        }
        if (n == 0 && n2 == 1) {
            return HashCode.fromLong(1373487864664336681L);
        }
        return HashCode.fromLong(n << 32 | (n2 & 0xFFFFFFFFL));
    }
}
