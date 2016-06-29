package com.google.common.collect;

import java.util.*;

class TreeBasedTable$2 extends AbstractIterator
{
    Object lastValue;
    final /* synthetic */ Iterator val$merged;
    final /* synthetic */ Comparator val$comparator;
    final /* synthetic */ TreeBasedTable this$0;
    
    TreeBasedTable$2(final TreeBasedTable this$0, final Iterator val$merged, final Comparator val$comparator) {
        this.this$0 = this$0;
        this.val$merged = val$merged;
        this.val$comparator = val$comparator;
    }
    
    @Override
    protected Object computeNext() {
        while (this.val$merged.hasNext()) {
            final Object next = this.val$merged.next();
            if (this.lastValue == null || this.val$comparator.compare(next, this.lastValue) != 0) {
                return this.lastValue = next;
            }
        }
        this.lastValue = null;
        return this.endOfData();
    }
}
