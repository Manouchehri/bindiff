package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class Maps$FilteredEntryMap$EntrySet$1$1 extends ForwardingMapEntry
{
    final /* synthetic */ Entry val$entry;
    final /* synthetic */ Maps$FilteredEntryMap$EntrySet$1 this$2;
    
    Maps$FilteredEntryMap$EntrySet$1$1(final Maps$FilteredEntryMap$EntrySet$1 this$2, final Entry val$entry) {
        this.this$2 = this$2;
        this.val$entry = val$entry;
    }
    
    @Override
    protected Entry delegate() {
        return this.val$entry;
    }
    
    @Override
    public Object setValue(final Object value) {
        Preconditions.checkArgument(this.this$2.this$1.this$0.apply(this.getKey(), value));
        return super.setValue(value);
    }
}
