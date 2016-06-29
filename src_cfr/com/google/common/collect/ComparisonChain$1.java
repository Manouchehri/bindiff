/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;
import javax.annotation.Nullable;

final class ComparisonChain$1
extends ComparisonChain {
    ComparisonChain$1() {
        super(null);
    }

    @Override
    public ComparisonChain compare(Comparable comparable, Comparable comparable2) {
        return this.classify(comparable.compareTo(comparable2));
    }

    @Override
    public ComparisonChain compare(@Nullable Object object, @Nullable Object object2, Comparator comparator) {
        return this.classify(comparator.compare(object, object2));
    }

    @Override
    public ComparisonChain compare(int n2, int n3) {
        return this.classify(Ints.compare(n2, n3));
    }

    @Override
    public ComparisonChain compare(long l2, long l3) {
        return this.classify(Longs.compare(l2, l3));
    }

    @Override
    public ComparisonChain compare(float f2, float f3) {
        return this.classify(Float.compare(f2, f3));
    }

    @Override
    public ComparisonChain compare(double d2, double d3) {
        return this.classify(Double.compare(d2, d3));
    }

    @Override
    public ComparisonChain compareTrueFirst(boolean bl2, boolean bl3) {
        return this.classify(Booleans.compare(bl3, bl2));
    }

    @Override
    public ComparisonChain compareFalseFirst(boolean bl2, boolean bl3) {
        return this.classify(Booleans.compare(bl2, bl3));
    }

    ComparisonChain classify(int n2) {
        ComparisonChain comparisonChain;
        if (n2 < 0) {
            comparisonChain = ComparisonChain.access$100();
            return comparisonChain;
        }
        if (n2 > 0) {
            comparisonChain = ComparisonChain.access$200();
            return comparisonChain;
        }
        comparisonChain = ComparisonChain.access$300();
        return comparisonChain;
    }

    @Override
    public int result() {
        return 0;
    }
}

