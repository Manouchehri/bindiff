package com.google.common.collect;

interface MapMakerInternalMap$ReferenceEntry
{
    MapMakerInternalMap$ValueReference getValueReference();
    
    void setValueReference(final MapMakerInternalMap$ValueReference p0);
    
    MapMakerInternalMap$ReferenceEntry getNext();
    
    int getHash();
    
    Object getKey();
    
    long getExpirationTime();
    
    void setExpirationTime(final long p0);
    
    MapMakerInternalMap$ReferenceEntry getNextExpirable();
    
    void setNextExpirable(final MapMakerInternalMap$ReferenceEntry p0);
    
    MapMakerInternalMap$ReferenceEntry getPreviousExpirable();
    
    void setPreviousExpirable(final MapMakerInternalMap$ReferenceEntry p0);
    
    MapMakerInternalMap$ReferenceEntry getNextEvictable();
    
    void setNextEvictable(final MapMakerInternalMap$ReferenceEntry p0);
    
    MapMakerInternalMap$ReferenceEntry getPreviousEvictable();
    
    void setPreviousEvictable(final MapMakerInternalMap$ReferenceEntry p0);
}
