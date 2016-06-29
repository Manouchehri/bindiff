package com.google.common.collect;

import java.util.*;

class AbstractBiMap$ValueSet extends ForwardingSet
{
    final Set valuesDelegate;
    final /* synthetic */ AbstractBiMap this$0;
    
    private AbstractBiMap$ValueSet(final AbstractBiMap this$0) {
        this.this$0 = this$0;
        this.valuesDelegate = this.this$0.inverse.keySet();
    }
    
    @Override
    protected Set delegate() {
        return this.valuesDelegate;
    }
    
    @Override
    public Iterator iterator() {
        return Maps.valueIterator(this.this$0.entrySet().iterator());
    }
    
    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.standardToArray(array);
    }
    
    @Override
    public String toString() {
        return this.standardToString();
    }
}
