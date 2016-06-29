package org.jfree.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.Serializable;

public class CenterLayout implements LayoutManager, Serializable {
   private static final long serialVersionUID = 469319532333015042L;

   public Dimension preferredLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         if(var1.getComponentCount() > 0) {
            Component var4 = var1.getComponent(0);
            Dimension var5 = var4.getPreferredSize();
            return new Dimension((int)var5.getWidth() + var3.left + var3.right, (int)var5.getHeight() + var3.top + var3.bottom);
         } else {
            return new Dimension(var3.left + var3.right, var3.top + var3.bottom);
         }
      }
   }

   public Dimension minimumLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         if(var1.getComponentCount() > 0) {
            Component var4 = var1.getComponent(0);
            Dimension var5 = var4.getMinimumSize();
            return new Dimension(var5.width + var3.left + var3.right, var5.height + var3.top + var3.bottom);
         } else {
            return new Dimension(var3.left + var3.right, var3.top + var3.bottom);
         }
      }
   }

   public void layoutContainer(Container var1) {
      synchronized(var1.getTreeLock()) {
         if(var1.getComponentCount() > 0) {
            Insets var3 = var1.getInsets();
            Dimension var4 = var1.getSize();
            Component var5 = var1.getComponent(0);
            Dimension var6 = var5.getPreferredSize();
            int var7 = var3.left + Math.max((var4.width - var3.left - var3.right - var6.width) / 2, 0);
            int var8 = var3.top + Math.max((var4.height - var3.top - var3.bottom - var6.height) / 2, 0);
            var5.setBounds(var7, var8, var6.width, var6.height);
         }

      }
   }

   public void addLayoutComponent(Component var1) {
   }

   public void removeLayoutComponent(Component var1) {
   }

   public void addLayoutComponent(String var1, Component var2) {
   }

   public void removeLayoutComponent(String var1, Component var2) {
   }
}
