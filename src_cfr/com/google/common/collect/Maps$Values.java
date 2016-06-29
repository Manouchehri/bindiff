/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$Values
extends AbstractCollection {
    @Weak
    final Map map;

    Maps$Values(Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }

    final Map map() {
        return this.map;
    }

    @Override
    public Iterator iterator() {
        return Maps.valueIterator(this.map().entrySet().iterator());
    }

    @Override
    public boolean remove(Object object) {
        try {
            return super.remove(object);
        }
        catch (UnsupportedOperationException var2_2) {
            Map.Entry entry;
            Iterator iterator = this.map().entrySet().iterator();
            do {
                if (!iterator.hasNext()) return false;
            } while (!Objects.equal(object, (entry = iterator.next()).getValue()));
            this.map().remove(entry.getKey());
            return true;
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        try {
            return super.removeAll((Collection)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException var2_2) {
            HashSet hashSet = Sets.newHashSet();
            Iterator iterator = this.map().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                if (!collection.contains(entry.getValue())) continue;
                hashSet.add(entry.getKey());
            }
            return this.map().keySet().removeAll(hashSet);
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        try {
            return super.retainAll((Collection)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException var2_2) {
            HashSet hashSet = Sets.newHashSet();
            Iterator iterator = this.map().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = iterator.next();
                if (!collection.contains(entry.getValue())) continue;
                hashSet.add(entry.getKey());
            }
            return this.map().keySet().retainAll(hashSet);
        }
    }

    @Override
    public int size() {
        return this.map().size();
    }

    @Override
    public boolean isEmpty() {
        return this.map().isEmpty();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.map().containsValue(object);
    }

    @Override
    public void clear() {
        this.map().clear();
    }
}

