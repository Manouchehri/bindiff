package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType$1;

@GwtCompatible
public enum BoundType {
   OPEN,
   CLOSED;

   private BoundType() {
   }

   static BoundType forBoolean(boolean var0) {
      return var0?CLOSED:OPEN;
   }

   abstract BoundType flip();

   // $FF: synthetic method
   BoundType(BoundType$1 var3) {
      this();
   }
}
