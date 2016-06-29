/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Cut;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import java.util.Iterator;
import javax.annotation.Nullable;

final class TreeRangeMap$AsMapOfRanges
extends Maps$IteratorBasedAbstractMap {
    final Iterable entryIterable;
    final /* synthetic */ TreeRangeMap this$0;

    TreeRangeMap$AsMapOfRanges(TreeRangeMap treeRangeMap, Iterable iterable) {
        this.this$0 = treeRangeMap;
        this.entryIterable = iterable;
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (this.get(object) == null) return false;
        return true;
    }

    @Override
    public Object get(@Nullable Object object) {
        if (!(object instanceof Range)) return null;
        Range range = (Range)object;
        TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)TreeRangeMap.access$000(this.this$0).get(range.lowerBound);
        if (treeRangeMap$RangeMapEntry == null) return null;
        if (!treeRangeMap$RangeMapEntry.getKey().equals(range)) return null;
        return treeRangeMap$RangeMapEntry.getValue();
    }

    @Override
    public int size() {
        return TreeRangeMap.access$000(this.this$0).size();
    }

    @Override
    Iterator entryIterator() {
        return this.entryIterable.iterator();
    }
}

