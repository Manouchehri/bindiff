package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

class LinkedListMultimap$DistinctKeyIterator implements Iterator
{
    final Set seenKeys;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node current;
    int expectedModCount;
    final /* synthetic */ LinkedListMultimap this$0;
    
    private LinkedListMultimap$DistinctKeyIterator(final LinkedListMultimap this$0) {
        this.this$0 = this$0;
        this.seenKeys = Sets.newHashSetWithExpectedSize(this.this$0.keySet().size());
        this.next = this.this$0.head;
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
        return this.next != null;
    }
    
    @Override
    public Object next() {
        this.checkForConcurrentModification();
        checkElement(this.next);
        this.current = this.next;
        this.seenKeys.add(this.current.key);
        do {
            this.next = this.next.next;
        } while (this.next != null && !this.seenKeys.add(this.next.key));
        return this.current.key;
    }
    
    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.current != null);
        this.this$0.removeAllNodes(this.current.key);
        this.current = null;
        this.expectedModCount = this.this$0.modCount;
    }
}
