package com.google.common.cache;

import java.lang.ref.*;
import javax.annotation.*;

final class LocalCache$1 implements LocalCache$ValueReference
{
    @Override
    public Object get() {
        return null;
    }
    
    @Override
    public int getWeight() {
        return 0;
    }
    
    @Override
    public LocalCache$ReferenceEntry getEntry() {
        return null;
    }
    
    @Override
    public LocalCache$ValueReference copyFor(final ReferenceQueue referenceQueue, @Nullable final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return this;
    }
    
    @Override
    public boolean isLoading() {
        return false;
    }
    
    @Override
    public boolean isActive() {
        return false;
    }
    
    @Override
    public Object waitForValue() {
        return null;
    }
    
    @Override
    public void notifyNewValue(final Object o) {
    }
}
