package com.google.common.collect;

import java.util.*;

class AbstractTable$Values extends AbstractCollection
{
    final /* synthetic */ AbstractTable this$0;
    
    AbstractTable$Values(final AbstractTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.valuesIterator();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.this$0.containsValue(o);
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
    
    @Override
    public int size() {
        return this.this$0.size();
    }
}
