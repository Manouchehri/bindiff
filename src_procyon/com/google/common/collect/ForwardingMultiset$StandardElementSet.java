package com.google.common.collect;

import com.google.common.annotations.*;

@Beta
public class ForwardingMultiset$StandardElementSet extends Multisets$ElementSet
{
    final /* synthetic */ ForwardingMultiset this$0;
    
    public ForwardingMultiset$StandardElementSet(final ForwardingMultiset this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Multiset multiset() {
        return this.this$0;
    }
}
