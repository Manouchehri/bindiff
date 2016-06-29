/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$Keys;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredMultimapValues;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredEntryMultimap
extends AbstractMultimap
implements FilteredMultimap {
    final Multimap unfiltered;
    final Predicate predicate;

    FilteredEntryMultimap(Multimap multimap, Predicate predicate) {
        this.unfiltered = (Multimap)Preconditions.checkNotNull(multimap);
        this.predicate = (Predicate)Preconditions.checkNotNull(predicate);
    }

    @Override
    public Multimap unfiltered() {
        return this.unfiltered;
    }

    @Override
    public Predicate entryPredicate() {
        return this.predicate;
    }

    @Override
    public int size() {
        return this.entries().size();
    }

    private boolean satisfies(Object object, Object object2) {
        return this.predicate.apply(Maps.immutableEntry(object, object2));
    }

    static Collection filterCollection(Collection collection, Predicate predicate) {
        if (!(collection instanceof Set)) return Collections2.filter(collection, predicate);
        return Sets.filter((Set)collection, predicate);
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (this.asMap().get(object) == null) return false;
        return true;
    }

    @Override
    public Collection removeAll(@Nullable Object object) {
        return (Collection)MoreObjects.firstNonNull(this.asMap().remove(object), this.unmodifiableEmptyCollection());
    }

    Collection unmodifiableEmptyCollection() {
        Set set;
        if (this.unfiltered instanceof SetMultimap) {
            set = Collections.emptySet();
            return set;
        }
        set = Collections.emptyList();
        return set;
    }

    @Override
    public void clear() {
        this.entries().clear();
    }

    @Override
    public Collection get(Object object) {
        return FilteredEntryMultimap.filterCollection(this.unfiltered.get(object), new FilteredEntryMultimap$ValuePredicate(this, object));
    }

    @Override
    Collection createEntries() {
        return FilteredEntryMultimap.filterCollection(this.unfiltered.entries(), this.predicate);
    }

    @Override
    Collection createValues() {
        return new FilteredMultimapValues(this);
    }

    @Override
    Iterator entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    Map createAsMap() {
        return new FilteredEntryMultimap$AsMap(this);
    }

    @Override
    public Set keySet() {
        return this.asMap().keySet();
    }

    boolean removeEntriesIf(Predicate predicate) {
        Iterator iterator = this.unfiltered.asMap().entrySet().iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Object k2 = entry.getKey();
            Collection collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap$ValuePredicate(this, k2));
            if (collection.isEmpty() || !predicate.apply(Maps.immutableEntry(k2, collection))) continue;
            if (collection.size() == ((Collection)entry.getValue()).size()) {
                iterator.remove();
            } else {
                collection.clear();
            }
            bl2 = true;
        }
        return bl2;
    }

    @Override
    Multiset createKeys() {
        return new FilteredEntryMultimap$Keys(this);
    }

    static /* synthetic */ boolean access$000(FilteredEntryMultimap filteredEntryMultimap, Object object, Object object2) {
        return filteredEntryMultimap.satisfies(object, object2);
    }
}

