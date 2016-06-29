/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class Collections2$OrderedPermutationIterator
extends AbstractIterator {
    List nextPermutation;
    final Comparator comparator;

    Collections2$OrderedPermutationIterator(List list, Comparator comparator) {
        this.nextPermutation = Lists.newArrayList(list);
        this.comparator = comparator;
    }

    @Override
    protected List computeNext() {
        if (this.nextPermutation == null) {
            return (List)this.endOfData();
        }
        ImmutableList immutableList = ImmutableList.copyOf(this.nextPermutation);
        this.calculateNextPermutation();
        return immutableList;
    }

    void calculateNextPermutation() {
        int n2 = this.findNextJ();
        if (n2 == -1) {
            this.nextPermutation = null;
            return;
        }
        int n3 = this.findNextL(n2);
        Collections.swap(this.nextPermutation, n2, n3);
        int n4 = this.nextPermutation.size();
        Collections.reverse(this.nextPermutation.subList(n2 + 1, n4));
    }

    int findNextJ() {
        int n2 = this.nextPermutation.size() - 2;
        while (n2 >= 0) {
            if (this.comparator.compare(this.nextPermutation.get(n2), this.nextPermutation.get(n2 + 1)) < 0) {
                return n2;
            }
            --n2;
        }
        return -1;
    }

    int findNextL(int n2) {
        Object e2 = this.nextPermutation.get(n2);
        int n3 = this.nextPermutation.size() - 1;
        while (n3 > n2) {
            if (this.comparator.compare(e2, this.nextPermutation.get(n3)) < 0) {
                return n3;
            }
            --n3;
        }
        throw new AssertionError((Object)"this statement should be unreachable");
    }
}

