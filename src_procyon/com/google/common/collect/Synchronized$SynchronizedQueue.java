package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class Synchronized$SynchronizedQueue extends Synchronized$SynchronizedCollection implements Queue
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedQueue(final Queue queue, @Nullable final Object o) {
        super(queue, o, null);
    }
    
    @Override
    Queue delegate() {
        return (Queue)super.delegate();
    }
    
    @Override
    public Object element() {
        synchronized (this.mutex) {
            return this.delegate().element();
        }
    }
    
    @Override
    public boolean offer(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().offer(o);
        }
    }
    
    @Override
    public Object peek() {
        synchronized (this.mutex) {
            return this.delegate().peek();
        }
    }
    
    @Override
    public Object poll() {
        synchronized (this.mutex) {
            return this.delegate().poll();
        }
    }
    
    @Override
    public Object remove() {
        synchronized (this.mutex) {
            return this.delegate().remove();
        }
    }
}
