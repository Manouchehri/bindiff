/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import java.util.Comparator;

enum Doubles$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private Doubles$LexicographicalComparator() {
    }

    public int compare(double[] arrd, double[] arrd2) {
        int n2 = Math.min(arrd.length, arrd2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = Double.compare(arrd[n3], arrd2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrd.length - arrd2.length;
    }
}

