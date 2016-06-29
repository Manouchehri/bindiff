package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

class CompactLinkedHashSet$1 implements Iterator
{
    int next;
    int toRemove;
    int expectedModCount;
    final /* synthetic */ CompactLinkedHashSet this$0;
    
    CompactLinkedHashSet$1(final CompactLinkedHashSet this$0) {
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
        this.checkForConcurrentModification();
        return this.next != -2;
    }
    
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final Object o = this.this$0.elements[this.next];
        this.toRemove = this.next;
        this.next = this.this$0.successor[this.next];
        return o;
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != -1);
        this.this$0.remove(this.this$0.elements[this.toRemove]);
        if (this.next == this.this$0.size()) {
            this.next = this.toRemove;
        }
        this.toRemove = -1;
        this.expectedModCount = this.this$0.modCount;
    }
}
