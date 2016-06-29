package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class SuperDiffEdge extends ZyGraphEdge {
   private final SingleDiffEdge primaryDiffEdge;
   private final SingleDiffEdge secondaryDiffEdge;
   private CombinedDiffEdge combinedDiffEdge;

   public SuperDiffEdge(SuperDiffNode var1, SuperDiffNode var2, d var3, ZyEdgeRealizer var4, SuperViewEdge var5, SingleDiffEdge var6, SingleDiffEdge var7) {
      super(var1, var2, var3, var4, var5);
      Preconditions.checkArgument(var6 != null || var7 != null, "Primary and secondary edge cannot both be null.");
      this.primaryDiffEdge = var6;
      this.secondaryDiffEdge = var7;
   }

   public CombinedDiffEdge getCombinedDiffEdge() {
      return this.combinedDiffEdge;
   }

   public SingleDiffEdge getPrimaryDiffEdge() {
      return this.primaryDiffEdge;
   }

   public SuperViewEdge getRawEdge() {
      return (SuperViewEdge)super.getRawEdge();
   }

   public SingleDiffEdge getSecondaryDiffEdge() {
      return this.secondaryDiffEdge;
   }

   public void setCombinedDiffEdge(CombinedDiffEdge var1) {
      this.combinedDiffEdge = var1;
   }
}
