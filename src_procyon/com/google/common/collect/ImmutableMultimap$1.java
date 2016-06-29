package com.google.common.collect;

import java.util.*;

class ImmutableMultimap$1 extends ImmutableMultimap$Itr
{
    final /* synthetic */ ImmutableMultimap this$0;
    
    ImmutableMultimap$1(final ImmutableMultimap this$0) {
        this.this$0 = this$0;
        super(this$0, null);
    }
    
    @Override
    Map.Entry output(final Object o, final Object o2) {
        return Maps.immutableEntry(o, o2);
    }
}
