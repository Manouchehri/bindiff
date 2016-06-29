package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

class TreeRangeSet$SubRangeSetRangesByLowerBound$1 extends AbstractIterator
{
    final /* synthetic */ Iterator val$completeRangeItr;
    final /* synthetic */ Cut val$upperBoundOnLowerBounds;
    final /* synthetic */ TreeRangeSet$SubRangeSetRangesByLowerBound this$0;
    
    TreeRangeSet$SubRangeSetRangesByLowerBound$1(final TreeRangeSet$SubRangeSetRangesByLowerBound this$0, final Iterator val$completeRangeItr, final Cut val$upperBoundOnLowerBounds) {
        this.this$0 = this$0;
        this.val$completeRangeItr = val$completeRangeItr;
        this.val$upperBoundOnLowerBounds = val$upperBoundOnLowerBounds;
    }
    
    @Override
    protected Map.Entry computeNext() {
        if (!this.val$completeRangeItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        final Range range = this.val$completeRangeItr.next();
        if (this.val$upperBoundOnLowerBounds.isLessThan(range.lowerBound)) {
            return (Map.Entry)this.endOfData();
        }
        final Range intersection = range.intersection(this.this$0.restriction);
        return Maps.immutableEntry(intersection.lowerBound, intersection);
    }
}
