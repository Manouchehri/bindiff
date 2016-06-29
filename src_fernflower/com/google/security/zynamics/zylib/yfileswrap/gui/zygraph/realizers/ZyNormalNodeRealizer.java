package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import y.h.dr;
import y.h.fj;

public class ZyNormalNodeRealizer extends ZyNodeRealizer {
   private static final byte SHADOW_SIZE = 8;
   private static final Color SHADOW_COLOR;
   private final ZyLabelContent m_content;

   public ZyNormalNodeRealizer(ZyLabelContent var1) {
      Preconditions.checkNotNull(var1, "Error: Node content can\'t be null.");
      this.m_content = var1;
      this.setShapeType((byte)1);
      this.setLineType(dr.b);
      this.setDropShadowOffsetX((byte)8);
      this.setDropShadowOffsetY((byte)8);
      this.setDropShadowColor(SHADOW_COLOR);
      Rectangle2D var2 = this.getNodeContent().getBounds();
      this.setSize(var2.getWidth(), var2.getHeight());
   }

   protected void paintShadow(Graphics2D var1) {
      if(!this.isSelected() && this.isDropShadowVisible()) {
         var1.setColor(SHADOW_COLOR);
         this.setDropShadowOffsetX((byte)8);
         this.setDropShadowOffsetY((byte)8);
         var1.setComposite(AlphaComposite.getInstance(3, 0.7F));
         super.paintShadow(var1);
         var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      }

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

   public String toString() {
      return this.m_content.toString();
   }

   static {
      SHADOW_COLOR = Color.GRAY;
   }
}
