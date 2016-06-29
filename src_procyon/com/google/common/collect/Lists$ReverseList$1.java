package com.google.common.collect;

import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class Lists$ReverseList$1 implements ListIterator
{
    boolean canRemoveOrSet;
    final /* synthetic */ ListIterator val$forwardIterator;
    final /* synthetic */ Lists$ReverseList this$0;
    
    Lists$ReverseList$1(final Lists$ReverseList this$0, final ListIterator val$forwardIterator) {
        this.this$0 = this$0;
        this.val$forwardIterator = val$forwardIterator;
    }
    
    @Override
    public void add(final Object o) {
        this.val$forwardIterator.add(o);
        this.val$forwardIterator.previous();
        this.canRemoveOrSet = false;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$forwardIterator.hasPrevious();
    }
    
    @Override
    public boolean hasPrevious() {
        return this.val$forwardIterator.hasNext();
    }
    
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.canRemoveOrSet = true;
        return this.val$forwardIterator.previous();
    }
    
    @Override
    public int nextIndex() {
        return this.this$0.reversePosition(this.val$forwardIterator.nextIndex());
    }
    
    @Override
    public Object previous() {
        if (!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.canRemoveOrSet = true;
        return this.val$forwardIterator.next();
    }
    
    @Override
    public int previousIndex() {
        return this.nextIndex() - 1;
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.canRemoveOrSet);
        this.val$forwardIterator.remove();
        this.canRemoveOrSet = false;
    }
    
    @Override
    public void set(final Object o) {
        Preconditions.checkState(this.canRemoveOrSet);
        this.val$forwardIterator.set(o);
    }
}
