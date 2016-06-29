/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapEntries;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap$AsMapIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$AsMap
extends Maps$ViewCachingAbstractMap {
    final transient Map submap;
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$AsMap(AbstractMapBasedMultimap abstractMapBasedMultimap, Map map) {
        this.this$0 = abstractMapBasedMultimap;
        this.submap = map;
    }

    @Override
    protected Set createEntrySet() {
        return new AbstractMapBasedMultimap$AsMap$AsMapEntries(this);
    }

    @Override
    public boolean containsKey(Object object) {
        return Maps.safeContainsKey(this.submap, object);
    }

    @Override
    public Collection get(Object object) {
        Collection collection = (Collection)Maps.safeGet(this.submap, object);
        if (collection == null) {
            return null;
        }
        Object object2 = object;
        return this.this$0.wrapCollection(object2, collection);
    }

    @Override
    public Set keySet() {
        return this.this$0.keySet();
    }

    @Override
    public int size() {
        return this.submap.size();
    }

    @Override
    public Collection remove(Object object) {
        Collection collection = (Collection)this.submap.remove(object);
        if (collection == null) {
            return null;
        }
        Collection collection2 = this.this$0.createCollection();
        collection2.addAll(collection);
        AbstractMapBasedMultimap.access$202(this.this$0, AbstractMapBasedMultimap.access$200(this.this$0) - collection.size());
        collection.clear();
        return collection2;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (this == object) return true;
        if (this.submap.equals(object)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.submap.hashCode();
    }

    @Override
    public String toString() {
        return this.submap.toString();
    }

    @Override
    public void clear() {
        if (this.submap == AbstractMapBasedMultimap.access$000(this.this$0)) {
            this.this$0.clear();
            return;
        }
        Iterators.clear(new AbstractMapBasedMultimap$AsMap$AsMapIterator(this));
    }

    Map.Entry wrapEntry(Map.Entry entry) {
        Object k2 = entry.getKey();
        return Maps.immutableEntry(k2, this.this$0.wrapCollection(k2, (Collection)entry.getValue()));
    }
}

