package com.google.common.collect;

import com.google.common.base.*;
import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

class AbstractBiMap$EntrySet$1$1 extends ForwardingMapEntry
{
    final /* synthetic */ Entry val$finalEntry;
    final /* synthetic */ AbstractBiMap$EntrySet$1 this$2;
    
    AbstractBiMap$EntrySet$1$1(final AbstractBiMap$EntrySet$1 this$2, final Entry val$finalEntry) {
        this.this$2 = this$2;
        this.val$finalEntry = val$finalEntry;
    }
    
    @Override
    protected Entry delegate() {
        return this.val$finalEntry;
    }
    
    @Override
    public Object setValue(final Object value) {
        Preconditions.checkState(this.this$2.this$1.contains(this), (Object)"entry no longer in map");
        if (Objects.equal(value, this.getValue())) {
            return value;
        }
        Preconditions.checkArgument(!this.this$2.this$1.this$0.containsValue(value), "value already present: %s", value);
        final Object setValue = this.val$finalEntry.setValue(value);
        Preconditions.checkState(Objects.equal(value, this.this$2.this$1.this$0.get(this.getKey())), (Object)"entry no longer in map");
        this.this$2.this$1.this$0.updateInverseMap(this.getKey(), true, setValue, value);
        return setValue;
    }
}
