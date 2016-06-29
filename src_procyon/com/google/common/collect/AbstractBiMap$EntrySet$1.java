package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

class AbstractBiMap$EntrySet$1 implements Iterator
{
    Map.Entry entry;
    final /* synthetic */ Iterator val$iterator;
    final /* synthetic */ AbstractBiMap$EntrySet this$1;
    
    AbstractBiMap$EntrySet$1(final AbstractBiMap$EntrySet this$1, final Iterator val$iterator) {
        this.this$1 = this$1;
        this.val$iterator = val$iterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }
    
    @Override
    public Map.Entry next() {
        this.entry = (Map.Entry)this.val$iterator.next();
        return new AbstractBiMap$EntrySet$1$1(this, this.entry);
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.entry != null);
        final Object value = this.entry.getValue();
        this.val$iterator.remove();
        this.this$1.this$0.removeFromInverseMap(value);
    }
}
