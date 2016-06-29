package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class YIntervalRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -2951586537224143260L;

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      Rectangle var13 = null;
      EntityCollection var14 = null;
      if(var4 != null) {
         var14 = var4.getOwner().getEntityCollection();
      }

      IntervalXYDataset var15 = (IntervalXYDataset)var8;
      double var16 = var15.getXValue(var9, var10);
      double var18 = var15.getStartYValue(var9, var10);
      double var20 = var15.getEndYValue(var9, var10);
      RectangleEdge var22 = var5.getDomainAxisEdge();
      RectangleEdge var23 = var5.getRangeAxisEdge();
      double var24 = var6.valueToJava2D(var16, var3, var22);
      double var26 = var7.valueToJava2D(var18, var3, var23);
      double var28 = var7.valueToJava2D(var20, var3, var23);
      Paint var30 = this.getItemPaint(var9, var10);
      Stroke var31 = this.getItemStroke(var9, var10);
      Double var32 = null;
      Shape var33 = this.getItemShape(var9, var10);
      Shape var34 = null;
      Shape var35 = null;
      PlotOrientation var36 = var5.getOrientation();
      if(var36 == PlotOrientation.HORIZONTAL) {
         var32 = new Double(var26, var24, var28, var24);
         var34 = ShapeUtilities.createTranslatedShape(var33, var28, var24);
         var35 = ShapeUtilities.createTranslatedShape(var33, var26, var24);
      } else if(var36 == PlotOrientation.VERTICAL) {
         var32 = new Double(var24, var26, var24, var28);
         var34 = ShapeUtilities.createTranslatedShape(var33, var24, var28);
         var35 = ShapeUtilities.createTranslatedShape(var33, var24, var26);
      }

      var1.setPaint(var30);
      var1.setStroke(var31);
      var1.draw(var32);
      var1.fill(var34);
      var1.fill(var35);
      if(var14 != null) {
         if(var13 == null) {
            var13 = var32.getBounds();
         }

         String var37 = null;
         XYToolTipGenerator var38 = this.getToolTipGenerator(var9, var10);
         if(var38 != null) {
            var37 = var38.generateToolTip(var8, var9, var10);
         }

         String var39 = null;
         if(this.getURLGenerator() != null) {
            var39 = this.getURLGenerator().generateURL(var8, var9, var10);
         }

         XYItemEntity var40 = new XYItemEntity(var13, var8, var9, var10, var37, var39);
         var14.add(var40);
      }

   }

   public Object clone() {
      return super.clone();
   }
}
