/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.annotations.GoogleInternal;
import com.google.common.hash.CityHash128HashFunction;
import com.google.common.hash.HashFunction;

@GoogleInternal
class Hashing$CityHash128Holder {
    static final HashFunction CITY_HASH_128 = new CityHash128HashFunction();

    private Hashing$CityHash128Holder() {
    }
}

