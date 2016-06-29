package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarCellData;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class PercentageTwoBarIcon implements Icon {
   private String leftText;
   private String totalText;
   private String rightText;
   private int leftValue;
   private int rightValue;
   private int width;
   private final int height;
   private final int xOffset;
   private final int yOffset;
   private final Color leftBarColor;
   private final Color rightBarColor;
   private final Color emptyBarColor;
   private final Color leftTextColor;
   private final Color totalTextColor;
   private final Color rightTextColor;
   private final Color selectionColor;
   private final boolean selected;
   private boolean showAdditionalPercetageValues = false;

   public PercentageTwoBarIcon(PercentageTwoBarCellData var1, Color var2, Color var3, Color var4, Color var5, Color var6, Color var7, Color var8, boolean var9, int var10, int var11, int var12, int var13) {
      this.totalText = Integer.toString(var1.getTotalBarValue());
      this.leftText = Integer.toString(var1.getLeftBarValue());
      this.rightText = Integer.toString(var1.getRightBarValue());
      this.leftValue = var1.getLeftBarValue();
      this.rightValue = var1.getRightBarValue();
      this.selected = var9;
      this.width = var12;
      this.height = var13;
      this.xOffset = var10;
      this.yOffset = var11;
      this.leftBarColor = var2;
      this.rightBarColor = var3;
      this.emptyBarColor = var4;
      this.leftTextColor = var5;
      this.totalTextColor = var6;
      this.rightTextColor = var7;
      this.selectionColor = var8;
   }

   private void buildTexts() {
      // $FF: Couldn't be decompiled
   }

   private void drawText(Graphics2D var1) {
      Color var2 = var1.getColor();
      Composite var3 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Rectangle2D var4 = var1.getFontMetrics(var1.getFont()).getStringBounds(this.leftText, var1);
      Rectangle2D var5 = var1.getFontMetrics(var1.getFont()).getStringBounds(this.totalText, var1);
      Rectangle2D var6 = var1.getFontMetrics(var1.getFont()).getStringBounds(this.rightText, var1);
      double var7 = 4.0D + var4.getWidth() + 5.0D + var5.getWidth() + 5.0D + var6.getWidth() + 4.0D;
      boolean var9 = false;
      boolean var10 = false;
      boolean var11 = false;
      int var12 = (int)(((double)this.height - var5.getHeight()) / 2.0D + var5.getHeight()) - 1;
      int var15;
      if(var7 < (double)this.width) {
         byte var14 = 4;
         var15 = (int)(((double)this.width - var5.getWidth()) / 2.0D) + 1;
         int var16 = (int)((double)this.width - var6.getWidth() - 4.0D);
         var1.setColor(this.leftTextColor);
         var1.drawString(this.leftText, var14, var12);
         var1.setColor(this.totalTextColor);
         var1.drawString(this.totalText, var15, var12);
         var1.setColor(this.rightTextColor);
         var1.drawString(this.rightText, var16, var12);
      } else {
         String var13 = "...";
         var5 = var1.getFontMetrics(var1.getFont()).getStringBounds("...", var1);
         var15 = (int)(((double)this.width - var5.getWidth()) / 2.0D) + 1;
         var1.setColor(Color.BLACK);
         var1.drawString("...", var15, var12);
      }

      var1.setComposite(var3);
      var1.setColor(var2);
   }

   public int getIconHeight() {
      return this.height;
   }

   public int getIconWidth() {
      return this.width;
   }

   public void paintIcon(Component var1, Graphics var2, int var3, int var4) {
      int var5 = var3 + this.xOffset;
      int var6 = var4 + this.yOffset;
      var2.translate(var5, var6);
      Graphics2D var7 = (Graphics2D)var2;
      Color var8 = var7.getColor();
      if(this.leftValue + this.rightValue != 0) {
         int var9 = (this.width - 2) * this.leftValue / (this.leftValue + this.rightValue);
         var7.setColor(this.leftBarColor);
         var7.fillRect(var5, var6, (double)this.rightValue == 0.0D?this.width:var9, this.height);
         if(this.rightValue != 0) {
            var7.setColor(this.rightBarColor);
            var7.fillRect(var5 + var9 + 1, var6, this.width - var9 - 1, this.height);
         }

         if(this.selected) {
            var7.setColor(this.selectionColor);
            var7.drawRect(var5, var6, this.width, this.height);
            Composite var10 = var7.getComposite();
            var7.setComposite(AlphaComposite.getInstance(3, 0.6F));
            var7.fillRect(var5, var6, this.width, this.height);
            var7.setComposite(var10);
         } else {
            var7.setColor(Color.WHITE);
            var7.drawRect(var5, var6, this.width, this.height);
         }

         this.drawText(var7);
      } else {
         var7.setColor(this.emptyBarColor);
         var7.fillRect(var5 + 1, var6 + 1, this.width, this.height);
         if(this.selected) {
            var7.setComposite(AlphaComposite.getInstance(3, 0.6F));
            var7.setColor(this.selectionColor);
            var7.fillRect(var5, var6, this.width, this.height);
            var7.setComposite(AlphaComposite.getInstance(3, 1.0F));
            var7.drawRect(var5, var6, this.width, this.height);
         }

         Composite var13 = var7.getComposite();
         var7.setComposite(AlphaComposite.getInstance(3, 1.0F));
         Rectangle2D var14 = var7.getFontMetrics(var7.getFont()).getStringBounds("0", var7);
         int var11 = (int)(((double)this.width - var14.getWidth()) / 2.0D) + 1;
         int var12 = (int)(((double)this.height - var14.getHeight()) / 2.0D + var14.getHeight()) - 1;
         var7.setColor(this.totalTextColor);
         var7.drawString(this.totalText, var11, var12);
         var7.setComposite(var13);
      }

      var7.setColor(var8);
      var2.translate(-var5, -var6);
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public void showAdditionalPercetageValues(boolean var1) {
      this.showAdditionalPercetageValues = var1;
      this.buildTexts();
   }

   public void updateData(int var1, int var2) {
      PercentageTwoBarCellData var3 = new PercentageTwoBarCellData(var1, var2);
      this.totalText = Integer.toString(var3.getTotalBarValue());
      this.leftText = Integer.toString(var3.getLeftBarValue());
      this.rightText = Integer.toString(var3.getRightBarValue());
      this.leftValue = var3.getLeftBarValue();
      this.rightValue = var3.getRightBarValue();
   }
}
