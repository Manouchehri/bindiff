/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ComparisonChain$1;
import java.util.Comparator;
import javax.annotation.Nullable;

final class ComparisonChain$InactiveComparisonChain
extends ComparisonChain {
    final int result;

    ComparisonChain$InactiveComparisonChain(int n2) {
        super(null);
        this.result = n2;
    }

    @Override
    public ComparisonChain compare(@Nullable Comparable comparable, @Nullable Comparable comparable2) {
        return this;
    }

    @Override
    public ComparisonChain compare(@Nullable Object object, @Nullable Object object2, @Nullable Comparator comparator) {
        return this;
    }

    @Override
    public ComparisonChain compare(int n2, int n3) {
        return this;
    }

    @Override
    public ComparisonChain compare(long l2, long l3) {
        return this;
    }

    @Override
    public ComparisonChain compare(float f2, float f3) {
        return this;
    }

    @Override
    public ComparisonChain compare(double d2, double d3) {
        return this;
    }

    @Override
    public ComparisonChain compareTrueFirst(boolean bl2, boolean bl3) {
        return this;
    }

    @Override
    public ComparisonChain compareFalseFirst(boolean bl2, boolean bl3) {
        return this;
    }

    @Override
    public int result() {
        return this.result;
    }
}

