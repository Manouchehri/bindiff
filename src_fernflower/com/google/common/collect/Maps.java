package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
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
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class Maps {
   static final Joiner$MapJoiner STANDARD_JOINER;

   static Function keyFunction() {
      return Maps$EntryFunction.KEY;
   }

   static Function valueFunction() {
      return Maps$EntryFunction.VALUE;
   }

   static Iterator keyIterator(Iterator var0) {
      return Iterators.transform(var0, keyFunction());
   }

   static Iterator valueIterator(Iterator var0) {
      return Iterators.transform(var0, valueFunction());
   }

   @GwtCompatible(
      serializable = true
   )
   @Beta
   public static ImmutableMap immutableEnumMap(Map var0) {
      if(var0 instanceof ImmutableEnumMap) {
         ImmutableEnumMap var3 = (ImmutableEnumMap)var0;
         return var3;
      } else if(var0.isEmpty()) {
         return ImmutableMap.of();
      } else {
         Iterator var1 = var0.entrySet().iterator();

         while(var1.hasNext()) {
            Entry var2 = (Entry)var1.next();
            Preconditions.checkNotNull(var2.getKey());
            Preconditions.checkNotNull(var2.getValue());
         }

         return ImmutableEnumMap.asImmutable(new EnumMap(var0));
      }
   }

   public static HashMap newHashMap() {
      return new HashMap();
   }

   public static HashMap newHashMapWithExpectedSize(int var0) {
      return new HashMap(capacity(var0));
   }

   static int capacity(int var0) {
      if(var0 < 3) {
         CollectPreconditions.checkNonnegative(var0, "expectedSize");
         return var0 + 1;
      } else {
         return var0 < 1073741824?(int)((float)var0 / 0.75F + 1.0F):Integer.MAX_VALUE;
      }
   }

   public static HashMap newHashMap(Map var0) {
      return new HashMap(var0);
   }

   public static LinkedHashMap newLinkedHashMap() {
      return new LinkedHashMap();
   }

   public static LinkedHashMap newLinkedHashMapWithExpectedSize(int var0) {
      return new LinkedHashMap(capacity(var0));
   }

   public static LinkedHashMap newLinkedHashMap(Map var0) {
      return new LinkedHashMap(var0);
   }

   public static ConcurrentMap newConcurrentMap() {
      return (new MapMaker()).makeMap();
   }

   public static TreeMap newTreeMap() {
      return new TreeMap();
   }

   public static TreeMap newTreeMap(SortedMap var0) {
      return new TreeMap(var0);
   }

   public static TreeMap newTreeMap(@Nullable Comparator var0) {
      return new TreeMap(var0);
   }

   public static EnumMap newEnumMap(Class var0) {
      return new EnumMap((Class)Preconditions.checkNotNull(var0));
   }

   public static EnumMap newEnumMap(Map var0) {
      return new EnumMap(var0);
   }

   public static IdentityHashMap newIdentityHashMap() {
      return new IdentityHashMap();
   }

   public static MapDifference difference(Map var0, Map var1) {
      if(var0 instanceof SortedMap) {
         SortedMap var2 = (SortedMap)var0;
         SortedMapDifference var3 = difference(var2, var1);
         return var3;
      } else {
         return difference(var0, var1, Equivalence.equals());
      }
   }

   @Beta
   public static MapDifference difference(Map var0, Map var1, Equivalence var2) {
      Preconditions.checkNotNull(var2);
      LinkedHashMap var3 = newLinkedHashMap();
      LinkedHashMap var4 = new LinkedHashMap(var1);
      LinkedHashMap var5 = newLinkedHashMap();
      LinkedHashMap var6 = newLinkedHashMap();
      doDifference(var0, var1, var2, var3, var4, var5, var6);
      return new Maps$MapDifferenceImpl(var3, var4, var5, var6);
   }

   private static void doDifference(Map var0, Map var1, Equivalence var2, Map var3, Map var4, Map var5, Map var6) {
      Iterator var7 = var0.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Object var9 = var8.getKey();
         Object var10 = var8.getValue();
         if(var1.containsKey(var9)) {
            Object var11 = var4.remove(var9);
            if(var2.equivalent(var10, var11)) {
               var5.put(var9, var10);
            } else {
               var6.put(var9, Maps$ValueDifferenceImpl.create(var10, var11));
            }
         } else {
            var3.put(var9, var10);
         }
      }

   }

   private static Map unmodifiableMap(Map var0) {
      return (Map)(var0 instanceof SortedMap?Collections.unmodifiableSortedMap((SortedMap)var0):Collections.unmodifiableMap(var0));
   }

   public static SortedMapDifference difference(SortedMap var0, Map var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      Comparator var2 = orNaturalOrder(var0.comparator());
      TreeMap var3 = newTreeMap(var2);
      TreeMap var4 = newTreeMap(var2);
      var4.putAll(var1);
      TreeMap var5 = newTreeMap(var2);
      TreeMap var6 = newTreeMap(var2);
      doDifference(var0, var1, Equivalence.equals(), var3, var4, var5, var6);
      return new Maps$SortedMapDifferenceImpl(var3, var4, var5, var6);
   }

   static Comparator orNaturalOrder(@Nullable Comparator var0) {
      return (Comparator)(var0 != null?var0:Ordering.natural());
   }

   public static Map asMap(Set var0, Function var1) {
      return (Map)(var0 instanceof SortedSet?asMap((SortedSet)var0, var1):new Maps$AsMapView(var0, var1));
   }

   public static SortedMap asMap(SortedSet var0, Function var1) {
      return Platform.mapsAsMapSortedSet(var0, var1);
   }

   static SortedMap asMapSortedIgnoreNavigable(SortedSet var0, Function var1) {
      return new Maps$SortedAsMapView(var0, var1);
   }

   @GwtIncompatible("NavigableMap")
   public static NavigableMap asMap(NavigableSet var0, Function var1) {
      return new Maps$NavigableAsMapView(var0, var1);
   }

   static Iterator asMapEntryIterator(Set var0, Function var1) {
      return new Maps$1(var0.iterator(), var1);
   }

   private static Set removeOnlySet(Set var0) {
      return new Maps$2(var0);
   }

   private static SortedSet removeOnlySortedSet(SortedSet var0) {
      return new Maps$3(var0);
   }

   @GwtIncompatible("NavigableSet")
   private static NavigableSet removeOnlyNavigableSet(NavigableSet var0) {
      return new Maps$4(var0);
   }

   public static ImmutableMap toMap(Iterable var0, Function var1) {
      return toMap(var0.iterator(), var1);
   }

   public static ImmutableMap toMap(Iterator var0, Function var1) {
      Preconditions.checkNotNull(var1);
      LinkedHashMap var2 = newLinkedHashMap();

      while(var0.hasNext()) {
         Object var3 = var0.next();
         var2.put(var3, var1.apply(var3));
      }

      return ImmutableMap.copyOf((Map)var2);
   }

   public static ImmutableMap uniqueIndex(Iterable var0, Function var1) {
      return uniqueIndex(var0.iterator(), var1);
   }

   public static ImmutableMap uniqueIndex(Iterator var0, Function var1) {
      Preconditions.checkNotNull(var1);
      ImmutableMap$Builder var2 = ImmutableMap.builder();

      while(var0.hasNext()) {
         Object var3 = var0.next();
         var2.put(var1.apply(var3), var3);
      }

      try {
         return var2.build();
      } catch (IllegalArgumentException var4) {
         throw new IllegalArgumentException(String.valueOf(var4.getMessage()).concat(". To index multiple values under a key, use Multimaps.index."));
      }
   }

   @GwtIncompatible("java.util.Properties")
   public static ImmutableMap fromProperties(Properties var0) {
      ImmutableMap$Builder var1 = ImmutableMap.builder();
      Enumeration var2 = var0.propertyNames();

      while(var2.hasMoreElements()) {
         String var3 = (String)var2.nextElement();
         var1.put(var3, var0.getProperty(var3));
      }

      return var1.build();
   }

   @GwtCompatible(
      serializable = true
   )
   public static Entry immutableEntry(@Nullable Object var0, @Nullable Object var1) {
      return new ImmutableEntry(var0, var1);
   }

   static Set unmodifiableEntrySet(Set var0) {
      return new Maps$UnmodifiableEntrySet(Collections.unmodifiableSet(var0));
   }

   static Entry unmodifiableEntry(Entry var0) {
      Preconditions.checkNotNull(var0);
      return new Maps$5(var0);
   }

   static UnmodifiableIterator unmodifiableEntryIterator(Iterator var0) {
      return new Maps$6(var0);
   }

   @Beta
   public static Converter asConverter(BiMap var0) {
      return new Maps$BiMapConverter(var0);
   }

   public static BiMap synchronizedBiMap(BiMap var0) {
      return Synchronized.biMap(var0, (Object)null);
   }

   public static BiMap unmodifiableBiMap(BiMap var0) {
      return new Maps$UnmodifiableBiMap(var0, (BiMap)null);
   }

   public static Map transformValues(Map var0, Function var1) {
      return transformEntries(var0, asEntryTransformer(var1));
   }

   public static SortedMap transformValues(SortedMap var0, Function var1) {
      return transformEntries(var0, asEntryTransformer(var1));
   }

   @GwtIncompatible("NavigableMap")
   public static NavigableMap transformValues(NavigableMap var0, Function var1) {
      return transformEntries(var0, asEntryTransformer(var1));
   }

   public static Map transformEntries(Map var0, Maps$EntryTransformer var1) {
      return (Map)(var0 instanceof SortedMap?transformEntries((SortedMap)var0, var1):new Maps$TransformedEntriesMap(var0, var1));
   }

   public static SortedMap transformEntries(SortedMap var0, Maps$EntryTransformer var1) {
      return Platform.mapsTransformEntriesSortedMap(var0, var1);
   }

   @GwtIncompatible("NavigableMap")
   public static NavigableMap transformEntries(NavigableMap var0, Maps$EntryTransformer var1) {
      return new Maps$TransformedEntriesNavigableMap(var0, var1);
   }

   static SortedMap transformEntriesIgnoreNavigable(SortedMap var0, Maps$EntryTransformer var1) {
      return new Maps$TransformedEntriesSortedMap(var0, var1);
   }

   static Maps$EntryTransformer asEntryTransformer(Function var0) {
      Preconditions.checkNotNull(var0);
      return new Maps$7(var0);
   }

   static Function asValueToValueFunction(Maps$EntryTransformer var0, Object var1) {
      Preconditions.checkNotNull(var0);
      return new Maps$8(var0, var1);
   }

   static Function asEntryToValueFunction(Maps$EntryTransformer var0) {
      Preconditions.checkNotNull(var0);
      return new Maps$9(var0);
   }

   static Entry transformEntry(Maps$EntryTransformer var0, Entry var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Maps$10(var1, var0);
   }

   static Function asEntryToEntryFunction(Maps$EntryTransformer var0) {
      Preconditions.checkNotNull(var0);
      return new Maps$11(var0);
   }

   static Predicate keyPredicateOnEntries(Predicate var0) {
      return Predicates.compose(var0, keyFunction());
   }

   static Predicate valuePredicateOnEntries(Predicate var0) {
      return Predicates.compose(var0, valueFunction());
   }

   @CheckReturnValue
   public static Map filterKeys(Map var0, Predicate var1) {
      if(var0 instanceof SortedMap) {
         return filterKeys((SortedMap)var0, var1);
      } else if(var0 instanceof BiMap) {
         return filterKeys((BiMap)var0, var1);
      } else {
         Preconditions.checkNotNull(var1);
         Predicate var2 = keyPredicateOnEntries(var1);
         return (Map)(var0 instanceof Maps$AbstractFilteredMap?filterFiltered((Maps$AbstractFilteredMap)var0, var2):new Maps$FilteredKeyMap((Map)Preconditions.checkNotNull(var0), var1, var2));
      }
   }

   @CheckReturnValue
   public static SortedMap filterKeys(SortedMap var0, Predicate var1) {
      return filterEntries(var0, keyPredicateOnEntries(var1));
   }

   @CheckReturnValue
   @GwtIncompatible("NavigableMap")
   public static NavigableMap filterKeys(NavigableMap var0, Predicate var1) {
      return filterEntries(var0, keyPredicateOnEntries(var1));
   }

   @CheckReturnValue
   public static BiMap filterKeys(BiMap var0, Predicate var1) {
      Preconditions.checkNotNull(var1);
      return filterEntries(var0, keyPredicateOnEntries(var1));
   }

   @CheckReturnValue
   public static Map filterValues(Map var0, Predicate var1) {
      return (Map)(var0 instanceof SortedMap?filterValues((SortedMap)var0, var1):(var0 instanceof BiMap?filterValues((BiMap)var0, var1):filterEntries(var0, valuePredicateOnEntries(var1))));
   }

   @CheckReturnValue
   public static SortedMap filterValues(SortedMap var0, Predicate var1) {
      return filterEntries(var0, valuePredicateOnEntries(var1));
   }

   @CheckReturnValue
   @GwtIncompatible("NavigableMap")
   public static NavigableMap filterValues(NavigableMap var0, Predicate var1) {
      return filterEntries(var0, valuePredicateOnEntries(var1));
   }

   @CheckReturnValue
   public static BiMap filterValues(BiMap var0, Predicate var1) {
      return filterEntries(var0, valuePredicateOnEntries(var1));
   }

   @CheckReturnValue
   public static Map filterEntries(Map var0, Predicate var1) {
      if(var0 instanceof SortedMap) {
         return filterEntries((SortedMap)var0, var1);
      } else if(var0 instanceof BiMap) {
         return filterEntries((BiMap)var0, var1);
      } else {
         Preconditions.checkNotNull(var1);
         return (Map)(var0 instanceof Maps$AbstractFilteredMap?filterFiltered((Maps$AbstractFilteredMap)var0, var1):new Maps$FilteredEntryMap((Map)Preconditions.checkNotNull(var0), var1));
      }
   }

   @CheckReturnValue
   public static SortedMap filterEntries(SortedMap var0, Predicate var1) {
      return Platform.mapsFilterSortedMap(var0, var1);
   }

   static SortedMap filterSortedIgnoreNavigable(SortedMap var0, Predicate var1) {
      Preconditions.checkNotNull(var1);
      return (SortedMap)(var0 instanceof Maps$FilteredEntrySortedMap?filterFiltered((Maps$FilteredEntrySortedMap)var0, var1):new Maps$FilteredEntrySortedMap((SortedMap)Preconditions.checkNotNull(var0), var1));
   }

   @CheckReturnValue
   @GwtIncompatible("NavigableMap")
   public static NavigableMap filterEntries(NavigableMap var0, Predicate var1) {
      Preconditions.checkNotNull(var1);
      return (NavigableMap)(var0 instanceof Maps$FilteredEntryNavigableMap?filterFiltered((Maps$FilteredEntryNavigableMap)var0, var1):new Maps$FilteredEntryNavigableMap((NavigableMap)Preconditions.checkNotNull(var0), var1));
   }

   @CheckReturnValue
   public static BiMap filterEntries(BiMap var0, Predicate var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return (BiMap)(var0 instanceof Maps$FilteredEntryBiMap?filterFiltered((Maps$FilteredEntryBiMap)var0, var1):new Maps$FilteredEntryBiMap(var0, var1));
   }

   private static Map filterFiltered(Maps$AbstractFilteredMap var0, Predicate var1) {
      return new Maps$FilteredEntryMap(var0.unfiltered, Predicates.and(var0.predicate, var1));
   }

   private static SortedMap filterFiltered(Maps$FilteredEntrySortedMap var0, Predicate var1) {
      Predicate var2 = Predicates.and(var0.predicate, var1);
      return new Maps$FilteredEntrySortedMap(var0.sortedMap(), var2);
   }

   @GwtIncompatible("NavigableMap")
   private static NavigableMap filterFiltered(Maps$FilteredEntryNavigableMap var0, Predicate var1) {
      Predicate var2 = Predicates.and(Maps$FilteredEntryNavigableMap.access$600(var0), var1);
      return new Maps$FilteredEntryNavigableMap(Maps$FilteredEntryNavigableMap.access$700(var0), var2);
   }

   private static BiMap filterFiltered(Maps$FilteredEntryBiMap var0, Predicate var1) {
      Predicate var2 = Predicates.and(var0.predicate, var1);
      return new Maps$FilteredEntryBiMap(var0.unfiltered(), var2);
   }

   @GwtIncompatible("NavigableMap")
   public static NavigableMap unmodifiableNavigableMap(NavigableMap var0) {
      Preconditions.checkNotNull(var0);
      return (NavigableMap)(var0 instanceof Maps$UnmodifiableNavigableMap?var0:new Maps$UnmodifiableNavigableMap(var0));
   }

   @Nullable
   private static Entry unmodifiableOrNull(@Nullable Entry var0) {
      return var0 == null?null:unmodifiableEntry(var0);
   }

   @GwtIncompatible("NavigableMap")
   public static NavigableMap synchronizedNavigableMap(NavigableMap var0) {
      return Synchronized.navigableMap(var0);
   }

   static Object safeGet(Map var0, @Nullable Object var1) {
      Preconditions.checkNotNull(var0);

      try {
         return var0.get(var1);
      } catch (ClassCastException var3) {
         return null;
      } catch (NullPointerException var4) {
         return null;
      }
   }

   static boolean safeContainsKey(Map var0, Object var1) {
      Preconditions.checkNotNull(var0);

      try {
         return var0.containsKey(var1);
      } catch (ClassCastException var3) {
         return false;
      } catch (NullPointerException var4) {
         return false;
      }
   }

   static Object safeRemove(Map var0, Object var1) {
      Preconditions.checkNotNull(var0);

      try {
         return var0.remove(var1);
      } catch (ClassCastException var3) {
         return null;
      } catch (NullPointerException var4) {
         return null;
      }
   }

   static boolean containsKeyImpl(Map var0, @Nullable Object var1) {
      return Iterators.contains(keyIterator(var0.entrySet().iterator()), var1);
   }

   static boolean containsValueImpl(Map var0, @Nullable Object var1) {
      return Iterators.contains(valueIterator(var0.entrySet().iterator()), var1);
   }

   static boolean containsEntryImpl(Collection var0, Object var1) {
      return !(var1 instanceof Entry)?false:var0.contains(unmodifiableEntry((Entry)var1));
   }

   static boolean removeEntryImpl(Collection var0, Object var1) {
      return !(var1 instanceof Entry)?false:var0.remove(unmodifiableEntry((Entry)var1));
   }

   static boolean equalsImpl(Map var0, Object var1) {
      if(var0 == var1) {
         return true;
      } else if(var1 instanceof Map) {
         Map var2 = (Map)var1;
         return var0.entrySet().equals(var2.entrySet());
      } else {
         return false;
      }
   }

   static String toStringImpl(Map var0) {
      StringBuilder var1 = Collections2.newStringBuilderForCollection(var0.size()).append('{');
      STANDARD_JOINER.appendTo(var1, var0);
      return var1.append('}').toString();
   }

   static void putAllImpl(Map var0, Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var0.put(var3.getKey(), var3.getValue());
      }

   }

   @Nullable
   static Object keyOrNull(@Nullable Entry var0) {
      return var0 == null?null:var0.getKey();
   }

   @Nullable
   static Object valueOrNull(@Nullable Entry var0) {
      return var0 == null?null:var0.getValue();
   }

   static ImmutableMap indexMap(Collection var0) {
      ImmutableMap$Builder var1 = new ImmutableMap$Builder(var0.size());
      int var2 = 0;
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         var1.put(var4, Integer.valueOf(var2++));
      }

      return var1.build();
   }

   // $FF: synthetic method
   static Map access$100(Map var0) {
      return unmodifiableMap(var0);
   }

   // $FF: synthetic method
   static Set access$200(Set var0) {
      return removeOnlySet(var0);
   }

   // $FF: synthetic method
   static SortedSet access$300(SortedSet var0) {
      return removeOnlySortedSet(var0);
   }

   // $FF: synthetic method
   static NavigableSet access$400(NavigableSet var0) {
      return removeOnlyNavigableSet(var0);
   }

   // $FF: synthetic method
   static Entry access$800(Entry var0) {
      return unmodifiableOrNull(var0);
   }

   static {
      STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
   }
}
