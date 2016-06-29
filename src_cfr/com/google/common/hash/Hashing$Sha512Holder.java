/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

class Hashing$Sha512Holder {
    static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");

    private Hashing$Sha512Holder() {
    }
}

