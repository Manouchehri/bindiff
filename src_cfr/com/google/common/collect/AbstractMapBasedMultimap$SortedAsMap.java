/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMapBasedMultimap$SortedAsMap
extends AbstractMapBasedMultimap$AsMap
implements SortedMap {
    SortedSet sortedKeySet;
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$SortedAsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, SortedMap sortedMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, sortedMap);
    }

    SortedMap sortedMap() {
        return (SortedMap)this.submap;
    }

    public Comparator comparator() {
        return this.sortedMap().comparator();
    }

    public Object firstKey() {
        return this.sortedMap().firstKey();
    }

    public Object lastKey() {
        return this.sortedMap().lastKey();
    }

    public SortedMap headMap(Object object) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().headMap(object));
    }

    public SortedMap subMap(Object object, Object object2) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().subMap(object, object2));
    }

    public SortedMap tailMap(Object object) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().tailMap(object));
    }

    @Override
    public SortedSet keySet() {
        SortedSet sortedSet;
        SortedSet sortedSet2 = this.sortedKeySet;
        if (sortedSet2 == null) {
            sortedSet = this.sortedKeySet = this.createKeySet();
            return sortedSet;
        }
        sortedSet = sortedSet2;
        return sortedSet;
    }

    @Override
    SortedSet createKeySet() {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap());
    }
}

