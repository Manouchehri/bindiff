package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Maps$FilteredEntryMap$KeySet extends Maps$KeySet
{
    final /* synthetic */ Maps$FilteredEntryMap this$0;
    
    Maps$FilteredEntryMap$KeySet(final Maps$FilteredEntryMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public boolean remove(final Object o) {
        if (this.this$0.containsKey(o)) {
            this.this$0.unfiltered.remove(o);
            return true;
        }
        return false;
    }
    
    private boolean removeIf(final Predicate predicate) {
        return Iterables.removeIf(this.this$0.unfiltered.entrySet(), Predicates.and(this.this$0.predicate, Maps.keyPredicateOnEntries(predicate)));
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.removeIf(Predicates.in(collection));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.removeIf(Predicates.not(Predicates.in(collection)));
    }
    
    @Override
    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return Lists.newArrayList(this.iterator()).toArray(array);
    }
}
