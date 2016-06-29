package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

class TreeRangeSet$ComplementRangesByLowerBound$1 extends AbstractIterator
{
    Cut nextComplementRangeLowerBound;
    final /* synthetic */ Cut val$firstComplementRangeLowerBound;
    final /* synthetic */ PeekingIterator val$positiveItr;
    final /* synthetic */ TreeRangeSet$ComplementRangesByLowerBound this$0;
    
    TreeRangeSet$ComplementRangesByLowerBound$1(final TreeRangeSet$ComplementRangesByLowerBound this$0, final Cut val$firstComplementRangeLowerBound, final PeekingIterator val$positiveItr) {
        this.this$0 = this$0;
        this.val$firstComplementRangeLowerBound = val$firstComplementRangeLowerBound;
        this.val$positiveItr = val$positiveItr;
        this.nextComplementRangeLowerBound = this.val$firstComplementRangeLowerBound;
    }
    
    @Override
    protected Map.Entry computeNext() {
        if (this.this$0.complementLowerBoundWindow.upperBound.isLessThan(this.nextComplementRangeLowerBound) || this.nextComplementRangeLowerBound == Cut.aboveAll()) {
            return (Map.Entry)this.endOfData();
        }
        Range range2;
        if (this.val$positiveItr.hasNext()) {
            final Range range = (Range)this.val$positiveItr.next();
            range2 = Range.create(this.nextComplementRangeLowerBound, range.lowerBound);
            this.nextComplementRangeLowerBound = range.upperBound;
        }
        else {
            range2 = Range.create(this.nextComplementRangeLowerBound, Cut.aboveAll());
            this.nextComplementRangeLowerBound = Cut.aboveAll();
        }
        return Maps.immutableEntry(range2.lowerBound, range2);
    }
}
