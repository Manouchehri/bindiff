package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.ui.RectangleInsets;

public class WaferMapPlot extends Plot implements Serializable, Cloneable, RendererChangeListener {
   private static final long serialVersionUID = 4668320403707308155L;
   public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5F, 0, 2, 0.0F, new float[]{2.0F, 2.0F}, 0.0F);
   public static final Paint DEFAULT_GRIDLINE_PAINT;
   public static final boolean DEFAULT_CROSSHAIR_VISIBLE = false;
   public static final Stroke DEFAULT_CROSSHAIR_STROKE;
   public static final Paint DEFAULT_CROSSHAIR_PAINT;
   protected static ResourceBundle localizationResources;
   private PlotOrientation orientation;
   private WaferMapDataset dataset;
   private WaferMapRenderer renderer;

   public WaferMapPlot() {
      this((WaferMapDataset)null);
   }

   public WaferMapPlot(WaferMapDataset var1) {
      this(var1, (WaferMapRenderer)null);
   }

   public WaferMapPlot(WaferMapDataset var1, WaferMapRenderer var2) {
      this.orientation = PlotOrientation.VERTICAL;
      this.dataset = var1;
      if(var1 != null) {
         var1.addChangeListener(this);
      }

      this.renderer = var2;
      if(var2 != null) {
         var2.setPlot(this);
         var2.addChangeListener(this);
      }

   }

   public String getPlotType() {
      return "WMAP_Plot";
   }

   public WaferMapDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(WaferMapDataset var1) {
      if(this.dataset != null) {
         this.dataset.removeChangeListener(this);
      }

      this.dataset = var1;
      if(var1 != null) {
         this.setDatasetGroup(var1.getGroup());
         var1.addChangeListener(this);
      }

      this.datasetChanged(new DatasetChangeEvent(this, var1));
   }

   public void setRenderer(WaferMapRenderer var1) {
      if(this.renderer != null) {
         this.renderer.removeChangeListener(this);
      }

      this.renderer = var1;
      if(var1 != null) {
         var1.setPlot(this);
      }

      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      boolean var6 = var2.getWidth() <= 10.0D;
      boolean var7 = var2.getHeight() <= 10.0D;
      if(!var6 && !var7) {
         if(var5 != null) {
            var5.setPlotArea(var2);
         }

         RectangleInsets var8 = this.getInsets();
         var8.trim(var2);
         this.drawChipGrid(var1, var2);
         this.drawWaferEdge(var1, var2);
      }
   }

   protected void drawChipGrid(Graphics2D var1, Rectangle2D var2) {
      Shape var3 = var1.getClip();
      var1.setClip(this.getWaferEdge(var2));
      Double var4 = new Double();
      int var5 = 35;
      int var6 = 20;
      double var7 = 1.0D;
      if(this.dataset != null) {
         var5 = this.dataset.getMaxChipX() + 2;
         var6 = this.dataset.getMaxChipY() + 2;
         var7 = this.dataset.getChipSpace();
      }

      double var9 = var2.getX();
      double var11 = var2.getY();
      double var13 = 1.0D;
      double var15 = 1.0D;
      if(var2.getWidth() != var2.getHeight()) {
         double var17 = 0.0D;
         double var19 = 0.0D;
         if(var2.getWidth() > var2.getHeight()) {
            var17 = var2.getWidth();
            var19 = var2.getHeight();
         } else {
            var17 = var2.getHeight();
            var19 = var2.getWidth();
         }

         if(var2.getWidth() == var19) {
            var11 += (var17 - var19) / 2.0D;
            var13 = (var2.getWidth() - (var7 * (double)var5 - 1.0D)) / (double)var5;
            var15 = (var2.getWidth() - (var7 * (double)var6 - 1.0D)) / (double)var6;
         } else {
            var9 += (var17 - var19) / 2.0D;
            var13 = (var2.getHeight() - (var7 * (double)var5 - 1.0D)) / (double)var5;
            var15 = (var2.getHeight() - (var7 * (double)var6 - 1.0D)) / (double)var6;
         }
      }

      for(int var23 = 1; var23 <= var5; ++var23) {
         double var18 = var9 - var13 + var13 * (double)var23 + var7 * (double)(var23 - 1);

         for(int var20 = 1; var20 <= var6; ++var20) {
            double var21 = var11 - var15 + var15 * (double)var20 + var7 * (double)(var20 - 1);
            var4.setFrame(var18, var21, var13, var15);
            var1.setColor(Color.white);
            if(this.dataset.getChipValue(var23 - 1, var6 - var20 - 1) != null) {
               var1.setPaint(this.renderer.getChipColor(this.dataset.getChipValue(var23 - 1, var6 - var20 - 1)));
            }

            var1.fill(var4);
            var1.setColor(Color.lightGray);
            var1.draw(var4);
         }
      }

      var1.setClip(var3);
   }

   protected Ellipse2D getWaferEdge(Rectangle2D var1) {
      java.awt.geom.Ellipse2D.Double var2 = new java.awt.geom.Ellipse2D.Double();
      double var3 = var1.getWidth();
      double var5 = var1.getX();
      double var7 = var1.getY();
      if(var1.getWidth() != var1.getHeight()) {
         double var9 = 0.0D;
         double var11 = 0.0D;
         if(var1.getWidth() > var1.getHeight()) {
            var9 = var1.getWidth();
            var11 = var1.getHeight();
         } else {
            var9 = var1.getHeight();
            var11 = var1.getWidth();
         }

         var3 = var11;
         if(var1.getWidth() == var11) {
            var7 = var1.getY() + (var9 - var11) / 2.0D;
         } else {
            var5 = var1.getX() + (var9 - var11) / 2.0D;
         }
      }

      var2.setFrame(var5, var7, var3, var3);
      return var2;
   }

   protected void drawWaferEdge(Graphics2D var1, Rectangle2D var2) {
      Ellipse2D var3 = this.getWaferEdge(var2);
      var1.setColor(Color.black);
      var1.draw(var3);
      java.awt.geom.Arc2D.Double var4 = null;
      Rectangle2D var5 = var3.getFrame();
      double var6 = var5.getWidth() * 0.04D;
      Double var8;
      if(this.orientation == PlotOrientation.HORIZONTAL) {
         var8 = new Double(var5.getX() + var5.getWidth() - var6 / 2.0D, var5.getY() + var5.getHeight() / 2.0D - var6 / 2.0D, var6, var6);
         var4 = new java.awt.geom.Arc2D.Double(var8, 90.0D, 180.0D, 0);
      } else {
         var8 = new Double(var5.getX() + var5.getWidth() / 2.0D - var6 / 2.0D, var5.getY() + var5.getHeight() - var6 / 2.0D, var6, var6);
         var4 = new java.awt.geom.Arc2D.Double(var8, 0.0D, 180.0D, 0);
      }

      var1.setColor(Color.white);
      var1.fill(var4);
      var1.setColor(Color.black);
      var1.draw(var4);
   }

   public LegendItemCollection getLegendItems() {
      return this.renderer.getLegendCollection();
   }

   public void rendererChanged(RendererChangeEvent var1) {
      this.notifyListeners(new PlotChangeEvent(this));
   }

   static {
      DEFAULT_GRIDLINE_PAINT = Color.lightGray;
      DEFAULT_CROSSHAIR_STROKE = DEFAULT_GRIDLINE_STROKE;
      DEFAULT_CROSSHAIR_PAINT = Color.blue;
      localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   }
}
