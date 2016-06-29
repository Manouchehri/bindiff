package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.data.Range;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.Size2D;
import org.jfree.util.ObjectUtilities;

public class BorderArrangement implements Serializable, Arrangement {
   private static final long serialVersionUID = 506071142274883745L;
   private Block centerBlock;
   private Block topBlock;
   private Block bottomBlock;
   private Block leftBlock;
   private Block rightBlock;

   public void add(Block var1, Object var2) {
      if(var2 == null) {
         this.centerBlock = var1;
      } else {
         RectangleEdge var3 = (RectangleEdge)var2;
         if(var3 == RectangleEdge.TOP) {
            this.topBlock = var1;
         } else if(var3 == RectangleEdge.BOTTOM) {
            this.bottomBlock = var1;
         } else if(var3 == RectangleEdge.LEFT) {
            this.leftBlock = var1;
         } else if(var3 == RectangleEdge.RIGHT) {
            this.rightBlock = var1;
         }
      }

   }

   public Size2D arrange(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      RectangleConstraint var4 = var1.toContentConstraint(var3);
      Size2D var5 = null;
      LengthConstraintType var6 = var4.getWidthConstraintType();
      LengthConstraintType var7 = var4.getHeightConstraintType();
      if(var6 == LengthConstraintType.NONE) {
         if(var7 == LengthConstraintType.NONE) {
            var5 = this.arrangeNN(var1, var2);
         } else {
            if(var7 == LengthConstraintType.FIXED) {
               throw new RuntimeException("Not implemented.");
            }

            if(var7 == LengthConstraintType.RANGE) {
               throw new RuntimeException("Not implemented.");
            }
         }
      } else if(var6 == LengthConstraintType.FIXED) {
         if(var7 == LengthConstraintType.NONE) {
            var5 = this.arrangeFN(var1, var2, var3.getWidth());
         } else if(var7 == LengthConstraintType.FIXED) {
            var5 = this.arrangeFF(var1, var2, var3);
         } else if(var7 == LengthConstraintType.RANGE) {
            var5 = this.arrangeFR(var1, var2, var3);
         }
      } else if(var6 == LengthConstraintType.RANGE) {
         if(var7 == LengthConstraintType.NONE) {
            throw new RuntimeException("Not implemented.");
         }

         if(var7 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not implemented.");
         }

         if(var7 == LengthConstraintType.RANGE) {
            var5 = this.arrangeRR(var1, var3.getWidthRange(), var3.getHeightRange(), var2);
         }
      }

      return new Size2D(var1.calculateTotalWidth(var5.getWidth()), var1.calculateTotalHeight(var5.getHeight()));
   }

   protected Size2D arrangeNN(BlockContainer var1, Graphics2D var2) {
      double[] var3 = new double[5];
      double[] var4 = new double[5];
      Size2D var5;
      if(this.topBlock != null) {
         var5 = this.topBlock.arrange(var2, RectangleConstraint.NONE);
         var3[0] = var5.width;
         var4[0] = var5.height;
      }

      if(this.bottomBlock != null) {
         var5 = this.bottomBlock.arrange(var2, RectangleConstraint.NONE);
         var3[1] = var5.width;
         var4[1] = var5.height;
      }

      if(this.leftBlock != null) {
         var5 = this.leftBlock.arrange(var2, RectangleConstraint.NONE);
         var3[2] = var5.width;
         var4[2] = var5.height;
      }

      if(this.rightBlock != null) {
         var5 = this.rightBlock.arrange(var2, RectangleConstraint.NONE);
         var3[3] = var5.width;
         var4[3] = var5.height;
      }

      var4[2] = Math.max(var4[2], var4[3]);
      var4[3] = var4[2];
      if(this.centerBlock != null) {
         var5 = this.centerBlock.arrange(var2, RectangleConstraint.NONE);
         var3[4] = var5.width;
         var4[4] = var5.height;
      }

      double var11 = Math.max(var3[0], Math.max(var3[1], var3[2] + var3[4] + var3[3]));
      double var7 = Math.max(var4[2], Math.max(var4[3], var4[4]));
      double var9 = var4[0] + var4[1] + var7;
      if(this.topBlock != null) {
         this.topBlock.setBounds(new Double(0.0D, 0.0D, var11, var4[0]));
      }

      if(this.bottomBlock != null) {
         this.bottomBlock.setBounds(new Double(0.0D, var9 - var4[1], var11, var4[1]));
      }

      if(this.leftBlock != null) {
         this.leftBlock.setBounds(new Double(0.0D, var4[0], var3[2], var7));
      }

      if(this.rightBlock != null) {
         this.rightBlock.setBounds(new Double(var11 - var3[3], var4[0], var3[3], var7));
      }

      if(this.centerBlock != null) {
         this.centerBlock.setBounds(new Double(var3[2], var4[0], var11 - var3[2] - var3[3], var7));
      }

      return new Size2D(var11, var9);
   }

   protected Size2D arrangeFR(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      Size2D var4 = this.arrangeFN(var1, var2, var3.getWidth());
      if(var3.getHeightRange().contains(var4.getHeight())) {
         return var4;
      } else {
         double var5 = var3.getHeightRange().constrain(var4.getHeight());
         RectangleConstraint var7 = var3.toFixedHeight(var5);
         return this.arrange(var1, var2, var7);
      }
   }

   protected Size2D arrangeFN(BlockContainer var1, Graphics2D var2, double var3) {
      double[] var5 = new double[5];
      double[] var6 = new double[5];
      RectangleConstraint var7 = new RectangleConstraint(var3, (Range)null, LengthConstraintType.FIXED, 0.0D, (Range)null, LengthConstraintType.NONE);
      Size2D var8;
      if(this.topBlock != null) {
         var8 = this.topBlock.arrange(var2, var7);
         var5[0] = var8.width;
         var6[0] = var8.height;
      }

      if(this.bottomBlock != null) {
         var8 = this.bottomBlock.arrange(var2, var7);
         var5[1] = var8.width;
         var6[1] = var8.height;
      }

      RectangleConstraint var13 = new RectangleConstraint(0.0D, new Range(0.0D, var3), LengthConstraintType.RANGE, 0.0D, (Range)null, LengthConstraintType.NONE);
      if(this.leftBlock != null) {
         Size2D var9 = this.leftBlock.arrange(var2, var13);
         var5[2] = var9.width;
         var6[2] = var9.height;
      }

      double var14;
      if(this.rightBlock != null) {
         var14 = Math.max(var3 - var5[2], 0.0D);
         RectangleConstraint var11 = new RectangleConstraint(0.0D, new Range(Math.min(var5[2], var14), var14), LengthConstraintType.RANGE, 0.0D, (Range)null, LengthConstraintType.NONE);
         Size2D var12 = this.rightBlock.arrange(var2, var11);
         var5[3] = var12.width;
         var6[3] = var12.height;
      }

      var6[2] = Math.max(var6[2], var6[3]);
      var6[3] = var6[2];
      if(this.centerBlock != null) {
         RectangleConstraint var15 = new RectangleConstraint(var3 - var5[2] - var5[3], (Range)null, LengthConstraintType.FIXED, 0.0D, (Range)null, LengthConstraintType.NONE);
         Size2D var10 = this.centerBlock.arrange(var2, var15);
         var5[4] = var10.width;
         var6[4] = var10.height;
      }

      var14 = var6[0] + var6[1] + Math.max(var6[2], Math.max(var6[3], var6[4]));
      return this.arrange(var1, var2, new RectangleConstraint(var3, var14));
   }

   protected Size2D arrangeRR(BlockContainer var1, Range var2, Range var3, Graphics2D var4) {
      double[] var5 = new double[5];
      double[] var6 = new double[5];
      if(this.topBlock != null) {
         RectangleConstraint var7 = new RectangleConstraint(var2, var3);
         Size2D var8 = this.topBlock.arrange(var4, var7);
         var5[0] = var8.width;
         var6[0] = var8.height;
      }

      Size2D var9;
      Range var14;
      RectangleConstraint var15;
      if(this.bottomBlock != null) {
         var14 = Range.shift(var3, -var6[0], false);
         var15 = new RectangleConstraint(var2, var14);
         var9 = this.bottomBlock.arrange(var4, var15);
         var5[1] = var9.width;
         var6[1] = var9.height;
      }

      var14 = Range.shift(var3, -(var6[0] + var6[1]));
      if(this.leftBlock != null) {
         var15 = new RectangleConstraint(var2, var14);
         var9 = this.leftBlock.arrange(var4, var15);
         var5[2] = var9.width;
         var6[2] = var9.height;
      }

      Range var16 = Range.shift(var2, -var5[2], false);
      if(this.rightBlock != null) {
         RectangleConstraint var17 = new RectangleConstraint(var16, var14);
         Size2D var10 = this.rightBlock.arrange(var4, var17);
         var5[3] = var10.width;
         var6[3] = var10.height;
      }

      var6[2] = Math.max(var6[2], var6[3]);
      var6[3] = var6[2];
      Range var18 = Range.shift(var2, -(var5[2] + var5[3]), false);
      if(this.centerBlock != null) {
         RectangleConstraint var19 = new RectangleConstraint(var18, var14);
         Size2D var11 = this.centerBlock.arrange(var4, var19);
         var5[4] = var11.width;
         var6[4] = var11.height;
      }

      double var20 = Math.max(var5[0], Math.max(var5[1], var5[2] + var5[4] + var5[3]));
      double var12 = var6[0] + var6[1] + Math.max(var6[2], Math.max(var6[3], var6[4]));
      if(this.topBlock != null) {
         this.topBlock.setBounds(new Double(0.0D, 0.0D, var20, var6[0]));
      }

      if(this.bottomBlock != null) {
         this.bottomBlock.setBounds(new Double(0.0D, var12 - var6[1], var20, var6[1]));
      }

      if(this.leftBlock != null) {
         this.leftBlock.setBounds(new Double(0.0D, var6[0], var5[2], var6[2]));
      }

      if(this.rightBlock != null) {
         this.rightBlock.setBounds(new Double(var20 - var5[3], var6[0], var5[3], var6[3]));
      }

      if(this.centerBlock != null) {
         this.centerBlock.setBounds(new Double(var5[2], var6[0], var20 - var5[2] - var5[3], var12 - var6[0] - var6[1]));
      }

      return new Size2D(var20, var12);
   }

   protected Size2D arrangeFF(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      double[] var4 = new double[5];
      double[] var5 = new double[5];
      var4[0] = var3.getWidth();
      RectangleConstraint var6;
      Size2D var7;
      if(this.topBlock != null) {
         var6 = new RectangleConstraint(var4[0], (Range)null, LengthConstraintType.FIXED, 0.0D, new Range(0.0D, var3.getHeight()), LengthConstraintType.RANGE);
         var7 = this.topBlock.arrange(var2, var6);
         var5[0] = var7.height;
      }

      var4[1] = var4[0];
      if(this.bottomBlock != null) {
         var6 = new RectangleConstraint(var4[0], (Range)null, LengthConstraintType.FIXED, 0.0D, new Range(0.0D, var3.getHeight() - var5[0]), LengthConstraintType.RANGE);
         var7 = this.bottomBlock.arrange(var2, var6);
         var5[1] = var7.height;
      }

      var5[2] = var3.getHeight() - var5[1] - var5[0];
      if(this.leftBlock != null) {
         var6 = new RectangleConstraint(0.0D, new Range(0.0D, var3.getWidth()), LengthConstraintType.RANGE, var5[2], (Range)null, LengthConstraintType.FIXED);
         var7 = this.leftBlock.arrange(var2, var6);
         var4[2] = var7.width;
      }

      var5[3] = var5[2];
      if(this.rightBlock != null) {
         var6 = new RectangleConstraint(0.0D, new Range(0.0D, var3.getWidth() - var4[2]), LengthConstraintType.RANGE, var5[2], (Range)null, LengthConstraintType.FIXED);
         var7 = this.rightBlock.arrange(var2, var6);
         var4[3] = var7.width;
      }

      var5[4] = var5[2];
      var4[4] = var3.getWidth() - var4[3] - var4[2];
      var6 = new RectangleConstraint(var4[4], var5[4]);
      if(this.centerBlock != null) {
         this.centerBlock.arrange(var2, var6);
      }

      if(this.topBlock != null) {
         this.topBlock.setBounds(new Double(0.0D, 0.0D, var4[0], var5[0]));
      }

      if(this.bottomBlock != null) {
         this.bottomBlock.setBounds(new Double(0.0D, var5[0] + var5[2], var4[1], var5[1]));
      }

      if(this.leftBlock != null) {
         this.leftBlock.setBounds(new Double(0.0D, var5[0], var4[2], var5[2]));
      }

      if(this.rightBlock != null) {
         this.rightBlock.setBounds(new Double(var4[2] + var4[4], var5[0], var4[3], var5[3]));
      }

      if(this.centerBlock != null) {
         this.centerBlock.setBounds(new Double(var4[2], var5[0], var4[4], var5[4]));
      }

      return new Size2D(var3.getWidth(), var3.getHeight());
   }

   public void clear() {
      this.centerBlock = null;
      this.topBlock = null;
      this.bottomBlock = null;
      this.leftBlock = null;
      this.rightBlock = null;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BorderArrangement)) {
         return false;
      } else {
         BorderArrangement var2 = (BorderArrangement)var1;
         return !ObjectUtilities.equal(this.topBlock, var2.topBlock)?false:(!ObjectUtilities.equal(this.bottomBlock, var2.bottomBlock)?false:(!ObjectUtilities.equal(this.leftBlock, var2.leftBlock)?false:(!ObjectUtilities.equal(this.rightBlock, var2.rightBlock)?false:ObjectUtilities.equal(this.centerBlock, var2.centerBlock))));
      }
   }
}
