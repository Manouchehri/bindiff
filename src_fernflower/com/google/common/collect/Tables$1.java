package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collections;
import java.util.Map;

final class Tables$1 implements Function {
   public Map apply(Map var1) {
      return Collections.unmodifiableMap(var1);
   }
}
