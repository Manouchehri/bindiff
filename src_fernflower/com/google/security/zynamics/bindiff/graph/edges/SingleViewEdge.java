package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import java.awt.Color;
import java.util.ArrayList;

public abstract class SingleViewEdge extends CViewEdge {
   public SingleViewEdge(SingleViewNode var1, SingleViewNode var2) {
      super(-1, var1, var2, EdgeType.DUMMY, 0.0D, 0.0D, 0.0D, 0.0D, Color.BLACK, false, true, new ArrayList());
      SingleViewNode.link(var1, var2);
      var1.addOutgoingEdge(this);
      var2.addIncomingEdge(this);
   }
}
