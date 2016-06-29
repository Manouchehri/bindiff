package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class LineNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = 6215321387896748945L;

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      Double var6 = new Double();
      double var7 = var2.getMinX() + var2.getWidth() / 2.0D;
      var6.setLine(var7, var2.getMinY(), var7, var2.getMaxY());
      Object var9 = var6;
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var9 = this.getTransform().createTransformedShape(var6);
      }

      this.defaultDisplay(var1, (Shape)var9);
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof LineNeedle)?false:super.equals(var1));
   }

   public Object clone() {
      return super.clone();
   }
}
