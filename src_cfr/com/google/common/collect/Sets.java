/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Platform;
import com.google.common.collect.Range;
import com.google.common.collect.Sets$1;
import com.google.common.collect.Sets$2;
import com.google.common.collect.Sets$3;
import com.google.common.collect.Sets$4;
import com.google.common.collect.Sets$CartesianSet;
import com.google.common.collect.Sets$FilteredNavigableSet;
import com.google.common.collect.Sets$FilteredSet;
import com.google.common.collect.Sets$FilteredSortedSet;
import com.google.common.collect.Sets$PowerSet;
import com.google.common.collect.Sets$SetView;
import com.google.common.collect.Sets$UnmodifiableNavigableSet;
import com.google.common.collect.Synchronized;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
public final class Sets {
    private Sets() {
    }

    @GwtCompatible(serializable=1)
    public static /* varargs */ ImmutableSet immutableEnumSet(Enum enum_, Enum ... arrenum) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(enum_, arrenum));
    }

    @GwtCompatible(serializable=1)
    public static ImmutableSet immutableEnumSet(Iterable iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet)iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection)iterable;
            if (!collection.isEmpty()) return ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
            return ImmutableSet.of();
        }
        Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) return ImmutableSet.of();
        EnumSet<Enum> enumSet = EnumSet.of((Enum)iterator.next());
        Iterators.addAll(enumSet, iterator);
        return ImmutableEnumSet.asImmutable(enumSet);
    }

    public static EnumSet newEnumSet(Iterable iterable, Class class_) {
        EnumSet enumSet = EnumSet.noneOf(class_);
        Iterables.addAll(enumSet, iterable);
        return enumSet;
    }

    public static HashSet newHashSet() {
        return new HashSet();
    }

    public static /* varargs */ HashSet newHashSet(Object ... arrobject) {
        HashSet hashSet = Sets.newHashSetWithExpectedSize(arrobject.length);
        Collections.addAll(hashSet, arrobject);
        return hashSet;
    }

    public static HashSet newHashSetWithExpectedSize(int n2) {
        return new HashSet(Maps.capacity(n2));
    }

    public static HashSet newHashSet(Iterable iterable) {
        HashSet hashSet;
        if (iterable instanceof Collection) {
            hashSet = new HashSet(Collections2.cast(iterable));
            return hashSet;
        }
        hashSet = Sets.newHashSet(iterable.iterator());
        return hashSet;
    }

    public static HashSet newHashSet(Iterator iterator) {
        HashSet hashSet = Sets.newHashSet();
        Iterators.addAll(hashSet, iterator);
        return hashSet;
    }

    public static Set newConcurrentHashSet() {
        return Sets.newSetFromMap(new ConcurrentHashMap());
    }

    @GoogleInternal
    public static /* varargs */ Set newConcurrentHashSet(Object ... arrobject) {
        int n2 = Maps.capacity(arrobject.length);
        Set set = Sets.newSetFromMap(new ConcurrentHashMap(n2));
        Collections.addAll(set, arrobject);
        return set;
    }

    public static Set newConcurrentHashSet(Iterable iterable) {
        Set set = Sets.newConcurrentHashSet();
        Iterables.addAll(set, iterable);
        return set;
    }

    public static LinkedHashSet newLinkedHashSet() {
        return new LinkedHashSet();
    }

    @GoogleInternal
    public static /* varargs */ LinkedHashSet newLinkedHashSet(Object ... arrobject) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Maps.capacity(arrobject.length));
        Collections.addAll(linkedHashSet, arrobject);
        return linkedHashSet;
    }

    public static LinkedHashSet newLinkedHashSetWithExpectedSize(int n2) {
        return new LinkedHashSet(Maps.capacity(n2));
    }

    public static LinkedHashSet newLinkedHashSet(Iterable iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet(Collections2.cast(iterable));
        }
        LinkedHashSet linkedHashSet = Sets.newLinkedHashSet();
        Iterables.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @GoogleInternal
    public static LinkedHashSet newLinkedHashSet(Iterator iterator) {
        LinkedHashSet linkedHashSet = Sets.newLinkedHashSet();
        Iterators.addAll(linkedHashSet, iterator);
        return linkedHashSet;
    }

    public static TreeSet newTreeSet() {
        return new TreeSet();
    }

    @GoogleInternal
    public static /* varargs */ TreeSet newTreeSet(Comparable ... arrcomparable) {
        TreeSet treeSet = Sets.newTreeSet();
        Collections.addAll(treeSet, arrcomparable);
        return treeSet;
    }

    public static TreeSet newTreeSet(Iterable iterable) {
        TreeSet treeSet = Sets.newTreeSet();
        Iterables.addAll(treeSet, iterable);
        return treeSet;
    }

    @GoogleInternal
    public static TreeSet newTreeSet(Iterator iterator) {
        TreeSet treeSet = Sets.newTreeSet();
        Iterators.addAll(treeSet, iterator);
        return treeSet;
    }

    public static TreeSet newTreeSet(Comparator comparator) {
        return new TreeSet((Comparator)Preconditions.checkNotNull(comparator));
    }

    @GoogleInternal
    public static /* varargs */ TreeSet newTreeSet(Comparator comparator, Object ... arrobject) {
        TreeSet treeSet = Sets.newTreeSet(comparator);
        Collections.addAll(treeSet, arrobject);
        return treeSet;
    }

    @GoogleInternal
    public static TreeSet newTreeSet(Comparator comparator, Iterable iterable) {
        return Sets.newTreeSet(comparator, iterable.iterator());
    }

    @GoogleInternal
    public static TreeSet newTreeSet(Comparator comparator, Iterator iterator) {
        TreeSet treeSet = Sets.newTreeSet(comparator);
        Iterators.addAll(treeSet, iterator);
        return treeSet;
    }

    public static Set newIdentityHashSet() {
        return Sets.newSetFromMap(Maps.newIdentityHashMap());
    }

    @GwtIncompatible(value="CopyOnWriteArraySet")
    public static CopyOnWriteArraySet newCopyOnWriteArraySet() {
        return new CopyOnWriteArraySet();
    }

    @GwtIncompatible(value="CopyOnWriteArraySet")
    public static CopyOnWriteArraySet newCopyOnWriteArraySet(Iterable iterable) {
        Collection collection = iterable instanceof Collection ? Collections2.cast(iterable) : Lists.newArrayList(iterable);
        return new CopyOnWriteArraySet(collection);
    }

    public static EnumSet complementOf(Collection collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet)collection);
        }
        Preconditions.checkArgument(!collection.isEmpty(), "collection is empty; use the other version of this method");
        Class class_ = ((Enum)collection.iterator().next()).getDeclaringClass();
        return Sets.makeComplementByHand(collection, class_);
    }

    public static EnumSet complementOf(Collection collection, Class class_) {
        EnumSet enumSet;
        Preconditions.checkNotNull(collection);
        if (collection instanceof EnumSet) {
            enumSet = EnumSet.complementOf((EnumSet)collection);
            return enumSet;
        }
        enumSet = Sets.makeComplementByHand(collection, class_);
        return enumSet;
    }

    private static EnumSet makeComplementByHand(Collection collection, Class class_) {
        EnumSet enumSet = EnumSet.allOf(class_);
        enumSet.removeAll(collection);
        return enumSet;
    }

    @GoogleInternal
    public static SortedSet asIntegerSet(int n2, int n3) {
        ImmutableSortedSet immutableSortedSet;
        if (n3 < n2) {
            immutableSortedSet = ImmutableSortedSet.of();
            return immutableSortedSet;
        }
        immutableSortedSet = ContiguousSet.create(Range.closed(Integer.valueOf(n2), Integer.valueOf(n3)), DiscreteDomain.integers());
        return immutableSortedSet;
    }

    @Deprecated
    static Set newSetFromMap(Map map) {
        return Platform.newSetFromMap(map);
    }

    public static Sets$SetView union(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        Sets$SetView sets$SetView = Sets.difference(set2, set);
        return new Sets$1(set, sets$SetView, set2);
    }

    public static Sets$SetView intersection(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        Predicate predicate = Predicates.in(set2);
        return new Sets$2(set, predicate, set2);
    }

    public static Sets$SetView difference(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        Predicate predicate = Predicates.not(Predicates.in(set2));
        return new Sets$3(set, predicate, set2);
    }

    public static Sets$SetView symmetricDifference(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new Sets$4(set, set2);
    }

    @CheckReturnValue
    public static Set filter(Set set, Predicate predicate) {
        if (set instanceof SortedSet) {
            return Sets.filter((SortedSet)set, predicate);
        }
        if (!(set instanceof Sets$FilteredSet)) return new Sets$FilteredSet((Set)Preconditions.checkNotNull(set), (Predicate)Preconditions.checkNotNull(predicate));
        Sets$FilteredSet sets$FilteredSet = (Sets$FilteredSet)set;
        Predicate predicate2 = Predicates.and(sets$FilteredSet.predicate, predicate);
        return new Sets$FilteredSet((Set)sets$FilteredSet.unfiltered, predicate2);
    }

    @CheckReturnValue
    public static SortedSet filter(SortedSet sortedSet, Predicate predicate) {
        return Platform.setsFilterSortedSet(sortedSet, predicate);
    }

    static SortedSet filterSortedIgnoreNavigable(SortedSet sortedSet, Predicate predicate) {
        if (!(sortedSet instanceof Sets$FilteredSet)) return new Sets$FilteredSortedSet((SortedSet)Preconditions.checkNotNull(sortedSet), (Predicate)Preconditions.checkNotNull(predicate));
        Sets$FilteredSet sets$FilteredSet = (Sets$FilteredSet)((Object)sortedSet);
        Predicate predicate2 = Predicates.and(sets$FilteredSet.predicate, predicate);
        return new Sets$FilteredSortedSet((SortedSet)sets$FilteredSet.unfiltered, predicate2);
    }

    @CheckReturnValue
    @GwtIncompatible(value="NavigableSet")
    public static NavigableSet filter(NavigableSet navigableSet, Predicate predicate) {
        if (!(navigableSet instanceof Sets$FilteredSet)) return new Sets$FilteredNavigableSet((NavigableSet)Preconditions.checkNotNull(navigableSet), (Predicate)Preconditions.checkNotNull(predicate));
        Sets$FilteredSet sets$FilteredSet = (Sets$FilteredSet)((Object)navigableSet);
        Predicate predicate2 = Predicates.and(sets$FilteredSet.predicate, predicate);
        return new Sets$FilteredNavigableSet((NavigableSet)sets$FilteredSet.unfiltered, predicate2);
    }

    public static Set cartesianProduct(List list) {
        return Sets$CartesianSet.create(list);
    }

    public static /* varargs */ Set cartesianProduct(Set ... arrset) {
        return Sets.cartesianProduct(Arrays.asList(arrset));
    }

    @GwtCompatible(serializable=0)
    public static Set powerSet(Set set) {
        return new Sets$PowerSet(set);
    }

    static int hashCodeImpl(Set set) {
        int n2 = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            n2 += e2 != null ? e2.hashCode() : 0;
            n2 = ~ (~ n2);
        }
        return n2;
    }

    static boolean equalsImpl(Set set, @Nullable Object object) {
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) return false;
        Set set2 = (Set)object;
        try {
            if (set.size() != set2.size()) return false;
            if (!set.containsAll(set2)) return false;
            return true;
        }
        catch (NullPointerException var3_3) {
            return false;
        }
        catch (ClassCastException var3_4) {
            return false;
        }
    }

    @GwtIncompatible(value="NavigableSet")
    public static NavigableSet unmodifiableNavigableSet(NavigableSet navigableSet) {
        if (navigableSet instanceof ImmutableSortedSet) return navigableSet;
        if (!(navigableSet instanceof Sets$UnmodifiableNavigableSet)) return new Sets$UnmodifiableNavigableSet(navigableSet);
        return navigableSet;
    }

    @GwtIncompatible(value="NavigableSet")
    public static NavigableSet synchronizedNavigableSet(NavigableSet navigableSet) {
        return Synchronized.navigableSet(navigableSet);
    }

    static boolean removeAllImpl(Set set, Iterator iterator) {
        boolean bl2 = false;
        while (iterator.hasNext()) {
            bl2 |= set.remove(iterator.next());
        }
        return bl2;
    }

    static boolean removeAllImpl(Set set, Collection collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset)collection).elementSet();
        }
        if (!(collection instanceof Set)) return Sets.removeAllImpl(set, collection.iterator());
        if (collection.size() <= set.size()) return Sets.removeAllImpl(set, collection.iterator());
        return Iterators.removeAll(set.iterator(), collection);
    }
}

