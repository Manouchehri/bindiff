package com.google.security.zynamics.bindiff.graph;

import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

class CombinedGraph$1 implements ICollectionFilter {
   // $FF: synthetic field
   final CombinedGraph this$0;

   CombinedGraph$1(CombinedGraph var1) {
      this.this$0 = var1;
   }

   public boolean qualifies(CombinedDiffNode var1) {
      return var1.isSelected();
   }
}
