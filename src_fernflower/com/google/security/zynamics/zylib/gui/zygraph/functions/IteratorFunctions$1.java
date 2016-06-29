package com.google.security.zynamics.zylib.gui.zygraph.functions;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;

final class IteratorFunctions$1 implements IEdgeCallback {
   // $FF: synthetic field
   final IEdgeCallback val$callback;

   IteratorFunctions$1(IEdgeCallback var1) {
      this.val$callback = var1;
   }

   public IterationMode nextEdge(ZyGraphEdge var1) {
      return var1.isVisible()?IterationMode.CONTINUE:this.val$callback.nextEdge(var1);
   }
}
