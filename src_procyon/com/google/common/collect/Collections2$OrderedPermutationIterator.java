package com.google.common.collect;

import java.util.*;

final class Collections2$OrderedPermutationIterator extends AbstractIterator
{
    List nextPermutation;
    final Comparator comparator;
    
    Collections2$OrderedPermutationIterator(final List list, final Comparator comparator) {
        this.nextPermutation = Lists.newArrayList(list);
        this.comparator = comparator;
    }
    
    @Override
    protected List computeNext() {
        if (this.nextPermutation == null) {
            return (List)this.endOfData();
        }
        final ImmutableList copy = ImmutableList.copyOf(this.nextPermutation);
        this.calculateNextPermutation();
        return copy;
    }
    
    void calculateNextPermutation() {
        final int nextJ = this.findNextJ();
        if (nextJ == -1) {
            this.nextPermutation = null;
            return;
        }
        Collections.swap(this.nextPermutation, nextJ, this.findNextL(nextJ));
        Collections.reverse(this.nextPermutation.subList(nextJ + 1, this.nextPermutation.size()));
    }
    
    int findNextJ() {
        for (int i = this.nextPermutation.size() - 2; i >= 0; --i) {
            if (this.comparator.compare(this.nextPermutation.get(i), this.nextPermutation.get(i + 1)) < 0) {
                return i;
            }
        }
        return -1;
    }
    
    int findNextL(final int n) {
        final Object value = this.nextPermutation.get(n);
        for (int i = this.nextPermutation.size() - 1; i > n; --i) {
            if (this.comparator.compare(value, this.nextPermutation.get(i)) < 0) {
                return i;
            }
        }
        throw new AssertionError((Object)"this statement should be unreachable");
    }
}
