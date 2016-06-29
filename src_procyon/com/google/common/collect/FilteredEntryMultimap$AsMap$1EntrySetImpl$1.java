package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class FilteredEntryMultimap$AsMap$1EntrySetImpl$1 extends AbstractIterator
{
    final Iterator backingIterator;
    final /* synthetic */ FilteredEntryMultimap$AsMap$1EntrySetImpl this$2;
    
    FilteredEntryMultimap$AsMap$1EntrySetImpl$1(final FilteredEntryMultimap$AsMap$1EntrySetImpl this$2) {
        this.this$2 = this$2;
        this.backingIterator = this.this$2.this$1.this$0.unfiltered.asMap().entrySet().iterator();
    }
    
    @Override
    protected Map.Entry computeNext() {
        while (this.backingIterator.hasNext()) {
            final Map.Entry<Object, V> entry = this.backingIterator.next();
            final Object key = entry.getKey();
            final Collection filterCollection = FilteredEntryMultimap.filterCollection((Collection)entry.getValue(), new FilteredEntryMultimap$ValuePredicate(this.this$2.this$1.this$0, key));
            if (!filterCollection.isEmpty()) {
                return Maps.immutableEntry(key, filterCollection);
            }
        }
        return (Map.Entry)this.endOfData();
    }
}
