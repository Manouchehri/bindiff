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

class TreeRangeSet$SubRangeSetRangesByLowerBound$2
extends AbstractIterator {
    final /* synthetic */ Iterator val$completeRangeItr;
    final /* synthetic */ TreeRangeSet$SubRangeSetRangesByLowerBound this$0;

    TreeRangeSet$SubRangeSetRangesByLowerBound$2(TreeRangeSet$SubRangeSetRangesByLowerBound treeRangeSet$SubRangeSetRangesByLowerBound, Iterator iterator) {
        this.this$0 = treeRangeSet$SubRangeSetRangesByLowerBound;
        this.val$completeRangeItr = iterator;
    }

    @Override
    protected Map.Entry computeNext() {
        if (!this.val$completeRangeItr.hasNext()) {
            return (Map.Entry)this.endOfData();
        }
        Range range = (Range)this.val$completeRangeItr.next();
        if (TreeRangeSet$SubRangeSetRangesByLowerBound.access$300((TreeRangeSet$SubRangeSetRangesByLowerBound)this.this$0).lowerBound.compareTo(range.upperBound) >= 0) {
            return (Map.Entry)this.endOfData();
        }
        range = range.intersection(TreeRangeSet$SubRangeSetRangesByLowerBound.access$300(this.this$0));
        if (!TreeRangeSet$SubRangeSetRangesByLowerBound.access$400(this.this$0).contains(range.lowerBound)) return (Map.Entry)this.endOfData();
        return Maps.immutableEntry(range.lowerBound, range);
    }
}

