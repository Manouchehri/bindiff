package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;

@VisibleForTesting
class FuturesGetChecked$GetCheckedTypeValidatorHolder {
   static final String CLASS_VALUE_VALIDATOR_NAME = String.valueOf(FuturesGetChecked$GetCheckedTypeValidatorHolder.class.getName()).concat("$ClassValueValidator");
   static final FuturesGetChecked$GetCheckedTypeValidator BEST_VALIDATOR = getBestValidator();

   static FuturesGetChecked$GetCheckedTypeValidator getBestValidator() {
      try {
         Class var0 = Class.forName(CLASS_VALUE_VALIDATOR_NAME);
         return (FuturesGetChecked$GetCheckedTypeValidator)var0.getEnumConstants()[0];
      } catch (Throwable var1) {
         return FuturesGetChecked.weakSetValidator();
      }
   }
}
