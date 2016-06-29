package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapConstraint;

class MapConstraints$InverseConstraint implements MapConstraint {
   final MapConstraint constraint;

   public MapConstraints$InverseConstraint(MapConstraint var1) {
      this.constraint = (MapConstraint)Preconditions.checkNotNull(var1);
   }

   public void checkKeyValue(Object var1, Object var2) {
      this.constraint.checkKeyValue(var2, var1);
   }
}
