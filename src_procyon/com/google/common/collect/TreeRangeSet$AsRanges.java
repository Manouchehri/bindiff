package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

final class TreeRangeSet$AsRanges extends ForwardingCollection implements Set
{
    final Collection delegate;
    final /* synthetic */ TreeRangeSet this$0;
    
    TreeRangeSet$AsRanges(final TreeRangeSet this$0, final Collection delegate) {
        this.this$0 = this$0;
        this.delegate = delegate;
    }
    
    @Override
    protected Collection delegate() {
        return this.delegate;
    }
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Sets.equalsImpl(this, o);
    }
}
