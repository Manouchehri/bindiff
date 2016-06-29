package com.google.security.zynamics.bindiff.graph.edges;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.edges.CombinedDiffEdge;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.edges.SuperDiffEdge;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.edges.ZyGraphEdge;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;
import y.c.d;

public class SingleDiffEdge extends ZyGraphEdge {
   private SingleDiffEdge otherDiffEdge;
   private SuperDiffEdge superDiffEdge;
   private CombinedDiffEdge combinedDiffEdge;
   private final ESide side;

   public SingleDiffEdge(SingleDiffNode var1, SingleDiffNode var2, d var3, ZyEdgeRealizer var4, SingleViewEdge var5, ESide var6) {
      super(var1, var2, var3, var4, var5);
      this.side = (ESide)Preconditions.checkNotNull(var6);
   }

   public CombinedDiffEdge getCombinedDiffEdge() {
      return this.combinedDiffEdge;
   }

   public SingleDiffEdge getOtherSideDiffEdge() {
      return this.otherDiffEdge;
   }

   public ESide getSide() {
      return this.side;
   }

   public SuperDiffEdge getSuperDiffEdge() {
      return this.superDiffEdge;
   }

   public void setCombinedDiffEdge(CombinedDiffEdge var1) {
      this.combinedDiffEdge = var1;
      this.superDiffEdge = var1.getSuperDiffEdge();
      this.otherDiffEdge = this.side == ESide.PRIMARY?var1.getSecondaryDiffEdge():var1.getPrimaryDiffEdge();
   }
}
