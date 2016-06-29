package com.google.common.collect;

import java.util.*;

class Maps$IteratorBasedAbstractMap$1 extends Maps$EntrySet
{
    final /* synthetic */ Maps$IteratorBasedAbstractMap this$0;
    
    Maps$IteratorBasedAbstractMap$1(final Maps$IteratorBasedAbstractMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Map map() {
        return this.this$0;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }
}
