/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$1;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.util.Comparator;
import java.util.List;

final class SortedLists$KeyPresentBehavior$3
extends SortedLists$KeyPresentBehavior {
    SortedLists$KeyPresentBehavior$3(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    int resultIndex(Comparator comparator, Object object, List list, int n2) {
        int n3 = 0;
        int n4 = n2;
        while (n3 < n4) {
            int n5 = n3 + n4 >>> 1;
            int n6 = comparator.compare(list.get(n5), object);
            if (n6 < 0) {
                n3 = n5 + 1;
                continue;
            }
            n4 = n5;
        }
        return n3;
    }
}

