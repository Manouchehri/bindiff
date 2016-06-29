/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.Longs;
import java.util.Comparator;

enum Longs$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private Longs$LexicographicalComparator() {
    }

    public int compare(long[] arrl, long[] arrl2) {
        int n2 = Math.min(arrl.length, arrl2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = Longs.compare(arrl[n3], arrl2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrl.length - arrl2.length;
    }
}

