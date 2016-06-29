package com.google.common.collect;

import com.google.common.collect.Constraint;
import com.google.common.collect.MapConstraints$ConstrainedMultimap;

class MapConstraints$ConstrainedMultimap$1 implements Constraint {
   // $FF: synthetic field
   final Object val$key;
   // $FF: synthetic field
   final MapConstraints$ConstrainedMultimap this$0;

   MapConstraints$ConstrainedMultimap$1(MapConstraints$ConstrainedMultimap var1, Object var2) {
      this.this$0 = var1;
      this.val$key = var2;
   }

   public Object checkElement(Object var1) {
      this.this$0.constraint.checkKeyValue(this.val$key, var1);
      return var1;
   }
}
