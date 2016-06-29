/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap$1;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Multimaps$TransformedEntriesMultimap
extends AbstractMultimap {
    final Multimap fromMultimap;
    final Maps$EntryTransformer transformer;

    Multimaps$TransformedEntriesMultimap(Multimap multimap, Maps$EntryTransformer maps$EntryTransformer) {
        this.fromMultimap = (Multimap)Preconditions.checkNotNull(multimap);
        this.transformer = (Maps$EntryTransformer)Preconditions.checkNotNull(maps$EntryTransformer);
    }

    Collection transform(Object object, Collection collection) {
        Function function = Maps.asValueToValueFunction(this.transformer, object);
        if (!(collection instanceof List)) return Collections2.transform(collection, function);
        return Lists.transform((List)collection, function);
    }

    @Override
    Map createAsMap() {
        return Maps.transformEntries(this.fromMultimap.asMap(), (Maps$EntryTransformer)new Multimaps$TransformedEntriesMultimap$1(this));
    }

    @Override
    public void clear() {
        this.fromMultimap.clear();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.fromMultimap.containsKey(object);
    }

    @Override
    Iterator entryIterator() {
        return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
    }

    @Override
    public Collection get(Object object) {
        return this.transform(object, this.fromMultimap.get(object));
    }

    @Override
    public boolean isEmpty() {
        return this.fromMultimap.isEmpty();
    }

    @Override
    public Set keySet() {
        return this.fromMultimap.keySet();
    }

    @Override
    public Multiset keys() {
        return this.fromMultimap.keys();
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
        return this.get(object).remove(object2);
    }

    @Override
    public Collection removeAll(Object object) {
        return this.transform(object, this.fromMultimap.removeAll(object));
    }

    @Override
    public Collection replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.fromMultimap.size();
    }

    @Override
    Collection createValues() {
        return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
    }
}

