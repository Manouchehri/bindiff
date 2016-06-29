/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.FilteredKeyMultimap$AddRejectingList;
import com.google.common.collect.FilteredKeyMultimap$AddRejectingSet;
import com.google.common.collect.FilteredKeyMultimap$Entries;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredMultimapValues;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredKeyMultimap
extends AbstractMultimap
implements FilteredMultimap {
    final Multimap unfiltered;
    final Predicate keyPredicate;

    FilteredKeyMultimap(Multimap multimap, Predicate predicate) {
        this.unfiltered = (Multimap)Preconditions.checkNotNull(multimap);
        this.keyPredicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    @Override
    public Multimap unfiltered() {
        return this.unfiltered;
    }

    @Override
    public Predicate entryPredicate() {
        return Maps.keyPredicateOnEntries(this.keyPredicate);
    }

    @Override
    public int size() {
        int n2 = 0;
        Iterator iterator = this.asMap().values().iterator();
        while (iterator.hasNext()) {
            Collection collection = (Collection)iterator.next();
            n2 += collection.size();
        }
        return n2;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (!this.unfiltered.containsKey(object)) return false;
        Object object2 = object;
        return this.keyPredicate.apply(object2);
    }

    @Override
    public Collection removeAll(Object object) {
        Collection collection;
        if (this.containsKey(object)) {
            collection = this.unfiltered.removeAll(object);
            return collection;
        }
        collection = this.unmodifiableEmptyCollection();
        return collection;
    }

    Collection unmodifiableEmptyCollection() {
        if (!(this.unfiltered instanceof SetMultimap)) return ImmutableList.of();
        return ImmutableSet.of();
    }

    @Override
    public void clear() {
        this.keySet().clear();
    }

    @Override
    Set createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    @Override
    public Collection get(Object object) {
        if (this.keyPredicate.apply(object)) {
            return this.unfiltered.get(object);
        }
        if (!(this.unfiltered instanceof SetMultimap)) return new FilteredKeyMultimap$AddRejectingList(object);
        return new FilteredKeyMultimap$AddRejectingSet(object);
    }

    @Override
    Iterator entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    Collection createEntries() {
        return new FilteredKeyMultimap$Entries(this);
    }

    @Override
    Collection createValues() {
        return new FilteredMultimapValues(this);
    }

    @Override
    Map createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }

    @Override
    Multiset createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }
}

