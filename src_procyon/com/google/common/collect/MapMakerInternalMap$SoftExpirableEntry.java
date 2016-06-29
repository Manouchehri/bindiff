package com.google.common.collect;

import java.lang.ref.*;
import javax.annotation.*;

final class MapMakerInternalMap$SoftExpirableEntry extends MapMakerInternalMap$SoftEntry implements MapMakerInternalMap$ReferenceEntry
{
    volatile long time;
    MapMakerInternalMap$ReferenceEntry nextExpirable;
    MapMakerInternalMap$ReferenceEntry previousExpirable;
    
    MapMakerInternalMap$SoftExpirableEntry(final ReferenceQueue referenceQueue, final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(referenceQueue, o, n, mapMakerInternalMap$ReferenceEntry);
        this.time = Long.MAX_VALUE;
        this.nextExpirable = MapMakerInternalMap.nullEntry();
        this.previousExpirable = MapMakerInternalMap.nullEntry();
    }
    
    @Override
    public long getExpirationTime() {
        return this.time;
    }
    
    @Override
    public void setExpirationTime(final long time) {
        this.time = time;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        return this.nextExpirable;
    }
    
    @Override
    public void setNextExpirable(final MapMakerInternalMap$ReferenceEntry nextExpirable) {
        this.nextExpirable = nextExpirable;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        return this.previousExpirable;
    }
    
    @Override
    public void setPreviousExpirable(final MapMakerInternalMap$ReferenceEntry previousExpirable) {
        this.previousExpirable = previousExpirable;
    }
}
