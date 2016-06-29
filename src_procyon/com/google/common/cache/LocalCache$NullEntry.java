package com.google.common.cache;

enum LocalCache$NullEntry implements LocalCache$ReferenceEntry
{
    INSTANCE("INSTANCE", 0);
    
    private LocalCache$NullEntry(final String s, final int n) {
    }
    
    @Override
    public LocalCache$ValueReference getValueReference() {
        return null;
    }
    
    @Override
    public void setValueReference(final LocalCache$ValueReference localCache$ValueReference) {
    }
    
    @Override
    public LocalCache$ReferenceEntry getNext() {
        return null;
    }
    
    @Override
    public int getHash() {
        return 0;
    }
    
    @Override
    public Object getKey() {
        return null;
    }
    
    @Override
    public long getAccessTime() {
        return 0L;
    }
    
    @Override
    public void setAccessTime(final long n) {
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        return this;
    }
    
    @Override
    public void setNextInAccessQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        return this;
    }
    
    @Override
    public void setPreviousInAccessQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }
    
    @Override
    public long getWriteTime() {
        return 0L;
    }
    
    @Override
    public void setWriteTime(final long n) {
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInWriteQueue() {
        return this;
    }
    
    @Override
    public void setNextInWriteQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
        return this;
    }
    
    @Override
    public void setPreviousInWriteQueue(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
    }
}
