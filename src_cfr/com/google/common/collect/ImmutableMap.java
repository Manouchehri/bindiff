/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableMap$1;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMap$MapViewOfValuesAsSingletonSets;
import com.google.common.collect.ImmutableMap$SerializedForm;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapKeySet;
import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public abstract class ImmutableMap
implements Serializable,
Map {
    static final Map.Entry[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
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

    public static ImmutableMap of(Object object, Object object2) {
        return ImmutableBiMap.of(object, object2);
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4) {
        return RegularImmutableMap.fromEntries(ImmutableMap.entryOf(object, object2), ImmutableMap.entryOf(object3, object4));
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        return RegularImmutableMap.fromEntries(ImmutableMap.entryOf(object, object2), ImmutableMap.entryOf(object3, object4), ImmutableMap.entryOf(object5, object6));
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        return RegularImmutableMap.fromEntries(ImmutableMap.entryOf(object, object2), ImmutableMap.entryOf(object3, object4), ImmutableMap.entryOf(object5, object6), ImmutableMap.entryOf(object7, object8));
    }

    public static ImmutableMap of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        return RegularImmutableMap.fromEntries(ImmutableMap.entryOf(object, object2), ImmutableMap.entryOf(object3, object4), ImmutableMap.entryOf(object5, object6), ImmutableMap.entryOf(object7, object8), ImmutableMap.entryOf(object9, object10));
    }

    static ImmutableMapEntry entryOf(Object object, Object object2) {
        return new ImmutableMapEntry(object, object2);
    }

    public static ImmutableMap$Builder builder() {
        return new ImmutableMap$Builder();
    }

    static void checkNoConflict(boolean bl2, String string, Map.Entry entry, Map.Entry entry2) {
        if (bl2) return;
        String string2 = String.valueOf(entry);
        String string3 = String.valueOf(entry2);
        throw new IllegalArgumentException(new StringBuilder(34 + String.valueOf(string).length() + String.valueOf(string2).length() + String.valueOf(string3).length()).append("Multiple entries with same ").append(string).append(": ").append(string2).append(" and ").append(string3).toString());
    }

    public static ImmutableMap copyOf(Map map) {
        if (map instanceof ImmutableMap && !(map instanceof ImmutableSortedMap)) {
            ImmutableMap immutableMap = (ImmutableMap)map;
            if (immutableMap.isPartialView()) return ImmutableMap.copyOf(map.entrySet());
            return immutableMap;
        }
        if (!(map instanceof EnumMap)) return ImmutableMap.copyOf(map.entrySet());
        return ImmutableMap.copyOfEnumMap((EnumMap)map);
    }

    @Beta
    public static ImmutableMap copyOf(Iterable iterable) {
        Map.Entry[] arrentry = (Map.Entry[])Iterables.toArray(iterable, EMPTY_ENTRY_ARRAY);
        switch (arrentry.length) {
            case 0: {
                return ImmutableMap.of();
            }
            case 1: {
                Map.Entry entry = arrentry[0];
                return ImmutableMap.of(entry.getKey(), entry.getValue());
            }
        }
        return RegularImmutableMap.fromEntries(arrentry);
    }

    private static ImmutableMap copyOfEnumMap(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(enumMap);
        Iterator iterator = enumMap2.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            CollectPreconditions.checkEntryNotNull(entry.getKey(), entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(enumMap2);
    }

    ImmutableMap() {
    }

    @Deprecated
    public final Object put(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        if (this.size() != 0) return false;
        return true;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (this.get(object) == null) return false;
        return true;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.values().contains(object);
    }

    public abstract Object get(@Nullable Object var1);

    public ImmutableSet entrySet() {
        ImmutableSet immutableSet;
        ImmutableSet immutableSet2 = this.entrySet;
        if (immutableSet2 == null) {
            immutableSet = this.entrySet = this.createEntrySet();
            return immutableSet;
        }
        immutableSet = immutableSet2;
        return immutableSet;
    }

    abstract ImmutableSet createEntrySet();

    public ImmutableSet keySet() {
        ImmutableSet immutableSet;
        ImmutableSet immutableSet2 = this.keySet;
        if (immutableSet2 == null) {
            immutableSet = this.keySet = this.createKeySet();
            return immutableSet;
        }
        immutableSet = immutableSet2;
        return immutableSet;
    }

    ImmutableSet createKeySet() {
        ImmutableSet immutableSet;
        if (this.isEmpty()) {
            immutableSet = ImmutableSet.of();
            return immutableSet;
        }
        immutableSet = new ImmutableMapKeySet(this);
        return immutableSet;
    }

    UnmodifiableIterator keyIterator() {
        UnmodifiableIterator unmodifiableIterator = this.entrySet().iterator();
        return new ImmutableMap$1(this, unmodifiableIterator);
    }

    public ImmutableCollection values() {
        ImmutableCollection immutableCollection;
        ImmutableCollection immutableCollection2 = this.values;
        if (immutableCollection2 == null) {
            immutableCollection = this.values = new ImmutableMapValues(this);
            return immutableCollection;
        }
        immutableCollection = immutableCollection2;
        return immutableCollection;
    }

    @Beta
    public ImmutableSetMultimap asMultimap() {
        ImmutableSetMultimap immutableSetMultimap;
        if (this.isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap immutableSetMultimap2 = this.multimapView;
        if (immutableSetMultimap2 == null) {
            immutableSetMultimap = this.multimapView = new ImmutableSetMultimap(new ImmutableMap$MapViewOfValuesAsSingletonSets(this, null), this.size(), null);
            return immutableSetMultimap;
        }
        immutableSetMultimap = immutableSetMultimap2;
        return immutableSetMultimap;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Maps.equalsImpl(this, object);
    }

    abstract boolean isPartialView();

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }

    boolean isHashCodeFast() {
        return false;
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    Object writeReplace() {
        return new ImmutableMap$SerializedForm(this);
    }
}

