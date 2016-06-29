package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$AbstractReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$ExpirationQueue$1 extends MapMakerInternalMap$AbstractReferenceEntry {
   MapMakerInternalMap$ReferenceEntry nextExpirable;
   MapMakerInternalMap$ReferenceEntry previousExpirable;
   // $FF: synthetic field
   final MapMakerInternalMap$ExpirationQueue this$0;

   MapMakerInternalMap$ExpirationQueue$1(MapMakerInternalMap$ExpirationQueue var1) {
      this.this$0 = var1;
      this.nextExpirable = this;
      this.previousExpirable = this;
   }

   public long getExpirationTime() {
      return Long.MAX_VALUE;
   }

   public void setExpirationTime(long var1) {
   }

   public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
      return this.nextExpirable;
   }

   public void setNextExpirable(MapMakerInternalMap$ReferenceEntry var1) {
      this.nextExpirable = var1;
   }

   public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
      return this.previousExpirable;
   }

   public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry var1) {
      this.previousExpirable = var1;
   }
}
