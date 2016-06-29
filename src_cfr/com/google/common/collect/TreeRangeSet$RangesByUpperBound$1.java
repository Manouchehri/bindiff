/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$RangesByUpperBound;
import java.util.Iterator;
import java.util.Map;

class TreeRangeSet$RangesByUpperBound$1
extends AbstractIterator {
    final /* synthetic */ Iterator val$backingItr;
    final /* synthetic */ TreeRangeSet$RangesByUpperBound this$0;

    TreeRangeSet$RangesByUpperBound$1(TreeRangeSet$RangesByUpperBound treeRangeSet$RangesByUpperBound, Iterator iterator) {
        this.this$0 = treeRangeSet$RangesByUpperBound;
        this.val$backingItr = iterator;
    }

    @Override
    protected Map.Entry computeNext() {
        if (!this.val$backingItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        Range range = (Range)this.val$backingItr.next();
        if (!TreeRangeSet$RangesByUpperBound.access$000((TreeRangeSet$RangesByUpperBound)this.this$0).upperBound.isLessThan(range.upperBound)) return Maps.immutableEntry(range.upperBound, range);
        return (Map.Entry)this.endOfData();
    }
}

