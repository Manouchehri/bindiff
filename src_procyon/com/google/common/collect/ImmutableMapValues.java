package com.google.common.collect;

import com.google.j2objc.annotations.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
final class ImmutableMapValues extends ImmutableCollection
{
    @Weak
    private final ImmutableMap map;
    
    ImmutableMapValues(final ImmutableMap map) {
        this.map = map;
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return new ImmutableMapValues$1(this);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return o != null && Iterators.contains(this.iterator(), o);
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
    
    @Override
    ImmutableList createAsList() {
        return new ImmutableMapValues$2(this, this.map.entrySet().asList());
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new ImmutableMapValues$SerializedForm(this.map);
    }
}
