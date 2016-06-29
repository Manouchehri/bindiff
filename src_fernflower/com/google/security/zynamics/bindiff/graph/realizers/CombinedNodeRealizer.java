package com.google.security.zynamics.bindiff.graph.realizers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.IZyNodeRealizerListener;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyNodeRealizer;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.dr;
import y.h.fj;

public class CombinedNodeRealizer extends ZyNodeRealizer {
   private static final byte SHADOW_SIZE = 8;
   private static final Color SHADOW_COLOR;
   private static final int SEPARATOR_GAP = 12;
   private final ZyLabelContent leftContent;
   private final ZyLabelContent rightContent;
   private final Rectangle2D bounds = new Rectangle();
   private ESide activeContentSide;

   public CombinedNodeRealizer(ZyLabelContent var1, ZyLabelContent var2) {
      this.leftContent = var1;
      this.rightContent = var2;
      this.activeContentSide = var1 != null?ESide.PRIMARY:ESide.SECONDARY;
      this.setShapeType((byte)1);
      this.setLineType(dr.b);
      this.setDropShadowOffsetX((byte)8);
      this.setDropShadowOffsetY((byte)8);
      this.setDropShadowColor(SHADOW_COLOR);
      this.setNodeSize();
   }

   private boolean isUnmatched() {
      return this.leftContent == null || this.rightContent == null;
   }

   private void setNodeSize() {
      if(this.isUnmatched()) {
         this.bounds.setRect(this.getNodeContent().getBounds());
      } else {
         double var1 = this.leftContent.getBounds().getX();
         double var3 = this.leftContent.getBounds().getY();
         double var5 = Math.max(this.leftContent.getBounds().getHeight(), this.rightContent.getBounds().getHeight());
         double var7 = this.leftContent.getBounds().getWidth() + 12.0D + this.rightContent.getBounds().getWidth();
         this.bounds.setRect(var1, var3, var7, var5);
      }

      this.setSize(this.bounds.getWidth(), this.bounds.getHeight());
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

   public void addListener(IZyNodeRealizerListener var1) {
   }

   public void removeListener(IZyNodeRealizerListener var1) {
   }

   public ZyLabelContent getNodeContent() {
      return this.isUnmatched()?(this.leftContent == null?this.rightContent:this.leftContent):(this.activeContentSide == ESide.PRIMARY?this.leftContent:this.rightContent);
   }

   public fj getRealizer() {
      return this;
   }

   public void paintHotSpots(Graphics2D var1) {
   }

   public void paintText(Graphics2D var1) {
      if(this.leftContent != null && this.rightContent == null) {
         this.leftContent.draw(var1, this.getX(), this.getY());
      } else if(this.leftContent == null && this.rightContent != null) {
         this.rightContent.draw(var1, this.getX(), this.getY());
      } else {
         double var2 = this.leftContent.getBounds().getWidth();
         int var4 = (int)Math.round(this.getX() + var2 + 6.0D - 1.0D);
         int var5 = (int)Math.round(this.getY() + 1.0D);
         int var6 = (int)Math.round(this.getY() + this.bounds.getHeight() - 1.0D);
         var1.setStroke(new BasicStroke(1.0F));
         this.leftContent.draw(var1, this.getX(), this.getY());
         this.rightContent.draw(var1, this.getX() + 12.0D + var2, this.getY());
         var1.setColor(Color.BLACK);
         var1.setStroke(new BasicStroke(2.0F));
         var1.drawLine(var4, var5, var4, var6);
      }

      super.paintText(var1);
   }

   public void regenerate() {
      if(this.isUnmatched()) {
         super.regenerate();
      } else {
         double var1 = this.leftContent.getBounds().getWidth() + 12.0D + this.rightContent.getBounds().getWidth();
         double var3 = this.leftContent.getBounds().getHeight() + this.rightContent.getBounds().getHeight();
         this.getUpdater().generateContent(this, this.leftContent);
         this.getUpdater().generateContent(this, this.rightContent);
         this.setNodeSize();
         this.scalePortCoordinates(this.getNode(), var1, this.bounds.getWidth(), var3, this.bounds.getHeight());
         this.notifyHasRegenerated();
         this.repaint();
      }
   }

   public void setActiveContent(ESide var1) {
      if(!this.isUnmatched()) {
         this.activeContentSide = var1;
      }

   }

   public void updateContentSelectionColor() {
      if(this.isUnmatched()) {
         super.updateContentSelectionColor();
      }
   }

   static {
      SHADOW_COLOR = Color.GRAY;
   }
}
