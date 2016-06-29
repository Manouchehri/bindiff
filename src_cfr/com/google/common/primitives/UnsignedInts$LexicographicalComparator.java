/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedInts;
import java.util.Comparator;

enum UnsignedInts$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private UnsignedInts$LexicographicalComparator() {
    }

    public int compare(int[] arrn, int[] arrn2) {
        int n2 = Math.min(arrn.length, arrn2.length);
        int n3 = 0;
        while (n3 < n2) {
            if (arrn[n3] != arrn2[n3]) {
                return UnsignedInts.compare(arrn[n3], arrn2[n3]);
            }
            ++n3;
        }
        return arrn.length - arrn2.length;
    }
}

