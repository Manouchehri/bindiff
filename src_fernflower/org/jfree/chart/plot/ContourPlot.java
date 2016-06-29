package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.ClipPath;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.ColorBar;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.ContourEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.ContourToolTipGenerator;
import org.jfree.chart.labels.StandardContourToolTipGenerator;
import org.jfree.chart.plot.ContourValuePlot;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.contour.ContourDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;

public class ContourPlot extends Plot implements PropertyChangeListener, Serializable, Cloneable, ContourValuePlot, ValueAxisPlot {
   private static final long serialVersionUID = 7861072556590502247L;
   protected static final RectangleInsets DEFAULT_INSETS = new RectangleInsets(2.0D, 2.0D, 100.0D, 10.0D);
   private ValueAxis domainAxis;
   private ValueAxis rangeAxis;
   private ContourDataset dataset;
   private ColorBar colorBar;
   private RectangleEdge colorBarLocation;
   private boolean domainCrosshairVisible;
   private double domainCrosshairValue;
   private transient Stroke domainCrosshairStroke;
   private transient Paint domainCrosshairPaint;
   private boolean domainCrosshairLockedOnData;
   private boolean rangeCrosshairVisible;
   private double rangeCrosshairValue;
   private transient Stroke rangeCrosshairStroke;
   private transient Paint rangeCrosshairPaint;
   private boolean rangeCrosshairLockedOnData;
   private double dataAreaRatio;
   private List domainMarkers;
   private List rangeMarkers;
   private List annotations;
   private ContourToolTipGenerator toolTipGenerator;
   private XYURLGenerator urlGenerator;
   private boolean renderAsPoints;
   private double ptSizePct;
   private transient ClipPath clipPath;
   private transient Paint missingPaint;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");

   public ContourPlot() {
      this((ContourDataset)null, (ValueAxis)null, (ValueAxis)null, (ColorBar)null);
   }

   public ContourPlot(ContourDataset var1, ValueAxis var2, ValueAxis var3, ColorBar var4) {
      this.colorBar = null;
      this.domainCrosshairLockedOnData = true;
      this.rangeCrosshairLockedOnData = true;
      this.dataAreaRatio = 0.0D;
      this.renderAsPoints = false;
      this.ptSizePct = 0.05D;
      this.clipPath = null;
      this.missingPaint = null;
      this.dataset = var1;
      if(var1 != null) {
         var1.addChangeListener(this);
      }

      this.domainAxis = var2;
      if(var2 != null) {
         var2.setPlot(this);
         var2.addChangeListener(this);
      }

      this.rangeAxis = var3;
      if(var3 != null) {
         var3.setPlot(this);
         var3.addChangeListener(this);
      }

      this.colorBar = var4;
      if(var4 != null) {
         var4.getAxis().setPlot(this);
         var4.getAxis().addChangeListener(this);
         var4.configure(this);
      }

      this.colorBarLocation = RectangleEdge.LEFT;
      this.toolTipGenerator = new StandardContourToolTipGenerator();
   }

   public RectangleEdge getColorBarLocation() {
      return this.colorBarLocation;
   }

   public void setColorBarLocation(RectangleEdge var1) {
      this.colorBarLocation = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public ContourDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(ContourDataset var1) {
      ContourDataset var2 = this.dataset;
      if(var2 != null) {
         var2.removeChangeListener(this);
      }

      this.dataset = var1;
      if(var1 != null) {
         this.setDatasetGroup(var1.getGroup());
         var1.addChangeListener(this);
      }

      DatasetChangeEvent var3 = new DatasetChangeEvent(this, var1);
      this.datasetChanged(var3);
   }

   public ValueAxis getDomainAxis() {
      ValueAxis var1 = this.domainAxis;
      return var1;
   }

   public void setDomainAxis(ValueAxis var1) {
      if(this.isCompatibleDomainAxis(var1)) {
         if(var1 != null) {
            var1.setPlot(this);
            var1.addChangeListener(this);
         }

         if(this.domainAxis != null) {
            this.domainAxis.removeChangeListener(this);
         }

         this.domainAxis = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public ValueAxis getRangeAxis() {
      ValueAxis var1 = this.rangeAxis;
      return var1;
   }

   public void setRangeAxis(ValueAxis var1) {
      if(var1 != null) {
         var1.setPlot(this);
         var1.addChangeListener(this);
      }

      if(this.rangeAxis != null) {
         this.rangeAxis.removeChangeListener(this);
      }

      this.rangeAxis = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void setColorBarAxis(ColorBar var1) {
      this.colorBar = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getDataAreaRatio() {
      return this.dataAreaRatio;
   }

   public void setDataAreaRatio(double var1) {
      this.dataAreaRatio = var1;
   }

   public void addDomainMarker(Marker var1) {
      if(this.domainMarkers == null) {
         this.domainMarkers = new ArrayList();
      }

      this.domainMarkers.add(var1);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void clearDomainMarkers() {
      if(this.domainMarkers != null) {
         this.domainMarkers.clear();
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void addRangeMarker(Marker var1) {
      if(this.rangeMarkers == null) {
         this.rangeMarkers = new ArrayList();
      }

      this.rangeMarkers.add(var1);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void clearRangeMarkers() {
      if(this.rangeMarkers != null) {
         this.rangeMarkers.clear();
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void addAnnotation(XYAnnotation var1) {
      if(this.annotations == null) {
         this.annotations = new ArrayList();
      }

      this.annotations.add(var1);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void clearAnnotations() {
      if(this.annotations != null) {
         this.annotations.clear();
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean isCompatibleDomainAxis(ValueAxis var1) {
      return true;
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
         AxisSpace var9 = new AxisSpace();
         var9 = this.domainAxis.reserveSpace(var1, this, var2, RectangleEdge.BOTTOM, var9);
         var9 = this.rangeAxis.reserveSpace(var1, this, var2, RectangleEdge.LEFT, var9);
         Rectangle2D var10 = var9.shrink(var2, (Rectangle2D)null);
         AxisSpace var11 = new AxisSpace();
         var11 = this.colorBar.reserveSpace(var1, this, var2, var10, this.colorBarLocation, var11);
         Rectangle2D var12 = var11.shrink(var2, (Rectangle2D)null);
         Rectangle2D var13 = var9.shrink(var12, (Rectangle2D)null);
         Rectangle2D var14 = var11.reserved(var2, this.colorBarLocation);
         if(this.getDataAreaRatio() != 0.0D) {
            double var15 = this.getDataAreaRatio();
            Rectangle2D var17 = (Rectangle2D)var13.clone();
            double var18 = var17.getHeight();
            double var20 = var17.getWidth();
            if(var15 > 0.0D) {
               if(var20 * var15 <= var18) {
                  var18 = var15 * var20;
               } else {
                  var20 = var18 / var15;
               }
            } else {
               var15 *= -1.0D;
               double var22 = this.getDomainAxis().getRange().getLength();
               double var24 = this.getRangeAxis().getRange().getLength();
               double var26 = var24 / var22;
               var15 = var26 * var15;
               if(var20 * var15 <= var18) {
                  var18 = var15 * var20;
               } else {
                  var20 = var18 / var15;
               }
            }

            var13.setRect(var17.getX() + var17.getWidth() / 2.0D - var20 / 2.0D, var17.getY(), var20, var18);
         }

         if(var5 != null) {
            var5.setDataArea(var13);
         }

         CrosshairState var29 = new CrosshairState();
         var29.setCrosshairDistance(Double.POSITIVE_INFINITY);
         this.drawBackground(var1, var13);
         double var16 = var13.getMaxY();
         if(this.domainAxis != null) {
            this.domainAxis.draw(var1, var16, var12, var13, RectangleEdge.BOTTOM, var5);
         }

         if(this.rangeAxis != null) {
            var16 = var13.getMinX();
            this.rangeAxis.draw(var1, var16, var12, var13, RectangleEdge.LEFT, var5);
         }

         if(this.colorBar != null) {
            var16 = 0.0D;
            this.colorBar.draw(var1, var16, var12, var13, var14, this.colorBarLocation);
         }

         Shape var30 = var1.getClip();
         Composite var19 = var1.getComposite();
         var1.clip(var13);
         var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
         this.render(var1, var13, var5, var29);
         Marker var21;
         Iterator var28;
         if(this.domainMarkers != null) {
            var28 = this.domainMarkers.iterator();

            while(var28.hasNext()) {
               var21 = (Marker)var28.next();
               this.drawDomainMarker(var1, this, this.getDomainAxis(), var21, var13);
            }
         }

         if(this.rangeMarkers != null) {
            var28 = this.rangeMarkers.iterator();

            while(var28.hasNext()) {
               var21 = (Marker)var28.next();
               this.drawRangeMarker(var1, this, this.getRangeAxis(), var21, var13);
            }
         }

         var1.setClip(var30);
         var1.setComposite(var19);
         this.drawOutline(var1, var13);
      }
   }

   public void render(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, CrosshairState var4) {
      ContourDataset var5 = this.getDataset();
      if(var5 != null) {
         ColorBar var6 = this.getColorBar();
         if(this.clipPath != null) {
            GeneralPath var7 = this.getClipPath().draw(var1, var2, this.domainAxis, this.rangeAxis);
            if(this.clipPath.isClip()) {
               var1.clip(var7);
            }
         }

         if(this.renderAsPoints) {
            this.pointRenderer(var1, var2, var3, this, this.domainAxis, this.rangeAxis, var6, var5, var4);
         } else {
            this.contourRenderer(var1, var2, var3, this, this.domainAxis, this.rangeAxis, var6, var5, var4);
         }

         this.setDomainCrosshairValue(var4.getCrosshairX(), false);
         if(this.isDomainCrosshairVisible()) {
            this.drawVerticalLine(var1, var2, this.getDomainCrosshairValue(), this.getDomainCrosshairStroke(), this.getDomainCrosshairPaint());
         }

         this.setRangeCrosshairValue(var4.getCrosshairY(), false);
         if(this.isRangeCrosshairVisible()) {
            this.drawHorizontalLine(var1, var2, this.getRangeCrosshairValue(), this.getRangeCrosshairStroke(), this.getRangeCrosshairPaint());
         }
      } else if(this.clipPath != null) {
         this.getClipPath().draw(var1, var2, this.domainAxis, this.rangeAxis);
      }

   }

   public void contourRenderer(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, ContourPlot var4, ValueAxis var5, ValueAxis var6, ColorBar var7, ContourDataset var8, CrosshairState var9) {
      Object var10 = null;
      EntityCollection var11 = null;
      if(var3 != null) {
         var11 = var3.getOwner().getEntityCollection();
      }

      java.awt.geom.Rectangle2D.Double var12 = null;
      var12 = new java.awt.geom.Rectangle2D.Double();
      Object var13 = var1.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
      Number[] var14 = var8.getXValues();
      Number[] var15 = var8.getYValues();
      Number[] var16 = var8.getZValues();
      double[] var17 = new double[var14.length];
      double[] var18 = new double[var15.length];

      for(int var19 = 0; var19 < var17.length; ++var19) {
         var17[var19] = var14[var19].doubleValue();
         var18[var19] = var15[var19].doubleValue();
      }

      int[] var53 = var8.indexX();
      int[] var20 = var8.getXIndices();
      boolean var21 = ((NumberAxis)var6).isInverted();
      boolean var22 = false;
      if(var5 instanceof NumberAxis) {
         var22 = ((NumberAxis)var5).isInverted();
      }

      double var23 = 0.0D;
      double var25 = 0.0D;
      double var27 = 0.0D;
      double var29 = 0.0D;
      double var31 = 0.0D;
      double var33 = 0.0D;
      double var35 = 0.0D;
      double var37 = 0.0D;
      double var39 = 0.0D;
      double var41 = 0.0D;
      double var43 = 0.0D;
      double var45 = 0.0D;
      int var47 = var53[var53.length - 1];

      for(int var48 = 0; var48 < var17.length; ++var48) {
         int var49 = var53[var48];
         if(var20[var49] == var48) {
            if(var49 == 0) {
               var23 = var5.valueToJava2D(var17[var48], var2, RectangleEdge.BOTTOM);
               var27 = var5.valueToJava2D(var17[var20[var49 + 1]], var2, RectangleEdge.BOTTOM);
               var29 = Math.abs(0.5D * (var23 - var23));
               var31 = Math.abs(0.5D * (var23 - var27));
            } else if(var49 == var47) {
               var23 = var5.valueToJava2D(var17[var48], var2, RectangleEdge.BOTTOM);
               var25 = var5.valueToJava2D(var17[var20[var49 - 1]], var2, RectangleEdge.BOTTOM);
               var29 = Math.abs(0.5D * (var23 - var25));
               var31 = Math.abs(0.5D * (var23 - var23));
            } else {
               var23 = var5.valueToJava2D(var17[var48], var2, RectangleEdge.BOTTOM);
               var27 = var5.valueToJava2D(var17[var20[var49 + 1]], var2, RectangleEdge.BOTTOM);
               var29 = var31;
               var31 = Math.abs(0.5D * (var23 - var27));
            }

            if(var22) {
               var23 -= var31;
            } else {
               var23 -= var29;
            }

            var33 = var29 + var31;
            var35 = var6.valueToJava2D(var18[var48], var2, RectangleEdge.LEFT);
            if(var48 + 1 == var18.length) {
               continue;
            }

            var39 = var6.valueToJava2D(var18[var48 + 1], var2, RectangleEdge.LEFT);
            var41 = Math.abs(0.5D * (var35 - var35));
            var43 = Math.abs(0.5D * (var35 - var39));
         } else if((var49 >= var20.length - 1 || var20[var49 + 1] - 1 != var48) && var48 != var17.length - 1) {
            var35 = var6.valueToJava2D(var18[var48], var2, RectangleEdge.LEFT);
            var39 = var6.valueToJava2D(var18[var48 + 1], var2, RectangleEdge.LEFT);
            var41 = var43;
            var43 = Math.abs(0.5D * (var35 - var39));
         } else {
            var35 = var6.valueToJava2D(var18[var48], var2, RectangleEdge.LEFT);
            var37 = var6.valueToJava2D(var18[var48 - 1], var2, RectangleEdge.LEFT);
            var41 = Math.abs(0.5D * (var35 - var37));
            var43 = Math.abs(0.5D * (var35 - var35));
         }

         if(var21) {
            var35 -= var41;
         } else {
            var35 -= var43;
         }

         var45 = var41 + var43;
         var12.setRect(var23, var35, var33, var45);
         if(var16[var48] != null) {
            var1.setPaint(var7.getPaint(var16[var48].doubleValue()));
            var1.fill(var12);
         } else if(this.missingPaint != null) {
            var1.setPaint(this.missingPaint);
            var1.fill(var12);
         }

         if(var11 != null) {
            String var50 = "";
            if(this.getToolTipGenerator() != null) {
               var50 = this.toolTipGenerator.generateToolTip(var8, var48);
            }

            Object var51 = null;
            ContourEntity var52 = new ContourEntity((java.awt.geom.Rectangle2D.Double)var12.clone(), var50, (String)var51);
            var52.setIndex(var48);
            var11.add(var52);
         }

         if(var4.isDomainCrosshairLockedOnData()) {
            if(var4.isRangeCrosshairLockedOnData()) {
               var9.updateCrosshairPoint(var17[var48], var18[var48], var23, var35, PlotOrientation.VERTICAL);
            } else {
               var9.updateCrosshairX(var23);
            }
         } else if(var4.isRangeCrosshairLockedOnData()) {
            var9.updateCrosshairY(var35);
         }
      }

      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, var13);
   }

   public void pointRenderer(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, ContourPlot var4, ValueAxis var5, ValueAxis var6, ColorBar var7, ContourDataset var8, CrosshairState var9) {
      Object var10 = null;
      EntityCollection var11 = null;
      if(var3 != null) {
         var11 = var3.getOwner().getEntityCollection();
      }

      java.awt.geom.Ellipse2D.Double var12 = new java.awt.geom.Ellipse2D.Double();
      Object var13 = var1.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
      Number[] var14 = var8.getXValues();
      Number[] var15 = var8.getYValues();
      Number[] var16 = var8.getZValues();
      double[] var17 = new double[var14.length];
      double[] var18 = new double[var15.length];

      for(int var19 = 0; var19 < var17.length; ++var19) {
         var17[var19] = var14[var19].doubleValue();
         var18[var19] = var15[var19].doubleValue();
      }

      double var33 = 0.0D;
      double var21 = 0.0D;
      double var23 = 0.0D;
      double var25 = 0.0D;
      double var27 = var2.getWidth() * this.ptSizePct;

      for(int var29 = 0; var29 < var17.length; ++var29) {
         var33 = var5.valueToJava2D(var17[var29], var2, RectangleEdge.BOTTOM) - 0.5D * var27;
         var23 = var6.valueToJava2D(var18[var29], var2, RectangleEdge.LEFT) - 0.5D * var27;
         var12.setFrame(var33, var23, var27, var27);
         if(var16[var29] != null) {
            var1.setPaint(var7.getPaint(var16[var29].doubleValue()));
            var1.fill(var12);
         } else if(this.missingPaint != null) {
            var1.setPaint(this.missingPaint);
            var1.fill(var12);
         }

         if(var11 != null) {
            String var30 = null;
            if(this.getToolTipGenerator() != null) {
               var30 = this.toolTipGenerator.generateToolTip(var8, var29);
            }

            Object var31 = null;
            ContourEntity var32 = new ContourEntity((RectangularShape)var12.clone(), var30, (String)var31);
            var32.setIndex(var29);
            var11.add(var32);
         }

         if(var4.isDomainCrosshairLockedOnData()) {
            if(var4.isRangeCrosshairLockedOnData()) {
               var9.updateCrosshairPoint(var17[var29], var18[var29], var33, var23, PlotOrientation.VERTICAL);
            } else {
               var9.updateCrosshairX(var33);
            }
         } else if(var4.isRangeCrosshairLockedOnData()) {
            var9.updateCrosshairY(var23);
         }
      }

      var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, var13);
   }

   protected void drawVerticalLine(Graphics2D var1, Rectangle2D var2, double var3, Stroke var5, Paint var6) {
      double var7 = this.getDomainAxis().valueToJava2D(var3, var2, RectangleEdge.BOTTOM);
      java.awt.geom.Line2D.Double var9 = new java.awt.geom.Line2D.Double(var7, var2.getMinY(), var7, var2.getMaxY());
      var1.setStroke(var5);
      var1.setPaint(var6);
      var1.draw(var9);
   }

   protected void drawHorizontalLine(Graphics2D var1, Rectangle2D var2, double var3, Stroke var5, Paint var6) {
      double var7 = this.getRangeAxis().valueToJava2D(var3, var2, RectangleEdge.LEFT);
      java.awt.geom.Line2D.Double var9 = new java.awt.geom.Line2D.Double(var2.getMinX(), var7, var2.getMaxX(), var7);
      var1.setStroke(var5);
      var1.setPaint(var6);
      var1.draw(var9);
   }

   public void handleClick(int var1, int var2, PlotRenderingInfo var3) {
   }

   public void zoom(double var1) {
      if(var1 <= 0.0D) {
         this.getRangeAxis().setAutoRange(true);
         this.getDomainAxis().setAutoRange(true);
      }

   }

   public String getPlotType() {
      return localizationResources.getString("Contour_Plot");
   }

   public Range getDataRange(ValueAxis var1) {
      if(this.dataset == null) {
         return null;
      } else {
         Range var2 = null;
         if(var1 == this.getDomainAxis()) {
            var2 = DatasetUtilities.findDomainBounds(this.dataset);
         } else if(var1 == this.getRangeAxis()) {
            var2 = DatasetUtilities.findRangeBounds((XYDataset)this.dataset);
         }

         return var2;
      }
   }

   public Range getContourDataRange() {
      Range var1 = null;
      ContourDataset var2 = this.getDataset();
      if(var2 != null) {
         Range var3 = this.getDomainAxis().getRange();
         Range var4 = this.getRangeAxis().getRange();
         var1 = this.visibleRange(var2, var3, var4);
      }

      return var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      if(this.domainAxis != null) {
         this.domainAxis.configure();
      }

      if(this.rangeAxis != null) {
         this.rangeAxis.configure();
      }

      if(this.colorBar != null) {
         this.colorBar.configure(this);
      }

      super.datasetChanged(var1);
   }

   public ColorBar getColorBar() {
      return this.colorBar;
   }

   public boolean isDomainCrosshairVisible() {
      return this.domainCrosshairVisible;
   }

   public void setDomainCrosshairVisible(boolean var1) {
      if(this.domainCrosshairVisible != var1) {
         this.domainCrosshairVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean isDomainCrosshairLockedOnData() {
      return this.domainCrosshairLockedOnData;
   }

   public void setDomainCrosshairLockedOnData(boolean var1) {
      if(this.domainCrosshairLockedOnData != var1) {
         this.domainCrosshairLockedOnData = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public double getDomainCrosshairValue() {
      return this.domainCrosshairValue;
   }

   public void setDomainCrosshairValue(double var1) {
      this.setDomainCrosshairValue(var1, true);
   }

   public void setDomainCrosshairValue(double var1, boolean var3) {
      this.domainCrosshairValue = var1;
      if(this.isDomainCrosshairVisible() && var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getDomainCrosshairStroke() {
      return this.domainCrosshairStroke;
   }

   public void setDomainCrosshairStroke(Stroke var1) {
      this.domainCrosshairStroke = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getDomainCrosshairPaint() {
      return this.domainCrosshairPaint;
   }

   public void setDomainCrosshairPaint(Paint var1) {
      this.domainCrosshairPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean isRangeCrosshairVisible() {
      return this.rangeCrosshairVisible;
   }

   public void setRangeCrosshairVisible(boolean var1) {
      if(this.rangeCrosshairVisible != var1) {
         this.rangeCrosshairVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean isRangeCrosshairLockedOnData() {
      return this.rangeCrosshairLockedOnData;
   }

   public void setRangeCrosshairLockedOnData(boolean var1) {
      if(this.rangeCrosshairLockedOnData != var1) {
         this.rangeCrosshairLockedOnData = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public double getRangeCrosshairValue() {
      return this.rangeCrosshairValue;
   }

   public void setRangeCrosshairValue(double var1) {
      this.setRangeCrosshairValue(var1, true);
   }

   public void setRangeCrosshairValue(double var1, boolean var3) {
      this.rangeCrosshairValue = var1;
      if(this.isRangeCrosshairVisible() && var3) {
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getRangeCrosshairStroke() {
      return this.rangeCrosshairStroke;
   }

   public void setRangeCrosshairStroke(Stroke var1) {
      this.rangeCrosshairStroke = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getRangeCrosshairPaint() {
      return this.rangeCrosshairPaint;
   }

   public void setRangeCrosshairPaint(Paint var1) {
      this.rangeCrosshairPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public ContourToolTipGenerator getToolTipGenerator() {
      return this.toolTipGenerator;
   }

   public void setToolTipGenerator(ContourToolTipGenerator var1) {
      this.toolTipGenerator = var1;
   }

   public XYURLGenerator getURLGenerator() {
      return this.urlGenerator;
   }

   public void setURLGenerator(XYURLGenerator var1) {
      this.urlGenerator = var1;
   }

   public void drawDomainMarker(Graphics2D var1, ContourPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5) {
      if(var4 instanceof ValueMarker) {
         ValueMarker var6 = (ValueMarker)var4;
         double var7 = var6.getValue();
         Range var9 = var3.getRange();
         if(!var9.contains(var7)) {
            return;
         }

         double var10 = var3.valueToJava2D(var7, var5, RectangleEdge.BOTTOM);
         java.awt.geom.Line2D.Double var12 = new java.awt.geom.Line2D.Double(var10, var5.getMinY(), var10, var5.getMaxY());
         Paint var13 = var4.getOutlinePaint();
         Stroke var14 = var4.getOutlineStroke();
         var1.setPaint(var13 != null?var13:Plot.DEFAULT_OUTLINE_PAINT);
         var1.setStroke(var14 != null?var14:Plot.DEFAULT_OUTLINE_STROKE);
         var1.draw(var12);
      }

   }

   public void drawRangeMarker(Graphics2D var1, ContourPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5) {
      if(var4 instanceof ValueMarker) {
         ValueMarker var6 = (ValueMarker)var4;
         double var7 = var6.getValue();
         Range var9 = var3.getRange();
         if(!var9.contains(var7)) {
            return;
         }

         double var10 = var3.valueToJava2D(var7, var5, RectangleEdge.LEFT);
         java.awt.geom.Line2D.Double var12 = new java.awt.geom.Line2D.Double(var5.getMinX(), var10, var5.getMaxX(), var10);
         Paint var13 = var4.getOutlinePaint();
         Stroke var14 = var4.getOutlineStroke();
         var1.setPaint(var13 != null?var13:Plot.DEFAULT_OUTLINE_PAINT);
         var1.setStroke(var14 != null?var14:Plot.DEFAULT_OUTLINE_STROKE);
         var1.draw(var12);
      }

   }

   public ClipPath getClipPath() {
      return this.clipPath;
   }

   public void setClipPath(ClipPath var1) {
      this.clipPath = var1;
   }

   public double getPtSizePct() {
      return this.ptSizePct;
   }

   public boolean isRenderAsPoints() {
      return this.renderAsPoints;
   }

   public void setPtSizePct(double var1) {
      this.ptSizePct = var1;
   }

   public void setRenderAsPoints(boolean var1) {
      this.renderAsPoints = var1;
   }

   public void axisChanged(AxisChangeEvent var1) {
      Object var2 = var1.getSource();
      if(var2.equals(this.rangeAxis) || var2.equals(this.domainAxis)) {
         ColorBar var3 = this.colorBar;
         if(this.colorBar.getAxis().isAutoRange()) {
            var3.getAxis().configure();
         }
      }

      super.axisChanged(var1);
   }

   public Range visibleRange(ContourDataset var1, Range var2, Range var3) {
      Range var4 = null;
      var4 = var1.getZValueRange(var2, var3);
      return var4;
   }

   public Paint getMissingPaint() {
      return this.missingPaint;
   }

   public void setMissingPaint(Paint var1) {
      this.missingPaint = var1;
   }

   public void zoomDomainAxes(double var1, double var3, double var5) {
   }

   public void zoomDomainAxes(double var1, double var3, double var5, double var7) {
   }

   public void zoomRangeAxes(double var1, double var3, double var5) {
   }

   public void zoomRangeAxes(double var1, double var3, double var5, double var7) {
   }

   public boolean isDomainZoomable() {
      return false;
   }

   public boolean isRangeZoomable() {
      return false;
   }

   public Object clone() {
      ContourPlot var1 = (ContourPlot)super.clone();
      if(this.domainAxis != null) {
         var1.domainAxis = (ValueAxis)this.domainAxis.clone();
         var1.domainAxis.setPlot(var1);
         var1.domainAxis.addChangeListener(var1);
      }

      if(this.rangeAxis != null) {
         var1.rangeAxis = (ValueAxis)this.rangeAxis.clone();
         var1.rangeAxis.setPlot(var1);
         var1.rangeAxis.addChangeListener(var1);
      }

      if(var1.dataset != null) {
         var1.dataset.addChangeListener(var1);
      }

      if(this.colorBar != null) {
         var1.colorBar = (ColorBar)this.colorBar.clone();
      }

      var1.domainMarkers = (List)ObjectUtilities.deepClone(this.domainMarkers);
      var1.rangeMarkers = (List)ObjectUtilities.deepClone(this.rangeMarkers);
      var1.annotations = (List)ObjectUtilities.deepClone(this.annotations);
      if(this.clipPath != null) {
         var1.clipPath = (ClipPath)this.clipPath.clone();
      }

      return var1;
   }
}
