/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class FilteredEntryMultimap$AsMap$1EntrySetImpl$1
extends AbstractIterator {
    final Iterator backingIterator;
    final /* synthetic */ FilteredEntryMultimap$AsMap$1EntrySetImpl this$2;

    FilteredEntryMultimap$AsMap$1EntrySetImpl$1(FilteredEntryMultimap$AsMap$1EntrySetImpl filteredEntryMultimap$AsMap$1EntrySetImpl) {
        this.this$2 = filteredEntryMultimap$AsMap$1EntrySetImpl;
        this.backingIterator = this.this$2.this$1.this$0.unfiltered.asMap().entrySet().iterator();
    }

    @Override
    protected Map.Entry computeNext() {
        Object k2;
        Collection collection;
        Map.Entry entry;
        do {
            if (!this.backingIterator.hasNext()) return (Map.Entry)this.endOfData();
            entry = (Map.Entry)this.backingIterator.next();
            k2 = entry.getKey();
        } while ((collection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap$ValuePredicate(this.this$2.this$1.this$0, k2))).isEmpty());
        return Maps.immutableEntry(k2, collection);
    }
}

