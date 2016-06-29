package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.io.*;
import java.util.*;

class LinkedListMultimap$1KeySetImpl extends Sets$ImprovedAbstractSet
{
    final /* synthetic */ LinkedListMultimap this$0;
    
    LinkedListMultimap$1KeySetImpl(final LinkedListMultimap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public int size() {
        return this.this$0.keyToKeyList.size();
    }
    
    @Override
    public Iterator iterator() {
        return new LinkedListMultimap$DistinctKeyIterator(this.this$0, null);
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.this$0.containsKey(o);
    }
    
    @Override
    public boolean remove(final Object o) {
        return !this.this$0.removeAll(o).isEmpty();
    }
}
