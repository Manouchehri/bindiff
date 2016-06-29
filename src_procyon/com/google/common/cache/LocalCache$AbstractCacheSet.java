package com.google.common.cache;

import java.util.*;
import java.util.concurrent.*;

abstract class LocalCache$AbstractCacheSet extends AbstractSet
{
    final ConcurrentMap map;
    final /* synthetic */ LocalCache this$0;
    
    LocalCache$AbstractCacheSet(final LocalCache this$0, final ConcurrentMap map) {
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
}
