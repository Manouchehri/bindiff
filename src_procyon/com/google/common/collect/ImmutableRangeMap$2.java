package com.google.common.collect;

import java.util.*;

class ImmutableRangeMap$2 extends ImmutableRangeMap
{
    final /* synthetic */ Range val$range;
    final /* synthetic */ ImmutableRangeMap val$outer;
    final /* synthetic */ ImmutableRangeMap this$0;
    
    ImmutableRangeMap$2(final ImmutableRangeMap this$0, final ImmutableList list, final ImmutableList list2, final Range val$range, final ImmutableRangeMap val$outer) {
        this.this$0 = this$0;
        this.val$range = val$range;
        this.val$outer = val$outer;
        super(list, list2);
    }
    
    @Override
    public ImmutableRangeMap subRangeMap(final Range range) {
        if (this.val$range.isConnected(range)) {
            return this.val$outer.subRangeMap(range.intersection(this.val$range));
        }
        return ImmutableRangeMap.of();
    }
}
