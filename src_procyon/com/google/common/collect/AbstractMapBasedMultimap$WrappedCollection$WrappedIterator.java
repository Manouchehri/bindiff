package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class AbstractMapBasedMultimap$WrappedCollection$WrappedIterator implements Iterator
{
    final Iterator delegateIterator;
    final Collection originalDelegate;
    final /* synthetic */ AbstractMapBasedMultimap$WrappedCollection this$1;
    
    AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(final AbstractMapBasedMultimap$WrappedCollection this$1) {
        this.this$1 = this$1;
        this.originalDelegate = this.this$1.delegate;
        this.delegateIterator = this$1.this$0.iteratorOrListIterator(this$1.delegate);
    }
    
    AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(final AbstractMapBasedMultimap$WrappedCollection this$1, final Iterator delegateIterator) {
        this.this$1 = this$1;
        this.originalDelegate = this.this$1.delegate;
        this.delegateIterator = delegateIterator;
    }
    
    void validateIterator() {
        this.this$1.refreshIfEmpty();
        if (this.this$1.delegate != this.originalDelegate) {
            throw new ConcurrentModificationException();
        }
    }
    
    @Override
    public boolean hasNext() {
        this.validateIterator();
        return this.delegateIterator.hasNext();
    }
    
    @Override
    public Object next() {
        this.validateIterator();
        return this.delegateIterator.next();
    }
    
    @Override
    public void remove() {
        this.delegateIterator.remove();
        this.this$1.this$0.totalSize--;
        this.this$1.removeIfEmpty();
    }
    
    Iterator getDelegateIterator() {
        this.validateIterator();
        return this.delegateIterator;
    }
}
