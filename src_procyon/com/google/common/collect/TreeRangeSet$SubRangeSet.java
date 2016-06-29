package com.google.common.collect;

import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;

final class TreeRangeSet$SubRangeSet extends TreeRangeSet
{
    private final Range restriction;
    final /* synthetic */ TreeRangeSet this$0;
    
    TreeRangeSet$SubRangeSet(final TreeRangeSet this$0, final Range restriction) {
        this.this$0 = this$0;
        super(new TreeRangeSet$SubRangeSetRangesByLowerBound(Range.all(), restriction, this$0.rangesByLowerBound, null), null);
        this.restriction = restriction;
    }
    
    @Override
    public boolean encloses(final Range range) {
        if (!this.restriction.isEmpty() && this.restriction.encloses(range)) {
            final Range access$600 = TreeRangeSet.access$600(this.this$0, range);
            return access$600 != null && !access$600.intersection(this.restriction).isEmpty();
        }
        return false;
    }
    
    @Nullable
    @Override
    public Range rangeContaining(final Comparable comparable) {
        if (!this.restriction.contains(comparable)) {
            return null;
        }
        final Range rangeContaining = this.this$0.rangeContaining(comparable);
        return (rangeContaining == null) ? null : rangeContaining.intersection(this.restriction);
    }
    
    @Override
    public void add(final Range range) {
        Preconditions.checkArgument(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
        super.add(range);
    }
    
    @Override
    public void remove(final Range range) {
        if (range.isConnected(this.restriction)) {
            this.this$0.remove(range.intersection(this.restriction));
        }
    }
    
    @Override
    public boolean contains(final Comparable comparable) {
        return this.restriction.contains(comparable) && this.this$0.contains(comparable);
    }
    
    @Override
    public void clear() {
        this.this$0.remove(this.restriction);
    }
    
    @Override
    public RangeSet subRangeSet(final Range range) {
        if (range.encloses(this.restriction)) {
            return this;
        }
        if (range.isConnected(this.restriction)) {
            return new TreeRangeSet$SubRangeSet(this, this.restriction.intersection(range));
        }
        return ImmutableRangeSet.of();
    }
}
