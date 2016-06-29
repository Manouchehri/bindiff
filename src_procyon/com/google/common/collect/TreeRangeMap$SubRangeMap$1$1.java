package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;

class TreeRangeMap$SubRangeMap$1$1 extends AbstractIterator
{
    final /* synthetic */ Iterator val$backingItr;
    final /* synthetic */ TreeRangeMap$SubRangeMap$1 this$2;
    
    TreeRangeMap$SubRangeMap$1$1(final TreeRangeMap$SubRangeMap$1 this$2, final Iterator val$backingItr) {
        this.this$2 = this$2;
        this.val$backingItr = val$backingItr;
    }
    
    @Override
    protected Map.Entry computeNext() {
        if (!this.val$backingItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        final TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = this.val$backingItr.next();
        if (treeRangeMap$RangeMapEntry.getUpperBound().compareTo(this.this$2.this$1.subRange.lowerBound) <= 0) {
            return (Map.Entry)this.endOfData();
        }
        return Maps.immutableEntry(treeRangeMap$RangeMapEntry.getKey().intersection(this.this$2.this$1.subRange), treeRangeMap$RangeMapEntry.getValue());
    }
}
