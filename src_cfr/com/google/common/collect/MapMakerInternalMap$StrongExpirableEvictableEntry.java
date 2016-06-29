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

final class MapMakerInternalMap$StrongExpirableEvictableEntry
extends MapMakerInternalMap$StrongEntry
implements MapMakerInternalMap$ReferenceEntry {
    volatile long time = Long.MAX_VALUE;
    MapMakerInternalMap$ReferenceEntry nextExpirable = MapMakerInternalMap.nullEntry();
    MapMakerInternalMap$ReferenceEntry previousExpirable = MapMakerInternalMap.nullEntry();
    MapMakerInternalMap$ReferenceEntry nextEvictable = MapMakerInternalMap.nullEntry();
    MapMakerInternalMap$ReferenceEntry previousEvictable = MapMakerInternalMap.nullEntry();

    MapMakerInternalMap$StrongExpirableEvictableEntry(Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(object, n2, mapMakerInternalMap$ReferenceEntry);
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

