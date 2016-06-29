package com.google.common.collect;

import javax.annotation.*;
import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class AbstractMapBasedMultimap$KeySet extends Maps$KeySet
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$KeySet(final AbstractMapBasedMultimap this$0, final Map map) {
        this.this$0 = this$0;
        super(map);
    }
    
    @Override
    public Iterator iterator() {
        return new AbstractMapBasedMultimap$KeySet$1(this, this.map().entrySet().iterator());
    }
    
    @Override
    public boolean remove(final Object o) {
        int size = 0;
        final Collection collection = this.map().remove(o);
        if (collection != null) {
            size = collection.size();
            collection.clear();
            this.this$0.totalSize -= size;
        }
        return size > 0;
    }
    
    @Override
    public void clear() {
        Iterators.clear(this.iterator());
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return this.map().keySet().containsAll(collection);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return this == o || this.map().keySet().equals(o);
    }
    
    @Override
    public int hashCode() {
        return this.map().keySet().hashCode();
    }
}
