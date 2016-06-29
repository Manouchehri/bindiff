/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multimaps$UnmodifiableMultimap$1;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

class Multimaps$UnmodifiableMultimap
extends ForwardingMultimap
implements Serializable {
    final Multimap delegate;
    transient Collection entries;
    transient Multiset keys;
    transient Set keySet;
    transient Collection values;
    transient Map map;
    private static final long serialVersionUID = 0;

    Multimaps$UnmodifiableMultimap(Multimap multimap) {
        this.delegate = (Multimap)Preconditions.checkNotNull(multimap);
    }

    @Override
    protected Multimap delegate() {
        return this.delegate;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map asMap() {
        Map map = this.map;
        if (map != null) return map;
        this.map = Collections.unmodifiableMap(Maps.transformValues(this.delegate.asMap(), (Function)new Multimaps$UnmodifiableMultimap$1(this)));
        return this.map;
    }

    @Override
    public Collection entries() {
        Collection collection = this.entries;
        if (collection != null) return collection;
        this.entries = collection = Multimaps.access$100(this.delegate.entries());
        return collection;
    }

    @Override
    public Collection get(Object object) {
        return Multimaps.access$000(this.delegate.get(object));
    }

    @Override
    public Multiset keys() {
        Multiset multiset = this.keys;
        if (multiset != null) return multiset;
        this.keys = multiset = Multisets.unmodifiableMultiset(this.delegate.keys());
        return multiset;
    }

    @Override
    public Set keySet() {
        Set set = this.keySet;
        if (set != null) return set;
        this.keySet = set = Collections.unmodifiableSet(this.delegate.keySet());
        return set;
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
    public boolean remove(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) return collection;
        this.values = collection = Collections.unmodifiableCollection(this.delegate.values());
        return collection;
    }
}

