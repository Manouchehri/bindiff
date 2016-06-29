package org.jfree.chart.renderer.xy;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;

public class XYErrorRenderer extends XYLineAndShapeRenderer {
   private boolean drawXError = true;
   private boolean drawYError = true;
   private double capLength = 4.0D;
   private transient Paint errorPaint = null;

   public XYErrorRenderer() {
      super(false, true);
   }

   public boolean getDrawXError() {
      return this.drawXError;
   }

   public void setDrawXError(boolean var1) {
      if(this.drawXError != var1) {
         this.drawXError = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public boolean getDrawYError() {
      return this.drawYError;
   }

   public void setDrawYError(boolean var1) {
      if(this.drawYError != var1) {
         this.drawYError = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public double getCapLength() {
      return this.capLength;
   }

   public void setCapLength(double var1) {
      this.capLength = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Paint getErrorPaint() {
      return this.errorPaint;
   }

   public void setErrorPaint(Paint var1) {
      this.errorPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Range findDomainBounds(XYDataset var1) {
      return var1 != null?DatasetUtilities.findDomainBounds(var1, true):null;
   }

   public Range findRangeBounds(XYDataset var1) {
      return var1 != null?DatasetUtilities.findRangeBounds(var1, true):null;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(var12 == 0 && var8 instanceof IntervalXYDataset && this.getItemVisible(var9, var10)) {
         IntervalXYDataset var13 = (IntervalXYDataset)var8;
         PlotOrientation var14 = var5.getOrientation();
         double var15;
         double var17;
         double var19;
         RectangleEdge var21;
         double var22;
         double var24;
         double var26;
         Double var28;
         Double var29;
         Double var30;
         double var31;
         if(this.drawXError) {
            var15 = var13.getStartXValue(var9, var10);
            var17 = var13.getEndXValue(var9, var10);
            var19 = var13.getYValue(var9, var10);
            var21 = var5.getDomainAxisEdge();
            var22 = var6.valueToJava2D(var15, var3, var21);
            var24 = var6.valueToJava2D(var17, var3, var21);
            var26 = var7.valueToJava2D(var19, var3, var5.getRangeAxisEdge());
            var29 = null;
            var30 = null;
            var31 = this.capLength / 2.0D;
            if(var14 == PlotOrientation.VERTICAL) {
               var28 = new Double(var22, var26, var24, var26);
               var29 = new Double(var22, var26 - var31, var22, var26 + var31);
               var30 = new Double(var24, var26 - var31, var24, var26 + var31);
            } else {
               var28 = new Double(var26, var22, var26, var24);
               var29 = new Double(var26 - var31, var22, var26 + var31, var22);
               var30 = new Double(var26 - var31, var24, var26 + var31, var24);
            }

            var1.setStroke(new BasicStroke(1.0F));
            if(this.errorPaint != null) {
               var1.setPaint(this.errorPaint);
            } else {
               var1.setPaint(this.getItemPaint(var9, var10));
            }

            var1.draw(var28);
            var1.draw(var29);
            var1.draw(var30);
         }

         if(this.drawYError) {
            var15 = var13.getStartYValue(var9, var10);
            var17 = var13.getEndYValue(var9, var10);
            var19 = var13.getXValue(var9, var10);
            var21 = var5.getRangeAxisEdge();
            var22 = var7.valueToJava2D(var15, var3, var21);
            var24 = var7.valueToJava2D(var17, var3, var21);
            var26 = var6.valueToJava2D(var19, var3, var5.getDomainAxisEdge());
            var29 = null;
            var30 = null;
            var31 = this.capLength / 2.0D;
            if(var14 == PlotOrientation.VERTICAL) {
               var28 = new Double(var26, var22, var26, var24);
               var29 = new Double(var26 - var31, var22, var26 + var31, var22);
               var30 = new Double(var26 - var31, var24, var26 + var31, var24);
            } else {
               var28 = new Double(var22, var26, var24, var26);
               var29 = new Double(var22, var26 - var31, var22, var26 + var31);
               var30 = new Double(var24, var26 - var31, var24, var26 + var31);
            }

            var1.setStroke(new BasicStroke(1.0F));
            if(this.errorPaint != null) {
               var1.setPaint(this.errorPaint);
            } else {
               var1.setPaint(this.getItemPaint(var9, var10));
            }

            var1.draw(var28);
            var1.draw(var29);
            var1.draw(var30);
         }
      }

      super.drawItem(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYErrorRenderer)) {
         return false;
      } else {
         XYErrorRenderer var2 = (XYErrorRenderer)var1;
         return this.drawXError != var2.drawXError?false:(this.drawYError != var2.drawYError?false:(this.capLength != var2.capLength?false:(!PaintUtilities.equal(this.errorPaint, var2.errorPaint)?false:super.equals(var1))));
      }
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.errorPaint = SerialUtilities.readPaint(var1);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.errorPaint, var1);
   }
}
