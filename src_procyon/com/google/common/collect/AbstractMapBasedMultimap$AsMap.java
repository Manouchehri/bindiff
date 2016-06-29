package com.google.common.collect;

import javax.annotation.*;
import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class AbstractMapBasedMultimap$AsMap extends Maps$ViewCachingAbstractMap
{
    final transient Map submap;
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$AsMap(final AbstractMapBasedMultimap this$0, final Map submap) {
        this.this$0 = this$0;
        this.submap = submap;
    }
    
    protected Set createEntrySet() {
        return new AbstractMapBasedMultimap$AsMap$AsMapEntries(this);
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return Maps.safeContainsKey(this.submap, o);
    }
    
    @Override
    public Collection get(final Object o) {
        final Collection collection = (Collection)Maps.safeGet(this.submap, o);
        if (collection == null) {
            return null;
        }
        return this.this$0.wrapCollection(o, collection);
    }
    
    @Override
    public Set keySet() {
        return this.this$0.keySet();
    }
    
    @Override
    public int size() {
        return this.submap.size();
    }
    
    @Override
    public Collection remove(final Object o) {
        final Collection collection = this.submap.remove(o);
        if (collection == null) {
            return null;
        }
        final Collection collection2 = this.this$0.createCollection();
        collection2.addAll(collection);
        this.this$0.totalSize -= collection.size();
        collection.clear();
        return collection2;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return this == o || this.submap.equals(o);
    }
    
    @Override
    public int hashCode() {
        return this.submap.hashCode();
    }
    
    @Override
    public String toString() {
        return this.submap.toString();
    }
    
    @Override
    public void clear() {
        if (this.submap == this.this$0.map) {
            this.this$0.clear();
        }
        else {
            Iterators.clear(new AbstractMapBasedMultimap$AsMap$AsMapIterator(this));
        }
    }
    
    Entry wrapEntry(final Entry entry) {
        final Object key = entry.getKey();
        return Maps.immutableEntry(key, this.this$0.wrapCollection(key, (Collection)entry.getValue()));
    }
}
