package com.google.common.collect;

import com.google.j2objc.annotations.*;
import com.google.common.base.*;
import java.util.*;

class Maps$KeySet extends Sets$ImprovedAbstractSet
{
    @Weak
    final Map map;
    
    Maps$KeySet(final Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }
    
    Map map() {
        return this.map;
    }
    
    @Override
    public Iterator iterator() {
        return Maps.keyIterator(this.map().entrySet().iterator());
    }
    
    @Override
    public int size() {
        return this.map().size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.map().isEmpty();
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.map().containsKey(o);
    }
    
    @Override
    public boolean remove(final Object o) {
        if (this.contains(o)) {
            this.map().remove(o);
            return true;
        }
        return false;
    }
    
    @Override
    public void clear() {
        this.map().clear();
    }
}
