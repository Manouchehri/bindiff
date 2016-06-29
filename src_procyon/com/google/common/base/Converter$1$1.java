package com.google.common.base;

import java.util.*;

class Converter$1$1 implements Iterator
{
    private final Iterator fromIterator;
    final /* synthetic */ Converter$1 this$1;
    
    Converter$1$1(final Converter$1 this$1) {
        this.this$1 = this$1;
        this.fromIterator = this.this$1.val$fromIterable.iterator();
    }
    
    @Override
    public boolean hasNext() {
        return this.fromIterator.hasNext();
    }
    
    @Override
    public Object next() {
        return this.this$1.this$0.convert(this.fromIterator.next());
    }
    
    @Override
    public void remove() {
        this.fromIterator.remove();
    }
}
