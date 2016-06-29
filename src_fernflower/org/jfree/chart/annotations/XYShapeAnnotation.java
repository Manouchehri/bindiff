package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.HashUtilities;
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

public class XYShapeAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -8553218317600684041L;
   private transient Shape shape;
   private transient Stroke stroke;
   private transient Paint outlinePaint;
   private transient Paint fillPaint;

   public XYShapeAnnotation(Shape var1) {
      this(var1, new BasicStroke(1.0F), Color.black);
   }

   public XYShapeAnnotation(Shape var1, Stroke var2, Paint var3) {
      this(var1, var2, var3, (Paint)null);
   }

   public XYShapeAnnotation(Shape var1, Stroke var2, Paint var3, Paint var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else {
         this.shape = var1;
         this.stroke = var2;
         this.outlinePaint = var3;
         this.fillPaint = var4;
      }
   }

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      PlotOrientation var8 = var2.getOrientation();
      RectangleEdge var9 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var8);
      RectangleEdge var10 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var8);
      Rectangle2D var11 = this.shape.getBounds2D();
      double var12 = var11.getMinX();
      double var14 = var11.getMaxX();
      double var16 = var4.valueToJava2D(var12, var3, var9);
      double var18 = var4.valueToJava2D(var14, var3, var9);
      double var20 = (var18 - var16) / (var14 - var12);
      double var22 = var16 - var12 * var20;
      double var24 = var11.getMaxY();
      double var26 = var11.getMinY();
      double var28 = var5.valueToJava2D(var24, var3, var10);
      double var30 = var5.valueToJava2D(var26, var3, var10);
      double var32 = (var30 - var28) / (var26 - var24);
      double var34 = var28 - var32 * var24;
      Shape var36 = null;
      AffineTransform var37;
      if(var8 == PlotOrientation.HORIZONTAL) {
         var37 = new AffineTransform(0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
         AffineTransform var38 = new AffineTransform(var32, 0.0D, 0.0D, var20, var34, var22);
         var36 = var37.createTransformedShape(this.shape);
         var36 = var38.createTransformedShape(var36);
      } else if(var8 == PlotOrientation.VERTICAL) {
         var37 = new AffineTransform(var20, 0.0D, 0.0D, var32, var22, var34);
         var36 = var37.createTransformedShape(this.shape);
      }

      if(this.fillPaint != null) {
         var1.setPaint(this.fillPaint);
         var1.fill(var36);
      }

      if(this.stroke != null && this.outlinePaint != null) {
         var1.setPaint(this.outlinePaint);
         var1.setStroke(this.stroke);
         var1.draw(var36);
      }

      this.addEntity(var7, var36, var6, this.getToolTipText(), this.getURL());
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof XYShapeAnnotation)) {
         return false;
      } else {
         XYShapeAnnotation var2 = (XYShapeAnnotation)var1;
         return !this.shape.equals(var2.shape)?false:(!ObjectUtilities.equal(this.stroke, var2.stroke)?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:PaintUtilities.equal(this.fillPaint, var2.fillPaint)));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var2 = 37 * var1 + this.shape.hashCode();
      if(this.stroke != null) {
         var2 = 37 * var2 + this.stroke.hashCode();
      }

      var2 = 37 * var2 + HashUtilities.hashCodeForPaint(this.outlinePaint);
      var2 = 37 * var2 + HashUtilities.hashCodeForPaint(this.fillPaint);
      return var2;
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.shape, var1);
      SerialUtilities.writeStroke(this.stroke, var1);
      SerialUtilities.writePaint(this.outlinePaint, var1);
      SerialUtilities.writePaint(this.fillPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.shape = SerialUtilities.readShape(var1);
      this.stroke = SerialUtilities.readStroke(var1);
      this.outlinePaint = SerialUtilities.readPaint(var1);
      this.fillPaint = SerialUtilities.readPaint(var1);
   }
}
