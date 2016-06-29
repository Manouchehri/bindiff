/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Map;

class TreeRangeSet$RangesByUpperBound$2
extends AbstractIterator {
    final /* synthetic */ PeekingIterator val$backingItr;
    final /* synthetic */ TreeRangeSet$RangesByUpperBound this$0;

    TreeRangeSet$RangesByUpperBound$2(TreeRangeSet$RangesByUpperBound treeRangeSet$RangesByUpperBound, PeekingIterator peekingIterator) {
        this.this$0 = treeRangeSet$RangesByUpperBound;
        this.val$backingItr = peekingIterator;
    }

    @Override
    protected Map.Entry computeNext() {
        Map.Entry entry;
        if (!this.val$backingItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        Range range = (Range)this.val$backingItr.next();
        if (TreeRangeSet$RangesByUpperBound.access$000((TreeRangeSet$RangesByUpperBound)this.this$0).lowerBound.isLessThan(range.upperBound)) {
            entry = Maps.immutableEntry(range.upperBound, range);
            return entry;
        }
        entry = (Map.Entry)this.endOfData();
        return entry;
    }
}

