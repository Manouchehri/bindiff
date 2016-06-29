package org.jfree.chart.axis;

import java.io.Serializable;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;

public class CategoryLabelPositions implements Serializable {
   private static final long serialVersionUID = -8999557901920364580L;
   public static final CategoryLabelPositions STANDARD;
   public static final CategoryLabelPositions UP_90;
   public static final CategoryLabelPositions DOWN_90;
   public static final CategoryLabelPositions UP_45;
   public static final CategoryLabelPositions DOWN_45;
   private CategoryLabelPosition positionForAxisAtTop;
   private CategoryLabelPosition positionForAxisAtBottom;
   private CategoryLabelPosition positionForAxisAtLeft;
   private CategoryLabelPosition positionForAxisAtRight;

   public static CategoryLabelPositions createUpRotationLabelPositions(double var0) {
      return new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_LEFT, -var0, CategoryLabelWidthType.RANGE, 0.5F), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_RIGHT, TextAnchor.TOP_RIGHT, -var0, CategoryLabelWidthType.RANGE, 0.5F), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.BOTTOM_RIGHT, TextAnchor.BOTTOM_RIGHT, -var0, CategoryLabelWidthType.RANGE, 0.5F), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, -var0, CategoryLabelWidthType.RANGE, 0.5F));
   }

   public static CategoryLabelPositions createDownRotationLabelPositions(double var0) {
      return new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_RIGHT, TextAnchor.BOTTOM_RIGHT, var0, CategoryLabelWidthType.RANGE, 0.5F), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_LEFT, TextAnchor.TOP_LEFT, var0, CategoryLabelWidthType.RANGE, 0.5F), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.TOP_RIGHT, TextAnchor.TOP_RIGHT, var0, CategoryLabelWidthType.RANGE, 0.5F), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.BOTTOM_LEFT, TextAnchor.BOTTOM_LEFT, var0, CategoryLabelWidthType.RANGE, 0.5F));
   }

   public CategoryLabelPositions() {
      this.positionForAxisAtTop = new CategoryLabelPosition();
      this.positionForAxisAtBottom = new CategoryLabelPosition();
      this.positionForAxisAtLeft = new CategoryLabelPosition();
      this.positionForAxisAtRight = new CategoryLabelPosition();
   }

   public CategoryLabelPositions(CategoryLabelPosition var1, CategoryLabelPosition var2, CategoryLabelPosition var3, CategoryLabelPosition var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'top\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'bottom\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'left\' argument.");
      } else if(var4 == null) {
         throw new IllegalArgumentException("Null \'right\' argument.");
      } else {
         this.positionForAxisAtTop = var1;
         this.positionForAxisAtBottom = var2;
         this.positionForAxisAtLeft = var3;
         this.positionForAxisAtRight = var4;
      }
   }

   public CategoryLabelPosition getLabelPosition(RectangleEdge var1) {
      CategoryLabelPosition var2 = null;
      if(var1 == RectangleEdge.TOP) {
         var2 = this.positionForAxisAtTop;
      } else if(var1 == RectangleEdge.BOTTOM) {
         var2 = this.positionForAxisAtBottom;
      } else if(var1 == RectangleEdge.LEFT) {
         var2 = this.positionForAxisAtLeft;
      } else if(var1 == RectangleEdge.RIGHT) {
         var2 = this.positionForAxisAtRight;
      }

      return var2;
   }

   public static CategoryLabelPositions replaceTopPosition(CategoryLabelPositions var0, CategoryLabelPosition var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'base\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'top\' argument.");
      } else {
         return new CategoryLabelPositions(var1, var0.getLabelPosition(RectangleEdge.BOTTOM), var0.getLabelPosition(RectangleEdge.LEFT), var0.getLabelPosition(RectangleEdge.RIGHT));
      }
   }

   public static CategoryLabelPositions replaceBottomPosition(CategoryLabelPositions var0, CategoryLabelPosition var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'base\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'bottom\' argument.");
      } else {
         return new CategoryLabelPositions(var0.getLabelPosition(RectangleEdge.TOP), var1, var0.getLabelPosition(RectangleEdge.LEFT), var0.getLabelPosition(RectangleEdge.RIGHT));
      }
   }

   public static CategoryLabelPositions replaceLeftPosition(CategoryLabelPositions var0, CategoryLabelPosition var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'base\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'left\' argument.");
      } else {
         return new CategoryLabelPositions(var0.getLabelPosition(RectangleEdge.TOP), var0.getLabelPosition(RectangleEdge.BOTTOM), var1, var0.getLabelPosition(RectangleEdge.RIGHT));
      }
   }

   public static CategoryLabelPositions replaceRightPosition(CategoryLabelPositions var0, CategoryLabelPosition var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'base\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'right\' argument.");
      } else {
         return new CategoryLabelPositions(var0.getLabelPosition(RectangleEdge.TOP), var0.getLabelPosition(RectangleEdge.BOTTOM), var0.getLabelPosition(RectangleEdge.LEFT), var1);
      }
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof CategoryLabelPositions)) {
         return false;
      } else {
         CategoryLabelPositions var2 = (CategoryLabelPositions)var1;
         return !this.positionForAxisAtTop.equals(var2.positionForAxisAtTop)?false:(!this.positionForAxisAtBottom.equals(var2.positionForAxisAtBottom)?false:(!this.positionForAxisAtLeft.equals(var2.positionForAxisAtLeft)?false:this.positionForAxisAtRight.equals(var2.positionForAxisAtRight)));
      }
   }

   public int hashCode() {
      byte var1 = 19;
      int var2 = 37 * var1 + this.positionForAxisAtTop.hashCode();
      var2 = 37 * var2 + this.positionForAxisAtBottom.hashCode();
      var2 = 37 * var2 + this.positionForAxisAtLeft.hashCode();
      var2 = 37 * var2 + this.positionForAxisAtRight.hashCode();
      return var2;
   }

   static {
      STANDARD = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.BOTTOM_CENTER), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.TOP_CENTER), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.CENTER_RIGHT, CategoryLabelWidthType.RANGE, 0.3F), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, CategoryLabelWidthType.RANGE, 0.3F));
      UP_90 = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, -1.5707963267948966D, CategoryLabelWidthType.RANGE, 0.3F), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, -1.5707963267948966D, CategoryLabelWidthType.RANGE, 0.3F), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.BOTTOM_CENTER, -1.5707963267948966D, CategoryLabelWidthType.CATEGORY, 0.9F), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.TOP_CENTER, TextAnchor.TOP_CENTER, -1.5707963267948966D, CategoryLabelWidthType.CATEGORY, 0.9F));
      DOWN_90 = new CategoryLabelPositions(new CategoryLabelPosition(RectangleAnchor.BOTTOM, TextBlockAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, 1.5707963267948966D, CategoryLabelWidthType.RANGE, 0.3F), new CategoryLabelPosition(RectangleAnchor.TOP, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 1.5707963267948966D, CategoryLabelWidthType.RANGE, 0.3F), new CategoryLabelPosition(RectangleAnchor.RIGHT, TextBlockAnchor.TOP_CENTER, TextAnchor.TOP_CENTER, 1.5707963267948966D, CategoryLabelWidthType.CATEGORY, 0.9F), new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.BOTTOM_CENTER, 1.5707963267948966D, CategoryLabelWidthType.CATEGORY, 0.9F));
      UP_45 = createUpRotationLabelPositions(0.7853981633974483D);
      DOWN_45 = createDownRotationLabelPositions(0.7853981633974483D);
   }
}
