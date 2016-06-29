package com.google.common.collect;

import java.util.*;

final class Maps$6 extends UnmodifiableIterator
{
    final /* synthetic */ Iterator val$entryIterator;
    
    Maps$6(final Iterator val$entryIterator) {
        this.val$entryIterator = val$entryIterator;
    }
    
    @Override
    public boolean hasNext() {
        return this.val$entryIterator.hasNext();
    }
    
    @Override
    public Map.Entry next() {
        return Maps.unmodifiableEntry((Map.Entry)this.val$entryIterator.next());
    }
}
