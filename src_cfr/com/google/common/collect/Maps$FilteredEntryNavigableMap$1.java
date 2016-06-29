/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredEntryNavigableMap;
import com.google.common.collect.Maps$NavigableKeySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

class Maps$FilteredEntryNavigableMap$1
extends Maps$NavigableKeySet {
    final /* synthetic */ Maps$FilteredEntryNavigableMap this$0;

    Maps$FilteredEntryNavigableMap$1(Maps$FilteredEntryNavigableMap filteredEntryNavigableMap, NavigableMap navigableMap) {
        this.this$0 = filteredEntryNavigableMap;
        super(navigableMap);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return Iterators.removeIf(Maps$FilteredEntryNavigableMap.access$700(this.this$0).entrySet().iterator(), Predicates.and(Maps$FilteredEntryNavigableMap.access$600(this.this$0), Maps.keyPredicateOnEntries(Predicates.in(collection))));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return Iterators.removeIf(Maps$FilteredEntryNavigableMap.access$700(this.this$0).entrySet().iterator(), Predicates.and(Maps$FilteredEntryNavigableMap.access$600(this.this$0), Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection)))));
    }
}

