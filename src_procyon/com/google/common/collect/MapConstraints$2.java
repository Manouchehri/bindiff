package com.google.common.collect;

import java.util.*;

final class MapConstraints$2 extends ForwardingMapEntry
{
    final /* synthetic */ Entry val$entry;
    final /* synthetic */ MapConstraint val$constraint;
    
    MapConstraints$2(final Entry val$entry, final MapConstraint val$constraint) {
        this.val$entry = val$entry;
        this.val$constraint = val$constraint;
    }
    
    @Override
    protected Entry delegate() {
        return this.val$entry;
    }
    
    @Override
    public Collection getValue() {
        return Constraints.constrainedTypePreservingCollection(this.val$entry.getValue(), new MapConstraints$2$1(this));
    }
}
