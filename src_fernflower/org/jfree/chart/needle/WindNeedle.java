package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.needle.ArrowNeedle;

public class WindNeedle extends ArrowNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = -2861061368907167834L;

   public WindNeedle() {
      super(false);
   }

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      super.drawNeedle(var1, var2, var3, var4);
      if(var3 != null && var2 != null) {
         int var6 = this.getSize() * 3;
         Double var7 = new Double();
         var7.setRect(var2.getMinX() - (double)var6, var2.getMinY(), var2.getWidth(), var2.getHeight());
         super.drawNeedle(var1, var7, var3, var4);
         var7.setRect(var2.getMinX() + (double)var6, var2.getMinY(), var2.getWidth(), var2.getHeight());
         super.drawNeedle(var1, var7, var3, var4);
      }

   }

   public boolean equals(Object var1) {
      return var1 == null?false:(var1 == this?true:super.equals(var1) && var1 instanceof WindNeedle);
   }
}
