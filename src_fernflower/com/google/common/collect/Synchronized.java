package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedBiMap;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import com.google.common.collect.Synchronized$SynchronizedDeque;
import com.google.common.collect.Synchronized$SynchronizedEntry;
import com.google.common.collect.Synchronized$SynchronizedList;
import com.google.common.collect.Synchronized$SynchronizedListMultimap;
import com.google.common.collect.Synchronized$SynchronizedMap;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import com.google.common.collect.Synchronized$SynchronizedMultiset;
import com.google.common.collect.Synchronized$SynchronizedNavigableMap;
import com.google.common.collect.Synchronized$SynchronizedNavigableSet;
import com.google.common.collect.Synchronized$SynchronizedQueue;
import com.google.common.collect.Synchronized$SynchronizedRandomAccessList;
import com.google.common.collect.Synchronized$SynchronizedSet;
import com.google.common.collect.Synchronized$SynchronizedSetMultimap;
import com.google.common.collect.Synchronized$SynchronizedSortedMap;
import com.google.common.collect.Synchronized$SynchronizedSortedSet;
import com.google.common.collect.Synchronized$SynchronizedSortedSetMultimap;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
final class Synchronized {
   private static Collection collection(Collection var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedCollection(var0, var1, (Synchronized$1)null);
   }

   @VisibleForTesting
   static Set set(Set var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedSet(var0, var1);
   }

   private static SortedSet sortedSet(SortedSet var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedSortedSet(var0, var1);
   }

   private static List list(List var0, @Nullable Object var1) {
      return (List)(var0 instanceof RandomAccess?new Synchronized$SynchronizedRandomAccessList(var0, var1):new Synchronized$SynchronizedList(var0, var1));
   }

   static Multiset multiset(Multiset var0, @Nullable Object var1) {
      return (Multiset)(!(var0 instanceof Synchronized$SynchronizedMultiset) && !(var0 instanceof ImmutableMultiset)?new Synchronized$SynchronizedMultiset(var0, var1):var0);
   }

   static Multimap multimap(Multimap var0, @Nullable Object var1) {
      return (Multimap)(!(var0 instanceof Synchronized$SynchronizedMultimap) && !(var0 instanceof ImmutableMultimap)?new Synchronized$SynchronizedMultimap(var0, var1):var0);
   }

   static ListMultimap listMultimap(ListMultimap var0, @Nullable Object var1) {
      return (ListMultimap)(!(var0 instanceof Synchronized$SynchronizedListMultimap) && !(var0 instanceof ImmutableListMultimap)?new Synchronized$SynchronizedListMultimap(var0, var1):var0);
   }

   static SetMultimap setMultimap(SetMultimap var0, @Nullable Object var1) {
      return (SetMultimap)(!(var0 instanceof Synchronized$SynchronizedSetMultimap) && !(var0 instanceof ImmutableSetMultimap)?new Synchronized$SynchronizedSetMultimap(var0, var1):var0);
   }

   static SortedSetMultimap sortedSetMultimap(SortedSetMultimap var0, @Nullable Object var1) {
      return (SortedSetMultimap)(var0 instanceof Synchronized$SynchronizedSortedSetMultimap?var0:new Synchronized$SynchronizedSortedSetMultimap(var0, var1));
   }

   private static Collection typePreservingCollection(Collection var0, @Nullable Object var1) {
      return (Collection)(var0 instanceof SortedSet?sortedSet((SortedSet)var0, var1):(var0 instanceof Set?set((Set)var0, var1):(var0 instanceof List?list((List)var0, var1):collection(var0, var1))));
   }

   private static Set typePreservingSet(Set var0, @Nullable Object var1) {
      return (Set)(var0 instanceof SortedSet?sortedSet((SortedSet)var0, var1):set(var0, var1));
   }

   @VisibleForTesting
   static Map map(Map var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedMap(var0, var1);
   }

   static SortedMap sortedMap(SortedMap var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedSortedMap(var0, var1);
   }

   static BiMap biMap(BiMap var0, @Nullable Object var1) {
      return (BiMap)(!(var0 instanceof Synchronized$SynchronizedBiMap) && !(var0 instanceof ImmutableBiMap)?new Synchronized$SynchronizedBiMap(var0, var1, (BiMap)null, (Synchronized$1)null):var0);
   }

   @GwtIncompatible("NavigableSet")
   static NavigableSet navigableSet(NavigableSet var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedNavigableSet(var0, var1);
   }

   @GwtIncompatible("NavigableSet")
   static NavigableSet navigableSet(NavigableSet var0) {
      return navigableSet(var0, (Object)null);
   }

   @GwtIncompatible("NavigableMap")
   static NavigableMap navigableMap(NavigableMap var0) {
      return navigableMap(var0, (Object)null);
   }

   @GwtIncompatible("NavigableMap")
   static NavigableMap navigableMap(NavigableMap var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedNavigableMap(var0, var1);
   }

   @GwtIncompatible("works but is needed only for NavigableMap")
   private static Entry nullableSynchronizedEntry(@Nullable Entry var0, @Nullable Object var1) {
      return var0 == null?null:new Synchronized$SynchronizedEntry(var0, var1);
   }

   static Queue queue(Queue var0, @Nullable Object var1) {
      return (Queue)(var0 instanceof Synchronized$SynchronizedQueue?var0:new Synchronized$SynchronizedQueue(var0, var1));
   }

   @GwtIncompatible("Deque")
   static Deque deque(Deque var0, @Nullable Object var1) {
      return new Synchronized$SynchronizedDeque(var0, var1);
   }

   // $FF: synthetic method
   static SortedSet access$100(SortedSet var0, Object var1) {
      return sortedSet(var0, var1);
   }

   // $FF: synthetic method
   static List access$200(List var0, Object var1) {
      return list(var0, var1);
   }

   // $FF: synthetic method
   static Set access$300(Set var0, Object var1) {
      return typePreservingSet(var0, var1);
   }

   // $FF: synthetic method
   static Collection access$400(Collection var0, Object var1) {
      return typePreservingCollection(var0, var1);
   }

   // $FF: synthetic method
   static Collection access$500(Collection var0, Object var1) {
      return collection(var0, var1);
   }

   // $FF: synthetic method
   static Entry access$700(Entry var0, Object var1) {
      return nullableSynchronizedEntry(var0, var1);
   }
}
