package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class FilteredEntryMultimap$Keys$1$1 implements Predicate
{
    final /* synthetic */ Predicate val$predicate;
    final /* synthetic */ FilteredEntryMultimap$Keys$1 this$2;
    
    FilteredEntryMultimap$Keys$1$1(final FilteredEntryMultimap$Keys$1 this$2, final Predicate val$predicate) {
        this.this$2 = this$2;
        this.val$predicate = val$predicate;
    }
    
    public boolean apply(final Map.Entry entry) {
        return this.val$predicate.apply(Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size()));
    }
}
