package com.google.common.collect;

import java.util.*;

class Maps$FilteredEntryMap$EntrySet$1 extends TransformedIterator
{
    final /* synthetic */ Maps$FilteredEntryMap$EntrySet this$1;
    
    Maps$FilteredEntryMap$EntrySet$1(final Maps$FilteredEntryMap$EntrySet this$1, final Iterator iterator) {
        this.this$1 = this$1;
        super(iterator);
    }
    
    Map.Entry transform(final Map.Entry entry) {
        return new Maps$FilteredEntryMap$EntrySet$1$1(this, entry);
    }
}
