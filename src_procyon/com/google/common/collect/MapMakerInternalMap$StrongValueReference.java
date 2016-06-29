package com.google.common.collect;

import java.lang.ref.*;

final class MapMakerInternalMap$StrongValueReference implements MapMakerInternalMap$ValueReference
{
    final Object referent;
    
    MapMakerInternalMap$StrongValueReference(final Object referent) {
        this.referent = referent;
    }
    
    @Override
    public Object get() {
        return this.referent;
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
