package com.google.security.zynamics.bindiff.graph.edges;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import java.awt.Color;
import java.util.ArrayList;

public abstract class CombinedViewEdge extends CViewEdge {
   public CombinedViewEdge(CombinedViewNode var1, CombinedViewNode var2) {
      super(-1, var1, var2, EdgeType.DUMMY, 0.0D, 0.0D, 0.0D, 0.0D, Color.BLACK, false, true, new ArrayList());
      CombinedViewNode.link(var1, var2);
      var1.addOutgoingEdge(this);
      var2.addIncomingEdge(this);
   }

   public abstract EMatchState getMatchState();

   public abstract SingleViewEdge getPrimaryEdge();

   public abstract SingleViewEdge getSecondaryEdge();
}
