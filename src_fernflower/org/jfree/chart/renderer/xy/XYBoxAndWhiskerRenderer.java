package org.jfree.chart.renderer.xy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.BoxAndWhiskerXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;
import org.jfree.chart.renderer.OutlierListCollection;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class XYBoxAndWhiskerRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = -8020170108532232324L;
   private double boxWidth;
   private transient Paint boxPaint;
   private boolean fillBox;
   private transient Paint artifactPaint;

   public XYBoxAndWhiskerRenderer() {
      this(-1.0D);
   }

   public XYBoxAndWhiskerRenderer(double var1) {
      this.artifactPaint = Color.black;
      this.boxWidth = var1;
      this.boxPaint = Color.green;
      this.fillBox = true;
      this.setToolTipGenerator(new BoxAndWhiskerXYToolTipGenerator());
   }

   public double getBoxWidth() {
      return this.boxWidth;
   }

   public void setBoxWidth(double var1) {
      if(var1 != this.boxWidth) {
         this.boxWidth = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public Paint getBoxPaint() {
      return this.boxPaint;
   }

   public void setBoxPaint(Paint var1) {
      this.boxPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean getFillBox() {
      return this.fillBox;
   }

   public void setFillBox(boolean var1) {
      this.fillBox = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Paint getArtifactPaint() {
      return this.artifactPaint;
   }

   public void setArtifactPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'artifactPaint\' argument.");
      } else {
         this.artifactPaint = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      PlotOrientation var13 = var5.getOrientation();
      if(var13 == PlotOrientation.HORIZONTAL) {
         this.drawHorizontalItem(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
      } else if(var13 == PlotOrientation.VERTICAL) {
         this.drawVerticalItem(var1, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
      }

   }

   public void drawHorizontalItem(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, XYPlot var4, ValueAxis var5, ValueAxis var6, XYDataset var7, int var8, int var9, CrosshairState var10, int var11) {
      EntityCollection var12 = null;
      if(var3 != null) {
         var12 = var3.getOwner().getEntityCollection();
      }

      BoxAndWhiskerXYDataset var13 = (BoxAndWhiskerXYDataset)var7;
      Number var14 = var13.getX(var8, var9);
      Number var15 = var13.getMaxRegularValue(var8, var9);
      Number var16 = var13.getMinRegularValue(var8, var9);
      Number var17 = var13.getMedianValue(var8, var9);
      Number var18 = var13.getMeanValue(var8, var9);
      Number var19 = var13.getQ1Value(var8, var9);
      Number var20 = var13.getQ3Value(var8, var9);
      double var21 = var5.valueToJava2D(var14.doubleValue(), var2, var4.getDomainAxisEdge());
      RectangleEdge var23 = var4.getRangeAxisEdge();
      double var24 = var6.valueToJava2D(var15.doubleValue(), var2, var23);
      double var26 = var6.valueToJava2D(var16.doubleValue(), var2, var23);
      double var28 = var6.valueToJava2D(var17.doubleValue(), var2, var23);
      double var30 = 0.0D;
      if(var18 != null) {
         var30 = var6.valueToJava2D(var18.doubleValue(), var2, var23);
      }

      double var32 = var6.valueToJava2D(var19.doubleValue(), var2, var23);
      double var34 = var6.valueToJava2D(var20.doubleValue(), var2, var23);
      double var36 = this.getBoxWidth();
      double var38 = var36;
      double var40 = var2.getHeight();
      double var42 = 0.1D;
      double var44 = var40 * var42;
      if(var36 <= 0.0D) {
         int var46 = var13.getItemCount(var8);
         var36 = var40 / (double)var46 * 4.5D / 7.0D;
         if(var36 < 3.0D) {
            var38 = 3.0D;
         } else if(var36 > var44) {
            var38 = var44;
         } else {
            var38 = var36;
         }
      }

      Paint var53 = this.getBoxPaint();
      if(var53 != null) {
         var1.setPaint(var53);
      }

      Stroke var47 = this.getItemStroke(var8, var9);
      var1.setStroke(var47);
      var1.draw(new Double(var24, var21, var34, var21));
      var1.draw(new Double(var24, var21 - var38 / 2.0D, var24, var21 + var38 / 2.0D));
      var1.draw(new Double(var26, var21, var32, var21));
      var1.draw(new Double(var26, var21 - var38 / 2.0D, var26, var21 + var38 / 2.0D));
      java.awt.geom.Rectangle2D.Double var48 = null;
      if(var32 < var34) {
         var48 = new java.awt.geom.Rectangle2D.Double(var32, var21 - var38 / 2.0D, var34 - var32, var38);
      } else {
         var48 = new java.awt.geom.Rectangle2D.Double(var34, var21 - var38 / 2.0D, var32 - var34, var38);
      }

      if(this.getBoxPaint() != null) {
         var1.setPaint(this.getBoxPaint());
      }

      if(this.fillBox) {
         var1.fill(var48);
      }

      var1.draw(var48);
      var1.setPaint(this.getArtifactPaint());
      var1.draw(new Double(var28, var21 - var38 / 2.0D, var28, var21 + var38 / 2.0D));
      if(var18 != null) {
         double var49 = var38 / 4.0D;
         java.awt.geom.Ellipse2D.Double var51 = new java.awt.geom.Ellipse2D.Double(var30 - var49, var21 - var49, var49 * 2.0D, var49 * 2.0D);
         var1.fill(var51);
         var1.draw(var51);
      }

      if(var12 != null) {
         String var54 = null;
         XYToolTipGenerator var50 = this.getToolTipGenerator(var8, var9);
         if(var50 != null) {
            var54 = var50.generateToolTip(var7, var8, var9);
         }

         String var55 = null;
         if(this.getURLGenerator() != null) {
            var55 = this.getURLGenerator().generateURL(var7, var8, var9);
         }

         XYItemEntity var52 = new XYItemEntity(var48, var7, var8, var9, var54, var55);
         var12.add(var52);
      }

   }

   public void drawVerticalItem(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, XYPlot var4, ValueAxis var5, ValueAxis var6, XYDataset var7, int var8, int var9, CrosshairState var10, int var11) {
      EntityCollection var12 = null;
      if(var3 != null) {
         var12 = var3.getOwner().getEntityCollection();
      }

      BoxAndWhiskerXYDataset var13 = (BoxAndWhiskerXYDataset)var7;
      Number var14 = var13.getX(var8, var9);
      Number var15 = var13.getMaxRegularValue(var8, var9);
      Number var16 = var13.getMinRegularValue(var8, var9);
      Number var17 = var13.getMedianValue(var8, var9);
      Number var18 = var13.getMeanValue(var8, var9);
      Number var19 = var13.getQ1Value(var8, var9);
      Number var20 = var13.getQ3Value(var8, var9);
      List var21 = var13.getOutliers(var8, var9);
      double var22 = var5.valueToJava2D(var14.doubleValue(), var2, var4.getDomainAxisEdge());
      RectangleEdge var24 = var4.getRangeAxisEdge();
      double var25 = var6.valueToJava2D(var15.doubleValue(), var2, var24);
      double var27 = var6.valueToJava2D(var16.doubleValue(), var2, var24);
      double var29 = var6.valueToJava2D(var17.doubleValue(), var2, var24);
      double var31 = 0.0D;
      if(var18 != null) {
         var31 = var6.valueToJava2D(var18.doubleValue(), var2, var24);
      }

      double var33 = var6.valueToJava2D(var19.doubleValue(), var2, var24);
      double var35 = var6.valueToJava2D(var20.doubleValue(), var2, var24);
      double var39 = this.getBoxWidth();
      double var41 = var39;
      double var43 = var2.getMaxX() - var2.getMinX();
      double var45 = 0.1D;
      double var47 = var43 * var45;
      if(var39 <= 0.0D) {
         int var49 = var13.getItemCount(var8);
         var39 = var43 / (double)var49 * 4.5D / 7.0D;
         if(var39 < 3.0D) {
            var41 = 3.0D;
         } else if(var39 > var47) {
            var41 = var47;
         } else {
            var41 = var39;
         }
      }

      Paint var66 = this.getBoxPaint();
      if(var66 != null) {
         var1.setPaint(var66);
      }

      Stroke var50 = this.getItemStroke(var8, var9);
      var1.setStroke(var50);
      var1.draw(new Double(var22, var25, var22, var35));
      var1.draw(new Double(var22 - var41 / 2.0D, var25, var22 + var41 / 2.0D, var25));
      var1.draw(new Double(var22, var27, var22, var33));
      var1.draw(new Double(var22 - var41 / 2.0D, var27, var22 + var41 / 2.0D, var27));
      java.awt.geom.Rectangle2D.Double var51 = null;
      if(var33 > var35) {
         var51 = new java.awt.geom.Rectangle2D.Double(var22 - var41 / 2.0D, var35, var41, var33 - var35);
      } else {
         var51 = new java.awt.geom.Rectangle2D.Double(var22 - var41 / 2.0D, var33, var41, var35 - var33);
      }

      if(this.fillBox) {
         var1.fill(var51);
      }

      var1.draw(var51);
      var1.setPaint(this.getArtifactPaint());
      var1.draw(new Double(var22 - var41 / 2.0D, var29, var22 + var41 / 2.0D, var29));
      double var52 = 0.0D;
      double var54 = var41 / 3.0D;
      if(var18 != null) {
         var52 = var41 / 4.0D;
         java.awt.geom.Ellipse2D.Double var56 = new java.awt.geom.Ellipse2D.Double(var22 - var52, var31 - var52, var52 * 2.0D, var52 * 2.0D);
         var1.fill(var56);
         var1.draw(var56);
      }

      ArrayList var67 = new ArrayList();
      OutlierListCollection var57 = new OutlierListCollection();

      for(int var58 = 0; var58 < var21.size(); ++var58) {
         double var59 = ((Number)var21.get(var58)).doubleValue();
         if(var59 > var13.getMaxOutlier(var8, var9).doubleValue()) {
            var57.setHighFarOut(true);
         } else if(var59 < var13.getMinOutlier(var8, var9).doubleValue()) {
            var57.setLowFarOut(true);
         } else {
            double var37;
            if(var59 > var13.getMaxRegularValue(var8, var9).doubleValue()) {
               var37 = var6.valueToJava2D(var59, var2, var24);
               var67.add(new Outlier(var22, var37, var54));
            } else if(var59 < var13.getMinRegularValue(var8, var9).doubleValue()) {
               var37 = var6.valueToJava2D(var59, var2, var24);
               var67.add(new Outlier(var22, var37, var54));
            }
         }

         Collections.sort(var67);
      }

      Iterator var68 = var67.iterator();

      while(var68.hasNext()) {
         Outlier var70 = (Outlier)var68.next();
         var57.add(var70);
      }

      double var69 = var6.valueToJava2D(var6.getUpperBound(), var2, var24) + var52;
      double var60 = var6.valueToJava2D(var6.getLowerBound(), var2, var24) - var52;
      Iterator var62 = var57.iterator();

      while(var62.hasNext()) {
         OutlierList var63 = (OutlierList)var62.next();
         Outlier var64 = var63.getAveragedOutlier();
         Point2D var65 = var64.getPoint();
         if(var63.isMultiple()) {
            this.drawMultipleEllipse(var65, var41, var54, var1);
         } else {
            this.drawEllipse(var65, var54, var1);
         }
      }

      if(var57.isHighFarOut()) {
         this.drawHighFarOut(var52, var1, var22, var69);
      }

      if(var57.isLowFarOut()) {
         this.drawLowFarOut(var52, var1, var22, var60);
      }

      if(var12 != null) {
         String var71 = null;
         XYToolTipGenerator var72 = this.getToolTipGenerator(var8, var9);
         if(var72 != null) {
            var71 = var72.generateToolTip(var7, var8, var9);
         }

         String var73 = null;
         if(this.getURLGenerator() != null) {
            var73 = this.getURLGenerator().generateURL(var7, var8, var9);
         }

         XYItemEntity var74 = new XYItemEntity(var51, var7, var8, var9, var71, var73);
         var12.add(var74);
      }

   }

   protected void drawEllipse(Point2D var1, double var2, Graphics2D var4) {
      java.awt.geom.Ellipse2D.Double var5 = new java.awt.geom.Ellipse2D.Double(var1.getX() + var2 / 2.0D, var1.getY(), var2, var2);
      var4.draw(var5);
   }

   protected void drawMultipleEllipse(Point2D var1, double var2, double var4, Graphics2D var6) {
      java.awt.geom.Ellipse2D.Double var7 = new java.awt.geom.Ellipse2D.Double(var1.getX() - var2 / 2.0D + var4, var1.getY(), var4, var4);
      java.awt.geom.Ellipse2D.Double var8 = new java.awt.geom.Ellipse2D.Double(var1.getX() + var2 / 2.0D, var1.getY(), var4, var4);
      var6.draw(var7);
      var6.draw(var8);
   }

   protected void drawHighFarOut(double var1, Graphics2D var3, double var4, double var6) {
      double var8 = var1 * 2.0D;
      var3.draw(new Double(var4 - var8, var6 + var8, var4 + var8, var6 + var8));
      var3.draw(new Double(var4 - var8, var6 + var8, var4, var6));
      var3.draw(new Double(var4 + var8, var6 + var8, var4, var6));
   }

   protected void drawLowFarOut(double var1, Graphics2D var3, double var4, double var6) {
      double var8 = var1 * 2.0D;
      var3.draw(new Double(var4 - var8, var6 - var8, var4 + var8, var6 - var8));
      var3.draw(new Double(var4 - var8, var6 - var8, var4, var6));
      var3.draw(new Double(var4 + var8, var6 - var8, var4, var6));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof XYBoxAndWhiskerRenderer)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         XYBoxAndWhiskerRenderer var2 = (XYBoxAndWhiskerRenderer)var1;
         return this.boxWidth != var2.getBoxWidth()?false:(!PaintUtilities.equal(this.boxPaint, var2.boxPaint)?false:(!PaintUtilities.equal(this.artifactPaint, var2.artifactPaint)?false:this.fillBox == var2.fillBox));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.boxPaint, var1);
      SerialUtilities.writePaint(this.artifactPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.boxPaint = SerialUtilities.readPaint(var1);
      this.artifactPaint = SerialUtilities.readPaint(var1);
   }

   public Object clone() {
      return super.clone();
   }
}
