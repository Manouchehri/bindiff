/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

class Lists$Partition
extends AbstractList {
    final List list;
    final int size;

    Lists$Partition(List list, int n2) {
        this.list = list;
        this.size = n2;
    }

    @Override
    public List get(int n2) {
        Preconditions.checkElementIndex(n2, this.size());
        int n3 = n2 * this.size;
        int n4 = Math.min(n3 + this.size, this.list.size());
        return this.list.subList(n3, n4);
    }

    @Override
    public int size() {
        return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}

