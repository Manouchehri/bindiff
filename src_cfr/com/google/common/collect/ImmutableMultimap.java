/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap$1;
import com.google.common.collect.ImmutableMultimap$2;
import com.google.common.collect.ImmutableMultimap$Builder;
import com.google.common.collect.ImmutableMultimap$EntryCollection;
import com.google.common.collect.ImmutableMultimap$Keys;
import com.google.common.collect.ImmutableMultimap$Values;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public abstract class ImmutableMultimap
extends AbstractMultimap
implements Serializable {
    final transient ImmutableMap map;
    final transient int size;
    private static final long serialVersionUID = 0;

    public static ImmutableMultimap of() {
        return ImmutableListMultimap.of();
    }

    public static ImmutableMultimap of(Object object, Object object2) {
        return ImmutableListMultimap.of(object, object2);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4) {
        return ImmutableListMultimap.of(object, object2, object3, object4);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        return ImmutableListMultimap.of(object, object2, object3, object4, object5, object6);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        return ImmutableListMultimap.of(object, object2, object3, object4, object5, object6, object7, object8);
    }

    public static ImmutableMultimap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        return ImmutableListMultimap.of(object, object2, object3, object4, object5, object6, object7, object8, object9, object10);
    }

    public static ImmutableMultimap$Builder builder() {
        return new ImmutableMultimap$Builder();
    }

    public static ImmutableMultimap copyOf(Multimap multimap) {
        if (!(multimap instanceof ImmutableMultimap)) return ImmutableListMultimap.copyOf(multimap);
        ImmutableMultimap immutableMultimap = (ImmutableMultimap)multimap;
        if (immutableMultimap.isPartialView()) return ImmutableListMultimap.copyOf(multimap);
        return immutableMultimap;
    }

    @Beta
    public static ImmutableMultimap copyOf(Iterable iterable) {
        return ImmutableListMultimap.copyOf(iterable);
    }

    ImmutableMultimap(ImmutableMap immutableMap, int n2) {
        this.map = immutableMap;
        this.size = n2;
    }

    @Deprecated
    @Override
    public ImmutableCollection removeAll(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public ImmutableCollection replaceValues(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract ImmutableCollection get(Object var1);

    public abstract ImmutableMultimap inverse();

    @Deprecated
    @Override
    public boolean put(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public boolean putAll(Object object, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public boolean putAll(Multimap multimap) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public boolean remove(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        if (object == null) return false;
        if (!super.containsValue(object)) return false;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableSet keySet() {
        return this.map.keySet();
    }

    @Override
    public ImmutableMap asMap() {
        return this.map;
    }

    @Override
    Map createAsMap() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public ImmutableCollection entries() {
        return (ImmutableCollection)super.entries();
    }

    @Override
    ImmutableCollection createEntries() {
        return new ImmutableMultimap$EntryCollection(this);
    }

    @Override
    UnmodifiableIterator entryIterator() {
        return new ImmutableMultimap$1(this);
    }

    @Override
    public ImmutableMultiset keys() {
        return (ImmutableMultiset)super.keys();
    }

    @Override
    ImmutableMultiset createKeys() {
        return new ImmutableMultimap$Keys(this);
    }

    @Override
    public ImmutableCollection values() {
        return (ImmutableCollection)super.values();
    }

    @Override
    ImmutableCollection createValues() {
        return new ImmutableMultimap$Values(this);
    }

    @Override
    UnmodifiableIterator valueIterator() {
        return new ImmutableMultimap$2(this);
    }
}

