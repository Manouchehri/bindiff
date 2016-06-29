package com.google.common.cache;

import javax.annotation.*;

class LocalCache$StrongEntry extends LocalCache$AbstractReferenceEntry
{
    final Object key;
    final int hash;
    final LocalCache$ReferenceEntry next;
    volatile LocalCache$ValueReference valueReference;
    
    LocalCache$StrongEntry(final Object key, final int hash, @Nullable final LocalCache$ReferenceEntry next) {
        this.valueReference = LocalCache.unset();
        this.key = key;
        this.hash = hash;
        this.next = next;
    }
    
    @Override
    public Object getKey() {
        return this.key;
    }
    
    @Override
    public LocalCache$ValueReference getValueReference() {
        return this.valueReference;
    }
    
    @Override
    public void setValueReference(final LocalCache$ValueReference valueReference) {
        this.valueReference = valueReference;
    }
    
    @Override
    public int getHash() {
        return this.hash;
    }
    
    @Override
    public LocalCache$ReferenceEntry getNext() {
        return this.next;
    }
}
