package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

class SuperGraph$1 implements ICollectionFilter {
   // $FF: synthetic field
   final SuperGraph this$0;

   SuperGraph$1(SuperGraph var1) {
      this.this$0 = var1;
   }

   public boolean qualifies(SuperDiffNode var1) {
      return var1.isSelected();
   }
}
