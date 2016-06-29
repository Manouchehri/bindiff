package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.ProximityNodeFunctions;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

class ProximityNodeFunctions$1 implements ICollectionFilter {
   // $FF: synthetic field
   final ProximityNodeFunctions this$0;

   ProximityNodeFunctions$1(ProximityNodeFunctions var1) {
      this.this$0 = var1;
   }

   public boolean qualifies(ZyGraphNode var1) {
      return NodeHelpers.getVisibleNode(var1.getRawNode()) == var1.getRawNode();
   }
}
