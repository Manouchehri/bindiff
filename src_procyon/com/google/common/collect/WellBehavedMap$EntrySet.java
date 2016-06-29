package com.google.common.collect;

import java.util.*;

final class WellBehavedMap$EntrySet extends Maps$EntrySet
{
    final /* synthetic */ WellBehavedMap this$0;
    
    private WellBehavedMap$EntrySet(final WellBehavedMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Map map() {
        return this.this$0;
    }
    
    @Override
    public Iterator iterator() {
        return new WellBehavedMap$EntrySet$1(this, this.this$0.keySet().iterator());
    }
}
