package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class Synchronized$SynchronizedSetMultimap extends Synchronized$SynchronizedMultimap implements SetMultimap
{
    transient Set entrySet;
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedSetMultimap(final SetMultimap setMultimap, @Nullable final Object o) {
        super(setMultimap, o);
    }
    
    @Override
    SetMultimap delegate() {
        return (SetMultimap)super.delegate();
    }
    
    @Override
    public Set get(final Object o) {
        synchronized (this.mutex) {
            return Synchronized.set(this.delegate().get(o), this.mutex);
        }
    }
    
    @Override
    public Set removeAll(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().removeAll(o);
        }
    }
    
    @Override
    public Set replaceValues(final Object o, final Iterable iterable) {
        synchronized (this.mutex) {
            return this.delegate().replaceValues(o, iterable);
        }
    }
    
    @Override
    public Set entries() {
        synchronized (this.mutex) {
            if (this.entrySet == null) {
                this.entrySet = Synchronized.set(this.delegate().entries(), this.mutex);
            }
            return this.entrySet;
        }
    }
}
