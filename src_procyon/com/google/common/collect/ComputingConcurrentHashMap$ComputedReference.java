package com.google.common.collect;

import javax.annotation.*;
import java.lang.ref.*;

final class ComputingConcurrentHashMap$ComputedReference implements MapMakerInternalMap$ValueReference
{
    final Object value;
    
    ComputingConcurrentHashMap$ComputedReference(@Nullable final Object value) {
        this.value = value;
    }
    
    @Override
    public Object get() {
        return this.value;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getEntry() {
        return null;
    }
    
    @Override
    public MapMakerInternalMap$ValueReference copyFor(final ReferenceQueue referenceQueue, final Object o, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this;
    }
    
    @Override
    public boolean isComputingReference() {
        return false;
    }
    
    @Override
    public Object waitForValue() {
        return this.get();
    }
    
    @Override
    public void clear(final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
    }
}
