package com.google.common.collect;

import java.io.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public abstract class ImmutableMap implements Serializable, Map
{
    static final Entry[] EMPTY_ENTRY_ARRAY;
    @LazyInit
    private transient ImmutableSet entrySet;
    @LazyInit
    private transient ImmutableSet keySet;
    @LazyInit
    private transient ImmutableCollection values;
    @LazyInit
    private transient ImmutableSetMultimap multimapView;
    
    public static ImmutableMap of() {
        return ImmutableBiMap.of();
    }
    
    public static ImmutableMap of(final Object o, final Object o2) {
        return ImmutableBiMap.of(o, o2);
    }
    
    public static ImmutableMap of(final Object o, final Object o2, final Object o3, final Object o4) {
        return RegularImmutableMap.fromEntries(entryOf(o, o2), entryOf(o3, o4));
    }
    
    public static ImmutableMap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6) {
        return RegularImmutableMap.fromEntries(entryOf(o, o2), entryOf(o3, o4), entryOf(o5, o6));
    }
    
    public static ImmutableMap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8) {
        return RegularImmutableMap.fromEntries(entryOf(o, o2), entryOf(o3, o4), entryOf(o5, o6), entryOf(o7, o8));
    }
    
    public static ImmutableMap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10) {
        return RegularImmutableMap.fromEntries(entryOf(o, o2), entryOf(o3, o4), entryOf(o5, o6), entryOf(o7, o8), entryOf(o9, o10));
    }
    
    static ImmutableMapEntry entryOf(final Object o, final Object o2) {
        return new ImmutableMapEntry(o, o2);
    }
    
    public static ImmutableMap$Builder builder() {
        return new ImmutableMap$Builder();
    }
    
    static void checkNoConflict(final boolean b, final String s, final Entry entry, final Entry entry2) {
        if (!b) {
            final String value = String.valueOf(entry);
            final String value2 = String.valueOf(entry2);
            throw new IllegalArgumentException(new StringBuilder(34 + String.valueOf(s).length() + String.valueOf(value).length() + String.valueOf(value2).length()).append("Multiple entries with same ").append(s).append(": ").append(value).append(" and ").append(value2).toString());
        }
    }
    
    public static ImmutableMap copyOf(final Map map) {
        if (map instanceof ImmutableMap && !(map instanceof ImmutableSortedMap)) {
            final ImmutableMap immutableMap = (ImmutableMap)map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        else if (map instanceof EnumMap) {
            return copyOfEnumMap((EnumMap<Object, Object>)map);
        }
        return copyOf(map.entrySet());
    }
    
    @Beta
    public static ImmutableMap copyOf(final Iterable iterable) {
        final Entry[] array = (Entry[])Iterables.toArray(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
        switch (array.length) {
            case 0: {
                return of();
            }
            case 1: {
                final Entry entry = array[0];
                return of(entry.getKey(), entry.getValue());
            }
            default: {
                return RegularImmutableMap.fromEntries(array);
            }
        }
    }
    
    private static ImmutableMap copyOfEnumMap(final EnumMap enumMap) {
        final EnumMap<Object, Object> enumMap2 = new EnumMap<Object, Object>(enumMap);
        for (final Entry<Object, V> entry : enumMap2.entrySet()) {
            CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(enumMap2);
    }
    
    @Deprecated
    @Override
    public final Object put(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Object remove(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final void putAll(final Map map) {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.get(o) != null;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.values().contains(o);
    }
    
    @Override
    public abstract Object get(@Nullable final Object p0);
    
    @Override
    public ImmutableSet entrySet() {
        final ImmutableSet entrySet = this.entrySet;
        return (entrySet == null) ? (this.entrySet = this.createEntrySet()) : entrySet;
    }
    
    abstract ImmutableSet createEntrySet();
    
    @Override
    public ImmutableSet keySet() {
        final ImmutableSet keySet = this.keySet;
        return (keySet == null) ? (this.keySet = this.createKeySet()) : keySet;
    }
    
    ImmutableSet createKeySet() {
        return this.isEmpty() ? ImmutableSet.of() : new ImmutableMapKeySet(this);
    }
    
    UnmodifiableIterator keyIterator() {
        return new ImmutableMap$1(this, this.entrySet().iterator());
    }
    
    @Override
    public ImmutableCollection values() {
        final ImmutableCollection values = this.values;
        return (values == null) ? (this.values = new ImmutableMapValues(this)) : values;
    }
    
    @Beta
    public ImmutableSetMultimap asMultimap() {
        if (this.isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        final ImmutableSetMultimap multimapView = this.multimapView;
        return (multimapView == null) ? (this.multimapView = new ImmutableSetMultimap(new ImmutableMap$MapViewOfValuesAsSingletonSets(this, null), this.size(), null)) : multimapView;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Maps.equalsImpl(this, o);
    }
    
    abstract boolean isPartialView();
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }
    
    boolean isHashCodeFast() {
        return false;
    }
    
    @Override
    public String toString() {
        return Maps.toStringImpl(this);
    }
    
    Object writeReplace() {
        return new ImmutableMap$SerializedForm(this);
    }
    
    static {
        EMPTY_ENTRY_ARRAY = new Entry[0];
    }
}
