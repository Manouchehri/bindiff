package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.edges.SuperViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.CViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SuperViewNode extends CViewNode implements IGraphNode {
   private final List children = new ArrayList();
   private final List parents = new ArrayList();
   private final CombinedViewNode combinedNode;

   public SuperViewNode(CombinedViewNode var1) {
      super(-1, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE, Color.BLACK, false, true);
      Preconditions.checkNotNull(var1);
      this.combinedNode = var1;
   }

   public static void link(SuperViewNode var0, SuperViewNode var1) {
      var0.getChildren().add(var1);
      var1.getParents().add(var0);
   }

   public static void unlink(SuperViewNode var0, SuperViewNode var1) {
      var0.getChildren().remove(var1);
      var1.getParents().remove(var0);
   }

   public List getChildren() {
      return this.children;
   }

   public CombinedViewNode getCombinedNode() {
      return this.combinedNode;
   }

   public IGroupNode getParentGroup() {
      return null;
   }

   public List getParents() {
      return this.parents;
   }

   public void removeNode() {
      Iterator var1 = this.getIncomingEdges().iterator();

      SuperViewEdge var2;
      while(var1.hasNext()) {
         var2 = (SuperViewEdge)var1.next();
         unlink((SuperViewNode)var2.getSource(), (SuperViewNode)var2.getTarget());
         ((SuperViewNode)var2.getSource()).removeOutgoingEdge(var2);
         ((SuperViewNode)var2.getTarget()).removeIncomingEdge(var2);
      }

      var1 = this.getOutgoingEdges().iterator();

      while(var1.hasNext()) {
         var2 = (SuperViewEdge)var1.next();
         unlink((SuperViewNode)var2.getSource(), (SuperViewNode)var2.getTarget());
         ((SuperViewNode)var2.getSource()).removeOutgoingEdge(var2);
         ((SuperViewNode)var2.getTarget()).removeIncomingEdge(var2);
      }

   }
}
