/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$Keys;
import com.google.common.collect.FilteredEntryMultimap$Keys$1$1;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class FilteredEntryMultimap$Keys$1
extends Multisets$EntrySet {
    final /* synthetic */ FilteredEntryMultimap$Keys this$1;

    FilteredEntryMultimap$Keys$1(FilteredEntryMultimap$Keys filteredEntryMultimap$Keys) {
        this.this$1 = filteredEntryMultimap$Keys;
    }

    @Override
    Multiset multiset() {
        return this.this$1;
    }

    @Override
    public Iterator iterator() {
        return this.this$1.entryIterator();
    }

    @Override
    public int size() {
        return this.this$1.this$0.keySet().size();
    }

    private boolean removeEntriesIf(Predicate predicate) {
        return this.this$1.this$0.removeEntriesIf(new FilteredEntryMultimap$Keys$1$1(this, predicate));
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.removeEntriesIf(Predicates.in(collection));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.removeEntriesIf(Predicates.not(Predicates.in(collection)));
    }
}

