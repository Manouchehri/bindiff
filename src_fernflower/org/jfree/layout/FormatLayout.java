package org.jfree.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.Serializable;

public class FormatLayout implements LayoutManager, Serializable {
   private static final long serialVersionUID = 2866692886323930722L;
   public static final int C = 1;
   public static final int LC = 2;
   public static final int LCB = 3;
   public static final int LCLC = 4;
   public static final int LCLCB = 5;
   public static final int LCBLC = 6;
   public static final int LCBLCB = 7;
   private int[] rowFormats;
   private int rowGap;
   private int[] columnGaps;
   private int[] rowHeights;
   private int totalHeight;
   private int[] columnWidths;
   private int totalWidth;
   private int columns1and2Width;
   private int columns4and5Width;
   private int columns1to4Width;
   private int columns1to5Width;
   private int columns0to5Width;

   public FormatLayout(int var1, int[] var2) {
      this.rowFormats = var2;
      this.rowGap = 2;
      this.columnGaps = new int[5];
      this.columnGaps[0] = 10;
      this.columnGaps[1] = 5;
      this.columnGaps[2] = 5;
      this.columnGaps[3] = 10;
      this.columnGaps[4] = 5;
      this.rowHeights = new int[var1];
      this.columnWidths = new int[6];
   }

   public Dimension preferredLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var9 = var1.getInsets();
         int var10 = 0;
         int var11 = this.rowHeights.length;

         int var12;
         for(var12 = 0; var12 < this.columnWidths.length; ++var12) {
            this.columnWidths[var12] = 0;
         }

         this.columns1and2Width = 0;
         this.columns4and5Width = 0;
         this.columns1to4Width = 0;
         this.columns1to5Width = 0;
         this.columns0to5Width = 0;
         this.totalHeight = 0;

         for(var12 = 0; var12 < var11; ++var12) {
            int var13 = this.rowFormats[var12 % this.rowFormats.length];
            Component var2;
            Component var3;
            Component var4;
            Component var5;
            Component var6;
            switch(var13) {
            case 1:
               var2 = var1.getComponent(var10);
               this.updateC(var12, var2.getPreferredSize());
               ++var10;
               break;
            case 2:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               this.updateLC(var12, var2.getPreferredSize(), var3.getPreferredSize());
               var10 += 2;
               break;
            case 3:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               this.updateLCB(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize());
               var10 += 3;
               break;
            case 4:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               this.updateLCLC(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize());
               var10 += 4;
               break;
            case 5:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               this.updateLCLCB(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize(), var6.getPreferredSize());
               var10 += 5;
               break;
            case 6:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               this.updateLCBLC(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize(), var6.getPreferredSize());
               var10 += 5;
               break;
            case 7:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               Component var7 = var1.getComponent(var10 + 5);
               this.updateLCBLCB(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize(), var6.getPreferredSize(), var7.getPreferredSize());
               var10 += 6;
            }
         }

         this.complete();
         return new Dimension(this.totalWidth + var9.left + var9.right, this.totalHeight + (var11 - 1) * this.rowGap + var9.top + var9.bottom);
      }
   }

   public Dimension minimumLayoutSize(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var9 = var1.getInsets();
         int var10 = 0;
         int var11 = this.rowHeights.length;

         for(int var12 = 0; var12 < this.columnWidths.length; ++var12) {
            this.columnWidths[var12] = 0;
         }

         this.columns1and2Width = 0;
         this.columns4and5Width = 0;
         this.columns1to4Width = 0;
         this.columns1to5Width = 0;
         this.columns0to5Width = 0;
         boolean var17 = false;

         for(int var13 = 0; var13 < var11; ++var13) {
            int var14 = this.rowFormats[var13 % this.rowFormats.length];
            Component var2;
            Component var3;
            Component var4;
            Component var5;
            Component var6;
            switch(var14) {
            case 1:
               var2 = var1.getComponent(var10);
               this.columns0to5Width = Math.max(this.columns0to5Width, var2.getMinimumSize().width);
               ++var10;
               break;
            case 2:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               this.updateLC(var13, var2.getMinimumSize(), var3.getMinimumSize());
               var10 += 2;
               break;
            case 3:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               this.updateLCB(var13, var2.getMinimumSize(), var3.getMinimumSize(), var4.getMinimumSize());
               var10 += 3;
               break;
            case 4:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               this.updateLCLC(var13, var2.getMinimumSize(), var3.getMinimumSize(), var4.getMinimumSize(), var5.getMinimumSize());
               var10 += 3;
               break;
            case 5:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               this.updateLCLCB(var13, var2.getMinimumSize(), var3.getMinimumSize(), var4.getMinimumSize(), var5.getMinimumSize(), var6.getMinimumSize());
               var10 += 4;
               break;
            case 6:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               this.updateLCBLC(var13, var2.getMinimumSize(), var3.getMinimumSize(), var4.getMinimumSize(), var5.getMinimumSize(), var6.getMinimumSize());
               var10 += 4;
               break;
            case 7:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               Component var7 = var1.getComponent(var10 + 5);
               this.updateLCBLCB(var13, var2.getMinimumSize(), var3.getMinimumSize(), var4.getMinimumSize(), var5.getMinimumSize(), var6.getMinimumSize(), var7.getMinimumSize());
               var10 += 5;
            }
         }

         this.complete();
         return new Dimension(this.totalWidth + var9.left + var9.right, 0 + (var11 - 1) * this.rowGap + var9.top + var9.bottom);
      }
   }

   public void layoutContainer(Container var1) {
      synchronized(var1.getTreeLock()) {
         Insets var9 = var1.getInsets();
         int var10 = 0;
         int var11 = this.rowHeights.length;

         int var12;
         for(var12 = 0; var12 < this.columnWidths.length; ++var12) {
            this.columnWidths[var12] = 0;
         }

         this.columns1and2Width = 0;
         this.columns4and5Width = 0;
         this.columns1to4Width = 0;
         this.columns1to5Width = 0;
         this.columns0to5Width = var1.getBounds().width - var9.left - var9.right;
         this.totalHeight = 0;

         Component var2;
         Component var3;
         Component var4;
         Component var5;
         Component var6;
         Component var7;
         for(var12 = 0; var12 < var11; ++var12) {
            int var13 = this.rowFormats[var12 % this.rowFormats.length];
            switch(var13) {
            case 1:
               var2 = var1.getComponent(var10);
               this.updateC(var12, var2.getPreferredSize());
               ++var10;
               break;
            case 2:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               this.updateLC(var12, var2.getPreferredSize(), var3.getPreferredSize());
               var10 += 2;
               break;
            case 3:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               this.updateLCB(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize());
               var10 += 3;
               break;
            case 4:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               this.updateLCLC(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize());
               var10 += 4;
               break;
            case 5:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               this.updateLCLCB(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize(), var6.getPreferredSize());
               var10 += 5;
               break;
            case 6:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               this.updateLCBLC(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize(), var6.getPreferredSize());
               var10 += 5;
               break;
            case 7:
               var2 = var1.getComponent(var10);
               var3 = var1.getComponent(var10 + 1);
               var4 = var1.getComponent(var10 + 2);
               var5 = var1.getComponent(var10 + 3);
               var6 = var1.getComponent(var10 + 4);
               var7 = var1.getComponent(var10 + 5);
               this.updateLCBLCB(var12, var2.getPreferredSize(), var3.getPreferredSize(), var4.getPreferredSize(), var5.getPreferredSize(), var6.getPreferredSize(), var7.getPreferredSize());
               var10 += 6;
            }
         }

         this.complete();
         var10 = 0;
         var12 = var9.top;
         int[] var23 = new int[6];
         var23[0] = var9.left;
         var23[1] = var23[0] + this.columnWidths[0] + this.columnGaps[0];
         var23[2] = var23[1] + this.columnWidths[1] + this.columnGaps[1];
         var23[3] = var23[2] + this.columnWidths[2] + this.columnGaps[2];
         var23[4] = var23[3] + this.columnWidths[3] + this.columnGaps[3];
         var23[5] = var23[4] + this.columnWidths[4] + this.columnGaps[4];
         int var14 = this.columnWidths[1] + this.columnGaps[1] + this.columnWidths[2];
         int var15 = this.columnWidths[4] + this.columnGaps[4] + this.columnWidths[5];
         int var16 = var14 + this.columnGaps[2] + this.columnWidths[3] + this.columnGaps[3] + this.columnWidths[4];
         int var17 = var16 + this.columnGaps[4] + this.columnWidths[5];
         int var18 = var17 + this.columnWidths[0] + this.columnGaps[0];

         for(int var19 = 0; var19 < var11; ++var19) {
            int var20 = this.rowFormats[var19 % this.rowFormats.length];
            switch(var20) {
            case 1:
               var2 = var1.getComponent(var10);
               var2.setBounds(var23[0], var12, var18, var2.getPreferredSize().height);
               ++var10;
               break;
            case 2:
               var2 = var1.getComponent(var10);
               var2.setBounds(var23[0], var12 + (this.rowHeights[var19] - var2.getPreferredSize().height) / 2, this.columnWidths[0], var2.getPreferredSize().height);
               var3 = var1.getComponent(var10 + 1);
               var3.setBounds(var23[1], var12 + (this.rowHeights[var19] - var3.getPreferredSize().height) / 2, var17, var3.getPreferredSize().height);
               var10 += 2;
               break;
            case 3:
               var2 = var1.getComponent(var10);
               var2.setBounds(var23[0], var12 + (this.rowHeights[var19] - var2.getPreferredSize().height) / 2, this.columnWidths[0], var2.getPreferredSize().height);
               var3 = var1.getComponent(var10 + 1);
               var3.setBounds(var23[1], var12 + (this.rowHeights[var19] - var3.getPreferredSize().height) / 2, var16, var3.getPreferredSize().height);
               var4 = var1.getComponent(var10 + 2);
               var4.setBounds(var23[5], var12 + (this.rowHeights[var19] - var4.getPreferredSize().height) / 2, this.columnWidths[5], var4.getPreferredSize().height);
               var10 += 3;
               break;
            case 4:
               var2 = var1.getComponent(var10);
               var2.setBounds(var23[0], var12 + (this.rowHeights[var19] - var2.getPreferredSize().height) / 2, this.columnWidths[0], var2.getPreferredSize().height);
               var3 = var1.getComponent(var10 + 1);
               var3.setBounds(var23[1], var12 + (this.rowHeights[var19] - var3.getPreferredSize().height) / 2, var14, var3.getPreferredSize().height);
               var4 = var1.getComponent(var10 + 2);
               var4.setBounds(var23[3], var12 + (this.rowHeights[var19] - var4.getPreferredSize().height) / 2, this.columnWidths[3], var4.getPreferredSize().height);
               var5 = var1.getComponent(var10 + 3);
               var5.setBounds(var23[4], var12 + (this.rowHeights[var19] - var5.getPreferredSize().height) / 2, var15, var5.getPreferredSize().height);
               var10 += 4;
               break;
            case 5:
               var2 = var1.getComponent(var10);
               var2.setBounds(var23[0], var12 + (this.rowHeights[var19] - var2.getPreferredSize().height) / 2, this.columnWidths[0], var2.getPreferredSize().height);
               var3 = var1.getComponent(var10 + 1);
               var3.setBounds(var23[1], var12 + (this.rowHeights[var19] - var3.getPreferredSize().height) / 2, var14, var3.getPreferredSize().height);
               var4 = var1.getComponent(var10 + 2);
               var4.setBounds(var23[3], var12 + (this.rowHeights[var19] - var4.getPreferredSize().height) / 2, this.columnWidths[3], var4.getPreferredSize().height);
               var5 = var1.getComponent(var10 + 3);
               var5.setBounds(var23[4], var12 + (this.rowHeights[var19] - var5.getPreferredSize().height) / 2, this.columnWidths[4], var5.getPreferredSize().height);
               var6 = var1.getComponent(var10 + 4);
               var6.setBounds(var23[5], var12 + (this.rowHeights[var19] - var6.getPreferredSize().height) / 2, this.columnWidths[5], var6.getPreferredSize().height);
               var10 += 5;
               break;
            case 6:
               var2 = var1.getComponent(var10);
               var2.setBounds(var23[0], var12 + (this.rowHeights[var19] - var2.getPreferredSize().height) / 2, this.columnWidths[0], var2.getPreferredSize().height);
               var3 = var1.getComponent(var10 + 1);
               var3.setBounds(var23[1], var12 + (this.rowHeights[var19] - var3.getPreferredSize().height) / 2, this.columnWidths[1], var3.getPreferredSize().height);
               var4 = var1.getComponent(var10 + 2);
               var4.setBounds(var23[2], var12 + (this.rowHeights[var19] - var4.getPreferredSize().height) / 2, this.columnWidths[2], var4.getPreferredSize().height);
               var5 = var1.getComponent(var10 + 3);
               var5.setBounds(var23[3], var12 + (this.rowHeights[var19] - var5.getPreferredSize().height) / 2, this.columnWidths[3], var5.getPreferredSize().height);
               var6 = var1.getComponent(var10 + 4);
               var6.setBounds(var23[4], var12 + (this.rowHeights[var19] - var6.getPreferredSize().height) / 2, var15, var6.getPreferredSize().height);
               var10 += 5;
               break;
            case 7:
               var2 = var1.getComponent(var10);
               var2.setBounds(var23[0], var12 + (this.rowHeights[var19] - var2.getPreferredSize().height) / 2, this.columnWidths[0], var2.getPreferredSize().height);
               var3 = var1.getComponent(var10 + 1);
               var3.setBounds(var23[1], var12 + (this.rowHeights[var19] - var3.getPreferredSize().height) / 2, this.columnWidths[1], var3.getPreferredSize().height);
               var4 = var1.getComponent(var10 + 2);
               var4.setBounds(var23[2], var12 + (this.rowHeights[var19] - var4.getPreferredSize().height) / 2, this.columnWidths[2], var4.getPreferredSize().height);
               var5 = var1.getComponent(var10 + 3);
               var5.setBounds(var23[3], var12 + (this.rowHeights[var19] - var5.getPreferredSize().height) / 2, this.columnWidths[3], var5.getPreferredSize().height);
               var6 = var1.getComponent(var10 + 4);
               var6.setBounds(var23[4], var12 + (this.rowHeights[var19] - var6.getPreferredSize().height) / 2, this.columnWidths[4], var6.getPreferredSize().height);
               var7 = var1.getComponent(var10 + 5);
               var7.setBounds(var23[5], var12 + (this.rowHeights[var19] - var7.getPreferredSize().height) / 2, this.columnWidths[5], var7.getPreferredSize().height);
               var10 += 6;
            }

            var12 = var12 + this.rowHeights[var19] + this.rowGap;
         }

      }
   }

   protected void updateC(int var1, Dimension var2) {
      this.rowHeights[var1] = var2.height;
      this.totalHeight += this.rowHeights[var1];
      this.columns0to5Width = Math.max(this.columns0to5Width, var2.width);
   }

   protected void updateLC(int var1, Dimension var2, Dimension var3) {
      this.rowHeights[var1] = Math.max(var2.height, var3.height);
      this.totalHeight += this.rowHeights[var1];
      this.columnWidths[0] = Math.max(this.columnWidths[0], var2.width);
      this.columns1to5Width = Math.max(this.columns1to5Width, var3.width);
   }

   protected void updateLCB(int var1, Dimension var2, Dimension var3, Dimension var4) {
      this.rowHeights[var1] = Math.max(var2.height, Math.max(var3.height, var4.height));
      this.totalHeight += this.rowHeights[var1];
      this.columnWidths[0] = Math.max(this.columnWidths[0], var2.width);
      this.columns1to4Width = Math.max(this.columns1to4Width, var3.width);
      this.columnWidths[5] = Math.max(this.columnWidths[5], var4.width);
   }

   protected void updateLCLC(int var1, Dimension var2, Dimension var3, Dimension var4, Dimension var5) {
      this.rowHeights[var1] = Math.max(Math.max(var2.height, var3.height), Math.max(var4.height, var5.height));
      this.totalHeight += this.rowHeights[var1];
      this.columnWidths[0] = Math.max(this.columnWidths[0], var2.width);
      this.columns1and2Width = Math.max(this.columns1and2Width, var3.width);
      this.columnWidths[3] = Math.max(this.columnWidths[3], var4.width);
      this.columns4and5Width = Math.max(this.columns4and5Width, var5.width);
   }

   protected void updateLCBLC(int var1, Dimension var2, Dimension var3, Dimension var4, Dimension var5, Dimension var6) {
      this.rowHeights[var1] = Math.max(var2.height, Math.max(Math.max(var3.height, var4.height), Math.max(var5.height, var6.height)));
      this.totalHeight += this.rowHeights[var1];
      this.columnWidths[0] = Math.max(this.columnWidths[0], var2.width);
      this.columnWidths[1] = Math.max(this.columnWidths[1], var3.width);
      this.columnWidths[2] = Math.max(this.columnWidths[2], var4.width);
      this.columnWidths[3] = Math.max(this.columnWidths[3], var5.width);
      this.columns4and5Width = Math.max(this.columns4and5Width, var6.width);
   }

   protected void updateLCLCB(int var1, Dimension var2, Dimension var3, Dimension var4, Dimension var5, Dimension var6) {
      this.rowHeights[var1] = Math.max(var2.height, Math.max(Math.max(var3.height, var4.height), Math.max(var5.height, var6.height)));
      this.totalHeight += this.rowHeights[var1];
      this.columnWidths[0] = Math.max(this.columnWidths[0], var2.width);
      this.columns1and2Width = Math.max(this.columns1and2Width, var3.width);
      this.columnWidths[3] = Math.max(this.columnWidths[3], var4.width);
      this.columnWidths[4] = Math.max(this.columnWidths[4], var5.width);
      this.columnWidths[5] = Math.max(this.columnWidths[5], var6.width);
   }

   protected void updateLCBLCB(int var1, Dimension var2, Dimension var3, Dimension var4, Dimension var5, Dimension var6, Dimension var7) {
      this.rowHeights[var1] = Math.max(Math.max(var2.height, var3.height), Math.max(Math.max(var4.height, var5.height), Math.max(var6.height, var7.height)));
      this.totalHeight += this.rowHeights[var1];
      this.columnWidths[0] = Math.max(this.columnWidths[0], var2.width);
      this.columnWidths[1] = Math.max(this.columnWidths[1], var3.width);
      this.columnWidths[2] = Math.max(this.columnWidths[2], var4.width);
      this.columnWidths[3] = Math.max(this.columnWidths[3], var5.width);
      this.columnWidths[4] = Math.max(this.columnWidths[4], var6.width);
      this.columnWidths[5] = Math.max(this.columnWidths[5], var7.width);
   }

   public void complete() {
      this.columnWidths[1] = Math.max(this.columnWidths[1], this.columns1and2Width - this.columnGaps[1] - this.columnWidths[2]);
      this.columnWidths[4] = Math.max(this.columnWidths[4], Math.max(this.columns4and5Width - this.columnGaps[4] - this.columnWidths[5], Math.max(this.columns1to4Width - this.columnGaps[1] - this.columnGaps[2] - this.columnGaps[3] - this.columnWidths[1] - this.columnWidths[2] - this.columnWidths[3], this.columns1to5Width - this.columnGaps[1] - this.columnGaps[2] - this.columnGaps[3] - this.columnWidths[1] - this.columnWidths[2] - this.columnWidths[3] - this.columnGaps[4])));
      int var1 = this.columnWidths[0] + this.columnGaps[0] + this.columnWidths[1] + this.columnGaps[1] + this.columnWidths[2];
      int var2 = this.columnWidths[3] + this.columnGaps[3] + this.columnWidths[4] + this.columnGaps[4] + this.columnWidths[5];
      int var3;
      if(this.splitLayout()) {
         if(var1 > var2) {
            var3 = var1 - var2;
            this.columnWidths[4] += var3;
            var2 += var3;
         } else {
            var3 = var2 - var1;
            this.columnWidths[1] += var3;
            var1 += var3;
         }
      }

      this.totalWidth = var1 + this.columnGaps[2] + var2;
      if(this.columns0to5Width > this.totalWidth) {
         var3 = this.columns0to5Width - this.totalWidth;
         if(this.splitLayout()) {
            int var4 = var3 / 2;
            this.columnWidths[1] += var4;
            this.columnWidths[4] = this.columnWidths[4] + var3 - var4;
            this.totalWidth += var3;
         } else {
            this.columnWidths[1] += var3;
            this.totalWidth += var3;
         }
      }

   }

   private boolean splitLayout() {
      for(int var1 = 0; var1 < this.rowFormats.length; ++var1) {
         if(this.rowFormats[var1] > 3) {
            return true;
         }
      }

      return false;
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
