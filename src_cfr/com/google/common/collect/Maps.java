/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner$MapJoiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference$ValueDifference;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps$1;
import com.google.common.collect.Maps$10;
import com.google.common.collect.Maps$11;
import com.google.common.collect.Maps$2;
import com.google.common.collect.Maps$3;
import com.google.common.collect.Maps$4;
import com.google.common.collect.Maps$5;
import com.google.common.collect.Maps$6;
import com.google.common.collect.Maps$7;
import com.google.common.collect.Maps$8;
import com.google.common.collect.Maps$9;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Maps$AsMapView;
import com.google.common.collect.Maps$BiMapConverter;
import com.google.common.collect.Maps$EntryFunction;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$FilteredEntryBiMap;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryNavigableMap;
import com.google.common.collect.Maps$FilteredEntrySortedMap;
import com.google.common.collect.Maps$FilteredKeyMap;
import com.google.common.collect.Maps$MapDifferenceImpl;
import com.google.common.collect.Maps$NavigableAsMapView;
import com.google.common.collect.Maps$SortedAsMapView;
import com.google.common.collect.Maps$SortedMapDifferenceImpl;
import com.google.common.collect.Maps$TransformedEntriesMap;
import com.google.common.collect.Maps$TransformedEntriesNavigableMap;
import com.google.common.collect.Maps$TransformedEntriesSortedMap;
import com.google.common.collect.Maps$UnmodifiableBiMap;
import com.google.common.collect.Maps$UnmodifiableEntrySet;
import com.google.common.collect.Maps$UnmodifiableNavigableMap;
import com.google.common.collect.Maps$ValueDifferenceImpl;
import com.google.common.collect.Ordering;
import com.google.common.collect.Platform;
import com.google.common.collect.SortedMapDifference;
import com.google.common.collect.Synchronized;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class Maps {
    static final Joiner$MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");

    private Maps() {
    }

    static Function keyFunction() {
        return Maps$EntryFunction.KEY;
    }

    static Function valueFunction() {
        return Maps$EntryFunction.VALUE;
    }

    static Iterator keyIterator(Iterator iterator) {
        return Iterators.transform(iterator, Maps.keyFunction());
    }

    static Iterator valueIterator(Iterator iterator) {
        return Iterators.transform(iterator, Maps.valueFunction());
    }

    @GwtCompatible(serializable=1)
    @Beta
    public static ImmutableMap immutableEnumMap(Map map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap)map;
        }
        if (map.isEmpty()) {
            return ImmutableMap.of();
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Preconditions.checkNotNull(entry.getKey());
            Preconditions.checkNotNull(entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(new EnumMap(map));
    }

    public static HashMap newHashMap() {
        return new HashMap();
    }

    public static HashMap newHashMapWithExpectedSize(int n2) {
        return new HashMap(Maps.capacity(n2));
    }

    static int capacity(int n2) {
        if (n2 < 3) {
            CollectPreconditions.checkNonnegative(n2, "expectedSize");
            return n2 + 1;
        }
        if (n2 >= 1073741824) return Integer.MAX_VALUE;
        return (int)((float)n2 / 0.75f + 1.0f);
    }

    public static HashMap newHashMap(Map map) {
        return new HashMap(map);
    }

    public static LinkedHashMap newLinkedHashMap() {
        return new LinkedHashMap();
    }

    public static LinkedHashMap newLinkedHashMapWithExpectedSize(int n2) {
        return new LinkedHashMap(Maps.capacity(n2));
    }

    public static LinkedHashMap newLinkedHashMap(Map map) {
        return new LinkedHashMap(map);
    }

    public static ConcurrentMap newConcurrentMap() {
        return new MapMaker().makeMap();
    }

    public static TreeMap newTreeMap() {
        return new TreeMap();
    }

    public static TreeMap newTreeMap(SortedMap sortedMap) {
        return new TreeMap(sortedMap);
    }

    public static TreeMap newTreeMap(@Nullable Comparator comparator) {
        return new TreeMap(comparator);
    }

    public static EnumMap newEnumMap(Class class_) {
        return new EnumMap((Class)Preconditions.checkNotNull(class_));
    }

    public static EnumMap newEnumMap(Map map) {
        return new EnumMap(map);
    }

    public static IdentityHashMap newIdentityHashMap() {
        return new IdentityHashMap();
    }

    public static MapDifference difference(Map map, Map map2) {
        if (!(map instanceof SortedMap)) return Maps.difference(map, map2, Equivalence.equals());
        SortedMap sortedMap = (SortedMap)map;
        return Maps.difference(sortedMap, map2);
    }

    @Beta
    public static MapDifference difference(Map map, Map map2, Equivalence equivalence) {
        Preconditions.checkNotNull(equivalence);
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map2);
        LinkedHashMap linkedHashMap3 = Maps.newLinkedHashMap();
        LinkedHashMap linkedHashMap4 = Maps.newLinkedHashMap();
        Maps.doDifference(map, map2, equivalence, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
        return new Maps$MapDifferenceImpl(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
    }

    private static void doDifference(Map map, Map map2, Equivalence equivalence, Map map3, Map map4, Map map5, Map map6) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Object k2 = entry.getKey();
            Object v2 = entry.getValue();
            if (map2.containsKey(k2)) {
                Object v3 = map4.remove(k2);
                if (equivalence.equivalent(v2, v3)) {
                    map5.put(k2, v2);
                    continue;
                }
                map6.put(k2, Maps$ValueDifferenceImpl.create(v2, v3));
                continue;
            }
            map3.put(k2, v2);
        }
    }

    private static Map unmodifiableMap(Map map) {
        if (!(map instanceof SortedMap)) return Collections.unmodifiableMap(map);
        return Collections.unmodifiableSortedMap((SortedMap)map);
    }

    public static SortedMapDifference difference(SortedMap sortedMap, Map map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        Comparator comparator = Maps.orNaturalOrder(sortedMap.comparator());
        TreeMap treeMap = Maps.newTreeMap(comparator);
        TreeMap treeMap2 = Maps.newTreeMap(comparator);
        treeMap2.putAll(map);
        TreeMap treeMap3 = Maps.newTreeMap(comparator);
        TreeMap treeMap4 = Maps.newTreeMap(comparator);
        Maps.doDifference(sortedMap, map, Equivalence.equals(), treeMap, treeMap2, treeMap3, treeMap4);
        return new Maps$SortedMapDifferenceImpl(treeMap, treeMap2, treeMap3, treeMap4);
    }

    static Comparator orNaturalOrder(@Nullable Comparator comparator) {
        if (comparator == null) return Ordering.natural();
        return comparator;
    }

    public static Map asMap(Set set, Function function) {
        if (!(set instanceof SortedSet)) return new Maps$AsMapView(set, function);
        return Maps.asMap((SortedSet)set, function);
    }

    public static SortedMap asMap(SortedSet sortedSet, Function function) {
        return Platform.mapsAsMapSortedSet(sortedSet, function);
    }

    static SortedMap asMapSortedIgnoreNavigable(SortedSet sortedSet, Function function) {
        return new Maps$SortedAsMapView(sortedSet, function);
    }

    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap asMap(NavigableSet navigableSet, Function function) {
        return new Maps$NavigableAsMapView(navigableSet, function);
    }

    static Iterator asMapEntryIterator(Set set, Function function) {
        return new Maps$1(set.iterator(), function);
    }

    private static Set removeOnlySet(Set set) {
        return new Maps$2(set);
    }

    private static SortedSet removeOnlySortedSet(SortedSet sortedSet) {
        return new Maps$3(sortedSet);
    }

    @GwtIncompatible(value="NavigableSet")
    private static NavigableSet removeOnlyNavigableSet(NavigableSet navigableSet) {
        return new Maps$4(navigableSet);
    }

    public static ImmutableMap toMap(Iterable iterable, Function function) {
        return Maps.toMap(iterable.iterator(), function);
    }

    public static ImmutableMap toMap(Iterator iterator, Function function) {
        Preconditions.checkNotNull(function);
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            linkedHashMap.put(e2, function.apply(e2));
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }

    public static ImmutableMap uniqueIndex(Iterable iterable, Function function) {
        return Maps.uniqueIndex(iterable.iterator(), function);
    }

    public static ImmutableMap uniqueIndex(Iterator iterator, Function function) {
        Preconditions.checkNotNull(function);
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            immutableMap$Builder.put(function.apply(e2), e2);
        }
        try {
            return immutableMap$Builder.build();
        }
        catch (IllegalArgumentException var3_4) {
            throw new IllegalArgumentException(String.valueOf(var3_4.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
        }
    }

    @GwtIncompatible(value="java.util.Properties")
    public static ImmutableMap fromProperties(Properties properties) {
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            immutableMap$Builder.put(string, properties.getProperty(string));
        }
        return immutableMap$Builder.build();
    }

    @GwtCompatible(serializable=1)
    public static Map.Entry immutableEntry(@Nullable Object object, @Nullable Object object2) {
        return new ImmutableEntry(object, object2);
    }

    static Set unmodifiableEntrySet(Set set) {
        return new Maps$UnmodifiableEntrySet(Collections.unmodifiableSet(set));
    }

    static Map.Entry unmodifiableEntry(Map.Entry entry) {
        Preconditions.checkNotNull(entry);
        return new Maps$5(entry);
    }

    static UnmodifiableIterator unmodifiableEntryIterator(Iterator iterator) {
        return new Maps$6(iterator);
    }

    @Beta
    public static Converter asConverter(BiMap biMap) {
        return new Maps$BiMapConverter(biMap);
    }

    public static BiMap synchronizedBiMap(BiMap biMap) {
        return Synchronized.biMap(biMap, null);
    }

    public static BiMap unmodifiableBiMap(BiMap biMap) {
        return new Maps$UnmodifiableBiMap(biMap, null);
    }

    public static Map transformValues(Map map, Function function) {
        return Maps.transformEntries(map, Maps.asEntryTransformer(function));
    }

    public static SortedMap transformValues(SortedMap sortedMap, Function function) {
        return Maps.transformEntries(sortedMap, Maps.asEntryTransformer(function));
    }

    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap transformValues(NavigableMap navigableMap, Function function) {
        return Maps.transformEntries(navigableMap, Maps.asEntryTransformer(function));
    }

    public static Map transformEntries(Map map, Maps$EntryTransformer maps$EntryTransformer) {
        if (!(map instanceof SortedMap)) return new Maps$TransformedEntriesMap(map, maps$EntryTransformer);
        return Maps.transformEntries((SortedMap)map, maps$EntryTransformer);
    }

    public static SortedMap transformEntries(SortedMap sortedMap, Maps$EntryTransformer maps$EntryTransformer) {
        return Platform.mapsTransformEntriesSortedMap(sortedMap, maps$EntryTransformer);
    }

    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap transformEntries(NavigableMap navigableMap, Maps$EntryTransformer maps$EntryTransformer) {
        return new Maps$TransformedEntriesNavigableMap(navigableMap, maps$EntryTransformer);
    }

    static SortedMap transformEntriesIgnoreNavigable(SortedMap sortedMap, Maps$EntryTransformer maps$EntryTransformer) {
        return new Maps$TransformedEntriesSortedMap(sortedMap, maps$EntryTransformer);
    }

    static Maps$EntryTransformer asEntryTransformer(Function function) {
        Preconditions.checkNotNull(function);
        return new Maps$7(function);
    }

    static Function asValueToValueFunction(Maps$EntryTransformer maps$EntryTransformer, Object object) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        return new Maps$8(maps$EntryTransformer, object);
    }

    static Function asEntryToValueFunction(Maps$EntryTransformer maps$EntryTransformer) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        return new Maps$9(maps$EntryTransformer);
    }

    static Map.Entry transformEntry(Maps$EntryTransformer maps$EntryTransformer, Map.Entry entry) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        Preconditions.checkNotNull(entry);
        return new Maps$10(entry, maps$EntryTransformer);
    }

    static Function asEntryToEntryFunction(Maps$EntryTransformer maps$EntryTransformer) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        return new Maps$11(maps$EntryTransformer);
    }

    static Predicate keyPredicateOnEntries(Predicate predicate) {
        return Predicates.compose(predicate, Maps.keyFunction());
    }

    static Predicate valuePredicateOnEntries(Predicate predicate) {
        return Predicates.compose(predicate, Maps.valueFunction());
    }

    @CheckReturnValue
    public static Map filterKeys(Map map, Predicate predicate) {
        Maps$FilteredKeyMap maps$FilteredKeyMap /* !! */ ;
        if (map instanceof SortedMap) {
            return Maps.filterKeys((SortedMap)map, predicate);
        }
        if (map instanceof BiMap) {
            return Maps.filterKeys((BiMap)map, predicate);
        }
        Preconditions.checkNotNull(predicate);
        Predicate predicate2 = Maps.keyPredicateOnEntries(predicate);
        if (map instanceof Maps$AbstractFilteredMap) {
            maps$FilteredKeyMap /* !! */  = Maps.filterFiltered((Maps$AbstractFilteredMap)map, predicate2);
            return maps$FilteredKeyMap /* !! */ ;
        }
        maps$FilteredKeyMap /* !! */  = new Maps$FilteredKeyMap((Map)Preconditions.checkNotNull(map), predicate, predicate2);
        return maps$FilteredKeyMap /* !! */ ;
    }

    @CheckReturnValue
    public static SortedMap filterKeys(SortedMap sortedMap, Predicate predicate) {
        return Maps.filterEntries(sortedMap, Maps.keyPredicateOnEntries(predicate));
    }

    @CheckReturnValue
    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap filterKeys(NavigableMap navigableMap, Predicate predicate) {
        return Maps.filterEntries(navigableMap, Maps.keyPredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static BiMap filterKeys(BiMap biMap, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        return Maps.filterEntries(biMap, Maps.keyPredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static Map filterValues(Map map, Predicate predicate) {
        if (map instanceof SortedMap) {
            return Maps.filterValues((SortedMap)map, predicate);
        }
        if (!(map instanceof BiMap)) return Maps.filterEntries(map, Maps.valuePredicateOnEntries(predicate));
        return Maps.filterValues((BiMap)map, predicate);
    }

    @CheckReturnValue
    public static SortedMap filterValues(SortedMap sortedMap, Predicate predicate) {
        return Maps.filterEntries(sortedMap, Maps.valuePredicateOnEntries(predicate));
    }

    @CheckReturnValue
    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap filterValues(NavigableMap navigableMap, Predicate predicate) {
        return Maps.filterEntries(navigableMap, Maps.valuePredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static BiMap filterValues(BiMap biMap, Predicate predicate) {
        return Maps.filterEntries(biMap, Maps.valuePredicateOnEntries(predicate));
    }

    @CheckReturnValue
    public static Map filterEntries(Map map, Predicate predicate) {
        Maps$FilteredEntryMap maps$FilteredEntryMap /* !! */ ;
        if (map instanceof SortedMap) {
            return Maps.filterEntries((SortedMap)map, predicate);
        }
        if (map instanceof BiMap) {
            return Maps.filterEntries((BiMap)map, predicate);
        }
        Preconditions.checkNotNull(predicate);
        if (map instanceof Maps$AbstractFilteredMap) {
            maps$FilteredEntryMap /* !! */  = Maps.filterFiltered((Maps$AbstractFilteredMap)map, predicate);
            return maps$FilteredEntryMap /* !! */ ;
        }
        maps$FilteredEntryMap /* !! */  = new Maps$FilteredEntryMap((Map)Preconditions.checkNotNull(map), predicate);
        return maps$FilteredEntryMap /* !! */ ;
    }

    @CheckReturnValue
    public static SortedMap filterEntries(SortedMap sortedMap, Predicate predicate) {
        return Platform.mapsFilterSortedMap(sortedMap, predicate);
    }

    static SortedMap filterSortedIgnoreNavigable(SortedMap sortedMap, Predicate predicate) {
        Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap /* !! */ ;
        Preconditions.checkNotNull(predicate);
        if (sortedMap instanceof Maps$FilteredEntrySortedMap) {
            maps$FilteredEntrySortedMap /* !! */  = Maps.filterFiltered((Maps$FilteredEntrySortedMap)sortedMap, predicate);
            return maps$FilteredEntrySortedMap /* !! */ ;
        }
        maps$FilteredEntrySortedMap /* !! */  = new Maps$FilteredEntrySortedMap((SortedMap)Preconditions.checkNotNull(sortedMap), predicate);
        return maps$FilteredEntrySortedMap /* !! */ ;
    }

    @CheckReturnValue
    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap filterEntries(NavigableMap navigableMap, Predicate predicate) {
        Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap /* !! */ ;
        Preconditions.checkNotNull(predicate);
        if (navigableMap instanceof Maps$FilteredEntryNavigableMap) {
            maps$FilteredEntryNavigableMap /* !! */  = Maps.filterFiltered((Maps$FilteredEntryNavigableMap)navigableMap, predicate);
            return maps$FilteredEntryNavigableMap /* !! */ ;
        }
        maps$FilteredEntryNavigableMap /* !! */  = new Maps$FilteredEntryNavigableMap((NavigableMap)Preconditions.checkNotNull(navigableMap), predicate);
        return maps$FilteredEntryNavigableMap /* !! */ ;
    }

    @CheckReturnValue
    public static BiMap filterEntries(BiMap biMap, Predicate predicate) {
        Maps$FilteredEntryBiMap maps$FilteredEntryBiMap /* !! */ ;
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        if (biMap instanceof Maps$FilteredEntryBiMap) {
            maps$FilteredEntryBiMap /* !! */  = Maps.filterFiltered((Maps$FilteredEntryBiMap)biMap, predicate);
            return maps$FilteredEntryBiMap /* !! */ ;
        }
        maps$FilteredEntryBiMap /* !! */  = new Maps$FilteredEntryBiMap(biMap, predicate);
        return maps$FilteredEntryBiMap /* !! */ ;
    }

    private static Map filterFiltered(Maps$AbstractFilteredMap maps$AbstractFilteredMap, Predicate predicate) {
        return new Maps$FilteredEntryMap(maps$AbstractFilteredMap.unfiltered, Predicates.and(maps$AbstractFilteredMap.predicate, predicate));
    }

    private static SortedMap filterFiltered(Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap, Predicate predicate) {
        Predicate predicate2 = Predicates.and(maps$FilteredEntrySortedMap.predicate, predicate);
        return new Maps$FilteredEntrySortedMap(maps$FilteredEntrySortedMap.sortedMap(), predicate2);
    }

    @GwtIncompatible(value="NavigableMap")
    private static NavigableMap filterFiltered(Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap, Predicate predicate) {
        Predicate predicate2 = Predicates.and(Maps$FilteredEntryNavigableMap.access$600(maps$FilteredEntryNavigableMap), predicate);
        return new Maps$FilteredEntryNavigableMap(Maps$FilteredEntryNavigableMap.access$700(maps$FilteredEntryNavigableMap), predicate2);
    }

    private static BiMap filterFiltered(Maps$FilteredEntryBiMap maps$FilteredEntryBiMap, Predicate predicate) {
        Predicate predicate2 = Predicates.and(maps$FilteredEntryBiMap.predicate, predicate);
        return new Maps$FilteredEntryBiMap(maps$FilteredEntryBiMap.unfiltered(), predicate2);
    }

    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap unmodifiableNavigableMap(NavigableMap navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        if (!(navigableMap instanceof Maps$UnmodifiableNavigableMap)) return new Maps$UnmodifiableNavigableMap(navigableMap);
        return navigableMap;
    }

    @Nullable
    private static Map.Entry unmodifiableOrNull(@Nullable Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        Map.Entry entry2 = Maps.unmodifiableEntry(entry);
        return entry2;
    }

    @GwtIncompatible(value="NavigableMap")
    public static NavigableMap synchronizedNavigableMap(NavigableMap navigableMap) {
        return Synchronized.navigableMap(navigableMap);
    }

    static Object safeGet(Map map, @Nullable Object object) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(object);
        }
        catch (ClassCastException var2_2) {
            return null;
        }
        catch (NullPointerException var2_3) {
            return null;
        }
    }

    static boolean safeContainsKey(Map map, Object object) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(object);
        }
        catch (ClassCastException var2_2) {
            return false;
        }
        catch (NullPointerException var2_3) {
            return false;
        }
    }

    static Object safeRemove(Map map, Object object) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(object);
        }
        catch (ClassCastException var2_2) {
            return null;
        }
        catch (NullPointerException var2_3) {
            return null;
        }
    }

    static boolean containsKeyImpl(Map map, @Nullable Object object) {
        return Iterators.contains(Maps.keyIterator(map.entrySet().iterator()), object);
    }

    static boolean containsValueImpl(Map map, @Nullable Object object) {
        return Iterators.contains(Maps.valueIterator(map.entrySet().iterator()), object);
    }

    static boolean containsEntryImpl(Collection collection, Object object) {
        if (object instanceof Map.Entry) return collection.contains(Maps.unmodifiableEntry((Map.Entry)object));
        return false;
    }

    static boolean removeEntryImpl(Collection collection, Object object) {
        if (object instanceof Map.Entry) return collection.remove(Maps.unmodifiableEntry((Map.Entry)object));
        return false;
    }

    static boolean equalsImpl(Map map, Object object) {
        if (map == object) {
            return true;
        }
        if (!(object instanceof Map)) return false;
        Map map2 = (Map)object;
        return map.entrySet().equals(map2.entrySet());
    }

    static String toStringImpl(Map map) {
        StringBuilder stringBuilder = Collections2.newStringBuilderForCollection(map.size()).append('{');
        STANDARD_JOINER.appendTo(stringBuilder, map);
        return stringBuilder.append('}').toString();
    }

    static void putAllImpl(Map map, Map map2) {
        Iterator iterator = map2.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            map.put(entry.getKey(), entry.getValue());
        }
    }

    @Nullable
    static Object keyOrNull(@Nullable Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        Object v0 = entry.getKey();
        return v0;
    }

    @Nullable
    static Object valueOrNull(@Nullable Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        Object v0 = entry.getValue();
        return v0;
    }

    static ImmutableMap indexMap(Collection collection) {
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(collection.size());
        int n2 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            immutableMap$Builder.put(e2, n2++);
        }
        return immutableMap$Builder.build();
    }

    static /* synthetic */ Map access$100(Map map) {
        return Maps.unmodifiableMap(map);
    }

    static /* synthetic */ Set access$200(Set set) {
        return Maps.removeOnlySet(set);
    }

    static /* synthetic */ SortedSet access$300(SortedSet sortedSet) {
        return Maps.removeOnlySortedSet(sortedSet);
    }

    static /* synthetic */ NavigableSet access$400(NavigableSet navigableSet) {
        return Maps.removeOnlyNavigableSet(navigableSet);
    }

    static /* synthetic */ Map.Entry access$800(Map.Entry entry) {
        return Maps.unmodifiableOrNull(entry);
    }
}

