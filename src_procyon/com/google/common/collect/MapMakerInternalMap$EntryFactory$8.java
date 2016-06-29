package com.google.common.collect;

import javax.annotation.*;

enum MapMakerInternalMap$EntryFactory$8
{
    MapMakerInternalMap$EntryFactory$8(final String s, final int n) {
    }
    
    @Override
    MapMakerInternalMap$ReferenceEntry newEntry(final MapMakerInternalMap$Segment mapMakerInternalMap$Segment, final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return new MapMakerInternalMap$WeakExpirableEvictableEntry(mapMakerInternalMap$Segment.keyReferenceQueue, o, n, mapMakerInternalMap$ReferenceEntry);
    }
    
    @Override
    MapMakerInternalMap$ReferenceEntry copyEntry(final MapMakerInternalMap$Segment mapMakerInternalMap$Segment, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        final MapMakerInternalMap$ReferenceEntry copyEntry = super.copyEntry(mapMakerInternalMap$Segment, mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry2);
        this.copyExpirableEntry(mapMakerInternalMap$ReferenceEntry, copyEntry);
        this.copyEvictableEntry(mapMakerInternalMap$ReferenceEntry, copyEntry);
        return copyEntry;
    }
}
