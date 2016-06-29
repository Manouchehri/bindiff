/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;

final class ImmutableRangeSet$ComplementRanges
extends ImmutableList {
    private final boolean positiveBoundedBelow;
    private final boolean positiveBoundedAbove;
    private final int size;
    final /* synthetic */ ImmutableRangeSet this$0;

    ImmutableRangeSet$ComplementRanges(ImmutableRangeSet immutableRangeSet) {
        this.this$0 = immutableRangeSet;
        this.positiveBoundedBelow = ((Range)ImmutableRangeSet.access$000(immutableRangeSet).get(0)).hasLowerBound();
        this.positiveBoundedAbove = ((Range)Iterables.getLast(ImmutableRangeSet.access$000(immutableRangeSet))).hasUpperBound();
        int n2 = ImmutableRangeSet.access$000(immutableRangeSet).size() - 1;
        if (this.positiveBoundedBelow) {
            ++n2;
        }
        if (this.positiveBoundedAbove) {
            ++n2;
        }
        this.size = n2;
    }

    @Override
    public int size() {
        return this.size;
    }

    public Range get(int n2) {
        Cut cut;
        Preconditions.checkElementIndex(n2, this.size);
        Cut cut2 = this.positiveBoundedBelow ? (n2 == 0 ? Cut.belowAll() : ((Range)ImmutableRangeSet.access$000((ImmutableRangeSet)this.this$0).get((int)(n2 - 1))).upperBound) : ((Range)ImmutableRangeSet.access$000((ImmutableRangeSet)this.this$0).get((int)n2)).upperBound;
        if (this.positiveBoundedAbove && n2 == this.size - 1) {
            cut = Cut.aboveAll();
            return Range.create(cut2, cut);
        }
        cut = ((Range)ImmutableRangeSet.access$000((ImmutableRangeSet)this.this$0).get((int)(n2 + (this.positiveBoundedBelow != false ? 0 : 1)))).lowerBound;
        return Range.create(cut2, cut);
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

