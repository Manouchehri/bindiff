package com.google.common.collect;

import java.util.*;

class ImmutableMapValues$2 extends ImmutableAsList
{
    final /* synthetic */ ImmutableList val$entryList;
    final /* synthetic */ ImmutableMapValues this$0;
    
    ImmutableMapValues$2(final ImmutableMapValues this$0, final ImmutableList val$entryList) {
        this.this$0 = this$0;
        this.val$entryList = val$entryList;
    }
    
    @Override
    public Object get(final int n) {
        return this.val$entryList.get(n).getValue();
    }
    
    @Override
    ImmutableCollection delegateCollection() {
        return this.this$0;
    }
}
