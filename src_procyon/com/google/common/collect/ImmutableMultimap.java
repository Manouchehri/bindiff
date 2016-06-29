package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap extends AbstractMultimap implements Serializable
{
    final transient ImmutableMap map;
    final transient int size;
    private static final long serialVersionUID = 0L;
    
    public static ImmutableMultimap of() {
        return ImmutableListMultimap.of();
    }
    
    public static ImmutableMultimap of(final Object o, final Object o2) {
        return ImmutableListMultimap.of(o, o2);
    }
    
    public static ImmutableMultimap of(final Object o, final Object o2, final Object o3, final Object o4) {
        return ImmutableListMultimap.of(o, o2, o3, o4);
    }
    
    public static ImmutableMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6) {
        return ImmutableListMultimap.of(o, o2, o3, o4, o5, o6);
    }
    
    public static ImmutableMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8) {
        return ImmutableListMultimap.of(o, o2, o3, o4, o5, o6, o7, o8);
    }
    
    public static ImmutableMultimap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10) {
        return ImmutableListMultimap.of(o, o2, o3, o4, o5, o6, o7, o8, o9, o10);
    }
    
    public static ImmutableMultimap$Builder builder() {
        return new ImmutableMultimap$Builder();
    }
    
    public static ImmutableMultimap copyOf(final Multimap multimap) {
        if (multimap instanceof ImmutableMultimap) {
            final ImmutableMultimap immutableMultimap = (ImmutableMultimap)multimap;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf(multimap);
    }
    
    @Beta
    public static ImmutableMultimap copyOf(final Iterable iterable) {
        return ImmutableListMultimap.copyOf(iterable);
    }
    
    ImmutableMultimap(final ImmutableMap map, final int size) {
        this.map = map;
        this.size = size;
    }
    
    @Deprecated
    @Override
    public ImmutableCollection removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public ImmutableCollection replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public abstract ImmutableCollection get(final Object p0);
    
    public abstract ImmutableMultimap inverse();
    
    @Deprecated
    @Override
    public boolean put(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public boolean putAll(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public boolean putAll(final Multimap multimap) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public boolean remove(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    boolean isPartialView() {
        return this.map.isPartialView();
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return o != null && super.containsValue(o);
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
