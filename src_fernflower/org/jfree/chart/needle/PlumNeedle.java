package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D.Double;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class PlumNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = -3082660488660600718L;

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      Double var6 = new Double(2);
      double var7 = var2.getHeight();
      double var9 = var2.getWidth() / 2.0D;
      double var11 = 2.0D * var7;
      var6.setFrame(var2.getMinX() + var9 - var7, var2.getMinY() - var7, var11, var11);
      var7 = Math.toDegrees(Math.asin(var9 / var7));
      var6.setAngleStart(270.0D - var7);
      var6.setAngleExtent(2.0D * var7);
      Area var13 = new Area(var6);
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var13.transform(this.getTransform());
      }

      this.defaultDisplay(var1, var13);
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof PlumNeedle)?false:super.equals(var1));
   }

   public Object clone() {
      return super.clone();
   }
}
