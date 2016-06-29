package com.google.common.collect;

import java.util.*;

final class MapMakerInternalMap$EntrySet extends AbstractSet
{
    final /* synthetic */ MapMakerInternalMap this$0;
    
    MapMakerInternalMap$EntrySet(final MapMakerInternalMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$EntryIterator(this.this$0);
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
    
    @Override
    public int size() {
        return this.this$0.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
}
