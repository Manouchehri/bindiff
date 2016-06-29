package com.google.common.collect;

import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.MapMaker$RemovalCause;
import javax.annotation.Nullable;

public final class MapMaker$RemovalNotification extends ImmutableEntry {
   private static final long serialVersionUID = 0L;
   private final MapMaker$RemovalCause cause;

   MapMaker$RemovalNotification(@Nullable Object var1, @Nullable Object var2, MapMaker$RemovalCause var3) {
      super(var1, var2);
      this.cause = var3;
   }

   public MapMaker$RemovalCause getCause() {
      return this.cause;
   }

   public boolean wasEvicted() {
      return this.cause.wasEvicted();
   }
}
