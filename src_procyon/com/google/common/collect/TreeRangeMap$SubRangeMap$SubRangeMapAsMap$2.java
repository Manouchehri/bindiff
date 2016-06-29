package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2 extends Maps$EntrySet
{
    final /* synthetic */ TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;
    
    TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2) {
        this.this$2 = this$2;
    }
    
    @Override
    Map map() {
        return this.this$2;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$2.entryIterator();
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$2.removeEntryIf(Predicates.not(Predicates.in(collection)));
    }
    
    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }
    
    @Override
    public boolean isEmpty() {
        return !this.iterator().hasNext();
    }
}
