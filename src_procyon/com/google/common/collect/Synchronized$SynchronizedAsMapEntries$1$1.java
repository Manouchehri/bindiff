package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedAsMapEntries$1$1 extends ForwardingMapEntry
{
    final /* synthetic */ Entry val$entry;
    final /* synthetic */ Synchronized$SynchronizedAsMapEntries$1 this$1;
    
    Synchronized$SynchronizedAsMapEntries$1$1(final Synchronized$SynchronizedAsMapEntries$1 this$1, final Entry val$entry) {
        this.this$1 = this$1;
        this.val$entry = val$entry;
    }
    
    @Override
    protected Entry delegate() {
        return this.val$entry;
    }
    
    @Override
    public Collection getValue() {
        return typePreservingCollection(this.val$entry.getValue(), this.this$1.this$0.mutex);
    }
}
