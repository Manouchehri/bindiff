package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class MiddlePinNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = 6237073996403125310L;

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      GeneralPath var7 = new GeneralPath();
      int var8 = (int)var2.getMinY();
      int var9 = (int)var2.getMaxY();
      int var10 = (var9 - var8) / 2 + var8;
      int var11 = (int)(var2.getMinX() + var2.getWidth() / 2.0D);
      int var12 = (int)(var2.getWidth() / 10.0D);
      if(var12 < 2) {
         var12 = 2;
      }

      var7.moveTo((float)(var11 - var12), (float)(var10 - var12));
      var7.lineTo((float)(var11 + var12), (float)(var10 - var12));
      var7.lineTo((float)var11, (float)var8);
      var7.closePath();
      var12 = 4 * var12;
      Double var13 = new Double((double)(var11 - var12 / 2), (double)(var10 - var12), (double)var12, (double)var12);
      Area var6 = new Area(var13);
      var6.add(new Area(var7));
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var6.transform(this.getTransform());
      }

      this.defaultDisplay(var1, var6);
   }

   public boolean equals(Object var1) {
      return var1 == null?false:(var1 == this?true:super.equals(var1) && var1 instanceof MiddlePinNeedle);
   }

   public Object clone() {
      return super.clone();
   }
}
