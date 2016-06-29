package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;

final class NodeHelpers$1 implements ICollectionFilter {
   public boolean qualifies(IViewEdge var1) {
      return !NodeHelpers.getVisibleNode((IViewNode)var1.getSource()).isVisible();
   }
}
