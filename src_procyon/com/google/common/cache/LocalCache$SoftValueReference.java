package com.google.common.cache;

import java.lang.ref.*;

class LocalCache$SoftValueReference extends SoftReference implements LocalCache$ValueReference
{
    final LocalCache$ReferenceEntry entry;
    
    LocalCache$SoftValueReference(final ReferenceQueue referenceQueue, final Object o, final LocalCache$ReferenceEntry entry) {
        super(o, referenceQueue);
        this.entry = entry;
    }
    
    @Override
    public int getWeight() {
        return 1;
    }
    
    @Override
    public LocalCache$ReferenceEntry getEntry() {
        return this.entry;
    }
    
    @Override
    public void notifyNewValue(final Object o) {
    }
    
    @Override
    public LocalCache$ValueReference copyFor(final ReferenceQueue referenceQueue, final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$SoftValueReference(referenceQueue, o, localCache$ReferenceEntry);
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
}
