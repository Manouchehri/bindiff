package org.jfree.chart.renderer.xy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.awt.image.ImageObserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer$State;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.BooleanList;
import org.jfree.util.BooleanUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.UnitType;

public class StandardXYItemRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -3271351259436865995L;
   public static final int SHAPES = 1;
   public static final int LINES = 2;
   public static final int SHAPES_AND_LINES = 3;
   public static final int IMAGES = 4;
   public static final int DISCONTINUOUS = 8;
   public static final int DISCONTINUOUS_LINES = 10;
   private boolean baseShapesVisible;
   private boolean plotLines;
   private boolean plotImages;
   private boolean plotDiscontinuous;
   private UnitType gapThresholdType;
   private double gapThreshold;
   private Boolean shapesFilled;
   private BooleanList seriesShapesFilled;
   private boolean baseShapesFilled;
   private boolean drawSeriesLineAsPath;
   private transient Shape legendLine;

   public StandardXYItemRenderer() {
      this(2, (XYToolTipGenerator)null);
   }

   public StandardXYItemRenderer(int var1) {
      this(var1, (XYToolTipGenerator)null);
   }

   public StandardXYItemRenderer(int var1, XYToolTipGenerator var2) {
      this(var1, var2, (XYURLGenerator)null);
   }

   public StandardXYItemRenderer(int var1, XYToolTipGenerator var2, XYURLGenerator var3) {
      this.gapThresholdType = UnitType.RELATIVE;
      this.gapThreshold = 1.0D;
      this.setToolTipGenerator(var2);
      this.setURLGenerator(var3);
      if((var1 & 1) != 0) {
         this.baseShapesVisible = true;
      }

      if((var1 & 2) != 0) {
         this.plotLines = true;
      }

      if((var1 & 4) != 0) {
         this.plotImages = true;
      }

      if((var1 & 8) != 0) {
         this.plotDiscontinuous = true;
      }

      this.shapesFilled = null;
      this.seriesShapesFilled = new BooleanList();
      this.baseShapesFilled = true;
      this.legendLine = new Double(-7.0D, 0.0D, 7.0D, 0.0D);
      this.drawSeriesLineAsPath = false;
   }

   public boolean getBaseShapesVisible() {
      return this.baseShapesVisible;
   }

   public void setBaseShapesVisible(boolean var1) {
      if(this.baseShapesVisible != var1) {
         this.baseShapesVisible = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public boolean getItemShapeFilled(int var1, int var2) {
      if(this.shapesFilled != null) {
         return this.shapesFilled.booleanValue();
      } else {
         Boolean var3 = this.seriesShapesFilled.getBoolean(var1);
         return var3 != null?var3.booleanValue():this.baseShapesFilled;
      }
   }

   public Boolean getShapesFilled() {
      return this.shapesFilled;
   }

   public void setShapesFilled(boolean var1) {
      this.setShapesFilled(BooleanUtilities.valueOf(var1));
   }

   public void setShapesFilled(Boolean var1) {
      this.shapesFilled = var1;
      this.fireChangeEvent();
   }

   public Boolean getSeriesShapesFilled(int var1) {
      return this.seriesShapesFilled.getBoolean(var1);
   }

   public void setSeriesShapesFilled(int var1, Boolean var2) {
      this.seriesShapesFilled.setBoolean(var1, var2);
      this.fireChangeEvent();
   }

   public boolean getBaseShapesFilled() {
      return this.baseShapesFilled;
   }

   public void setBaseShapesFilled(boolean var1) {
      this.baseShapesFilled = var1;
   }

   public boolean getPlotLines() {
      return this.plotLines;
   }

   public void setPlotLines(boolean var1) {
      if(this.plotLines != var1) {
         this.plotLines = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public UnitType getGapThresholdType() {
      return this.gapThresholdType;
   }

   public void setGapThresholdType(UnitType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'thresholdType\' argument.");
      } else {
         this.gapThresholdType = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public double getGapThreshold() {
      return this.gapThreshold;
   }

   public void setGapThreshold(double var1) {
      this.gapThreshold = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getPlotImages() {
      return this.plotImages;
   }

   public void setPlotImages(boolean var1) {
      if(this.plotImages != var1) {
         this.plotImages = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public boolean getPlotDiscontinuous() {
      return this.plotDiscontinuous;
   }

   public void setPlotDiscontinuous(boolean var1) {
      if(this.plotDiscontinuous != var1) {
         this.plotDiscontinuous = var1;
         this.fireChangeEvent();
      }

   }

   public boolean getDrawSeriesLineAsPath() {
      return this.drawSeriesLineAsPath;
   }

   public void setDrawSeriesLineAsPath(boolean var1) {
      this.drawSeriesLineAsPath = var1;
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

            Shape var10 = this.getSeriesShape(var2);
            boolean var11 = this.getItemShapeFilled(var2, 0);
            Paint var12 = this.getSeriesPaint(var2);
            Stroke var14 = this.getSeriesStroke(var2);
            var4 = new LegendItem(var6, var6, var8, var9, this.baseShapesVisible, var10, var11, var12, !var11, var12, var14, this.plotLines, this.legendLine, var14, var12);
         }

         return var4;
      }
   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      StandardXYItemRenderer$State var6 = new StandardXYItemRenderer$State(var5);
      var6.seriesPath = new GeneralPath();
      StandardXYItemRenderer$State.access$002(var6, -1);
      return var6;
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      boolean var13 = this.getItemVisible(var9, var10);
      Object var14 = null;
      EntityCollection var15 = null;
      if(var4 != null) {
         var15 = var4.getOwner().getEntityCollection();
      }

      PlotOrientation var16 = var5.getOrientation();
      Paint var17 = this.getItemPaint(var9, var10);
      Stroke var18 = this.getItemStroke(var9, var10);
      var1.setPaint(var17);
      var1.setStroke(var18);
      double var19 = var8.getXValue(var9, var10);
      double var21 = var8.getYValue(var9, var10);
      if(java.lang.Double.isNaN(var19) || java.lang.Double.isNaN(var21)) {
         var13 = false;
      }

      RectangleEdge var23 = var5.getDomainAxisEdge();
      RectangleEdge var24 = var5.getRangeAxisEdge();
      double var25 = var6.valueToJava2D(var19, var3, var23);
      double var27 = var7.valueToJava2D(var21, var3, var24);
      double var29;
      double var31;
      if(this.getPlotLines()) {
         if(this.drawSeriesLineAsPath) {
            StandardXYItemRenderer$State var39 = (StandardXYItemRenderer$State)var2;
            if(var39.getSeriesIndex() != var9) {
               var39.seriesPath.reset();
               StandardXYItemRenderer$State.access$102(var39, false);
               var39.setSeriesIndex(var9);
            }

            if(var13 && !java.lang.Double.isNaN(var25) && !java.lang.Double.isNaN(var27)) {
               float var30 = (float)var25;
               float var42 = (float)var27;
               if(var16 == PlotOrientation.HORIZONTAL) {
                  var30 = (float)var27;
                  var42 = (float)var25;
               }

               if(var39.isLastPointGood()) {
                  var39.seriesPath.lineTo(var30, var42);
               } else {
                  var39.seriesPath.moveTo(var30, var42);
               }

               var39.setLastPointGood(true);
            } else {
               var39.setLastPointGood(false);
            }

            if(var10 == var8.getItemCount(var9) - 1 && StandardXYItemRenderer$State.access$000(var39) == var9) {
               var1.setStroke(this.getSeriesStroke(var9));
               var1.setPaint(this.getSeriesPaint(var9));
               var1.draw(var39.seriesPath);
            }
         } else if(var10 != 0 && var13) {
            var29 = var8.getXValue(var9, var10 - 1);
            var31 = var8.getYValue(var9, var10 - 1);
            if(!java.lang.Double.isNaN(var29) && !java.lang.Double.isNaN(var31)) {
               boolean var33 = true;
               if(this.getPlotDiscontinuous()) {
                  int var34 = var8.getItemCount(var9);
                  double var35 = var8.getXValue(var9, 0);
                  double var37 = var8.getXValue(var9, var34 - 1);
                  if(this.gapThresholdType == UnitType.ABSOLUTE) {
                     var33 = Math.abs(var19 - var29) <= this.gapThreshold;
                  } else {
                     var33 = Math.abs(var19 - var29) <= (var37 - var35) / (double)var34 * this.getGapThreshold();
                  }
               }

               if(var33) {
                  double var46 = var6.valueToJava2D(var29, var3, var23);
                  double var36 = var7.valueToJava2D(var31, var3, var24);
                  if(java.lang.Double.isNaN(var46) || java.lang.Double.isNaN(var36) || java.lang.Double.isNaN(var25) || java.lang.Double.isNaN(var27)) {
                     return;
                  }

                  if(var16 == PlotOrientation.HORIZONTAL) {
                     var2.workingLine.setLine(var36, var46, var27, var25);
                  } else if(var16 == PlotOrientation.VERTICAL) {
                     var2.workingLine.setLine(var46, var36, var25, var27);
                  }

                  if(var2.workingLine.intersects(var3)) {
                     var1.draw(var2.workingLine);
                  }
               }
            }
         }
      }

      if(var13) {
         if(this.getBaseShapesVisible()) {
            Shape var40 = this.getItemShape(var9, var10);
            if(var16 == PlotOrientation.HORIZONTAL) {
               var40 = ShapeUtilities.createTranslatedShape(var40, var27, var25);
            } else if(var16 == PlotOrientation.VERTICAL) {
               var40 = ShapeUtilities.createTranslatedShape(var40, var25, var27);
            }

            if(var40.intersects(var3)) {
               if(this.getItemShapeFilled(var9, var10)) {
                  var1.fill(var40);
               } else {
                  var1.draw(var40);
               }
            }

            var14 = var40;
         }

         if(this.getPlotImages()) {
            Image var41 = this.getImage(var5, var9, var10, var25, var27);
            if(var41 != null) {
               Point var43 = this.getImageHotspot(var5, var9, var10, var25, var27, var41);
               var1.drawImage(var41, (int)(var25 - var43.getX()), (int)(var27 - var43.getY()), (ImageObserver)null);
               var14 = new java.awt.geom.Rectangle2D.Double(var25 - var43.getX(), var27 - var43.getY(), (double)var41.getWidth((ImageObserver)null), (double)var41.getHeight((ImageObserver)null));
            }
         }

         if(this.isItemLabelVisible(var9, var10)) {
            var29 = var25;
            var31 = var27;
            if(var16 == PlotOrientation.HORIZONTAL) {
               var29 = var27;
               var31 = var25;
            }

            this.drawItemLabel(var1, var16, var8, var9, var10, var29, var31, var21 < 0.0D);
         }

         int var45 = var5.getDomainAxisIndex(var6);
         int var44 = var5.getRangeAxisIndex(var7);
         this.updateCrosshairValues(var11, var19, var21, var45, var44, var25, var27, var16);
         if(var15 != null) {
            this.addEntity(var15, (Shape)var14, var8, var9, var10, var25, var27);
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardXYItemRenderer)) {
         return false;
      } else {
         StandardXYItemRenderer var2 = (StandardXYItemRenderer)var1;
         return this.baseShapesVisible != var2.baseShapesVisible?false:(this.plotLines != var2.plotLines?false:(this.plotImages != var2.plotImages?false:(this.plotDiscontinuous != var2.plotDiscontinuous?false:(this.gapThresholdType != var2.gapThresholdType?false:(this.gapThreshold != var2.gapThreshold?false:(!ObjectUtilities.equal(this.shapesFilled, var2.shapesFilled)?false:(!this.seriesShapesFilled.equals(var2.seriesShapesFilled)?false:(this.baseShapesFilled != var2.baseShapesFilled?false:(this.drawSeriesLineAsPath != var2.drawSeriesLineAsPath?false:(!ShapeUtilities.equal(this.legendLine, var2.legendLine)?false:super.equals(var1)))))))))));
      }
   }

   public Object clone() {
      StandardXYItemRenderer var1 = (StandardXYItemRenderer)super.clone();
      var1.seriesShapesFilled = (BooleanList)this.seriesShapesFilled.clone();
      var1.legendLine = ShapeUtilities.clone(this.legendLine);
      return var1;
   }

   protected Image getImage(Plot var1, int var2, int var3, double var4, double var6) {
      return null;
   }

   protected Point getImageHotspot(Plot var1, int var2, int var3, double var4, double var6, Image var8) {
      int var9 = var8.getHeight((ImageObserver)null);
      int var10 = var8.getWidth((ImageObserver)null);
      return new Point(var10 / 2, var9 / 2);
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
