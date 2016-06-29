package org.jfree.chart.renderer.category;

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
import java.awt.geom.Line2D.Double;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.GradientPaintTransformer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectList;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public abstract class AbstractCategoryItemRenderer extends AbstractRenderer implements Serializable, Cloneable, CategoryItemRenderer, PublicCloneable {
   private static final long serialVersionUID = 1247553218442497391L;
   private CategoryPlot plot;
   private CategoryItemLabelGenerator itemLabelGenerator = null;
   private ObjectList itemLabelGeneratorList = new ObjectList();
   private CategoryItemLabelGenerator baseItemLabelGenerator;
   private CategoryToolTipGenerator toolTipGenerator = null;
   private ObjectList toolTipGeneratorList = new ObjectList();
   private CategoryToolTipGenerator baseToolTipGenerator;
   private CategoryURLGenerator itemURLGenerator = null;
   private ObjectList itemURLGeneratorList = new ObjectList();
   private CategoryURLGenerator baseItemURLGenerator;
   private CategorySeriesLabelGenerator legendItemLabelGenerator = new StandardCategorySeriesLabelGenerator();
   private CategorySeriesLabelGenerator legendItemToolTipGenerator;
   private CategorySeriesLabelGenerator legendItemURLGenerator;
   private transient int rowCount;
   private transient int columnCount;

   public int getPassCount() {
      return 1;
   }

   public CategoryPlot getPlot() {
      return this.plot;
   }

   public void setPlot(CategoryPlot var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'plot\' argument.");
      } else {
         this.plot = var1;
      }
   }

   public CategoryItemLabelGenerator getItemLabelGenerator(int var1, int var2) {
      return this.getSeriesItemLabelGenerator(var1);
   }

   public CategoryItemLabelGenerator getSeriesItemLabelGenerator(int var1) {
      if(this.itemLabelGenerator != null) {
         return this.itemLabelGenerator;
      } else {
         CategoryItemLabelGenerator var2 = (CategoryItemLabelGenerator)this.itemLabelGeneratorList.get(var1);
         if(var2 == null) {
            var2 = this.baseItemLabelGenerator;
         }

         return var2;
      }
   }

   public void setItemLabelGenerator(CategoryItemLabelGenerator var1) {
      this.itemLabelGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void setSeriesItemLabelGenerator(int var1, CategoryItemLabelGenerator var2) {
      this.itemLabelGeneratorList.set(var1, var2);
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public CategoryItemLabelGenerator getBaseItemLabelGenerator() {
      return this.baseItemLabelGenerator;
   }

   public void setBaseItemLabelGenerator(CategoryItemLabelGenerator var1) {
      this.baseItemLabelGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public CategoryToolTipGenerator getToolTipGenerator(int var1, int var2) {
      CategoryToolTipGenerator var3 = null;
      if(this.toolTipGenerator != null) {
         var3 = this.toolTipGenerator;
      } else {
         var3 = this.getSeriesToolTipGenerator(var1);
         if(var3 == null) {
            var3 = this.baseToolTipGenerator;
         }
      }

      return var3;
   }

   public CategoryToolTipGenerator getToolTipGenerator() {
      return this.toolTipGenerator;
   }

   public void setToolTipGenerator(CategoryToolTipGenerator var1) {
      this.toolTipGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public CategoryToolTipGenerator getSeriesToolTipGenerator(int var1) {
      return (CategoryToolTipGenerator)this.toolTipGeneratorList.get(var1);
   }

   public void setSeriesToolTipGenerator(int var1, CategoryToolTipGenerator var2) {
      this.toolTipGeneratorList.set(var1, var2);
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public CategoryToolTipGenerator getBaseToolTipGenerator() {
      return this.baseToolTipGenerator;
   }

   public void setBaseToolTipGenerator(CategoryToolTipGenerator var1) {
      this.baseToolTipGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public CategoryURLGenerator getItemURLGenerator(int var1, int var2) {
      return this.getSeriesItemURLGenerator(var1);
   }

   public CategoryURLGenerator getSeriesItemURLGenerator(int var1) {
      if(this.itemURLGenerator != null) {
         return this.itemURLGenerator;
      } else {
         CategoryURLGenerator var2 = (CategoryURLGenerator)this.itemURLGeneratorList.get(var1);
         if(var2 == null) {
            var2 = this.baseItemURLGenerator;
         }

         return var2;
      }
   }

   public void setItemURLGenerator(CategoryURLGenerator var1) {
      this.itemURLGenerator = var1;
   }

   public void setSeriesItemURLGenerator(int var1, CategoryURLGenerator var2) {
      this.itemURLGeneratorList.set(var1, var2);
   }

   public CategoryURLGenerator getBaseItemURLGenerator() {
      return this.baseItemURLGenerator;
   }

   public void setBaseItemURLGenerator(CategoryURLGenerator var1) {
      this.baseItemURLGenerator = var1;
   }

   public int getRowCount() {
      return this.rowCount;
   }

   public int getColumnCount() {
      return this.columnCount;
   }

   protected CategoryItemRendererState createState(PlotRenderingInfo var1) {
      return new CategoryItemRendererState(var1);
   }

   public CategoryItemRendererState initialise(Graphics2D var1, Rectangle2D var2, CategoryPlot var3, int var4, PlotRenderingInfo var5) {
      this.setPlot(var3);
      CategoryDataset var6 = var3.getDataset(var4);
      if(var6 != null) {
         this.rowCount = var6.getRowCount();
         this.columnCount = var6.getColumnCount();
      } else {
         this.rowCount = 0;
         this.columnCount = 0;
      }

      return this.createState(var5);
   }

   public Range findRangeBounds(CategoryDataset var1) {
      return DatasetUtilities.findRangeBounds(var1);
   }

   public void drawBackground(Graphics2D var1, CategoryPlot var2, Rectangle2D var3) {
      var2.drawBackground(var1, var3);
   }

   public void drawOutline(Graphics2D var1, CategoryPlot var2, Rectangle2D var3) {
      var2.drawOutline(var1, var3);
   }

   public void drawDomainGridline(Graphics2D var1, CategoryPlot var2, Rectangle2D var3, double var4) {
      Double var6 = null;
      PlotOrientation var7 = var2.getOrientation();
      if(var7 == PlotOrientation.HORIZONTAL) {
         var6 = new Double(var3.getMinX(), var4, var3.getMaxX(), var4);
      } else if(var7 == PlotOrientation.VERTICAL) {
         var6 = new Double(var4, var3.getMinY(), var4, var3.getMaxY());
      }

      Paint var8 = var2.getDomainGridlinePaint();
      if(var8 == null) {
         var8 = CategoryPlot.DEFAULT_GRIDLINE_PAINT;
      }

      var1.setPaint(var8);
      Stroke var9 = var2.getDomainGridlineStroke();
      if(var9 == null) {
         var9 = CategoryPlot.DEFAULT_GRIDLINE_STROKE;
      }

      var1.setStroke(var9);
      var1.draw(var6);
   }

   public void drawRangeGridline(Graphics2D var1, CategoryPlot var2, ValueAxis var3, Rectangle2D var4, double var5) {
      Range var7 = var3.getRange();
      if(var7.contains(var5)) {
         PlotOrientation var8 = var2.getOrientation();
         double var9 = var3.valueToJava2D(var5, var4, var2.getRangeAxisEdge());
         Double var11 = null;
         if(var8 == PlotOrientation.HORIZONTAL) {
            var11 = new Double(var9, var4.getMinY(), var9, var4.getMaxY());
         } else if(var8 == PlotOrientation.VERTICAL) {
            var11 = new Double(var4.getMinX(), var9, var4.getMaxX(), var9);
         }

         Paint var12 = var2.getRangeGridlinePaint();
         if(var12 == null) {
            var12 = CategoryPlot.DEFAULT_GRIDLINE_PAINT;
         }

         var1.setPaint(var12);
         Stroke var13 = var2.getRangeGridlineStroke();
         if(var13 == null) {
            var13 = CategoryPlot.DEFAULT_GRIDLINE_STROKE;
         }

         var1.setStroke(var13);
         var1.draw(var11);
      }
   }

   public void drawDomainMarker(Graphics2D var1, CategoryPlot var2, CategoryAxis var3, CategoryMarker var4, Rectangle2D var5) {
      Comparable var6 = var4.getKey();
      CategoryDataset var7 = var2.getDataset(var2.getIndexOf(this));
      int var8 = var7.getColumnIndex(var6);
      if(var8 >= 0) {
         Composite var9 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var4.getAlpha()));
         PlotOrientation var10 = var2.getOrientation();
         Object var11 = null;
         double var12;
         if(var4.getDrawAsLine()) {
            var12 = var3.getCategoryMiddle(var8, var7.getColumnCount(), var5, var2.getDomainAxisEdge());
            Double var14 = null;
            if(var10 == PlotOrientation.HORIZONTAL) {
               var14 = new Double(var5.getMinX(), var12, var5.getMaxX(), var12);
            } else if(var10 == PlotOrientation.VERTICAL) {
               var14 = new Double(var12, var5.getMinY(), var12, var5.getMaxY());
            }

            var1.setPaint(var4.getPaint());
            var1.setStroke(var4.getStroke());
            var1.draw(var14);
            var11 = var14.getBounds2D();
         } else {
            var12 = var3.getCategoryStart(var8, var7.getColumnCount(), var5, var2.getDomainAxisEdge());
            double var18 = var3.getCategoryEnd(var8, var7.getColumnCount(), var5, var2.getDomainAxisEdge());
            java.awt.geom.Rectangle2D.Double var16 = null;
            if(var10 == PlotOrientation.HORIZONTAL) {
               var16 = new java.awt.geom.Rectangle2D.Double(var5.getMinX(), var12, var5.getWidth(), var18 - var12);
            } else if(var10 == PlotOrientation.VERTICAL) {
               var16 = new java.awt.geom.Rectangle2D.Double(var12, var5.getMinY(), var18 - var12, var5.getHeight());
            }

            var1.setPaint(var4.getPaint());
            var1.fill(var16);
            var11 = var16;
         }

         String var17 = var4.getLabel();
         RectangleAnchor var13 = var4.getLabelAnchor();
         if(var17 != null) {
            Font var19 = var4.getLabelFont();
            var1.setFont(var19);
            var1.setPaint(var4.getLabelPaint());
            Point2D var15 = this.calculateDomainMarkerTextAnchorPoint(var1, var10, var5, (Rectangle2D)var11, var4.getLabelOffset(), var4.getLabelOffsetType(), var13);
            TextUtilities.drawAlignedString(var17, var1, (float)var15.getX(), (float)var15.getY(), var4.getLabelTextAnchor());
         }

         var1.setComposite(var9);
      }
   }

   public void drawRangeMarker(Graphics2D var1, CategoryPlot var2, ValueAxis var3, Marker var4, Rectangle2D var5) {
      double var7;
      if(var4 instanceof ValueMarker) {
         ValueMarker var6 = (ValueMarker)var4;
         var7 = var6.getValue();
         Range var9 = var3.getRange();
         if(!var9.contains(var7)) {
            return;
         }

         Composite var10 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var4.getAlpha()));
         PlotOrientation var11 = var2.getOrientation();
         double var12 = var3.valueToJava2D(var7, var5, var2.getRangeAxisEdge());
         Double var14 = null;
         if(var11 == PlotOrientation.HORIZONTAL) {
            var14 = new Double(var12, var5.getMinY(), var12, var5.getMaxY());
         } else if(var11 == PlotOrientation.VERTICAL) {
            var14 = new Double(var5.getMinX(), var12, var5.getMaxX(), var12);
         }

         var1.setPaint(var4.getPaint());
         var1.setStroke(var4.getStroke());
         var1.draw(var14);
         String var15 = var4.getLabel();
         RectangleAnchor var16 = var4.getLabelAnchor();
         if(var15 != null) {
            Font var17 = var4.getLabelFont();
            var1.setFont(var17);
            var1.setPaint(var4.getLabelPaint());
            Point2D var18 = this.calculateRangeMarkerTextAnchorPoint(var1, var11, var5, var14.getBounds2D(), var4.getLabelOffset(), LengthAdjustmentType.EXPAND, var16);
            TextUtilities.drawAlignedString(var15, var1, (float)var18.getX(), (float)var18.getY(), var4.getLabelTextAnchor());
         }

         var1.setComposite(var10);
      } else if(var4 instanceof IntervalMarker) {
         IntervalMarker var29 = (IntervalMarker)var4;
         var7 = var29.getStartValue();
         double var30 = var29.getEndValue();
         Range var31 = var3.getRange();
         if(!var31.intersects(var7, var30)) {
            return;
         }

         Composite var32 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, var4.getAlpha()));
         double var13 = var3.valueToJava2D(var7, var5, var2.getRangeAxisEdge());
         double var33 = var3.valueToJava2D(var30, var5, var2.getRangeAxisEdge());
         double var34 = Math.min(var13, var33);
         double var19 = Math.max(var13, var33);
         PlotOrientation var21 = var2.getOrientation();
         java.awt.geom.Rectangle2D.Double var22 = null;
         if(var21 == PlotOrientation.HORIZONTAL) {
            var34 = Math.max(var34, var5.getMinX());
            var19 = Math.min(var19, var5.getMaxX());
            var22 = new java.awt.geom.Rectangle2D.Double(var34, var5.getMinY(), var19 - var34, var5.getHeight());
         } else if(var21 == PlotOrientation.VERTICAL) {
            var34 = Math.max(var34, var5.getMinY());
            var19 = Math.min(var19, var5.getMaxY());
            var22 = new java.awt.geom.Rectangle2D.Double(var5.getMinX(), var34, var5.getWidth(), var19 - var34);
         }

         Paint var23 = var4.getPaint();
         if(var23 instanceof GradientPaint) {
            GradientPaint var24 = (GradientPaint)var23;
            GradientPaintTransformer var25 = var29.getGradientPaintTransformer();
            if(var25 != null) {
               var24 = var25.transform(var24, var22);
            }

            var1.setPaint(var24);
         } else {
            var1.setPaint(var23);
         }

         var1.fill(var22);
         if(var29.getOutlinePaint() != null && var29.getOutlineStroke() != null) {
            double var27;
            Double var35;
            double var36;
            if(var21 == PlotOrientation.VERTICAL) {
               var35 = new Double();
               var36 = var5.getMinX();
               var27 = var5.getMaxX();
               var1.setPaint(var29.getOutlinePaint());
               var1.setStroke(var29.getOutlineStroke());
               if(var31.contains(var7)) {
                  var35.setLine(var36, var13, var27, var13);
                  var1.draw(var35);
               }

               if(var31.contains(var30)) {
                  var35.setLine(var36, var33, var27, var33);
                  var1.draw(var35);
               }
            } else {
               var35 = new Double();
               var36 = var5.getMinY();
               var27 = var5.getMaxY();
               var1.setPaint(var29.getOutlinePaint());
               var1.setStroke(var29.getOutlineStroke());
               if(var31.contains(var7)) {
                  var35.setLine(var13, var36, var13, var27);
                  var1.draw(var35);
               }

               if(var31.contains(var30)) {
                  var35.setLine(var33, var36, var33, var27);
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
            Point2D var39 = this.calculateRangeMarkerTextAnchorPoint(var1, var21, var5, var22, var4.getLabelOffset(), var4.getLabelOffsetType(), var38);
            TextUtilities.drawAlignedString(var37, var1, (float)var39.getX(), (float)var39.getY(), var4.getLabelTextAnchor());
         }

         var1.setComposite(var32);
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

   protected Point2D calculateRangeMarkerTextAnchorPoint(Graphics2D var1, PlotOrientation var2, Rectangle2D var3, Rectangle2D var4, RectangleInsets var5, LengthAdjustmentType var6, RectangleAnchor var7) {
      Rectangle2D var8 = null;
      if(var2 == PlotOrientation.HORIZONTAL) {
         var8 = var5.createAdjustedRectangle(var4, var6, LengthAdjustmentType.CONTRACT);
      } else if(var2 == PlotOrientation.VERTICAL) {
         var8 = var5.createAdjustedRectangle(var4, LengthAdjustmentType.CONTRACT, var6);
      }

      return RectangleAnchor.coordinates(var8, var7);
   }

   public LegendItem getLegendItem(int var1, int var2) {
      CategoryPlot var3 = this.getPlot();
      if(var3 == null) {
         return null;
      } else if(this.isSeriesVisible(var2) && this.isSeriesVisibleInLegend(var2)) {
         CategoryDataset var4 = var3.getDataset(var1);
         String var5 = this.legendItemLabelGenerator.generateLabel(var4, var2);
         String var7 = null;
         if(this.legendItemToolTipGenerator != null) {
            var7 = this.legendItemToolTipGenerator.generateLabel(var4, var2);
         }

         String var8 = null;
         if(this.legendItemURLGenerator != null) {
            var8 = this.legendItemURLGenerator.generateLabel(var4, var2);
         }

         Shape var9 = this.getSeriesShape(var2);
         Paint var10 = this.getSeriesPaint(var2);
         Paint var11 = this.getSeriesOutlinePaint(var2);
         Stroke var12 = this.getSeriesOutlineStroke(var2);
         LegendItem var13 = new LegendItem(var5, var5, var7, var8, var9, var10, var12, var11);
         var13.setSeriesIndex(var2);
         var13.setDatasetIndex(var1);
         return var13;
      } else {
         return null;
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof AbstractCategoryItemRenderer)) {
         return false;
      } else {
         AbstractCategoryItemRenderer var2 = (AbstractCategoryItemRenderer)var1;
         return !ObjectUtilities.equal(this.itemLabelGenerator, var2.itemLabelGenerator)?false:(!ObjectUtilities.equal(this.itemLabelGeneratorList, var2.itemLabelGeneratorList)?false:(!ObjectUtilities.equal(this.baseItemLabelGenerator, var2.baseItemLabelGenerator)?false:(!ObjectUtilities.equal(this.toolTipGenerator, var2.toolTipGenerator)?false:(!ObjectUtilities.equal(this.toolTipGeneratorList, var2.toolTipGeneratorList)?false:(!ObjectUtilities.equal(this.baseToolTipGenerator, var2.baseToolTipGenerator)?false:(!ObjectUtilities.equal(this.itemURLGenerator, var2.itemURLGenerator)?false:(!ObjectUtilities.equal(this.itemURLGeneratorList, var2.itemURLGeneratorList)?false:(!ObjectUtilities.equal(this.baseItemURLGenerator, var2.baseItemURLGenerator)?false:(!ObjectUtilities.equal(this.legendItemLabelGenerator, var2.legendItemLabelGenerator)?false:(!ObjectUtilities.equal(this.legendItemToolTipGenerator, var2.legendItemToolTipGenerator)?false:(!ObjectUtilities.equal(this.legendItemURLGenerator, var2.legendItemURLGenerator)?false:super.equals(var1))))))))))));
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      return var1;
   }

   public DrawingSupplier getDrawingSupplier() {
      DrawingSupplier var1 = null;
      CategoryPlot var2 = this.getPlot();
      if(var2 != null) {
         var1 = var2.getDrawingSupplier();
      }

      return var1;
   }

   protected void drawItemLabel(Graphics2D var1, PlotOrientation var2, CategoryDataset var3, int var4, int var5, double var6, double var8, boolean var10) {
      CategoryItemLabelGenerator var11 = this.getItemLabelGenerator(var4, var5);
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

   public Object clone() {
      AbstractCategoryItemRenderer var1 = (AbstractCategoryItemRenderer)super.clone();
      PublicCloneable var2;
      if(this.itemLabelGenerator != null) {
         if(!(this.itemLabelGenerator instanceof PublicCloneable)) {
            throw new CloneNotSupportedException("ItemLabelGenerator not cloneable.");
         }

         var2 = (PublicCloneable)this.itemLabelGenerator;
         var1.itemLabelGenerator = (CategoryItemLabelGenerator)var2.clone();
      }

      if(this.itemLabelGeneratorList != null) {
         var1.itemLabelGeneratorList = (ObjectList)this.itemLabelGeneratorList.clone();
      }

      if(this.baseItemLabelGenerator != null) {
         if(!(this.baseItemLabelGenerator instanceof PublicCloneable)) {
            throw new CloneNotSupportedException("ItemLabelGenerator not cloneable.");
         }

         var2 = (PublicCloneable)this.baseItemLabelGenerator;
         var1.baseItemLabelGenerator = (CategoryItemLabelGenerator)var2.clone();
      }

      if(this.toolTipGenerator != null) {
         if(!(this.toolTipGenerator instanceof PublicCloneable)) {
            throw new CloneNotSupportedException("Tool tip generator not cloneable.");
         }

         var2 = (PublicCloneable)this.toolTipGenerator;
         var1.toolTipGenerator = (CategoryToolTipGenerator)var2.clone();
      }

      if(this.toolTipGeneratorList != null) {
         var1.toolTipGeneratorList = (ObjectList)this.toolTipGeneratorList.clone();
      }

      if(this.baseToolTipGenerator != null) {
         if(!(this.baseToolTipGenerator instanceof PublicCloneable)) {
            throw new CloneNotSupportedException("Base tool tip generator not cloneable.");
         }

         var2 = (PublicCloneable)this.baseToolTipGenerator;
         var1.baseToolTipGenerator = (CategoryToolTipGenerator)var2.clone();
      }

      if(this.itemURLGenerator != null) {
         if(!(this.itemURLGenerator instanceof PublicCloneable)) {
            throw new CloneNotSupportedException("Item URL generator not cloneable.");
         }

         var2 = (PublicCloneable)this.itemURLGenerator;
         var1.itemURLGenerator = (CategoryURLGenerator)var2.clone();
      }

      if(this.itemURLGeneratorList != null) {
         var1.itemURLGeneratorList = (ObjectList)this.itemURLGeneratorList.clone();
      }

      if(this.baseItemURLGenerator != null) {
         if(!(this.baseItemURLGenerator instanceof PublicCloneable)) {
            throw new CloneNotSupportedException("Base item URL generator not cloneable.");
         }

         var2 = (PublicCloneable)this.baseItemURLGenerator;
         var1.baseItemURLGenerator = (CategoryURLGenerator)var2.clone();
      }

      if(this.legendItemLabelGenerator instanceof PublicCloneable) {
         var1.legendItemLabelGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemLabelGenerator);
      }

      if(this.legendItemToolTipGenerator instanceof PublicCloneable) {
         var1.legendItemToolTipGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemToolTipGenerator);
      }

      if(this.legendItemURLGenerator instanceof PublicCloneable) {
         var1.legendItemURLGenerator = (CategorySeriesLabelGenerator)ObjectUtilities.clone(this.legendItemURLGenerator);
      }

      return var1;
   }

   protected CategoryAxis getDomainAxis(CategoryPlot var1, int var2) {
      CategoryAxis var3 = var1.getDomainAxis(var2);
      if(var3 == null) {
         var3 = var1.getDomainAxis();
      }

      return var3;
   }

   protected ValueAxis getRangeAxis(CategoryPlot var1, int var2) {
      ValueAxis var3 = var1.getRangeAxis(var2);
      if(var3 == null) {
         var3 = var1.getRangeAxis();
      }

      return var3;
   }

   public LegendItemCollection getLegendItems() {
      if(this.plot == null) {
         return new LegendItemCollection();
      } else {
         LegendItemCollection var1 = new LegendItemCollection();
         int var2 = this.plot.getIndexOf(this);
         CategoryDataset var3 = this.plot.getDataset(var2);
         if(var3 != null) {
            int var4 = var3.getRowCount();

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

   public CategorySeriesLabelGenerator getLegendItemLabelGenerator() {
      return this.legendItemLabelGenerator;
   }

   public void setLegendItemLabelGenerator(CategorySeriesLabelGenerator var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'generator\' argument.");
      } else {
         this.legendItemLabelGenerator = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public CategorySeriesLabelGenerator getLegendItemToolTipGenerator() {
      return this.legendItemToolTipGenerator;
   }

   public void setLegendItemToolTipGenerator(CategorySeriesLabelGenerator var1) {
      this.legendItemToolTipGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public CategorySeriesLabelGenerator getLegendItemURLGenerator() {
      return this.legendItemURLGenerator;
   }

   public void setLegendItemURLGenerator(CategorySeriesLabelGenerator var1) {
      this.legendItemURLGenerator = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   protected void addItemEntity(EntityCollection var1, CategoryDataset var2, int var3, int var4, Shape var5) {
      String var6 = null;
      CategoryToolTipGenerator var7 = this.getToolTipGenerator(var3, var4);
      if(var7 != null) {
         var6 = var7.generateToolTip(var2, var3, var4);
      }

      String var8 = null;
      CategoryURLGenerator var9 = this.getItemURLGenerator(var3, var4);
      if(var9 != null) {
         var8 = var9.generateURL(var2, var3, var4);
      }

      CategoryItemEntity var10 = new CategoryItemEntity(var5, var6, var8, var2, var3, var2.getColumnKey(var4), var4);
      var1.add(var10);
   }
}
