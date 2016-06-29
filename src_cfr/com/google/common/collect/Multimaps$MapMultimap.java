/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap;
import com.google.common.collect.Multimaps$MapMultimap$1;
import com.google.common.collect.SetMultimap;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Multimaps$MapMultimap
extends AbstractMultimap
implements SetMultimap,
Serializable {
    final Map map;
    private static final long serialVersionUID = 7845222491160860175L;

    Multimaps$MapMultimap(Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.map.containsValue(object);
    }

    @Override
    public boolean containsEntry(Object object, Object object2) {
        return this.map.entrySet().contains(Maps.immutableEntry(object, object2));
    }

    @Override
    public Set get(Object object) {
        return new Multimaps$MapMultimap$1(this, object);
    }

    @Override
    public boolean put(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean putAll(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean putAll(Multimap multimap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object, Object object2) {
        return this.map.entrySet().remove(Maps.immutableEntry(object, object2));
    }

    @Override
    public Set removeAll(Object object) {
        HashSet hashSet = new HashSet(2);
        if (!this.map.containsKey(object)) {
            return hashSet;
        }
        hashSet.add(this.map.remove(object));
        return hashSet;
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Set keySet() {
        return this.map.keySet();
    }

    @Override
    public Collection values() {
        return this.map.values();
    }

    @Override
    public Set entries() {
        return this.map.entrySet();
    }

    @Override
    Iterator entryIterator() {
        return this.map.entrySet().iterator();
    }

    @Override
    Map createAsMap() {
        return new Multimaps$AsMap(this);
    }

    @Override
    public int hashCode() {
        return this.map.hashCode();
    }
}

