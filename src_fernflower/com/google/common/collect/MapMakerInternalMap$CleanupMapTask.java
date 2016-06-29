package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$Segment;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

final class MapMakerInternalMap$CleanupMapTask implements Runnable {
   final WeakReference mapReference;

   public MapMakerInternalMap$CleanupMapTask(MapMakerInternalMap var1) {
      this.mapReference = new WeakReference(var1);
   }

   public void run() {
      MapMakerInternalMap var1 = (MapMakerInternalMap)this.mapReference.get();
      if(var1 == null) {
         throw new CancellationException();
      } else {
         MapMakerInternalMap$Segment[] var2 = var1.segments;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            MapMakerInternalMap$Segment var5 = var2[var4];
            var5.runCleanup();
         }

      }
   }
}
