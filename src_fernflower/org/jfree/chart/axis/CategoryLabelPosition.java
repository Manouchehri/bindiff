package org.jfree.chart.axis;

import java.io.Serializable;
import org.jfree.chart.axis.CategoryLabelWidthType;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

public class CategoryLabelPosition implements Serializable {
   private static final long serialVersionUID = 5168681143844183864L;
   private RectangleAnchor categoryAnchor;
   private TextBlockAnchor labelAnchor;
   private TextAnchor rotationAnchor;
   private double angle;
   private CategoryLabelWidthType widthType;
   private float widthRatio;

   public CategoryLabelPosition() {
      this(RectangleAnchor.CENTER, TextBlockAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0.0D, CategoryLabelWidthType.CATEGORY, 0.95F);
   }

   public CategoryLabelPosition(RectangleAnchor var1, TextBlockAnchor var2) {
      this(var1, var2, TextAnchor.CENTER, 0.0D, CategoryLabelWidthType.CATEGORY, 0.95F);
   }

   public CategoryLabelPosition(RectangleAnchor var1, TextBlockAnchor var2, CategoryLabelWidthType var3, float var4) {
      this(var1, var2, TextAnchor.CENTER, 0.0D, var3, var4);
   }

   public CategoryLabelPosition(RectangleAnchor var1, TextBlockAnchor var2, TextAnchor var3, double var4, CategoryLabelWidthType var6, float var7) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'categoryAnchor\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'labelAnchor\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'rotationAnchor\' argument.");
      } else if(var6 == null) {
         throw new IllegalArgumentException("Null \'widthType\' argument.");
      } else {
         this.categoryAnchor = var1;
         this.labelAnchor = var2;
         this.rotationAnchor = var3;
         this.angle = var4;
         this.widthType = var6;
         this.widthRatio = var7;
      }
   }

   public RectangleAnchor getCategoryAnchor() {
      return this.categoryAnchor;
   }

   public TextBlockAnchor getLabelAnchor() {
      return this.labelAnchor;
   }

   public TextAnchor getRotationAnchor() {
      return this.rotationAnchor;
   }

   public double getAngle() {
      return this.angle;
   }

   public CategoryLabelWidthType getWidthType() {
      return this.widthType;
   }

   public float getWidthRatio() {
      return this.widthRatio;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CategoryLabelPosition)) {
         return false;
      } else {
         CategoryLabelPosition var2 = (CategoryLabelPosition)var1;
         return !this.categoryAnchor.equals(var2.categoryAnchor)?false:(!this.labelAnchor.equals(var2.labelAnchor)?false:(!this.rotationAnchor.equals(var2.rotationAnchor)?false:(this.angle != var2.angle?false:(this.widthType != var2.widthType?false:this.widthRatio == var2.widthRatio))));
      }
   }

   public int hashCode() {
      byte var1 = 19;
      int var2 = 37 * var1 + this.categoryAnchor.hashCode();
      var2 = 37 * var2 + this.labelAnchor.hashCode();
      var2 = 37 * var2 + this.rotationAnchor.hashCode();
      return var2;
   }
}
