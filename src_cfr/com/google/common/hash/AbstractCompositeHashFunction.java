/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractCompositeHashFunction$1;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;

abstract class AbstractCompositeHashFunction
extends AbstractStreamingHashFunction {
    final HashFunction[] functions;
    private static final long serialVersionUID = 0;

    /* varargs */ AbstractCompositeHashFunction(HashFunction ... arrhashFunction) {
        HashFunction[] arrhashFunction2 = arrhashFunction;
        int n2 = arrhashFunction2.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.functions = arrhashFunction;
                return;
            }
            HashFunction hashFunction = arrhashFunction2[n3];
            Preconditions.checkNotNull(hashFunction);
            ++n3;
        } while (true);
    }

    abstract HashCode makeHash(Hasher[] var1);

    @Override
    public Hasher newHasher() {
        Hasher[] arrhasher = new Hasher[this.functions.length];
        int n2 = 0;
        while (n2 < arrhasher.length) {
            arrhasher[n2] = this.functions[n2].newHasher();
            ++n2;
        }
        return new AbstractCompositeHashFunction$1(this, arrhasher);
    }
}

