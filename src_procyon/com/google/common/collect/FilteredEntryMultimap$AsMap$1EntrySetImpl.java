package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class FilteredEntryMultimap$AsMap$1EntrySetImpl extends Maps$EntrySet
{
    final /* synthetic */ FilteredEntryMultimap$AsMap this$1;
    
    FilteredEntryMultimap$AsMap$1EntrySetImpl(final FilteredEntryMultimap$AsMap this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    Map map() {
        return this.this$1;
    }
    
    @Override
    public Iterator iterator() {
        return new FilteredEntryMultimap$AsMap$1EntrySetImpl$1(this);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Predicates.in(collection));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Predicates.not(Predicates.in(collection)));
    }
    
    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }
}
