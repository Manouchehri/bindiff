package com.google.common.cache;

import java.lang.ref.*;
import javax.annotation.*;

class LocalCache$WeakEntry extends WeakReference implements LocalCache$ReferenceEntry
{
    final int hash;
    final LocalCache$ReferenceEntry next;
    volatile LocalCache$ValueReference valueReference;
    
    LocalCache$WeakEntry(final ReferenceQueue referenceQueue, final Object o, final int hash, @Nullable final LocalCache$ReferenceEntry next) {
        super(o, referenceQueue);
        this.valueReference = LocalCache.unset();
        this.hash = hash;
        this.next = next;
    }
    
    @Override
    public Object getKey() {
        return this.get();
    }
    
    @Override
    public long getAccessTime() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setAccessTime(final long n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setNextInAccessQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setPreviousInAccessQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public long getWriteTime() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setWriteTime(final long n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInWriteQueue() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setNextInWriteQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setPreviousInWriteQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        throw new UnsupportedOperationException();
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
