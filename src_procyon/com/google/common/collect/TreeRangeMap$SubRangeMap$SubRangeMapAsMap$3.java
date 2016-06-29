package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3 extends AbstractIterator
{
    final /* synthetic */ Iterator val$backingItr;
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;
    
    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2, final Iterator val$backingItr) {
        this.this$2 = this$2;
        this.val$backingItr = val$backingItr;
    }
    
    @Override
    protected Map.Entry computeNext() {
        while (this.val$backingItr.hasNext()) {
            final TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = this.val$backingItr.next();
            if (treeRangeMap$RangeMapEntry.getLowerBound().compareTo(this.this$2.this$1.subRange.upperBound) >= 0) {
                return (Map.Entry)this.endOfData();
            }
            if (treeRangeMap$RangeMapEntry.getUpperBound().compareTo(this.this$2.this$1.subRange.lowerBound) > 0) {
                return Maps.immutableEntry(treeRangeMap$RangeMapEntry.getKey().intersection(this.this$2.this$1.subRange), treeRangeMap$RangeMapEntry.getValue());
            }
        }
        return (Map.Entry)this.endOfData();
    }
}
