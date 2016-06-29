package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;

final class FuturesGetChecked$1 implements Function {
   public Boolean apply(Constructor var1) {
      return Boolean.valueOf(Arrays.asList(var1.getParameterTypes()).contains(String.class));
   }
}
