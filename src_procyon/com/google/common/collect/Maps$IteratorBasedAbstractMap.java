package com.google.common.collect;

import java.util.*;

abstract class Maps$IteratorBasedAbstractMap extends AbstractMap
{
    @Override
    public abstract int size();
    
    abstract Iterator entryIterator();
    
    @Override
    public Set entrySet() {
        return new Maps$IteratorBasedAbstractMap$1(this);
    }
    
    @Override
    public void clear() {
        Iterators.clear(this.entryIterator());
    }
}
