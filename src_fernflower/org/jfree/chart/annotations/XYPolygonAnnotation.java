package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
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

public class XYPolygonAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -6984203651995900036L;
   private double[] polygon;
   private transient Stroke stroke;
   private transient Paint outlinePaint;
   private transient Paint fillPaint;

   public XYPolygonAnnotation(double[] var1) {
      this(var1, new BasicStroke(1.0F), Color.black);
   }

   public XYPolygonAnnotation(double[] var1, Stroke var2, Paint var3) {
      this(var1, var2, var3, (Paint)null);
   }

   public XYPolygonAnnotation(double[] var1, Stroke var2, Paint var3, Paint var4) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'polygon\' argument.");
      } else if(var1.length % 2 != 0) {
         throw new IllegalArgumentException("The \'polygon\' array must contain an even number of items.");
      } else {
         this.polygon = (double[])((double[])var1.clone());
         this.stroke = var2;
         this.outlinePaint = var3;
         this.fillPaint = var4;
      }
   }

   public double[] getPolygonCoordinates() {
      return (double[])((double[])this.polygon.clone());
   }

   public Paint getFillPaint() {
      return this.fillPaint;
   }

   public Stroke getOutlineStroke() {
      return this.stroke;
   }

   public Paint getOutlinePaint() {
      return this.outlinePaint;
   }

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      if(this.polygon.length >= 4) {
         PlotOrientation var8 = var2.getOrientation();
         RectangleEdge var9 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var8);
         RectangleEdge var10 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var8);
         GeneralPath var11 = new GeneralPath();
         double var12 = var4.valueToJava2D(this.polygon[0], var3, var9);
         double var14 = var5.valueToJava2D(this.polygon[1], var3, var10);
         int var16;
         if(var8 == PlotOrientation.HORIZONTAL) {
            var11.moveTo((float)var14, (float)var12);

            for(var16 = 2; var16 < this.polygon.length; var16 += 2) {
               var12 = var4.valueToJava2D(this.polygon[var16], var3, var9);
               var14 = var5.valueToJava2D(this.polygon[var16 + 1], var3, var10);
               var11.lineTo((float)var14, (float)var12);
            }

            var11.closePath();
         } else if(var8 == PlotOrientation.VERTICAL) {
            var11.moveTo((float)var12, (float)var14);

            for(var16 = 2; var16 < this.polygon.length; var16 += 2) {
               var12 = var4.valueToJava2D(this.polygon[var16], var3, var9);
               var14 = var5.valueToJava2D(this.polygon[var16 + 1], var3, var10);
               var11.lineTo((float)var12, (float)var14);
            }

            var11.closePath();
         }

         if(this.fillPaint != null) {
            var1.setPaint(this.fillPaint);
            var1.fill(var11);
         }

         if(this.stroke != null && this.outlinePaint != null) {
            var1.setPaint(this.outlinePaint);
            var1.setStroke(this.stroke);
            var1.draw(var11);
         }

         this.addEntity(var7, var11, var6, this.getToolTipText(), this.getURL());
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof XYPolygonAnnotation)) {
         return false;
      } else {
         XYPolygonAnnotation var2 = (XYPolygonAnnotation)var1;
         return !Arrays.equals(this.polygon, var2.polygon)?false:(!ObjectUtilities.equal(this.stroke, var2.stroke)?false:(!PaintUtilities.equal(this.outlinePaint, var2.outlinePaint)?false:PaintUtilities.equal(this.fillPaint, var2.fillPaint)));
      }
   }

   public int hashCode() {
      short var1 = 193;
      int var2 = 37 * var1 + HashUtilities.hashCodeForDoubleArray(this.polygon);
      var2 = 37 * var2 + HashUtilities.hashCodeForPaint(this.fillPaint);
      var2 = 37 * var2 + HashUtilities.hashCodeForPaint(this.outlinePaint);
      if(this.stroke != null) {
         var2 = 37 * var2 + this.stroke.hashCode();
      }

      return var2;
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
