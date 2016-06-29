/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredMapValues;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

abstract class Maps$AbstractFilteredMap
extends Maps$ViewCachingAbstractMap {
    final Map unfiltered;
    final Predicate predicate;

    Maps$AbstractFilteredMap(Map map, Predicate predicate) {
        this.unfiltered = map;
        this.predicate = predicate;
    }

    boolean apply(@Nullable Object object, @Nullable Object object2) {
        Object object3 = object;
        return this.predicate.apply(Maps.immutableEntry(object3, object2));
    }

    @Override
    public Object put(Object object, Object object2) {
        Preconditions.checkArgument(this.apply(object, object2));
        return this.unfiltered.put(object, object2);
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        do {
            if (!iterator.hasNext()) {
                this.unfiltered.putAll(map);
                return;
            }
            Map.Entry entry = iterator.next();
            Preconditions.checkArgument(this.apply(entry.getKey(), entry.getValue()));
        } while (true);
    }

    @Override
    public boolean containsKey(Object object) {
        if (!this.unfiltered.containsKey(object)) return false;
        if (!this.apply(object, this.unfiltered.get(object))) return false;
        return true;
    }

    @Override
    public Object get(Object object) {
        Object v2 = this.unfiltered.get(object);
        if (v2 == null) return null;
        if (!this.apply(object, v2)) return null;
        Object v0 = v2;
        return v0;
    }

    @Override
    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }

    @Override
    public Object remove(Object object) {
        if (!this.containsKey(object)) return null;
        Object v0 = this.unfiltered.remove(object);
        return v0;
    }

    @Override
    Collection createValues() {
        return new Maps$FilteredMapValues(this, this.unfiltered, this.predicate);
    }
}

