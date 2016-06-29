/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
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
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class Synchronized {
    private Synchronized() {
    }

    private static Collection collection(Collection collection, @Nullable Object object) {
        return new Synchronized$SynchronizedCollection(collection, object, null);
    }

    @VisibleForTesting
    static Set set(Set set, @Nullable Object object) {
        return new Synchronized$SynchronizedSet(set, object);
    }

    private static SortedSet sortedSet(SortedSet sortedSet, @Nullable Object object) {
        return new Synchronized$SynchronizedSortedSet(sortedSet, object);
    }

    private static List list(List list, @Nullable Object object) {
        Synchronized$SynchronizedRandomAccessList synchronized$SynchronizedRandomAccessList /* !! */ ;
        if (list instanceof RandomAccess) {
            synchronized$SynchronizedRandomAccessList /* !! */  = new Synchronized$SynchronizedRandomAccessList(list, object);
            return synchronized$SynchronizedRandomAccessList /* !! */ ;
        }
        synchronized$SynchronizedRandomAccessList /* !! */  = new Synchronized$SynchronizedList(list, object);
        return synchronized$SynchronizedRandomAccessList /* !! */ ;
    }

    static Multiset multiset(Multiset multiset, @Nullable Object object) {
        if (multiset instanceof Synchronized$SynchronizedMultiset) return multiset;
        if (!(multiset instanceof ImmutableMultiset)) return new Synchronized$SynchronizedMultiset(multiset, object);
        return multiset;
    }

    static Multimap multimap(Multimap multimap, @Nullable Object object) {
        if (multimap instanceof Synchronized$SynchronizedMultimap) return multimap;
        if (!(multimap instanceof ImmutableMultimap)) return new Synchronized$SynchronizedMultimap(multimap, object);
        return multimap;
    }

    static ListMultimap listMultimap(ListMultimap listMultimap, @Nullable Object object) {
        if (listMultimap instanceof Synchronized$SynchronizedListMultimap) return listMultimap;
        if (!(listMultimap instanceof ImmutableListMultimap)) return new Synchronized$SynchronizedListMultimap(listMultimap, object);
        return listMultimap;
    }

    static SetMultimap setMultimap(SetMultimap setMultimap, @Nullable Object object) {
        if (setMultimap instanceof Synchronized$SynchronizedSetMultimap) return setMultimap;
        if (!(setMultimap instanceof ImmutableSetMultimap)) return new Synchronized$SynchronizedSetMultimap(setMultimap, object);
        return setMultimap;
    }

    static SortedSetMultimap sortedSetMultimap(SortedSetMultimap sortedSetMultimap, @Nullable Object object) {
        if (!(sortedSetMultimap instanceof Synchronized$SynchronizedSortedSetMultimap)) return new Synchronized$SynchronizedSortedSetMultimap(sortedSetMultimap, object);
        return sortedSetMultimap;
    }

    private static Collection typePreservingCollection(Collection collection, @Nullable Object object) {
        if (collection instanceof SortedSet) {
            return Synchronized.sortedSet((SortedSet)collection, object);
        }
        if (collection instanceof Set) {
            return Synchronized.set((Set)collection, object);
        }
        if (!(collection instanceof List)) return Synchronized.collection(collection, object);
        return Synchronized.list((List)collection, object);
    }

    private static Set typePreservingSet(Set set, @Nullable Object object) {
        if (!(set instanceof SortedSet)) return Synchronized.set(set, object);
        return Synchronized.sortedSet((SortedSet)set, object);
    }

    @VisibleForTesting
    static Map map(Map map, @Nullable Object object) {
        return new Synchronized$SynchronizedMap(map, object);
    }

    static SortedMap sortedMap(SortedMap sortedMap, @Nullable Object object) {
        return new Synchronized$SynchronizedSortedMap(sortedMap, object);
    }

    static BiMap biMap(BiMap biMap, @Nullable Object object) {
        if (biMap instanceof Synchronized$SynchronizedBiMap) return biMap;
        if (!(biMap instanceof ImmutableBiMap)) return new Synchronized$SynchronizedBiMap(biMap, object, null, null);
        return biMap;
    }

    @GwtIncompatible(value="NavigableSet")
    static NavigableSet navigableSet(NavigableSet navigableSet, @Nullable Object object) {
        return new Synchronized$SynchronizedNavigableSet(navigableSet, object);
    }

    @GwtIncompatible(value="NavigableSet")
    static NavigableSet navigableSet(NavigableSet navigableSet) {
        return Synchronized.navigableSet(navigableSet, null);
    }

    @GwtIncompatible(value="NavigableMap")
    static NavigableMap navigableMap(NavigableMap navigableMap) {
        return Synchronized.navigableMap(navigableMap, null);
    }

    @GwtIncompatible(value="NavigableMap")
    static NavigableMap navigableMap(NavigableMap navigableMap, @Nullable Object object) {
        return new Synchronized$SynchronizedNavigableMap(navigableMap, object);
    }

    @GwtIncompatible(value="works but is needed only for NavigableMap")
    private static Map.Entry nullableSynchronizedEntry(@Nullable Map.Entry entry, @Nullable Object object) {
        if (entry != null) return new Synchronized$SynchronizedEntry(entry, object);
        return null;
    }

    static Queue queue(Queue queue, @Nullable Object object) {
        Queue queue2;
        if (queue instanceof Synchronized$SynchronizedQueue) {
            queue2 = queue;
            return queue2;
        }
        queue2 = new Synchronized$SynchronizedQueue(queue, object);
        return queue2;
    }

    @GwtIncompatible(value="Deque")
    static Deque deque(Deque deque, @Nullable Object object) {
        return new Synchronized$SynchronizedDeque(deque, object);
    }

    static /* synthetic */ SortedSet access$100(SortedSet sortedSet, Object object) {
        return Synchronized.sortedSet(sortedSet, object);
    }

    static /* synthetic */ List access$200(List list, Object object) {
        return Synchronized.list(list, object);
    }

    static /* synthetic */ Set access$300(Set set, Object object) {
        return Synchronized.typePreservingSet(set, object);
    }

    static /* synthetic */ Collection access$400(Collection collection, Object object) {
        return Synchronized.typePreservingCollection(collection, object);
    }

    static /* synthetic */ Collection access$500(Collection collection, Object object) {
        return Synchronized.collection(collection, object);
    }

    static /* synthetic */ Map.Entry access$700(Map.Entry entry, Object object) {
        return Synchronized.nullableSynchronizedEntry(entry, object);
    }
}

