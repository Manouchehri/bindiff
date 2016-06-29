package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

class TreeRangeSet$SubRangeSetRangesByLowerBound$2 extends AbstractIterator
{
    final /* synthetic */ Iterator val$completeRangeItr;
    final /* synthetic */ TreeRangeSet$SubRangeSetRangesByLowerBound this$0;
    
    TreeRangeSet$SubRangeSetRangesByLowerBound$2(final TreeRangeSet$SubRangeSetRangesByLowerBound this$0, final Iterator val$completeRangeItr) {
        this.this$0 = this$0;
        this.val$completeRangeItr = val$completeRangeItr;
    }
    
    @Override
    protected Map.Entry computeNext() {
        if (!this.val$completeRangeItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        final Range range = this.val$completeRangeItr.next();
        if (this.this$0.restriction.lowerBound.compareTo(range.upperBound) >= 0) {
            return (Map.Entry)this.endOfData();
        }
        final Range intersection = range.intersection(this.this$0.restriction);
        if (this.this$0.lowerBoundWindow.contains(intersection.lowerBound)) {
            return Maps.immutableEntry(intersection.lowerBound, intersection);
        }
        return (Map.Entry)this.endOfData();
    }
}
