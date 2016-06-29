package com.google.common.collect;

import com.google.j2objc.annotations.*;
import javax.annotation.*;
import java.util.*;

class Multimaps$Keys extends AbstractMultiset
{
    @Weak
    final Multimap multimap;
    
    Multimaps$Keys(final Multimap multimap) {
        this.multimap = multimap;
    }
    
    @Override
    Iterator entryIterator() {
        return new Multimaps$Keys$1(this, this.multimap.asMap().entrySet().iterator());
    }
    
    @Override
    int distinctElements() {
        return this.multimap.asMap().size();
    }
    
    @Override
    Set createEntrySet() {
        return new Multimaps$Keys$KeysEntrySet(this);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.multimap.containsKey(o);
    }
    
    @Override
    public Iterator iterator() {
        return Maps.keyIterator(this.multimap.entries().iterator());
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final Collection collection = (Collection)Maps.safeGet(this.multimap.asMap(), o);
        return (collection == null) ? 0 : collection.size();
    }
    
    @Override
    public int remove(@Nullable final Object o, final int n) {
        CollectPreconditions.checkNonnegative(n, "occurrences");
        if (n == 0) {
            return this.count(o);
        }
        final Collection collection = (Collection)Maps.safeGet(this.multimap.asMap(), o);
        if (collection == null) {
            return 0;
        }
        final int size = collection.size();
        if (n >= size) {
            collection.clear();
        }
        else {
            final Iterator iterator = collection.iterator();
            for (int i = 0; i < n; ++i) {
                iterator.next();
                iterator.remove();
            }
        }
        return size;
    }
    
    @Override
    public void clear() {
        this.multimap.clear();
    }
    
    @Override
    public Set elementSet() {
        return this.multimap.keySet();
    }
}
