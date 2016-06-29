package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class Synchronized$SynchronizedSet extends Synchronized$SynchronizedCollection implements Set
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedSet(final Set set, @Nullable final Object o) {
        super(set, o, null);
    }
    
    @Override
    Set delegate() {
        return (Set)super.delegate();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        synchronized (this.mutex) {
            return this.delegate().equals(o);
        }
    }
    
    @Override
    public int hashCode() {
        synchronized (this.mutex) {
            return this.delegate().hashCode();
        }
    }
}
