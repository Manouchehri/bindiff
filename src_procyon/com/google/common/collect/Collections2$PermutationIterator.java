package com.google.common.collect;

import java.util.*;

class Collections2$PermutationIterator extends AbstractIterator
{
    final List list;
    final int[] c;
    final int[] o;
    int j;
    
    Collections2$PermutationIterator(final List list) {
        this.list = new ArrayList(list);
        final int size = list.size();
        this.c = new int[size];
        this.o = new int[size];
        Arrays.fill(this.c, 0);
        Arrays.fill(this.o, 1);
        this.j = Integer.MAX_VALUE;
    }
    
    @Override
    protected List computeNext() {
        if (this.j <= 0) {
            return (List)this.endOfData();
        }
        final ImmutableList copy = ImmutableList.copyOf(this.list);
        this.calculateNextPermutation();
        return copy;
    }
    
    void calculateNextPermutation() {
        this.j = this.list.size() - 1;
        int n = 0;
        if (this.j == -1) {
            return;
        }
        while (true) {
            final int n2 = this.c[this.j] + this.o[this.j];
            if (n2 < 0) {
                this.switchDirection();
            }
            else {
                if (n2 != this.j + 1) {
                    Collections.swap(this.list, this.j - this.c[this.j] + n, this.j - n2 + n);
                    this.c[this.j] = n2;
                    break;
                }
                if (this.j == 0) {
                    break;
                }
                ++n;
                this.switchDirection();
            }
        }
    }
    
    void switchDirection() {
        this.o[this.j] = -this.o[this.j];
        --this.j;
    }
}
