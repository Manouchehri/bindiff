/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$EntrySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class FilteredEntryMultimap$AsMap$1EntrySetImpl
extends Maps$EntrySet {
    final /* synthetic */ FilteredEntryMultimap$AsMap this$1;

    FilteredEntryMultimap$AsMap$1EntrySetImpl(FilteredEntryMultimap$AsMap filteredEntryMultimap$AsMap) {
        this.this$1 = filteredEntryMultimap$AsMap;
    }

    @Override
    Map map() {
        return this.this$1;
    }

    @Override
    public Iterator iterator() {
        return new FilteredEntryMultimap$AsMap$1EntrySetImpl$1(this);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Predicates.in(collection));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Predicates.not(Predicates.in(collection)));
    }

    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }
}

