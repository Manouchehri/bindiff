/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntrySortedMap$SortedKeySet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$FilteredEntrySortedMap
extends Maps$FilteredEntryMap
implements SortedMap {
    Maps$FilteredEntrySortedMap(SortedMap sortedMap, Predicate predicate) {
        super(sortedMap, predicate);
    }

    SortedMap sortedMap() {
        return (SortedMap)this.unfiltered;
    }

    @Override
    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }

    @Override
    SortedSet createKeySet() {
        return new Maps$FilteredEntrySortedMap$SortedKeySet(this);
    }

    public Comparator comparator() {
        return this.sortedMap().comparator();
    }

    public Object firstKey() {
        return this.keySet().iterator().next();
    }

    public Object lastKey() {
        SortedMap sortedMap = this.sortedMap();
        Object k2;
        while (!this.apply(k2 = sortedMap.lastKey(), this.unfiltered.get(k2))) {
            sortedMap = this.sortedMap().headMap(k2);
        }
        return k2;
    }

    public SortedMap headMap(Object object) {
        return new Maps$FilteredEntrySortedMap(this.sortedMap().headMap(object), this.predicate);
    }

    public SortedMap subMap(Object object, Object object2) {
        return new Maps$FilteredEntrySortedMap(this.sortedMap().subMap(object, object2), this.predicate);
    }

    public SortedMap tailMap(Object object) {
        return new Maps$FilteredEntrySortedMap(this.sortedMap().tailMap(object), this.predicate);
    }
}

