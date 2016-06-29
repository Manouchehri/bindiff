package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;

class ZyDefaultProximityBrowser$1 implements ICollectionFilter {
   // $FF: synthetic field
   final ZyDefaultProximityBrowser this$0;

   ZyDefaultProximityBrowser$1(ZyDefaultProximityBrowser var1) {
      this.this$0 = var1;
   }

   private boolean isOpenGroupNode(ZyGraphNode var1) {
      return var1.getRawNode() instanceof IGroupNode && !((IGroupNode)var1.getRawNode()).isCollapsed();
   }

   public boolean qualifies(ZyGraphNode var1) {
      return var1 == ZyDefaultProximityBrowser.access$200(this.this$0, var1) && !this.isOpenGroupNode(var1);
   }
}
