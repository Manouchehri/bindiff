package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.edges.EdgeType;
import java.awt.Color;
import java.util.ArrayList;

public final class SuperViewEdge extends CViewEdge {
   private final CombinedViewEdge combinedEdge;

   public SuperViewEdge(CombinedViewEdge var1, SuperViewNode var2, SuperViewNode var3) {
      super(-1, var2, var3, EdgeType.DUMMY, 0.0D, 0.0D, 0.0D, 0.0D, Color.BLACK, false, true, new ArrayList());
      this.combinedEdge = (CombinedViewEdge)Preconditions.checkNotNull(var1);
      SuperViewNode.link(var2, var3);
      var2.addOutgoingEdge(this);
      var3.addIncomingEdge(this);
   }

   public CombinedViewEdge getCombinedEdge() {
      return this.combinedEdge;
   }

   public SingleViewEdge getSingleEdge(ESide var1) {
      return var1 == ESide.PRIMARY?this.combinedEdge.getPrimaryEdge():this.combinedEdge.getSecondaryEdge();
   }
}
