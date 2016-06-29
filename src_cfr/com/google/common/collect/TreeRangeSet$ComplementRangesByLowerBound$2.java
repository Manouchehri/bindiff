/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound;
import java.util.Map;

class TreeRangeSet$ComplementRangesByLowerBound$2
extends AbstractIterator {
    Cut nextComplementRangeUpperBound;
    final /* synthetic */ Cut val$firstComplementRangeUpperBound;
    final /* synthetic */ PeekingIterator val$positiveItr;
    final /* synthetic */ TreeRangeSet$ComplementRangesByLowerBound this$0;

    TreeRangeSet$ComplementRangesByLowerBound$2(TreeRangeSet$ComplementRangesByLowerBound treeRangeSet$ComplementRangesByLowerBound, Cut cut, PeekingIterator peekingIterator) {
        this.this$0 = treeRangeSet$ComplementRangesByLowerBound;
        this.val$firstComplementRangeUpperBound = cut;
        this.val$positiveItr = peekingIterator;
        this.nextComplementRangeUpperBound = this.val$firstComplementRangeUpperBound;
    }

    @Override
    protected Map.Entry computeNext() {
        if (this.nextComplementRangeUpperBound == Cut.belowAll()) {
            return (Map.Entry)this.endOfData();
        }
        if (this.val$positiveItr.hasNext()) {
            Range range = (Range)this.val$positiveItr.next();
            Range range2 = Range.create(range.upperBound, this.nextComplementRangeUpperBound);
            this.nextComplementRangeUpperBound = range.lowerBound;
            if (!TreeRangeSet$ComplementRangesByLowerBound.access$100((TreeRangeSet$ComplementRangesByLowerBound)this.this$0).lowerBound.isLessThan(range2.lowerBound)) return (Map.Entry)this.endOfData();
            return Maps.immutableEntry(range2.lowerBound, range2);
        }
        if (!TreeRangeSet$ComplementRangesByLowerBound.access$100((TreeRangeSet$ComplementRangesByLowerBound)this.this$0).lowerBound.isLessThan(Cut.belowAll())) return (Map.Entry)this.endOfData();
        Range range = Range.create(Cut.belowAll(), this.nextComplementRangeUpperBound);
        this.nextComplementRangeUpperBound = Cut.belowAll();
        return Maps.immutableEntry(Cut.belowAll(), range);
    }
}

