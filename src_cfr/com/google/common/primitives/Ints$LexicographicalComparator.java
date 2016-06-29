/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.Ints;
import java.util.Comparator;

enum Ints$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private Ints$LexicographicalComparator() {
    }

    public int compare(int[] arrn, int[] arrn2) {
        int n2 = Math.min(arrn.length, arrn2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = Ints.compare(arrn[n3], arrn2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrn.length - arrn2.length;
    }
}

