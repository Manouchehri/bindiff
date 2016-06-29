package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects$1;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class MoreObjects {
   @CheckReturnValue
   public static Object firstNonNull(@Nullable Object var0, @Nullable Object var1) {
      return var0 != null?var0:Preconditions.checkNotNull(var1);
   }

   @CheckReturnValue
   public static MoreObjects$ToStringHelper toStringHelper(Object var0) {
      return new MoreObjects$ToStringHelper(var0.getClass().getSimpleName(), (MoreObjects$1)null);
   }

   @CheckReturnValue
   public static MoreObjects$ToStringHelper toStringHelper(Class var0) {
      return new MoreObjects$ToStringHelper(var0.getSimpleName(), (MoreObjects$1)null);
   }

   @CheckReturnValue
   public static MoreObjects$ToStringHelper toStringHelper(String var0) {
      return new MoreObjects$ToStringHelper(var0, (MoreObjects$1)null);
   }
}
