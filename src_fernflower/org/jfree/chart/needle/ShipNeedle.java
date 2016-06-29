package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Arc2D.Double;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class ShipNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = 149554868169435612L;

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      GeneralPath var6 = new GeneralPath();
      var6.append(new Double(-9.0D, -7.0D, 10.0D, 14.0D, 0.0D, 25.5D, 0), true);
      var6.append(new Double(0.0D, -7.0D, 10.0D, 14.0D, 154.5D, 25.5D, 0), true);
      var6.closePath();
      this.getTransform().setToTranslation(var2.getMinX(), var2.getMaxY());
      this.getTransform().scale(var2.getWidth(), var2.getHeight() / 3.0D);
      var6.transform(this.getTransform());
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var6.transform(this.getTransform());
      }

      this.defaultDisplay(var1, var6);
   }

   public boolean equals(Object var1) {
      return var1 == null?false:(var1 == this?true:super.equals(var1) && var1 instanceof ShipNeedle);
   }

   public Object clone() {
      return super.clone();
   }
}
