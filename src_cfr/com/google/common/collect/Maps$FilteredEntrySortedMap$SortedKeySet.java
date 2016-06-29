/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryMap$KeySet;
import com.google.common.collect.Maps$FilteredEntrySortedMap;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$FilteredEntrySortedMap$SortedKeySet
extends Maps$FilteredEntryMap$KeySet
implements SortedSet {
    final /* synthetic */ Maps$FilteredEntrySortedMap this$0;

    Maps$FilteredEntrySortedMap$SortedKeySet(Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap) {
        this.this$0 = maps$FilteredEntrySortedMap;
        super(maps$FilteredEntrySortedMap);
    }

    public Comparator comparator() {
        return this.this$0.sortedMap().comparator();
    }

    public SortedSet subSet(Object object, Object object2) {
        return (SortedSet)this.this$0.subMap(object, object2).keySet();
    }

    public SortedSet headSet(Object object) {
        return (SortedSet)this.this$0.headMap(object).keySet();
    }

    public SortedSet tailSet(Object object) {
        return (SortedSet)this.this$0.tailMap(object).keySet();
    }

    public Object first() {
        return this.this$0.firstKey();
    }

    public Object last() {
        return this.this$0.lastKey();
    }
}

