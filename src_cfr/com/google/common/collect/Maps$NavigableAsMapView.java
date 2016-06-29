/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

@GwtIncompatible(value="NavigableMap")
final class Maps$NavigableAsMapView
extends AbstractNavigableMap {
    private final NavigableSet set;
    private final Function function;

    Maps$NavigableAsMapView(NavigableSet navigableSet, Function function) {
        this.set = (NavigableSet)Preconditions.checkNotNull(navigableSet);
        this.function = (Function)Preconditions.checkNotNull(function);
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return Maps.asMap(this.set.subSet(object, bl2, object2, bl3), this.function);
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return Maps.asMap(this.set.headSet(object, bl2), this.function);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return Maps.asMap(this.set.tailSet(object, bl2), this.function);
    }

    @Override
    public Comparator comparator() {
        return this.set.comparator();
    }

    @Nullable
    @Override
    public Object get(@Nullable Object object) {
        if (!Collections2.safeContains(this.set, object)) return null;
        Object object2 = object;
        return this.function.apply(object2);
    }

    @Override
    public void clear() {
        this.set.clear();
    }

    @Override
    Iterator entryIterator() {
        return Maps.asMapEntryIterator(this.set, this.function);
    }

    @Override
    Iterator descendingEntryIterator() {
        return this.descendingMap().entrySet().iterator();
    }

    @Override
    public NavigableSet navigableKeySet() {
        return Maps.access$400(this.set);
    }

    @Override
    public int size() {
        return this.set.size();
    }

    @Override
    public NavigableMap descendingMap() {
        return Maps.asMap(this.set.descendingSet(), this.function);
    }
}

