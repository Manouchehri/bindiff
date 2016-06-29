package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

class TreeRangeSet$ComplementRangesByLowerBound$2 extends AbstractIterator
{
    Cut nextComplementRangeUpperBound;
    final /* synthetic */ Cut val$firstComplementRangeUpperBound;
    final /* synthetic */ PeekingIterator val$positiveItr;
    final /* synthetic */ TreeRangeSet$ComplementRangesByLowerBound this$0;
    
    TreeRangeSet$ComplementRangesByLowerBound$2(final TreeRangeSet$ComplementRangesByLowerBound this$0, final Cut val$firstComplementRangeUpperBound, final PeekingIterator val$positiveItr) {
        this.this$0 = this$0;
        this.val$firstComplementRangeUpperBound = val$firstComplementRangeUpperBound;
        this.val$positiveItr = val$positiveItr;
        this.nextComplementRangeUpperBound = this.val$firstComplementRangeUpperBound;
    }
    
    @Override
    protected Map.Entry computeNext() {
        if (this.nextComplementRangeUpperBound == Cut.belowAll()) {
            return (Map.Entry)this.endOfData();
        }
        if (this.val$positiveItr.hasNext()) {
            final Range range = (Range)this.val$positiveItr.next();
            final Range create = Range.create(range.upperBound, this.nextComplementRangeUpperBound);
            this.nextComplementRangeUpperBound = range.lowerBound;
            if (this.this$0.complementLowerBoundWindow.lowerBound.isLessThan(create.lowerBound)) {
                return Maps.immutableEntry(create.lowerBound, create);
            }
        }
        else if (this.this$0.complementLowerBoundWindow.lowerBound.isLessThan(Cut.belowAll())) {
            final Range create2 = Range.create(Cut.belowAll(), this.nextComplementRangeUpperBound);
            this.nextComplementRangeUpperBound = Cut.belowAll();
            return Maps.immutableEntry(Cut.belowAll(), create2);
        }
        return (Map.Entry)this.endOfData();
    }
}
