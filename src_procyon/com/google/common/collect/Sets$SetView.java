package com.google.common.collect;

import java.util.*;

public abstract class Sets$SetView extends AbstractSet
{
    public ImmutableSet immutableCopy() {
        return ImmutableSet.copyOf(this);
    }
    
    public Set copyInto(final Set set) {
        set.addAll(this);
        return set;
    }
}
