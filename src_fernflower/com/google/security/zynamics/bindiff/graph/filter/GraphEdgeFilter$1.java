package com.google.security.zynamics.bindiff.graph.filter;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import java.util.Collection;

final class GraphEdgeFilter$1 implements IEdgeCallback {
   // $FF: synthetic field
   final Collection val$edges;

   GraphEdgeFilter$1(Collection var1) {
      this.val$edges = var1;
   }

   public IterationMode nextEdge(ZyGraphEdge var1) {
      if(var1.isVisible()) {
         this.val$edges.add(var1);
      }

      return IterationMode.CONTINUE;
   }
}
