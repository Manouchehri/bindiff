package org.jfree.chart.renderer.category;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class LineAndShapeRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = -197749519869226398L;
   private Boolean linesVisible;
   private BooleanList seriesLinesVisible;
   private boolean baseLinesVisible;
   private Boolean shapesVisible;
   private BooleanList seriesShapesVisible;
   private boolean baseShapesVisible;
   private Boolean shapesFilled;
   private BooleanList seriesShapesFilled;
   private boolean baseShapesFilled;
   private boolean useFillPaint;
   private boolean drawOutlines;
   private boolean useOutlinePaint;

   public LineAndShapeRenderer() {
      this(true, true);
   }

   public LineAndShapeRenderer(boolean var1, boolean var2) {
      this.linesVisible = null;
      this.seriesLinesVisible = new BooleanList();
      this.baseLinesVisible = var1;
      this.shapesVisible = null;
      this.seriesShapesVisible = new BooleanList();
      this.baseShapesVisible = var2;
      this.shapesFilled = null;
      this.seriesShapesFilled = new BooleanList();
      this.baseShapesFilled = true;
      this.useFillPaint = false;
      this.drawOutlines = true;
      this.useOutlinePaint = false;
   }

   public boolean getItemLineVisible(int var1, int var2) {
      Boolean var3 = this.linesVisible;
      if(var3 == null) {
         var3 = this.getSeriesLinesVisible(var1);
      }

      return var3 != null?var3.booleanValue():this.baseLinesVisible;
   }

   public Boolean getLinesVisible() {
      return this.linesVisible;
   }

   public void setLinesVisible(Boolean var1) {
      this.linesVisible = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void setLinesVisible(boolean var1) {
      this.setLinesVisible(BooleanUtilities.valueOf(var1));
   }

   public Boolean getSeriesLinesVisible(int var1) {
      return this.seriesLinesVisible.getBoolean(var1);
   }

   public void setSeriesLinesVisible(int var1, Boolean var2) {
      this.seriesLinesVisible.setBoolean(var1, var2);
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void setSeriesLinesVisible(int var1, boolean var2) {
      this.setSeriesLinesVisible(var1, BooleanUtilities.valueOf(var2));
   }

   public boolean getBaseLinesVisible() {
      return this.baseLinesVisible;
   }

   public void setBaseLinesVisible(boolean var1) {
      this.baseLinesVisible = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getItemShapeVisible(int var1, int var2) {
      Boolean var3 = this.shapesVisible;
      if(var3 == null) {
         var3 = this.getSeriesShapesVisible(var1);
      }

      return var3 != null?var3.booleanValue():this.baseShapesVisible;
   }

   public Boolean getShapesVisible() {
      return this.shapesVisible;
   }

   public void setShapesVisible(Boolean var1) {
      this.shapesVisible = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public void setShapesVisible(boolean var1) {
      this.setShapesVisible(BooleanUtilities.valueOf(var1));
   }

   public Boolean getSeriesShapesVisible(int var1) {
      return this.seriesShapesVisible.getBoolean(var1);
   }

   public void setSeriesShapesVisible(int var1, boolean var2) {
      this.setSeriesShapesVisible(var1, BooleanUtilities.valueOf(var2));
   }

   public void setSeriesShapesVisible(int var1, Boolean var2) {
      this.seriesShapesVisible.setBoolean(var1, var2);
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getBaseShapesVisible() {
      return this.baseShapesVisible;
   }

   public void setBaseShapesVisible(boolean var1) {
      this.baseShapesVisible = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getDrawOutlines() {
      return this.drawOutlines;
   }

   public void setDrawOutlines(boolean var1) {
      this.drawOutlines = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getUseOutlinePaint() {
      return this.useOutlinePaint;
   }

   public void setUseOutlinePaint(boolean var1) {
      this.useOutlinePaint = var1;
   }

   public boolean getItemShapeFilled(int var1, int var2) {
      return this.getSeriesShapesFilled(var1);
   }

   public boolean getSeriesShapesFilled(int var1) {
      if(this.shapesFilled != null) {
         return this.shapesFilled.booleanValue();
      } else {
         Boolean var2 = this.seriesShapesFilled.getBoolean(var1);
         return var2 != null?var2.booleanValue():this.baseShapesFilled;
      }
   }

   public Boolean getShapesFilled() {
      return this.shapesFilled;
   }

   public void setShapesFilled(boolean var1) {
      if(var1) {
         this.setShapesFilled(Boolean.TRUE);
      } else {
         this.setShapesFilled(Boolean.FALSE);
      }

   }

   public void setShapesFilled(Boolean var1) {
      this.shapesFilled = var1;
   }

   public void setSeriesShapesFilled(int var1, Boolean var2) {
      this.seriesShapesFilled.setBoolean(var1, var2);
   }

   public void setSeriesShapesFilled(int var1, boolean var2) {
      this.seriesShapesFilled.setBoolean(var1, BooleanUtilities.valueOf(var2));
   }

   public boolean getBaseShapesFilled() {
      return this.baseShapesFilled;
   }

   public void setBaseShapesFilled(boolean var1) {
      this.baseShapesFilled = var1;
   }

   public boolean getUseFillPaint() {
      return this.useFillPaint;
   }

   public void setUseFillPaint(boolean var1) {
      this.useFillPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public LegendItem getLegendItem(int var1, int var2) {
      CategoryPlot var3 = this.getPlot();
      if(var3 == null) {
         return null;
      } else if(this.isSeriesVisible(var2) && this.isSeriesVisibleInLegend(var2)) {
         CategoryDataset var4 = var3.getDataset(var1);
         String var5 = this.getLegendItemLabelGenerator().generateLabel(var4, var2);
         String var7 = null;
         if(this.getLegendItemToolTipGenerator() != null) {
            var7 = this.getLegendItemToolTipGenerator().generateLabel(var4, var2);
         }

         String var8 = null;
         if(this.getLegendItemURLGenerator() != null) {
            var8 = this.getLegendItemURLGenerator().generateLabel(var4, var2);
         }

         Shape var9 = this.getSeriesShape(var2);
         Paint var10 = this.getSeriesPaint(var2);
         Paint var11 = this.useFillPaint?this.getItemFillPaint(var2, 0):var10;
         boolean var12 = this.drawOutlines;
         Paint var13 = this.useOutlinePaint?this.getItemOutlinePaint(var2, 0):var10;
         Stroke var14 = this.getSeriesOutlineStroke(var2);
         boolean var15 = this.getItemLineVisible(var2, 0);
         boolean var16 = this.getItemShapeVisible(var2, 0);
         return new LegendItem(var5, var5, var7, var8, var16, var9, this.getItemShapeFilled(var2, 0), var11, var12, var13, var14, var15, new Double(-7.0D, 0.0D, 7.0D, 0.0D), this.getItemStroke(var2, 0), this.getItemPaint(var2, 0));
      } else {
         return null;
      }
   }

   public int getPassCount() {
      return 2;
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(this.getItemVisible(var8, var9)) {
         if(this.getItemLineVisible(var8, var9) || this.getItemShapeVisible(var8, var9)) {
            Number var11 = var7.getValue(var8, var9);
            if(var11 != null) {
               PlotOrientation var12 = var4.getOrientation();
               double var13 = var5.getCategoryMiddle(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
               double var15 = var11.doubleValue();
               double var17 = var6.valueToJava2D(var15, var3, var4.getRangeAxisEdge());
               if(var10 == 0 && this.getItemLineVisible(var8, var9) && var9 != 0) {
                  Number var19 = var7.getValue(var8, var9 - 1);
                  if(var19 != null) {
                     double var20 = var19.doubleValue();
                     double var22 = var5.getCategoryMiddle(var9 - 1, this.getColumnCount(), var3, var4.getDomainAxisEdge());
                     double var24 = var6.valueToJava2D(var20, var3, var4.getRangeAxisEdge());
                     Double var26 = null;
                     if(var12 == PlotOrientation.HORIZONTAL) {
                        var26 = new Double(var24, var22, var17, var13);
                     } else if(var12 == PlotOrientation.VERTICAL) {
                        var26 = new Double(var22, var24, var13, var17);
                     }

                     var1.setPaint(this.getItemPaint(var8, var9));
                     var1.setStroke(this.getItemStroke(var8, var9));
                     var1.draw(var26);
                  }
               }

               if(var10 == 1) {
                  Shape var27 = this.getItemShape(var8, var9);
                  if(var12 == PlotOrientation.HORIZONTAL) {
                     var27 = ShapeUtilities.createTranslatedShape(var27, var17, var13);
                  } else if(var12 == PlotOrientation.VERTICAL) {
                     var27 = ShapeUtilities.createTranslatedShape(var27, var13, var17);
                  }

                  if(this.getItemShapeVisible(var8, var9)) {
                     if(this.getItemShapeFilled(var8, var9)) {
                        if(this.useFillPaint) {
                           var1.setPaint(this.getItemFillPaint(var8, var9));
                        } else {
                           var1.setPaint(this.getItemPaint(var8, var9));
                        }

                        var1.fill(var27);
                     }

                     if(this.drawOutlines) {
                        if(this.useOutlinePaint) {
                           var1.setPaint(this.getItemOutlinePaint(var8, var9));
                        } else {
                           var1.setPaint(this.getItemPaint(var8, var9));
                        }

                        var1.setStroke(this.getItemOutlineStroke(var8, var9));
                        var1.draw(var27);
                     }
                  }

                  if(this.isItemLabelVisible(var8, var9)) {
                     if(var12 == PlotOrientation.HORIZONTAL) {
                        this.drawItemLabel(var1, var12, var7, var8, var9, var17, var13, var15 < 0.0D);
                     } else if(var12 == PlotOrientation.VERTICAL) {
                        this.drawItemLabel(var1, var12, var7, var8, var9, var13, var17, var15 < 0.0D);
                     }
                  }

                  EntityCollection var28 = var2.getEntityCollection();
                  if(var28 != null) {
                     this.addItemEntity(var28, var7, var8, var9, var27);
                  }
               }

            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LineAndShapeRenderer)) {
         return false;
      } else {
         LineAndShapeRenderer var2 = (LineAndShapeRenderer)var1;
         return this.baseLinesVisible != var2.baseLinesVisible?false:(!ObjectUtilities.equal(this.seriesLinesVisible, var2.seriesLinesVisible)?false:(!ObjectUtilities.equal(this.linesVisible, var2.linesVisible)?false:(this.baseShapesVisible != var2.baseShapesVisible?false:(!ObjectUtilities.equal(this.seriesShapesVisible, var2.seriesShapesVisible)?false:(!ObjectUtilities.equal(this.shapesVisible, var2.shapesVisible)?false:(!ObjectUtilities.equal(this.shapesFilled, var2.shapesFilled)?false:(!ObjectUtilities.equal(this.seriesShapesFilled, var2.seriesShapesFilled)?false:(this.baseShapesFilled != var2.baseShapesFilled?false:(this.useOutlinePaint != var2.useOutlinePaint?false:super.equals(var1))))))))));
      }
   }

   public Object clone() {
      LineAndShapeRenderer var1 = (LineAndShapeRenderer)super.clone();
      var1.seriesLinesVisible = (BooleanList)this.seriesLinesVisible.clone();
      var1.seriesShapesVisible = (BooleanList)this.seriesLinesVisible.clone();
      var1.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
      return var1;
   }
}
