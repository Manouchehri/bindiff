package com.google.common.collect;

import java.util.*;

abstract class Multisets$ElementSet extends Sets$ImprovedAbstractSet
{
    abstract Multiset multiset();
    
    @Override
    public void clear() {
        this.multiset().clear();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.multiset().contains(o);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return this.multiset().containsAll(collection);
    }
    
    @Override
    public boolean isEmpty() {
        return this.multiset().isEmpty();
    }
    
    @Override
    public Iterator iterator() {
        return new Multisets$ElementSet$1(this, this.multiset().entrySet().iterator());
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.multiset().remove(o, Integer.MAX_VALUE) > 0;
    }
    
    @Override
    public int size() {
        return this.multiset().entrySet().size();
    }
}
