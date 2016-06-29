package com.google.common.collect;

import java.util.*;

final class MapMakerInternalMap$KeySet extends AbstractSet
{
    final /* synthetic */ MapMakerInternalMap this$0;
    
    MapMakerInternalMap$KeySet(final MapMakerInternalMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$KeyIterator(this.this$0);
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
        return this.this$0.containsKey(o);
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.this$0.remove(o) != null;
    }
    
    @Override
    public void clear() {
        this.this$0.clear();
    }
}
