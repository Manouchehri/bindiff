package com.google.common.collect;

import javax.annotation.*;

final class MapMakerInternalMap$StrongEvictableEntry extends MapMakerInternalMap$StrongEntry implements MapMakerInternalMap$ReferenceEntry
{
    MapMakerInternalMap$ReferenceEntry nextEvictable;
    MapMakerInternalMap$ReferenceEntry previousEvictable;
    
    MapMakerInternalMap$StrongEvictableEntry(final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(o, n, mapMakerInternalMap$ReferenceEntry);
        this.nextEvictable = MapMakerInternalMap.nullEntry();
        this.previousEvictable = MapMakerInternalMap.nullEntry();
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
