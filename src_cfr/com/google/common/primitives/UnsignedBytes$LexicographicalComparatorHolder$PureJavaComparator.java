/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

enum UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator implements Comparator
{
    INSTANCE;
    

    private UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator() {
    }

    public int compare(byte[] arrby, byte[] arrby2) {
        int n2 = Math.min(arrby.length, arrby2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = UnsignedBytes.compare(arrby[n3], arrby2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrby.length - arrby2.length;
    }
}

