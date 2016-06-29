package org.jfree.chart.needle;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.needle.MeterNeedle;

public class LongNeedle extends MeterNeedle implements Serializable, Cloneable {
   private static final long serialVersionUID = -4319985779783688159L;

   public LongNeedle() {
      this.setRotateY(0.8D);
   }

   protected void drawNeedle(Graphics2D var1, Rectangle2D var2, Point2D var3, double var4) {
      GeneralPath var6 = new GeneralPath();
      GeneralPath var7 = new GeneralPath();
      GeneralPath var8 = new GeneralPath();
      float var9 = (float)var2.getMinX();
      float var10 = (float)var2.getMinY();
      float var11 = (float)var2.getMaxX();
      float var12 = (float)var2.getMaxY();
      float var13 = (float)((double)var9 + var2.getWidth() * 0.5D);
      float var14 = (float)((double)var10 + var2.getHeight() * 0.8D);
      float var15 = var12 - 2.0F * (var12 - var14);
      if(var15 < var10) {
         var15 = var10;
      }

      var6.moveTo(var9, var14);
      var6.lineTo(var13, var10);
      var6.lineTo(var13, var15);
      var6.closePath();
      var7.moveTo(var11, var14);
      var7.lineTo(var13, var10);
      var7.lineTo(var13, var15);
      var7.closePath();
      var8.moveTo(var9, var14);
      var8.lineTo(var13, var12);
      var8.lineTo(var11, var14);
      var8.lineTo(var13, var15);
      var8.closePath();
      Object var16 = var6;
      Object var17 = var7;
      Object var18 = var8;
      if(var3 != null && var4 != 0.0D) {
         this.getTransform().setToRotation(var4, var3.getX(), var3.getY());
         var16 = var6.createTransformedShape(transform);
         var17 = var7.createTransformedShape(transform);
         var18 = var8.createTransformedShape(transform);
      }

      if(this.getHighlightPaint() != null) {
         var1.setPaint(this.getHighlightPaint());
         var1.fill((Shape)var18);
      }

      if(this.getFillPaint() != null) {
         var1.setPaint(this.getFillPaint());
         var1.fill((Shape)var16);
         var1.fill((Shape)var17);
      }

      if(this.getOutlinePaint() != null) {
         var1.setStroke(this.getOutlineStroke());
         var1.setPaint(this.getOutlinePaint());
         var1.draw((Shape)var16);
         var1.draw((Shape)var17);
         var1.draw((Shape)var18);
      }

   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof LongNeedle)?false:super.equals(var1));
   }

   public Object clone() {
      return super.clone();
   }
}
