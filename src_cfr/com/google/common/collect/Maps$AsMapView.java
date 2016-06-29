/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView$1EntrySetImpl;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$AsMapView
extends Maps$ViewCachingAbstractMap {
    private final Set set;
    final Function function;

    Set backingSet() {
        return this.set;
    }

    Maps$AsMapView(Set set, Function function) {
        this.set = (Set)Preconditions.checkNotNull(set);
        this.function = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public Set createKeySet() {
        return Maps.access$200(this.backingSet());
    }

    @Override
    Collection createValues() {
        return Collections2.transform(this.set, this.function);
    }

    @Override
    public int size() {
        return this.backingSet().size();
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.backingSet().contains(object);
    }

    @Override
    public Object get(@Nullable Object object) {
        if (!Collections2.safeContains(this.backingSet(), object)) return null;
        Object object2 = object;
        return this.function.apply(object2);
    }

    @Override
    public Object remove(@Nullable Object object) {
        if (!this.backingSet().remove(object)) return null;
        Object object2 = object;
        return this.function.apply(object2);
    }

    @Override
    public void clear() {
        this.backingSet().clear();
    }

    @Override
    protected Set createEntrySet() {
        return new Maps$AsMapView$1EntrySetImpl(this);
    }
}

