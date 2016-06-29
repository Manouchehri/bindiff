package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;

public class ZyNodeData {
   private final ZyGraphNode m_node;

   public ZyNodeData(ZyGraphNode var1) {
      Preconditions.checkNotNull(var1, "Error: Node argument can\'t be null");
      this.m_node = var1;
   }

   public ZyGraphNode getNode() {
      return this.m_node;
   }
}
