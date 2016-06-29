package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;

@VisibleForTesting
class Ordering$IncomparableValueException extends ClassCastException {
   final Object value;
   private static final long serialVersionUID = 0L;

   Ordering$IncomparableValueException(Object var1) {
      String var2 = String.valueOf(var1);
      super((new StringBuilder(22 + String.valueOf(var2).length())).append("Cannot compare value: ").append(var2).toString());
      this.value = var1;
   }
}
