/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

class Hashing$Sha256Holder {
    static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");

    private Hashing$Sha256Holder() {
    }
}

