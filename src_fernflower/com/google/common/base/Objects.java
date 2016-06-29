package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects$1;
import com.google.common.base.Objects$ToStringHelper;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class Objects {
   @CheckReturnValue
   public static boolean equal(@Nullable Object var0, @Nullable Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   @CheckReturnValue
   public static int hashCode(@Nullable Object... var0) {
      return Arrays.hashCode(var0);
   }

   @CheckReturnValue
   @Deprecated
   public static Objects$ToStringHelper toStringHelper(Object var0) {
      return new Objects$ToStringHelper(var0.getClass().getSimpleName(), (Objects$1)null);
   }

   @CheckReturnValue
   @Deprecated
   public static Objects$ToStringHelper toStringHelper(Class var0) {
      return new Objects$ToStringHelper(var0.getSimpleName(), (Objects$1)null);
   }

   @CheckReturnValue
   @Deprecated
   public static Objects$ToStringHelper toStringHelper(String var0) {
      return new Objects$ToStringHelper(var0, (Objects$1)null);
   }

   @CheckReturnValue
   @Deprecated
   public static Object firstNonNull(@Nullable Object var0, @Nullable Object var1) {
      return MoreObjects.firstNonNull(var0, var1);
   }
}
