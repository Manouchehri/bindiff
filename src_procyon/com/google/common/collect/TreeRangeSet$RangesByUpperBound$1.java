package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

class TreeRangeSet$RangesByUpperBound$1 extends AbstractIterator
{
    final /* synthetic */ Iterator val$backingItr;
    final /* synthetic */ TreeRangeSet$RangesByUpperBound this$0;
    
    TreeRangeSet$RangesByUpperBound$1(final TreeRangeSet$RangesByUpperBound this$0, final Iterator val$backingItr) {
        this.this$0 = this$0;
        this.val$backingItr = val$backingItr;
    }
    
    @Override
    protected Map.Entry computeNext() {
        if (!this.val$backingItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        final Range range = this.val$backingItr.next();
        if (this.this$0.upperBoundWindow.upperBound.isLessThan(range.upperBound)) {
            return (Map.Entry)this.endOfData();
        }
        return Maps.immutableEntry(range.upperBound, range);
    }
}
