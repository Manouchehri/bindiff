package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

final class TreeRangeMap$AsMapOfRanges extends Maps$IteratorBasedAbstractMap
{
    final Iterable entryIterable;
    final /* synthetic */ TreeRangeMap this$0;
    
    TreeRangeMap$AsMapOfRanges(final TreeRangeMap this$0, final Iterable entryIterable) {
        this.this$0 = this$0;
        this.entryIterable = entryIterable;
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.get(o) != null;
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        if (o instanceof Range) {
            final Range range = (Range)o;
            final TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)this.this$0.entriesByLowerBound.get(range.lowerBound);
            if (treeRangeMap$RangeMapEntry != null && treeRangeMap$RangeMapEntry.getKey().equals(range)) {
                return treeRangeMap$RangeMapEntry.getValue();
            }
        }
        return null;
    }
    
    @Override
    public int size() {
        return this.this$0.entriesByLowerBound.size();
    }
    
    @Override
    Iterator entryIterator() {
        return this.entryIterable.iterator();
    }
}
