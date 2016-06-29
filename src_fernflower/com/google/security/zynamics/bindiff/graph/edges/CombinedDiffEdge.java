package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.edges.CombinedViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class CombinedDiffEdge extends ZyGraphEdge {
   private final SingleDiffEdge primaryDiffEdge;
   private final SingleDiffEdge secondaryDiffEdge;
   private final SuperDiffEdge superDiffEdge;

   public CombinedDiffEdge(CombinedDiffNode var1, CombinedDiffNode var2, d var3, ZyEdgeRealizer var4, CombinedViewEdge var5, SuperDiffEdge var6) {
      super(var1, var2, var3, var4, var5);
      this.superDiffEdge = (SuperDiffEdge)Preconditions.checkNotNull(var6);
      this.primaryDiffEdge = var6.getPrimaryDiffEdge();
      this.secondaryDiffEdge = var6.getSecondaryDiffEdge();
   }

   public SingleDiffEdge getPrimaryDiffEdge() {
      return this.primaryDiffEdge;
   }

   public SingleDiffEdge getSecondaryDiffEdge() {
      return this.secondaryDiffEdge;
   }

   public SuperDiffEdge getSuperDiffEdge() {
      return this.superDiffEdge;
   }
}
