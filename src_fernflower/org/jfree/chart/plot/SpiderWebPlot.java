package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintList;
import org.jfree.util.PaintUtilities;
import org.jfree.util.Rotation;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.StrokeList;
import org.jfree.util.TableOrder;

public class SpiderWebPlot extends Plot implements Serializable, Cloneable {
   private static final long serialVersionUID = -5376340422031599463L;
   public static final double DEFAULT_HEAD = 0.01D;
   public static final double DEFAULT_AXIS_LABEL_GAP = 0.1D;
   public static final double DEFAULT_INTERIOR_GAP = 0.25D;
   public static final double MAX_INTERIOR_GAP = 0.4D;
   public static final double DEFAULT_START_ANGLE = 90.0D;
   public static final Font DEFAULT_LABEL_FONT = new Font("SansSerif", 0, 10);
   public static final Paint DEFAULT_LABEL_PAINT;
   public static final Paint DEFAULT_LABEL_BACKGROUND_PAINT;
   public static final Paint DEFAULT_LABEL_OUTLINE_PAINT;
   public static final Stroke DEFAULT_LABEL_OUTLINE_STROKE;
   public static final Paint DEFAULT_LABEL_SHADOW_PAINT;
   public static final double DEFAULT_MAX_VALUE = -1.0D;
   protected double headPercent;
   private double interiorGap;
   private double axisLabelGap;
   private transient Paint axisLinePaint;
   private transient Stroke axisLineStroke;
   private CategoryDataset dataset;
   private double maxValue;
   private TableOrder dataExtractOrder;
   private double startAngle;
   private Rotation direction;
   private transient Shape legendItemShape;
   private transient Paint seriesPaint;
   private PaintList seriesPaintList;
   private transient Paint baseSeriesPaint;
   private transient Paint seriesOutlinePaint;
   private PaintList seriesOutlinePaintList;
   private transient Paint baseSeriesOutlinePaint;
   private transient Stroke seriesOutlineStroke;
   private StrokeList seriesOutlineStrokeList;
   private transient Stroke baseSeriesOutlineStroke;
   private Font labelFont;
   private transient Paint labelPaint;
   private CategoryItemLabelGenerator labelGenerator;
   private boolean webFilled;
   private CategoryToolTipGenerator toolTipGenerator;
   private CategoryURLGenerator urlGenerator;

   public SpiderWebPlot() {
      this((CategoryDataset)null);
   }

   public SpiderWebPlot(CategoryDataset var1) {
      this(var1, TableOrder.BY_ROW);
   }

   public SpiderWebPlot(CategoryDataset var1, TableOrder var2) {
      this.webFilled = true;
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'extract\' argument.");
      } else {
         this.dataset = var1;
         if(var1 != null) {
            var1.addChangeListener(this);
         }

         this.dataExtractOrder = var2;
         this.headPercent = 0.01D;
         this.axisLabelGap = 0.1D;
         this.axisLinePaint = Color.black;
         this.axisLineStroke = new BasicStroke(1.0F);
         this.interiorGap = 0.25D;
         this.startAngle = 90.0D;
         this.direction = Rotation.CLOCKWISE;
         this.maxValue = -1.0D;
         this.seriesPaint = null;
         this.seriesPaintList = new PaintList();
         this.baseSeriesPaint = null;
         this.seriesOutlinePaint = null;
         this.seriesOutlinePaintList = new PaintList();
         this.baseSeriesOutlinePaint = DEFAULT_OUTLINE_PAINT;
         this.seriesOutlineStroke = null;
         this.seriesOutlineStrokeList = new StrokeList();
         this.baseSeriesOutlineStroke = DEFAULT_OUTLINE_STROKE;
         this.labelFont = DEFAULT_LABEL_FONT;
         this.labelPaint = DEFAULT_LABEL_PAINT;
         this.labelGenerator = new StandardCategoryItemLabelGenerator();
         this.legendItemShape = DEFAULT_LEGEND_ITEM_CIRCLE;
      }
   }

   public String getPlotType() {
      return "Spider Web Plot";
   }

   public CategoryDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(CategoryDataset var1) {
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

   public boolean isWebFilled() {
      return this.webFilled;
   }

   public void setWebFilled(boolean var1) {
      this.webFilled = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public TableOrder getDataExtractOrder() {
      return this.dataExtractOrder;
   }

   public void setDataExtractOrder(TableOrder var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'order\' argument");
      } else {
         this.dataExtractOrder = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public double getHeadPercent() {
      return this.headPercent;
   }

   public void setHeadPercent(double var1) {
      this.headPercent = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getStartAngle() {
      return this.startAngle;
   }

   public void setStartAngle(double var1) {
      this.startAngle = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public double getMaxValue() {
      return this.maxValue;
   }

   public void setMaxValue(double var1) {
      this.maxValue = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Rotation getDirection() {
      return this.direction;
   }

   public void setDirection(Rotation var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'direction\' argument.");
      } else {
         this.direction = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public double getInteriorGap() {
      return this.interiorGap;
   }

   public void setInteriorGap(double var1) {
      if(var1 >= 0.0D && var1 <= 0.4D) {
         if(this.interiorGap != var1) {
            this.interiorGap = var1;
            this.notifyListeners(new PlotChangeEvent(this));
         }

      } else {
         throw new IllegalArgumentException("Percentage outside valid range.");
      }
   }

   public double getAxisLabelGap() {
      return this.axisLabelGap;
   }

   public void setAxisLabelGap(double var1) {
      this.axisLabelGap = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getAxisLinePaint() {
      return this.axisLinePaint;
   }

   public void setAxisLinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.axisLinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Stroke getAxisLineStroke() {
      return this.axisLineStroke;
   }

   public void setAxisLineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.axisLineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getSeriesPaint() {
      return this.seriesPaint;
   }

   public void setSeriesPaint(Paint var1) {
      this.seriesPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getSeriesPaint(int var1) {
      if(this.seriesPaint != null) {
         return this.seriesPaint;
      } else {
         Paint var2 = this.seriesPaintList.getPaint(var1);
         if(var2 == null) {
            DrawingSupplier var3 = this.getDrawingSupplier();
            if(var3 != null) {
               Paint var4 = var3.getNextPaint();
               this.seriesPaintList.setPaint(var1, var4);
               var2 = var4;
            } else {
               var2 = this.baseSeriesPaint;
            }
         }

         return var2;
      }
   }

   public void setSeriesPaint(int var1, Paint var2) {
      this.seriesPaintList.setPaint(var1, var2);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getBaseSeriesPaint() {
      return this.baseSeriesPaint;
   }

   public void setBaseSeriesPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.baseSeriesPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getSeriesOutlinePaint() {
      return this.seriesOutlinePaint;
   }

   public void setSeriesOutlinePaint(Paint var1) {
      this.seriesOutlinePaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getSeriesOutlinePaint(int var1) {
      if(this.seriesOutlinePaint != null) {
         return this.seriesOutlinePaint;
      } else {
         Paint var2 = this.seriesOutlinePaintList.getPaint(var1);
         if(var2 == null) {
            var2 = this.baseSeriesOutlinePaint;
         }

         return var2;
      }
   }

   public void setSeriesOutlinePaint(int var1, Paint var2) {
      this.seriesOutlinePaintList.setPaint(var1, var2);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getBaseSeriesOutlinePaint() {
      return this.baseSeriesOutlinePaint;
   }

   public void setBaseSeriesOutlinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.baseSeriesOutlinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Stroke getSeriesOutlineStroke() {
      return this.seriesOutlineStroke;
   }

   public void setSeriesOutlineStroke(Stroke var1) {
      this.seriesOutlineStroke = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getSeriesOutlineStroke(int var1) {
      if(this.seriesOutlineStroke != null) {
         return this.seriesOutlineStroke;
      } else {
         Stroke var2 = this.seriesOutlineStrokeList.getStroke(var1);
         if(var2 == null) {
            var2 = this.baseSeriesOutlineStroke;
         }

         return var2;
      }
   }

   public void setSeriesOutlineStroke(int var1, Stroke var2) {
      this.seriesOutlineStrokeList.setStroke(var1, var2);
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getBaseSeriesOutlineStroke() {
      return this.baseSeriesOutlineStroke;
   }

   public void setBaseSeriesOutlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.baseSeriesOutlineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Shape getLegendItemShape() {
      return this.legendItemShape;
   }

   public void setLegendItemShape(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else {
         this.legendItemShape = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Font getLabelFont() {
      return this.labelFont;
   }

   public void setLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.labelFont = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getLabelPaint() {
      return this.labelPaint;
   }

   public void setLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.labelPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public CategoryItemLabelGenerator getLabelGenerator() {
      return this.labelGenerator;
   }

   public void setLabelGenerator(CategoryItemLabelGenerator var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'generator\' argument.");
      } else {
         this.labelGenerator = var1;
      }
   }

   public CategoryToolTipGenerator getToolTipGenerator() {
      return this.toolTipGenerator;
   }

   public void setToolTipGenerator(CategoryToolTipGenerator var1) {
      this.toolTipGenerator = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public CategoryURLGenerator getURLGenerator() {
      return this.urlGenerator;
   }

   public void setURLGenerator(CategoryURLGenerator var1) {
      this.urlGenerator = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public LegendItemCollection getLegendItems() {
      LegendItemCollection var1 = new LegendItemCollection();
      List var2 = null;
      if(this.dataExtractOrder == TableOrder.BY_ROW) {
         var2 = this.dataset.getRowKeys();
      } else if(this.dataExtractOrder == TableOrder.BY_COLUMN) {
         var2 = this.dataset.getColumnKeys();
      }

      if(var2 != null) {
         int var3 = 0;
         Iterator var4 = var2.iterator();

         for(Shape var5 = this.getLegendItemShape(); var4.hasNext(); ++var3) {
            String var6 = var4.next().toString();
            Paint var8 = this.getSeriesPaint(var3);
            Paint var9 = this.getSeriesOutlinePaint(var3);
            Stroke var10 = this.getSeriesOutlineStroke(var3);
            LegendItem var11 = new LegendItem(var6, var6, (String)null, (String)null, var5, var8, var10, var9);
            var1.add(var11);
         }
      }

      return var1;
   }

   protected Point2D getWebPoint(Rectangle2D var1, double var2, double var4) {
      double var6 = Math.toRadians(var2);
      double var8 = Math.cos(var6) * var4 * var1.getWidth() / 2.0D;
      double var10 = -Math.sin(var6) * var4 * var1.getHeight() / 2.0D;
      return new Double(var1.getX() + var8 + var1.getWidth() / 2.0D, var1.getY() + var10 + var1.getHeight() / 2.0D);
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      RectangleInsets var6 = this.getInsets();
      var6.trim(var2);
      if(var5 != null) {
         var5.setPlotArea(var2);
         var5.setDataArea(var2);
      }

      this.drawBackground(var1, var2);
      this.drawOutline(var1, var2);
      Shape var7 = var1.getClip();
      var1.clip(var2);
      Composite var8 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
      if(!DatasetUtilities.isEmptyOrNull(this.dataset)) {
         boolean var9 = false;
         boolean var10 = false;
         int var36;
         int var37;
         if(this.dataExtractOrder == TableOrder.BY_ROW) {
            var36 = this.dataset.getRowCount();
            var37 = this.dataset.getColumnCount();
         } else {
            var36 = this.dataset.getColumnCount();
            var37 = this.dataset.getRowCount();
         }

         if(this.maxValue == -1.0D) {
            this.calculateMaxValue(var36, var37);
         }

         double var11 = var2.getWidth() * this.getInteriorGap();
         double var13 = var2.getHeight() * this.getInteriorGap();
         double var15 = var2.getX() + var11 / 2.0D;
         double var17 = var2.getY() + var13 / 2.0D;
         double var19 = var2.getWidth() - var11;
         double var21 = var2.getHeight() - var13;
         double var23 = var2.getWidth() * this.headPercent;
         double var25 = var2.getHeight() * this.headPercent;
         double var27 = Math.min(var19, var21) / 2.0D;
         var15 = (var15 + var15 + var19) / 2.0D - var27;
         var17 = (var17 + var17 + var21) / 2.0D - var27;
         var19 = 2.0D * var27;
         var21 = 2.0D * var27;
         Double var29 = new Double(var15 + var19 / 2.0D, var17 + var21 / 2.0D);
         java.awt.geom.Rectangle2D.Double var30 = new java.awt.geom.Rectangle2D.Double(var15, var17, var19, var21);

         int var31;
         for(var31 = 0; var31 < var37; ++var31) {
            double var32 = this.getStartAngle() + this.getDirection().getFactor() * (double)var31 * 360.0D / (double)var37;
            Point2D var34 = this.getWebPoint(var30, var32, 1.0D);
            java.awt.geom.Line2D.Double var35 = new java.awt.geom.Line2D.Double(var29, var34);
            var1.setPaint(this.axisLinePaint);
            var1.setStroke(this.axisLineStroke);
            var1.draw(var35);
            this.drawLabel(var1, var30, 0.0D, var31, var32, 360.0D / (double)var37);
         }

         for(var31 = 0; var31 < var36; ++var31) {
            this.drawRadarPoly(var1, var30, var29, var5, var31, var37, var25, var23);
         }
      } else {
         this.drawNoDataMessage(var1, var2);
      }

      var1.setClip(var7);
      var1.setComposite(var8);
      this.drawOutline(var1, var2);
   }

   private void calculateMaxValue(int var1, int var2) {
      double var3 = 0.0D;
      Number var5 = null;

      for(int var6 = 0; var6 < var1; ++var6) {
         for(int var7 = 0; var7 < var2; ++var7) {
            var5 = this.getPlotValue(var6, var7);
            if(var5 != null) {
               var3 = var5.doubleValue();
               if(var3 > this.maxValue) {
                  this.maxValue = var3;
               }
            }
         }
      }

   }

   protected void drawRadarPoly(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotRenderingInfo var4, int var5, int var6, double var7, double var9) {
      Polygon var11 = new Polygon();
      EntityCollection var12 = null;
      if(var4 != null) {
         var12 = var4.getOwner().getEntityCollection();
      }

      for(int var13 = 0; var13 < var6; ++var13) {
         Number var14 = this.getPlotValue(var5, var13);
         if(var14 != null) {
            double var15 = var14.doubleValue();
            if(var15 >= 0.0D) {
               double var17 = this.getStartAngle() + this.getDirection().getFactor() * (double)var13 * 360.0D / (double)var6;
               Point2D var19 = this.getWebPoint(var2, var17, var15 / this.maxValue);
               var11.addPoint((int)var19.getX(), (int)var19.getY());
               Paint var20 = this.getSeriesPaint(var5);
               Paint var21 = this.getSeriesOutlinePaint(var5);
               Stroke var22 = this.getSeriesOutlineStroke(var5);
               java.awt.geom.Ellipse2D.Double var23 = new java.awt.geom.Ellipse2D.Double(var19.getX() - var9 / 2.0D, var19.getY() - var7 / 2.0D, var9, var7);
               var1.setPaint(var20);
               var1.fill(var23);
               var1.setStroke(var22);
               var1.setPaint(var21);
               var1.draw(var23);
               if(var12 != null) {
                  String var24 = null;
                  if(this.toolTipGenerator != null) {
                     var24 = this.toolTipGenerator.generateToolTip(this.dataset, var5, var13);
                  }

                  String var25 = null;
                  if(this.urlGenerator != null) {
                     var25 = this.urlGenerator.generateURL(this.dataset, var5, var13);
                  }

                  Rectangle var26 = new Rectangle((int)(var19.getX() - var9), (int)(var19.getY() - var7), (int)(var9 * 2.0D), (int)(var7 * 2.0D));
                  CategoryItemEntity var27 = new CategoryItemEntity(var26, var24, var25, this.dataset, var5, this.dataset.getColumnKey(var13), var13);
                  var12.add(var27);
               }
            }
         }
      }

      Paint var28 = this.getSeriesPaint(var5);
      var1.setPaint(var28);
      var1.setStroke(this.getSeriesOutlineStroke(var5));
      var1.draw(var11);
      if(this.webFilled) {
         var1.setComposite(AlphaComposite.getInstance(3, 0.1F));
         var1.fill(var11);
         var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
      }

   }

   protected Number getPlotValue(int var1, int var2) {
      Number var3 = null;
      if(this.dataExtractOrder == TableOrder.BY_ROW) {
         var3 = this.dataset.getValue(var1, var2);
      } else if(this.dataExtractOrder == TableOrder.BY_COLUMN) {
         var3 = this.dataset.getValue(var2, var1);
      }

      return var3;
   }

   protected void drawLabel(Graphics2D var1, Rectangle2D var2, double var3, int var5, double var6, double var8) {
      FontRenderContext var10 = var1.getFontRenderContext();
      String var11 = null;
      if(this.dataExtractOrder == TableOrder.BY_ROW) {
         var11 = this.labelGenerator.generateColumnLabel(this.dataset, var5);
      } else {
         var11 = this.labelGenerator.generateRowLabel(this.dataset, var5);
      }

      Rectangle2D var12 = this.getLabelFont().getStringBounds(var11, var10);
      LineMetrics var13 = this.getLabelFont().getLineMetrics(var11, var10);
      double var14 = (double)var13.getAscent();
      Point2D var16 = this.calculateLabelLocation(var12, var14, var2, var6);
      Composite var17 = var1.getComposite();
      var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
      var1.setPaint(this.getLabelPaint());
      var1.setFont(this.getLabelFont());
      var1.drawString(var11, (float)var16.getX(), (float)var16.getY());
      var1.setComposite(var17);
   }

   protected Point2D calculateLabelLocation(Rectangle2D var1, double var2, Rectangle2D var4, double var5) {
      java.awt.geom.Arc2D.Double var7 = new java.awt.geom.Arc2D.Double(var4, var5, 0.0D, 0);
      Point2D var8 = var7.getEndPoint();
      double var9 = -(var8.getX() - var4.getCenterX()) * this.axisLabelGap;
      double var11 = -(var8.getY() - var4.getCenterY()) * this.axisLabelGap;
      double var13 = var8.getX() - var9;
      double var15 = var8.getY() - var11;
      if(var13 < var4.getCenterX()) {
         var13 -= var1.getWidth();
      }

      if(var13 == var4.getCenterX()) {
         var13 -= var1.getWidth() / 2.0D;
      }

      if(var15 > var4.getCenterY()) {
         var15 += var2;
      }

      return new Double(var13, var15);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof SpiderWebPlot)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         SpiderWebPlot var2 = (SpiderWebPlot)var1;
         return !this.dataExtractOrder.equals(var2.dataExtractOrder)?false:(this.headPercent != var2.headPercent?false:(this.interiorGap != var2.interiorGap?false:(this.startAngle != var2.startAngle?false:(!this.direction.equals(var2.direction)?false:(this.maxValue != var2.maxValue?false:(this.webFilled != var2.webFilled?false:(this.axisLabelGap != var2.axisLabelGap?false:(!PaintUtilities.equal(this.axisLinePaint, var2.axisLinePaint)?false:(!this.axisLineStroke.equals(var2.axisLineStroke)?false:(!ShapeUtilities.equal(this.legendItemShape, var2.legendItemShape)?false:(!PaintUtilities.equal(this.seriesPaint, var2.seriesPaint)?false:(!this.seriesPaintList.equals(var2.seriesPaintList)?false:(!PaintUtilities.equal(this.baseSeriesPaint, var2.baseSeriesPaint)?false:(!PaintUtilities.equal(this.seriesOutlinePaint, var2.seriesOutlinePaint)?false:(!this.seriesOutlinePaintList.equals(var2.seriesOutlinePaintList)?false:(!PaintUtilities.equal(this.baseSeriesOutlinePaint, var2.baseSeriesOutlinePaint)?false:(!ObjectUtilities.equal(this.seriesOutlineStroke, var2.seriesOutlineStroke)?false:(!this.seriesOutlineStrokeList.equals(var2.seriesOutlineStrokeList)?false:(!this.baseSeriesOutlineStroke.equals(var2.baseSeriesOutlineStroke)?false:(!this.labelFont.equals(var2.labelFont)?false:(!PaintUtilities.equal(this.labelPaint, var2.labelPaint)?false:(!this.labelGenerator.equals(var2.labelGenerator)?false:(!ObjectUtilities.equal(this.toolTipGenerator, var2.toolTipGenerator)?false:ObjectUtilities.equal(this.urlGenerator, var2.urlGenerator))))))))))))))))))))))));
      }
   }

   public Object clone() {
      SpiderWebPlot var1 = (SpiderWebPlot)super.clone();
      var1.legendItemShape = ShapeUtilities.clone(this.legendItemShape);
      var1.seriesPaintList = (PaintList)this.seriesPaintList.clone();
      var1.seriesOutlinePaintList = (PaintList)this.seriesOutlinePaintList.clone();
      var1.seriesOutlineStrokeList = (StrokeList)this.seriesOutlineStrokeList.clone();
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.legendItemShape, var1);
      SerialUtilities.writePaint(this.seriesPaint, var1);
      SerialUtilities.writePaint(this.baseSeriesPaint, var1);
      SerialUtilities.writePaint(this.seriesOutlinePaint, var1);
      SerialUtilities.writePaint(this.baseSeriesOutlinePaint, var1);
      SerialUtilities.writeStroke(this.seriesOutlineStroke, var1);
      SerialUtilities.writeStroke(this.baseSeriesOutlineStroke, var1);
      SerialUtilities.writePaint(this.labelPaint, var1);
      SerialUtilities.writePaint(this.axisLinePaint, var1);
      SerialUtilities.writeStroke(this.axisLineStroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.legendItemShape = SerialUtilities.readShape(var1);
      this.seriesPaint = SerialUtilities.readPaint(var1);
      this.baseSeriesPaint = SerialUtilities.readPaint(var1);
      this.seriesOutlinePaint = SerialUtilities.readPaint(var1);
      this.baseSeriesOutlinePaint = SerialUtilities.readPaint(var1);
      this.seriesOutlineStroke = SerialUtilities.readStroke(var1);
      this.baseSeriesOutlineStroke = SerialUtilities.readStroke(var1);
      this.labelPaint = SerialUtilities.readPaint(var1);
      this.axisLinePaint = SerialUtilities.readPaint(var1);
      this.axisLineStroke = SerialUtilities.readStroke(var1);
      if(this.dataset != null) {
         this.dataset.addChangeListener(this);
      }

   }

   static {
      DEFAULT_LABEL_PAINT = Color.black;
      DEFAULT_LABEL_BACKGROUND_PAINT = new Color(255, 255, 192);
      DEFAULT_LABEL_OUTLINE_PAINT = Color.black;
      DEFAULT_LABEL_OUTLINE_STROKE = new BasicStroke(0.5F);
      DEFAULT_LABEL_SHADOW_PAINT = Color.lightGray;
   }
}
