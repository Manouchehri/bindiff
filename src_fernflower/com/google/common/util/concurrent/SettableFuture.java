package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

@GwtCompatible
public final class SettableFuture extends AbstractFuture$TrustedFuture {
   public static SettableFuture create() {
      return new SettableFuture();
   }

   public boolean set(@Nullable Object var1) {
      return super.set(var1);
   }

   public boolean setException(Throwable var1) {
      return super.setException(var1);
   }

   @Beta
   public boolean setFuture(ListenableFuture var1) {
      return super.setFuture(var1);
   }
}
