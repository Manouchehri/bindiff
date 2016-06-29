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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedAsList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.SortedIterables;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1, emulated=1)
final class RegularImmutableSortedSet
extends ImmutableSortedSet {
    private final transient ImmutableList elements;

    RegularImmutableSortedSet(ImmutableList immutableList, Comparator comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.elements.iterator();
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        try {
            if (object == null) return false;
            if (this.unsafeBinarySearch(object) < 0) return false;
            return true;
        }
        catch (ClassCastException var2_2) {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset)collection).elementSet();
        }
        if (!SortedIterables.hasSameComparator(this.comparator(), collection)) return super.containsAll(collection);
        if (collection.size() <= 1) {
            return super.containsAll(collection);
        }
        PeekingIterator peekingIterator = Iterators.peekingIterator(this.iterator());
        Iterator iterator = collection.iterator();
        Object e2 = iterator.next();
        try {
            while (peekingIterator.hasNext()) {
                int n2 = this.unsafeCompare(peekingIterator.peek(), e2);
                if (n2 < 0) {
                    peekingIterator.next();
                    continue;
                }
                if (n2 == 0) {
                    if (!iterator.hasNext()) {
                        return true;
                    }
                    e2 = iterator.next();
                    continue;
                }
                if (n2 > 0) return false;
            }
            return false;
        }
        catch (NullPointerException var5_6) {
            return false;
        }
        catch (ClassCastException var5_7) {
            return false;
        }
    }

    private int unsafeBinarySearch(Object object) {
        return Collections.binarySearch(this.elements, object, this.unsafeComparator());
    }

    @Override
    boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override
    int copyIntoArray(Object[] arrobject, int n2) {
        return this.elements.copyIntoArray(arrobject, n2);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set set = (Set)object;
        if (this.size() != set.size()) {
            return false;
        }
        if (this.isEmpty()) {
            return true;
        }
        if (!SortedIterables.hasSameComparator(this.comparator, set)) return this.containsAll(set);
        Iterator iterator = set.iterator();
        try {
            Object e2;
            Object e3;
            UnmodifiableIterator unmodifiableIterator = this.iterator();
            do {
                if (!unmodifiableIterator.hasNext()) return true;
                e3 = unmodifiableIterator.next();
                e2 = iterator.next();
                if (e2 == null) return false;
            } while (this.unsafeCompare(e3, e2) == 0);
            return false;
        }
        catch (ClassCastException var4_5) {
            return false;
        }
        catch (NoSuchElementException var4_6) {
            return false;
        }
    }

    @Override
    public Object first() {
        if (!this.isEmpty()) return this.elements.get(0);
        throw new NoSuchElementException();
    }

    @Override
    public Object last() {
        if (!this.isEmpty()) return this.elements.get(this.size() - 1);
        throw new NoSuchElementException();
    }

    @Override
    public Object lower(Object object) {
        int n2 = this.headIndex(object, false) - 1;
        if (n2 == -1) {
            return null;
        }
        Object v0 = this.elements.get(n2);
        return v0;
    }

    @Override
    public Object floor(Object object) {
        int n2 = this.headIndex(object, true) - 1;
        if (n2 == -1) {
            return null;
        }
        Object v0 = this.elements.get(n2);
        return v0;
    }

    @Override
    public Object ceiling(Object object) {
        int n2 = this.tailIndex(object, true);
        if (n2 == this.size()) {
            return null;
        }
        Object v0 = this.elements.get(n2);
        return v0;
    }

    @Override
    public Object higher(Object object) {
        int n2 = this.tailIndex(object, false);
        if (n2 == this.size()) {
            return null;
        }
        Object v0 = this.elements.get(n2);
        return v0;
    }

    @Override
    ImmutableSortedSet headSetImpl(Object object, boolean bl2) {
        return this.getSubSet(0, this.headIndex(object, bl2));
    }

    int headIndex(Object object, boolean bl2) {
        SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior;
        if (bl2) {
            sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.FIRST_AFTER;
            return SortedLists.binarySearch((List)this.elements, Preconditions.checkNotNull(object), this.comparator(), sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        }
        sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.FIRST_PRESENT;
        return SortedLists.binarySearch((List)this.elements, Preconditions.checkNotNull(object), this.comparator(), sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
    }

    @Override
    ImmutableSortedSet subSetImpl(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.tailSetImpl(object, bl2).headSetImpl(object2, bl3);
    }

    @Override
    ImmutableSortedSet tailSetImpl(Object object, boolean bl2) {
        return this.getSubSet(this.tailIndex(object, bl2), this.size());
    }

    int tailIndex(Object object, boolean bl2) {
        SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior;
        if (bl2) {
            sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.FIRST_PRESENT;
            return SortedLists.binarySearch((List)this.elements, Preconditions.checkNotNull(object), this.comparator(), sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        }
        sortedLists$KeyPresentBehavior = SortedLists$KeyPresentBehavior.FIRST_AFTER;
        return SortedLists.binarySearch((List)this.elements, Preconditions.checkNotNull(object), this.comparator(), sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
    }

    Comparator unsafeComparator() {
        return this.comparator;
    }

    RegularImmutableSortedSet getSubSet(int n2, int n3) {
        if (n2 == 0 && n3 == this.size()) {
            return this;
        }
        if (n2 >= n3) return RegularImmutableSortedSet.emptySet(this.comparator);
        return new RegularImmutableSortedSet(this.elements.subList(n2, n3), this.comparator);
    }

    @Override
    int indexOf(@Nullable Object object) {
        int n2;
        if (object == null) {
            return -1;
        }
        try {
            n2 = SortedLists.binarySearch((List)this.elements, object, this.unsafeComparator(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
        }
        catch (ClassCastException var3_3) {
            return -1;
        }
        if (n2 < 0) return -1;
        int n3 = n2;
        return n3;
    }

    @Override
    ImmutableList createAsList() {
        ImmutableList immutableList;
        if (this.size() <= 1) {
            immutableList = this.elements;
            return immutableList;
        }
        immutableList = new ImmutableSortedAsList(this, this.elements);
        return immutableList;
    }

    @Override
    ImmutableSortedSet createDescendingSet() {
        RegularImmutableSortedSet regularImmutableSortedSet;
        Ordering ordering = Ordering.from(this.comparator).reverse();
        if (this.isEmpty()) {
            regularImmutableSortedSet = RegularImmutableSortedSet.emptySet(ordering);
            return regularImmutableSortedSet;
        }
        regularImmutableSortedSet = new RegularImmutableSortedSet(this.elements.reverse(), ordering);
        return regularImmutableSortedSet;
    }
}

