/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$StrongEntry;
import javax.annotation.Nullable;

final class MapMakerInternalMap$StrongEvictableEntry
extends MapMakerInternalMap$StrongEntry
implements MapMakerInternalMap$ReferenceEntry {
    MapMakerInternalMap$ReferenceEntry nextEvictable = MapMakerInternalMap.nullEntry();
    MapMakerInternalMap$ReferenceEntry previousEvictable = MapMakerInternalMap.nullEntry();

    MapMakerInternalMap$StrongEvictableEntry(Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(object, n2, mapMakerInternalMap$ReferenceEntry);
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        return this.nextEvictable;
    }

    @Override
    public void setNextEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.nextEvictable = mapMakerInternalMap$ReferenceEntry;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        return this.previousEvictable;
    }

    @Override
    public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.previousEvictable = mapMakerInternalMap$ReferenceEntry;
    }
}

