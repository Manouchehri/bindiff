/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Pair;
import java.util.Comparator;

enum Pair$SecondComparator implements Comparator
{
    SECOND_COMPARATOR;
    

    private Pair$SecondComparator() {
    }

    public int compare(Pair pair, Pair pair2) {
        Comparable comparable = (Comparable)pair.getSecond();
        Comparable comparable2 = (Comparable)pair2.getSecond();
        return comparable.compareTo(comparable2);
    }
}

