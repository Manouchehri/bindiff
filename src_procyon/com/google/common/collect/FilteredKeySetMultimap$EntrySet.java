package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

class FilteredKeySetMultimap$EntrySet extends FilteredKeyMultimap$Entries implements Set
{
    final /* synthetic */ FilteredKeySetMultimap this$0;
    
    FilteredKeySetMultimap$EntrySet(final FilteredKeySetMultimap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Sets.equalsImpl(this, o);
    }
}
