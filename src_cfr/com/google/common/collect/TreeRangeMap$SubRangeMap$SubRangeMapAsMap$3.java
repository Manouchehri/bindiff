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
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Iterator;
import java.util.Map;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3
extends AbstractIterator {
    final /* synthetic */ Iterator val$backingItr;
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap, Iterator iterator) {
        this.this$2 = treeRangeMap$SubRangeMap$SubRangeMapAsMap;
        this.val$backingItr = iterator;
    }

    @Override
    protected Map.Entry computeNext() {
        TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry;
        do {
            if (!this.val$backingItr.hasNext()) return (Map.Entry)this.endOfData();
            treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)this.val$backingItr.next();
            if (treeRangeMap$RangeMapEntry.getLowerBound().compareTo(TreeRangeMap$SubRangeMap.access$200((TreeRangeMap$SubRangeMap)this.this$2.this$1).upperBound) < 0) continue;
            return (Map.Entry)this.endOfData();
        } while (treeRangeMap$RangeMapEntry.getUpperBound().compareTo(TreeRangeMap$SubRangeMap.access$200((TreeRangeMap$SubRangeMap)this.this$2.this$1).lowerBound) <= 0);
        return Maps.immutableEntry(treeRangeMap$RangeMapEntry.getKey().intersection(TreeRangeMap$SubRangeMap.access$200(this.this$2.this$1)), treeRangeMap$RangeMapEntry.getValue());
    }
}

