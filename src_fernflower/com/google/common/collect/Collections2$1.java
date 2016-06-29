package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

final class Collections2$1 implements Function {
   // $FF: synthetic field
   final Collection val$collection;

   Collections2$1(Collection var1) {
      this.val$collection = var1;
   }

   public Object apply(Object var1) {
      return var1 == this.val$collection?"(this Collection)":var1;
   }
}
