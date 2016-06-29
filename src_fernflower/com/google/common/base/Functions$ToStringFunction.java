package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

enum Functions$ToStringFunction implements Function {
   INSTANCE;

   public String apply(Object var1) {
      Preconditions.checkNotNull(var1);
      return var1.toString();
   }

   public String toString() {
      return "Functions.toStringFunction()";
   }
}
