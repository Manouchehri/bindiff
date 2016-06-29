/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import com.google.j2objc.annotations.Weak;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Maps$KeySet
extends Sets$ImprovedAbstractSet {
    @Weak
    final Map map;

    Maps$KeySet(Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }

    Map map() {
        return this.map;
    }

    @Override
    public Iterator iterator() {
        return Maps.keyIterator(this.map().entrySet().iterator());
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
    public boolean contains(Object object) {
        return this.map().containsKey(object);
    }

    @Override
    public boolean remove(Object object) {
        if (!this.contains(object)) return false;
        this.map().remove(object);
        return true;
    }

    @Override
    public void clear() {
        this.map().clear();
    }
}

