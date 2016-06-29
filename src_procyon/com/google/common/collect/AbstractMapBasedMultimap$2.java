package com.google.common.collect;

import java.util.*;

class AbstractMapBasedMultimap$2 extends AbstractMapBasedMultimap$Itr
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$2(final AbstractMapBasedMultimap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    Map.Entry output(final Object o, final Object o2) {
        return Maps.immutableEntry(o, o2);
    }
}
