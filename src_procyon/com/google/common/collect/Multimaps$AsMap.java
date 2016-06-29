package com.google.common.collect;

import com.google.j2objc.annotations.*;
import com.google.common.base.*;
import java.util.*;

final class Multimaps$AsMap extends Maps$ViewCachingAbstractMap
{
    @Weak
    private final Multimap multimap;
    
    Multimaps$AsMap(final Multimap multimap) {
        this.multimap = (Multimap)Preconditions.checkNotNull(multimap);
    }
    
    @Override
    public int size() {
        return this.multimap.keySet().size();
    }
    
    protected Set createEntrySet() {
        return new Multimaps$AsMap$EntrySet(this);
    }
    
    void removeValuesForKey(final Object o) {
        this.multimap.keySet().remove(o);
    }
    
    @Override
    public Collection get(final Object o) {
        return this.containsKey(o) ? this.multimap.get(o) : null;
    }
    
    @Override
    public Collection remove(final Object o) {
        return this.containsKey(o) ? this.multimap.removeAll(o) : null;
    }
    
    @Override
    public Set keySet() {
        return this.multimap.keySet();
    }
    
    @Override
    public boolean isEmpty() {
        return this.multimap.isEmpty();
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.multimap.containsKey(o);
    }
    
    @Override
    public void clear() {
        this.multimap.clear();
    }
}
