package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.Size2D;
import org.jfree.ui.VerticalAlignment;

public class FlowArrangement implements Serializable, Arrangement {
   private static final long serialVersionUID = 4543632485478613800L;
   private HorizontalAlignment horizontalAlignment;
   private VerticalAlignment verticalAlignment;
   private double horizontalGap;
   private double verticalGap;

   public FlowArrangement() {
      this(HorizontalAlignment.CENTER, VerticalAlignment.CENTER, 2.0D, 2.0D);
   }

   public FlowArrangement(HorizontalAlignment var1, VerticalAlignment var2, double var3, double var5) {
      this.horizontalAlignment = var1;
      this.verticalAlignment = var2;
      this.horizontalGap = var3;
      this.verticalGap = var5;
   }

   public void add(Block var1, Object var2) {
   }

   public Size2D arrange(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      LengthConstraintType var4 = var3.getWidthConstraintType();
      LengthConstraintType var5 = var3.getHeightConstraintType();
      if(var4 == LengthConstraintType.NONE) {
         if(var5 == LengthConstraintType.NONE) {
            return this.arrangeNN(var1, var2);
         }

         if(var5 == LengthConstraintType.FIXED) {
            return this.arrangeNF(var1, var2, var3);
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not implemented.");
         }
      } else if(var4 == LengthConstraintType.FIXED) {
         if(var5 == LengthConstraintType.NONE) {
            return this.arrangeFN(var1, var2, var3);
         }

         if(var5 == LengthConstraintType.FIXED) {
            return this.arrangeFF(var1, var2, var3);
         }

         if(var5 == LengthConstraintType.RANGE) {
            return this.arrangeFR(var1, var2, var3);
         }
      } else if(var4 == LengthConstraintType.RANGE) {
         if(var5 == LengthConstraintType.NONE) {
            return this.arrangeRN(var1, var2, var3);
         }

         if(var5 == LengthConstraintType.FIXED) {
            return this.arrangeRF(var1, var2, var3);
         }

         if(var5 == LengthConstraintType.RANGE) {
            return this.arrangeRR(var1, var2, var3);
         }
      }

      throw new RuntimeException("Unrecognised constraint type.");
   }

   protected Size2D arrangeFN(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      List var4 = var1.getBlocks();
      double var5 = var3.getWidth();
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      ArrayList var13 = new ArrayList();

      for(int var14 = 0; var14 < var4.size(); ++var14) {
         Block var15 = (Block)var4.get(var14);
         Size2D var16 = var15.arrange(var2, RectangleConstraint.NONE);
         if(var7 + var16.width <= var5) {
            var13.add(var15);
            var15.setBounds(new Double(var7, var9, var16.width, var16.height));
            var7 = var7 + var16.width + this.horizontalGap;
            var11 = Math.max(var11, var16.height);
         } else if(var13.isEmpty()) {
            var15.setBounds(new Double(var7, var9, Math.min(var16.width, var5 - var7), var16.height));
            var7 = 0.0D;
            var9 = var9 + var16.height + this.verticalGap;
         } else {
            var13.clear();
            var7 = 0.0D;
            var9 = var9 + var11 + this.verticalGap;
            var11 = var16.height;
            var15.setBounds(new Double(var7, var9, Math.min(var16.width, var5), var16.height));
            var7 = var16.width + this.horizontalGap;
            var13.add(var15);
         }
      }

      return new Size2D(var3.getWidth(), var9 + var11);
   }

   protected Size2D arrangeFR(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      Size2D var4 = this.arrangeFN(var1, var2, var3);
      if(var3.getHeightRange().contains(var4.height)) {
         return var4;
      } else {
         RectangleConstraint var5 = var3.toFixedHeight(var3.getHeightRange().constrain(var4.getHeight()));
         return this.arrangeFF(var1, var2, var5);
      }
   }

   protected Size2D arrangeFF(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      return this.arrangeFN(var1, var2, var3);
   }

   protected Size2D arrangeRR(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      Size2D var4 = this.arrangeNN(var1, var2);
      if(var3.getWidthRange().contains(var4.width)) {
         return var4;
      } else {
         RectangleConstraint var5 = var3.toFixedWidth(var3.getWidthRange().getUpperBound());
         return this.arrangeFR(var1, var2, var5);
      }
   }

   protected Size2D arrangeRF(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      Size2D var4 = this.arrangeNF(var1, var2, var3);
      if(var3.getWidthRange().contains(var4.width)) {
         return var4;
      } else {
         RectangleConstraint var5 = var3.toFixedWidth(var3.getWidthRange().constrain(var4.getWidth()));
         return this.arrangeFF(var1, var2, var5);
      }
   }

   protected Size2D arrangeRN(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      Size2D var4 = this.arrangeNN(var1, var2);
      if(var3.getWidthRange().contains(var4.width)) {
         return var4;
      } else {
         RectangleConstraint var5 = var3.toFixedWidth(var3.getWidthRange().getUpperBound());
         return this.arrangeFN(var1, var2, var5);
      }
   }

   protected Size2D arrangeNN(BlockContainer var1, Graphics2D var2) {
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      List var9 = var1.getBlocks();
      int var10 = var9.size();
      if(var10 > 0) {
         Size2D[] var11 = new Size2D[var9.size()];

         int var12;
         for(var12 = 0; var12 < var9.size(); ++var12) {
            Block var13 = (Block)var9.get(var12);
            var11[var12] = var13.arrange(var2, RectangleConstraint.NONE);
            var5 += var11[var12].getWidth();
            var7 = Math.max(var11[var12].height, var7);
            var13.setBounds(new Double(var3, 0.0D, var11[var12].width, var11[var12].height));
            var3 = var3 + var11[var12].width + this.horizontalGap;
         }

         if(var10 > 1) {
            var5 += this.horizontalGap * (double)(var10 - 1);
         }

         if(this.verticalAlignment != VerticalAlignment.TOP) {
            for(var12 = 0; var12 < var9.size(); ++var12) {
               if(this.verticalAlignment != VerticalAlignment.CENTER && this.verticalAlignment == VerticalAlignment.BOTTOM) {
                  ;
               }
            }
         }
      }

      return new Size2D(var5, var7);
   }

   protected Size2D arrangeNF(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      return this.arrangeNN(var1, var2);
   }

   public void clear() {
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof FlowArrangement)) {
         return false;
      } else {
         FlowArrangement var2 = (FlowArrangement)var1;
         return this.horizontalAlignment != var2.horizontalAlignment?false:(this.verticalAlignment != var2.verticalAlignment?false:(this.horizontalGap != var2.horizontalGap?false:this.verticalGap == var2.verticalGap));
      }
   }
}
