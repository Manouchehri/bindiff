package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

class LinkedListMultimap$NodeIterator implements ListIterator
{
    int nextIndex;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node current;
    LinkedListMultimap$Node previous;
    int expectedModCount;
    final /* synthetic */ LinkedListMultimap this$0;
    
    LinkedListMultimap$NodeIterator(final LinkedListMultimap this$0, int n) {
        this.this$0 = this$0;
        this.expectedModCount = this.this$0.modCount;
        final int size = this$0.size();
        Preconditions.checkPositionIndex(n, size);
        if (n >= size / 2) {
            this.previous = this$0.tail;
            this.nextIndex = size;
            while (n++ < size) {
                this.previous();
            }
        }
        else {
            this.next = this$0.head;
            while (n-- > 0) {
                this.next();
            }
        }
        this.current = null;
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
    public LinkedListMultimap$Node next() {
        this.checkForConcurrentModification();
        checkElement(this.next);
        final LinkedListMultimap$Node next = this.next;
        this.current = next;
        this.previous = next;
        this.next = this.next.next;
        ++this.nextIndex;
        return this.current;
    }
    
    @Override
    public void remove() {
        this.checkForConcurrentModification();
        CollectPreconditions.checkRemove(this.current != null);
        if (this.current != this.next) {
            this.previous = this.current.previous;
            --this.nextIndex;
        }
        else {
            this.next = this.current.next;
        }
        this.this$0.removeNode(this.current);
        this.current = null;
        this.expectedModCount = this.this$0.modCount;
    }
    
    @Override
    public boolean hasPrevious() {
        this.checkForConcurrentModification();
        return this.previous != null;
    }
    
    @Override
    public LinkedListMultimap$Node previous() {
        this.checkForConcurrentModification();
        checkElement(this.previous);
        final LinkedListMultimap$Node previous = this.previous;
        this.current = previous;
        this.next = previous;
        this.previous = this.previous.previous;
        --this.nextIndex;
        return this.current;
    }
    
    @Override
    public int nextIndex() {
        return this.nextIndex;
    }
    
    @Override
    public int previousIndex() {
        return this.nextIndex - 1;
    }
    
    public void set(final Map.Entry entry) {
        throw new UnsupportedOperationException();
    }
    
    public void add(final Map.Entry entry) {
        throw new UnsupportedOperationException();
    }
    
    void setValue(final Object value) {
        Preconditions.checkState(this.current != null);
        this.current.value = value;
    }
}
