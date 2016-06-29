/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import java.util.Comparator;

enum Floats$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private Floats$LexicographicalComparator() {
    }

    public int compare(float[] arrf, float[] arrf2) {
        int n2 = Math.min(arrf.length, arrf2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = Float.compare(arrf[n3], arrf2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrf.length - arrf2.length;
    }
}

