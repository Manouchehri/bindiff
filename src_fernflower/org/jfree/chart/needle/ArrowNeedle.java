package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Float;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class ArrowNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = -5334056511213782357L;
   private boolean isArrowAtTop = true;

   public ArrowNeedle(boolean var1) {
      this.isArrowAtTop = var1;
   }

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      Float var6 = new Float();
      Object var7 = null;
      float var8 = (float)(var2.getMinX() + var2.getWidth() / 2.0D);
      float var9 = (float)var2.getMinY();
      float var10 = (float)var2.getMaxY();
      var6.setLine((double)var8, (double)var9, (double)var8, (double)var10);
      GeneralPath var11 = new GeneralPath();
      if(this.isArrowAtTop) {
         var11.moveTo(var8, var9);
         var9 += (float)(4 * this.getSize());
      } else {
         var11.moveTo(var8, var10);
         var9 = var10 - (float)(4 * this.getSize());
      }

      var11.lineTo(var8 + (float)this.getSize(), var9);
      var11.lineTo(var8 - (float)this.getSize(), var9);
      var11.closePath();
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var7 = this.getTransform().createTransformedShape(var6);
      } else {
         var7 = var6;
      }

      this.defaultDisplay(var1, (Shape)var7);
      if(var3 != null && var4 != 0.0D) {
         var7 = this.getTransform().createTransformedShape(var11);
      } else {
         var7 = var11;
      }

      this.defaultDisplay(var1, (Shape)var7);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ArrowNeedle)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         ArrowNeedle var2 = (ArrowNeedle)var1;
         return this.isArrowAtTop == var2.isArrowAtTop;
      }
   }

   public Object clone() {
      return super.clone();
   }
}
