package com.google.common.collect;

import java.lang.ref.*;
import java.util.concurrent.*;

final class ComputingConcurrentHashMap$ComputationExceptionReference implements MapMakerInternalMap$ValueReference
{
    final Throwable t;
    
    ComputingConcurrentHashMap$ComputationExceptionReference(final Throwable t) {
        this.t = t;
    }
    
    @Override
    public Object get() {
        return null;
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
        throw new ExecutionException(this.t);
    }
    
    @Override
    public void clear(final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
    }
}
