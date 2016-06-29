/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.DescendingImmutableSortedSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet$Builder;
import com.google.common.collect.ImmutableSortedSet$SerializedForm;
import com.google.common.collect.ImmutableSortedSetFauxverideShim;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedIterable;
import com.google.common.collect.SortedIterables;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
public abstract class ImmutableSortedSet
extends ImmutableSortedSetFauxverideShim
implements SortedIterable,
NavigableSet {
    private static final Comparator NATURAL_ORDER = Ordering.natural();
    private static final RegularImmutableSortedSet NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), NATURAL_ORDER);
    final transient Comparator comparator;
    @LazyInit
    @GwtIncompatible(value="NavigableSet")
    transient ImmutableSortedSet descendingSet;

    static RegularImmutableSortedSet emptySet(Comparator comparator) {
        if (!NATURAL_ORDER.equals(comparator)) return new RegularImmutableSortedSet(ImmutableList.of(), comparator);
        return NATURAL_EMPTY_SET;
    }

    public static ImmutableSortedSet of() {
        return NATURAL_EMPTY_SET;
    }

    public static ImmutableSortedSet of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.of(comparable), Ordering.natural());
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        return ImmutableSortedSet.construct(Ordering.natural(), 2, comparable, comparable2);
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return ImmutableSortedSet.construct(Ordering.natural(), 3, comparable, comparable2, comparable3);
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return ImmutableSortedSet.construct(Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return ImmutableSortedSet.construct(Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    public static /* varargs */ ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable ... arrcomparable) {
        Object[] arrobject = new Comparable[6 + arrcomparable.length];
        arrobject[0] = comparable;
        arrobject[1] = comparable2;
        arrobject[2] = comparable3;
        arrobject[3] = comparable4;
        arrobject[4] = comparable5;
        arrobject[5] = comparable6;
        System.arraycopy(arrcomparable, 0, arrobject, 6, arrcomparable.length);
        return ImmutableSortedSet.construct(Ordering.natural(), arrobject.length, arrobject);
    }

    public static ImmutableSortedSet copyOf(Comparable[] arrcomparable) {
        return ImmutableSortedSet.construct(Ordering.natural(), arrcomparable.length, (Object[])arrcomparable.clone());
    }

    public static ImmutableSortedSet copyOf(Iterable iterable) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedSet.copyOf((Comparator)ordering, iterable);
    }

    public static ImmutableSortedSet copyOf(Collection collection) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedSet.copyOf((Comparator)ordering, collection);
    }

    public static ImmutableSortedSet copyOf(Iterator iterator) {
        Ordering ordering = Ordering.natural();
        return ImmutableSortedSet.copyOf((Comparator)ordering, iterator);
    }

    public static ImmutableSortedSet copyOf(Comparator comparator, Iterator iterator) {
        return new ImmutableSortedSet$Builder(comparator).addAll(iterator).build();
    }

    public static ImmutableSortedSet copyOf(Comparator comparator, Iterable iterable) {
        Object object;
        Preconditions.checkNotNull(comparator);
        boolean bl2 = SortedIterables.hasSameComparator(comparator, iterable);
        if (bl2 && iterable instanceof ImmutableSortedSet && !(object = (ImmutableSortedSet)iterable).isPartialView()) {
            return object;
        }
        object = Iterables.toArray(iterable);
        return ImmutableSortedSet.construct(comparator, object.length, (Object[])object);
    }

    public static ImmutableSortedSet copyOf(Comparator comparator, Collection collection) {
        return ImmutableSortedSet.copyOf(comparator, (Iterable)collection);
    }

    public static ImmutableSortedSet copyOfSorted(SortedSet sortedSet) {
        Comparator comparator = SortedIterables.comparator(sortedSet);
        ImmutableList immutableList = ImmutableList.copyOf(sortedSet);
        if (!immutableList.isEmpty()) return new RegularImmutableSortedSet(immutableList, comparator);
        return ImmutableSortedSet.emptySet(comparator);
    }

    static /* varargs */ ImmutableSortedSet construct(Comparator comparator, int n2, Object ... arrobject) {
        if (n2 == 0) {
            return ImmutableSortedSet.emptySet(comparator);
        }
        ObjectArrays.checkElementsNotNull(arrobject, n2);
        Arrays.sort(arrobject, 0, n2, comparator);
        int n3 = 1;
        int n4 = 1;
        do {
            if (n4 >= n2) {
                Arrays.fill(arrobject, n3, n2, null);
                return new RegularImmutableSortedSet(ImmutableList.asImmutableList(arrobject, n3), comparator);
            }
            Object object = arrobject[n4];
            Object object2 = arrobject[n3 - 1];
            if (comparator.compare(object, object2) != 0) {
                arrobject[n3++] = object;
            }
            ++n4;
        } while (true);
    }

    public static ImmutableSortedSet$Builder orderedBy(Comparator comparator) {
        return new ImmutableSortedSet$Builder(comparator);
    }

    public static ImmutableSortedSet$Builder reverseOrder() {
        return new ImmutableSortedSet$Builder(Ordering.natural().reverse());
    }

    public static ImmutableSortedSet$Builder naturalOrder() {
        return new ImmutableSortedSet$Builder(Ordering.natural());
    }

    int unsafeCompare(Object object, Object object2) {
        return ImmutableSortedSet.unsafeCompare(this.comparator, object, object2);
    }

    static int unsafeCompare(Comparator comparator, Object object, Object object2) {
        Comparator comparator2 = comparator;
        return comparator2.compare(object, object2);
    }

    ImmutableSortedSet(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public Comparator comparator() {
        return this.comparator;
    }

    @Override
    public abstract UnmodifiableIterator iterator();

    public ImmutableSortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet headSet(Object object, boolean bl2) {
        return this.headSetImpl(Preconditions.checkNotNull(object), bl2);
    }

    public ImmutableSortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Preconditions.checkArgument(this.comparator.compare(object, object2) <= 0);
        return this.subSetImpl(object, bl2, object2, bl3);
    }

    public ImmutableSortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }

    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet tailSet(Object object, boolean bl2) {
        return this.tailSetImpl(Preconditions.checkNotNull(object), bl2);
    }

    abstract ImmutableSortedSet headSetImpl(Object var1, boolean var2);

    abstract ImmutableSortedSet subSetImpl(Object var1, boolean var2, Object var3, boolean var4);

    abstract ImmutableSortedSet tailSetImpl(Object var1, boolean var2);

    @GwtIncompatible(value="NavigableSet")
    public Object lower(Object object) {
        return Iterators.getNext(this.headSet(object, false).descendingIterator(), null);
    }

    @GwtIncompatible(value="NavigableSet")
    public Object floor(Object object) {
        return Iterators.getNext(this.headSet(object, true).descendingIterator(), null);
    }

    @GwtIncompatible(value="NavigableSet")
    public Object ceiling(Object object) {
        return Iterables.getFirst(this.tailSet(object, true), null);
    }

    @GwtIncompatible(value="NavigableSet")
    public Object higher(Object object) {
        return Iterables.getFirst(this.tailSet(object, false), null);
    }

    @Override
    public Object first() {
        return this.iterator().next();
    }

    @Override
    public Object last() {
        return this.descendingIterator().next();
    }

    @Deprecated
    @GwtIncompatible(value="NavigableSet")
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    @GwtIncompatible(value="NavigableSet")
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible(value="NavigableSet")
    public ImmutableSortedSet descendingSet() {
        ImmutableSortedSet immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) return immutableSortedSet;
        immutableSortedSet = this.descendingSet = this.createDescendingSet();
        immutableSortedSet.descendingSet = this;
        return immutableSortedSet;
    }

    @GwtIncompatible(value="NavigableSet")
    ImmutableSortedSet createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @GwtIncompatible(value="NavigableSet")
    public abstract UnmodifiableIterator descendingIterator();

    abstract int indexOf(@Nullable Object var1);

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override
    Object writeReplace() {
        return new ImmutableSortedSet$SerializedForm(this.comparator, this.toArray());
    }
}

