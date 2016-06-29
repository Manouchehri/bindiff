package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1;

enum FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator implements FuturesGetChecked$GetCheckedTypeValidator {
   INSTANCE;

   private static final ClassValue isValidClass;

   public void validateClass(Class var1) {
      isValidClass.get(var1);
   }

   static {
      isValidClass = new FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator$1();
   }
}
