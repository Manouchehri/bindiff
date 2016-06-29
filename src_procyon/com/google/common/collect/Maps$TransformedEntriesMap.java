package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Maps$TransformedEntriesMap extends Maps$IteratorBasedAbstractMap
{
    final Map fromMap;
    final Maps$EntryTransformer transformer;
    
    Maps$TransformedEntriesMap(final Map map, final Maps$EntryTransformer maps$EntryTransformer) {
        this.fromMap = (Map)Preconditions.checkNotNull(map);
        this.transformer = (Maps$EntryTransformer)Preconditions.checkNotNull(maps$EntryTransformer);
    }
    
    @Override
    public int size() {
        return this.fromMap.size();
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.fromMap.containsKey(o);
    }
    
    @Override
    public Object get(final Object o) {
        final Object value = this.fromMap.get(o);
        return (value != null || this.fromMap.containsKey(o)) ? this.transformer.transformEntry(o, value) : null;
    }
    
    @Override
    public Object remove(final Object o) {
        return this.fromMap.containsKey(o) ? this.transformer.transformEntry(o, this.fromMap.remove(o)) : null;
    }
    
    @Override
    public void clear() {
        this.fromMap.clear();
    }
    
    @Override
    public Set keySet() {
        return this.fromMap.keySet();
    }
    
    @Override
    Iterator entryIterator() {
        return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
    }
    
    @Override
    public Collection values() {
        return new Maps$Values(this);
    }
}
