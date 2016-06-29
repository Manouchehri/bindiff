package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge$1;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyInfoEdge$CInfoEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class ZyInfoEdge extends ZyGraphEdge {
   public ZyInfoEdge(ZyGraphNode var1, ZyGraphNode var2, d var3, ZyEdgeRealizer var4) {
      super(var1, var2, var3, var4, new ZyInfoEdge$CInfoEdge((ZyInfoEdge$1)null));
   }
}
