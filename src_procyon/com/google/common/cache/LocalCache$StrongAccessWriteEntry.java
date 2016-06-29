package com.google.common.cache;

import javax.annotation.*;

final class LocalCache$StrongAccessWriteEntry extends LocalCache$StrongEntry
{
    volatile long accessTime;
    LocalCache$ReferenceEntry nextAccess;
    LocalCache$ReferenceEntry previousAccess;
    volatile long writeTime;
    LocalCache$ReferenceEntry nextWrite;
    LocalCache$ReferenceEntry previousWrite;
    
    LocalCache$StrongAccessWriteEntry(final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        super(o, n, localCache$ReferenceEntry);
        this.accessTime = Long.MAX_VALUE;
        this.nextAccess = LocalCache.nullEntry();
        this.previousAccess = LocalCache.nullEntry();
        this.writeTime = Long.MAX_VALUE;
        this.nextWrite = LocalCache.nullEntry();
        this.previousWrite = LocalCache.nullEntry();
    }
    
    @Override
    public long getAccessTime() {
        return this.accessTime;
    }
    
    @Override
    public void setAccessTime(final long accessTime) {
        this.accessTime = accessTime;
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInAccessQueue() {
        return this.nextAccess;
    }
    
    @Override
    public void setNextInAccessQueue(final LocalCache$ReferenceEntry nextAccess) {
        this.nextAccess = nextAccess;
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInAccessQueue() {
        return this.previousAccess;
    }
    
    @Override
    public void setPreviousInAccessQueue(final LocalCache$ReferenceEntry previousAccess) {
        this.previousAccess = previousAccess;
    }
    
    @Override
    public long getWriteTime() {
        return this.writeTime;
    }
    
    @Override
    public void setWriteTime(final long writeTime) {
        this.writeTime = writeTime;
    }
    
    @Override
    public LocalCache$ReferenceEntry getNextInWriteQueue() {
        return this.nextWrite;
    }
    
    @Override
    public void setNextInWriteQueue(final LocalCache$ReferenceEntry nextWrite) {
        this.nextWrite = nextWrite;
    }
    
    @Override
    public LocalCache$ReferenceEntry getPreviousInWriteQueue() {
        return this.previousWrite;
    }
    
    @Override
    public void setPreviousInWriteQueue(final LocalCache$ReferenceEntry previousWrite) {
        this.previousWrite = previousWrite;
    }
}
