/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;

@GoogleInternal
final class Fingerprint1999
extends AbstractCompositeHashFunction {
    private final String toString;

    Fingerprint1999(HashFunction hashFunction, HashFunction hashFunction2, String string) {
        super(hashFunction, hashFunction2);
        this.toString = (String)Preconditions.checkNotNull(string);
    }

    @Override
    public int bits() {
        return 64;
    }

    public String toString() {
        return this.toString;
    }

    @Override
    HashCode makeHash(Hasher[] arrhasher) {
        return Fingerprint1999.combineFingerprintHalves(arrhasher[0].hash().asInt(), arrhasher[1].hash().asInt());
    }

    @VisibleForTesting
    static HashCode combineFingerprintHalves(int n2, int n3) {
        if (n2 == 0 && n3 == 0) {
            return HashCode.fromLong(1373487864664336680L);
        }
        if (n2 != 0) return HashCode.fromLong((long)n2 << 32 | (long)n3 & 0xFFFFFFFFL);
        if (n3 != 1) return HashCode.fromLong((long)n2 << 32 | (long)n3 & 0xFFFFFFFFL);
        return HashCode.fromLong(1373487864664336681L);
    }
}

