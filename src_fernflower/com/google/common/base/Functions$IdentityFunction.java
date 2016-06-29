package com.google.common.base;

import com.google.common.base.Function;
import javax.annotation.Nullable;

enum Functions$IdentityFunction implements Function {
   INSTANCE;

   @Nullable
   public Object apply(@Nullable Object var1) {
      return var1;
   }

   public String toString() {
      return "Functions.identity()";
   }
}
