package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

@GwtCompatible(emulated = true)
public final class Sets
{
    @GwtCompatible(serializable = true)
    public static ImmutableSet immutableEnumSet(final Enum enum1, final Enum... array) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(enum1, (Enum[])array));
    }
    
    @GwtCompatible(serializable = true)
    public static ImmutableSet immutableEnumSet(final Iterable iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet)iterable;
        }
        if (iterable instanceof Collection) {
            final ImmutableEnumSet set = (ImmutableEnumSet)iterable;
            if (set.isEmpty()) {
                return ImmutableSet.of();
            }
            return ImmutableEnumSet.asImmutable(EnumSet.copyOf((Collection<Enum>)set));
        }
        else {
            final Iterator<E> iterator = iterable.iterator();
            if (iterator.hasNext()) {
                final EnumSet<Enum> of = EnumSet.of((Enum)iterator.next());
                Iterators.addAll(of, iterator);
                return ImmutableEnumSet.asImmutable(of);
            }
            return ImmutableSet.of();
        }
    }
    
    public static EnumSet newEnumSet(final Iterable iterable, final Class clazz) {
        final EnumSet<Enum> none = EnumSet.noneOf((Class<Enum>)clazz);
        Iterables.addAll(none, iterable);
        return none;
    }
    
    public static HashSet newHashSet() {
        return new HashSet();
    }
    
    public static HashSet newHashSet(final Object... array) {
        final HashSet hashSetWithExpectedSize = newHashSetWithExpectedSize(array.length);
        Collections.addAll(hashSetWithExpectedSize, array);
        return hashSetWithExpectedSize;
    }
    
    public static HashSet newHashSetWithExpectedSize(final int n) {
        return new HashSet(Maps.capacity(n));
    }
    
    public static HashSet newHashSet(final Iterable iterable) {
        return (iterable instanceof Collection) ? new HashSet(Collections2.cast(iterable)) : newHashSet(iterable.iterator());
    }
    
    public static HashSet newHashSet(final Iterator iterator) {
        final HashSet hashSet = newHashSet();
        Iterators.addAll(hashSet, iterator);
        return hashSet;
    }
    
    public static Set newConcurrentHashSet() {
        return newSetFromMap(new ConcurrentHashMap());
    }
    
    @GoogleInternal
    public static Set newConcurrentHashSet(final Object... array) {
        final Set setFromMap = newSetFromMap(new ConcurrentHashMap(Maps.capacity(array.length)));
        Collections.addAll(setFromMap, array);
        return setFromMap;
    }
    
    public static Set newConcurrentHashSet(final Iterable iterable) {
        final Set concurrentHashSet = newConcurrentHashSet();
        Iterables.addAll(concurrentHashSet, iterable);
        return concurrentHashSet;
    }
    
    public static LinkedHashSet newLinkedHashSet() {
        return new LinkedHashSet();
    }
    
    @GoogleInternal
    public static LinkedHashSet newLinkedHashSet(final Object... array) {
        final LinkedHashSet<Object> set = new LinkedHashSet<Object>(Maps.capacity(array.length));
        Collections.addAll(set, array);
        return set;
    }
    
    public static LinkedHashSet newLinkedHashSetWithExpectedSize(final int n) {
        return new LinkedHashSet(Maps.capacity(n));
    }
    
    public static LinkedHashSet newLinkedHashSet(final Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet(Collections2.cast(iterable));
        }
        final LinkedHashSet linkedHashSet = newLinkedHashSet();
        Iterables.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }
    
    @GoogleInternal
    public static LinkedHashSet newLinkedHashSet(final Iterator iterator) {
        final LinkedHashSet linkedHashSet = newLinkedHashSet();
        Iterators.addAll(linkedHashSet, iterator);
        return linkedHashSet;
    }
    
    public static TreeSet newTreeSet() {
        return new TreeSet();
    }
    
    @GoogleInternal
    public static TreeSet newTreeSet(final Comparable... array) {
        final TreeSet treeSet = newTreeSet();
        Collections.addAll(treeSet, (Comparable[])array);
        return treeSet;
    }
    
    public static TreeSet newTreeSet(final Iterable iterable) {
        final TreeSet treeSet = newTreeSet();
        Iterables.addAll(treeSet, iterable);
        return treeSet;
    }
    
    @GoogleInternal
    public static TreeSet newTreeSet(final Iterator iterator) {
        final TreeSet treeSet = newTreeSet();
        Iterators.addAll(treeSet, iterator);
        return treeSet;
    }
    
    public static TreeSet newTreeSet(final Comparator comparator) {
        return new TreeSet((Comparator<? super E>)Preconditions.checkNotNull(comparator));
    }
    
    @GoogleInternal
    public static TreeSet newTreeSet(final Comparator comparator, final Object... array) {
        final TreeSet treeSet = newTreeSet(comparator);
        Collections.addAll(treeSet, array);
        return treeSet;
    }
    
    @GoogleInternal
    public static TreeSet newTreeSet(final Comparator comparator, final Iterable iterable) {
        return newTreeSet(comparator, iterable.iterator());
    }
    
    @GoogleInternal
    public static TreeSet newTreeSet(final Comparator comparator, final Iterator iterator) {
        final TreeSet treeSet = newTreeSet(comparator);
        Iterators.addAll(treeSet, iterator);
        return treeSet;
    }
    
    public static Set newIdentityHashSet() {
        return newSetFromMap(Maps.newIdentityHashMap());
    }
    
    @GwtIncompatible("CopyOnWriteArraySet")
    public static CopyOnWriteArraySet newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet();
    }
    
    @GwtIncompatible("CopyOnWriteArraySet")
    public static CopyOnWriteArraySet newCopyOnWriteArraySet(final Iterable iterable) {
        return new CopyOnWriteArraySet((iterable instanceof Collection) ? Collections2.cast(iterable) : Lists.newArrayList(iterable));
    }
    
    public static EnumSet complementOf(final Collection collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet<Enum>)collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), (Object)"collection is empty; use the other version of this method");
        return makeComplementByHand(collection, collection.iterator().next().getDeclaringClass());
    }
    
    public static EnumSet complementOf(final Collection collection, final Class clazz) {
        Preconditions.checkNotNull(collection);
        return (collection instanceof EnumSet) ? EnumSet.complementOf((EnumSet<Enum>)collection) : makeComplementByHand(collection, clazz);
    }
    
    private static EnumSet makeComplementByHand(final Collection collection, final Class clazz) {
        final EnumSet<Enum> all = EnumSet.allOf((Class<Enum>)clazz);
        all.removeAll(collection);
        return all;
    }
    
    @GoogleInternal
    public static SortedSet asIntegerSet(final int n, final int n2) {
        return (n2 < n) ? ImmutableSortedSet.of() : ContiguousSet.create(Range.closed(n, n2), DiscreteDomain.integers());
    }
    
    @Deprecated
    static Set newSetFromMap(final Map map) {
        return Platform.newSetFromMap(map);
    }
    
    public static Sets$SetView union(final Set set, final Set set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return new Sets$1(set, difference(set2, set), set2);
    }
    
    public static Sets$SetView intersection(final Set set, final Set set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return new Sets$2(set, Predicates.in(set2), set2);
    }
    
    public static Sets$SetView difference(final Set set, final Set set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return new Sets$3(set, Predicates.not(Predicates.in(set2)), set2);
    }
    
    public static Sets$SetView symmetricDifference(final Set set, final Set set2) {
        Preconditions.checkNotNull(set, (Object)"set1");
        Preconditions.checkNotNull(set2, (Object)"set2");
        return new Sets$4(set, set2);
    }
    
    @CheckReturnValue
    public static Set filter(final Set set, final Predicate predicate) {
        if (set instanceof SortedSet) {
            return filter((SortedSet)set, predicate);
        }
        if (set instanceof Sets$FilteredSet) {
            final Sets$FilteredSet set2 = (Sets$FilteredSet)set;
            return new Sets$FilteredSet((Set)set2.unfiltered, Predicates.and(set2.predicate, predicate));
        }
        return new Sets$FilteredSet((Set)Preconditions.checkNotNull(set), (Predicate)Preconditions.checkNotNull(predicate));
    }
    
    @CheckReturnValue
    public static SortedSet filter(final SortedSet set, final Predicate predicate) {
        return Platform.setsFilterSortedSet(set, predicate);
    }
    
    static SortedSet filterSortedIgnoreNavigable(final SortedSet set, final Predicate predicate) {
        if (set instanceof Sets$FilteredSet) {
            final Sets$FilteredSet set2 = (Sets$FilteredSet)set;
            return new Sets$FilteredSortedSet((SortedSet)set2.unfiltered, Predicates.and(set2.predicate, predicate));
        }
        return new Sets$FilteredSortedSet((SortedSet)Preconditions.checkNotNull(set), (Predicate)Preconditions.checkNotNull(predicate));
    }
    
    @CheckReturnValue
    @GwtIncompatible("NavigableSet")
    public static NavigableSet filter(final NavigableSet set, final Predicate predicate) {
        if (set instanceof Sets$FilteredSet) {
            final Sets$FilteredSet set2 = (Sets$FilteredSet)set;
            return new Sets$FilteredNavigableSet((NavigableSet)set2.unfiltered, Predicates.and(set2.predicate, predicate));
        }
        return new Sets$FilteredNavigableSet((NavigableSet)Preconditions.checkNotNull(set), (Predicate)Preconditions.checkNotNull(predicate));
    }
    
    public static Set cartesianProduct(final List list) {
        return Sets$CartesianSet.create(list);
    }
    
    public static Set cartesianProduct(final Set... array) {
        return cartesianProduct(Arrays.asList((Set[])array));
    }
    
    @GwtCompatible(serializable = false)
    public static Set powerSet(final Set set) {
        return new Sets$PowerSet(set);
    }
    
    static int hashCodeImpl(final Set set) {
        int n = 0;
        for (final Object next : set) {
            n = ~(~(n + ((next != null) ? next.hashCode() : 0)));
        }
        return n;
    }
    
    static boolean equalsImpl(final Set set, @Nullable final Object o) {
        if (set == o) {
            return true;
        }
        if (o instanceof Set) {
            final Set set2 = (Set)o;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            }
            catch (NullPointerException ex) {
                return false;
            }
            catch (ClassCastException ex2) {
                return false;
            }
        }
        return false;
    }
    
    @GwtIncompatible("NavigableSet")
    public static NavigableSet unmodifiableNavigableSet(final NavigableSet set) {
        if (set instanceof ImmutableSortedSet || set instanceof Sets$UnmodifiableNavigableSet) {
            return set;
        }
        return new Sets$UnmodifiableNavigableSet(set);
    }
    
    @GwtIncompatible("NavigableSet")
    public static NavigableSet synchronizedNavigableSet(final NavigableSet set) {
        return Synchronized.navigableSet(set);
    }
    
    static boolean removeAllImpl(final Set set, final Iterator iterator) {
        boolean b = false;
        while (iterator.hasNext()) {
            b |= set.remove(iterator.next());
        }
        return b;
    }
    
    static boolean removeAllImpl(final Set set, Collection elementSet) {
        Preconditions.checkNotNull(elementSet);
        if (elementSet instanceof Multiset) {
            elementSet = ((Multiset)elementSet).elementSet();
        }
        if (elementSet instanceof Set && elementSet.size() > set.size()) {
            return Iterators.removeAll(set.iterator(), elementSet);
        }
        return removeAllImpl(set, elementSet.iterator());
    }
}
