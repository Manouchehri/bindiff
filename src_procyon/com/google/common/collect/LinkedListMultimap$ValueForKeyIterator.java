package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.io.*;
import java.util.*;

class LinkedListMultimap$ValueForKeyIterator implements ListIterator
{
    final Object key;
    int nextIndex;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node current;
    LinkedListMultimap$Node previous;
    final /* synthetic */ LinkedListMultimap this$0;
    
    LinkedListMultimap$ValueForKeyIterator(final LinkedListMultimap this$0, @Nullable final Object key) {
        this.this$0 = this$0;
        this.key = key;
        final LinkedListMultimap$KeyList list = this$0.keyToKeyList.get(key);
        this.next = ((list == null) ? null : list.head);
    }
    
    public LinkedListMultimap$ValueForKeyIterator(final LinkedListMultimap this$0, @Nullable final Object key, int n) {
        this.this$0 = this$0;
        final LinkedListMultimap$KeyList list = this$0.keyToKeyList.get(key);
        final int nextIndex = (list == null) ? 0 : list.count;
        Preconditions.checkPositionIndex(n, nextIndex);
        if (n >= nextIndex / 2) {
            this.previous = ((list == null) ? null : list.tail);
            this.nextIndex = nextIndex;
            while (n++ < nextIndex) {
                this.previous();
            }
        }
        else {
            this.next = ((list == null) ? null : list.head);
            while (n-- > 0) {
                this.next();
            }
        }
        this.key = key;
        this.current = null;
    }
    
    @Override
    public boolean hasNext() {
        return this.next != null;
    }
    
    @Override
    public Object next() {
        checkElement(this.next);
        final LinkedListMultimap$Node next = this.next;
        this.current = next;
        this.previous = next;
        this.next = this.next.nextSibling;
        ++this.nextIndex;
        return this.current.value;
    }
    
    @Override
    public boolean hasPrevious() {
        return this.previous != null;
    }
    
    @Override
    public Object previous() {
        checkElement(this.previous);
        final LinkedListMultimap$Node previous = this.previous;
        this.current = previous;
        this.next = previous;
        this.previous = this.previous.previousSibling;
        --this.nextIndex;
        return this.current.value;
    }
    
    @Override
    public int nextIndex() {
        return this.nextIndex;
    }
    
    @Override
    public int previousIndex() {
        return this.nextIndex - 1;
    }
    
    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.current != null);
        if (this.current != this.next) {
            this.previous = this.current.previousSibling;
            --this.nextIndex;
        }
        else {
            this.next = this.current.nextSibling;
        }
        this.this$0.removeNode(this.current);
        this.current = null;
    }
    
    @Override
    public void set(final Object value) {
        Preconditions.checkState(this.current != null);
        this.current.value = value;
    }
    
    @Override
    public void add(final Object o) {
        this.previous = this.this$0.addNode(this.key, o, this.next);
        ++this.nextIndex;
        this.current = null;
    }
}
