package com.google.common.collect;

import java.util.*;

class WellBehavedMap$EntrySet$1 extends TransformedIterator
{
    final /* synthetic */ WellBehavedMap$EntrySet this$1;
    
    WellBehavedMap$EntrySet$1(final WellBehavedMap$EntrySet this$1, final Iterator iterator) {
        this.this$1 = this$1;
        super(iterator);
    }
    
    @Override
    Map.Entry transform(final Object o) {
        return new WellBehavedMap$EntrySet$1$1(this, o);
    }
}
