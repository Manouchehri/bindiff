package com.google.common.collect;

import com.google.common.collect.MapMaker$1;

public enum MapMaker$RemovalCause {
   EXPLICIT,
   REPLACED,
   COLLECTED,
   EXPIRED,
   SIZE;

   private MapMaker$RemovalCause() {
   }

   abstract boolean wasEvicted();

   // $FF: synthetic method
   MapMaker$RemovalCause(MapMaker$1 var3) {
      this();
   }
}
