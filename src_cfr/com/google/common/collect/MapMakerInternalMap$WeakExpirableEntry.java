/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$WeakEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class MapMakerInternalMap$WeakExpirableEntry
extends MapMakerInternalMap$WeakEntry
implements MapMakerInternalMap$ReferenceEntry {
    volatile long time = Long.MAX_VALUE;
    MapMakerInternalMap$ReferenceEntry nextExpirable = MapMakerInternalMap.nullEntry();
    MapMakerInternalMap$ReferenceEntry previousExpirable = MapMakerInternalMap.nullEntry();

    MapMakerInternalMap$WeakExpirableEntry(ReferenceQueue referenceQueue, Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(referenceQueue, object, n2, mapMakerInternalMap$ReferenceEntry);
    }

    @Override
    public long getExpirationTime() {
        return this.time;
    }

    @Override
    public void setExpirationTime(long l2) {
        this.time = l2;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        return this.nextExpirable;
    }

    @Override
    public void setNextExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.nextExpirable = mapMakerInternalMap$ReferenceEntry;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        return this.previousExpirable;
    }

    @Override
    public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.previousExpirable = mapMakerInternalMap$ReferenceEntry;
    }
}

