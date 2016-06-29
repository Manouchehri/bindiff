package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.primitives.*;

@GwtCompatible
public final class Multisets
{
    private static final Ordering DECREASING_COUNT_ORDERING;
    
    public static Multiset unmodifiableMultiset(final Multiset multiset) {
        if (multiset instanceof Multisets$UnmodifiableMultiset || multiset instanceof ImmutableMultiset) {
            return multiset;
        }
        return new Multisets$UnmodifiableMultiset((Multiset)Preconditions.checkNotNull(multiset));
    }
    
    @Deprecated
    public static Multiset unmodifiableMultiset(final ImmutableMultiset immutableMultiset) {
        return (Multiset)Preconditions.checkNotNull(immutableMultiset);
    }
    
    @Beta
    public static SortedMultiset unmodifiableSortedMultiset(final SortedMultiset sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset)Preconditions.checkNotNull(sortedMultiset));
    }
    
    public static Multiset$Entry immutableEntry(@Nullable final Object o, final int n) {
        return new Multisets$ImmutableEntry(o, n);
    }
    
    @CheckReturnValue
    @Beta
    public static Multiset filter(final Multiset multiset, final Predicate predicate) {
        if (multiset instanceof Multisets$FilteredMultiset) {
            final Multisets$FilteredMultiset multisets$FilteredMultiset = (Multisets$FilteredMultiset)multiset;
            return new Multisets$FilteredMultiset(multisets$FilteredMultiset.unfiltered, Predicates.and(multisets$FilteredMultiset.predicate, predicate));
        }
        return new Multisets$FilteredMultiset(multiset, predicate);
    }
    
    static int inferDistinctElements(final Iterable iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset)iterable).elementSet().size();
        }
        return 11;
    }
    
    @Beta
    public static Multiset union(final Multiset multiset, final Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$1(multiset, multiset2);
    }
    
    public static Multiset intersection(final Multiset multiset, final Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$2(multiset, multiset2);
    }
    
    @Beta
    public static Multiset sum(final Multiset multiset, final Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$3(multiset, multiset2);
    }
    
    @Beta
    public static Multiset difference(final Multiset multiset, final Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        return new Multisets$4(multiset, multiset2);
    }
    
    public static boolean containsOccurrences(final Multiset multiset, final Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        for (final Multiset$Entry multiset$Entry : multiset2.entrySet()) {
            if (multiset.count(multiset$Entry.getElement()) < multiset$Entry.getCount()) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean retainOccurrences(final Multiset multiset, final Multiset multiset2) {
        return retainOccurrencesImpl(multiset, multiset2);
    }
    
    private static boolean retainOccurrencesImpl(final Multiset multiset, final Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        final Iterator iterator = multiset.entrySet().iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            final Multiset$Entry multiset$Entry = iterator.next();
            final int count = multiset2.count(multiset$Entry.getElement());
            if (count == 0) {
                iterator.remove();
                b = true;
            }
            else {
                if (count >= multiset$Entry.getCount()) {
                    continue;
                }
                multiset.setCount(multiset$Entry.getElement(), count);
                b = true;
            }
        }
        return b;
    }
    
    public static boolean removeOccurrences(final Multiset multiset, final Iterable iterable) {
        if (iterable instanceof Multiset) {
            return removeOccurrences(multiset, (Multiset)iterable);
        }
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(iterable);
        boolean b = false;
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            b |= multiset.remove(iterator.next());
        }
        return b;
    }
    
    public static boolean removeOccurrences(final Multiset multiset, final Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        boolean b = false;
        final Iterator iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            final Multiset$Entry multiset$Entry = iterator.next();
            final int count = multiset2.count(multiset$Entry.getElement());
            if (count >= multiset$Entry.getCount()) {
                iterator.remove();
                b = true;
            }
            else {
                if (count <= 0) {
                    continue;
                }
                multiset.remove(multiset$Entry.getElement(), count);
                b = true;
            }
        }
        return b;
    }
    
    static boolean equalsImpl(final Multiset multiset, @Nullable final Object o) {
        if (o == multiset) {
            return true;
        }
        if (!(o instanceof Multiset)) {
            return false;
        }
        final Multiset multiset2 = (Multiset)o;
        if (multiset.size() != multiset2.size() || multiset.entrySet().size() != multiset2.entrySet().size()) {
            return false;
        }
        for (final Multiset$Entry multiset$Entry : multiset2.entrySet()) {
            if (multiset.count(multiset$Entry.getElement()) != multiset$Entry.getCount()) {
                return false;
            }
        }
        return true;
    }
    
    static boolean addAllImpl(final Multiset multiset, final Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof Multiset) {
            for (final Multiset$Entry multiset$Entry : cast(collection).entrySet()) {
                multiset.add(multiset$Entry.getElement(), multiset$Entry.getCount());
            }
        }
        else {
            Iterators.addAll(multiset, collection.iterator());
        }
        return true;
    }
    
    static boolean removeAllImpl(final Multiset multiset, final Collection collection) {
        return multiset.elementSet().removeAll((collection instanceof Multiset) ? ((Multiset)collection).elementSet() : collection);
    }
    
    static boolean retainAllImpl(final Multiset multiset, final Collection collection) {
        Preconditions.checkNotNull(collection);
        return multiset.elementSet().retainAll((collection instanceof Multiset) ? ((Multiset)collection).elementSet() : collection);
    }
    
    static int setCountImpl(final Multiset multiset, final Object o, final int n) {
        CollectPreconditions.checkNonnegative(n, "count");
        final int count = multiset.count(o);
        final int n2 = n - count;
        if (n2 > 0) {
            multiset.add(o, n2);
        }
        else if (n2 < 0) {
            multiset.remove(o, -n2);
        }
        return count;
    }
    
    static boolean setCountImpl(final Multiset multiset, final Object o, final int n, final int n2) {
        CollectPreconditions.checkNonnegative(n, "oldCount");
        CollectPreconditions.checkNonnegative(n2, "newCount");
        if (multiset.count(o) == n) {
            multiset.setCount(o, n2);
            return true;
        }
        return false;
    }
    
    static Iterator iteratorImpl(final Multiset multiset) {
        return new Multisets$MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }
    
    static int sizeImpl(final Multiset multiset) {
        long n = 0L;
        final Iterator<Multiset$Entry> iterator = multiset.entrySet().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().getCount();
        }
        return Ints.saturatedCast(n);
    }
    
    static Multiset cast(final Iterable iterable) {
        return (Multiset)iterable;
    }
    
    @Beta
    public static ImmutableMultiset copyHighestCountFirst(final Multiset multiset) {
        return ImmutableMultiset.copyFromEntries(Multisets.DECREASING_COUNT_ORDERING.immutableSortedCopy(multiset.entrySet()));
    }
    
    static {
        DECREASING_COUNT_ORDERING = new Multisets$5();
    }
}
