package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class TreeRangeMap$SubRangeMap$1 extends TreeRangeMap$SubRangeMap$SubRangeMapAsMap
{
    final /* synthetic */ TreeRangeMap$SubRangeMap this$1;
    
    TreeRangeMap$SubRangeMap$1(final TreeRangeMap$SubRangeMap this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    @Override
    Iterator entryIterator() {
        if (this.this$1.subRange.isEmpty()) {
            return Iterators.emptyIterator();
        }
        return new TreeRangeMap$SubRangeMap$1$1(this, this.this$1.this$0.entriesByLowerBound.headMap(this.this$1.subRange.upperBound, false).descendingMap().values().iterator());
    }
}
