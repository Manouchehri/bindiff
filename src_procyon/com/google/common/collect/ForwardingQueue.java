package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible
public abstract class ForwardingQueue extends ForwardingCollection implements Queue
{
    @Override
    protected abstract Queue delegate();
    
    @Override
    public boolean offer(final Object o) {
        return this.delegate().offer(o);
    }
    
    @Override
    public Object poll() {
        return this.delegate().poll();
    }
    
    @Override
    public Object remove() {
        return this.delegate().remove();
    }
    
    @Override
    public Object peek() {
        return this.delegate().peek();
    }
    
    @Override
    public Object element() {
        return this.delegate().element();
    }
    
    protected boolean standardOffer(final Object o) {
        try {
            return this.add(o);
        }
        catch (IllegalStateException ex) {
            return false;
        }
    }
    
    protected Object standardPeek() {
        try {
            return this.element();
        }
        catch (NoSuchElementException ex) {
            return null;
        }
    }
    
    protected Object standardPoll() {
        try {
            return this.remove();
        }
        catch (NoSuchElementException ex) {
            return null;
        }
    }
}
