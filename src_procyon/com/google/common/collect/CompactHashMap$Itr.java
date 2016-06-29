package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;

abstract class CompactHashMap$Itr implements Iterator
{
    int expectedModCount;
    boolean nextCalled;
    int index;
    final /* synthetic */ CompactHashMap this$0;
    
    private CompactHashMap$Itr(final CompactHashMap this$0) {
        this.this$0 = this$0;
        this.expectedModCount = this.this$0.modCount;
        this.nextCalled = false;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return this.index < this.this$0.size;
    }
    
    abstract Object getOutput(final int p0);
    
    @Override
    public Object next() {
        this.checkForConcurrentModification();
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.nextCalled = true;
        return this.getOutput(this.index++);
    }
    
    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.nextCalled);
        ++this.expectedModCount;
        --this.index;
        this.this$0.removeEntry(this.index);
        this.nextCalled = false;
    }
    
    private void checkForConcurrentModification() {
        if (this.this$0.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}
