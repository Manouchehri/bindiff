package com.google.common.collect;

import java.util.*;

class Maps$FilteredEntryMap$EntrySet extends ForwardingSet
{
    final /* synthetic */ Maps$FilteredEntryMap this$0;
    
    private Maps$FilteredEntryMap$EntrySet(final Maps$FilteredEntryMap this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected Set delegate() {
        return this.this$0.filteredEntrySet;
    }
    
    @Override
    public Iterator iterator() {
        return new Maps$FilteredEntryMap$EntrySet$1(this, this.this$0.filteredEntrySet.iterator());
    }
}
