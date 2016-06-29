package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapConstraint;

enum MapConstraints$NotNullMapConstraint implements MapConstraint {
   INSTANCE;

   public void checkKeyValue(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
   }

   public String toString() {
      return "Not null";
   }
}
