package com.google.common.cache;

import java.lang.ref.*;
import javax.annotation.*;

final class LocalCache$WeakWriteEntry extends LocalCache$WeakEntry
{
    volatile long writeTime;
    LocalCache$ReferenceEntry nextWrite;
    LocalCache$ReferenceEntry previousWrite;
    
    LocalCache$WeakWriteEntry(final ReferenceQueue referenceQueue, final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        super(referenceQueue, o, n, localCache$ReferenceEntry);
        this.writeTime = Long.MAX_VALUE;
        this.nextWrite = LocalCache.nullEntry();
        this.previousWrite = LocalCache.nullEntry();
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
