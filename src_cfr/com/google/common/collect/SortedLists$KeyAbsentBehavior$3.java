/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$1;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;

final class SortedLists$KeyAbsentBehavior$3
extends SortedLists$KeyAbsentBehavior {
    SortedLists$KeyAbsentBehavior$3(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    public int resultIndex(int n2) {
        return ~ n2;
    }
}

