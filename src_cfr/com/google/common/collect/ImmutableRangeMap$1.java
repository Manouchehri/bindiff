/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;

class ImmutableRangeMap$1
extends ImmutableList {
    final /* synthetic */ int val$len;
    final /* synthetic */ int val$off;
    final /* synthetic */ Range val$range;
    final /* synthetic */ ImmutableRangeMap this$0;

    ImmutableRangeMap$1(ImmutableRangeMap immutableRangeMap, int n2, int n3, Range range) {
        this.this$0 = immutableRangeMap;
        this.val$len = n2;
        this.val$off = n3;
        this.val$range = range;
    }

    @Override
    public int size() {
        return this.val$len;
    }

    public Range get(int n2) {
        Preconditions.checkElementIndex(n2, this.val$len);
        if (n2 == 0) return ((Range)ImmutableRangeMap.access$000(this.this$0).get(n2 + this.val$off)).intersection(this.val$range);
        if (n2 != this.val$len - 1) return (Range)ImmutableRangeMap.access$000(this.this$0).get(n2 + this.val$off);
        return ((Range)ImmutableRangeMap.access$000(this.this$0).get(n2 + this.val$off)).intersection(this.val$range);
    }

    @Override
    boolean isPartialView() {
        return true;
    }
}

