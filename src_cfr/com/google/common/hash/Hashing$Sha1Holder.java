/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

class Hashing$Sha1Holder {
    static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");

    private Hashing$Sha1Holder() {
    }
}

