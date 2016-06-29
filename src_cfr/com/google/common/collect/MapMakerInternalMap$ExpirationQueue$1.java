/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$AbstractReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$ExpirationQueue$1
extends MapMakerInternalMap$AbstractReferenceEntry {
    MapMakerInternalMap$ReferenceEntry nextExpirable;
    MapMakerInternalMap$ReferenceEntry previousExpirable;
    final /* synthetic */ MapMakerInternalMap.ExpirationQueue this$0;

    MapMakerInternalMap$ExpirationQueue$1(MapMakerInternalMap.ExpirationQueue expirationQueue) {
        this.this$0 = expirationQueue;
        this.nextExpirable = this;
        this.previousExpirable = this;
    }

    @Override
    public long getExpirationTime() {
        return Long.MAX_VALUE;
    }

    @Override
    public void setExpirationTime(long l2) {
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

