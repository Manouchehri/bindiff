package org.jfree.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;

public final class OverlayLayout implements LayoutManager {
   private boolean ignoreInvisible;

   public OverlayLayout(boolean var1) {
      this.ignoreInvisible = var1;
   }

   public OverlayLayout() {
   }

   public void addLayoutComponent(String var1, Component var2) {
   }

   public void removeLayoutComponent(Component var1) {
   }

   public void layoutContainer(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         Rectangle var4 = var1.getBounds();
         int var5 = var4.width - var3.left - var3.right;
         int var6 = var4.height - var3.top - var3.bottom;
         Component[] var7 = var1.getComponents();

         for(int var8 = 0; var8 < var7.length; ++var8) {
            Component var9 = var7[var8];
            if(var7[var8].isVisible() || !this.ignoreInvisible) {
               var9.setBounds(var3.left, var3.top, var5, var6);
            }
         }

      }
   }

   public Dimension minimumLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         Component[] var4 = var1.getComponents();
         int var5 = 0;
         int var6 = 0;

         for(int var7 = 0; var7 < var4.length; ++var7) {
            if(var4[var7].isVisible() || !this.ignoreInvisible) {
               Dimension var8 = var4[var7].getMinimumSize();
               if(var8.height > var5) {
                  var5 = var8.height;
               }

               if(var8.width > var6) {
                  var6 = var8.width;
               }
            }
         }

         return new Dimension(var6 + var3.left + var3.right, var5 + var3.top + var3.bottom);
      }
   }

   public Dimension preferredLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         Component[] var4 = var1.getComponents();
         int var5 = 0;
         int var6 = 0;

         for(int var7 = 0; var7 < var4.length; ++var7) {
            if(var4[var7].isVisible() || !this.ignoreInvisible) {
               Dimension var8 = var4[var7].getPreferredSize();
               if(var8.height > var5) {
                  var5 = var8.height;
               }

               if(var8.width > var6) {
                  var6 = var8.width;
               }
            }
         }

         return new Dimension(var6 + var3.left + var3.right, var5 + var3.top + var3.bottom);
      }
   }
}
