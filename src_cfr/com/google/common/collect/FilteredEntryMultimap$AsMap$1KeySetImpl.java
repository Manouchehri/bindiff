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
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

class FilteredEntryMultimap$AsMap$1KeySetImpl
extends Maps$KeySet {
    final /* synthetic */ FilteredEntryMultimap$AsMap this$1;

    FilteredEntryMultimap$AsMap$1KeySetImpl(FilteredEntryMultimap$AsMap filteredEntryMultimap$AsMap) {
        this.this$1 = filteredEntryMultimap$AsMap;
        super(filteredEntryMultimap$AsMap);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(collection)));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (this.this$1.remove(object) == null) return false;
        return true;
    }
}

