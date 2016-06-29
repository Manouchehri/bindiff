package com.google.common.collect;

import javax.annotation.*;

final class MapMakerInternalMap$StrongExpirableEvictableEntry extends MapMakerInternalMap$StrongEntry implements MapMakerInternalMap$ReferenceEntry
{
    volatile long time;
    MapMakerInternalMap$ReferenceEntry nextExpirable;
    MapMakerInternalMap$ReferenceEntry previousExpirable;
    MapMakerInternalMap$ReferenceEntry nextEvictable;
    MapMakerInternalMap$ReferenceEntry previousEvictable;
    
    MapMakerInternalMap$StrongExpirableEvictableEntry(final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(o, n, mapMakerInternalMap$ReferenceEntry);
        this.time = Long.MAX_VALUE;
        this.nextExpirable = MapMakerInternalMap.nullEntry();
        this.previousExpirable = MapMakerInternalMap.nullEntry();
        this.nextEvictable = MapMakerInternalMap.nullEntry();
        this.previousEvictable = MapMakerInternalMap.nullEntry();
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
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        return this.nextEvictable;
    }
    
    @Override
    public void setNextEvictable(final MapMakerInternalMap$ReferenceEntry nextEvictable) {
        this.nextEvictable = nextEvictable;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        return this.previousEvictable;
    }
    
    @Override
    public void setPreviousEvictable(final MapMakerInternalMap$ReferenceEntry previousEvictable) {
        this.previousEvictable = previousEvictable;
    }
}
