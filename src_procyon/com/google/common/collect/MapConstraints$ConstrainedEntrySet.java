package com.google.common.collect;

import java.util.*;
import javax.annotation.*;

class MapConstraints$ConstrainedEntrySet extends MapConstraints$ConstrainedEntries implements Set
{
    MapConstraints$ConstrainedEntrySet(final Set set, final MapConstraint mapConstraint) {
        super(set, mapConstraint);
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
