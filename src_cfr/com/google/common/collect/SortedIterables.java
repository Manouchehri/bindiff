/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedIterable;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
final class SortedIterables {
    private SortedIterables() {
    }

    public static boolean hasSameComparator(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = SortedIterables.comparator((SortedSet)iterable);
            return comparator.equals(comparator2);
        }
        if (!(iterable instanceof SortedIterable)) return false;
        comparator2 = ((SortedIterable)iterable).comparator();
        return comparator.equals(comparator2);
    }

    public static Comparator comparator(SortedSet sortedSet) {
        Ordering ordering = sortedSet.comparator();
        if (ordering != null) return ordering;
        return Ordering.natural();
    }
}

