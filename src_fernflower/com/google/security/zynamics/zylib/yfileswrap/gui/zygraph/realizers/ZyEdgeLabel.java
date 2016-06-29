package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import y.h.aA;

public class ZyEdgeLabel extends aA {
   private static final int SHADOW_SIZE = 5;
   private static Color m_backGroundColor = new Color(250, 250, 255);
   private static Color borderColor;
   private final ZyLabelContent m_content;
   private final int m_roundedHeight;
   private final int m_roundedWidth;
   private final double m_height;
   private final double m_width;

   public ZyEdgeLabel(ZyLabelContent var1) {
      Preconditions.checkNotNull(var1, "Internal Error: Content can\'t be null");
      this.m_content = var1;
      this.setVisible(true);
      this.setText("A");
      this.setModel((byte)1);
      this.setPreferredPlacement((byte)8);
      this.setPosition((byte)12);
      this.m_height = this.getHeight();
      this.m_width = this.getWidth();
      this.m_roundedHeight = (int)this.m_height;
      this.m_roundedWidth = (int)this.m_width;
   }

   protected void paintBox(Graphics2D var1, double var2, double var4, double var6, double var8) {
      int var10 = (int)(var2 - this.m_width / 2.0D);
      int var11 = (int)(var4 - this.m_height / 2.0D);
      BasicStroke var12 = (BasicStroke)var1.getStroke();
      var1.setStroke(new BasicStroke(var12.getLineWidth()));
      var1.setColor(m_backGroundColor);
      var1.setComposite(AlphaComposite.getInstance(3, 0.8F));
      var1.fillRoundRect(var10, var11, this.m_roundedWidth, this.m_roundedHeight, 5, 5);
      var1.setComposite(AlphaComposite.getInstance(3, 0.95F));
      var1.setColor(borderColor);
      var1.drawRoundRect(var10, var11, this.m_roundedWidth, this.m_roundedHeight, 5, 5);
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      var1.setStroke(var12);
   }

   protected void paintContent(Graphics2D var1, double var2, double var4, double var6, double var8) {
      int var10 = (int)(var2 - this.m_width / 2.0D);
      int var11 = (int)(var4 - this.m_height / 2.0D);
      this.m_content.draw(var1, (double)var10, (double)var11);
   }

   public double getHeight() {
      return this.m_content.getBounds().getHeight();
   }

   public ZyLabelContent getLabelContent() {
      return this.m_content;
   }

   public double getWidth() {
      return this.m_content.getBounds().getWidth();
   }

   static {
      borderColor = Color.BLACK;
   }
}
