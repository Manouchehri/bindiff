package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(serializable = true, emulated = true)
public final class ImmutableSortedMap extends ImmutableSortedMapFauxverideShim implements NavigableMap
{
    private static final Comparator NATURAL_ORDER;
    private static final ImmutableSortedMap NATURAL_EMPTY_MAP;
    private final transient RegularImmutableSortedSet keySet;
    private final transient ImmutableList valueList;
    private transient ImmutableSortedMap descendingMap;
    private static final long serialVersionUID = 0L;
    
    static ImmutableSortedMap emptyMap(final Comparator comparator) {
        if (Ordering.natural().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
    }
    
    public static ImmutableSortedMap of() {
        return ImmutableSortedMap.NATURAL_EMPTY_MAP;
    }
    
    public static ImmutableSortedMap of(final Comparable comparable, final Object o) {
        return of(Ordering.natural(), comparable, o);
    }
    
    private static ImmutableSortedMap of(final Comparator comparator, final Object o, final Object o2) {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.of(o), (Comparator)Preconditions.checkNotNull(comparator)), ImmutableList.of(o2));
    }
    
    private static ImmutableSortedMap ofEntries(final ImmutableMapEntry... array) {
        return fromEntries(Ordering.natural(), false, array, array.length);
    }
    
    public static ImmutableSortedMap of(final Comparable comparable, final Object o, final Comparable comparable2, final Object o2) {
        return ofEntries(ImmutableMap.entryOf(comparable, o), ImmutableMap.entryOf(comparable2, o2));
    }
    
    public static ImmutableSortedMap of(final Comparable comparable, final Object o, final Comparable comparable2, final Object o2, final Comparable comparable3, final Object o3) {
        return ofEntries(ImmutableMap.entryOf(comparable, o), ImmutableMap.entryOf(comparable2, o2), ImmutableMap.entryOf(comparable3, o3));
    }
    
    public static ImmutableSortedMap of(final Comparable comparable, final Object o, final Comparable comparable2, final Object o2, final Comparable comparable3, final Object o3, final Comparable comparable4, final Object o4) {
        return ofEntries(ImmutableMap.entryOf(comparable, o), ImmutableMap.entryOf(comparable2, o2), ImmutableMap.entryOf(comparable3, o3), ImmutableMap.entryOf(comparable4, o4));
    }
    
    public static ImmutableSortedMap of(final Comparable comparable, final Object o, final Comparable comparable2, final Object o2, final Comparable comparable3, final Object o3, final Comparable comparable4, final Object o4, final Comparable comparable5, final Object o5) {
        return ofEntries(ImmutableMap.entryOf(comparable, o), ImmutableMap.entryOf(comparable2, o2), ImmutableMap.entryOf(comparable3, o3), ImmutableMap.entryOf(comparable4, o4), ImmutableMap.entryOf(comparable5, o5));
    }
    
    public static ImmutableSortedMap copyOf(final Map map) {
        return copyOfInternal(map, ImmutableSortedMap.NATURAL_ORDER);
    }
    
    public static ImmutableSortedMap copyOf(final Map map, final Comparator comparator) {
        return copyOfInternal(map, (Comparator)Preconditions.checkNotNull(comparator));
    }
    
    @Beta
    public static ImmutableSortedMap copyOf(final Iterable iterable) {
        return copyOf(iterable, ImmutableSortedMap.NATURAL_ORDER);
    }
    
    @Beta
    public static ImmutableSortedMap copyOf(final Iterable iterable, final Comparator comparator) {
        return fromEntries((Comparator)Preconditions.checkNotNull(comparator), false, iterable);
    }
    
    public static ImmutableSortedMap copyOfSorted(final SortedMap sortedMap) {
        Comparator<? super Object> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = (Comparator<? super Object>)ImmutableSortedMap.NATURAL_ORDER;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            final ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap)sortedMap;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, true, sortedMap.entrySet());
    }
    
    private static ImmutableSortedMap copyOfInternal(final Map map, final Comparator comparator) {
        boolean b = false;
        if (map instanceof SortedMap) {
            final Comparator comparator2 = ((SortedMap)map).comparator();
            b = ((comparator2 == null) ? (comparator == ImmutableSortedMap.NATURAL_ORDER) : comparator.equals(comparator2));
        }
        if (b && map instanceof ImmutableSortedMap) {
            final ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap)map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, b, map.entrySet());
    }
    
    private static ImmutableSortedMap fromEntries(final Comparator comparator, final boolean b, final Iterable iterable) {
        final Entry[] array = (Entry[])Iterables.toArray(iterable, ImmutableSortedMap.EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, b, array, array.length);
    }
    
    private static ImmutableSortedMap fromEntries(final Comparator comparator, final boolean b, final Entry[] array, final int n) {
        switch (n) {
            case 0: {
                return emptyMap(comparator);
            }
            case 1: {
                return of(comparator, array[0].getKey(), array[0].getValue());
            }
            default: {
                final Object[] array2 = new Object[n];
                final Object[] array3 = new Object[n];
                if (b) {
                    for (int i = 0; i < n; ++i) {
                        final Object key = array[i].getKey();
                        final Object value = array[i].getValue();
                        CollectPreconditions.checkEntryNotNull(key, value);
                        array2[i] = key;
                        array3[i] = value;
                    }
                }
                else {
                    Arrays.sort((Map.Entry[])array, 0, n, Ordering.from(comparator).onKeys());
                    Object key2 = array[0].getKey();
                    array2[0] = key2;
                    array3[0] = array[0].getValue();
                    for (int j = 1; j < n; ++j) {
                        final Object key3 = array[j].getKey();
                        final Object value2 = array[j].getValue();
                        CollectPreconditions.checkEntryNotNull(key3, value2);
                        array2[j] = key3;
                        array3[j] = value2;
                        ImmutableMap.checkNoConflict(comparator.compare(key2, key3) != 0, "key", array[j - 1], array[j]);
                        key2 = key3;
                    }
                }
                return new ImmutableSortedMap(new RegularImmutableSortedSet(new RegularImmutableList(array2), comparator), new RegularImmutableList(array3));
            }
        }
    }
    
    public static ImmutableSortedMap$Builder naturalOrder() {
        return new ImmutableSortedMap$Builder(Ordering.natural());
    }
    
    public static ImmutableSortedMap$Builder orderedBy(final Comparator comparator) {
        return new ImmutableSortedMap$Builder(comparator);
    }
    
    public static ImmutableSortedMap$Builder reverseOrder() {
        return new ImmutableSortedMap$Builder(Ordering.natural().reverse());
    }
    
    ImmutableSortedMap(final RegularImmutableSortedSet set, final ImmutableList list) {
        this(set, list, null);
    }
    
    ImmutableSortedMap(final RegularImmutableSortedSet keySet, final ImmutableList valueList, final ImmutableSortedMap descendingMap) {
        this.keySet = keySet;
        this.valueList = valueList;
        this.descendingMap = descendingMap;
    }
    
    @Override
    public int size() {
        return this.valueList.size();
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        final int index = this.keySet.indexOf(o);
        return (index == -1) ? null : this.valueList.get(index);
    }
    
    @Override
    boolean isPartialView() {
        return this.keySet.isPartialView() || this.valueList.isPartialView();
    }
    
    @Override
    public ImmutableSet entrySet() {
        return super.entrySet();
    }
    
    @Override
    ImmutableSet createEntrySet() {
        return this.isEmpty() ? ImmutableSet.of() : new ImmutableSortedMap$1EntrySet(this);
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
    
    private ImmutableSortedMap getSubMap(final int n, final int n2) {
        if (n == 0 && n2 == this.size()) {
            return this;
        }
        if (n == n2) {
            return emptyMap(this.comparator());
        }
        return new ImmutableSortedMap(this.keySet.getSubSet(n, n2), this.valueList.subList(n, n2));
    }
    
    @Override
    public ImmutableSortedMap headMap(final Object o) {
        return this.headMap(o, false);
    }
    
    @Override
    public ImmutableSortedMap headMap(final Object o, final boolean b) {
        return this.getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(o), b));
    }
    
    @Override
    public ImmutableSortedMap subMap(final Object o, final Object o2) {
        return this.subMap(o, true, o2, false);
    }
    
    @Override
    public ImmutableSortedMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        Preconditions.checkArgument(this.comparator().compare(o, o2) <= 0, "expected fromKey <= toKey but %s > %s", o, o2);
        return this.headMap(o2, b2).tailMap(o, b);
    }
    
    @Override
    public ImmutableSortedMap tailMap(final Object o) {
        return this.tailMap(o, true);
    }
    
    @Override
    public ImmutableSortedMap tailMap(final Object o, final boolean b) {
        return this.getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(o), b), this.size());
    }
    
    @Override
    public Entry lowerEntry(final Object o) {
        return this.headMap(o, false).lastEntry();
    }
    
    @Override
    public Object lowerKey(final Object o) {
        return Maps.keyOrNull(this.lowerEntry(o));
    }
    
    @Override
    public Entry floorEntry(final Object o) {
        return this.headMap(o, true).lastEntry();
    }
    
    @Override
    public Object floorKey(final Object o) {
        return Maps.keyOrNull(this.floorEntry(o));
    }
    
    @Override
    public Entry ceilingEntry(final Object o) {
        return this.tailMap(o, true).firstEntry();
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        return Maps.keyOrNull(this.ceilingEntry(o));
    }
    
    @Override
    public Entry higherEntry(final Object o) {
        return this.tailMap(o, false).firstEntry();
    }
    
    @Override
    public Object higherKey(final Object o) {
        return Maps.keyOrNull(this.higherEntry(o));
    }
    
    @Override
    public Entry firstEntry() {
        return (Entry)(this.isEmpty() ? null : this.entrySet().asList().get(0));
    }
    
    @Override
    public Entry lastEntry() {
        return (Entry)(this.isEmpty() ? null : this.entrySet().asList().get(this.size() - 1));
    }
    
    @Deprecated
    @Override
    public final Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ImmutableSortedMap descendingMap() {
        final ImmutableSortedMap descendingMap = this.descendingMap;
        if (descendingMap != null) {
            return descendingMap;
        }
        if (this.isEmpty()) {
            return emptyMap(Ordering.from(this.comparator()).reverse());
        }
        return new ImmutableSortedMap((RegularImmutableSortedSet)this.keySet.descendingSet(), this.valueList.reverse(), this);
    }
    
    @Override
    public ImmutableSortedSet navigableKeySet() {
        return this.keySet;
    }
    
    @Override
    public ImmutableSortedSet descendingKeySet() {
        return this.keySet.descendingSet();
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableSortedMap$SerializedForm(this);
    }
    
    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MAP = new ImmutableSortedMap(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    }
}
