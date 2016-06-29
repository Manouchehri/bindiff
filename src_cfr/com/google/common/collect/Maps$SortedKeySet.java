/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$KeySet;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$SortedKeySet
extends Maps$KeySet
implements SortedSet {
    Maps$SortedKeySet(SortedMap sortedMap) {
        super(sortedMap);
    }

    @Override
    SortedMap map() {
        return (SortedMap)super.map();
    }

    public Comparator comparator() {
        return this.map().comparator();
    }

    public SortedSet subSet(Object object, Object object2) {
        return new Maps$SortedKeySet(this.map().subMap(object, object2));
    }

    public SortedSet headSet(Object object) {
        return new Maps$SortedKeySet(this.map().headMap(object));
    }

    public SortedSet tailSet(Object object) {
        return new Maps$SortedKeySet(this.map().tailMap(object));
    }

    public Object first() {
        return this.map().firstKey();
    }

    public Object last() {
        return this.map().lastKey();
    }
}

