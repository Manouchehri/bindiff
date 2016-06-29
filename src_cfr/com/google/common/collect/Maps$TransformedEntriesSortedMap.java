/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$TransformedEntriesMap;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

class Maps$TransformedEntriesSortedMap
extends Maps$TransformedEntriesMap
implements SortedMap {
    protected SortedMap fromMap() {
        return (SortedMap)this.fromMap;
    }

    Maps$TransformedEntriesSortedMap(SortedMap sortedMap, Maps$EntryTransformer maps$EntryTransformer) {
        super(sortedMap, maps$EntryTransformer);
    }

    public Comparator comparator() {
        return this.fromMap().comparator();
    }

    public Object firstKey() {
        return this.fromMap().firstKey();
    }

    public SortedMap headMap(Object object) {
        return Maps.transformEntries(this.fromMap().headMap(object), this.transformer);
    }

    public Object lastKey() {
        return this.fromMap().lastKey();
    }

    public SortedMap subMap(Object object, Object object2) {
        return Maps.transformEntries(this.fromMap().subMap(object, object2), this.transformer);
    }

    public SortedMap tailMap(Object object) {
        return Maps.transformEntries(this.fromMap().tailMap(object), this.transformer);
    }
}

