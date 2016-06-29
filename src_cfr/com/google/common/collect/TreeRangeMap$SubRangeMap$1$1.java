/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Cut;
import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1;
import java.util.Iterator;
import java.util.Map;

class TreeRangeMap$SubRangeMap$1$1
extends AbstractIterator {
    final /* synthetic */ Iterator val$backingItr;
    final /* synthetic */ TreeRangeMap$SubRangeMap$1 this$2;

    TreeRangeMap$SubRangeMap$1$1(TreeRangeMap$SubRangeMap$1 var1_1, Iterator iterator) {
        this.this$2 = var1_1;
        this.val$backingItr = iterator;
    }

    @Override
    protected Map.Entry computeNext() {
        if (!this.val$backingItr.hasNext()) return (Map.Entry)this.endOfData();
        TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)this.val$backingItr.next();
        if (treeRangeMap$RangeMapEntry.getUpperBound().compareTo(TreeRangeMap$SubRangeMap.access$200((TreeRangeMap$SubRangeMap)this.this$2.this$1).lowerBound) > 0) return Maps.immutableEntry(treeRangeMap$RangeMapEntry.getKey().intersection(TreeRangeMap$SubRangeMap.access$200(this.this$2.this$1)), treeRangeMap$RangeMapEntry.getValue());
        return (Map.Entry)this.endOfData();
    }
}

