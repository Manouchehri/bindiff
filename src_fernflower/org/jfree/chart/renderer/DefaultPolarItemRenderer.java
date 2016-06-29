package org.jfree.chart.renderer;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.PolarItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.TextAnchor;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;

public class DefaultPolarItemRenderer extends AbstractRenderer implements PolarItemRenderer {
   private PolarPlot plot;
   private BooleanList seriesFilled = new BooleanList();

   public void setPlot(PolarPlot var1) {
      this.plot = var1;
   }

   public PolarPlot getPlot() {
      return this.plot;
   }

   public DrawingSupplier getDrawingSupplier() {
      DrawingSupplier var1 = null;
      PolarPlot var2 = this.getPlot();
      if(var2 != null) {
         var1 = var2.getDrawingSupplier();
      }

      return var1;
   }

   public boolean isSeriesFilled(int var1) {
      boolean var2 = false;
      Boolean var3 = this.seriesFilled.getBoolean(var1);
      if(var3 != null) {
         var2 = var3.booleanValue();
      }

      return var2;
   }

   public void setSeriesFilled(int var1, boolean var2) {
      this.seriesFilled.setBoolean(var1, BooleanUtilities.valueOf(var2));
   }

   public void drawSeries(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, PolarPlot var4, XYDataset var5, int var6) {
      Polygon var7 = new Polygon();
      int var8 = var5.getItemCount(var6);

      for(int var9 = 0; var9 < var8; ++var9) {
         double var10 = var5.getXValue(var6, var9);
         double var12 = var5.getYValue(var6, var9);
         Point var14 = var4.translateValueThetaRadiusToJava2D(var10, var12, var2);
         var7.addPoint(var14.x, var14.y);
      }

      var1.setPaint(this.getSeriesPaint(var6));
      var1.setStroke(this.getSeriesStroke(var6));
      if(this.isSeriesFilled(var6)) {
         Composite var15 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, 0.5F));
         var1.fill(var7);
         var1.setComposite(var15);
      } else {
         var1.draw(var7);
      }

   }

   public void drawAngularGridLines(Graphics2D var1, PolarPlot var2, List var3, Rectangle2D var4) {
      var1.setFont(var2.getAngleLabelFont());
      var1.setStroke(var2.getAngleGridlineStroke());
      var1.setPaint(var2.getAngleGridlinePaint());
      double var5 = var2.getAxis().getLowerBound();
      double var7 = var2.getMaxRadius();
      Point var9 = var2.translateValueThetaRadiusToJava2D(var5, var5, var4);
      Iterator var10 = var3.iterator();

      while(var10.hasNext()) {
         NumberTick var11 = (NumberTick)var10.next();
         Point var12 = var2.translateValueThetaRadiusToJava2D(var11.getNumber().doubleValue(), var7, var4);
         var1.setPaint(var2.getAngleGridlinePaint());
         var1.drawLine(var9.x, var9.y, var12.x, var12.y);
         if(var2.isAngleLabelsVisible()) {
            int var13 = var12.x;
            int var14 = var12.y;
            var1.setPaint(var2.getAngleLabelPaint());
            TextUtilities.drawAlignedString(var11.getText(), var1, (float)var13, (float)var14, TextAnchor.CENTER);
         }
      }

   }

   public void drawRadialGridLines(Graphics2D var1, PolarPlot var2, ValueAxis var3, List var4, Rectangle2D var5) {
      var1.setFont(var3.getTickLabelFont());
      var1.setPaint(var2.getRadiusGridlinePaint());
      var1.setStroke(var2.getRadiusGridlineStroke());
      double var6 = var3.getLowerBound();
      Point var8 = var2.translateValueThetaRadiusToJava2D(var6, var6, var5);
      Iterator var9 = var4.iterator();

      while(var9.hasNext()) {
         NumberTick var10 = (NumberTick)var9.next();
         Point var11 = var2.translateValueThetaRadiusToJava2D(90.0D, var10.getNumber().doubleValue(), var5);
         int var12 = var11.x - var8.x;
         int var13 = var8.x - var12;
         int var14 = var8.y - var12;
         int var15 = 2 * var12;
         Double var16 = new Double((double)var13, (double)var14, (double)var15, (double)var15);
         var1.setPaint(var2.getRadiusGridlinePaint());
         var1.draw(var16);
      }

   }

   public LegendItem getLegendItem(int var1) {
      LegendItem var2 = null;
      PolarPlot var3 = this.getPlot();
      if(var3 != null) {
         XYDataset var4 = var3.getDataset();
         if(var4 != null) {
            String var5 = var4.getSeriesKey(var1).toString();
            Shape var7 = this.getSeriesShape(var1);
            Paint var8 = this.getSeriesPaint(var1);
            Paint var9 = this.getSeriesOutlinePaint(var1);
            Stroke var10 = this.getSeriesOutlineStroke(var1);
            var2 = new LegendItem(var5, var5, (String)null, (String)null, var7, var8, var10, var9);
         }
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(!(var1 instanceof DefaultPolarItemRenderer)) {
         return false;
      } else {
         DefaultPolarItemRenderer var2 = (DefaultPolarItemRenderer)var1;
         return !this.seriesFilled.equals(var2.seriesFilled)?false:super.equals(var1);
      }
   }

   public Object clone() {
      DefaultPolarItemRenderer var1 = (DefaultPolarItemRenderer)super.clone();
      var1.seriesFilled = (BooleanList)this.seriesFilled.clone();
      return var1;
   }
}
