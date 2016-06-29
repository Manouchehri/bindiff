/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$1;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.util.Comparator;
import java.util.List;

final class SortedLists$KeyPresentBehavior$4
extends SortedLists$KeyPresentBehavior {
    SortedLists$KeyPresentBehavior$4(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public int resultIndex(Comparator comparator, Object object, List list, int n2) {
        return LAST_PRESENT.resultIndex(comparator, object, list, n2) + 1;
    }
}

