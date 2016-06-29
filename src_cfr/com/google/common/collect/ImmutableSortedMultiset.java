/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.DescendingImmutableSortedMultiset;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMultiset$Builder;
import com.google.common.collect.ImmutableSortedMultiset$SerializedForm;
import com.google.common.collect.ImmutableSortedMultisetFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedMultiset;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@Beta
@GwtIncompatible(value="hasn't been tested yet")
public abstract class ImmutableSortedMultiset
extends ImmutableSortedMultisetFauxverideShim
implements SortedMultiset {
    private static final Comparator NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedMultiset NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(NATURAL_ORDER);
    @LazyInit
    transient ImmutableSortedMultiset descendingMultiset;

    public static ImmutableSortedMultiset of() {
        return NATURAL_EMPTY_MULTISET;
    }

    public static ImmutableSortedMultiset of(Comparable comparable) {
        RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet)ImmutableSortedSet.of(comparable);
        long[] arrl = new long[]{0, 1};
        return new RegularImmutableSortedMultiset(regularImmutableSortedSet, arrl, 0, 1);
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    public static /* varargs */ ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable ... arrcomparable) {
        int n2 = arrcomparable.length + 6;
        ArrayList arrayList = Lists.newArrayListWithCapacity(n2);
        Collections.addAll(arrayList, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayList, arrcomparable);
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), arrayList);
    }

    public static ImmutableSortedMultiset copyOf(Comparable[] arrcomparable) {
        return ImmutableSortedMultiset.copyOf((Comparator)Ordering.natural(), Arrays.asList(arrcomparable));
    }

    public static ImmutableSortedMultiset copyOf(Iterable iterable) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedMultiset.copyOf((Comparator)ordering, iterable);
    }

    public static ImmutableSortedMultiset copyOf(Iterator iterator) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedMultiset.copyOf((Comparator)ordering, iterator);
    }

    public static ImmutableSortedMultiset copyOf(Comparator comparator, Iterator iterator) {
        Preconditions.checkNotNull(comparator);
        return new ImmutableSortedMultiset$Builder(comparator).addAll(iterator).build();
    }

    public static ImmutableSortedMultiset copyOf(Comparator comparator, Iterable iterable) {
        ImmutableCollection immutableCollection;
        if (iterable instanceof ImmutableSortedMultiset && comparator.equals((immutableCollection = (ImmutableSortedMultiset)iterable).comparator())) {
            if (!immutableCollection.isPartialView()) return immutableCollection;
            return ImmutableSortedMultiset.copyOfSortedEntries(comparator, immutableCollection.entrySet().asList());
        }
        iterable = Lists.newArrayList(iterable);
        immutableCollection = TreeMultiset.create((Comparator)Preconditions.checkNotNull(comparator));
        Iterables.addAll(immutableCollection, iterable);
        return ImmutableSortedMultiset.copyOfSortedEntries(comparator, immutableCollection.entrySet());
    }

    public static ImmutableSortedMultiset copyOfSorted(SortedMultiset sortedMultiset) {
        return ImmutableSortedMultiset.copyOfSortedEntries(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    private static ImmutableSortedMultiset copyOfSortedEntries(Comparator comparator, Collection collection) {
        if (collection.isEmpty()) {
            return ImmutableSortedMultiset.emptyMultiset(comparator);
        }
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(collection.size());
        long[] arrl = new long[collection.size() + 1];
        int n2 = 0;
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
            immutableList$Builder.add(multiset$Entry.getElement());
            arrl[n2 + 1] = arrl[n2] + (long)multiset$Entry.getCount();
            ++n2;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(immutableList$Builder.build(), comparator), arrl, 0, collection.size());
    }

    static ImmutableSortedMultiset emptyMultiset(Comparator comparator) {
        if (!NATURAL_ORDER.equals(comparator)) return new RegularImmutableSortedMultiset(comparator);
        return NATURAL_EMPTY_MULTISET;
    }

    ImmutableSortedMultiset() {
    }

    @Override
    public final Comparator comparator() {
        return this.elementSet().comparator();
    }

    @Override
    public abstract ImmutableSortedSet elementSet();

    @Override
    public ImmutableSortedMultiset descendingMultiset() {
        ImmutableSortedMultiset immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset != null) return immutableSortedMultiset;
        this.descendingMultiset = this.isEmpty() ? ImmutableSortedMultiset.emptyMultiset(Ordering.from(this.comparator()).reverse()) : new DescendingImmutableSortedMultiset(this);
        return this.descendingMultiset;
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
    public abstract ImmutableSortedMultiset headMultiset(Object var1, BoundType var2);

    @Override
    public ImmutableSortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        Preconditions.checkArgument(this.comparator().compare(object, object2) <= 0, "Expected lowerBound <= upperBound but %s > %s", object, object2);
        return this.tailMultiset(object, boundType).headMultiset(object2, boundType2);
    }

    @Override
    public abstract ImmutableSortedMultiset tailMultiset(Object var1, BoundType var2);

    public static ImmutableSortedMultiset$Builder orderedBy(Comparator comparator) {
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
}

