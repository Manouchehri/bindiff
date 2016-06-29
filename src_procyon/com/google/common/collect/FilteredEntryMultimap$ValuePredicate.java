package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

final class FilteredEntryMultimap$ValuePredicate implements Predicate
{
    private final Object key;
    final /* synthetic */ FilteredEntryMultimap this$0;
    
    FilteredEntryMultimap$ValuePredicate(final FilteredEntryMultimap this$0, final Object key) {
        this.this$0 = this$0;
        this.key = key;
    }
    
    @Override
    public boolean apply(@Nullable final Object o) {
        return this.this$0.satisfies(this.key, o);
    }
}
