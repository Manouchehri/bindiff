/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMap$1EntrySet;
import com.google.common.collect.ImmutableSortedMap$Builder;
import com.google.common.collect.ImmutableSortedMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMapFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.RegularImmutableSortedSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public final class ImmutableSortedMap
extends ImmutableSortedMapFauxverideShim
implements NavigableMap {
    private static final Comparator NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedMap NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    private final transient RegularImmutableSortedSet keySet;
    private final transient ImmutableList valueList;
    private transient ImmutableSortedMap descendingMap;
    private static final long serialVersionUID = 0;

    static ImmutableSortedMap emptyMap(Comparator comparator) {
        if (!Ordering.natural().equals(comparator)) return new ImmutableSortedMap(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
        return ImmutableSortedMap.of();
    }

    public static ImmutableSortedMap of() {
        return NATURAL_EMPTY_MAP;
    }

    public static ImmutableSortedMap of(Comparable comparable, Object object) {
        return ImmutableSortedMap.of(Ordering.natural(), comparable, object);
    }

    private static ImmutableSortedMap of(Comparator comparator, Object object, Object object2) {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(object), (Comparator)Preconditions.checkNotNull(comparator)), ImmutableList.of(object2));
    }

    private static /* varargs */ ImmutableSortedMap ofEntries(ImmutableMapEntry ... arrimmutableMapEntry) {
        return ImmutableSortedMap.fromEntries(Ordering.natural(), false, arrimmutableMapEntry, arrimmutableMapEntry.length);
    }

    public static ImmutableSortedMap of(Comparable comparable, Object object, Comparable comparable2, Object object2) {
        return ImmutableSortedMap.ofEntries(ImmutableSortedMap.entryOf(comparable, object), ImmutableSortedMap.entryOf(comparable2, object2));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object object, Comparable comparable2, Object object2, Comparable comparable3, Object object3) {
        return ImmutableSortedMap.ofEntries(ImmutableSortedMap.entryOf(comparable, object), ImmutableSortedMap.entryOf(comparable2, object2), ImmutableSortedMap.entryOf(comparable3, object3));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object object, Comparable comparable2, Object object2, Comparable comparable3, Object object3, Comparable comparable4, Object object4) {
        return ImmutableSortedMap.ofEntries(ImmutableSortedMap.entryOf(comparable, object), ImmutableSortedMap.entryOf(comparable2, object2), ImmutableSortedMap.entryOf(comparable3, object3), ImmutableSortedMap.entryOf(comparable4, object4));
    }

    public static ImmutableSortedMap of(Comparable comparable, Object object, Comparable comparable2, Object object2, Comparable comparable3, Object object3, Comparable comparable4, Object object4, Comparable comparable5, Object object5) {
        return ImmutableSortedMap.ofEntries(ImmutableSortedMap.entryOf(comparable, object), ImmutableSortedMap.entryOf(comparable2, object2), ImmutableSortedMap.entryOf(comparable3, object3), ImmutableSortedMap.entryOf(comparable4, object4), ImmutableSortedMap.entryOf(comparable5, object5));
    }

    public static ImmutableSortedMap copyOf(Map map) {
        Ordering ordering = (Ordering)NATURAL_ORDER;
        return ImmutableSortedMap.copyOfInternal(map, ordering);
    }

    public static ImmutableSortedMap copyOf(Map map, Comparator comparator) {
        return ImmutableSortedMap.copyOfInternal(map, (Comparator)Preconditions.checkNotNull(comparator));
    }

    @Beta
    public static ImmutableSortedMap copyOf(Iterable iterable) {
        Ordering ordering = (Ordering)NATURAL_ORDER;
        return ImmutableSortedMap.copyOf(iterable, (Comparator)ordering);
    }

    @Beta
    public static ImmutableSortedMap copyOf(Iterable iterable, Comparator comparator) {
        return ImmutableSortedMap.fromEntries((Comparator)Preconditions.checkNotNull(comparator), false, iterable);
    }

    public static ImmutableSortedMap copyOfSorted(SortedMap sortedMap) {
        Comparator comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (!(sortedMap instanceof ImmutableSortedMap)) return ImmutableSortedMap.fromEntries(comparator, true, sortedMap.entrySet());
        ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap)sortedMap;
        if (immutableSortedMap.isPartialView()) return ImmutableSortedMap.fromEntries(comparator, true, sortedMap.entrySet());
        return immutableSortedMap;
    }

    private static ImmutableSortedMap copyOfInternal(Map map, Comparator comparator) {
        SortedMap sortedMap;
        boolean bl2 = false;
        if (map instanceof SortedMap) {
            sortedMap = (SortedMap)map;
            Comparator comparator2 = sortedMap.comparator();
            bl2 = comparator2 == null ? comparator == NATURAL_ORDER : comparator.equals(comparator2);
        }
        if (!bl2) return ImmutableSortedMap.fromEntries(comparator, bl2, map.entrySet());
        if (!(map instanceof ImmutableSortedMap)) return ImmutableSortedMap.fromEntries(comparator, bl2, map.entrySet());
        sortedMap = (ImmutableSortedMap)map;
        if (sortedMap.isPartialView()) return ImmutableSortedMap.fromEntries(comparator, bl2, map.entrySet());
        return sortedMap;
    }

    private static ImmutableSortedMap fromEntries(Comparator comparator, boolean bl2, Iterable iterable) {
        Map.Entry[] arrentry = (Map.Entry[])Iterables.toArray(iterable, EMPTY_ENTRY_ARRAY);
        return ImmutableSortedMap.fromEntries(comparator, bl2, arrentry, arrentry.length);
    }

    private static ImmutableSortedMap fromEntries(Comparator comparator, boolean bl2, Map.Entry[] arrentry, int n2) {
        Object k2;
        switch (n2) {
            case 0: {
                return ImmutableSortedMap.emptyMap(comparator);
            }
            case 1: {
                return ImmutableSortedMap.of(comparator, arrentry[0].getKey(), arrentry[0].getValue());
            }
        }
        Object[] arrobject = new Object[n2];
        Object[] arrobject2 = new Object[n2];
        if (bl2) {
            int n3 = 0;
            while (n3 < n2) {
                Object k3 = arrentry[n3].getKey();
                Object v2 = arrentry[n3].getValue();
                CollectPreconditions.checkEntryNotNull(k3, v2);
                arrobject[n3] = k3;
                arrobject2[n3] = v2;
                ++n3;
            }
            return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(arrobject), comparator), new RegularImmutableList(arrobject2));
        }
        Arrays.sort(arrentry, 0, n2, Ordering.from(comparator).onKeys());
        arrobject[0] = k2 = arrentry[0].getKey();
        arrobject2[0] = arrentry[0].getValue();
        int n4 = 1;
        while (n4 < n2) {
            Object k4 = arrentry[n4].getKey();
            Object v3 = arrentry[n4].getValue();
            CollectPreconditions.checkEntryNotNull(k4, v3);
            arrobject[n4] = k4;
            arrobject2[n4] = v3;
            ImmutableSortedMap.checkNoConflict(comparator.compare(k2, k4) != 0, "key", arrentry[n4 - 1], arrentry[n4]);
            k2 = k4;
            ++n4;
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(arrobject), comparator), new RegularImmutableList(arrobject2));
    }

    public static ImmutableSortedMap$Builder naturalOrder() {
        return new ImmutableSortedMap$Builder(Ordering.natural());
    }

    public static ImmutableSortedMap$Builder orderedBy(Comparator comparator) {
        return new ImmutableSortedMap$Builder(comparator);
    }

    public static ImmutableSortedMap$Builder reverseOrder() {
        return new ImmutableSortedMap$Builder(Ordering.natural().reverse());
    }

    ImmutableSortedMap(RegularImmutableSortedSet regularImmutableSortedSet, ImmutableList immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    ImmutableSortedMap(RegularImmutableSortedSet regularImmutableSortedSet, ImmutableList immutableList, ImmutableSortedMap immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    @Override
    public int size() {
        return this.valueList.size();
    }

    @Override
    public Object get(@Nullable Object object) {
        int n2 = this.keySet.indexOf(object);
        if (n2 == -1) {
            return null;
        }
        Object v0 = this.valueList.get(n2);
        return v0;
    }

    @Override
    boolean isPartialView() {
        if (this.keySet.isPartialView()) return true;
        if (this.valueList.isPartialView()) return true;
        return false;
    }

    @Override
    public ImmutableSet entrySet() {
        return super.entrySet();
    }

    @Override
    ImmutableSet createEntrySet() {
        ImmutableSet immutableSet;
        if (this.isEmpty()) {
            immutableSet = ImmutableSet.of();
            return immutableSet;
        }
        immutableSet = new ImmutableSortedMap$1EntrySet(this);
        return immutableSet;
    }

    @Override
    public ImmutableSortedSet keySet() {
        return this.keySet;
    }

    @Override
    public ImmutableCollection values() {
        return this.valueList;
    }

    @Override
    public Comparator comparator() {
        return this.keySet().comparator();
    }

    @Override
    public Object firstKey() {
        return this.keySet().first();
    }

    @Override
    public Object lastKey() {
        return this.keySet().last();
    }

    private ImmutableSortedMap getSubMap(int n2, int n3) {
        if (n2 == 0 && n3 == this.size()) {
            return this;
        }
        if (n2 != n3) return new ImmutableSortedMap(this.keySet.getSubSet(n2, n3), this.valueList.subList(n2, n3));
        return ImmutableSortedMap.emptyMap(this.comparator());
    }

    public ImmutableSortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    public ImmutableSortedMap headMap(Object object, boolean bl2) {
        return this.getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(object), bl2));
    }

    public ImmutableSortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public ImmutableSortedMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Preconditions.checkArgument(this.comparator().compare(object, object2) <= 0, "expected fromKey <= toKey but %s > %s", object, object2);
        return this.headMap(object2, bl3).tailMap(object, bl2);
    }

    public ImmutableSortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    public ImmutableSortedMap tailMap(Object object, boolean bl2) {
        return this.getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(object), bl2), this.size());
    }

    public Map.Entry lowerEntry(Object object) {
        return this.headMap(object, false).lastEntry();
    }

    public Object lowerKey(Object object) {
        return Maps.keyOrNull(this.lowerEntry(object));
    }

    public Map.Entry floorEntry(Object object) {
        return this.headMap(object, true).lastEntry();
    }

    public Object floorKey(Object object) {
        return Maps.keyOrNull(this.floorEntry(object));
    }

    public Map.Entry ceilingEntry(Object object) {
        return this.tailMap(object, true).firstEntry();
    }

    public Object ceilingKey(Object object) {
        return Maps.keyOrNull(this.ceilingEntry(object));
    }

    public Map.Entry higherEntry(Object object) {
        return this.tailMap(object, false).firstEntry();
    }

    public Object higherKey(Object object) {
        return Maps.keyOrNull(this.higherEntry(object));
    }

    public Map.Entry firstEntry() {
        if (this.isEmpty()) {
            return null;
        }
        Map.Entry entry = (Map.Entry)this.entrySet().asList().get(0);
        return entry;
    }

    public Map.Entry lastEntry() {
        if (this.isEmpty()) {
            return null;
        }
        Map.Entry entry = (Map.Entry)this.entrySet().asList().get(this.size() - 1);
        return entry;
    }

    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedMap descendingMap() {
        ImmutableSortedMap immutableSortedMap = this.descendingMap;
        if (immutableSortedMap != null) return immutableSortedMap;
        if (!this.isEmpty()) return new ImmutableSortedMap((RegularImmutableSortedSet)this.keySet.descendingSet(), this.valueList.reverse(), this);
        return ImmutableSortedMap.emptyMap(Ordering.from(this.comparator()).reverse());
    }

    public ImmutableSortedSet navigableKeySet() {
        return this.keySet;
    }

    public ImmutableSortedSet descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override
    Object writeReplace() {
        return new ImmutableSortedMap$SerializedForm(this);
    }

    static /* synthetic */ ImmutableSortedMap access$000(Comparator comparator, Object object, Object object2) {
        return ImmutableSortedMap.of(comparator, object, object2);
    }

    static /* synthetic */ ImmutableSortedMap access$100(Comparator comparator, boolean bl2, Map.Entry[] arrentry, int n2) {
        return ImmutableSortedMap.fromEntries(comparator, bl2, arrentry, n2);
    }

    static /* synthetic */ RegularImmutableSortedSet access$200(ImmutableSortedMap immutableSortedMap) {
        return immutableSortedMap.keySet;
    }

    static /* synthetic */ ImmutableList access$300(ImmutableSortedMap immutableSortedMap) {
        return immutableSortedMap.valueList;
    }
}

