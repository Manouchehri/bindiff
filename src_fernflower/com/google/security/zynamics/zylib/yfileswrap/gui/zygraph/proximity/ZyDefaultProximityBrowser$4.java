package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$4 implements IEdgeCallback {
   // $FF: synthetic field
   final ZyDefaultProximityBrowser this$0;

   ZyDefaultProximityBrowser$4(ZyDefaultProximityBrowser var1) {
      this.this$0 = var1;
   }

   public IterationMode nextEdge(ZyGraphEdge var1) {
      var1.getRawEdge().setVisible(true);
      return IterationMode.CONTINUE;
   }
}
