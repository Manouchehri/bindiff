package com.google.common.collect;

import java.util.*;

class MapConstraints$ConstrainedEntries extends ForwardingCollection
{
    final MapConstraint constraint;
    final Collection entries;
    
    MapConstraints$ConstrainedEntries(final Collection entries, final MapConstraint constraint) {
        this.entries = entries;
        this.constraint = constraint;
    }
    
    @Override
    protected Collection delegate() {
        return this.entries;
    }
    
    @Override
    public Iterator iterator() {
        return new MapConstraints$ConstrainedEntries$1(this, this.entries.iterator());
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
        return Maps.containsEntryImpl(this.delegate(), o);
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return this.standardContainsAll(collection);
    }
    
    @Override
    public boolean remove(final Object o) {
        return Maps.removeEntryImpl(this.delegate(), o);
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
