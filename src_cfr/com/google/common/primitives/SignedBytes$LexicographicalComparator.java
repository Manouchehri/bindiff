/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.SignedBytes;
import java.util.Comparator;

enum SignedBytes$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private SignedBytes$LexicographicalComparator() {
    }

    public int compare(byte[] arrby, byte[] arrby2) {
        int n2 = Math.min(arrby.length, arrby2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = SignedBytes.compare(arrby[n3], arrby2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrby.length - arrby2.length;
    }
}

