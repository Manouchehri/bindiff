package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;

final class MultiEdgeHider$2 implements IEdgeCallback {
   public IterationMode nextEdge(ZyGraphEdge var1) {
      var1.getRawEdge().setVisible(var1.getSource().isVisible() && var1.getTarget().isVisible());
      return IterationMode.CONTINUE;
   }
}
