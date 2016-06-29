package com.google.common.collect;

import java.util.*;

class Maps$UnmodifiableEntries extends ForwardingCollection
{
    private final Collection entries;
    
    Maps$UnmodifiableEntries(final Collection entries) {
        this.entries = entries;
    }
    
    @Override
    protected Collection delegate() {
        return this.entries;
    }
    
    @Override
    public Iterator iterator() {
        return Maps.unmodifiableEntryIterator(this.entries.iterator());
    }
    
    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.standardToArray(array);
    }
}
