package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNodeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyDefaultProximityBrowser;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.Color;

class ZyDefaultProximityBrowser$InternalNodeListener implements IViewNodeListener {
   private double m_x;
   private double m_y;
   private final ZyProximityNode m_infoNode;
   // $FF: synthetic field
   final ZyDefaultProximityBrowser this$0;

   public ZyDefaultProximityBrowser$InternalNodeListener(ZyDefaultProximityBrowser var1, double var2, double var4, ZyProximityNode var6) {
      this.this$0 = var1;
      this.m_x = var2;
      this.m_y = var4;
      this.m_infoNode = var6;
   }

   public void changedBorderColor(IViewNode var1, Color var2) {
   }

   public void changedColor(IViewNode var1, Color var2) {
   }

   public void changedSelection(IViewNode var1, boolean var2) {
   }

   public void changedVisibility(IViewNode var1, boolean var2) {
   }

   public void heightChanged(IViewNode var1, double var2) {
   }

   public void widthChanged(IViewNode var1, double var2) {
   }

   public void xposChanged(IViewNode var1, double var2) {
      this.m_infoNode.getRealizer().setX(this.m_infoNode.getX() + var2 - this.m_x);
      this.m_x = var2;
   }

   public void yposChanged(IViewNode var1, double var2) {
      this.m_infoNode.getRealizer().setY(this.m_infoNode.getY() + var2 - this.m_y);
      this.m_y = var2;
   }
}
