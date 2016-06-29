package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.RemovalCause$1;

@GwtCompatible
public enum RemovalCause {
   EXPLICIT,
   REPLACED,
   COLLECTED,
   EXPIRED,
   SIZE;

   private RemovalCause() {
   }

   abstract boolean wasEvicted();

   // $FF: synthetic method
   RemovalCause(RemovalCause$1 var3) {
      this();
   }
}
