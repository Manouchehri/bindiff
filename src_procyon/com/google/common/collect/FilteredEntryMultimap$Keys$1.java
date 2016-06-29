package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class FilteredEntryMultimap$Keys$1 extends Multisets$EntrySet
{
    final /* synthetic */ FilteredEntryMultimap$Keys this$1;
    
    FilteredEntryMultimap$Keys$1(final FilteredEntryMultimap$Keys this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    Multiset multiset() {
        return this.this$1;
    }
    
    @Override
    public Iterator iterator() {
        return this.this$1.entryIterator();
    }
    
    @Override
    public int size() {
        return this.this$1.this$0.keySet().size();
    }
    
    private boolean removeEntriesIf(final Predicate predicate) {
        return this.this$1.this$0.removeEntriesIf(new FilteredEntryMultimap$Keys$1$1(this, predicate));
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.removeEntriesIf(Predicates.in(collection));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.removeEntriesIf(Predicates.not(Predicates.in(collection)));
    }
}
