package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtIncompatible("Deque")
final class Synchronized$SynchronizedDeque extends Synchronized$SynchronizedQueue implements Deque
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedDeque(final Deque deque, @Nullable final Object o) {
        super(deque, o);
    }
    
    @Override
    Deque delegate() {
        return (Deque)super.delegate();
    }
    
    @Override
    public void addFirst(final Object o) {
        synchronized (this.mutex) {
            this.delegate().addFirst(o);
        }
    }
    
    @Override
    public void addLast(final Object o) {
        synchronized (this.mutex) {
            this.delegate().addLast(o);
        }
    }
    
    @Override
    public boolean offerFirst(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().offerFirst(o);
        }
    }
    
    @Override
    public boolean offerLast(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().offerLast(o);
        }
    }
    
    @Override
    public Object removeFirst() {
        synchronized (this.mutex) {
            return this.delegate().removeFirst();
        }
    }
    
    @Override
    public Object removeLast() {
        synchronized (this.mutex) {
            return this.delegate().removeLast();
        }
    }
    
    @Override
    public Object pollFirst() {
        synchronized (this.mutex) {
            return this.delegate().pollFirst();
        }
    }
    
    @Override
    public Object pollLast() {
        synchronized (this.mutex) {
            return this.delegate().pollLast();
        }
    }
    
    @Override
    public Object getFirst() {
        synchronized (this.mutex) {
            return this.delegate().getFirst();
        }
    }
    
    @Override
    public Object getLast() {
        synchronized (this.mutex) {
            return this.delegate().getLast();
        }
    }
    
    @Override
    public Object peekFirst() {
        synchronized (this.mutex) {
            return this.delegate().peekFirst();
        }
    }
    
    @Override
    public Object peekLast() {
        synchronized (this.mutex) {
            return this.delegate().peekLast();
        }
    }
    
    @Override
    public boolean removeFirstOccurrence(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().removeFirstOccurrence(o);
        }
    }
    
    @Override
    public boolean removeLastOccurrence(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().removeLastOccurrence(o);
        }
    }
    
    @Override
    public void push(final Object o) {
        synchronized (this.mutex) {
            this.delegate().push(o);
        }
    }
    
    @Override
    public Object pop() {
        synchronized (this.mutex) {
            return this.delegate().pop();
        }
    }
    
    @Override
    public Iterator descendingIterator() {
        synchronized (this.mutex) {
            return this.delegate().descendingIterator();
        }
    }
}
