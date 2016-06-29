/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$Segment;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

final class MapMakerInternalMap$CleanupMapTask
implements Runnable {
    final WeakReference mapReference;

    public MapMakerInternalMap$CleanupMapTask(MapMakerInternalMap mapMakerInternalMap) {
        this.mapReference = new WeakReference<MapMakerInternalMap>(mapMakerInternalMap);
    }

    @Override
    public void run() {
        MapMakerInternalMap mapMakerInternalMap = (MapMakerInternalMap)this.mapReference.get();
        if (mapMakerInternalMap == null) {
            throw new CancellationException();
        }
        MapMakerInternalMap$Segment[] arrmapMakerInternalMap$Segment = mapMakerInternalMap.segments;
        int n2 = arrmapMakerInternalMap$Segment.length;
        int n3 = 0;
        while (n3 < n2) {
            MapMakerInternalMap$Segment mapMakerInternalMap$Segment = arrmapMakerInternalMap$Segment[n3];
            mapMakerInternalMap$Segment.runCleanup();
            ++n3;
        }
    }
}

