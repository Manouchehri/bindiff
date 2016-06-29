package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$2 implements INodeFilter {
   // $FF: synthetic field
   final ZyDefaultProximityBrowser this$0;

   ZyDefaultProximityBrowser$2(ZyDefaultProximityBrowser var1) {
      this.this$0 = var1;
   }

   public boolean qualifies(ZyGraphNode var1) {
      return !var1.isVisible();
   }
}
