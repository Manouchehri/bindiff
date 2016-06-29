package com.google.common.collect;

import com.google.common.math.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

final class Collections2$OrderedPermutationCollection extends AbstractCollection
{
    final ImmutableList inputList;
    final Comparator comparator;
    final int size;
    
    Collections2$OrderedPermutationCollection(final Iterable iterable, final Comparator comparator) {
        this.inputList = Ordering.from(comparator).immutableSortedCopy(iterable);
        this.comparator = comparator;
        this.size = calculateSize(this.inputList, comparator);
    }
    
    private static int calculateSize(final List list, final Comparator comparator) {
        long n = 1L;
        int i;
        int n2;
        for (i = 1, n2 = 1; i < list.size(); ++i, ++n2) {
            if (comparator.compare(list.get(i - 1), list.get(i)) < 0) {
                n *= LongMath.binomial(i, n2);
                n2 = 0;
                if (!isPositiveInt(n)) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        final long n3 = n * LongMath.binomial(i, n2);
        if (!isPositiveInt(n3)) {
            return Integer.MAX_VALUE;
        }
        return (int)n3;
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
    public boolean contains(@Nullable final Object o) {
        return o instanceof List && isPermutation(this.inputList, (List)o);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.inputList);
        return new StringBuilder(30 + String.valueOf(value).length()).append("orderedPermutationCollection(").append(value).append(")").toString();
    }
}
