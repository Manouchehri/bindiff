package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.types.common.IterationMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$3 implements INodeCallback {
   // $FF: synthetic field
   final ZyDefaultProximityBrowser this$0;

   ZyDefaultProximityBrowser$3(ZyDefaultProximityBrowser var1) {
      this.this$0 = var1;
   }

   public IterationMode next(ZyGraphNode var1) {
      var1.getRawNode().setVisible(true);
      return IterationMode.CONTINUE;
   }
}
