package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.annotations.AbstractXYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class XYBoxAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 6764703772526757457L;
   private double x0;
   private double y0;
   private double x1;
   private double y1;
   private transient Stroke stroke;
   private transient Paint outlinePaint;
   private transient Paint fillPaint;

   public XYBoxAnnotation(double var1, double var3, double var5, double var7) {
      this(var1, var3, var5, var7, new BasicStroke(1.0F), Color.black);
   }

   public XYBoxAnnotation(double var1, double var3, double var5, double var7, Stroke var9, Paint var10) {
      this(var1, var3, var5, var7, var9, var10, (Paint)null);
   }

   public XYBoxAnnotation(double var1, double var3, double var5, double var7, Stroke var9, Paint var10, Paint var11) {
      this.x0 = var1;
      this.y0 = var3;
      this.x1 = var5;
      this.y1 = var7;
      this.stroke = var9;
      this.outlinePaint = var10;
      this.fillPaint = var11;
   }

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      PlotOrientation var8 = var2.getOrientation();
      RectangleEdge var9 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var8);
      RectangleEdge var10 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var8);
      double var11 = var4.valueToJava2D(this.x0, var3, var9);
      double var13 = var5.valueToJava2D(this.y0, var3, var10);
      double var15 = var4.valueToJava2D(this.x1, var3, var9);
      double var17 = var5.valueToJava2D(this.y1, var3, var10);
      Double var19 = null;
      if(var8 == PlotOrientation.HORIZONTAL) {
         var19 = new Double(var13, var15, var17 - var13, var11 - var15);
      } else if(var8 == PlotOrientation.VERTICAL) {
         var19 = new Double(var11, var17, var15 - var11, var13 - var17);
      }

      if(this.fillPaint != null) {
         var1.setPaint(this.fillPaint);
         var1.fill(var19);
      }

      if(this.stroke != null && this.outlinePaint != null) {
         var1.setPaint(this.outlinePaint);
         var1.setStroke(this.stroke);
         var1.draw(var19);
      }

      this.addEntity(var7, var19, var6, this.getToolTipText(), this.getURL());
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof XYBoxAnnotation)) {
         return false;
      } else {
         XYBoxAnnotation var2 = (XYBoxAnnotation)var1;
         return this.x0 != var2.x0?false:(this.y0 != var2.y0?false:(this.x1 != var2.x1?false:(this.y1 != var2.y1?false:(!ObjectUtilities.equal(this.stroke, var2.stroke)?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:PaintUtilities.equal(this.fillPaint, var2.fillPaint))))));
      }
   }

   public int hashCode() {
      long var2 = java.lang.Double.doubleToLongBits(this.x0);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.x1);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.y0);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.y1);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.stroke, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writePaint(this.fillPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.stroke = SerialUtilities.readStroke(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.fillPaint = SerialUtilities.readPaint(var1);
   }
}
