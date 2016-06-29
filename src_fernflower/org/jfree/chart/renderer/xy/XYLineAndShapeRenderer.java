package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer$State;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;

public class XYLineAndShapeRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -7435246895986425885L;
   private Boolean linesVisible;
   private BooleanList seriesLinesVisible;
   private boolean baseLinesVisible;
   private transient Shape legendLine;
   private Boolean shapesVisible;
   private BooleanList seriesShapesVisible;
   private boolean baseShapesVisible;
   private Boolean shapesFilled;
   private BooleanList seriesShapesFilled;
   private boolean baseShapesFilled;
   private boolean drawOutlines;
   private boolean useFillPaint;
   private boolean useOutlinePaint;
   private boolean drawSeriesLineAsPath;

   public XYLineAndShapeRenderer() {
      this(true, true);
   }

   public XYLineAndShapeRenderer(boolean var1, boolean var2) {
      this.linesVisible = null;
      this.seriesLinesVisible = new BooleanList();
      this.baseLinesVisible = var1;
      this.legendLine = new Double(-7.0D, 0.0D, 7.0D, 0.0D);
      this.shapesVisible = null;
      this.seriesShapesVisible = new BooleanList();
      this.baseShapesVisible = var2;
      this.shapesFilled = null;
      this.useFillPaint = false;
      this.seriesShapesFilled = new BooleanList();
      this.baseShapesFilled = true;
      this.drawOutlines = true;
      this.useOutlinePaint = false;
      this.drawSeriesLineAsPath = false;
   }

   public boolean getDrawSeriesLineAsPath() {
      return this.drawSeriesLineAsPath;
   }

   public void setDrawSeriesLineAsPath(boolean var1) {
      if(this.drawSeriesLineAsPath != var1) {
         this.drawSeriesLineAsPath = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public int getPassCount() {
      return 2;
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

   public Shape getLegendLine() {
      return this.legendLine;
   }

   public void setLegendLine(Shape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'line\' argument.");
      } else {
         this.legendLine = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
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

   public boolean getItemShapeFilled(int var1, int var2) {
      Boolean var3 = this.shapesFilled;
      if(var3 == null) {
         var3 = this.getSeriesShapesFilled(var1);
      }

      return var3 != null?var3.booleanValue():this.baseShapesFilled;
   }

   public void setShapesFilled(boolean var1) {
      this.setShapesFilled(BooleanUtilities.valueOf(var1));
   }

   public void setShapesFilled(Boolean var1) {
      this.shapesFilled = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Boolean getSeriesShapesFilled(int var1) {
      return this.seriesShapesFilled.getBoolean(var1);
   }

   public void setSeriesShapesFilled(int var1, boolean var2) {
      this.setSeriesShapesFilled(var1, BooleanUtilities.valueOf(var2));
   }

   public void setSeriesShapesFilled(int var1, Boolean var2) {
      this.seriesShapesFilled.setBoolean(var1, var2);
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getBaseShapesFilled() {
      return this.baseShapesFilled;
   }

   public void setBaseShapesFilled(boolean var1) {
      this.baseShapesFilled = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getDrawOutlines() {
      return this.drawOutlines;
   }

   public void setDrawOutlines(boolean var1) {
      this.drawOutlines = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getUseFillPaint() {
      return this.useFillPaint;
   }

   public void setUseFillPaint(boolean var1) {
      this.useFillPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getUseOutlinePaint() {
      return this.useOutlinePaint;
   }

   public void setUseOutlinePaint(boolean var1) {
      this.useOutlinePaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      XYLineAndShapeRenderer$State var6 = new XYLineAndShapeRenderer$State(var5);
      var6.seriesPath = new GeneralPath();
      return var6;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      if(this.getItemVisible(var9, var10)) {
         if(this.isLinePass(var12)) {
            if(var10 == 0 && this.drawSeriesLineAsPath) {
               XYLineAndShapeRenderer$State var13 = (XYLineAndShapeRenderer$State)var2;
               var13.seriesPath.reset();
               XYLineAndShapeRenderer$State.access$002(var13, false);
            }

            if(this.getItemLineVisible(var9, var10)) {
               if(this.drawSeriesLineAsPath) {
                  this.drawPrimaryLineAsPath(var2, var1, var5, var8, var12, var9, var10, var6, var7, var3);
               } else {
                  this.drawPrimaryLine(var2, var1, var5, var8, var12, var9, var10, var6, var7, var3);
               }
            }
         } else if(this.isItemPass(var12)) {
            EntityCollection var14 = null;
            if(var4 != null) {
               var14 = var4.getOwner().getEntityCollection();
            }

            this.drawSecondaryPass(var1, var5, var8, var12, var9, var10, var6, var3, var7, var11, var14);
         }

      }
   }

   protected boolean isLinePass(int var1) {
      return var1 == 0;
   }

   protected boolean isItemPass(int var1) {
      return var1 == 1;
   }

   protected void drawPrimaryLine(XYItemRendererState var1, Graphics2D var2, XYPlot var3, XYDataset var4, int var5, int var6, int var7, ValueAxis var8, ValueAxis var9, Rectangle2D var10) {
      if(var7 != 0) {
         double var11 = var4.getXValue(var6, var7);
         double var13 = var4.getYValue(var6, var7);
         if(!java.lang.Double.isNaN(var13) && !java.lang.Double.isNaN(var11)) {
            double var15 = var4.getXValue(var6, var7 - 1);
            double var17 = var4.getYValue(var6, var7 - 1);
            if(!java.lang.Double.isNaN(var17) && !java.lang.Double.isNaN(var15)) {
               RectangleEdge var19 = var3.getDomainAxisEdge();
               RectangleEdge var20 = var3.getRangeAxisEdge();
               double var21 = var8.valueToJava2D(var15, var10, var19);
               double var23 = var9.valueToJava2D(var17, var10, var20);
               double var25 = var8.valueToJava2D(var11, var10, var19);
               double var27 = var9.valueToJava2D(var13, var10, var20);
               if(!java.lang.Double.isNaN(var21) && !java.lang.Double.isNaN(var23) && !java.lang.Double.isNaN(var25) && !java.lang.Double.isNaN(var27)) {
                  PlotOrientation var29 = var3.getOrientation();
                  if(var29 == PlotOrientation.HORIZONTAL) {
                     var1.workingLine.setLine(var23, var21, var27, var25);
                  } else if(var29 == PlotOrientation.VERTICAL) {
                     var1.workingLine.setLine(var21, var23, var25, var27);
                  }

                  if(var1.workingLine.intersects(var10)) {
                     this.drawFirstPassShape(var2, var5, var6, var7, var1.workingLine);
                  }

               }
            }
         }
      }
   }

   protected void drawFirstPassShape(Graphics2D var1, int var2, int var3, int var4, Shape var5) {
      var1.setStroke(this.getItemStroke(var3, var4));
      var1.setPaint(this.getItemPaint(var3, var4));
      var1.draw(var5);
   }

   protected void drawPrimaryLineAsPath(XYItemRendererState var1, Graphics2D var2, XYPlot var3, XYDataset var4, int var5, int var6, int var7, ValueAxis var8, ValueAxis var9, Rectangle2D var10) {
      RectangleEdge var11 = var3.getDomainAxisEdge();
      RectangleEdge var12 = var3.getRangeAxisEdge();
      double var13 = var4.getXValue(var6, var7);
      double var15 = var4.getYValue(var6, var7);
      double var17 = var8.valueToJava2D(var13, var10, var11);
      double var19 = var9.valueToJava2D(var15, var10, var12);
      XYLineAndShapeRenderer$State var21 = (XYLineAndShapeRenderer$State)var1;
      if(!java.lang.Double.isNaN(var17) && !java.lang.Double.isNaN(var19)) {
         float var22 = (float)var17;
         float var23 = (float)var19;
         PlotOrientation var24 = var3.getOrientation();
         if(var24 == PlotOrientation.HORIZONTAL) {
            var22 = (float)var19;
            var23 = (float)var17;
         }

         if(var21.isLastPointGood()) {
            var21.seriesPath.lineTo(var22, var23);
         } else {
            var21.seriesPath.moveTo(var22, var23);
         }

         var21.setLastPointGood(true);
      } else {
         var21.setLastPointGood(false);
      }

      if(var7 == var4.getItemCount(var6) - 1) {
         this.drawFirstPassShape(var2, var5, var6, var7, var21.seriesPath);
      }

   }

   protected void drawSecondaryPass(Graphics2D var1, XYPlot var2, XYDataset var3, int var4, int var5, int var6, ValueAxis var7, Rectangle2D var8, ValueAxis var9, CrosshairState var10, EntityCollection var11) {
      Shape var12 = null;
      double var13 = var3.getXValue(var5, var6);
      double var15 = var3.getYValue(var5, var6);
      if(!java.lang.Double.isNaN(var15) && !java.lang.Double.isNaN(var13)) {
         PlotOrientation var17 = var2.getOrientation();
         RectangleEdge var18 = var2.getDomainAxisEdge();
         RectangleEdge var19 = var2.getRangeAxisEdge();
         double var20 = var7.valueToJava2D(var13, var8, var18);
         double var22 = var9.valueToJava2D(var15, var8, var19);
         if(this.getItemShapeVisible(var5, var6)) {
            Shape var24 = this.getItemShape(var5, var6);
            if(var17 == PlotOrientation.HORIZONTAL) {
               var24 = ShapeUtilities.createTranslatedShape(var24, var22, var20);
            } else if(var17 == PlotOrientation.VERTICAL) {
               var24 = ShapeUtilities.createTranslatedShape(var24, var20, var22);
            }

            var12 = var24;
            if(var24.intersects(var8)) {
               if(this.getItemShapeFilled(var5, var6)) {
                  if(this.useFillPaint) {
                     var1.setPaint(this.getItemFillPaint(var5, var6));
                  } else {
                     var1.setPaint(this.getItemPaint(var5, var6));
                  }

                  var1.fill(var24);
               }

               if(this.drawOutlines) {
                  if(this.getUseOutlinePaint()) {
                     var1.setPaint(this.getItemOutlinePaint(var5, var6));
                  } else {
                     var1.setPaint(this.getItemPaint(var5, var6));
                  }

                  var1.setStroke(this.getItemOutlineStroke(var5, var6));
                  var1.draw(var24);
               }
            }
         }

         if(this.isItemLabelVisible(var5, var6)) {
            double var28 = var20;
            double var26 = var22;
            if(var17 == PlotOrientation.HORIZONTAL) {
               var28 = var22;
               var26 = var20;
            }

            this.drawItemLabel(var1, var17, var3, var5, var6, var28, var26, var15 < 0.0D);
         }

         int var29 = var2.getDomainAxisIndex(var7);
         int var25 = var2.getRangeAxisIndex(var9);
         this.updateCrosshairValues(var10, var13, var15, var29, var25, var20, var22, var2.getOrientation());
         if(var11 != null) {
            this.addEntity(var11, var12, var3, var5, var6, var20, var22);
         }

      }
   }

   public LegendItem getLegendItem(int var1, int var2) {
      XYPlot var3 = this.getPlot();
      if(var3 == null) {
         return null;
      } else {
         LegendItem var4 = null;
         XYDataset var5 = var3.getDataset(var1);
         if(var5 != null && this.getItemVisible(var2, 0)) {
            String var6 = this.getLegendItemLabelGenerator().generateLabel(var5, var2);
            String var8 = null;
            if(this.getLegendItemToolTipGenerator() != null) {
               var8 = this.getLegendItemToolTipGenerator().generateLabel(var5, var2);
            }

            String var9 = null;
            if(this.getLegendItemURLGenerator() != null) {
               var9 = this.getLegendItemURLGenerator().generateLabel(var5, var2);
            }

            boolean var10 = this.getItemShapeVisible(var2, 0);
            Shape var11 = this.getSeriesShape(var2);
            boolean var12 = this.getItemShapeFilled(var2, 0);
            Paint var13 = this.useFillPaint?this.getSeriesFillPaint(var2):this.getSeriesPaint(var2);
            boolean var14 = this.drawOutlines;
            Paint var15 = this.useOutlinePaint?this.getSeriesOutlinePaint(var2):this.getSeriesPaint(var2);
            Stroke var16 = this.getSeriesOutlineStroke(var2);
            boolean var17 = this.getItemLineVisible(var2, 0);
            Stroke var18 = this.getSeriesStroke(var2);
            Paint var19 = this.getSeriesPaint(var2);
            var4 = new LegendItem(var6, var6, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, this.legendLine, var18, var19);
            var4.setSeriesIndex(var2);
            var4.setDatasetIndex(var1);
         }

         return var4;
      }
   }

   public Object clone() {
      XYLineAndShapeRenderer var1 = (XYLineAndShapeRenderer)super.clone();
      var1.seriesLinesVisible = (BooleanList)this.seriesLinesVisible.clone();
      if(this.legendLine != null) {
         var1.legendLine = ShapeUtilities.clone(this.legendLine);
      }

      var1.seriesShapesVisible = (BooleanList)this.seriesShapesVisible.clone();
      var1.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYLineAndShapeRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYLineAndShapeRenderer var2 = (XYLineAndShapeRenderer)var1;
         return !ObjectUtilities.equal(this.linesVisible, var2.linesVisible)?false:(!ObjectUtilities.equal(this.seriesLinesVisible, var2.seriesLinesVisible)?false:(this.baseLinesVisible != var2.baseLinesVisible?false:(!ShapeUtilities.equal(this.legendLine, var2.legendLine)?false:(!ObjectUtilities.equal(this.shapesVisible, var2.shapesVisible)?false:(!ObjectUtilities.equal(this.seriesShapesVisible, var2.seriesShapesVisible)?false:(this.baseShapesVisible != var2.baseShapesVisible?false:(!ObjectUtilities.equal(this.shapesFilled, var2.shapesFilled)?false:(!ObjectUtilities.equal(this.seriesShapesFilled, var2.seriesShapesFilled)?false:(this.baseShapesFilled != var2.baseShapesFilled?false:(this.drawOutlines != var2.drawOutlines?false:(this.useOutlinePaint != var2.useOutlinePaint?false:(this.useFillPaint != var2.useFillPaint?false:this.drawSeriesLineAsPath == var2.drawSeriesLineAsPath))))))))))));
      }
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.legendLine = SerialUtilities.readShape(var1);
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeShape(this.legendLine, var1);
   }
}
