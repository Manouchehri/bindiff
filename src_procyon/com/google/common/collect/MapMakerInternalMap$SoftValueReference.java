package com.google.common.collect;

import java.lang.ref.*;

final class MapMakerInternalMap$SoftValueReference extends SoftReference implements MapMakerInternalMap$ValueReference
{
    final MapMakerInternalMap$ReferenceEntry entry;
    
    MapMakerInternalMap$SoftValueReference(final ReferenceQueue referenceQueue, final Object o, final MapMakerInternalMap$ReferenceEntry entry) {
        super(o, referenceQueue);
        this.entry = entry;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getEntry() {
        return this.entry;
    }
    
    @Override
    public void clear(final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        this.clear();
    }
    
    @Override
    public MapMakerInternalMap$ValueReference copyFor(final ReferenceQueue referenceQueue, final Object o, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return new MapMakerInternalMap$SoftValueReference(referenceQueue, o, mapMakerInternalMap$ReferenceEntry);
    }
    
    @Override
    public boolean isComputingReference() {
        return false;
    }
    
    @Override
    public Object waitForValue() {
        return this.get();
    }
}
