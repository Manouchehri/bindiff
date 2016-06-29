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
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$1;
import com.google.common.collect.Multisets$2;
import com.google.common.collect.Multisets$3;
import com.google.common.collect.Multisets$4;
import com.google.common.collect.Multisets$5;
import com.google.common.collect.Multisets$FilteredMultiset;
import com.google.common.collect.Multisets$ImmutableEntry;
import com.google.common.collect.Multisets$MultisetIteratorImpl;
import com.google.common.collect.Multisets$UnmodifiableMultiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.UnmodifiableSortedMultiset;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class Multisets {
    private static final Ordering DECREASING_COUNT_ORDERING = new Multisets$5();

    private Multisets() {
    }

    public static Multiset unmodifiableMultiset(Multiset multiset) {
        if (multiset instanceof Multisets$UnmodifiableMultiset) return multiset;
        if (!(multiset instanceof ImmutableMultiset)) return new Multisets$UnmodifiableMultiset((Multiset)Preconditions.checkNotNull(multiset));
        return multiset;
    }

    @Deprecated
    public static Multiset unmodifiableMultiset(ImmutableMultiset immutableMultiset) {
        return (Multiset)Preconditions.checkNotNull(immutableMultiset);
    }

    @Beta
    public static SortedMultiset unmodifiableSortedMultiset(SortedMultiset sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset)Preconditions.checkNotNull(sortedMultiset));
    }

    public static Multiset$Entry immutableEntry(@Nullable Object object, int n2) {
        return new Multisets$ImmutableEntry(object, n2);
    }

    @CheckReturnValue
    @Beta
    public static Multiset filter(Multiset multiset, Predicate predicate) {
        if (!(multiset instanceof Multisets$FilteredMultiset)) return new Multisets$FilteredMultiset(multiset, predicate);
        Multisets$FilteredMultiset multisets$FilteredMultiset = (Multisets$FilteredMultiset)multiset;
        Predicate predicate2 = Predicates.and(multisets$FilteredMultiset.predicate, predicate);
        return new Multisets$FilteredMultiset(multisets$FilteredMultiset.unfiltered, predicate2);
    }

    static int inferDistinctElements(Iterable iterable) {
        if (!(iterable instanceof Multiset)) return 11;
        return ((Multiset)iterable).elementSet().size();
    }

    @Beta
    public static Multiset union(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$1(multiset, multiset2);
    }

    public static Multiset intersection(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$2(multiset, multiset2);
    }

    @Beta
    public static Multiset sum(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$3(multiset, multiset2);
    }

    @Beta
    public static Multiset difference(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$4(multiset, multiset2);
    }

    public static boolean containsOccurrences(Multiset multiset, Multiset multiset2) {
        Multiset$Entry multiset$Entry;
        int n2;
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator iterator = multiset2.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while ((n2 = multiset.count((multiset$Entry = (Multiset$Entry)iterator.next()).getElement())) >= multiset$Entry.getCount());
        return false;
    }

    public static boolean retainOccurrences(Multiset multiset, Multiset multiset2) {
        return Multisets.retainOccurrencesImpl(multiset, multiset2);
    }

    private static boolean retainOccurrencesImpl(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator iterator = multiset.entrySet().iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            int n2 = multiset2.count(multiset$Entry.getElement());
            if (n2 == 0) {
                iterator.remove();
                bl2 = true;
                continue;
            }
            if (n2 >= multiset$Entry.getCount()) continue;
            multiset.setCount(multiset$Entry.getElement(), n2);
            bl2 = true;
        }
        return bl2;
    }

    public static boolean removeOccurrences(Multiset multiset, Iterable iterable) {
        if (iterable instanceof Multiset) {
            return Multisets.removeOccurrences(multiset, (Multiset)iterable);
        }
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(iterable);
        boolean bl2 = false;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            bl2 |= multiset.remove(t2);
        }
        return bl2;
    }

    public static boolean removeOccurrences(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        boolean bl2 = false;
        Iterator iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            int n2 = multiset2.count(multiset$Entry.getElement());
            if (n2 >= multiset$Entry.getCount()) {
                iterator.remove();
                bl2 = true;
                continue;
            }
            if (n2 <= 0) continue;
            multiset.remove(multiset$Entry.getElement(), n2);
            bl2 = true;
        }
        return bl2;
    }

    static boolean equalsImpl(Multiset multiset, @Nullable Object object) {
        Multiset$Entry multiset$Entry;
        if (object == multiset) {
            return true;
        }
        if (!(object instanceof Multiset)) return false;
        Multiset multiset2 = (Multiset)object;
        if (multiset.size() != multiset2.size()) return false;
        if (multiset.entrySet().size() != multiset2.entrySet().size()) {
            return false;
        }
        Iterator iterator = multiset2.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while (multiset.count((multiset$Entry = (Multiset$Entry)iterator.next()).getElement()) == multiset$Entry.getCount());
        return false;
    }

    static boolean addAllImpl(Multiset multiset, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (!(collection instanceof Multiset)) {
            Iterators.addAll(multiset, collection.iterator());
            return true;
        }
        Multiset multiset2 = Multisets.cast(collection);
        Iterator iterator = multiset2.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            multiset.add(multiset$Entry.getElement(), multiset$Entry.getCount());
        }
        return true;
    }

    static boolean removeAllImpl(Multiset multiset, Collection collection) {
        Collection collection2 = collection instanceof Multiset ? ((Multiset)collection).elementSet() : collection;
        return multiset.elementSet().removeAll(collection2);
    }

    static boolean retainAllImpl(Multiset multiset, Collection collection) {
        Preconditions.checkNotNull(collection);
        Collection collection2 = collection instanceof Multiset ? ((Multiset)collection).elementSet() : collection;
        return multiset.elementSet().retainAll(collection2);
    }

    static int setCountImpl(Multiset multiset, Object object, int n2) {
        CollectPreconditions.checkNonnegative(n2, "count");
        int n3 = multiset.count(object);
        int n4 = n2 - n3;
        if (n4 > 0) {
            multiset.add(object, n4);
            return n3;
        }
        if (n4 >= 0) return n3;
        multiset.remove(object, - n4);
        return n3;
    }

    static boolean setCountImpl(Multiset multiset, Object object, int n2, int n3) {
        CollectPreconditions.checkNonnegative(n2, "oldCount");
        CollectPreconditions.checkNonnegative(n3, "newCount");
        if (multiset.count(object) != n2) return false;
        multiset.setCount(object, n3);
        return true;
    }

    static Iterator iteratorImpl(Multiset multiset) {
        return new Multisets$MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    static int sizeImpl(Multiset multiset) {
        long l2 = 0;
        Iterator iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            l2 += (long)multiset$Entry.getCount();
        }
        return Ints.saturatedCast(l2);
    }

    static Multiset cast(Iterable iterable) {
        return (Multiset)iterable;
    }

    @Beta
    public static ImmutableMultiset copyHighestCountFirst(Multiset multiset) {
        ImmutableList immutableList = DECREASING_COUNT_ORDERING.immutableSortedCopy(multiset.entrySet());
        return ImmutableMultiset.copyFromEntries(immutableList);
    }
}

