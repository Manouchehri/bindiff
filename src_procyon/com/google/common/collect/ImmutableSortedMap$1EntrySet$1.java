package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

class ImmutableSortedMap$1EntrySet$1 extends ImmutableAsList
{
    final /* synthetic */ ImmutableSortedMap$1EntrySet this$1;
    
    ImmutableSortedMap$1EntrySet$1(final ImmutableSortedMap$1EntrySet this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public Map.Entry get(final int n) {
        return Maps.immutableEntry(this.this$1.this$0.keySet.asList().get(n), this.this$1.this$0.valueList.get(n));
    }
    
    @Override
    ImmutableCollection delegateCollection() {
        return this.this$1;
    }
}
