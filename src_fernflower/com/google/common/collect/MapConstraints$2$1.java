package com.google.common.collect;

import com.google.common.collect.Constraint;
import com.google.common.collect.MapConstraints$2;

class MapConstraints$2$1 implements Constraint {
   // $FF: synthetic field
   final MapConstraints$2 this$0;

   MapConstraints$2$1(MapConstraints$2 var1) {
      this.this$0 = var1;
   }

   public Object checkElement(Object var1) {
      this.this$0.val$constraint.checkKeyValue(this.this$0.getKey(), var1);
      return var1;
   }
}
