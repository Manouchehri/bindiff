package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageThreeBarExtendedCellData;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class PercentageThreeBarExtendedBarIcon implements Icon {
   private final String leftText;
   private final String centerText;
   private final String rightText;
   private final int leftValue;
   private final int centerValue;
   private final int innerCenterValue;
   private final int rightValue;
   private final boolean selected;
   private int width;
   private final int height;
   private final int xOffset;
   private final int yOffset;
   private final Color leftBarColor;
   private final Color centerBarColor;
   private final Color innerCenterBarColor;
   private final Color rightBarColor;
   private final Color emptyBarColor;
   private final Color textColor;
   private final Color selectionColor;

   public PercentageThreeBarExtendedBarIcon(PercentageThreeBarExtendedCellData var1, Color var2, Color var3, Color var4, Color var5, Color var6, Color var7, Color var8, boolean var9, int var10, int var11, int var12, int var13) {
      this.leftText = Integer.toString(var1.getLeftBarValue());
      this.centerText = Integer.toString(var1.getCenterBarValue());
      this.rightText = Integer.toString(var1.getRightBarValue());
      this.leftValue = var1.getLeftBarValue();
      this.centerValue = var1.getCenterBarValue();
      this.innerCenterValue = var1.getInnerCenterBarValue();
      this.rightValue = var1.getRightBarValue();
      this.selected = var9;
      this.width = var12;
      this.height = var13;
      this.xOffset = var10;
      this.yOffset = var11;
      this.leftBarColor = var2;
      this.centerBarColor = var3;
      this.innerCenterBarColor = var4;
      this.rightBarColor = var5;
      this.emptyBarColor = var6;
      this.textColor = var7;
      this.selectionColor = var8;
   }

   private void drawText(Graphics2D var1) {
      Color var2 = var1.getColor();
      Composite var3 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Rectangle2D var4 = var1.getFontMetrics(var1.getFont()).getStringBounds(this.leftText, var1);
      Rectangle2D var5 = var1.getFontMetrics(var1.getFont()).getStringBounds(this.centerText, var1);
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
         var1.setColor(this.textColor);
         var1.drawString(this.leftText, var14, var12);
         var1.drawString(this.centerText, var15, var12);
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
      int var9 = this.leftValue + this.centerValue + this.rightValue;
      int var10 = 0;
      int var11 = 0;
      boolean var12 = false;
      if(var9 != 0) {
         int var13 = 0;
         if(this.leftValue != 0) {
            var10 = (this.width - 2) * this.leftValue / var9;
            var7.setColor(this.leftBarColor);
            var7.fillRect(var5, var6, (double)(this.centerValue + this.rightValue) == 0.0D?this.width:var10, this.height);
            if(var10 > 1) {
               ++var13;
            }
         }

         if(this.centerValue != 0) {
            var11 = (this.width - 2) * this.centerValue / var9;
            var7.setColor(this.centerBarColor);
            var7.fillRect(var5 + var10 + var13, var6, this.rightValue == 0?this.width - var10 - var13:var11, this.height);
            if(this.innerCenterValue != 0) {
               int var17 = (var11 - 2) * this.innerCenterValue / this.centerValue;
               if(var17 > 0) {
                  int var14 = var5 + var10 + var13 + 1;
                  if((double)this.rightValue == 0.0D) {
                     ++var14;
                  } else if(this.leftValue == 0) {
                     --var17;
                     ++var14;
                  }

                  var7.setColor(this.innerCenterBarColor);
                  var7.fillRect(var14, var6 + 3, (double)this.rightValue == 0.0D?this.width - var10 - var11 + var17 - var13 - 1:var17, this.height - 5);
               }
            }

            if(var10 > 1) {
               ++var13;
            }
         }

         if(this.rightValue != 0) {
            if(var10 <= 1) {
               ++var13;
            }

            if(var10 <= 1 && var11 <= 1) {
               var13 -= 2;
            }

            var7.setColor(this.rightBarColor);
            var7.fillRect(var5 + var10 + var11 + var13, var6, this.width - var10 - var11 - var13, this.height);
         }

         if(this.selected) {
            var7.setColor(this.selectionColor);
            var7.drawRect(var5, var6, this.width, this.height);
            Composite var18 = var7.getComposite();
            var7.setComposite(AlphaComposite.getInstance(3, 0.6F));
            var7.fillRect(var5, var6, this.width, this.height);
            var7.setComposite(var18);
         } else {
            var7.setColor(Color.WHITE);
            var7.drawRect(var5, var6, this.width, this.height);
         }

         this.drawText(var7);
      } else {
         var7.setColor(this.emptyBarColor);
         var7.fillRect(var5 + 1, var6 + 1, this.width - 1, this.height - 1);
         if(this.selected) {
            var7.setComposite(AlphaComposite.getInstance(3, 0.6F));
            var7.setColor(this.selectionColor);
            var7.fillRect(var5, var6, this.width, this.height);
            var7.setComposite(AlphaComposite.getInstance(3, 1.0F));
            var7.drawRect(var5, var6, this.width, this.height);
         }

         Composite var20 = var7.getComposite();
         var7.setComposite(AlphaComposite.getInstance(3, 1.0F));
         Rectangle2D var19 = var7.getFontMetrics(var7.getFont()).getStringBounds("0", var7);
         int var15 = (int)(((double)this.width - var19.getWidth()) / 2.0D) + 1;
         int var16 = (int)(((double)this.height - var19.getHeight()) / 2.0D + var19.getHeight()) - 1;
         var7.setColor(this.textColor);
         var7.drawString(this.centerText, var15, var16);
         var7.setComposite(var20);
      }

      var7.setColor(var8);
      var2.translate(-var5, -var6);
   }

   public void setWidth(int var1) {
      this.width = var1;
   }
}
