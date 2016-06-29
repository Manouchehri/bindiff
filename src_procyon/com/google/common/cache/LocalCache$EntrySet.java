package com.google.common.cache;

import java.util.concurrent.*;
import java.util.*;

final class LocalCache$EntrySet extends LocalCache$AbstractCacheSet
{
    final /* synthetic */ LocalCache this$0;
    
    LocalCache$EntrySet(final LocalCache this$0, final ConcurrentMap concurrentMap) {
        this.this$0 = this$0;
        super(this$0, concurrentMap);
    }
    
    @Override
    public Iterator iterator() {
        return new LocalCache$EntryIterator(this.this$0);
    }
    
    @Override
    public boolean contains(final Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        final Map.Entry entry = (Map.Entry)o;
        final Object key = entry.getKey();
        if (key == null) {
            return false;
        }
        final Object value = this.this$0.get(key);
        return value != null && this.this$0.valueEquivalence.equivalent(entry.getValue(), value);
    }
    
    @Override
    public boolean remove(final Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        final Map.Entry entry = (Map.Entry)o;
        final Object key = entry.getKey();
        return key != null && this.this$0.remove(key, entry.getValue());
    }
}
