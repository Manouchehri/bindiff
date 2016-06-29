package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IRealizerUpdater;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import y.h.dr;
import y.h.fj;

public class ZyProximityNodeRealizer extends ZyNodeRealizer {
   private static Color m_backGroundColor = new Color(250, 250, 255);
   private final ZyLabelContent m_content;

   public ZyProximityNodeRealizer(ZyLabelContent var1) {
      Preconditions.checkNotNull(var1, "Error: Node content can\'t be null.");
      this.m_content = var1;
      this.setShapeType((byte)2);
      this.setLineType(dr.b);
      this.setDropShadowOffsetX((byte)0);
      this.setDropShadowOffsetY((byte)0);
      this.setFillColor(m_backGroundColor);
      setSloppySelectionColor(m_backGroundColor);
      Rectangle2D var2 = this.getNodeContent().getBounds();
      double var3 = Math.max(var2.getWidth(), var2.getHeight());
      this.setSize(var3, var3);
   }

   protected void paintFilledShape(Graphics2D var1) {
      var1.setComposite(AlphaComposite.getInstance(3, 0.66F));
      super.paintFilledShape(var1);
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
   }

   public void addListener(IZyNodeRealizerListener var1) {
   }

   public ZyLabelContent getNodeContent() {
      return this.m_content;
   }

   public fj getRealizer() {
      return this;
   }

   public void paintHotSpots(Graphics2D var1) {
   }

   public void paintNode(Graphics2D var1) {
      super.paintNode(var1);
      Rectangle2D var2 = this.getNodeContent().getBounds();
      double var3 = this.getWidth() / var2.getWidth();
      double var5 = this.getHeight() / var2.getHeight();
      var1.scale(var3, var5);
      this.getNodeContent().draw(var1, this.getX() * 1.0D / var3, this.getY() * 1.0D / var5);
      var1.scale(1.0D / var3, 1.0D / var5);
   }

   public void paintSloppy(Graphics2D var1) {
      super.paintFilledShape(var1);
      super.paintShapeBorder(var1);
   }

   public void removeListener(IZyNodeRealizerListener var1) {
   }

   public void setSelected(boolean var1) {
   }

   public void setUpdater(IRealizerUpdater var1) {
   }
}
