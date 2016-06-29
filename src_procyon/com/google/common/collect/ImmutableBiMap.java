package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public abstract class ImmutableBiMap extends ImmutableMap implements BiMap
{
    public static ImmutableBiMap of() {
        return RegularImmutableBiMap.EMPTY;
    }
    
    public static ImmutableBiMap of(final Object o, final Object o2) {
        return new SingletonImmutableBiMap(o, o2);
    }
    
    public static ImmutableBiMap of(final Object o, final Object o2, final Object o3, final Object o4) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(o, o2), ImmutableMap.entryOf(o3, o4));
    }
    
    public static ImmutableBiMap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(o, o2), ImmutableMap.entryOf(o3, o4), ImmutableMap.entryOf(o5, o6));
    }
    
    public static ImmutableBiMap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(o, o2), ImmutableMap.entryOf(o3, o4), ImmutableMap.entryOf(o5, o6), ImmutableMap.entryOf(o7, o8));
    }
    
    public static ImmutableBiMap of(final Object o, final Object o2, final Object o3, final Object o4, final Object o5, final Object o6, final Object o7, final Object o8, final Object o9, final Object o10) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(o, o2), ImmutableMap.entryOf(o3, o4), ImmutableMap.entryOf(o5, o6), ImmutableMap.entryOf(o7, o8), ImmutableMap.entryOf(o9, o10));
    }
    
    public static ImmutableBiMap$Builder builder() {
        return new ImmutableBiMap$Builder();
    }
    
    public static ImmutableBiMap copyOf(final Map map) {
        if (map instanceof ImmutableBiMap) {
            final ImmutableBiMap immutableBiMap = (ImmutableBiMap)map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf(map.entrySet());
    }
    
    @Beta
    public static ImmutableBiMap copyOf(final Iterable iterable) {
        final Entry[] array = (Entry[])Iterables.toArray(iterable, ImmutableBiMap.EMPTY_ENTRY_ARRAY);
        switch (array.length) {
            case 0: {
                return of();
            }
            case 1: {
                final Entry entry = array[0];
                return of(entry.getKey(), entry.getValue());
            }
            default: {
                return RegularImmutableBiMap.fromEntries(array);
            }
        }
    }
    
    @Override
    public abstract ImmutableBiMap inverse();
    
    @Override
    public ImmutableSet values() {
        return this.inverse().keySet();
    }
    
    @Deprecated
    @Override
    public Object forcePut(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableBiMap$SerializedForm(this);
    }
}
