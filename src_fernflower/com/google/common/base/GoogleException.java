package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Throwables;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Deprecated
@CheckReturnValue
@GoogleInternal
public class GoogleException extends Exception {
   private static final long serialVersionUID = 1L;
   private String internalMessage;
   private String externalMessage = "A system error has occurred";

   public GoogleException() {
   }

   public GoogleException(@Nullable Throwable var1) {
      super(var1);
      this.setInternalMessage(Throwables.getStackTraceAsString(var1));
   }

   public GoogleException(@Nullable Throwable var1, @Nullable String var2) {
      super(var2, var1);
      this.setInternalMessage(Throwables.getStackTraceAsString(var1));
      this.setExternalMessage(var2);
   }

   public GoogleException(@Nullable String var1) {
      super(var1);
      this.setInternalMessage(var1);
   }

   public GoogleException(@Nullable String var1, @Nullable String var2) {
      super(var1);
      this.setInternalMessage(var1);
      this.setExternalMessage(var2);
   }

   @Nullable
   public String getInternalMessage() {
      return this.internalMessage;
   }

   public final void setInternalMessage(@Nullable String var1) {
      this.internalMessage = var1;
   }

   @Nullable
   public String getExternalMessage() {
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
