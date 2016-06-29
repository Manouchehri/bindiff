package org.jfree.ui.tabbedui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;

public class VerticalLayout implements LayoutManager {
   private final boolean useSizeFromParent;

   public VerticalLayout() {
      this(true);
   }

   public VerticalLayout(boolean var1) {
      this.useSizeFromParent = var1;
   }

   public void addLayoutComponent(String var1, Component var2) {
   }

   public void removeLayoutComponent(Component var1) {
   }

   public Dimension preferredLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         Component[] var4 = var1.getComponents();
         int var5 = var3.top + var3.bottom;
         int var6 = var3.left + var3.right;

         for(int var7 = 0; var7 < var4.length; ++var7) {
            if(var4[var7].isVisible()) {
               Dimension var8 = var4[var7].getPreferredSize();
               var5 += var8.height;
               if(var8.width > var6) {
                  var6 = var8.width;
               }
            }
         }

         return new Dimension(var6 + var3.left + var3.right, var5 + var3.top + var3.bottom);
      }
   }

   public Dimension minimumLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         Component[] var4 = var1.getComponents();
         int var5 = var3.top + var3.bottom;
         int var6 = var3.left + var3.right;

         for(int var7 = 0; var7 < var4.length; ++var7) {
            if(var4[var7].isVisible()) {
               Dimension var8 = var4[var7].getMinimumSize();
               var5 += var8.height;
               if(var8.width > var6) {
                  var6 = var8.width;
               }
            }
         }

         return new Dimension(var6 + var3.left + var3.right, var5 + var3.top + var3.bottom);
      }
   }

   public boolean isUseSizeFromParent() {
      return this.useSizeFromParent;
   }

   public void layoutContainer(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         int var4 = var3.left + var3.right;
         int var5;
         if(this.isUseSizeFromParent()) {
            Rectangle var6 = var1.getBounds();
            var5 = var6.width - var4;
         } else {
            var5 = this.preferredLayoutSize(var1).width - var4;
         }

         Component[] var13 = var1.getComponents();
         int var7 = var3.top;

         for(int var8 = 0; var8 < var13.length; ++var8) {
            Component var9 = var13[var8];
            if(var9.isVisible()) {
               Dimension var10 = var9.getPreferredSize();
               var9.setBounds(var3.left, var7, var5, var10.height);
               var7 += var10.height;
            }
         }

      }
   }
}
