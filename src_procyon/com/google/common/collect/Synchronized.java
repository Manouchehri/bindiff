package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible(emulated = true)
final class Synchronized
{
    private static Collection collection(final Collection collection, @Nullable final Object o) {
        return new Synchronized$SynchronizedCollection(collection, o, null);
    }
    
    @VisibleForTesting
    static Set set(final Set set, @Nullable final Object o) {
        return new Synchronized$SynchronizedSet(set, o);
    }
    
    private static SortedSet sortedSet(final SortedSet set, @Nullable final Object o) {
        return new Synchronized$SynchronizedSortedSet(set, o);
    }
    
    private static List list(final List list, @Nullable final Object o) {
        return (list instanceof RandomAccess) ? new Synchronized$SynchronizedRandomAccessList(list, o) : new Synchronized$SynchronizedList(list, o);
    }
    
    static Multiset multiset(final Multiset multiset, @Nullable final Object o) {
        if (multiset instanceof Synchronized$SynchronizedMultiset || multiset instanceof ImmutableMultiset) {
            return multiset;
        }
        return new Synchronized$SynchronizedMultiset(multiset, o);
    }
    
    static Multimap multimap(final Multimap multimap, @Nullable final Object o) {
        if (multimap instanceof Synchronized$SynchronizedMultimap || multimap instanceof ImmutableMultimap) {
            return multimap;
        }
        return new Synchronized$SynchronizedMultimap(multimap, o);
    }
    
    static ListMultimap listMultimap(final ListMultimap listMultimap, @Nullable final Object o) {
        if (listMultimap instanceof Synchronized$SynchronizedListMultimap || listMultimap instanceof ImmutableListMultimap) {
            return listMultimap;
        }
        return new Synchronized$SynchronizedListMultimap(listMultimap, o);
    }
    
    static SetMultimap setMultimap(final SetMultimap setMultimap, @Nullable final Object o) {
        if (setMultimap instanceof Synchronized$SynchronizedSetMultimap || setMultimap instanceof ImmutableSetMultimap) {
            return setMultimap;
        }
        return new Synchronized$SynchronizedSetMultimap(setMultimap, o);
    }
    
    static SortedSetMultimap sortedSetMultimap(final SortedSetMultimap sortedSetMultimap, @Nullable final Object o) {
        if (sortedSetMultimap instanceof Synchronized$SynchronizedSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new Synchronized$SynchronizedSortedSetMultimap(sortedSetMultimap, o);
    }
    
    private static Collection typePreservingCollection(final Collection collection, @Nullable final Object o) {
        if (collection instanceof SortedSet) {
            return sortedSet((SortedSet)collection, o);
        }
        if (collection instanceof Set) {
            return set((Set)collection, o);
        }
        if (collection instanceof List) {
            return list((List)collection, o);
        }
        return collection(collection, o);
    }
    
    private static Set typePreservingSet(final Set set, @Nullable final Object o) {
        if (set instanceof SortedSet) {
            return sortedSet((SortedSet)set, o);
        }
        return set(set, o);
    }
    
    @VisibleForTesting
    static Map map(final Map map, @Nullable final Object o) {
        return new Synchronized$SynchronizedMap(map, o);
    }
    
    static SortedMap sortedMap(final SortedMap sortedMap, @Nullable final Object o) {
        return new Synchronized$SynchronizedSortedMap(sortedMap, o);
    }
    
    static BiMap biMap(final BiMap biMap, @Nullable final Object o) {
        if (biMap instanceof Synchronized$SynchronizedBiMap || biMap instanceof ImmutableBiMap) {
            return biMap;
        }
        return new Synchronized$SynchronizedBiMap(biMap, o, null, null);
    }
    
    @GwtIncompatible("NavigableSet")
    static NavigableSet navigableSet(final NavigableSet set, @Nullable final Object o) {
        return new Synchronized$SynchronizedNavigableSet(set, o);
    }
    
    @GwtIncompatible("NavigableSet")
    static NavigableSet navigableSet(final NavigableSet set) {
        return navigableSet(set, null);
    }
    
    @GwtIncompatible("NavigableMap")
    static NavigableMap navigableMap(final NavigableMap navigableMap) {
        return navigableMap(navigableMap, null);
    }
    
    @GwtIncompatible("NavigableMap")
    static NavigableMap navigableMap(final NavigableMap navigableMap, @Nullable final Object o) {
        return new Synchronized$SynchronizedNavigableMap(navigableMap, o);
    }
    
    @GwtIncompatible("works but is needed only for NavigableMap")
    private static Map.Entry nullableSynchronizedEntry(@Nullable final Map.Entry entry, @Nullable final Object o) {
        if (entry == null) {
            return null;
        }
        return new Synchronized$SynchronizedEntry(entry, o);
    }
    
    static Queue queue(final Queue queue, @Nullable final Object o) {
        return (queue instanceof Synchronized$SynchronizedQueue) ? queue : new Synchronized$SynchronizedQueue(queue, o);
    }
    
    @GwtIncompatible("Deque")
    static Deque deque(final Deque deque, @Nullable final Object o) {
        return new Synchronized$SynchronizedDeque(deque, o);
    }
}
