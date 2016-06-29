package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

class Sets$FilteredSet extends Collections2$FilteredCollection implements Set
{
    Sets$FilteredSet(final Set set, final Predicate predicate) {
        super(set, predicate);
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Sets.equalsImpl(this, o);
    }
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
}
