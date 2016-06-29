package com.google.common.cache;

abstract class LocalCache$AbstractReferenceEntry implements LocalCache$ReferenceEntry
{
    @Override
    public LocalCache$ValueReference getValueReference() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setValueReference(final LocalCache$ValueReference localCache$ValueReference) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public LocalCache$ReferenceEntry getNext() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int getHash() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object getKey() {
        throw new UnsupportedOperationException();
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
}
