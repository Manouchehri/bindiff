package com.google.common.collect;

import java.util.*;

abstract class ImmutableSet$Indexed extends ImmutableSet
{
    abstract Object get(final int p0);
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }
    
    @Override
    ImmutableList createAsList() {
        return new ImmutableSet$Indexed$1(this);
    }
}
