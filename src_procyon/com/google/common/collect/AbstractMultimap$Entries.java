package com.google.common.collect;

import java.util.*;

class AbstractMultimap$Entries extends Multimaps$Entries
{
    final /* synthetic */ AbstractMultimap this$0;
    
    private AbstractMultimap$Entries(final AbstractMultimap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    Multimap multimap() {
        return this.this$0;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.entryIterator();
    }
}
