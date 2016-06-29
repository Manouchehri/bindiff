package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class PointerNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = -4744677345334729606L;

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      GeneralPath var6 = new GeneralPath();
      GeneralPath var7 = new GeneralPath();
      float var8 = (float)var2.getMinX();
      float var9 = (float)var2.getMinY();
      float var10 = (float)var2.getMaxX();
      float var11 = (float)var2.getMaxY();
      float var12 = (float)((double)var8 + var2.getWidth() / 2.0D);
      float var13 = (float)((double)var9 + var2.getHeight() / 2.0D);
      var6.moveTo(var8, var13);
      var6.lineTo(var12, var9);
      var6.lineTo(var10, var13);
      var6.closePath();
      var7.moveTo(var8, var13);
      var7.lineTo(var12, var11);
      var7.lineTo(var10, var13);
      var7.closePath();
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var6.transform(this.getTransform());
         var7.transform(this.getTransform());
      }

      if(this.getFillPaint() != null) {
         var1.setPaint(this.getFillPaint());
         var1.fill(var6);
      }

      if(this.getHighlightPaint() != null) {
         var1.setPaint(this.getHighlightPaint());
         var1.fill(var7);
      }

      if(this.getOutlinePaint() != null) {
         var1.setStroke(this.getOutlineStroke());
         var1.setPaint(this.getOutlinePaint());
         var1.draw(var6);
         var1.draw(var7);
      }

   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof PointerNeedle)?false:super.equals(var1));
   }

   public Object clone() {
      return super.clone();
   }
}
