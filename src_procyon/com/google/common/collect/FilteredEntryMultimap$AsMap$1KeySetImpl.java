package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

class FilteredEntryMultimap$AsMap$1KeySetImpl extends Maps$KeySet
{
    final /* synthetic */ FilteredEntryMultimap$AsMap this$1;
    
    FilteredEntryMultimap$AsMap$1KeySetImpl(final FilteredEntryMultimap$AsMap this$1) {
        this.this$1 = this$1;
        super(this$1);
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(collection)));
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        return this.this$1.this$0.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }
    
    @Override
    public boolean remove(@Nullable final Object o) {
        return this.this$1.remove(o) != null;
    }
}
