/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$AbstractReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$EvictionQueue$1
extends MapMakerInternalMap$AbstractReferenceEntry {
    MapMakerInternalMap$ReferenceEntry nextEvictable;
    MapMakerInternalMap$ReferenceEntry previousEvictable;
    final /* synthetic */ MapMakerInternalMap.EvictionQueue this$0;

    MapMakerInternalMap$EvictionQueue$1(MapMakerInternalMap.EvictionQueue evictionQueue) {
        this.this$0 = evictionQueue;
        this.nextEvictable = this;
        this.previousEvictable = this;
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

