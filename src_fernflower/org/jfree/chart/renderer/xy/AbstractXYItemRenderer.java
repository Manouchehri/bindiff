package org.jfree.chart.renderer.xy;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYSeriesLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class AbstractXYItemRenderer extends AbstractRenderer implements Serializable, Cloneable, XYItemRenderer {
   private static final long serialVersionUID = 8019124836026607990L;
   private XYPlot plot;
   private XYItemLabelGenerator itemLabelGenerator = null;
   private ObjectList itemLabelGeneratorList = new ObjectList();
   private XYItemLabelGenerator baseItemLabelGenerator;
   private XYToolTipGenerator toolTipGenerator = null;
   private ObjectList toolTipGeneratorList = new ObjectList();
   private XYToolTipGenerator baseToolTipGenerator;
   private XYURLGenerator urlGenerator = null;
   private List backgroundAnnotations = new ArrayList();
   private List foregroundAnnotations = new ArrayList();
   private int defaultEntityRadius = 3;
   private XYSeriesLabelGenerator legendItemLabelGenerator = new StandardXYSeriesLabelGenerator("{0}");
   private XYSeriesLabelGenerator legendItemToolTipGenerator;
   private XYSeriesLabelGenerator legendItemURLGenerator;

   public int getPassCount() {
      return 1;
   }

   public XYPlot getPlot() {
      return this.plot;
   }

   public void setPlot(XYPlot var1) {
      this.plot = var1;
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      XYItemRendererState var6 = new XYItemRendererState(var5);
      return var6;
   }

   public XYItemLabelGenerator getItemLabelGenerator(int var1, int var2) {
      if(this.itemLabelGenerator != null) {
         return this.itemLabelGenerator;
      } else {
         XYItemLabelGenerator var3 = (XYItemLabelGenerator)this.itemLabelGeneratorList.get(var1);
         if(var3 == null) {
            var3 = this.baseItemLabelGenerator;
         }

         return var3;
      }
   }

   public XYItemLabelGenerator getSeriesItemLabelGenerator(int var1) {
      return (XYItemLabelGenerator)this.itemLabelGeneratorList.get(var1);
   }

   public XYItemLabelGenerator getItemLabelGenerator() {
      return this.itemLabelGenerator;
   }

   public void setItemLabelGenerator(XYItemLabelGenerator var1) {
      this.itemLabelGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void setSeriesItemLabelGenerator(int var1, XYItemLabelGenerator var2) {
      this.itemLabelGeneratorList.set(var1, var2);
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYItemLabelGenerator getBaseItemLabelGenerator() {
      return this.baseItemLabelGenerator;
   }

   public void setBaseItemLabelGenerator(XYItemLabelGenerator var1) {
      this.baseItemLabelGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYToolTipGenerator getToolTipGenerator(int var1, int var2) {
      if(this.toolTipGenerator != null) {
         return this.toolTipGenerator;
      } else {
         XYToolTipGenerator var3 = (XYToolTipGenerator)this.toolTipGeneratorList.get(var1);
         if(var3 == null) {
            var3 = this.baseToolTipGenerator;
         }

         return var3;
      }
   }

   public XYToolTipGenerator getToolTipGenerator() {
      return this.toolTipGenerator;
   }

   public void setToolTipGenerator(XYToolTipGenerator var1) {
      this.toolTipGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYToolTipGenerator getSeriesToolTipGenerator(int var1) {
      return (XYToolTipGenerator)this.toolTipGeneratorList.get(var1);
   }

   public void setSeriesToolTipGenerator(int var1, XYToolTipGenerator var2) {
      this.toolTipGeneratorList.set(var1, var2);
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYToolTipGenerator getBaseToolTipGenerator() {
      return this.baseToolTipGenerator;
   }

   public void setBaseToolTipGenerator(XYToolTipGenerator var1) {
      this.baseToolTipGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYURLGenerator getURLGenerator() {
      return this.urlGenerator;
   }

   public void setURLGenerator(XYURLGenerator var1) {
      this.urlGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void addAnnotation(XYAnnotation var1) {
      this.addAnnotation(var1, Layer.FOREGROUND);
   }

   public void addAnnotation(XYAnnotation var1, Layer var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'annotation\' argument.");
      } else {
         if(var2.equals(Layer.FOREGROUND)) {
            this.foregroundAnnotations.add(var1);
            this.notifyListeners(new RendererChangeEvent(this));
         } else {
            if(!var2.equals(Layer.BACKGROUND)) {
               throw new RuntimeException("Unknown layer.");
            }

            this.backgroundAnnotations.add(var1);
            this.notifyListeners(new RendererChangeEvent(this));
         }

      }
   }

   public boolean removeAnnotation(XYAnnotation var1) {
      boolean var2 = this.foregroundAnnotations.remove(var1);
      var2 &= this.backgroundAnnotations.remove(var1);
      this.notifyListeners(new RendererChangeEvent(this));
      return var2;
   }

   public void removeAnnotations() {
      this.foregroundAnnotations.clear();
      this.backgroundAnnotations.clear();
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public int getDefaultEntityRadius() {
      return this.defaultEntityRadius;
   }

   public void setDefaultEntityRadius(int var1) {
      this.defaultEntityRadius = var1;
   }

   public XYSeriesLabelGenerator getLegendItemLabelGenerator() {
      return this.legendItemLabelGenerator;
   }

   public void setLegendItemLabelGenerator(XYSeriesLabelGenerator var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'generator\' argument.");
      } else {
         this.legendItemLabelGenerator = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public XYSeriesLabelGenerator getLegendItemToolTipGenerator() {
      return this.legendItemToolTipGenerator;
   }

   public void setLegendItemToolTipGenerator(XYSeriesLabelGenerator var1) {
      this.legendItemToolTipGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYSeriesLabelGenerator getLegendItemURLGenerator() {
      return this.legendItemURLGenerator;
   }

   public void setLegendItemURLGenerator(XYSeriesLabelGenerator var1) {
      this.legendItemURLGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Range findDomainBounds(XYDataset var1) {
      return var1 != null?DatasetUtilities.findDomainBounds(var1, false):null;
   }

   public Range findRangeBounds(XYDataset var1) {
      return var1 != null?DatasetUtilities.findRangeBounds(var1, false):null;
   }

   public LegendItemCollection getLegendItems() {
      if(this.plot == null) {
         return new LegendItemCollection();
      } else {
         LegendItemCollection var1 = new LegendItemCollection();
         int var2 = this.plot.getIndexOf(this);
         XYDataset var3 = this.plot.getDataset(var2);
         if(var3 != null) {
            int var4 = var3.getSeriesCount();

            for(int var5 = 0; var5 < var4; ++var5) {
               if(this.isSeriesVisibleInLegend(var5)) {
                  LegendItem var6 = this.getLegendItem(var2, var5);
                  if(var6 != null) {
                     var1.add(var6);
                  }
               }
            }
         }

         return var1;
      }
   }

   public LegendItem getLegendItem(int var1, int var2) {
      LegendItem var3 = null;
      XYPlot var4 = this.getPlot();
      if(var4 != null) {
         XYDataset var5 = var4.getDataset(var1);
         if(var5 != null) {
            String var6 = this.legendItemLabelGenerator.generateLabel(var5, var2);
            String var8 = null;
            if(this.getLegendItemToolTipGenerator() != null) {
               var8 = this.getLegendItemToolTipGenerator().generateLabel(var5, var2);
            }

            String var9 = null;
            if(this.getLegendItemURLGenerator() != null) {
               var9 = this.getLegendItemURLGenerator().generateLabel(var5, var2);
            }

            Shape var10 = this.getSeriesShape(var2);
            Paint var11 = this.getSeriesPaint(var2);
            Paint var12 = this.getSeriesOutlinePaint(var2);
            Stroke var13 = this.getSeriesOutlineStroke(var2);
            var3 = new LegendItem(var6, var6, var8, var9, var10, var11, var13, var12);
            var3.setSeriesIndex(var2);
            var3.setDatasetIndex(var1);
         }
      }

      return var3;
   }

   public void fillDomainGridBand(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, double var7) {
      double var9 = var3.valueToJava2D(var5, var4, var2.getDomainAxisEdge());
      double var11 = var3.valueToJava2D(var7, var4, var2.getDomainAxisEdge());
      Double var13 = new Double(var9, var4.getMinY(), var11 - var9, var4.getMaxY() - var4.getMinY());
      Paint var14 = var2.getDomainTickBandPaint();
      if(var14 != null) {
         var1.setPaint(var14);
         var1.fill(var13);
      }

   }

   public void fillRangeGridBand(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, double var7) {
      double var9 = var3.valueToJava2D(var5, var4, var2.getRangeAxisEdge());
      double var11 = var3.valueToJava2D(var7, var4, var2.getRangeAxisEdge());
      Double var13 = new Double(var4.getMinX(), var11, var4.getWidth(), var9 - var11);
      Paint var14 = var2.getRangeTickBandPaint();
      if(var14 != null) {
         var1.setPaint(var14);
         var1.fill(var13);
      }

   }

   public void drawDomainGridLine(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5) {
      Range var7 = var3.getRange();
      if(var7.contains(var5)) {
         PlotOrientation var8 = var2.getOrientation();
         double var9 = var3.valueToJava2D(var5, var4, var2.getDomainAxisEdge());
         java.awt.geom.Line2D.Double var11 = null;
         if(var8 == PlotOrientation.HORIZONTAL) {
            var11 = new java.awt.geom.Line2D.Double(var4.getMinX(), var9, var4.getMaxX(), var9);
         } else if(var8 == PlotOrientation.VERTICAL) {
            var11 = new java.awt.geom.Line2D.Double(var9, var4.getMinY(), var9, var4.getMaxY());
         }

         Paint var12 = var2.getDomainGridlinePaint();
         Stroke var13 = var2.getDomainGridlineStroke();
         var1.setPaint(var12 != null?var12:Plot.DEFAULT_OUTLINE_PAINT);
         var1.setStroke(var13 != null?var13:Plot.DEFAULT_OUTLINE_STROKE);
         var1.draw(var11);
      }
   }

   public void drawDomainLine(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, Paint var7, Stroke var8) {
      Range var9 = var3.getRange();
      if(var9.contains(var5)) {
         PlotOrientation var10 = var2.getOrientation();
         java.awt.geom.Line2D.Double var11 = null;
         double var12 = var3.valueToJava2D(var5, var4, var2.getDomainAxisEdge());
         if(var10 == PlotOrientation.HORIZONTAL) {
            var11 = new java.awt.geom.Line2D.Double(var4.getMinX(), var12, var4.getMaxX(), var12);
         } else if(var10 == PlotOrientation.VERTICAL) {
            var11 = new java.awt.geom.Line2D.Double(var12, var4.getMinY(), var12, var4.getMaxY());
         }

         var1.setPaint(var7);
         var1.setStroke(var8);
         var1.draw(var11);
      }
   }

   public void drawRangeLine(Graphics2D var1, XYPlot var2, ValueAxis var3, Rectangle2D var4, double var5, Paint var7, Stroke var8) {
      Range var9 = var3.getRange();
      if(var9.contains(var5)) {
         PlotOrientation var10 = var2.getOrientation();
         java.awt.geom.Line2D.Double var11 = null;
         double var12 = var3.valueToJava2D(var5, var4, var2.getRangeAxisEdge());
         if(var10 == PlotOrientation.HORIZONTAL) {
            var11 = new java.awt.geom.Line2D.Double(var12, var4.getMinY(), var12, var4.getMaxY());
         } else if(var10 == PlotOrientation.VERTICAL) {
            var11 = new java.awt.geom.Line2D.Double(var4.getMinX(), var12, var4.getMaxX(), var12);
         }

         var1.setPaint(var7);
         var1.setStroke(var8);
         var1.draw(var11);
      }
   }

   public void drawDomainMarker(Graphics2D var1, XYPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5) {
      double var7;
      if(var4 instanceof ValueMarker) {
         ValueMarker var6 = (ValueMarker)var4;
         var7 = var6.getValue();
         Range var9 = var3.getRange();
         if(!var9.contains(var7)) {
            return;
         }

         double var10 = var3.valueToJava2D(var7, var5, var2.getDomainAxisEdge());
         PlotOrientation var12 = var2.getOrientation();
         java.awt.geom.Line2D.Double var13 = null;
         if(var12 == PlotOrientation.HORIZONTAL) {
            var13 = new java.awt.geom.Line2D.Double(var5.getMinX(), var10, var5.getMaxX(), var10);
         } else if(var12 == PlotOrientation.VERTICAL) {
            var13 = new java.awt.geom.Line2D.Double(var10, var5.getMinY(), var10, var5.getMaxY());
         }

         Composite var14 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var4.getAlpha()));
         var1.setPaint(var4.getPaint());
         var1.setStroke(var4.getStroke());
         var1.draw(var13);
         String var15 = var4.getLabel();
         RectangleAnchor var16 = var4.getLabelAnchor();
         if(var15 != null) {
            Font var17 = var4.getLabelFont();
            var1.setFont(var17);
            var1.setPaint(var4.getLabelPaint());
            Point2D var18 = this.calculateDomainMarkerTextAnchorPoint(var1, var12, var5, var13.getBounds2D(), var4.getLabelOffset(), LengthAdjustmentType.EXPAND, var16);
            TextUtilities.drawAlignedString(var15, var1, (float)var18.getX(), (float)var18.getY(), var4.getLabelTextAnchor());
         }

         var1.setComposite(var14);
      } else if(var4 instanceof IntervalMarker) {
         IntervalMarker var29 = (IntervalMarker)var4;
         var7 = var29.getStartValue();
         double var30 = var29.getEndValue();
         Range var11 = var3.getRange();
         if(!var11.intersects(var7, var30)) {
            return;
         }

         double var31 = var3.valueToJava2D(var7, var5, var2.getDomainAxisEdge());
         double var32 = var3.valueToJava2D(var30, var5, var2.getDomainAxisEdge());
         double var33 = Math.min(var31, var32);
         double var34 = Math.max(var31, var32);
         PlotOrientation var20 = var2.getOrientation();
         Double var21 = null;
         if(var20 == PlotOrientation.HORIZONTAL) {
            var33 = Math.max(var33, var5.getMinY());
            var34 = Math.min(var34, var5.getMaxY());
            var21 = new Double(var5.getMinX(), var33, var5.getWidth(), var34 - var33);
         } else if(var20 == PlotOrientation.VERTICAL) {
            var33 = Math.max(var33, var5.getMinX());
            var34 = Math.min(var34, var5.getMaxX());
            var21 = new Double(var33, var5.getMinY(), var34 - var33, var5.getHeight());
         }

         Composite var22 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var4.getAlpha()));
         Paint var23 = var4.getPaint();
         if(var23 instanceof GradientPaint) {
            GradientPaint var24 = (GradientPaint)var23;
            GradientPaintTransformer var25 = var29.getGradientPaintTransformer();
            if(var25 != null) {
               var24 = var25.transform(var24, var21);
            }

            var1.setPaint(var24);
         } else {
            var1.setPaint(var23);
         }

         var1.fill(var21);
         if(var29.getOutlinePaint() != null && var29.getOutlineStroke() != null) {
            double var27;
            java.awt.geom.Line2D.Double var35;
            double var36;
            if(var20 == PlotOrientation.VERTICAL) {
               var35 = new java.awt.geom.Line2D.Double();
               var36 = var5.getMinY();
               var27 = var5.getMaxY();
               var1.setPaint(var29.getOutlinePaint());
               var1.setStroke(var29.getOutlineStroke());
               if(var11.contains(var7)) {
                  var35.setLine(var31, var36, var31, var27);
                  var1.draw(var35);
               }

               if(var11.contains(var30)) {
                  var35.setLine(var32, var36, var32, var27);
                  var1.draw(var35);
               }
            } else {
               var35 = new java.awt.geom.Line2D.Double();
               var36 = var5.getMinX();
               var27 = var5.getMaxX();
               var1.setPaint(var29.getOutlinePaint());
               var1.setStroke(var29.getOutlineStroke());
               if(var11.contains(var7)) {
                  var35.setLine(var36, var31, var27, var31);
                  var1.draw(var35);
               }

               if(var11.contains(var30)) {
                  var35.setLine(var36, var32, var27, var32);
                  var1.draw(var35);
               }
            }
         }

         String var37 = var4.getLabel();
         RectangleAnchor var38 = var4.getLabelAnchor();
         if(var37 != null) {
            Font var26 = var4.getLabelFont();
            var1.setFont(var26);
            var1.setPaint(var4.getLabelPaint());
            Point2D var39 = this.calculateDomainMarkerTextAnchorPoint(var1, var20, var5, var21, var4.getLabelOffset(), var4.getLabelOffsetType(), var38);
            TextUtilities.drawAlignedString(var37, var1, (float)var39.getX(), (float)var39.getY(), var4.getLabelTextAnchor());
         }

         var1.setComposite(var22);
      }

   }

   protected Point2D calculateDomainMarkerTextAnchorPoint(Graphics2D var1, PlotOrientation var2, Rectangle2D var3, Rectangle2D var4, RectangleInsets var5, LengthAdjustmentType var6, RectangleAnchor var7) {
      Rectangle2D var8 = null;
      if(var2 == PlotOrientation.HORIZONTAL) {
         var8 = var5.createAdjustedRectangle(var4, LengthAdjustmentType.CONTRACT, var6);
      } else if(var2 == PlotOrientation.VERTICAL) {
         var8 = var5.createAdjustedRectangle(var4, var6, LengthAdjustmentType.CONTRACT);
      }

      return RectangleAnchor.coordinates(var8, var7);
   }

   public void drawRangeMarker(Graphics2D var1, XYPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5) {
      double var7;
      if(var4 instanceof ValueMarker) {
         ValueMarker var6 = (ValueMarker)var4;
         var7 = var6.getValue();
         Range var9 = var3.getRange();
         if(!var9.contains(var7)) {
            return;
         }

         double var10 = var3.valueToJava2D(var7, var5, var2.getRangeAxisEdge());
         PlotOrientation var12 = var2.getOrientation();
         java.awt.geom.Line2D.Double var13 = null;
         if(var12 == PlotOrientation.HORIZONTAL) {
            var13 = new java.awt.geom.Line2D.Double(var10, var5.getMinY(), var10, var5.getMaxY());
         } else if(var12 == PlotOrientation.VERTICAL) {
            var13 = new java.awt.geom.Line2D.Double(var5.getMinX(), var10, var5.getMaxX(), var10);
         }

         Composite var14 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var4.getAlpha()));
         var1.setPaint(var4.getPaint());
         var1.setStroke(var4.getStroke());
         var1.draw(var13);
         String var15 = var4.getLabel();
         RectangleAnchor var16 = var4.getLabelAnchor();
         if(var15 != null) {
            Font var17 = var4.getLabelFont();
            var1.setFont(var17);
            var1.setPaint(var4.getLabelPaint());
            Point2D var18 = this.calculateRangeMarkerTextAnchorPoint(var1, var12, var5, var13.getBounds2D(), var4.getLabelOffset(), LengthAdjustmentType.EXPAND, var16);
            TextUtilities.drawAlignedString(var15, var1, (float)var18.getX(), (float)var18.getY(), var4.getLabelTextAnchor());
         }

         var1.setComposite(var14);
      } else if(var4 instanceof IntervalMarker) {
         IntervalMarker var29 = (IntervalMarker)var4;
         var7 = var29.getStartValue();
         double var30 = var29.getEndValue();
         Range var11 = var3.getRange();
         if(!var11.intersects(var7, var30)) {
            return;
         }

         double var31 = var3.valueToJava2D(var7, var5, var2.getRangeAxisEdge());
         double var32 = var3.valueToJava2D(var30, var5, var2.getRangeAxisEdge());
         double var33 = Math.min(var31, var32);
         double var34 = Math.max(var31, var32);
         PlotOrientation var20 = var2.getOrientation();
         Double var21 = null;
         if(var20 == PlotOrientation.HORIZONTAL) {
            var33 = Math.max(var33, var5.getMinX());
            var34 = Math.min(var34, var5.getMaxX());
            var21 = new Double(var33, var5.getMinY(), var34 - var33, var5.getHeight());
         } else if(var20 == PlotOrientation.VERTICAL) {
            var33 = Math.max(var33, var5.getMinY());
            var34 = Math.min(var34, var5.getMaxY());
            var21 = new Double(var5.getMinX(), var33, var5.getWidth(), var34 - var33);
         }

         Composite var22 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var4.getAlpha()));
         Paint var23 = var4.getPaint();
         if(var23 instanceof GradientPaint) {
            GradientPaint var24 = (GradientPaint)var23;
            GradientPaintTransformer var25 = var29.getGradientPaintTransformer();
            if(var25 != null) {
               var24 = var25.transform(var24, var21);
            }

            var1.setPaint(var24);
         } else {
            var1.setPaint(var23);
         }

         var1.fill(var21);
         if(var29.getOutlinePaint() != null && var29.getOutlineStroke() != null) {
            double var27;
            java.awt.geom.Line2D.Double var35;
            double var36;
            if(var20 == PlotOrientation.VERTICAL) {
               var35 = new java.awt.geom.Line2D.Double();
               var36 = var5.getMinX();
               var27 = var5.getMaxX();
               var1.setPaint(var29.getOutlinePaint());
               var1.setStroke(var29.getOutlineStroke());
               if(var11.contains(var7)) {
                  var35.setLine(var36, var31, var27, var31);
                  var1.draw(var35);
               }

               if(var11.contains(var30)) {
                  var35.setLine(var36, var32, var27, var32);
                  var1.draw(var35);
               }
            } else {
               var35 = new java.awt.geom.Line2D.Double();
               var36 = var5.getMinY();
               var27 = var5.getMaxY();
               var1.setPaint(var29.getOutlinePaint());
               var1.setStroke(var29.getOutlineStroke());
               if(var11.contains(var7)) {
                  var35.setLine(var31, var36, var31, var27);
                  var1.draw(var35);
               }

               if(var11.contains(var30)) {
                  var35.setLine(var32, var36, var32, var27);
                  var1.draw(var35);
               }
            }
         }

         String var37 = var4.getLabel();
         RectangleAnchor var38 = var4.getLabelAnchor();
         if(var37 != null) {
            Font var26 = var4.getLabelFont();
            var1.setFont(var26);
            var1.setPaint(var4.getLabelPaint());
            Point2D var39 = this.calculateRangeMarkerTextAnchorPoint(var1, var20, var5, var21, var4.getLabelOffset(), var4.getLabelOffsetType(), var38);
            TextUtilities.drawAlignedString(var37, var1, (float)var39.getX(), (float)var39.getY(), var4.getLabelTextAnchor());
         }

         var1.setComposite(var22);
      }

   }

   private Point2D calculateRangeMarkerTextAnchorPoint(Graphics2D var1, PlotOrientation var2, Rectangle2D var3, Rectangle2D var4, RectangleInsets var5, LengthAdjustmentType var6, RectangleAnchor var7) {
      Rectangle2D var8 = null;
      if(var2 == PlotOrientation.HORIZONTAL) {
         var8 = var5.createAdjustedRectangle(var4, var6, LengthAdjustmentType.CONTRACT);
      } else if(var2 == PlotOrientation.VERTICAL) {
         var8 = var5.createAdjustedRectangle(var4, LengthAdjustmentType.CONTRACT, var6);
      }

      return RectangleAnchor.coordinates(var8, var7);
   }

   protected Object clone() {
      AbstractXYItemRenderer var1 = (AbstractXYItemRenderer)super.clone();
      PublicCloneable var2;
      if(this.itemLabelGenerator != null && this.itemLabelGenerator instanceof PublicCloneable) {
         var2 = (PublicCloneable)this.itemLabelGenerator;
         var1.itemLabelGenerator = (XYItemLabelGenerator)var2.clone();
      }

      var1.itemLabelGeneratorList = (ObjectList)this.itemLabelGeneratorList.clone();
      if(this.baseItemLabelGenerator != null && this.baseItemLabelGenerator instanceof PublicCloneable) {
         var2 = (PublicCloneable)this.baseItemLabelGenerator;
         var1.baseItemLabelGenerator = (XYItemLabelGenerator)var2.clone();
      }

      if(this.toolTipGenerator != null && this.toolTipGenerator instanceof PublicCloneable) {
         var2 = (PublicCloneable)this.toolTipGenerator;
         var1.toolTipGenerator = (XYToolTipGenerator)var2.clone();
      }

      var1.toolTipGeneratorList = (ObjectList)this.toolTipGeneratorList.clone();
      if(this.baseToolTipGenerator != null && this.baseToolTipGenerator instanceof PublicCloneable) {
         var2 = (PublicCloneable)this.baseToolTipGenerator;
         var1.baseToolTipGenerator = (XYToolTipGenerator)var2.clone();
      }

      if(var1.legendItemLabelGenerator instanceof PublicCloneable) {
         var1.legendItemLabelGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemLabelGenerator);
      }

      if(var1.legendItemToolTipGenerator instanceof PublicCloneable) {
         var1.legendItemToolTipGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemToolTipGenerator);
      }

      if(var1.legendItemURLGenerator instanceof PublicCloneable) {
         var1.legendItemURLGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
      }

      var1.foregroundAnnotations = (List)ObjectUtilities.deepClone(this.foregroundAnnotations);
      var1.backgroundAnnotations = (List)ObjectUtilities.deepClone(this.backgroundAnnotations);
      if(var1.legendItemLabelGenerator instanceof PublicCloneable) {
         var1.legendItemLabelGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemLabelGenerator);
      }

      if(var1.legendItemToolTipGenerator instanceof PublicCloneable) {
         var1.legendItemToolTipGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemToolTipGenerator);
      }

      if(var1.legendItemURLGenerator instanceof PublicCloneable) {
         var1.legendItemURLGenerator = (XYSeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractXYItemRenderer)) {
         return false;
      } else {
         AbstractXYItemRenderer var2 = (AbstractXYItemRenderer)var1;
         return !ObjectUtilities.equal(this.itemLabelGenerator, var2.itemLabelGenerator)?false:(!this.itemLabelGeneratorList.equals(var2.itemLabelGeneratorList)?false:(!ObjectUtilities.equal(this.baseItemLabelGenerator, var2.baseItemLabelGenerator)?false:(!ObjectUtilities.equal(this.toolTipGenerator, var2.toolTipGenerator)?false:(!this.toolTipGeneratorList.equals(var2.toolTipGeneratorList)?false:(!ObjectUtilities.equal(this.baseToolTipGenerator, var2.baseToolTipGenerator)?false:(!ObjectUtilities.equal(this.urlGenerator, var2.urlGenerator)?false:(!this.foregroundAnnotations.equals(var2.foregroundAnnotations)?false:(!this.backgroundAnnotations.equals(var2.backgroundAnnotations)?false:(this.defaultEntityRadius != var2.defaultEntityRadius?false:(!ObjectUtilities.equal(this.legendItemLabelGenerator, var2.legendItemLabelGenerator)?false:(!ObjectUtilities.equal(this.legendItemToolTipGenerator, var2.legendItemToolTipGenerator)?false:(!ObjectUtilities.equal(this.legendItemURLGenerator, var2.legendItemURLGenerator)?false:super.equals(var1)))))))))))));
      }
   }

   public DrawingSupplier getDrawingSupplier() {
      DrawingSupplier var1 = null;
      XYPlot var2 = this.getPlot();
      if(var2 != null) {
         var1 = var2.getDrawingSupplier();
      }

      return var1;
   }

   protected void updateCrosshairValues(CrosshairState var1, double var2, double var4, double var6, double var8, PlotOrientation var10) {
      this.updateCrosshairValues(var1, var2, var4, 0, 0, var6, var8, var10);
   }

   protected void updateCrosshairValues(CrosshairState var1, double var2, double var4, int var6, int var7, double var8, double var10, PlotOrientation var12) {
      if(var12 == null) {
         throw new IllegalArgumentException("Null \'orientation\' argument.");
      } else {
         if(var1 != null) {
            if(this.plot.isDomainCrosshairLockedOnData()) {
               if(this.plot.isRangeCrosshairLockedOnData()) {
                  var1.updateCrosshairPoint(var2, var4, var6, var7, var8, var10, var12);
               } else {
                  var1.updateCrosshairX(var2, var6);
               }
            } else if(this.plot.isRangeCrosshairLockedOnData()) {
               var1.updateCrosshairY(var4, var7);
            }
         }

      }
   }

   protected void drawItemLabel(Graphics2D var1, PlotOrientation var2, XYDataset var3, int var4, int var5, double var6, double var8, boolean var10) {
      XYItemLabelGenerator var11 = this.getItemLabelGenerator(var4, var5);
      if(var11 != null) {
         Font var12 = this.getItemLabelFont(var4, var5);
         Paint var13 = this.getItemLabelPaint(var4, var5);
         var1.setFont(var12);
         var1.setPaint(var13);
         String var14 = var11.generateLabel(var3, var4, var5);
         ItemLabelPosition var15 = null;
         if(!var10) {
            var15 = this.getPositiveItemLabelPosition(var4, var5);
         } else {
            var15 = this.getNegativeItemLabelPosition(var4, var5);
         }

         Point2D var16 = this.calculateLabelAnchorPoint(var15.getItemLabelAnchor(), var6, var8, var2);
         TextUtilities.drawRotatedString(var14, var1, (float)var16.getX(), (float)var16.getY(), var15.getTextAnchor(), var15.getAngle(), var15.getRotationAnchor());
      }

   }

   public void drawAnnotations(Graphics2D var1, Rectangle2D var2, ValueAxis var3, ValueAxis var4, Layer var5, PlotRenderingInfo var6) {
      Iterator var7 = null;
      if(var5.equals(Layer.FOREGROUND)) {
         var7 = this.foregroundAnnotations.iterator();
      } else {
         if(!var5.equals(Layer.BACKGROUND)) {
            throw new RuntimeException("Unknown layer.");
         }

         var7 = this.backgroundAnnotations.iterator();
      }

      while(var7.hasNext()) {
         XYAnnotation var8 = (XYAnnotation)var7.next();
         var8.draw(var1, this.plot, var2, var3, var4, 0, var6);
      }

   }

   protected void addEntity(EntityCollection var1, Shape var2, XYDataset var3, int var4, int var5, double var6, double var8) {
      if(this.getItemCreateEntity(var4, var5)) {
         if(var2 == null) {
            var2 = new java.awt.geom.Ellipse2D.Double(var6 - (double)this.defaultEntityRadius, var8 - (double)this.defaultEntityRadius, (double)(this.defaultEntityRadius * 2), (double)(this.defaultEntityRadius * 2));
         }

         String var10 = null;
         XYToolTipGenerator var11 = this.getToolTipGenerator(var4, var5);
         if(var11 != null) {
            var10 = var11.generateToolTip(var3, var4, var5);
         }

         String var12 = null;
         if(this.getURLGenerator() != null) {
            var12 = this.getURLGenerator().generateURL(var3, var4, var5);
         }

         XYItemEntity var13 = new XYItemEntity((Shape)var2, var3, var4, var5, var10, var12);
         var1.add(var13);
      }
   }
}
