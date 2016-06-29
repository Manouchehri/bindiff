package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers.PercentageTwoBarExtendedCellData;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class PercentageTwoBarExtendedIcon implements Icon {
   private String leftText;
   private String totalText;
   private String rightText;
   private int leftValue;
   private int innerLeftValue;
   private int rightValue;
   private int width;
   private final int height;
   private final int xOffset;
   private final int yOffset;
   private final Color leftBarColor;
   private final Color innerLeftBarColor;
   private final Color rightBarColor;
   private final Color emptyBarColor;
   private final Color textColor;

   public PercentageTwoBarExtendedIcon(PercentageTwoBarExtendedCellData var1, Color var2, Color var3, Color var4, Color var5, Color var6, int var7, int var8, int var9, int var10) {
      this.totalText = Integer.toString(var1.getTotalBarValue());
      this.leftText = var1.getLeftBarString(true, true);
      this.rightText = var1.getRightBarString(true);
      this.leftValue = var1.getLeftBarValue();
      this.innerLeftValue = var1.getInnerLeftBarValue();
      this.rightValue = var1.getRightBarValue();
      this.width = var9;
      this.height = var10;
      this.xOffset = var7;
      this.yOffset = var8;
      this.leftBarColor = var2;
      this.innerLeftBarColor = var3;
      this.rightBarColor = var4;
      this.emptyBarColor = var5;
      this.textColor = var6;
   }

   private void drawText(Graphics2D var1) {
      Color var2 = var1.getColor();
      Composite var3 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Rectangle2D var4 = var1.getFontMetrics(var1.getFont()).getStringBounds(String.valueOf(this.leftText).concat("----"), var1);
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
         var1.setColor(this.textColor);
         var1.drawString(this.leftText, var14, var12);
         var1.setColor(this.textColor);
         var1.drawString(this.totalText, var15, var12);
         var1.setColor(this.textColor);
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
      int var9 = this.leftValue + this.rightValue;
      if(var9 != 0) {
         int var10 = 0;
         if(this.leftValue != 0) {
            var10 = (this.width - 2) * this.leftValue / var9;
            var7.setColor(this.leftBarColor);
            var7.fillRect(var5, var6, (double)this.rightValue == 0.0D?this.width:var10, this.height);
            int var11 = (this.width - 2) * this.innerLeftValue / var9;
            var11 -= 2;
            if(var11 + 5 > var10) {
               var11 = var10 - 14;
            }

            if(var11 > 0) {
               var7.setColor(this.innerLeftBarColor);
               var7.fillRect(var5 + 5, var6 + 5, (double)this.rightValue == 0.0D?this.width - 4:var11 - 2, this.height - 7);
            }
         }

         if(this.rightValue != 0) {
            var7.setColor(this.rightBarColor);
            var7.fillRect(var5 + var10 + 1, var6, this.width - var10 - 1, this.height);
         }

         var7.setColor(Color.WHITE);
         var7.drawRect(var5, var6, this.width, this.height);
         this.drawText(var7);
      } else {
         var7.setColor(this.emptyBarColor);
         var7.fillRect(var5 + 1, var6 + 1, this.width, this.height);
         Composite var14 = var7.getComposite();
         var7.setComposite(AlphaComposite.getInstance(3, 1.0F));
         Rectangle2D var15 = var7.getFontMetrics(var7.getFont()).getStringBounds("0", var7);
         int var12 = (int)(((double)this.width - var15.getWidth()) / 2.0D) + 1;
         int var13 = (int)(((double)this.height - var15.getHeight()) / 2.0D + var15.getHeight()) - 1;
         var7.setColor(this.textColor);
         var7.drawString(this.totalText, var12, var13);
         var7.setComposite(var14);
      }

      var7.setColor(var8);
      var2.translate(-var5, -var6);
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public void updateData(int var1, int var2, int var3) {
      PercentageTwoBarExtendedCellData var4 = new PercentageTwoBarExtendedCellData(var1, var2, var3);
      this.totalText = Integer.toString(var4.getTotalBarValue());
      this.leftText = var4.getLeftBarString(true, true);
      this.rightText = var4.getRightBarString(true);
      this.leftValue = var4.getLeftBarValue();
      this.innerLeftValue = var4.getInnerLeftBarValue();
      this.rightValue = var4.getRightBarValue();
   }
}
