package com.google.common.cache;

import javax.annotation.*;

interface LocalCache$ReferenceEntry
{
    LocalCache$ValueReference getValueReference();
    
    void setValueReference(final LocalCache$ValueReference p0);
    
    @Nullable
    LocalCache$ReferenceEntry getNext();
    
    int getHash();
    
    @Nullable
    Object getKey();
    
    long getAccessTime();
    
    void setAccessTime(final long p0);
    
    LocalCache$ReferenceEntry getNextInAccessQueue();
    
    void setNextInAccessQueue(final LocalCache$ReferenceEntry p0);
    
    LocalCache$ReferenceEntry getPreviousInAccessQueue();
    
    void setPreviousInAccessQueue(final LocalCache$ReferenceEntry p0);
    
    long getWriteTime();
    
    void setWriteTime(final long p0);
    
    LocalCache$ReferenceEntry getNextInWriteQueue();
    
    void setNextInWriteQueue(final LocalCache$ReferenceEntry p0);
    
    LocalCache$ReferenceEntry getPreviousInWriteQueue();
    
    void setPreviousInWriteQueue(final LocalCache$ReferenceEntry p0);
}
