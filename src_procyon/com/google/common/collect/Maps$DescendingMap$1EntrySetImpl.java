package com.google.common.collect;

import java.util.*;

class Maps$DescendingMap$1EntrySetImpl extends Maps$EntrySet
{
    final /* synthetic */ Maps$DescendingMap this$0;
    
    Maps$DescendingMap$1EntrySetImpl(final Maps$DescendingMap this$0) {
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
