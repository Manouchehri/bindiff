/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$SubRangeSetRangesByLowerBound;
import java.util.NavigableMap;
import javax.annotation.Nullable;

final class TreeRangeSet$SubRangeSet
extends TreeRangeSet {
    private final Range restriction;
    final /* synthetic */ TreeRangeSet this$0;

    TreeRangeSet$SubRangeSet(TreeRangeSet treeRangeSet, Range range) {
        this.this$0 = treeRangeSet;
        super(new TreeRangeSet$SubRangeSetRangesByLowerBound(Range.all(), range, treeRangeSet.rangesByLowerBound, null), null);
        this.restriction = range;
    }

    @Override
    public boolean encloses(Range range) {
        if (this.restriction.isEmpty()) return false;
        if (!this.restriction.encloses(range)) return false;
        Range range2 = TreeRangeSet.access$600(this.this$0, range);
        if (range2 == null) return false;
        if (range2.intersection(this.restriction).isEmpty()) return false;
        return true;
    }

    @Nullable
    @Override
    public Range rangeContaining(Comparable comparable) {
        if (!this.restriction.contains(comparable)) {
            return null;
        }
        Range range = this.this$0.rangeContaining(comparable);
        if (range == null) {
            return null;
        }
        Range range2 = range.intersection(this.restriction);
        return range2;
    }

    @Override
    public void add(Range range) {
        Preconditions.checkArgument(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
        super.add(range);
    }

    @Override
    public void remove(Range range) {
        if (!range.isConnected(this.restriction)) return;
        this.this$0.remove(range.intersection(this.restriction));
    }

    @Override
    public boolean contains(Comparable comparable) {
        if (!this.restriction.contains(comparable)) return false;
        if (!this.this$0.contains(comparable)) return false;
        return true;
    }

    @Override
    public void clear() {
        this.this$0.remove(this.restriction);
    }

    @Override
    public RangeSet subRangeSet(Range range) {
        if (range.encloses(this.restriction)) {
            return this;
        }
        if (!range.isConnected(this.restriction)) return ImmutableRangeSet.of();
        return new TreeRangeSet$SubRangeSet(this, this.restriction.intersection(range));
    }
}

