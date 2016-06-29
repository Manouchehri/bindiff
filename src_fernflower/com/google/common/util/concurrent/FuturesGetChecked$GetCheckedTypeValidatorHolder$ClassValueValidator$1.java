package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked;

final class FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1 extends ClassValue {
   protected Boolean computeValue(Class var1) {
      FuturesGetChecked.checkExceptionClassValidity(var1.asSubclass(Exception.class));
      return Boolean.valueOf(true);
   }
}
