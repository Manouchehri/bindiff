package com.google.common.collect;

import java.util.*;

abstract class ImmutableMultimap$Itr extends UnmodifiableIterator
{
    final Iterator mapIterator;
    Object key;
    Iterator valueIterator;
    final /* synthetic */ ImmutableMultimap this$0;
    
    private ImmutableMultimap$Itr(final ImmutableMultimap this$0) {
        this.this$0 = this$0;
        this.mapIterator = this.this$0.asMap().entrySet().iterator();
        this.key = null;
        this.valueIterator = Iterators.emptyIterator();
    }
    
    abstract Object output(final Object p0, final Object p1);
    
    @Override
    public boolean hasNext() {
        return this.mapIterator.hasNext() || this.valueIterator.hasNext();
    }
    
    @Override
    public Object next() {
        if (!this.valueIterator.hasNext()) {
            final Map.Entry<Object, V> entry = this.mapIterator.next();
            this.key = entry.getKey();
            this.valueIterator = ((Collection)entry.getValue()).iterator();
        }
        return this.output(this.key, this.valueIterator.next());
    }
}
