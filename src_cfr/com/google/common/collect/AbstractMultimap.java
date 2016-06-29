/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap$1;
import com.google.common.collect.AbstractMultimap$Entries;
import com.google.common.collect.AbstractMultimap$EntrySet;
import com.google.common.collect.AbstractMultimap$Values;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multimaps$Keys;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMultimap
implements Multimap {
    private transient Collection entries;
    private transient Set keySet;
    private transient Multiset keys;
    private transient Collection values;
    private transient Map asMap;

    AbstractMultimap() {
    }

    @Override
    public boolean isEmpty() {
        if (this.size() != 0) return false;
        return true;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        Collection collection;
        Iterator iterator = this.asMap().values().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(collection = (Collection)iterator.next()).contains(object));
        return true;
    }

    @Override
    public boolean containsEntry(@Nullable Object object, @Nullable Object object2) {
        Collection collection = (Collection)this.asMap().get(object);
        if (collection == null) return false;
        if (!collection.contains(object2)) return false;
        return true;
    }

    @Override
    public boolean remove(@Nullable Object object, @Nullable Object object2) {
        Collection collection = (Collection)this.asMap().get(object);
        if (collection == null) return false;
        if (!collection.remove(object2)) return false;
        return true;
    }

    @Override
    public boolean put(@Nullable Object object, @Nullable Object object2) {
        return this.get(object).add(object2);
    }

    @Override
    public boolean putAll(@Nullable Object object, Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            if (collection.isEmpty()) return false;
            if (!this.get(object).addAll(collection)) return false;
            return true;
        }
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) return false;
        if (!Iterators.addAll(this.get(object), iterator)) return false;
        return true;
    }

    @Override
    public boolean putAll(Multimap multimap) {
        boolean bl2 = false;
        Iterator iterator = multimap.entries().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            bl2 |= this.put(entry.getKey(), entry.getValue());
        }
        return bl2;
    }

    @Override
    public Collection replaceValues(@Nullable Object object, Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        Collection collection = this.removeAll(object);
        this.putAll(object, iterable);
        return collection;
    }

    @Override
    public Collection entries() {
        Collection collection;
        Collection collection2 = this.entries;
        if (collection2 == null) {
            collection = this.entries = this.createEntries();
            return collection;
        }
        collection = collection2;
        return collection;
    }

    Collection createEntries() {
        if (!(this instanceof SetMultimap)) return new AbstractMultimap$Entries(this, null);
        return new AbstractMultimap$EntrySet(this, null);
    }

    abstract Iterator entryIterator();

    @Override
    public Set keySet() {
        Set set;
        Set set2 = this.keySet;
        if (set2 == null) {
            set = this.keySet = this.createKeySet();
            return set;
        }
        set = set2;
        return set;
    }

    Set createKeySet() {
        return new Maps$KeySet(this.asMap());
    }

    @Override
    public Multiset keys() {
        Multiset multiset;
        Multiset multiset2 = this.keys;
        if (multiset2 == null) {
            multiset = this.keys = this.createKeys();
            return multiset;
        }
        multiset = multiset2;
        return multiset;
    }

    Multiset createKeys() {
        return new Multimaps$Keys(this);
    }

    @Override
    public Collection values() {
        Collection collection;
        Collection collection2 = this.values;
        if (collection2 == null) {
            collection = this.values = this.createValues();
            return collection;
        }
        collection = collection2;
        return collection;
    }

    Collection createValues() {
        return new AbstractMultimap$Values(this);
    }

    Iterator valueIterator() {
        return Maps.valueIterator(this.entries().iterator());
    }

    @Override
    public Map asMap() {
        Map map;
        Map map2 = this.asMap;
        if (map2 == null) {
            map = this.asMap = this.createAsMap();
            return map;
        }
        map = map2;
        return map;
    }

    abstract Map createAsMap();

    @Override
    public boolean equals(@Nullable Object object) {
        return Multimaps.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        return this.asMap().hashCode();
    }

    public String toString() {
        return this.asMap().toString();
    }
}

