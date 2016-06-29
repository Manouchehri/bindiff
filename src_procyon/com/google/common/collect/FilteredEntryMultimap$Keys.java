package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class FilteredEntryMultimap$Keys extends Multimaps$Keys
{
    final /* synthetic */ FilteredEntryMultimap this$0;
    
    FilteredEntryMultimap$Keys(final FilteredEntryMultimap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public int remove(@Nullable final Object o, final int n) {
        CollectPreconditions.checkNonnegative(n, "occurrences");
        if (n == 0) {
            return this.count(o);
        }
        final Collection<Object> collection = this.this$0.unfiltered.asMap().get(o);
        if (collection == null) {
            return 0;
        }
        int n2 = 0;
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (this.this$0.satisfies(o, iterator.next()) && ++n2 <= n) {
                iterator.remove();
            }
        }
        return n2;
    }
    
    @Override
    public Set entrySet() {
        return new FilteredEntryMultimap$Keys$1(this);
    }
}
