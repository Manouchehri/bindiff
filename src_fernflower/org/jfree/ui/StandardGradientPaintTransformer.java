package org.jfree.ui;

import java.awt.GradientPaint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.util.PublicCloneable;

public class StandardGradientPaintTransformer implements Serializable, Cloneable, GradientPaintTransformer, PublicCloneable {
   private static final long serialVersionUID = -8155025776964678320L;
   private GradientPaintTransformType type;

   public StandardGradientPaintTransformer() {
      this(GradientPaintTransformType.VERTICAL);
   }

   public StandardGradientPaintTransformer(GradientPaintTransformType var1) {
      this.type = var1;
   }

   public GradientPaint transform(GradientPaint var1, Shape var2) {
      GradientPaint var3 = var1;
      Rectangle2D var4 = var2.getBounds2D();
      if(this.type.equals(GradientPaintTransformType.VERTICAL)) {
         var3 = new GradientPaint((float)var4.getCenterX(), (float)var4.getMinY(), var1.getColor1(), (float)var4.getCenterX(), (float)var4.getMaxY(), var1.getColor2());
      } else if(this.type.equals(GradientPaintTransformType.HORIZONTAL)) {
         var3 = new GradientPaint((float)var4.getMinX(), (float)var4.getCenterY(), var1.getColor1(), (float)var4.getMaxX(), (float)var4.getCenterY(), var1.getColor2());
      } else if(this.type.equals(GradientPaintTransformType.CENTER_HORIZONTAL)) {
         var3 = new GradientPaint((float)var4.getCenterX(), (float)var4.getCenterY(), var1.getColor1(), (float)var4.getMaxX(), (float)var4.getCenterY(), var1.getColor2(), true);
      } else if(this.type.equals(GradientPaintTransformType.CENTER_VERTICAL)) {
         var3 = new GradientPaint((float)var4.getCenterX(), (float)var4.getMinY(), var1.getColor1(), (float)var4.getCenterX(), (float)var4.getCenterY(), var1.getColor2(), true);
      }

      return var3;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardGradientPaintTransformer)) {
         return false;
      } else {
         StandardGradientPaintTransformer var2 = (StandardGradientPaintTransformer)var1;
         return this.type == var2.type;
      }
   }

   public Object clone() {
      return super.clone();
   }

   public int hashCode() {
      return this.type != null?this.type.hashCode():0;
   }
}
