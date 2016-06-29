package com.google.common.cache;

import java.util.concurrent.*;
import java.util.*;

final class LocalCache$KeySet extends LocalCache$AbstractCacheSet
{
    final /* synthetic */ LocalCache this$0;
    
    LocalCache$KeySet(final LocalCache this$0, final ConcurrentMap concurrentMap) {
        this.this$0 = this$0;
        super(this$0, concurrentMap);
    }
    
    @Override
    public Iterator iterator() {
        return new LocalCache$KeyIterator(this.this$0);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.map.remove(o) != null;
    }
}
