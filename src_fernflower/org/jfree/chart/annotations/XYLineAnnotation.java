package org.jfree.chart.annotations;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Float;
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
import org.jfree.util.ShapeUtilities;

public class XYLineAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -80535465244091334L;
   private double x1;
   private double y1;
   private double x2;
   private double y2;
   private transient Stroke stroke;
   private transient Paint paint;

   public XYLineAnnotation(double var1, double var3, double var5, double var7) {
      this(var1, var3, var5, var7, new BasicStroke(1.0F), Color.black);
   }

   public XYLineAnnotation(double var1, double var3, double var5, double var7, Stroke var9, Paint var10) {
      if(var9 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else if(var10 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.x1 = var1;
         this.y1 = var3;
         this.x2 = var5;
         this.y2 = var7;
         this.stroke = var9;
         this.paint = var10;
      }
   }

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      PlotOrientation var8 = var2.getOrientation();
      RectangleEdge var9 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var8);
      RectangleEdge var10 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var8);
      float var11 = 0.0F;
      float var12 = 0.0F;
      float var13 = 0.0F;
      float var14 = 0.0F;
      if(var8 == PlotOrientation.VERTICAL) {
         var11 = (float)var4.valueToJava2D(this.x1, var3, var9);
         var13 = (float)var5.valueToJava2D(this.y1, var3, var10);
         var12 = (float)var4.valueToJava2D(this.x2, var3, var9);
         var14 = (float)var5.valueToJava2D(this.y2, var3, var10);
      } else if(var8 == PlotOrientation.HORIZONTAL) {
         var13 = (float)var4.valueToJava2D(this.x1, var3, var9);
         var11 = (float)var5.valueToJava2D(this.y1, var3, var10);
         var14 = (float)var4.valueToJava2D(this.x2, var3, var9);
         var12 = (float)var5.valueToJava2D(this.y2, var3, var10);
      }

      var1.setPaint(this.paint);
      var1.setStroke(this.stroke);
      Float var15 = new Float(var11, var13, var12, var14);
      var1.draw(var15);
      String var16 = this.getToolTipText();
      String var17 = this.getURL();
      if(var16 != null || var17 != null) {
         this.addEntity(var7, ShapeUtilities.createLineRegion(var15, 1.0F), var6, var16, var17);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof XYLineAnnotation)) {
         return false;
      } else {
         XYLineAnnotation var2 = (XYLineAnnotation)var1;
         return this.x1 != var2.x1?false:(this.y1 != var2.y1?false:(this.x2 != var2.x2?false:(this.y2 != var2.y2?false:(!PaintUtilities.equal(this.paint, var2.paint)?false:ObjectUtilities.equal(this.stroke, var2.stroke)))));
      }
   }

   public int hashCode() {
      long var2 = Double.doubleToLongBits(this.x1);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.x2);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.y1);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.y2);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
      SerialUtilities.writeStroke(this.stroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
      this.stroke = SerialUtilities.readStroke(var1);
   }
}
