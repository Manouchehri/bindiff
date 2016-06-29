/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Pair;
import java.util.Comparator;

enum Pair$FirstComparator implements Comparator
{
    FIRST_COMPARATOR;
    

    private Pair$FirstComparator() {
    }

    public int compare(Pair pair, Pair pair2) {
        Comparable comparable = (Comparable)pair.getFirst();
        Comparable comparable2 = (Comparable)pair2.getFirst();
        return comparable.compareTo(comparable2);
    }
}

