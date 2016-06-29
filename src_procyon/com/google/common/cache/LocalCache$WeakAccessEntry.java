package com.google.common.cache;

import java.lang.ref.*;
import javax.annotation.*;

final class LocalCache$WeakAccessEntry extends LocalCache$WeakEntry
{
    volatile long accessTime;
    LocalCache$ReferenceEntry nextAccess;
    LocalCache$ReferenceEntry previousAccess;
    
    LocalCache$WeakAccessEntry(final ReferenceQueue referenceQueue, final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        super(referenceQueue, o, n, localCache$ReferenceEntry);
        this.accessTime = Long.MAX_VALUE;
        this.nextAccess = LocalCache.nullEntry();
        this.previousAccess = LocalCache.nullEntry();
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
}
