/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Maps$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Maps$TransformedEntriesMap
extends Maps$IteratorBasedAbstractMap {
    final Map fromMap;
    final Maps$EntryTransformer transformer;

    Maps$TransformedEntriesMap(Map map, Maps$EntryTransformer maps$EntryTransformer) {
        this.fromMap = (Map)Preconditions.checkNotNull(map);
        this.transformer = (Maps$EntryTransformer)Preconditions.checkNotNull(maps$EntryTransformer);
    }

    @Override
    public int size() {
        return this.fromMap.size();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.fromMap.containsKey(object);
    }

    @Override
    public Object get(Object object) {
        Object v2 = this.fromMap.get(object);
        if (v2 == null && !this.fromMap.containsKey(object)) {
            return null;
        }
        Object object2 = this.transformer.transformEntry(object, v2);
        return object2;
    }

    @Override
    public Object remove(Object object) {
        if (!this.fromMap.containsKey(object)) return null;
        Object object2 = this.transformer.transformEntry(object, this.fromMap.remove(object));
        return object2;
    }

    @Override
    public void clear() {
        this.fromMap.clear();
    }

    @Override
    public Set keySet() {
        return this.fromMap.keySet();
    }

    @Override
    Iterator entryIterator() {
        return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
    }

    @Override
    public Collection values() {
        return new Maps$Values(this);
    }
}

