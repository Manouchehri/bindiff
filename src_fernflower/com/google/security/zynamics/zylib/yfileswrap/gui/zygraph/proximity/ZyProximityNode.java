package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.proximity.CProximityNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyProximityNodeRealizer;
import java.util.List;
import y.c.q;

public class ZyProximityNode extends ZyGraphNode {
   private static final int DEFAULT_DISTANCE = 50;
   private final boolean m_isIncoming;

   public ZyProximityNode(q var1, ZyProximityNodeRealizer var2, ZyGraphNode var3, boolean var4) {
      super(var1, var2, new CProximityNode(getRawNode(var3)));
      this.m_isIncoming = var4;
      IZyNodeRealizer var5 = var3.getRealizer();
      double var6 = var5.getCenterX();
      double var8;
      if(var4) {
         var8 = var5.getCenterY() + var5.getHeight() / 2.0D + 50.0D;
      } else {
         var8 = var5.getCenterY() - var5.getHeight() / 2.0D - 50.0D;
      }

      var2.moveBy(var6 - var2.getWidth() / 2.0D, var8 - var2.getHeight() / 2.0D);
   }

   private static IViewNode getRawNode(ZyGraphNode var0) {
      IViewNode var1 = var0.getRawNode();
      return var1;
   }

   public List getChildren() {
      throw new IllegalStateException("Not yet implemented");
   }

   public List getParents() {
      throw new IllegalStateException("Not yet implemented");
   }

   public CProximityNode getRawNode() {
      return (CProximityNode)super.getRawNode();
   }

   public boolean isIncoming() {
      return this.m_isIncoming;
   }
}
