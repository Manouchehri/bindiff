package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

class AbstractMultimap$EntrySet extends AbstractMultimap$Entries implements Set
{
    final /* synthetic */ AbstractMultimap this$0;
    
    private AbstractMultimap$EntrySet(final AbstractMultimap this$0) {
        this.this$0 = this$0;
        super(this$0, null);
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
