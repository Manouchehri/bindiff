/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredMultimapValues
extends AbstractCollection {
    @Weak
    private final FilteredMultimap multimap;

    FilteredMultimapValues(FilteredMultimap filteredMultimap) {
        this.multimap = (FilteredMultimap)Preconditions.checkNotNull(filteredMultimap);
    }

    @Override
    public Iterator iterator() {
        return Maps.valueIterator(this.multimap.entries().iterator());
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.multimap.containsValue(object);
    }

    @Override
    public int size() {
        return this.multimap.size();
    }

    @Override
    public boolean remove(@Nullable Object object) {
        Map.Entry entry;
        Predicate predicate = this.multimap.entryPredicate();
        Iterator iterator = this.multimap.unfiltered().entries().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!predicate.apply(entry = (Map.Entry)iterator.next()) || !Objects.equal(entry.getValue(), object));
        iterator.remove();
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.in(collection))));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection)))));
    }

    @Override
    public void clear() {
        this.multimap.clear();
    }
}

