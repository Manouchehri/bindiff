/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;

class ImmutableRangeSet$1
extends ImmutableList {
    final /* synthetic */ int val$length;
    final /* synthetic */ int val$fromIndex;
    final /* synthetic */ Range val$range;
    final /* synthetic */ ImmutableRangeSet this$0;

    ImmutableRangeSet$1(ImmutableRangeSet immutableRangeSet, int n2, int n3, Range range) {
        this.this$0 = immutableRangeSet;
        this.val$length = n2;
        this.val$fromIndex = n3;
        this.val$range = range;
    }

    @Override
    public int size() {
        return this.val$length;
    }

    public Range get(int n2) {
        Preconditions.checkElementIndex(n2, this.val$length);
        if (n2 == 0) return ((Range)ImmutableRangeSet.access$000(this.this$0).get(n2 + this.val$fromIndex)).intersection(this.val$range);
        if (n2 != this.val$length - 1) return (Range)ImmutableRangeSet.access$000(this.this$0).get(n2 + this.val$fromIndex);
        return ((Range)ImmutableRangeSet.access$000(this.this$0).get(n2 + this.val$fromIndex)).intersection(this.val$range);
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

