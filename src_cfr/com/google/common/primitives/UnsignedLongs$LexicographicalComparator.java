/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedLongs;
import java.util.Comparator;

enum UnsignedLongs$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private UnsignedLongs$LexicographicalComparator() {
    }

    public int compare(long[] arrl, long[] arrl2) {
        int n2 = Math.min(arrl.length, arrl2.length);
        int n3 = 0;
        while (n3 < n2) {
            if (arrl[n3] != arrl2[n3]) {
                return UnsignedLongs.compare(arrl[n3], arrl2[n3]);
            }
            ++n3;
        }
        return arrl.length - arrl2.length;
    }
}

