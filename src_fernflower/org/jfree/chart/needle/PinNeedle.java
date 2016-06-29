package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class PinNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = -3787089953079863373L;

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      GeneralPath var7 = new GeneralPath();
      int var8 = (int)var2.getMinY();
      int var9 = (int)var2.getMaxY();
      int var10 = (int)(var2.getMinX() + var2.getWidth() / 2.0D);
      int var11 = (int)(var2.getWidth() / 10.0D);
      if(var11 < 2) {
         var11 = 2;
      }

      var7.moveTo((float)(var10 - var11), (float)(var9 - var11));
      var7.lineTo((float)(var10 + var11), (float)(var9 - var11));
      var7.lineTo((float)var10, (float)(var8 + var11));
      var7.closePath();
      var11 = 4 * var11;
      Double var12 = new Double((double)(var10 - var11 / 2), var2.getMaxY() - (double)var11, (double)var11, (double)var11);
      Area var6 = new Area(var12);
      var6.add(new Area(var7));
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var6.transform(this.getTransform());
      }

      this.defaultDisplay(var1, var6);
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof PinNeedle)?false:super.equals(var1));
   }

   public Object clone() {
      return super.clone();
   }
}
