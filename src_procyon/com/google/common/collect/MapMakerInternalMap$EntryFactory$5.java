package com.google.common.collect;

import javax.annotation.*;

enum MapMakerInternalMap$EntryFactory$5
{
    MapMakerInternalMap$EntryFactory$5(final String s, final int n) {
    }
    
    @Override
    MapMakerInternalMap$ReferenceEntry newEntry(final MapMakerInternalMap$Segment mapMakerInternalMap$Segment, final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return new MapMakerInternalMap$WeakEntry(mapMakerInternalMap$Segment.keyReferenceQueue, o, n, mapMakerInternalMap$ReferenceEntry);
    }
}
