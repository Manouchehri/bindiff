package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.List;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.ui.Size2D;

public class CenterArrangement implements Serializable, Arrangement {
   private static final long serialVersionUID = -353308149220382047L;

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
            throw new RuntimeException("Not implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not implemented.");
         }
      } else if(var4 == LengthConstraintType.FIXED) {
         if(var5 == LengthConstraintType.NONE) {
            return this.arrangeFN(var1, var2, var3);
         }

         if(var5 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not implemented.");
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

      throw new IllegalArgumentException("Unknown LengthConstraintType.");
   }

   protected Size2D arrangeFN(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      List var4 = var1.getBlocks();
      Block var5 = (Block)var4.get(0);
      Size2D var6 = var5.arrange(var2, RectangleConstraint.NONE);
      double var7 = var3.getWidth();
      Double var9 = new Double((var7 - var6.width) / 2.0D, 0.0D, var6.width, var6.height);
      var5.setBounds(var9);
      return new Size2D((var7 - var6.width) / 2.0D, var6.height);
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
      List var3 = var1.getBlocks();
      Block var4 = (Block)var3.get(0);
      Size2D var5 = var4.arrange(var2, RectangleConstraint.NONE);
      var4.setBounds(new Double(0.0D, 0.0D, var5.width, var5.height));
      return new Size2D(var5.width, var5.height);
   }

   protected Size2D arrangeNF(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      return this.arrangeNN(var1, var2);
   }

   public void clear() {
   }

   public boolean equals(Object var1) {
      return var1 == this?true:var1 instanceof CenterArrangement;
   }
}
