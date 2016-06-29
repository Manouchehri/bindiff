/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.primitives.Chars;
import java.util.Comparator;

enum Chars$LexicographicalComparator implements Comparator
{
    INSTANCE;
    

    private Chars$LexicographicalComparator() {
    }

    public int compare(char[] arrc, char[] arrc2) {
        int n2 = Math.min(arrc.length, arrc2.length);
        int n3 = 0;
        while (n3 < n2) {
            int n4 = Chars.compare(arrc[n3], arrc2[n3]);
            if (n4 != 0) {
                return n4;
            }
            ++n3;
        }
        return arrc.length - arrc2.length;
    }
}

