package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import y.c.d;
import y.c.q;
import y.h.bu;

public class ProximityHelper {
   public static ZyProximityNode getProximityNode(bu var0, q var1) {
      IZyNodeRealizer var2 = (IZyNodeRealizer)var0.t(var1);
      return (ZyProximityNode)var2.getUserData().getNode();
   }

   public static boolean isProximityEdge(bu var0, d var1) {
      return isProximityNode(var0, var1.c()) || isProximityNode(var0, var1.d());
   }

   public static boolean isProximityNode(bu var0, q var1) {
      IZyNodeRealizer var2 = (IZyNodeRealizer)var0.t(var1);
      return var2.getUserData().getNode() instanceof ZyProximityNode;
   }
}
