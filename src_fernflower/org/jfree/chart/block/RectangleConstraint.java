package org.jfree.chart.block;

import org.jfree.chart.block.LengthConstraintType;
import org.jfree.data.Range;
import org.jfree.ui.Size2D;

public class RectangleConstraint {
   public static final RectangleConstraint NONE;
   private double width;
   private Range widthRange;
   private LengthConstraintType widthConstraintType;
   private double height;
   private Range heightRange;
   private LengthConstraintType heightConstraintType;

   public RectangleConstraint(double var1, double var3) {
      this(var1, (Range)null, LengthConstraintType.FIXED, var3, (Range)null, LengthConstraintType.FIXED);
   }

   public RectangleConstraint(Range var1, Range var2) {
      this(0.0D, var1, LengthConstraintType.RANGE, 0.0D, var2, LengthConstraintType.RANGE);
   }

   public RectangleConstraint(Range var1, double var2) {
      this(0.0D, var1, LengthConstraintType.RANGE, var2, (Range)null, LengthConstraintType.FIXED);
   }

   public RectangleConstraint(double var1, Range var3) {
      this(var1, (Range)null, LengthConstraintType.FIXED, 0.0D, var3, LengthConstraintType.RANGE);
   }

   public RectangleConstraint(double var1, Range var3, LengthConstraintType var4, double var5, Range var7, LengthConstraintType var8) {
      if(var4 == null) {
         throw new IllegalArgumentException("Null \'widthType\' argument.");
      } else if(var8 == null) {
         throw new IllegalArgumentException("Null \'heightType\' argument.");
      } else {
         this.width = var1;
         this.widthRange = var3;
         this.widthConstraintType = var4;
         this.height = var5;
         this.heightRange = var7;
         this.heightConstraintType = var8;
      }
   }

   public double getWidth() {
      return this.width;
   }

   public Range getWidthRange() {
      return this.widthRange;
   }

   public LengthConstraintType getWidthConstraintType() {
      return this.widthConstraintType;
   }

   public double getHeight() {
      return this.height;
   }

   public Range getHeightRange() {
      return this.heightRange;
   }

   public LengthConstraintType getHeightConstraintType() {
      return this.heightConstraintType;
   }

   public RectangleConstraint toUnconstrainedWidth() {
      return this.widthConstraintType == LengthConstraintType.NONE?this:new RectangleConstraint(this.width, this.widthRange, LengthConstraintType.NONE, this.height, this.heightRange, this.heightConstraintType);
   }

   public RectangleConstraint toUnconstrainedHeight() {
      return this.heightConstraintType == LengthConstraintType.NONE?this:new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, 0.0D, this.heightRange, LengthConstraintType.NONE);
   }

   public RectangleConstraint toFixedWidth(double var1) {
      return new RectangleConstraint(var1, this.widthRange, LengthConstraintType.FIXED, this.height, this.heightRange, this.heightConstraintType);
   }

   public RectangleConstraint toFixedHeight(double var1) {
      return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, var1, this.heightRange, LengthConstraintType.FIXED);
   }

   public RectangleConstraint toRangeWidth(Range var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         return new RectangleConstraint(var1.getUpperBound(), var1, LengthConstraintType.RANGE, this.height, this.heightRange, this.heightConstraintType);
      }
   }

   public RectangleConstraint toRangeHeight(Range var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         return new RectangleConstraint(this.width, this.widthRange, this.widthConstraintType, var1.getUpperBound(), var1, LengthConstraintType.RANGE);
      }
   }

   public String toString() {
      return "RectangleConstraint[" + this.widthConstraintType.toString() + ": width=" + this.width + ", height=" + this.height + "]";
   }

   public Size2D calculateConstrainedSize(Size2D var1) {
      Size2D var2 = new Size2D();
      if(this.widthConstraintType == LengthConstraintType.NONE) {
         var2.width = var1.width;
         if(this.heightConstraintType == LengthConstraintType.NONE) {
            var2.height = var1.height;
         } else if(this.heightConstraintType == LengthConstraintType.RANGE) {
            var2.height = this.heightRange.constrain(var1.height);
         } else if(this.heightConstraintType == LengthConstraintType.FIXED) {
            var2.height = this.height;
         }
      } else if(this.widthConstraintType == LengthConstraintType.RANGE) {
         var2.width = this.widthRange.constrain(var1.width);
         if(this.heightConstraintType == LengthConstraintType.NONE) {
            var2.height = var1.height;
         } else if(this.heightConstraintType == LengthConstraintType.RANGE) {
            var2.height = this.heightRange.constrain(var1.height);
         } else if(this.heightConstraintType == LengthConstraintType.FIXED) {
            var2.height = this.height;
         }
      } else if(this.widthConstraintType == LengthConstraintType.FIXED) {
         var2.width = this.width;
         if(this.heightConstraintType == LengthConstraintType.NONE) {
            var2.height = var1.height;
         } else if(this.heightConstraintType == LengthConstraintType.RANGE) {
            var2.height = this.heightRange.constrain(var1.height);
         } else if(this.heightConstraintType == LengthConstraintType.FIXED) {
            var2.height = this.height;
         }
      }

      return var2;
   }

   static {
      NONE = new RectangleConstraint(0.0D, (Range)null, LengthConstraintType.NONE, 0.0D, (Range)null, LengthConstraintType.NONE);
   }
}
