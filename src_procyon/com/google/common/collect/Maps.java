package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(emulated = true)
public final class Maps
{
    static final Joiner$MapJoiner STANDARD_JOINER;
    
    static Function keyFunction() {
        return Maps$EntryFunction.KEY;
    }
    
    static Function valueFunction() {
        return Maps$EntryFunction.VALUE;
    }
    
    static Iterator keyIterator(final Iterator iterator) {
        return Iterators.transform(iterator, keyFunction());
    }
    
    static Iterator valueIterator(final Iterator iterator) {
        return Iterators.transform(iterator, valueFunction());
    }
    
    @GwtCompatible(serializable = true)
    @Beta
    public static ImmutableMap immutableEnumMap(final Map map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap)map;
        }
        if (map.isEmpty()) {
            return ImmutableMap.of();
        }
        for (final Map.Entry<Object, ? extends V> entry : map.entrySet()) {
            Preconditions.checkNotNull(entry.getKey());
            Preconditions.checkNotNull(entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(new EnumMap(map));
    }
    
    public static HashMap newHashMap() {
        return new HashMap();
    }
    
    public static HashMap newHashMapWithExpectedSize(final int n) {
        return new HashMap(capacity(n));
    }
    
    static int capacity(final int n) {
        if (n < 3) {
            CollectPreconditions.checkNonnegative(n, "expectedSize");
            return n + 1;
        }
        if (n < 1073741824) {
            return (int)(n / 0.75f + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
    
    public static HashMap newHashMap(final Map map) {
        return new HashMap(map);
    }
    
    public static LinkedHashMap newLinkedHashMap() {
        return new LinkedHashMap();
    }
    
    public static LinkedHashMap newLinkedHashMapWithExpectedSize(final int n) {
        return new LinkedHashMap(capacity(n));
    }
    
    public static LinkedHashMap newLinkedHashMap(final Map map) {
        return new LinkedHashMap(map);
    }
    
    public static ConcurrentMap newConcurrentMap() {
        return new MapMaker().makeMap();
    }
    
    public static TreeMap newTreeMap() {
        return new TreeMap();
    }
    
    public static TreeMap newTreeMap(final SortedMap sortedMap) {
        return new TreeMap((SortedMap<K, ? extends V>)sortedMap);
    }
    
    public static TreeMap newTreeMap(@Nullable final Comparator comparator) {
        return new TreeMap(comparator);
    }
    
    public static EnumMap newEnumMap(final Class clazz) {
        return new EnumMap((Class<K>)Preconditions.checkNotNull(clazz));
    }
    
    public static EnumMap newEnumMap(final Map map) {
        return new EnumMap(map);
    }
    
    public static IdentityHashMap newIdentityHashMap() {
        return new IdentityHashMap();
    }
    
    public static MapDifference difference(final Map map, final Map map2) {
        if (map instanceof SortedMap) {
            return difference((SortedMap)map, map2);
        }
        return difference(map, map2, Equivalence.equals());
    }
    
    @Beta
    public static MapDifference difference(final Map map, final Map map2, final Equivalence equivalence) {
        Preconditions.checkNotNull(equivalence);
        final LinkedHashMap linkedHashMap = newLinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap(map2);
        final LinkedHashMap linkedHashMap3 = newLinkedHashMap();
        final LinkedHashMap linkedHashMap4 = newLinkedHashMap();
        doDifference(map, map2, equivalence, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
        return new Maps$MapDifferenceImpl(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
    }
    
    private static void doDifference(final Map map, final Map map2, final Equivalence equivalence, final Map map3, final Map map4, final Map map5, final Map map6) {
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            final Object key = entry.getKey();
            final V value = entry.getValue();
            if (map2.containsKey(key)) {
                final Object remove = map4.remove(key);
                if (equivalence.equivalent(value, remove)) {
                    map5.put(key, value);
                }
                else {
                    map6.put(key, Maps$ValueDifferenceImpl.create(value, remove));
                }
            }
            else {
                map3.put(key, value);
            }
        }
    }
    
    private static Map unmodifiableMap(final Map map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap<Object, ?>)(SortedMap<Object, ? extends V>)map);
        }
        return Collections.unmodifiableMap((Map<?, ?>)map);
    }
    
    public static SortedMapDifference difference(final SortedMap sortedMap, final Map map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        final Comparator orNaturalOrder = orNaturalOrder(sortedMap.comparator());
        final TreeMap treeMap = newTreeMap(orNaturalOrder);
        final TreeMap treeMap2 = newTreeMap(orNaturalOrder);
        treeMap2.putAll(map);
        final TreeMap treeMap3 = newTreeMap(orNaturalOrder);
        final TreeMap treeMap4 = newTreeMap(orNaturalOrder);
        doDifference(sortedMap, map, Equivalence.equals(), treeMap, treeMap2, treeMap3, treeMap4);
        return new Maps$SortedMapDifferenceImpl(treeMap, treeMap2, treeMap3, treeMap4);
    }
    
    static Comparator orNaturalOrder(@Nullable final Comparator comparator) {
        if (comparator != null) {
            return comparator;
        }
        return Ordering.natural();
    }
    
    public static Map asMap(final Set set, final Function function) {
        if (set instanceof SortedSet) {
            return asMap((SortedSet)set, function);
        }
        return new Maps$AsMapView(set, function);
    }
    
    public static SortedMap asMap(final SortedSet set, final Function function) {
        return Platform.mapsAsMapSortedSet(set, function);
    }
    
    static SortedMap asMapSortedIgnoreNavigable(final SortedSet set, final Function function) {
        return new Maps$SortedAsMapView(set, function);
    }
    
    @GwtIncompatible("NavigableMap")
    public static NavigableMap asMap(final NavigableSet set, final Function function) {
        return new Maps$NavigableAsMapView(set, function);
    }
    
    static Iterator asMapEntryIterator(final Set set, final Function function) {
        return new Maps$1(set.iterator(), function);
    }
    
    private static Set removeOnlySet(final Set set) {
        return new Maps$2(set);
    }
    
    private static SortedSet removeOnlySortedSet(final SortedSet set) {
        return new Maps$3(set);
    }
    
    @GwtIncompatible("NavigableSet")
    private static NavigableSet removeOnlyNavigableSet(final NavigableSet set) {
        return new Maps$4(set);
    }
    
    public static ImmutableMap toMap(final Iterable iterable, final Function function) {
        return toMap(iterable.iterator(), function);
    }
    
    public static ImmutableMap toMap(final Iterator iterator, final Function function) {
        Preconditions.checkNotNull(function);
        final LinkedHashMap linkedHashMap = newLinkedHashMap();
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            linkedHashMap.put(next, function.apply(next));
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }
    
    public static ImmutableMap uniqueIndex(final Iterable iterable, final Function function) {
        return uniqueIndex(iterable.iterator(), function);
    }
    
    public static ImmutableMap uniqueIndex(final Iterator iterator, final Function function) {
        Preconditions.checkNotNull(function);
        final ImmutableMap$Builder builder = ImmutableMap.builder();
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            builder.put(function.apply(next), next);
        }
        try {
            return builder.build();
        }
        catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.valueOf(ex.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }
    
    @GwtIncompatible("java.util.Properties")
    public static ImmutableMap fromProperties(final Properties properties) {
        final ImmutableMap$Builder builder = ImmutableMap.builder();
        final Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            final String s = (String)propertyNames.nextElement();
            builder.put(s, properties.getProperty(s));
        }
        return builder.build();
    }
    
    @GwtCompatible(serializable = true)
    public static Map.Entry immutableEntry(@Nullable final Object o, @Nullable final Object o2) {
        return new ImmutableEntry(o, o2);
    }
    
    static Set unmodifiableEntrySet(final Set set) {
        return new Maps$UnmodifiableEntrySet(Collections.unmodifiableSet((Set<?>)set));
    }
    
    static Map.Entry unmodifiableEntry(final Map.Entry entry) {
        Preconditions.checkNotNull(entry);
        return new Maps$5(entry);
    }
    
    static UnmodifiableIterator unmodifiableEntryIterator(final Iterator iterator) {
        return new Maps$6(iterator);
    }
    
    @Beta
    public static Converter asConverter(final BiMap biMap) {
        return new Maps$BiMapConverter(biMap);
    }
    
    public static BiMap synchronizedBiMap(final BiMap biMap) {
        return Synchronized.biMap(biMap, null);
    }
    
    public static BiMap unmodifiableBiMap(final BiMap biMap) {
        return new Maps$UnmodifiableBiMap(biMap, null);
    }
    
    public static Map transformValues(final Map map, final Function function) {
        return transformEntries(map, asEntryTransformer(function));
    }
    
    public static SortedMap transformValues(final SortedMap sortedMap, final Function function) {
        return transformEntries(sortedMap, asEntryTransformer(function));
    }
    
    @GwtIncompatible("NavigableMap")
    public static NavigableMap transformValues(final NavigableMap navigableMap, final Function function) {
        return transformEntries(navigableMap, asEntryTransformer(function));
    }
    
    public static Map transformEntries(final Map map, final Maps$EntryTransformer maps$EntryTransformer) {
        if (map instanceof SortedMap) {
            return transformEntries((SortedMap)map, maps$EntryTransformer);
        }
        return new Maps$TransformedEntriesMap(map, maps$EntryTransformer);
    }
    
    public static SortedMap transformEntries(final SortedMap sortedMap, final Maps$EntryTransformer maps$EntryTransformer) {
        return Platform.mapsTransformEntriesSortedMap(sortedMap, maps$EntryTransformer);
    }
    
    @GwtIncompatible("NavigableMap")
    public static NavigableMap transformEntries(final NavigableMap navigableMap, final Maps$EntryTransformer maps$EntryTransformer) {
        return new Maps$TransformedEntriesNavigableMap(navigableMap, maps$EntryTransformer);
    }
    
    static SortedMap transformEntriesIgnoreNavigable(final SortedMap sortedMap, final Maps$EntryTransformer maps$EntryTransformer) {
        return new Maps$TransformedEntriesSortedMap(sortedMap, maps$EntryTransformer);
    }
    
    static Maps$EntryTransformer asEntryTransformer(final Function function) {
        Preconditions.checkNotNull(function);
        return new Maps$7(function);
    }
    
    static Function asValueToValueFunction(final Maps$EntryTransformer maps$EntryTransformer, final Object o) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        return new Maps$8(maps$EntryTransformer, o);
    }
    
    static Function asEntryToValueFunction(final Maps$EntryTransformer maps$EntryTransformer) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        return new Maps$9(maps$EntryTransformer);
    }
    
    static Map.Entry transformEntry(final Maps$EntryTransformer maps$EntryTransformer, final Map.Entry entry) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        Preconditions.checkNotNull(entry);
        return new Maps$10(entry, maps$EntryTransformer);
    }
    
    static Function asEntryToEntryFunction(final Maps$EntryTransformer maps$EntryTransformer) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        return new Maps$11(maps$EntryTransformer);
    }
    
    static Predicate keyPredicateOnEntries(final Predicate predicate) {
        return Predicates.compose(predicate, keyFunction());
    }
    
    static Predicate valuePredicateOnEntries(final Predicate predicate) {
        return Predicates.compose(predicate, valueFunction());
    }
    
    @CheckReturnValue
    public static Map filterKeys(final Map map, final Predicate predicate) {
        if (map instanceof SortedMap) {
            return filterKeys((SortedMap)map, predicate);
        }
        if (map instanceof BiMap) {
            return filterKeys((BiMap)map, predicate);
        }
        Preconditions.checkNotNull(predicate);
        final Predicate keyPredicateOnEntries = keyPredicateOnEntries(predicate);
        return (map instanceof Maps$AbstractFilteredMap) ? filterFiltered((Maps$AbstractFilteredMap)map, keyPredicateOnEntries) : new Maps$FilteredKeyMap((Map)Preconditions.checkNotNull(map), predicate, keyPredicateOnEntries);
    }
    
    @CheckReturnValue
    public static SortedMap filterKeys(final SortedMap sortedMap, final Predicate predicate) {
        return filterEntries(sortedMap, keyPredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    @GwtIncompatible("NavigableMap")
    public static NavigableMap filterKeys(final NavigableMap navigableMap, final Predicate predicate) {
        return filterEntries(navigableMap, keyPredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    public static BiMap filterKeys(final BiMap biMap, final Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        return filterEntries(biMap, keyPredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    public static Map filterValues(final Map map, final Predicate predicate) {
        if (map instanceof SortedMap) {
            return filterValues((SortedMap)map, predicate);
        }
        if (map instanceof BiMap) {
            return filterValues((BiMap)map, predicate);
        }
        return filterEntries(map, valuePredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    public static SortedMap filterValues(final SortedMap sortedMap, final Predicate predicate) {
        return filterEntries(sortedMap, valuePredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    @GwtIncompatible("NavigableMap")
    public static NavigableMap filterValues(final NavigableMap navigableMap, final Predicate predicate) {
        return filterEntries(navigableMap, valuePredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    public static BiMap filterValues(final BiMap biMap, final Predicate predicate) {
        return filterEntries(biMap, valuePredicateOnEntries(predicate));
    }
    
    @CheckReturnValue
    public static Map filterEntries(final Map map, final Predicate predicate) {
        if (map instanceof SortedMap) {
            return filterEntries((SortedMap)map, predicate);
        }
        if (map instanceof BiMap) {
            return filterEntries((BiMap)map, predicate);
        }
        Preconditions.checkNotNull(predicate);
        return (map instanceof Maps$AbstractFilteredMap) ? filterFiltered((Maps$AbstractFilteredMap)map, predicate) : new Maps$FilteredEntryMap((Map)Preconditions.checkNotNull(map), predicate);
    }
    
    @CheckReturnValue
    public static SortedMap filterEntries(final SortedMap sortedMap, final Predicate predicate) {
        return Platform.mapsFilterSortedMap(sortedMap, predicate);
    }
    
    static SortedMap filterSortedIgnoreNavigable(final SortedMap sortedMap, final Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        return (sortedMap instanceof Maps$FilteredEntrySortedMap) ? filterFiltered((Maps$FilteredEntrySortedMap)sortedMap, predicate) : new Maps$FilteredEntrySortedMap((SortedMap)Preconditions.checkNotNull(sortedMap), predicate);
    }
    
    @CheckReturnValue
    @GwtIncompatible("NavigableMap")
    public static NavigableMap filterEntries(final NavigableMap navigableMap, final Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        return (navigableMap instanceof Maps$FilteredEntryNavigableMap) ? filterFiltered((Maps$FilteredEntryNavigableMap)navigableMap, predicate) : new Maps$FilteredEntryNavigableMap((NavigableMap)Preconditions.checkNotNull(navigableMap), predicate);
    }
    
    @CheckReturnValue
    public static BiMap filterEntries(final BiMap biMap, final Predicate predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        return (biMap instanceof Maps$FilteredEntryBiMap) ? filterFiltered((Maps$FilteredEntryBiMap)biMap, predicate) : new Maps$FilteredEntryBiMap(biMap, predicate);
    }
    
    private static Map filterFiltered(final Maps$AbstractFilteredMap maps$AbstractFilteredMap, final Predicate predicate) {
        return new Maps$FilteredEntryMap(maps$AbstractFilteredMap.unfiltered, Predicates.and(maps$AbstractFilteredMap.predicate, predicate));
    }
    
    private static SortedMap filterFiltered(final Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap, final Predicate predicate) {
        return new Maps$FilteredEntrySortedMap(maps$FilteredEntrySortedMap.sortedMap(), Predicates.and(maps$FilteredEntrySortedMap.predicate, predicate));
    }
    
    @GwtIncompatible("NavigableMap")
    private static NavigableMap filterFiltered(final Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap, final Predicate predicate) {
        return new Maps$FilteredEntryNavigableMap(maps$FilteredEntryNavigableMap.unfiltered, Predicates.and(maps$FilteredEntryNavigableMap.entryPredicate, predicate));
    }
    
    private static BiMap filterFiltered(final Maps$FilteredEntryBiMap maps$FilteredEntryBiMap, final Predicate predicate) {
        return new Maps$FilteredEntryBiMap(maps$FilteredEntryBiMap.unfiltered(), Predicates.and(maps$FilteredEntryBiMap.predicate, predicate));
    }
    
    @GwtIncompatible("NavigableMap")
    public static NavigableMap unmodifiableNavigableMap(final NavigableMap navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        if (navigableMap instanceof Maps$UnmodifiableNavigableMap) {
            return navigableMap;
        }
        return new Maps$UnmodifiableNavigableMap(navigableMap);
    }
    
    @Nullable
    private static Map.Entry unmodifiableOrNull(@Nullable final Map.Entry entry) {
        return (entry == null) ? null : unmodifiableEntry(entry);
    }
    
    @GwtIncompatible("NavigableMap")
    public static NavigableMap synchronizedNavigableMap(final NavigableMap navigableMap) {
        return Synchronized.navigableMap(navigableMap);
    }
    
    static Object safeGet(final Map map, @Nullable final Object o) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(o);
        }
        catch (ClassCastException ex) {
            return null;
        }
        catch (NullPointerException ex2) {
            return null;
        }
    }
    
    static boolean safeContainsKey(final Map map, final Object o) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(o);
        }
        catch (ClassCastException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
    }
    
    static Object safeRemove(final Map map, final Object o) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(o);
        }
        catch (ClassCastException ex) {
            return null;
        }
        catch (NullPointerException ex2) {
            return null;
        }
    }
    
    static boolean containsKeyImpl(final Map map, @Nullable final Object o) {
        return Iterators.contains(keyIterator(map.entrySet().iterator()), o);
    }
    
    static boolean containsValueImpl(final Map map, @Nullable final Object o) {
        return Iterators.contains(valueIterator(map.entrySet().iterator()), o);
    }
    
    static boolean containsEntryImpl(final Collection collection, final Object o) {
        return o instanceof Map.Entry && collection.contains(unmodifiableEntry((Map.Entry)o));
    }
    
    static boolean removeEntryImpl(final Collection collection, final Object o) {
        return o instanceof Map.Entry && collection.remove(unmodifiableEntry((Map.Entry)o));
    }
    
    static boolean equalsImpl(final Map map, final Object o) {
        return map == o || (o instanceof Map && map.entrySet().equals(((Map)o).entrySet()));
    }
    
    static String toStringImpl(final Map map) {
        final StringBuilder append = Collections2.newStringBuilderForCollection(map.size()).append('{');
        Maps.STANDARD_JOINER.appendTo(append, map);
        return append.append('}').toString();
    }
    
    static void putAllImpl(final Map map, final Map map2) {
        for (final Map.Entry<Object, V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Nullable
    static Object keyOrNull(@Nullable final Map.Entry entry) {
        return (entry == null) ? null : entry.getKey();
    }
    
    @Nullable
    static Object valueOrNull(@Nullable final Map.Entry entry) {
        return (entry == null) ? null : entry.getValue();
    }
    
    static ImmutableMap indexMap(final Collection collection) {
        final ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(collection.size());
        int n = 0;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            immutableMap$Builder.put(iterator.next(), n++);
        }
        return immutableMap$Builder.build();
    }
    
    static {
        STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
    }
}
