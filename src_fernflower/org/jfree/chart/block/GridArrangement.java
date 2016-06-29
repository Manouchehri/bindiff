package org.jfree.chart.block;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.Block;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.LengthConstraintType;
import org.jfree.chart.block.RectangleConstraint;
import org.jfree.ui.Size2D;

public class GridArrangement implements Serializable, Arrangement {
   private static final long serialVersionUID = -2563758090144655938L;
   private int rows;
   private int columns;

   public GridArrangement(int var1, int var2) {
      this.rows = var1;
      this.columns = var2;
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
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not yet implemented.");
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
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.FIXED) {
            throw new RuntimeException("Not yet implemented.");
         }

         if(var5 == LengthConstraintType.RANGE) {
            throw new RuntimeException("Not yet implemented.");
         }
      }

      return new Size2D();
   }

   protected Size2D arrangeNN(BlockContainer var1, Graphics2D var2) {
      double var3 = 0.0D;
      double var5 = 0.0D;
      List var7 = var1.getBlocks();

      Size2D var10;
      for(Iterator var8 = var7.iterator(); var8.hasNext(); var5 = Math.max(var5, var10.height)) {
         Block var9 = (Block)var8.next();
         var10 = var9.arrange(var2, RectangleConstraint.NONE);
         var3 = Math.max(var3, var10.width);
      }

      double var14 = (double)this.columns * var3;
      double var11 = (double)this.rows * var5;
      RectangleConstraint var13 = new RectangleConstraint(var14, var11);
      return this.arrangeFF(var1, var2, var13);
   }

   protected Size2D arrangeFF(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      double var4 = var3.getWidth() / (double)this.columns;
      double var6 = var3.getHeight() / (double)this.rows;
      List var8 = var1.getBlocks();

      for(int var9 = 0; var9 < this.columns; ++var9) {
         for(int var10 = 0; var10 < this.rows; ++var10) {
            int var11 = var10 * this.columns + var9;
            if(var11 == var8.size()) {
               break;
            }

            Block var12 = (Block)var8.get(var11);
            var12.setBounds(new Double((double)var9 * var4, (double)var10 * var6, var4, var6));
         }
      }

      return new Size2D((double)this.columns * var4, (double)this.rows * var6);
   }

   protected Size2D arrangeFR(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      RectangleConstraint var4 = var3.toUnconstrainedHeight();
      Size2D var5 = this.arrange(var1, var2, var4);
      if(var3.getHeightRange().contains(var5.getHeight())) {
         return var5;
      } else {
         double var6 = var3.getHeightRange().constrain(var5.getHeight());
         RectangleConstraint var8 = var3.toFixedHeight(var6);
         return this.arrange(var1, var2, var8);
      }
   }

   protected Size2D arrangeFN(BlockContainer var1, Graphics2D var2, RectangleConstraint var3) {
      double var4 = var3.getWidth() / (double)this.columns;
      RectangleConstraint var6 = var3.toFixedWidth(var4);
      List var7 = var1.getBlocks();
      double var8 = 0.0D;

      for(int var10 = 0; var10 < this.rows; ++var10) {
         for(int var11 = 0; var11 < this.columns; ++var11) {
            int var12 = var10 * this.columns + var11;
            if(var12 == var7.size()) {
               break;
            }

            Block var13 = (Block)var7.get(var12);
            Size2D var14 = var13.arrange(var2, var6);
            var8 = Math.max(var8, var14.getHeight());
         }
      }

      RectangleConstraint var15 = var3.toFixedHeight(var8 * (double)this.rows);
      return this.arrange(var1, var2, var15);
   }

   public void clear() {
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof GridArrangement)) {
         return false;
      } else {
         GridArrangement var2 = (GridArrangement)var1;
         return this.columns != var2.columns?false:this.rows == var2.rows;
      }
   }
}
