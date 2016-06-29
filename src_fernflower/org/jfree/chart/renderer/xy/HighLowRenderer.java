package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class HighLowRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -8135673815876552516L;
   private boolean drawOpenTicks = true;
   private boolean drawCloseTicks = true;
   private transient Paint openTickPaint;
   private transient Paint closeTickPaint;

   public boolean getDrawOpenTicks() {
      return this.drawOpenTicks;
   }

   public void setDrawOpenTicks(boolean var1) {
      this.drawOpenTicks = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getDrawCloseTicks() {
      return this.drawCloseTicks;
   }

   public void setDrawCloseTicks(boolean var1) {
      this.drawCloseTicks = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Paint getOpenTickPaint() {
      return this.openTickPaint;
   }

   public void setOpenTickPaint(Paint var1) {
      this.openTickPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Paint getCloseTickPaint() {
      return this.closeTickPaint;
   }

   public void setCloseTickPaint(Paint var1) {
      this.closeTickPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      double var13 = var8.getXValue(var9, var10);
      if(var6.getRange().contains(var13)) {
         double var15 = var6.valueToJava2D(var13, var3, var5.getDomainAxisEdge());
         Double var17 = null;
         EntityCollection var18 = null;
         if(var4 != null) {
            var18 = var4.getOwner().getEntityCollection();
         }

         PlotOrientation var19 = var5.getOrientation();
         RectangleEdge var20 = var5.getRangeAxisEdge();
         Paint var21 = this.getItemPaint(var9, var10);
         Stroke var22 = this.getItemStroke(var9, var10);
         var1.setPaint(var21);
         var1.setStroke(var22);
         if(var8 instanceof OHLCDataset) {
            OHLCDataset var23 = (OHLCDataset)var8;
            double var24 = var23.getHighValue(var9, var10);
            double var26 = var23.getLowValue(var9, var10);
            double var28;
            double var30;
            if(!java.lang.Double.isNaN(var24) && !java.lang.Double.isNaN(var26)) {
               var28 = var7.valueToJava2D(var24, var3, var20);
               var30 = var7.valueToJava2D(var26, var3, var20);
               if(var19 == PlotOrientation.HORIZONTAL) {
                  var1.draw(new java.awt.geom.Line2D.Double(var30, var15, var28, var15));
                  var17 = new Double(Math.min(var30, var28), var15 - 1.0D, Math.abs(var28 - var30), 2.0D);
               } else if(var19 == PlotOrientation.VERTICAL) {
                  var1.draw(new java.awt.geom.Line2D.Double(var15, var30, var15, var28));
                  var17 = new Double(var15 - 1.0D, Math.min(var30, var28), 2.0D, Math.abs(var28 - var30));
               }
            }

            var28 = 2.0D;
            if(var6.isInverted()) {
               var28 = -var28;
            }

            double var32;
            if(this.getDrawOpenTicks()) {
               var30 = var23.getOpenValue(var9, var10);
               if(!java.lang.Double.isNaN(var30)) {
                  var32 = var7.valueToJava2D(var30, var3, var20);
                  if(this.openTickPaint != null) {
                     var1.setPaint(this.openTickPaint);
                  } else {
                     var1.setPaint(var21);
                  }

                  if(var19 == PlotOrientation.HORIZONTAL) {
                     var1.draw(new java.awt.geom.Line2D.Double(var32, var15 + var28, var32, var15));
                  } else if(var19 == PlotOrientation.VERTICAL) {
                     var1.draw(new java.awt.geom.Line2D.Double(var15 - var28, var32, var15, var32));
                  }
               }
            }

            if(this.getDrawCloseTicks()) {
               var30 = var23.getCloseValue(var9, var10);
               if(!java.lang.Double.isNaN(var30)) {
                  var32 = var7.valueToJava2D(var30, var3, var20);
                  if(this.closeTickPaint != null) {
                     var1.setPaint(this.closeTickPaint);
                  } else {
                     var1.setPaint(var21);
                  }

                  if(var19 == PlotOrientation.HORIZONTAL) {
                     var1.draw(new java.awt.geom.Line2D.Double(var32, var15, var32, var15 - var28));
                  } else if(var19 == PlotOrientation.VERTICAL) {
                     var1.draw(new java.awt.geom.Line2D.Double(var15, var32, var15 + var28, var32));
                  }
               }
            }
         } else if(var10 > 0) {
            double var35 = var8.getXValue(var9, var10 - 1);
            double var25 = var8.getYValue(var9, var10 - 1);
            double var27 = var8.getYValue(var9, var10);
            if(java.lang.Double.isNaN(var35) || java.lang.Double.isNaN(var25) || java.lang.Double.isNaN(var27)) {
               return;
            }

            double var29 = var6.valueToJava2D(var35, var3, var5.getDomainAxisEdge());
            double var31 = var7.valueToJava2D(var25, var3, var20);
            double var33 = var7.valueToJava2D(var27, var3, var20);
            if(var19 == PlotOrientation.HORIZONTAL) {
               var1.draw(new java.awt.geom.Line2D.Double(var31, var29, var33, var15));
            } else if(var19 == PlotOrientation.VERTICAL) {
               var1.draw(new java.awt.geom.Line2D.Double(var29, var31, var15, var33));
            }
         }

         if(var18 != null) {
            String var36 = null;
            XYToolTipGenerator var37 = this.getToolTipGenerator(var9, var10);
            if(var37 != null) {
               var36 = var37.generateToolTip(var8, var9, var10);
            }

            String var38 = null;
            if(this.getURLGenerator() != null) {
               var38 = this.getURLGenerator().generateURL(var8, var9, var10);
            }

            XYItemEntity var39 = new XYItemEntity(var17, var8, var9, var10, var36, var38);
            var18.add(var39);
         }

      }
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof HighLowRenderer)) {
         return false;
      } else {
         HighLowRenderer var2 = (HighLowRenderer)var1;
         return this.drawOpenTicks != var2.drawOpenTicks?false:(this.drawCloseTicks != var2.drawCloseTicks?false:(!PaintUtilities.equal(this.openTickPaint, var2.openTickPaint)?false:(!PaintUtilities.equal(this.closeTickPaint, var2.closeTickPaint)?false:super.equals(var1))));
      }
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.openTickPaint = SerialUtilities.readPaint(var1);
      this.closeTickPaint = SerialUtilities.readPaint(var1);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.openTickPaint, var1);
      SerialUtilities.writePaint(this.closeTickPaint, var1);
   }
}
