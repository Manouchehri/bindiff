package org.jfree.chart.annotations;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import org.jfree.chart.annotations.AbstractXYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.ui.Drawable;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class XYDrawableAnnotation extends AbstractXYAnnotation implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -6540812859722691020L;
   private double x;
   private double y;
   private double width;
   private double height;
   private Drawable drawable;

   public XYDrawableAnnotation(double var1, double var3, double var5, double var7, Drawable var9) {
      if(var9 == null) {
         throw new IllegalArgumentException("Null \'drawable\' argument.");
      } else {
         this.x = var1;
         this.y = var3;
         this.width = var5;
         this.height = var7;
         this.drawable = var9;
      }
   }

   public void draw(Graphics2D var1, XYPlot var2, Rectangle2D var3, ValueAxis var4, ValueAxis var5, int var6, PlotRenderingInfo var7) {
      PlotOrientation var8 = var2.getOrientation();
      RectangleEdge var9 = Plot.resolveDomainAxisLocation(var2.getDomainAxisLocation(), var8);
      RectangleEdge var10 = Plot.resolveRangeAxisLocation(var2.getRangeAxisLocation(), var8);
      float var11 = (float)var4.valueToJava2D(this.x, var3, var9);
      float var12 = (float)var5.valueToJava2D(this.y, var3, var10);
      Double var13 = new Double((double)var11 - this.width / 2.0D, (double)var12 - this.height / 2.0D, this.width, this.height);
      this.drawable.draw(var1, var13);
      String var14 = this.getToolTipText();
      String var15 = this.getURL();
      if(var14 != null || var15 != null) {
         this.addEntity(var7, var13, var6, var14, var15);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof XYDrawableAnnotation)) {
         return false;
      } else {
         XYDrawableAnnotation var2 = (XYDrawableAnnotation)var1;
         return this.x != var2.x?false:(this.y != var2.y?false:(this.width != var2.width?false:(this.height != var2.height?false:ObjectUtilities.equal(this.drawable, var2.drawable))));
      }
   }

   public int hashCode() {
      long var2 = java.lang.Double.doubleToLongBits(this.x);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.y);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.width);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = java.lang.Double.doubleToLongBits(this.height);
      var1 = 29 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   public Object clone() {
      return super.clone();
   }
}
