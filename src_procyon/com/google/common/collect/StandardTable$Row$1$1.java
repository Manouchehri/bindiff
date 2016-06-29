package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class StandardTable$Row$1$1 extends ForwardingMapEntry
{
    final /* synthetic */ Entry val$entry;
    final /* synthetic */ StandardTable$Row$1 this$2;
    
    StandardTable$Row$1$1(final StandardTable$Row$1 this$2, final Entry val$entry) {
        this.this$2 = this$2;
        this.val$entry = val$entry;
    }
    
    @Override
    protected Entry delegate() {
        return this.val$entry;
    }
    
    @Override
    public Object setValue(final Object o) {
        return super.setValue(Preconditions.checkNotNull(o));
    }
    
    @Override
    public boolean equals(final Object o) {
        return this.standardEquals(o);
    }
}
