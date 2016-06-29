/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$SortedAsMapView
extends Maps$AsMapView
implements SortedMap {
    Maps$SortedAsMapView(SortedSet sortedSet, Function function) {
        super(sortedSet, function);
    }

    @Override
    SortedSet backingSet() {
        return (SortedSet)super.backingSet();
    }

    public Comparator comparator() {
        return this.backingSet().comparator();
    }

    @Override
    public Set keySet() {
        return Maps.access$300(this.backingSet());
    }

    public SortedMap subMap(Object object, Object object2) {
        return Maps.asMap(this.backingSet().subSet(object, object2), this.function);
    }

    public SortedMap headMap(Object object) {
        return Maps.asMap(this.backingSet().headSet(object), this.function);
    }

    public SortedMap tailMap(Object object) {
        return Maps.asMap(this.backingSet().tailSet(object), this.function);
    }

    public Object firstKey() {
        return this.backingSet().first();
    }

    public Object lastKey() {
        return this.backingSet().last();
    }
}

