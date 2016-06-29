package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class Maps$FilteredEntryNavigableMap$1 extends Maps$NavigableKeySet
{
    final /* synthetic */ Maps$FilteredEntryNavigableMap this$0;
    
    Maps$FilteredEntryNavigableMap$1(final Maps$FilteredEntryNavigableMap this$0, final NavigableMap navigableMap) {
        this.this$0 = this$0;
        super(navigableMap);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return Iterators.removeIf(this.this$0.unfiltered.entrySet().iterator(), Predicates.and(this.this$0.entryPredicate, Maps.keyPredicateOnEntries(Predicates.in(collection))));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return Iterators.removeIf(this.this$0.unfiltered.entrySet().iterator(), Predicates.and(this.this$0.entryPredicate, Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection)))));
    }
}
