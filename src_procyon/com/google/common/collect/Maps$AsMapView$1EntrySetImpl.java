package com.google.common.collect;

import java.util.*;

class Maps$AsMapView$1EntrySetImpl extends Maps$EntrySet
{
    final /* synthetic */ Maps$AsMapView this$0;
    
    Maps$AsMapView$1EntrySetImpl(final Maps$AsMapView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Map map() {
        return this.this$0;
    }
    
    @Override
    public Iterator iterator() {
        return Maps.asMapEntryIterator(this.this$0.backingSet(), this.this$0.function);
    }
}
