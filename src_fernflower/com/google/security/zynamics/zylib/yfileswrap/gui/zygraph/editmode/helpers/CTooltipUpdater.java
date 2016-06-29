package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.ZyGraph2DView;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers.TooltipGenerator;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import y.c.d;
import y.c.q;

public final class CTooltipUpdater {
   public static boolean isProximityNode(AbstractZyGraph var0, q var1) {
      Preconditions.checkNotNull(var0, "Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Node argument can not be null");
      return var0.getGraph().t(var1) instanceof ZyProximityNodeRealizer;
   }

   public static String updateEdgeTooltip(AbstractZyGraph var0, d var1) {
      Preconditions.checkNotNull(var0, "Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Edge argument can not be null");
      if(var0.getView() instanceof ZyGraph2DView && ((ZyGraph2DView)var0.getView()).isEdgeSloppyPaintMode()) {
         String var2 = TooltipGenerator.createTooltip(var0, var1);
         var0.getView().setToolTipText(var2);
         return var2;
      } else {
         return null;
      }
   }

   public static String updateNodeTooltip(AbstractZyGraph var0, q var1) {
      Preconditions.checkNotNull(var0, "Graph argument can not be null");
      Preconditions.checkNotNull(var1, "Node argument can not be null");
      return isProximityNode(var0, var1)?TooltipGenerator.createTooltip(var0, var1):(var0.getView() instanceof ZyGraph2DView && ((ZyGraph2DView)var0.getView()).isNodeSloppyPaintMode()?TooltipGenerator.createTooltip(var0, var1):null);
   }
}
