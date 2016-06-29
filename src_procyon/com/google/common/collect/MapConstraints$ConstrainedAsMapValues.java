package com.google.common.collect;

import java.util.*;

class MapConstraints$ConstrainedAsMapValues extends ForwardingCollection
{
    final Collection delegate;
    final Set entrySet;
    
    MapConstraints$ConstrainedAsMapValues(final Collection delegate, final Set entrySet) {
        this.delegate = delegate;
        this.entrySet = entrySet;
    }
    
    @Override
    protected Collection delegate() {
        return this.delegate;
    }
    
    @Override
    public Iterator iterator() {
        return new MapConstraints$ConstrainedAsMapValues$1(this, this.entrySet.iterator());
    }
    
    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.standardToArray(array);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.standardContains(o);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return this.standardContainsAll(collection);
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.standardRemove(o);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.standardRemoveAll(collection);
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.standardRetainAll(collection);
    }
}
