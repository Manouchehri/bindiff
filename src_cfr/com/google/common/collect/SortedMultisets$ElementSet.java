/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$ElementSet;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

class SortedMultisets$ElementSet
extends Multisets$ElementSet
implements SortedSet {
    @Weak
    private final SortedMultiset multiset;

    SortedMultisets$ElementSet(SortedMultiset sortedMultiset) {
        this.multiset = sortedMultiset;
    }

    @Override
    final SortedMultiset multiset() {
        return this.multiset;
    }

    public Comparator comparator() {
        return this.multiset().comparator();
    }

    public SortedSet subSet(Object object, Object object2) {
        return this.multiset().subMultiset(object, BoundType.CLOSED, object2, BoundType.OPEN).elementSet();
    }

    public SortedSet headSet(Object object) {
        return this.multiset().headMultiset(object, BoundType.OPEN).elementSet();
    }

    public SortedSet tailSet(Object object) {
        return this.multiset().tailMultiset(object, BoundType.CLOSED).elementSet();
    }

    public Object first() {
        return SortedMultisets.access$000(this.multiset().firstEntry());
    }

    public Object last() {
        return SortedMultisets.access$000(this.multiset().lastEntry());
    }
}

