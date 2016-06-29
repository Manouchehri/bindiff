/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$UnmodifiableSetMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

class Multimaps$UnmodifiableSortedSetMultimap
extends Multimaps$UnmodifiableSetMultimap
implements SortedSetMultimap {
    private static final long serialVersionUID = 0;

    Multimaps$UnmodifiableSortedSetMultimap(SortedSetMultimap sortedSetMultimap) {
        super(sortedSetMultimap);
    }

    @Override
    public SortedSetMultimap delegate() {
        return (SortedSetMultimap)super.delegate();
    }

    @Override
    public SortedSet get(Object object) {
        return Collections.unmodifiableSortedSet(this.delegate().get(object));
    }

    @Override
    public SortedSet removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedSet replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Comparator valueComparator() {
        return this.delegate().valueComparator();
    }
}

