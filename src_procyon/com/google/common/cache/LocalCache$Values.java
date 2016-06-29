package com.google.common.cache;

import java.util.concurrent.*;
import java.util.*;

final class LocalCache$Values extends AbstractCollection
{
    private final ConcurrentMap map;
    final /* synthetic */ LocalCache this$0;
    
    LocalCache$Values(final LocalCache this$0, final ConcurrentMap map) {
        this.this$0 = this$0;
        this.map = map;
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    @Override
    public void clear() {
        this.map.clear();
    }
    
    @Override
    public Iterator iterator() {
        return new LocalCache$ValueIterator(this.this$0);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.map.containsValue(o);
    }
}
