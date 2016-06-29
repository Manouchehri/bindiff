package com.google.common.collect;

import com.google.j2objc.annotations.*;
import java.util.*;

final class ImmutableMapEntrySet$RegularEntrySet extends ImmutableMapEntrySet
{
    @Weak
    private final transient ImmutableMap map;
    private final transient Map.Entry[] entries;
    
    ImmutableMapEntrySet$RegularEntrySet(final ImmutableMap map, final Map.Entry[] entries) {
        this.map = map;
        this.entries = entries;
    }
    
    @Override
    ImmutableMap map() {
        return this.map;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }
    
    @Override
    ImmutableList createAsList() {
        return new RegularImmutableAsList(this, this.entries);
    }
}
