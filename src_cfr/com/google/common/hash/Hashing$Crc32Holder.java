/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.Hashing$ChecksumType;

class Hashing$Crc32Holder {
    static final HashFunction CRC_32 = Hashing.access$200(Hashing$ChecksumType.CRC_32, "Hashing.crc32()");

    private Hashing$Crc32Holder() {
    }
}

