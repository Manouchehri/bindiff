package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.renderers;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

public class BackgroundIcon implements Icon {
   private final String text;
   private final int horizontalAlignment;
   private final int height;
   private final int xOffset;
   private final int yOffset;
   private int width;
   private final Color backgroundColor;
   private final Color selectionColor;
   private final Color textColor;
   private final boolean selected;

   public BackgroundIcon(String var1, int var2, Color var3, Color var4, Color var5, boolean var6, int var7, int var8, int var9, int var10) {
      this.text = var1;
      this.horizontalAlignment = var2;
      this.textColor = var3;
      this.backgroundColor = var4;
      this.selectionColor = var5;
      this.selected = var6;
      this.width = var9;
      this.height = var10;
      this.xOffset = var7;
      this.yOffset = var8;
   }

   private void drawText(Graphics2D var1) {
      Color var2 = var1.getColor();
      var1.setColor(this.textColor);
      Composite var3 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Rectangle2D var4 = var1.getFontMetrics(var1.getFont()).getStringBounds(this.text, var1);
      double var5 = 4.0D + var4.getWidth() + 4.0D;
      int var7 = 4;
      int var8 = (int)(((double)this.height - var4.getHeight()) / 2.0D + var4.getHeight()) - 2;
      if(var5 < (double)this.width) {
         if(this.horizontalAlignment == 0) {
            var7 = (int)(((double)this.width - var4.getWidth()) / 2.0D) + 1;
         } else if(this.horizontalAlignment == 4) {
            var7 = (int)((double)this.width - var4.getWidth() - 4.0D);
         }

         var1.drawString(this.text, var7, var8);
      } else {
         String var9 = "...";
         String var10 = this.text;

         while(var10.length() > 2) {
            var10 = var10.substring(0, var10.length() - 2);
            var4 = var1.getFontMetrics(var1.getFont()).getStringBounds(String.valueOf(var10).concat("..."), var1);
            if(var4.getWidth() + 8.0D < (double)this.width) {
               var9 = String.valueOf(var10).concat("...");
               break;
            }
         }

         var7 = 4;
         if(this.horizontalAlignment == 0) {
            var7 = (int)(((double)this.width - var4.getWidth()) / 2.0D) + 1;
         } else if(this.horizontalAlignment == 4) {
            var7 = (int)((double)this.width - var4.getWidth() - 4.0D);
         }

         var1.getFontMetrics(var1.getFont()).getStringBounds(var9, var1);
         var1.drawString(var9, var7, var8);
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
      var7.setColor(this.backgroundColor);
      var7.fillRect(var5, var6, this.width, this.height);
      if(this.selected) {
         Composite var9 = var7.getComposite();
         var7.setComposite(AlphaComposite.getInstance(3, 0.6F));
         var7.setColor(this.selectionColor);
         var7.fillRect(var5, var6, this.width, this.height);
         var7.setComposite(AlphaComposite.getInstance(3, 1.0F));
         var7.drawRect(var5, var6, this.width - 1, this.height - 1);
         var7.setComposite(var9);
      }

      this.drawText(var7);
      var7.setColor(var8);
      var2.translate(-var5, -var6);
   }

   public void setWidth(int var1) {
      this.width = var1;
   }
}
