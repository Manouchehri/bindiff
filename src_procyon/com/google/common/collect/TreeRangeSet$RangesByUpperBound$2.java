package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

class TreeRangeSet$RangesByUpperBound$2 extends AbstractIterator
{
    final /* synthetic */ PeekingIterator val$backingItr;
    final /* synthetic */ TreeRangeSet$RangesByUpperBound this$0;
    
    TreeRangeSet$RangesByUpperBound$2(final TreeRangeSet$RangesByUpperBound this$0, final PeekingIterator val$backingItr) {
        this.this$0 = this$0;
        this.val$backingItr = val$backingItr;
    }
    
    @Override
    protected Map.Entry computeNext() {
        if (!this.val$backingItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        final Range range = (Range)this.val$backingItr.next();
        return (Map.Entry)(this.this$0.upperBoundWindow.lowerBound.isLessThan(range.upperBound) ? Maps.immutableEntry(range.upperBound, range) : this.endOfData());
    }
}
