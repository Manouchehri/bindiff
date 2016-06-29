/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

class Hashing$Md5Holder {
    static final HashFunction MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");

    private Hashing$Md5Holder() {
    }
}

