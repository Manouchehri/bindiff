package com.google.common.collect;

import java.lang.ref.*;
import javax.annotation.*;

final class MapMakerInternalMap$1 implements MapMakerInternalMap$ValueReference
{
    @Override
    public Object get() {
        return null;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getEntry() {
        return null;
    }
    
    @Override
    public MapMakerInternalMap$ValueReference copyFor(final ReferenceQueue referenceQueue, @Nullable final Object o, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this;
    }
    
    @Override
    public boolean isComputingReference() {
        return false;
    }
    
    @Override
    public Object waitForValue() {
        return null;
    }
    
    @Override
    public void clear(final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
    }
}
