package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;

abstract class HashBiMap$Itr implements Iterator
{
    HashBiMap$BiEntry next;
    HashBiMap$BiEntry toRemove;
    int expectedModCount;
    final /* synthetic */ HashBiMap this$0;
    
    HashBiMap$Itr(final HashBiMap this$0) {
        this.this$0 = this$0;
        this.next = this.this$0.firstInKeyInsertionOrder;
        this.toRemove = null;
        this.expectedModCount = this.this$0.modCount;
    }
    
    @Override
    public boolean hasNext() {
        if (this.this$0.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
        return this.next != null;
    }
    
    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        final HashBiMap$BiEntry next = this.next;
        this.next = next.nextInKeyInsertionOrder;
        this.toRemove = next;
        return this.output(next);
    }
    
    @Override
    public void remove() {
        if (this.this$0.modCount != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$0.delete(this.toRemove);
        this.expectedModCount = this.this$0.modCount;
        this.toRemove = null;
    }
    
    abstract Object output(final HashBiMap$BiEntry p0);
}
