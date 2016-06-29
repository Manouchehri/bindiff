package com.google.common.collect;

import java.util.*;

final class MapMakerInternalMap$EntryIterator extends MapMakerInternalMap$HashIterator
{
    final /* synthetic */ MapMakerInternalMap this$0;
    
    MapMakerInternalMap$EntryIterator(final MapMakerInternalMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Map.Entry next() {
        return this.nextEntry();
    }
}
