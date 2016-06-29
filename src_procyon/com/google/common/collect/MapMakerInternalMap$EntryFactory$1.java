package com.google.common.collect;

import javax.annotation.*;

enum MapMakerInternalMap$EntryFactory$1
{
    MapMakerInternalMap$EntryFactory$1(final String s, final int n) {
    }
    
    @Override
    MapMakerInternalMap$ReferenceEntry newEntry(final MapMakerInternalMap$Segment mapMakerInternalMap$Segment, final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return new MapMakerInternalMap$StrongEntry(o, n, mapMakerInternalMap$ReferenceEntry);
    }
}
