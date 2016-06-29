/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.GoogleLegacy32HashFunction$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy;

final class GoogleLegacy32HashFunction$FingerprintStrategy$1
extends GoogleLegacy32HashFunction$FingerprintStrategy {
    GoogleLegacy32HashFunction$FingerprintStrategy$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    int maybeAddSignCruft(int n2) {
        return (n2 & 2139062143) - (n2 & -2139062144);
    }

    @Override
    int word32At(byte[] arrby, int n2) {
        return arrby[n2 + 0] + (arrby[n2 + 1] << 8) + (arrby[n2 + 2] << 16) + (arrby[n2 + 3] << 24);
    }
}

