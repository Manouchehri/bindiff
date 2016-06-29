/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$1ValuesImpl
extends Maps$Values {
    final /* synthetic */ FilteredEntryMultimap$AsMap this$1;

    FilteredEntryMultimap$AsMap$1ValuesImpl(FilteredEntryMultimap$AsMap filteredEntryMultimap$AsMap) {
        this.this$1 = filteredEntryMultimap$AsMap;
        super(filteredEntryMultimap$AsMap);
    }

    @Override
    public boolean remove(@Nullable Object object) {
        Object k2;
        Collection collection;
        Map.Entry entry;
        if (!(object instanceof Collection)) return false;
        Collection collection2 = (Collection)object;
        Iterator iterator = this.this$1.this$0.unfiltered.asMap().entrySet().iterator();
        do {
            if (!iterator.hasNext()) return false;
            entry = iterator.next();
            k2 = entry.getKey();
        } while ((collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap$ValuePredicate(this.this$1.this$0, k2))).isEmpty() || !collection2.equals(collection));
        if (collection.size() == ((Collection)entry.getValue()).size()) {
            iterator.remove();
            return true;
        }
        collection.clear();
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }
}

