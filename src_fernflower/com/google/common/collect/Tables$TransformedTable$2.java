package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Tables$TransformedTable;
import java.util.Map;

class Tables$TransformedTable$2 implements Function {
   // $FF: synthetic field
   final Tables$TransformedTable this$0;

   Tables$TransformedTable$2(Tables$TransformedTable var1) {
      this.this$0 = var1;
   }

   public Map apply(Map var1) {
      return Maps.transformValues(var1, this.this$0.function);
   }
}
