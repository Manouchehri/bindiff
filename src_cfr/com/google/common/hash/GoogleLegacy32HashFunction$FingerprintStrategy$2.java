/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.GoogleLegacy32HashFunction$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;
import com.google.common.primitives.Ints;

final class GoogleLegacy32HashFunction$FingerprintStrategy$2
extends GoogleLegacy32HashFunction$FingerprintStrategy {
    GoogleLegacy32HashFunction$FingerprintStrategy$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    int maybeAddSignCruft(int n2) {
        return n2;
    }

    @Override
    int word32At(byte[] arrby, int n2) {
        return Ints.fromBytes(arrby[n2 + 3], arrby[n2 + 2], arrby[n2 + 1], arrby[n2]);
    }
}

