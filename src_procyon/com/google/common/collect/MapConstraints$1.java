package com.google.common.collect;

import java.util.*;

final class MapConstraints$1 extends ForwardingMapEntry
{
    final /* synthetic */ Entry val$entry;
    final /* synthetic */ MapConstraint val$constraint;
    
    MapConstraints$1(final Entry val$entry, final MapConstraint val$constraint) {
        this.val$entry = val$entry;
        this.val$constraint = val$constraint;
    }
    
    @Override
    protected Entry delegate() {
        return this.val$entry;
    }
    
    @Override
    public Object setValue(final Object value) {
        this.val$constraint.checkKeyValue(this.getKey(), value);
        return this.val$entry.setValue(value);
    }
}
