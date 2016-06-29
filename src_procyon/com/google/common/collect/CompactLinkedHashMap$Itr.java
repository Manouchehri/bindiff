package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

abstract class CompactLinkedHashMap$Itr implements Iterator
{
    private int next;
    private int toRemove;
    private int expectedModCount;
    final /* synthetic */ CompactLinkedHashMap this$0;
    
    private CompactLinkedHashMap$Itr(final CompactLinkedHashMap this$0) {
        this.this$0 = this$0;
        this.next = this.this$0.firstEntry;
        this.toRemove = -1;
        this.expectedModCount = this.this$0.modCount;
    }
    
    private void checkForConcurrentModification() {
        if (this.this$0.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
    
    @Override
    public boolean hasNext() {
        return this.next != -2;
    }
    
    abstract Object getOutput(final int p0);
    
    @Override
    public Object next() {
        this.checkForConcurrentModification();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final Object output = this.getOutput(this.next);
        this.toRemove = this.next;
        this.next = this.this$0.getSuccessor(this.next);
        return output;
    }
    
    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.toRemove != -1);
        this.this$0.remove(this.this$0.keys[this.toRemove]);
        if (this.next >= this.this$0.size()) {
            this.next = this.toRemove;
        }
        this.expectedModCount = this.this$0.modCount;
        this.toRemove = -1;
    }
}
