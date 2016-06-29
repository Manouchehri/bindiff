package com.google.common.collect;

import com.google.j2objc.annotations.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtCompatible(emulated = true)
final class ImmutableMapKeySet extends ImmutableSet$Indexed
{
    @Weak
    private final ImmutableMap map;
    
    ImmutableMapKeySet(final ImmutableMap map) {
        this.map = map;
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return this.map.keyIterator();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    Object get(final int n) {
        return this.map.entrySet().asList().get(n).getKey();
    }
    
    @Override
    boolean isPartialView() {
        return true;
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new ImmutableMapKeySet$KeySetSerializedForm(this.map);
    }
}
