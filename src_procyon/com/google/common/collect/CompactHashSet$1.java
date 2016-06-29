package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;

class CompactHashSet$1 implements Iterator
{
    int expectedModCount;
    boolean nextCalled;
    int index;
    final /* synthetic */ CompactHashSet this$0;
    
    CompactHashSet$1(final CompactHashSet this$0) {
        this.this$0 = this$0;
        this.expectedModCount = this.this$0.modCount;
        this.nextCalled = false;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.this$0.size;
    }
    
    @Override
    public Object next() {
        this.checkForConcurrentModification();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.nextCalled = true;
        return this.this$0.elements[this.index++];
    }
    
    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.nextCalled);
        ++this.expectedModCount;
        --this.index;
        this.this$0.remove(this.this$0.elements[this.index], getHash(this.this$0.entries[this.index]));
        this.nextCalled = false;
    }
    
    private void checkForConcurrentModification() {
        if (this.this$0.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}
