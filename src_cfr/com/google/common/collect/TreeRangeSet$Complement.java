/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$ComplementRangesByLowerBound;
import java.util.NavigableMap;

final class TreeRangeSet$Complement
extends TreeRangeSet {
    final /* synthetic */ TreeRangeSet this$0;

    TreeRangeSet$Complement(TreeRangeSet treeRangeSet) {
        this.this$0 = treeRangeSet;
        super(new TreeRangeSet$ComplementRangesByLowerBound(treeRangeSet.rangesByLowerBound), null);
    }

    @Override
    public void add(Range range) {
        this.this$0.remove(range);
    }

    @Override
    public void remove(Range range) {
        this.this$0.add(range);
    }

    @Override
    public boolean contains(Comparable comparable) {
        if (this.this$0.contains(comparable)) return false;
        return true;
    }

    @Override
    public RangeSet complement() {
        return this.this$0;
    }
}

