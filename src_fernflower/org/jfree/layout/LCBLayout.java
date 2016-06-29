package org.jfree.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.Serializable;

public class LCBLayout implements LayoutManager, Serializable {
   private static final long serialVersionUID = -2531780832406163833L;
   private static final int COLUMNS = 3;
   private int[] colWidth = new int[3];
   private int[] rowHeight;
   private int labelGap = 10;
   private int buttonGap = 6;
   private int vGap = 2;

   public LCBLayout(int var1) {
      this.rowHeight = new int[var1];
   }

   public Dimension preferredLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         int var4 = var1.getComponentCount();
         int var5 = var4 / 3;

         int var6;
         int var7;
         for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < var5; ++var7) {
               Component var8 = var1.getComponent(var7 * 3 + var6);
               Dimension var9 = var8.getPreferredSize();
               if(this.colWidth[var6] < var9.width) {
                  this.colWidth[var6] = var9.width;
               }

               if(this.rowHeight[var7] < var9.height) {
                  this.rowHeight[var7] = var9.height;
               }
            }
         }

         var6 = this.vGap * (var5 - 1);

         for(var7 = 0; var7 < var5; ++var7) {
            var6 += this.rowHeight[var7];
         }

         var7 = this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2];
         return new Dimension(var3.left + var3.right + var7 + this.labelGap + this.buttonGap, var3.top + var3.bottom + var6 + this.vGap);
      }
   }

   public Dimension minimumLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         int var4 = var1.getComponentCount();
         int var5 = var4 / 3;

         int var6;
         int var7;
         for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < var5; ++var7) {
               Component var8 = var1.getComponent(var7 * 3 + var6);
               Dimension var9 = var8.getMinimumSize();
               if(this.colWidth[var6] < var9.width) {
                  this.colWidth[var6] = var9.width;
               }

               if(this.rowHeight[var7] < var9.height) {
                  this.rowHeight[var7] = var9.height;
               }
            }
         }

         var6 = this.vGap * (var5 - 1);

         for(var7 = 0; var7 < var5; ++var7) {
            var6 += this.rowHeight[var7];
         }

         var7 = this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2];
         return new Dimension(var3.left + var3.right + var7 + this.labelGap + this.buttonGap, var3.top + var3.bottom + var6 + this.vGap);
      }
   }

   public void layoutContainer(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var3 = var1.getInsets();
         int var4 = var1.getComponentCount();
         int var5 = var4 / 3;

         int var6;
         int var7;
         for(var6 = 0; var6 < 3; ++var6) {
            for(var7 = 0; var7 < var5; ++var7) {
               Component var8 = var1.getComponent(var7 * 3 + var6);
               Dimension var9 = var8.getPreferredSize();
               if(this.colWidth[var6] < var9.width) {
                  this.colWidth[var6] = var9.width;
               }

               if(this.rowHeight[var7] < var9.height) {
                  this.rowHeight[var7] = var9.height;
               }
            }
         }

         var6 = this.vGap * (var5 - 1);

         for(var7 = 0; var7 < var5; ++var7) {
            var6 += this.rowHeight[var7];
         }

         var7 = this.colWidth[0] + this.colWidth[1] + this.colWidth[2];
         int var20 = var1.getWidth() - var3.left - var3.right - this.labelGap - this.buttonGap;
         this.colWidth[1] += var20 - var7;
         int var21 = var3.left;

         for(int var10 = 0; var10 < 3; ++var10) {
            int var11 = var3.top;

            for(int var12 = 0; var12 < var5; ++var12) {
               int var13 = var12 * 3 + var10;
               if(var13 < var4) {
                  Component var14 = var1.getComponent(var13);
                  Dimension var15 = var14.getPreferredSize();
                  int var16 = var15.height;
                  int var17 = (this.rowHeight[var12] - var16) / 2;
                  var1.getComponent(var13).setBounds(var21, var11 + var17, this.colWidth[var10], var16);
               }

               var11 = var11 + this.rowHeight[var12] + this.vGap;
            }

            var21 += this.colWidth[var10];
            if(var10 == 0) {
               var21 += this.labelGap;
            }

            if(var10 == 1) {
               var21 += this.buttonGap;
            }
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
