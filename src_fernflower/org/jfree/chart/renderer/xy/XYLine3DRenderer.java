package org.jfree.chart.renderer.xy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.Effect3D;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class XYLine3DRenderer extends XYLineAndShapeRenderer implements Serializable, Effect3D {
   private static final long serialVersionUID = 588933208243446087L;
   public static final double DEFAULT_X_OFFSET = 12.0D;
   public static final double DEFAULT_Y_OFFSET = 8.0D;
   public static final Paint DEFAULT_WALL_PAINT = new Color(221, 221, 221);
   private double xOffset;
   private double yOffset;
   private transient Paint wallPaint;

   public XYLine3DRenderer() {
      this.wallPaint = DEFAULT_WALL_PAINT;
      this.xOffset = 12.0D;
      this.yOffset = 8.0D;
   }

   public double getXOffset() {
      return this.xOffset;
   }

   public double getYOffset() {
      return this.yOffset;
   }

   public void setXOffset(double var1) {
      this.xOffset = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void setYOffset(double var1) {
      this.yOffset = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Paint getWallPaint() {
      return this.wallPaint;
   }

   public void setWallPaint(Paint var1) {
      this.wallPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public int getPassCount() {
      return 3;
   }

   protected boolean isLinePass(int var1) {
      return var1 == 0 || var1 == 1;
   }

   protected boolean isItemPass(int var1) {
      return var1 == 2;
   }

   protected boolean isShadowPass(int var1) {
      return var1 == 0;
   }

   protected void drawFirstPassShape(Graphics2D var1, int var2, int var3, int var4, Shape var5) {
      if(this.isShadowPass(var2)) {
         if(this.getWallPaint() != null) {
            var1.setStroke(this.getItemStroke(var3, var4));
            var1.setPaint(this.getWallPaint());
            var1.translate(this.getXOffset(), this.getYOffset());
            var1.draw(var5);
            var1.translate(-this.getXOffset(), -this.getYOffset());
         }
      } else {
         super.drawFirstPassShape(var1, var2, var3, var4, var5);
      }

   }
}
