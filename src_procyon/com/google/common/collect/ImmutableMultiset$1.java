package com.google.common.collect;

import java.util.*;

class ImmutableMultiset$1 extends UnmodifiableIterator
{
    int remaining;
    Object element;
    final /* synthetic */ Iterator val$entryIterator;
    final /* synthetic */ ImmutableMultiset this$0;
    
    ImmutableMultiset$1(final ImmutableMultiset this$0, final Iterator val$entryIterator) {
        this.this$0 = this$0;
        this.val$entryIterator = val$entryIterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.remaining > 0 || this.val$entryIterator.hasNext();
    }
    
    @Override
    public Object next() {
        if (this.remaining <= 0) {
            final Multiset$Entry multiset$Entry = this.val$entryIterator.next();
            this.element = multiset$Entry.getElement();
            this.remaining = multiset$Entry.getCount();
        }
        --this.remaining;
        return this.element;
    }
}
