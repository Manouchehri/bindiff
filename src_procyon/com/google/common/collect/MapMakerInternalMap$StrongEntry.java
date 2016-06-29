package com.google.common.collect;

import javax.annotation.*;

class MapMakerInternalMap$StrongEntry implements MapMakerInternalMap$ReferenceEntry
{
    final Object key;
    final int hash;
    final MapMakerInternalMap$ReferenceEntry next;
    volatile MapMakerInternalMap$ValueReference valueReference;
    
    MapMakerInternalMap$StrongEntry(final Object key, final int hash, @Nullable final MapMakerInternalMap$ReferenceEntry next) {
        this.valueReference = MapMakerInternalMap.unset();
        this.key = key;
        this.hash = hash;
        this.next = next;
    }
    
    @Override
    public Object getKey() {
        return this.key;
    }
    
    @Override
    public long getExpirationTime() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setExpirationTime(final long n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setNextExpirable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setPreviousExpirable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setNextEvictable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setPreviousEvictable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public MapMakerInternalMap$ValueReference getValueReference() {
        return this.valueReference;
    }
    
    @Override
    public void setValueReference(final MapMakerInternalMap$ValueReference valueReference) {
        this.valueReference.clear(this.valueReference = valueReference);
    }
    
    @Override
    public int getHash() {
        return this.hash;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNext() {
        return this.next;
    }
}
