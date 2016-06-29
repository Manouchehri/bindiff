/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.Map;

class ImmutableRangeMap$2
extends ImmutableRangeMap {
    final /* synthetic */ Range val$range;
    final /* synthetic */ ImmutableRangeMap val$outer;
    final /* synthetic */ ImmutableRangeMap this$0;

    ImmutableRangeMap$2(ImmutableRangeMap immutableRangeMap, ImmutableList immutableList, ImmutableList immutableList2, Range range, ImmutableRangeMap immutableRangeMap2) {
        this.this$0 = immutableRangeMap;
        this.val$range = range;
        this.val$outer = immutableRangeMap2;
        super(immutableList, immutableList2);
    }

    @Override
    public ImmutableRangeMap subRangeMap(Range range) {
        if (!this.val$range.isConnected(range)) return ImmutableRangeMap.of();
        return this.val$outer.subRangeMap(range.intersection(this.val$range));
    }
}

