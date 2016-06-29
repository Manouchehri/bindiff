package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedListMultimap extends Synchronized$SynchronizedMultimap implements ListMultimap
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedListMultimap(final ListMultimap listMultimap, @Nullable final Object o) {
        super(listMultimap, o);
    }
    
    @Override
    ListMultimap delegate() {
        return (ListMultimap)super.delegate();
    }
    
    @Override
    public List get(final Object o) {
        synchronized (this.mutex) {
            return list(this.delegate().get(o), this.mutex);
        }
    }
    
    @Override
    public List removeAll(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().removeAll(o);
        }
    }
    
    @Override
    public List replaceValues(final Object o, final Iterable iterable) {
        synchronized (this.mutex) {
            return this.delegate().replaceValues(o, iterable);
        }
    }
}
