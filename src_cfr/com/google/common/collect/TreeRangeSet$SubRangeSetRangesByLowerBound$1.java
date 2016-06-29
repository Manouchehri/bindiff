/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound;
import java.util.Iterator;
import java.util.Map;

class TreeRangeSet$SubRangeSetRangesByLowerBound$1
extends AbstractIterator {
    final /* synthetic */ Iterator val$completeRangeItr;
    final /* synthetic */ Cut val$upperBoundOnLowerBounds;
    final /* synthetic */ TreeRangeSet$SubRangeSetRangesByLowerBound this$0;

    TreeRangeSet$SubRangeSetRangesByLowerBound$1(TreeRangeSet$SubRangeSetRangesByLowerBound treeRangeSet$SubRangeSetRangesByLowerBound, Iterator iterator, Cut cut) {
        this.this$0 = treeRangeSet$SubRangeSetRangesByLowerBound;
        this.val$completeRangeItr = iterator;
        this.val$upperBoundOnLowerBounds = cut;
    }

    @Override
    protected Map.Entry computeNext() {
        if (!this.val$completeRangeItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        Range range = (Range)this.val$completeRangeItr.next();
        if (this.val$upperBoundOnLowerBounds.isLessThan(range.lowerBound)) {
            return (Map.Entry)this.endOfData();
        }
        range = range.intersection(TreeRangeSet$SubRangeSetRangesByLowerBound.access$300(this.this$0));
        return Maps.immutableEntry(range.lowerBound, range);
    }
}

