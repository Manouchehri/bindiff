package com.google.common.collect;

import java.util.*;

final class TreeRangeSet$Complement extends TreeRangeSet
{
    final /* synthetic */ TreeRangeSet this$0;
    
    TreeRangeSet$Complement(final TreeRangeSet this$0) {
        this.this$0 = this$0;
        super(new TreeRangeSet$ComplementRangesByLowerBound(this$0.rangesByLowerBound), null);
    }
    
    @Override
    public void add(final Range range) {
        this.this$0.remove(range);
    }
    
    @Override
    public void remove(final Range range) {
        this.this$0.add(range);
    }
    
    @Override
    public boolean contains(final Comparable comparable) {
        return !this.this$0.contains(comparable);
    }
    
    @Override
    public RangeSet complement() {
        return this.this$0;
    }
}
