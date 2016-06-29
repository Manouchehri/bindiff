/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing$1;
import java.util.Arrays;
import javax.annotation.Nullable;

final class Hashing$ConcatenatedHashFunction
extends AbstractCompositeHashFunction {
    private final int bits;

    private /* varargs */ Hashing$ConcatenatedHashFunction(HashFunction ... arrhashFunction) {
        super(arrhashFunction);
        int n2 = 0;
        HashFunction[] arrhashFunction2 = arrhashFunction;
        int n3 = arrhashFunction2.length;
        int n4 = 0;
        do {
            if (n4 >= n3) {
                this.bits = n2;
                return;
            }
            HashFunction hashFunction = arrhashFunction2[n4];
            n2 += hashFunction.bits();
            Preconditions.checkArgument(hashFunction.bits() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.bits(), hashFunction);
            ++n4;
        } while (true);
    }

    @Override
    HashCode makeHash(Hasher[] arrhasher) {
        byte[] arrby = new byte[this.bits / 8];
        int n2 = 0;
        Hasher[] arrhasher2 = arrhasher;
        int n3 = arrhasher2.length;
        int n4 = 0;
        while (n4 < n3) {
            Hasher hasher = arrhasher2[n4];
            HashCode hashCode = hasher.hash();
            n2 += hashCode.writeBytesTo(arrby, n2, hashCode.bits() / 8);
            ++n4;
        }
        return HashCode.fromBytesNoCopy(arrby);
    }

    @Override
    public int bits() {
        return this.bits;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Hashing$ConcatenatedHashFunction)) return false;
        Hashing$ConcatenatedHashFunction hashing$ConcatenatedHashFunction = (Hashing$ConcatenatedHashFunction)object;
        return Arrays.equals(this.functions, hashing$ConcatenatedHashFunction.functions);
    }

    public int hashCode() {
        return Arrays.hashCode(this.functions) * 31 + this.bits;
    }

    /* synthetic */ Hashing$ConcatenatedHashFunction(HashFunction[] arrhashFunction, Hashing$1 hashing$1) {
        this(arrhashFunction);
    }
}

