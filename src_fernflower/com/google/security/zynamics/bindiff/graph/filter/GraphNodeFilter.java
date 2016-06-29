package com.google.security.zynamics.bindiff.graph.filter;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$1;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeFilter$Criterium;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GraphNodeFilter {
   private static int internalFilterNodes(Collection var0, GraphNodeFilter$Criterium var1, Collection var2) {
      Preconditions.checkNotNull(var1);
      int var3 = 0;
      Iterator var5 = var0.iterator();

      while(var5.hasNext()) {
         ZyGraphNode var6 = (ZyGraphNode)var5.next();
         boolean var4;
         switch(GraphNodeFilter$1.$SwitchMap$com$google$security$zynamics$bindiff$graph$filter$GraphNodeFilter$Criterium[var1.ordinal()]) {
         case 1:
            var4 = var6.isVisible();
            break;
         case 2:
            var4 = !var6.isVisible();
            break;
         case 3:
            var4 = var6.isSelected();
            break;
         case 4:
            var4 = var6.isSelected() && var6.isVisible();
            break;
         case 5:
            var4 = !var6.isSelected() && var6.isVisible();
            break;
         default:
            throw new IllegalArgumentException("Invalid node filter criterium");
         }

         if(var4) {
            ++var3;
            if(var2 != null) {
               var2.add(var6);
            }
         }
      }

      return var3;
   }

   private static int internalFilterNodes(AbstractZyGraph var0, GraphNodeFilter$Criterium var1, Collection var2) {
      return internalFilterNodes(var0.getNodes(), var1, var2);
   }

   public static List filterNodes(AbstractZyGraph var0, GraphNodeFilter$Criterium var1) {
      ArrayList var2 = new ArrayList();
      internalFilterNodes((AbstractZyGraph)var0, var1, var2);
      return var2;
   }

   public static int filterNodesCountOnly(AbstractZyGraph var0, GraphNodeFilter$Criterium var1) {
      return internalFilterNodes((AbstractZyGraph)var0, var1, (Collection)null);
   }

   public static List filterNodes(Collection var0, GraphNodeFilter$Criterium var1) {
      ArrayList var2 = new ArrayList();
      internalFilterNodes((Collection)var0, var1, var2);
      return var2;
   }
}
