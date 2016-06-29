package com.google.common.cache;

import java.lang.ref.*;

class LocalCache$StrongValueReference implements LocalCache$ValueReference
{
    final Object referent;
    
    LocalCache$StrongValueReference(final Object referent) {
        this.referent = referent;
    }
    
    @Override
    public Object get() {
        return this.referent;
    }
    
    @Override
    public int getWeight() {
        return 1;
    }
    
    @Override
    public LocalCache$ReferenceEntry getEntry() {
        return null;
    }
    
    @Override
    public LocalCache$ValueReference copyFor(final ReferenceQueue referenceQueue, final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return this;
    }
    
    @Override
    public boolean isLoading() {
        return false;
    }
    
    @Override
    public boolean isActive() {
        return true;
    }
    
    @Override
    public Object waitForValue() {
        return this.get();
    }
    
    @Override
    public void notifyNewValue(final Object o) {
    }
}
