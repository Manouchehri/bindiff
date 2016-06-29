package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

class Maps$UnmodifiableEntrySet extends Maps$UnmodifiableEntries implements Set
{
    Maps$UnmodifiableEntrySet(final Set set) {
        super(set);
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
