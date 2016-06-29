package org.jfree.layout;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.io.Serializable;

public class RadialLayout implements LayoutManager, Serializable {
   private static final long serialVersionUID = -7582156799248315534L;
   private int minWidth = 0;
   private int minHeight = 0;
   private int maxCompWidth = 0;
   private int maxCompHeight = 0;
   private int preferredWidth = 0;
   private int preferredHeight = 0;
   private boolean sizeUnknown = true;

   public void addLayoutComponent(Component var1) {
   }

   public void removeLayoutComponent(Component var1) {
   }

   public void addLayoutComponent(String var1, Component var2) {
   }

   public void removeLayoutComponent(String var1, Component var2) {
   }

   private void setSizes(Container var1) {
      int var2 = var1.getComponentCount();
      this.preferredWidth = 0;
      this.preferredHeight = 0;
      this.minWidth = 0;
      this.minHeight = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         Component var4 = var1.getComponent(var3);
         if(var4.isVisible()) {
            Dimension var5 = var4.getPreferredSize();
            if(this.maxCompWidth < var5.width) {
               this.maxCompWidth = var5.width;
            }

            if(this.maxCompHeight < var5.height) {
               this.maxCompHeight = var5.height;
            }

            this.preferredWidth += var5.width;
            this.preferredHeight += var5.height;
         }
      }

      this.preferredWidth /= 2;
      this.preferredHeight /= 2;
      this.minWidth = this.preferredWidth;
      this.minHeight = this.preferredHeight;
   }

   public Dimension preferredLayoutSize(Container var1) {
      Dimension var2 = new Dimension(0, 0);
      this.setSizes(var1);
      Insets var3 = var1.getInsets();
      var2.width = this.preferredWidth + var3.left + var3.right;
      var2.height = this.preferredHeight + var3.top + var3.bottom;
      this.sizeUnknown = false;
      return var2;
   }

   public Dimension minimumLayoutSize(Container var1) {
      Dimension var2 = new Dimension(0, 0);
      Insets var3 = var1.getInsets();
      var2.width = this.minWidth + var3.left + var3.right;
      var2.height = this.minHeight + var3.top + var3.bottom;
      this.sizeUnknown = false;
      return var2;
   }

   public void layoutContainer(Container var1) {
      Insets var2 = var1.getInsets();
      int var10001 = var2.left + var2.right;
      int var3 = var1.getSize().width - var10001;
      var10001 = var2.top + var2.bottom;
      int var4 = var1.getSize().height - var10001;
      int var5 = var1.getComponentCount();
      byte var6 = 0;
      byte var7 = 0;
      if(this.sizeUnknown) {
         this.setSizes(var1);
      }

      if(var5 < 2) {
         Component var8 = var1.getComponent(0);
         if(var8.isVisible()) {
            Dimension var9 = var8.getPreferredSize();
            var8.setBounds(var6, var7, var9.width, var9.height);
         }
      } else {
         double var21 = Math.toRadians(90.0D);
         double var10 = 6.283185307179586D / (double)var5;
         int var12 = var3 / 2;
         int var13 = var4 / 2;
         int var14 = var12 - this.maxCompWidth;
         int var15 = var13 - this.maxCompHeight;

         for(int var16 = 0; var16 < var5; ++var16) {
            Component var17 = var1.getComponent(var16);
            if(var17.isVisible()) {
               Dimension var18 = var17.getPreferredSize();
               int var19 = (int)((double)var12 - (double)var14 * Math.cos(var21) - var18.getWidth() / 2.0D + (double)var2.left);
               int var20 = (int)((double)var13 - (double)var15 * Math.sin(var21) - var18.getHeight() / 2.0D + (double)var2.top);
               var17.setBounds(var19, var20, var18.width, var18.height);
            }

            var21 += var10;
         }
      }

   }

   public String toString() {
      return this.getClass().getName();
   }

   public static void main(String[] var0) {
      Frame var1 = new Frame();
      Panel var2 = new Panel();
      var2.setLayout(new RadialLayout());
      var2.add(new Checkbox("One"));
      var2.add(new Checkbox("Two"));
      var2.add(new Checkbox("Three"));
      var2.add(new Checkbox("Four"));
      var2.add(new Checkbox("Five"));
      var2.add(new Checkbox("One"));
      var2.add(new Checkbox("Two"));
      var2.add(new Checkbox("Three"));
      var2.add(new Checkbox("Four"));
      var2.add(new Checkbox("Five"));
      var1.add(var2);
      var1.setSize(300, 500);
      var1.setVisible(true);
   }
}
