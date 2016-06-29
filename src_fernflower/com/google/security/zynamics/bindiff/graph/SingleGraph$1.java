package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

class SingleGraph$1 implements ICollectionFilter {
   // $FF: synthetic field
   final SingleGraph this$0;

   SingleGraph$1(SingleGraph var1) {
      this.this$0 = var1;
   }

   public boolean qualifies(SingleDiffNode var1) {
      return var1.isSelected();
   }
}
