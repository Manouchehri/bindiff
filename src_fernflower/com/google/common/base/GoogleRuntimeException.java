package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.GoogleException;
import com.google.common.base.Throwables;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Deprecated
@CheckReturnValue
@GoogleInternal
public class GoogleRuntimeException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   private String internalMessage;
   private String externalMessage = "A system error has occurred";

   public GoogleRuntimeException() {
   }

   public GoogleRuntimeException(@Nullable String var1) {
      super(var1);
      this.setInternalMessage(var1);
   }

   public GoogleRuntimeException(@Nullable String var1, @Nullable Throwable var2) {
      super(var1, var2);
      this.setInternalMessage(Throwables.getStackTraceAsString(var2));
      this.setExternalMessage(var1);
   }

   public GoogleRuntimeException(@Nullable GoogleException var1) {
      super(var1);
      this.setInternalMessage(var1.getInternalMessage());
      this.setExternalMessage(var1.getExternalMessage());
   }

   @Nullable
   public final String getInternalMessage() {
      return this.internalMessage;
   }

   public final void setInternalMessage(@Nullable String var1) {
      this.internalMessage = var1;
   }

   @Nullable
   public final String getExternalMessage() {
      return this.externalMessage;
   }

   public final void setExternalMessage(@Nullable String var1) {
      this.externalMessage = var1;
   }

   @Nullable
   public String getMessage() {
      return this.getInternalMessage();
   }
}
