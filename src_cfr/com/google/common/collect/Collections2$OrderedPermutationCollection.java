/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Collections2$OrderedPermutationIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.math.LongMath;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

final class Collections2$OrderedPermutationCollection
extends AbstractCollection {
    final ImmutableList inputList;
    final Comparator comparator;
    final int size;

    Collections2$OrderedPermutationCollection(Iterable iterable, Comparator comparator) {
        this.inputList = Ordering.from(comparator).immutableSortedCopy(iterable);
        this.comparator = comparator;
        this.size = Collections2$OrderedPermutationCollection.calculateSize(this.inputList, comparator);
    }

    private static int calculateSize(List list, Comparator comparator) {
        long l2 = 1;
        int n2 = 1;
        int n3 = 1;
        do {
            if (n2 >= list.size()) {
                if (Collections2.access$000(l2 *= LongMath.binomial(n2, n3))) return (int)l2;
                return Integer.MAX_VALUE;
            }
            int n4 = comparator.compare(list.get(n2 - 1), list.get(n2));
            if (n4 < 0 && !Collections2.access$000(l2 *= LongMath.binomial(n2, n3 = 0))) {
                return Integer.MAX_VALUE;
            }
            ++n2;
            ++n3;
        } while (true);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Collections2$OrderedPermutationIterator(this.inputList, this.comparator);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof List)) return false;
        List list = (List)object;
        return Collections2.access$100(this.inputList, list);
    }

    @Override
    public String toString() {
        String string = String.valueOf(this.inputList);
        return new StringBuilder(30 + String.valueOf(string).length()).append("orderedPermutationCollection(").append(string).append(")").toString();
    }
}

