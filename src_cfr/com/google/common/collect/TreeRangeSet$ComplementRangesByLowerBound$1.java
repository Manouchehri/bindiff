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

class TreeRangeSet$ComplementRangesByLowerBound$1
extends AbstractIterator {
    Cut nextComplementRangeLowerBound;
    final /* synthetic */ Cut val$firstComplementRangeLowerBound;
    final /* synthetic */ PeekingIterator val$positiveItr;
    final /* synthetic */ TreeRangeSet$ComplementRangesByLowerBound this$0;

    TreeRangeSet$ComplementRangesByLowerBound$1(TreeRangeSet$ComplementRangesByLowerBound treeRangeSet$ComplementRangesByLowerBound, Cut cut, PeekingIterator peekingIterator) {
        this.this$0 = treeRangeSet$ComplementRangesByLowerBound;
        this.val$firstComplementRangeLowerBound = cut;
        this.val$positiveItr = peekingIterator;
        this.nextComplementRangeLowerBound = this.val$firstComplementRangeLowerBound;
    }

    @Override
    protected Map.Entry computeNext() {
        Range range;
        if (TreeRangeSet$ComplementRangesByLowerBound.access$100((TreeRangeSet$ComplementRangesByLowerBound)this.this$0).upperBound.isLessThan(this.nextComplementRangeLowerBound)) return (Map.Entry)this.endOfData();
        if (this.nextComplementRangeLowerBound == Cut.aboveAll()) {
            return (Map.Entry)this.endOfData();
        }
        if (this.val$positiveItr.hasNext()) {
            Range range2 = (Range)this.val$positiveItr.next();
            range = Range.create(this.nextComplementRangeLowerBound, range2.lowerBound);
            this.nextComplementRangeLowerBound = range2.upperBound;
            return Maps.immutableEntry(range.lowerBound, range);
        }
        range = Range.create(this.nextComplementRangeLowerBound, Cut.aboveAll());
        this.nextComplementRangeLowerBound = Cut.aboveAll();
        return Maps.immutableEntry(range.lowerBound, range);
    }
}

