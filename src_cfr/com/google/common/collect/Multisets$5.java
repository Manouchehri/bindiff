/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

final class Multisets$5
extends Ordering {
    Multisets$5() {
    }

    public int compare(Multiset$Entry multiset$Entry, Multiset$Entry multiset$Entry2) {
        return Ints.compare(multiset$Entry2.getCount(), multiset$Entry.getCount());
    }
}

