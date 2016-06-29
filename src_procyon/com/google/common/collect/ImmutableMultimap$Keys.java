package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class ImmutableMultimap$Keys extends ImmutableMultiset
{
    final /* synthetic */ ImmutableMultimap this$0;
    
    ImmutableMultimap$Keys(final ImmutableMultimap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.this$0.containsKey(o);
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final Collection collection = (Collection)this.this$0.map.get(o);
        return (collection == null) ? 0 : collection.size();
    }
    
    @Override
    public Set elementSet() {
        return this.this$0.keySet();
    }
    
    @Override
    public int size() {
        return this.this$0.size();
    }
    
    @Override
    Multiset$Entry getEntry(final int n) {
        final Map.Entry<Object, V> entry = this.this$0.map.entrySet().asList().get(n);
        return Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size());
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
}
