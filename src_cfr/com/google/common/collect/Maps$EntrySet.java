/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Maps$EntrySet
extends Sets$ImprovedAbstractSet {
    Maps$EntrySet() {
    }

    abstract Map map();

    @Override
    public int size() {
        return this.map().size();
    }

    @Override
    public void clear() {
        this.map().clear();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) return false;
        Map.Entry entry = (Map.Entry)object;
        K k2 = entry.getKey();
        Object object2 = Maps.safeGet(this.map(), k2);
        if (!Objects.equal(object2, entry.getValue())) return false;
        if (object2 != null) return true;
        if (!this.map().containsKey(k2)) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.map().isEmpty();
    }

    @Override
    public boolean remove(Object object) {
        if (!this.contains(object)) return false;
        Map.Entry entry = (Map.Entry)object;
        return this.map().keySet().remove(entry.getKey());
    }

    @Override
    public boolean removeAll(Collection collection) {
        try {
            return super.removeAll((Collection)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException var2_2) {
            return Sets.removeAllImpl((Set)this, collection.iterator());
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        try {
            return super.retainAll((Collection)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException var2_2) {
            HashSet hashSet = Sets.newHashSetWithExpectedSize(collection.size());
            Iterator<E> iterator = collection.iterator();
            while (iterator.hasNext()) {
                E e2 = iterator.next();
                if (!this.contains(e2)) continue;
                Map.Entry entry = (Map.Entry)e2;
                hashSet.add(entry.getKey());
            }
            return this.map().keySet().retainAll(hashSet);
        }
    }
}

