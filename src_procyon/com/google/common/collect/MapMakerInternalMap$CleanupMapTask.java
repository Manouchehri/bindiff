package com.google.common.collect;

import java.lang.ref.*;
import java.util.concurrent.*;

final class MapMakerInternalMap$CleanupMapTask implements Runnable
{
    final WeakReference mapReference;
    
    public MapMakerInternalMap$CleanupMapTask(final MapMakerInternalMap mapMakerInternalMap) {
        this.mapReference = new WeakReference((T)mapMakerInternalMap);
    }
    
    @Override
    public void run() {
        final MapMakerInternalMap mapMakerInternalMap = (MapMakerInternalMap)this.mapReference.get();
        if (mapMakerInternalMap == null) {
            throw new CancellationException();
        }
        final MapMakerInternalMap$Segment[] segments = mapMakerInternalMap.segments;
        for (int length = segments.length, i = 0; i < length; ++i) {
            segments[i].runCleanup();
        }
    }
}
