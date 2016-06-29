package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import javax.annotation.Nullable;

@Deprecated
@GoogleInternal
public class InterruptedRuntimeException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   public InterruptedRuntimeException() {
      Thread.currentThread().interrupt();
   }

   public InterruptedRuntimeException(@Nullable String var1) {
      super(var1);
      Thread.currentThread().interrupt();
   }

   public InterruptedRuntimeException(@Nullable InterruptedException var1) {
      super(var1);
      Thread.currentThread().interrupt();
   }

   public InterruptedRuntimeException(@Nullable String var1, @Nullable InterruptedException var2) {
      super(var1, var2);
      Thread.currentThread().interrupt();
   }
}
