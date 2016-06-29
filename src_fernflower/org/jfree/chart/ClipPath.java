package org.jfree.chart;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.ui.RectangleEdge;

public class ClipPath implements Cloneable {
   private double[] xValue;
   private double[] yValue;
   private boolean clip;
   private boolean drawPath;
   private boolean fillPath;
   private Paint fillPaint;
   private Paint drawPaint;
   private Stroke drawStroke;
   private Composite composite;

   public ClipPath() {
      this.xValue = null;
      this.yValue = null;
      this.clip = true;
      this.drawPath = false;
      this.fillPath = false;
      this.fillPaint = null;
      this.drawPaint = null;
      this.drawStroke = null;
      this.composite = null;
   }

   public ClipPath(double[] var1, double[] var2) {
      this(var1, var2, true, false, true);
   }

   public ClipPath(double[] var1, double[] var2, boolean var3, boolean var4, boolean var5) {
      this.xValue = null;
      this.yValue = null;
      this.clip = true;
      this.drawPath = false;
      this.fillPath = false;
      this.fillPaint = null;
      this.drawPaint = null;
      this.drawStroke = null;
      this.composite = null;
      this.xValue = var1;
      this.yValue = var2;
      this.clip = var3;
      this.fillPath = var4;
      this.drawPath = var5;
      this.fillPaint = Color.gray;
      this.drawPaint = Color.blue;
      this.drawStroke = new BasicStroke(1.0F);
      this.composite = AlphaComposite.Src;
   }

   public ClipPath(double[] var1, double[] var2, boolean var3, boolean var4, Paint var5, Paint var6, Stroke var7, Composite var8) {
      this.xValue = null;
      this.yValue = null;
      this.clip = true;
      this.drawPath = false;
      this.fillPath = false;
      this.fillPaint = null;
      this.drawPaint = null;
      this.drawStroke = null;
      this.composite = null;
      this.xValue = var1;
      this.yValue = var2;
      this.fillPath = var3;
      this.drawPath = var4;
      this.fillPaint = var5;
      this.drawPaint = var6;
      this.drawStroke = var7;
      this.composite = var8;
   }

   public GeneralPath draw(Graphics2D var1, Rectangle2D var2, ValueAxis var3, ValueAxis var4) {
      GeneralPath var5 = this.generateClipPath(var2, var3, var4);
      if(this.fillPath || this.drawPath) {
         Composite var6 = var1.getComposite();
         Paint var7 = var1.getPaint();
         Stroke var8 = var1.getStroke();
         if(this.fillPaint != null) {
            var1.setPaint(this.fillPaint);
         }

         if(this.composite != null) {
            var1.setComposite(this.composite);
         }

         if(this.fillPath) {
            var1.fill(var5);
         }

         if(this.drawStroke != null) {
            var1.setStroke(this.drawStroke);
         }

         if(this.drawPath) {
            var1.draw(var5);
         }

         var1.setPaint(var7);
         var1.setComposite(var6);
         var1.setStroke(var8);
      }

      return var5;
   }

   public GeneralPath generateClipPath(Rectangle2D var1, ValueAxis var2, ValueAxis var3) {
      GeneralPath var4 = new GeneralPath();
      double var5 = var2.valueToJava2D(this.xValue[0], var1, RectangleEdge.BOTTOM);
      double var7 = var3.valueToJava2D(this.yValue[0], var1, RectangleEdge.LEFT);
      var4.moveTo((float)var5, (float)var7);

      for(int var9 = 0; var9 < this.yValue.length; ++var9) {
         var5 = var2.valueToJava2D(this.xValue[var9], var1, RectangleEdge.BOTTOM);
         var7 = var3.valueToJava2D(this.yValue[var9], var1, RectangleEdge.LEFT);
         var4.lineTo((float)var5, (float)var7);
      }

      var4.closePath();
      return var4;
   }

   public Composite getComposite() {
      return this.composite;
   }

   public Paint getDrawPaint() {
      return this.drawPaint;
   }

   public boolean isDrawPath() {
      return this.drawPath;
   }

   public Stroke getDrawStroke() {
      return this.drawStroke;
   }

   public Paint getFillPaint() {
      return this.fillPaint;
   }

   public boolean isFillPath() {
      return this.fillPath;
   }

   public double[] getXValue() {
      return this.xValue;
   }

   public double[] getYValue() {
      return this.yValue;
   }

   public void setComposite(Composite var1) {
      this.composite = var1;
   }

   public void setDrawPaint(Paint var1) {
      this.drawPaint = var1;
   }

   public void setDrawPath(boolean var1) {
      this.drawPath = var1;
   }

   public void setDrawStroke(Stroke var1) {
      this.drawStroke = var1;
   }

   public void setFillPaint(Paint var1) {
      this.fillPaint = var1;
   }

   public void setFillPath(boolean var1) {
      this.fillPath = var1;
   }

   public void setXValue(double[] var1) {
      this.xValue = var1;
   }

   public void setYValue(double[] var1) {
      this.yValue = var1;
   }

   public boolean isClip() {
      return this.clip;
   }

   public void setClip(boolean var1) {
      this.clip = var1;
   }

   public Object clone() {
      ClipPath var1 = (ClipPath)super.clone();
      var1.xValue = (double[])((double[])this.xValue.clone());
      var1.yValue = (double[])((double[])this.yValue.clone());
      return var1;
   }
}
