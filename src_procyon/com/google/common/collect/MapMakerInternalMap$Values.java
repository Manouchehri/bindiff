package com.google.common.collect;

import java.util.*;

final class MapMakerInternalMap$Values extends AbstractCollection
{
    final /* synthetic */ MapMakerInternalMap this$0;
    
    MapMakerInternalMap$Values(final MapMakerInternalMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$ValueIterator(this.this$0);
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
    public boolean contains(final Object o) {
        return this.this$0.containsValue(o);
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
}
