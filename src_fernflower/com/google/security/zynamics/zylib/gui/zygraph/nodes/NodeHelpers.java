package com.google.security.zynamics.zylib.gui.zygraph.nodes;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers$1;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.NodeHelpers$2;
import com.google.security.zynamics.zylib.types.common.CollectionHelpers;
import java.util.HashSet;
import java.util.Iterator;

public class NodeHelpers {
   public static int countInvisibleIndegree(IViewNode var0) {
      return CollectionHelpers.countIf(var0.getIncomingEdges(), new NodeHelpers$1());
   }

   public static int countInvisibleIndegreeNeighbours(IViewNode var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getIncomingEdges().iterator();

      while(var2.hasNext()) {
         IViewEdge var3 = (IViewEdge)var2.next();
         IViewNode var4 = (IViewNode)var3.getSource();
         if(!var4.isVisible()) {
            var1.add(var4);
         }
      }

      return var1.size();
   }

   public static int countInvisibleOutdegree(IViewNode var0) {
      return CollectionHelpers.countIf(var0.getOutgoingEdges(), new NodeHelpers$2());
   }

   public static int countInvisibleOutdegreeNeighbours(IViewNode var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.getOutgoingEdges().iterator();

      while(var2.hasNext()) {
         IViewEdge var3 = (IViewEdge)var2.next();
         IViewNode var4 = (IViewNode)var3.getTarget();
         if(!var4.isVisible()) {
            var1.add(var4);
         }
      }

      return var1.size();
   }

   public static IViewNode getVisibleNode(IViewNode var0) {
      Object var1 = var0;

      for(IGroupNode var2 = var0.getParentGroup(); var2 != null && var2.isCollapsed(); var2 = var2.getParentGroup()) {
         var1 = var2;
      }

      return (IViewNode)var1;
   }
}
