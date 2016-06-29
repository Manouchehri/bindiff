/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.SortedSetMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractSortedSetMultimap
extends AbstractSetMultimap
implements SortedSetMultimap {
    private static final long serialVersionUID = 430848587173315748L;

    protected AbstractSortedSetMultimap(Map map) {
        super(map);
    }

    @Override
    abstract SortedSet createCollection();

    @Override
    SortedSet createUnmodifiableEmptyCollection() {
        Comparator comparator = this.valueComparator();
        if (comparator != null) return ImmutableSortedSet.emptySet(this.valueComparator());
        return Collections.unmodifiableSortedSet(this.createCollection());
    }

    @Override
    public SortedSet get(@Nullable Object object) {
        return (SortedSet)super.get(object);
    }

    @Override
    public SortedSet removeAll(@Nullable Object object) {
        return (SortedSet)super.removeAll(object);
    }

    @Override
    public SortedSet replaceValues(@Nullable Object object, Iterable iterable) {
        return (SortedSet)super.replaceValues(object, iterable);
    }

    @Override
    public Map asMap() {
        return super.asMap();
    }

    @Override
    public Collection values() {
        return super.values();
    }
}

