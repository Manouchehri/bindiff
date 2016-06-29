package com.google.common.collect;

import java.util.*;

class MapConstraints$ConstrainedAsMapValues$1 implements Iterator
{
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ MapConstraints$ConstrainedAsMapValues this$0;
    
    MapConstraints$ConstrainedAsMapValues$1(final MapConstraints$ConstrainedAsMapValues this$0, final Iterator val$iterator) {
        this.this$0 = this$0;
        this.val$iterator = val$iterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public Collection next() {
        return this.val$iterator.next().getValue();
    }
    
    @Override
    public void remove() {
        this.val$iterator.remove();
    }
}
