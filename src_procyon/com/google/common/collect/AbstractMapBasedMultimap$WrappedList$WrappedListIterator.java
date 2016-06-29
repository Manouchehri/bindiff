package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class AbstractMapBasedMultimap$WrappedList$WrappedListIterator extends AbstractMapBasedMultimap$WrappedCollection$WrappedIterator implements ListIterator
{
    final /* synthetic */ AbstractMapBasedMultimap$WrappedList this$1;
    
    AbstractMapBasedMultimap$WrappedList$WrappedListIterator(final AbstractMapBasedMultimap$WrappedList this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    public AbstractMapBasedMultimap$WrappedList$WrappedListIterator(final AbstractMapBasedMultimap$WrappedList this$1, final int n) {
        this.this$1 = this$1;
        super(this$1, this$1.getListDelegate().listIterator(n));
    }
    
    private ListIterator getDelegateListIterator() {
        return (ListIterator)this.getDelegateIterator();
    }
    
    @Override
    public boolean hasPrevious() {
        return this.getDelegateListIterator().hasPrevious();
    }
    
    @Override
    public Object previous() {
        return this.getDelegateListIterator().previous();
    }
    
    @Override
    public int nextIndex() {
        return this.getDelegateListIterator().nextIndex();
    }
    
    @Override
    public int previousIndex() {
        return this.getDelegateListIterator().previousIndex();
    }
    
    @Override
    public void set(final Object o) {
        this.getDelegateListIterator().set(o);
    }
    
    @Override
    public void add(final Object o) {
        final boolean empty = this.this$1.isEmpty();
        this.getDelegateListIterator().add(o);
        this.this$1.this$0.totalSize++;
        if (empty) {
            this.this$1.addToMap();
        }
    }
}
