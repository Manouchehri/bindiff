package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

class AbstractMultimap$Values extends AbstractCollection
{
    final /* synthetic */ AbstractMultimap this$0;
    
    AbstractMultimap$Values(final AbstractMultimap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.valueIterator();
    }
    
    @Override
    public int size() {
        return this.this$0.size();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.this$0.containsValue(o);
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
}
