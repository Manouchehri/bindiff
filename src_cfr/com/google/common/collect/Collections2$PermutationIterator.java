/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Collections2$PermutationIterator
extends AbstractIterator {
    final List list;
    final int[] c;
    final int[] o;
    int j;

    Collections2$PermutationIterator(List list) {
        this.list = new ArrayList(list);
        int n2 = list.size();
        this.c = new int[n2];
        this.o = new int[n2];
        Arrays.fill(this.c, 0);
        Arrays.fill(this.o, 1);
        this.j = Integer.MAX_VALUE;
    }

    @Override
    protected List computeNext() {
        if (this.j <= 0) {
            return (List)this.endOfData();
        }
        ImmutableList immutableList = ImmutableList.copyOf(this.list);
        this.calculateNextPermutation();
        return immutableList;
    }

    void calculateNextPermutation() {
        this.j = this.list.size() - 1;
        int n2 = 0;
        if (this.j == -1) {
            return;
        }
        do {
            int n3;
            if ((n3 = this.c[this.j] + this.o[this.j]) < 0) {
                this.switchDirection();
                continue;
            }
            if (n3 != this.j + 1) {
                Collections.swap(this.list, this.j - this.c[this.j] + n2, this.j - n3 + n2);
                this.c[this.j] = n3;
                return;
            }
            if (this.j == 0) {
                return;
            }
            ++n2;
            this.switchDirection();
        } while (true);
    }

    void switchDirection() {
        this.o[this.j] = - this.o[this.j];
        --this.j;
    }
}

