package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.primitives.*;
import java.io.*;

@Beta
@GwtIncompatible("hasn't been tested yet")
public abstract class ImmutableSortedMultiset extends ImmutableSortedMultisetFauxverideShim implements SortedMultiset
{
    private static final Comparator NATURAL_ORDER;
    private static final ImmutableSortedMultiset NATURAL_EMPTY_MULTISET;
    @LazyInit
    transient ImmutableSortedMultiset descendingMultiset;
    
    public static ImmutableSortedMultiset of() {
        return ImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }
    
    public static ImmutableSortedMultiset of(final Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet)ImmutableSortedSet.of(comparable), new long[] { 0L, 1L }, 0, 1);
    }
    
    public static ImmutableSortedMultiset of(final Comparable comparable, final Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }
    
    public static ImmutableSortedMultiset of(final Comparable comparable, final Comparable comparable2, final Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }
    
    public static ImmutableSortedMultiset of(final Comparable comparable, final Comparable comparable2, final Comparable comparable3, final Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }
    
    public static ImmutableSortedMultiset of(final Comparable comparable, final Comparable comparable2, final Comparable comparable3, final Comparable comparable4, final Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }
    
    public static ImmutableSortedMultiset of(final Comparable comparable, final Comparable comparable2, final Comparable comparable3, final Comparable comparable4, final Comparable comparable5, final Comparable comparable6, final Comparable... array) {
        final ArrayList arrayListWithCapacity = Lists.newArrayListWithCapacity(array.length + 6);
        Collections.addAll(arrayListWithCapacity, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayListWithCapacity, (Comparable[])array);
        return copyOf(Ordering.natural(), arrayListWithCapacity);
    }
    
    public static ImmutableSortedMultiset copyOf(final Comparable[] array) {
        return copyOf(Ordering.natural(), Arrays.asList((Comparable[])array));
    }
    
    public static ImmutableSortedMultiset copyOf(final Iterable iterable) {
        return copyOf(Ordering.natural(), iterable);
    }
    
    public static ImmutableSortedMultiset copyOf(final Iterator iterator) {
        return copyOf(Ordering.natural(), iterator);
    }
    
    public static ImmutableSortedMultiset copyOf(final Comparator comparator, final Iterator iterator) {
        Preconditions.checkNotNull(comparator);
        return new ImmutableSortedMultiset$Builder(comparator).addAll(iterator).build();
    }
    
    public static ImmutableSortedMultiset copyOf(final Comparator comparator, final Iterable iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            final ImmutableSortedMultiset immutableSortedMultiset = (ImmutableSortedMultiset)iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                if (immutableSortedMultiset.isPartialView()) {
                    return copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList());
                }
                return immutableSortedMultiset;
            }
        }
        final ArrayList arrayList = Lists.newArrayList(iterable);
        final TreeMultiset create = TreeMultiset.create((Comparator)Preconditions.checkNotNull(comparator));
        Iterables.addAll(create, arrayList);
        return copyOfSortedEntries(comparator, create.entrySet());
    }
    
    public static ImmutableSortedMultiset copyOfSorted(final SortedMultiset sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }
    
    private static ImmutableSortedMultiset copyOfSortedEntries(final Comparator comparator, final Collection collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(collection.size());
        final long[] array = new long[collection.size() + 1];
        int n = 0;
        for (final Multiset$Entry multiset$Entry : collection) {
            immutableList$Builder.add(multiset$Entry.getElement());
            array[n + 1] = array[n] + multiset$Entry.getCount();
            ++n;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(immutableList$Builder.build(), comparator), array, 0, collection.size());
    }
    
    static ImmutableSortedMultiset emptyMultiset(final Comparator comparator) {
        if (ImmutableSortedMultiset.NATURAL_ORDER.equals(comparator)) {
            return ImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }
    
    @Override
    public final Comparator comparator() {
        return this.elementSet().comparator();
    }
    
    @Override
    public abstract ImmutableSortedSet elementSet();
    
    @Override
    public ImmutableSortedMultiset descendingMultiset() {
        final ImmutableSortedMultiset descendingMultiset = this.descendingMultiset;
        if (descendingMultiset == null) {
            return this.descendingMultiset = (this.isEmpty() ? emptyMultiset(Ordering.from(this.comparator()).reverse()) : new DescendingImmutableSortedMultiset(this));
        }
        return descendingMultiset;
    }
    
    @Deprecated
    @Override
    public final Multiset$Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Deprecated
    @Override
    public final Multiset$Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public abstract ImmutableSortedMultiset headMultiset(final Object p0, final BoundType p1);
    
    @Override
    public ImmutableSortedMultiset subMultiset(final Object o, final BoundType boundType, final Object o2, final BoundType boundType2) {
        Preconditions.checkArgument(this.comparator().compare(o, o2) <= 0, "Expected lowerBound <= upperBound but %s > %s", o, o2);
        return this.tailMultiset(o, boundType).headMultiset(o2, boundType2);
    }
    
    @Override
    public abstract ImmutableSortedMultiset tailMultiset(final Object p0, final BoundType p1);
    
    public static ImmutableSortedMultiset$Builder orderedBy(final Comparator comparator) {
        return new ImmutableSortedMultiset$Builder(comparator);
    }
    
    public static ImmutableSortedMultiset$Builder reverseOrder() {
        return new ImmutableSortedMultiset$Builder(Ordering.natural().reverse());
    }
    
    public static ImmutableSortedMultiset$Builder naturalOrder() {
        return new ImmutableSortedMultiset$Builder(Ordering.natural());
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableSortedMultiset$SerializedForm(this);
    }
    
    static {
        NATURAL_ORDER = Ordering.natural();
        NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(ImmutableSortedMultiset.NATURAL_ORDER);
    }
}
