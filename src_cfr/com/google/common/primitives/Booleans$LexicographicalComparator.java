/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.Booleans;
import java.util.Comparator;

enum Booleans$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private Booleans$LexicographicalComparator() {
    }

    public int compare(boolean[] arrbl, boolean[] arrbl2) {
        int n2 = Math.min(arrbl.length, arrbl2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = Booleans.compare(arrbl[n3], arrbl2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrbl.length - arrbl2.length;
    }
}

