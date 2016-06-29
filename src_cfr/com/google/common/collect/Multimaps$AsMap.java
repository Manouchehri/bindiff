/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$AsMap$EntrySet;
import com.google.j2objc.annotations.Weak;
import java.util.Collection;
import java.util.Set;

final class Multimaps$AsMap
extends Maps$ViewCachingAbstractMap {
    @Weak
    private final Multimap multimap;

    Multimaps$AsMap(Multimap multimap) {
        this.multimap = (Multimap)Preconditions.checkNotNull(multimap);
    }

    @Override
    public int size() {
        return this.multimap.keySet().size();
    }

    @Override
    protected Set createEntrySet() {
        return new Multimaps$AsMap$EntrySet(this);
    }

    void removeValuesForKey(Object object) {
        this.multimap.keySet().remove(object);
    }

    @Override
    public Collection get(Object object) {
        if (!this.containsKey(object)) return null;
        Collection collection = this.multimap.get(object);
        return collection;
    }

    @Override
    public Collection remove(Object object) {
        if (!this.containsKey(object)) return null;
        Collection collection = this.multimap.removeAll(object);
        return collection;
    }

    @Override
    public Set keySet() {
        return this.multimap.keySet();
    }

    @Override
    public boolean isEmpty() {
        return this.multimap.isEmpty();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.multimap.containsKey(object);
    }

    @Override
    public void clear() {
        this.multimap.clear();
    }

    static /* synthetic */ Multimap access$200(Multimaps$AsMap multimaps$AsMap) {
        return multimaps$AsMap.multimap;
    }
}

