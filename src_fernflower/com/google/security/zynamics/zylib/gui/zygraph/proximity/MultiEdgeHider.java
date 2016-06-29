package com.google.security.zynamics.zylib.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.edges.IViewEdge;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IGroupNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.MultiEdgeHider$1;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.MultiEdgeHider$2;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.HashSet;
import java.util.Iterator;

public class MultiEdgeHider {
   public static void hideMultipleEdgesInternal(AbstractZyGraph var0) {
      var0.iterate((INodeCallback)(new MultiEdgeHider$1()));
   }

   public static void hideMultipleEdgesInternal(ZyGraphNode var0) {
      if(var0.isVisible() && !(var0.getRawNode() instanceof IGroupNode)) {
         HashSet var1 = new HashSet();
         Iterator var2 = var0.getRawNode().getOutgoingEdges().iterator();

         while(var2.hasNext()) {
            IViewEdge var3 = (IViewEdge)var2.next();
            Object var4 = var3.getTarget();
            if(var1.contains(var4)) {
               var3.setVisible(false);
            } else {
               var1.add(var4);
            }
         }

         HashSet var5 = new HashSet();
         Iterator var6 = var0.getRawNode().getIncomingEdges().iterator();

         while(var6.hasNext()) {
            IViewEdge var7 = (IViewEdge)var6.next();
            if(var5.contains(var7.getSource())) {
               var7.setVisible(false);
            } else {
               var5.add(var7.getSource());
            }
         }

      }
   }

   public static void unhideMultipleEdgesInternal(AbstractZyGraph var0) {
      var0.iterateEdges(new MultiEdgeHider$2());
   }
}
