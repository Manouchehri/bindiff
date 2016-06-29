package com.google.common.collect;

import com.google.j2objc.annotations.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.annotations.*;

class ImmutableMapValues$1 extends UnmodifiableIterator
{
    final UnmodifiableIterator entryItr;
    final /* synthetic */ ImmutableMapValues this$0;
    
    ImmutableMapValues$1(final ImmutableMapValues this$0) {
        this.this$0 = this$0;
        this.entryItr = this.this$0.map.entrySet().iterator();
    }
    
    @Override
    public boolean hasNext() {
        return this.entryItr.hasNext();
    }
    
    @Override
    public Object next() {
        return this.entryItr.next().getValue();
    }
}
