/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.Shorts;
import java.util.Comparator;

enum Shorts$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private Shorts$LexicographicalComparator() {
    }

    public int compare(short[] arrs, short[] arrs2) {
        int n2 = Math.min(arrs.length, arrs2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = Shorts.compare(arrs[n3], arrs2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrs.length - arrs2.length;
    }
}

