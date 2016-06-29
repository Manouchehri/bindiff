package org.jfree.chart.renderer.category;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;
import org.jfree.chart.renderer.OutlierListCollection;
import org.jfree.chart.renderer.category.AbstractCategoryItemRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class BoxAndWhiskerRenderer extends AbstractCategoryItemRenderer implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 632027470694481177L;
   private transient Paint artifactPaint;
   private boolean fillBox;
   private double itemMargin;

   public BoxAndWhiskerRenderer() {
      this.artifactPaint = Color.black;
      this.fillBox = true;
      this.itemMargin = 0.2D;
   }

   public Paint getArtifactPaint() {
      return this.artifactPaint;
   }

   public void setArtifactPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.artifactPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public boolean getFillBox() {
      return this.fillBox;
   }

   public void setFillBox(boolean var1) {
      this.fillBox = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public double getItemMargin() {
      return this.itemMargin;
   }

   public void setItemMargin(double var1) {
      this.itemMargin = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public LegendItem getLegendItem(int var1, int var2) {
      CategoryPlot var3 = this.getPlot();
      if(var3 == null) {
         return null;
      } else {
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

         Double var9 = new Double(-4.0D, -4.0D, 8.0D, 8.0D);
         Paint var10 = this.getSeriesPaint(var2);
         Paint var11 = this.getSeriesOutlinePaint(var2);
         Stroke var12 = this.getSeriesOutlineStroke(var2);
         return new LegendItem(var5, var5, var7, var8, var9, var10, var12, var11);
      }
   }

   public CategoryItemRendererState initialise(Graphics2D var1, Rectangle2D var2, CategoryPlot var3, int var4, PlotRenderingInfo var5) {
      CategoryItemRendererState var6 = super.initialise(var1, var2, var3, var4, var5);
      CategoryAxis var7 = this.getDomainAxis(var3, var4);
      CategoryDataset var8 = var3.getDataset(var4);
      if(var8 != null) {
         int var9 = var8.getColumnCount();
         int var10 = var8.getRowCount();
         double var11 = 0.0D;
         PlotOrientation var13 = var3.getOrientation();
         if(var13 == PlotOrientation.HORIZONTAL) {
            var11 = var2.getHeight();
         } else if(var13 == PlotOrientation.VERTICAL) {
            var11 = var2.getWidth();
         }

         double var14 = 0.0D;
         double var16 = 0.0D;
         if(var9 > 1) {
            var14 = var7.getCategoryMargin();
         }

         if(var10 > 1) {
            var16 = this.getItemMargin();
         }

         double var18 = var11 * (1.0D - var7.getLowerMargin() - var7.getUpperMargin() - var14 - var16);
         if(var10 * var9 > 0) {
            var6.setBarWidth(var18 / (double)(var8.getColumnCount() * var8.getRowCount()));
         } else {
            var6.setBarWidth(var18);
         }
      }

      return var6;
   }

   public void drawItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9, int var10) {
      if(!(var7 instanceof BoxAndWhiskerCategoryDataset)) {
         throw new IllegalArgumentException("BoxAndWhiskerRenderer.drawItem() : the data should be of type BoxAndWhiskerCategoryDataset only.");
      } else {
         PlotOrientation var11 = var4.getOrientation();
         if(var11 == PlotOrientation.HORIZONTAL) {
            this.drawHorizontalItem(var1, var2, var3, var4, var5, var6, var7, var8, var9);
         } else if(var11 == PlotOrientation.VERTICAL) {
            this.drawVerticalItem(var1, var2, var3, var4, var5, var6, var7, var8, var9);
         }

      }
   }

   public void drawHorizontalItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9) {
      BoxAndWhiskerCategoryDataset var10 = (BoxAndWhiskerCategoryDataset)var7;
      double var11 = var5.getCategoryEnd(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
      double var13 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
      double var15 = Math.abs(var11 - var13);
      int var19 = this.getRowCount();
      int var20 = this.getColumnCount();
      double var17;
      double var21;
      if(var19 > 1) {
         var21 = var3.getWidth() * this.getItemMargin() / (double)(var20 * (var19 - 1));
         double var23 = var2.getBarWidth() * (double)var19 + var21 * (double)(var19 - 1);
         double var25 = (var15 - var23) / 2.0D;
         var17 = var13 + var25 + (double)var8 * (var2.getBarWidth() + var21);
      } else {
         var21 = (var15 - var2.getBarWidth()) / 2.0D;
         var17 = var13 + var21;
      }

      Paint var39 = this.getItemPaint(var8, var9);
      if(var39 != null) {
         var1.setPaint(var39);
      }

      Stroke var22 = this.getItemStroke(var8, var9);
      var1.setStroke(var22);
      RectangleEdge var40 = var4.getRangeAxisEdge();
      Number var24 = var10.getQ1Value(var8, var9);
      Number var41 = var10.getQ3Value(var8, var9);
      Number var26 = var10.getMaxRegularValue(var8, var9);
      Number var27 = var10.getMinRegularValue(var8, var9);
      Double var28 = null;
      double var29;
      double var33;
      if(var24 != null && var41 != null && var26 != null && var27 != null) {
         var29 = var6.valueToJava2D(var24.doubleValue(), var3, var40);
         double var31 = var6.valueToJava2D(var41.doubleValue(), var3, var40);
         var33 = var6.valueToJava2D(var26.doubleValue(), var3, var40);
         double var35 = var6.valueToJava2D(var27.doubleValue(), var3, var40);
         double var37 = var17 + var2.getBarWidth() / 2.0D;
         var1.draw(new java.awt.geom.Line2D.Double(var33, var37, var31, var37));
         var1.draw(new java.awt.geom.Line2D.Double(var33, var17, var33, var17 + var2.getBarWidth()));
         var1.draw(new java.awt.geom.Line2D.Double(var35, var37, var29, var37));
         var1.draw(new java.awt.geom.Line2D.Double(var35, var17, var35, var17 + var2.getBarWidth()));
         var28 = new Double(Math.min(var29, var31), var17, Math.abs(var29 - var31), var2.getBarWidth());
         if(this.fillBox) {
            var1.fill(var28);
         }

         var1.draw(var28);
      }

      var1.setPaint(this.artifactPaint);
      var29 = 0.0D;
      Number var42 = var10.getMeanValue(var8, var9);
      if(var42 != null) {
         double var32 = var6.valueToJava2D(var42.doubleValue(), var3, var40);
         var29 = var2.getBarWidth() / 4.0D;
         java.awt.geom.Ellipse2D.Double var34 = new java.awt.geom.Ellipse2D.Double(var32 - var29, var17 + var29, var29 * 2.0D, var29 * 2.0D);
         var1.fill(var34);
         var1.draw(var34);
      }

      Number var43 = var10.getMedianValue(var8, var9);
      if(var43 != null) {
         var33 = var6.valueToJava2D(var43.doubleValue(), var3, var40);
         var1.draw(new java.awt.geom.Line2D.Double(var33, var17, var33, var17 + var2.getBarWidth()));
      }

      if(var2.getInfo() != null && var28 != null) {
         EntityCollection var44 = var2.getEntityCollection();
         if(var44 != null) {
            String var45 = null;
            CategoryToolTipGenerator var46 = this.getToolTipGenerator(var8, var9);
            if(var46 != null) {
               var45 = var46.generateToolTip(var7, var8, var9);
            }

            String var36 = null;
            if(this.getItemURLGenerator(var8, var9) != null) {
               var36 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
            }

            CategoryItemEntity var47 = new CategoryItemEntity(var28, var45, var36, var7, var8, var7.getColumnKey(var9), var9);
            var44.add(var47);
         }
      }

   }

   public void drawVerticalItem(Graphics2D var1, CategoryItemRendererState var2, Rectangle2D var3, CategoryPlot var4, CategoryAxis var5, ValueAxis var6, CategoryDataset var7, int var8, int var9) {
      BoxAndWhiskerCategoryDataset var10 = (BoxAndWhiskerCategoryDataset)var7;
      double var11 = var5.getCategoryEnd(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
      double var13 = var5.getCategoryStart(var9, this.getColumnCount(), var3, var4.getDomainAxisEdge());
      double var15 = var11 - var13;
      int var19 = this.getRowCount();
      int var20 = this.getColumnCount();
      double var17;
      double var21;
      double var23;
      if(var19 > 1) {
         var21 = var3.getWidth() * this.getItemMargin() / (double)(var20 * (var19 - 1));
         var23 = var2.getBarWidth() * (double)var19 + var21 * (double)(var19 - 1);
         double var25 = (var15 - var23) / 2.0D;
         var17 = var13 + var25 + (double)var8 * (var2.getBarWidth() + var21);
      } else {
         var21 = (var15 - var2.getBarWidth()) / 2.0D;
         var17 = var13 + var21;
      }

      var21 = 0.0D;
      Paint var63 = this.getItemPaint(var8, var9);
      if(var63 != null) {
         var1.setPaint(var63);
      }

      Stroke var26 = this.getItemStroke(var8, var9);
      var1.setStroke(var26);
      double var27 = 0.0D;
      RectangleEdge var29 = var4.getRangeAxisEdge();
      Number var30 = var10.getQ1Value(var8, var9);
      Number var31 = var10.getQ3Value(var8, var9);
      Number var32 = var10.getMaxRegularValue(var8, var9);
      Number var33 = var10.getMinRegularValue(var8, var9);
      Double var34 = null;
      double var37;
      double var39;
      double var41;
      if(var30 != null && var31 != null && var32 != null && var33 != null) {
         double var35 = var6.valueToJava2D(var30.doubleValue(), var3, var29);
         var37 = var6.valueToJava2D(var31.doubleValue(), var3, var29);
         var39 = var6.valueToJava2D(var32.doubleValue(), var3, var29);
         var41 = var6.valueToJava2D(var33.doubleValue(), var3, var29);
         double var43 = var17 + var2.getBarWidth() / 2.0D;
         var1.draw(new java.awt.geom.Line2D.Double(var43, var39, var43, var37));
         var1.draw(new java.awt.geom.Line2D.Double(var17, var39, var17 + var2.getBarWidth(), var39));
         var1.draw(new java.awt.geom.Line2D.Double(var43, var41, var43, var35));
         var1.draw(new java.awt.geom.Line2D.Double(var17, var41, var17 + var2.getBarWidth(), var41));
         var34 = new Double(var17, Math.min(var35, var37), var2.getBarWidth(), Math.abs(var35 - var37));
         if(this.fillBox) {
            var1.fill(var34);
         }

         var1.draw(var34);
      }

      var1.setPaint(this.artifactPaint);
      Number var64 = var10.getMeanValue(var8, var9);
      if(var64 != null) {
         var21 = var6.valueToJava2D(var64.doubleValue(), var3, var29);
         var27 = var2.getBarWidth() / 4.0D;
         java.awt.geom.Ellipse2D.Double var36 = new java.awt.geom.Ellipse2D.Double(var17 + var27, var21 - var27, var27 * 2.0D, var27 * 2.0D);
         var1.fill(var36);
         var1.draw(var36);
      }

      Number var65 = var10.getMedianValue(var8, var9);
      if(var65 != null) {
         var37 = var6.valueToJava2D(var65.doubleValue(), var3, var29);
         var1.draw(new java.awt.geom.Line2D.Double(var17, var37, var17 + var2.getBarWidth(), var37));
      }

      var37 = var6.valueToJava2D(var6.getUpperBound(), var3, var29) + var27;
      var39 = var6.valueToJava2D(var6.getLowerBound(), var3, var29) - var27;
      var1.setPaint(var63);
      var41 = var2.getBarWidth() / 3.0D;
      ArrayList var53 = new ArrayList();
      OutlierListCollection var44 = new OutlierListCollection();
      List var45 = var10.getOutliers(var8, var9);
      if(var45 != null) {
         for(int var46 = 0; var46 < var45.size(); ++var46) {
            double var47 = ((Number)var45.get(var46)).doubleValue();
            Number var49 = var10.getMinOutlier(var8, var9);
            Number var50 = var10.getMaxOutlier(var8, var9);
            Number var51 = var10.getMinRegularValue(var8, var9);
            Number var52 = var10.getMaxRegularValue(var8, var9);
            if(var47 > var50.doubleValue()) {
               var44.setHighFarOut(true);
            } else if(var47 < var49.doubleValue()) {
               var44.setLowFarOut(true);
            } else if(var47 > var52.doubleValue()) {
               var23 = var6.valueToJava2D(var47, var3, var29);
               var53.add(new Outlier(var17 + var2.getBarWidth() / 2.0D, var23, var41));
            } else if(var47 < var51.doubleValue()) {
               var23 = var6.valueToJava2D(var47, var3, var29);
               var53.add(new Outlier(var17 + var2.getBarWidth() / 2.0D, var23, var41));
            }

            Collections.sort(var53);
         }

         Iterator var54 = var53.iterator();

         while(var54.hasNext()) {
            Outlier var56 = (Outlier)var54.next();
            var44.add(var56);
         }

         var54 = var44.iterator();

         while(var54.hasNext()) {
            OutlierList var57 = (OutlierList)var54.next();
            Outlier var48 = var57.getAveragedOutlier();
            Point2D var60 = var48.getPoint();
            if(var57.isMultiple()) {
               this.drawMultipleEllipse(var60, var2.getBarWidth(), var41, var1);
            } else {
               this.drawEllipse(var60, var41, var1);
            }
         }

         if(var44.isHighFarOut()) {
            this.drawHighFarOut(var27 / 2.0D, var1, var17 + var2.getBarWidth() / 2.0D, var37);
         }

         if(var44.isLowFarOut()) {
            this.drawLowFarOut(var27 / 2.0D, var1, var17 + var2.getBarWidth() / 2.0D, var39);
         }
      }

      if(var2.getInfo() != null && var34 != null) {
         EntityCollection var55 = var2.getEntityCollection();
         if(var55 != null) {
            String var58 = null;
            CategoryToolTipGenerator var59 = this.getToolTipGenerator(var8, var9);
            if(var59 != null) {
               var58 = var59.generateToolTip(var7, var8, var9);
            }

            String var61 = null;
            if(this.getItemURLGenerator(var8, var9) != null) {
               var61 = this.getItemURLGenerator(var8, var9).generateURL(var7, var8, var9);
            }

            CategoryItemEntity var62 = new CategoryItemEntity(var34, var58, var61, var7, var8, var7.getColumnKey(var9), var9);
            var55.add(var62);
         }
      }

   }

   private void drawEllipse(Point2D var1, double var2, Graphics2D var4) {
      java.awt.geom.Ellipse2D.Double var5 = new java.awt.geom.Ellipse2D.Double(var1.getX() + var2 / 2.0D, var1.getY(), var2, var2);
      var4.draw(var5);
   }

   private void drawMultipleEllipse(Point2D var1, double var2, double var4, Graphics2D var6) {
      java.awt.geom.Ellipse2D.Double var7 = new java.awt.geom.Ellipse2D.Double(var1.getX() - var2 / 2.0D + var4, var1.getY(), var4, var4);
      java.awt.geom.Ellipse2D.Double var8 = new java.awt.geom.Ellipse2D.Double(var1.getX() + var2 / 2.0D, var1.getY(), var4, var4);
      var6.draw(var7);
      var6.draw(var8);
   }

   private void drawHighFarOut(double var1, Graphics2D var3, double var4, double var6) {
      double var8 = var1 * 2.0D;
      var3.draw(new java.awt.geom.Line2D.Double(var4 - var8, var6 + var8, var4 + var8, var6 + var8));
      var3.draw(new java.awt.geom.Line2D.Double(var4 - var8, var6 + var8, var4, var6));
      var3.draw(new java.awt.geom.Line2D.Double(var4 + var8, var6 + var8, var4, var6));
   }

   private void drawLowFarOut(double var1, Graphics2D var3, double var4, double var6) {
      double var8 = var1 * 2.0D;
      var3.draw(new java.awt.geom.Line2D.Double(var4 - var8, var6 - var8, var4 + var8, var6 - var8));
      var3.draw(new java.awt.geom.Line2D.Double(var4 - var8, var6 - var8, var4, var6));
      var3.draw(new java.awt.geom.Line2D.Double(var4 + var8, var6 - var8, var4, var6));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof BoxAndWhiskerRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         BoxAndWhiskerRenderer var2 = (BoxAndWhiskerRenderer)var1;
         return !PaintUtilities.equal(this.artifactPaint, var2.artifactPaint)?false:(this.fillBox != var2.fillBox?false:this.itemMargin == var2.itemMargin);
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.artifactPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.artifactPaint = SerialUtilities.readPaint(var1);
   }
}
