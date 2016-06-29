package org.jfree.chart.renderer.xy;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.AbstractXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;
import org.jfree.util.PublicCloneable;

public class CandlestickRenderer extends AbstractXYItemRenderer implements Serializable, Cloneable, XYItemRenderer, PublicCloneable {
   private static final long serialVersionUID = 50390395841817121L;
   public static final int WIDTHMETHOD_AVERAGE = 0;
   public static final int WIDTHMETHOD_SMALLEST = 1;
   public static final int WIDTHMETHOD_INTERVALDATA = 2;
   private int autoWidthMethod;
   private double autoWidthFactor;
   private double autoWidthGap;
   private double candleWidth;
   private double maxCandleWidthInMilliseconds;
   private double maxCandleWidth;
   private transient Paint upPaint;
   private transient Paint downPaint;
   private boolean drawVolume;
   private transient double maxVolume;
   private boolean useOutlinePaint;

   public CandlestickRenderer() {
      this(-1.0D);
   }

   public CandlestickRenderer(double var1) {
      this(var1, true, new HighLowItemLabelGenerator());
   }

   public CandlestickRenderer(double var1, boolean var3, XYToolTipGenerator var4) {
      this.autoWidthMethod = 0;
      this.autoWidthFactor = 0.6428571428571429D;
      this.autoWidthGap = 0.0D;
      this.maxCandleWidthInMilliseconds = 7.2E7D;
      this.setToolTipGenerator(var4);
      this.candleWidth = var1;
      this.drawVolume = var3;
      this.upPaint = Color.green;
      this.downPaint = Color.red;
      this.useOutlinePaint = false;
   }

   public double getCandleWidth() {
      return this.candleWidth;
   }

   public void setCandleWidth(double var1) {
      if(var1 != this.candleWidth) {
         this.candleWidth = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public double getMaxCandleWidthInMilliseconds() {
      return this.maxCandleWidthInMilliseconds;
   }

   public void setMaxCandleWidthInMilliseconds(double var1) {
      this.maxCandleWidthInMilliseconds = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public int getAutoWidthMethod() {
      return this.autoWidthMethod;
   }

   public void setAutoWidthMethod(int var1) {
      if(this.autoWidthMethod != var1) {
         this.autoWidthMethod = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public double getAutoWidthFactor() {
      return this.autoWidthFactor;
   }

   public void setAutoWidthFactor(double var1) {
      if(this.autoWidthFactor != var1) {
         this.autoWidthFactor = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public double getAutoWidthGap() {
      return this.autoWidthGap;
   }

   public void setAutoWidthGap(double var1) {
      if(this.autoWidthGap != var1) {
         this.autoWidthGap = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public Paint getUpPaint() {
      return this.upPaint;
   }

   public void setUpPaint(Paint var1) {
      this.upPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public Paint getDownPaint() {
      return this.downPaint;
   }

   public void setDownPaint(Paint var1) {
      this.downPaint = var1;
      this.notifyListeners(new RendererChangeEvent(this));
   }

   public boolean drawVolume() {
      return this.drawVolume;
   }

   public boolean getDrawVolume() {
      return this.drawVolume;
   }

   public void setDrawVolume(boolean var1) {
      if(this.drawVolume != var1) {
         this.drawVolume = var1;
         this.notifyListeners(new RendererChangeEvent(this));
      }

   }

   public boolean getUseOutlinePaint() {
      return this.useOutlinePaint;
   }

   public void setUseOutlinePaint(boolean var1) {
      if(this.useOutlinePaint != var1) {
         this.useOutlinePaint = var1;
         this.fireChangeEvent();
      }

   }

   public XYItemRendererState initialise(Graphics2D var1, Rectangle2D var2, XYPlot var3, XYDataset var4, PlotRenderingInfo var5) {
      ValueAxis var6 = var3.getDomainAxis();
      double var7 = var6.getLowerBound();
      double var9 = var7 + this.maxCandleWidthInMilliseconds;
      RectangleEdge var11 = var3.getDomainAxisEdge();
      double var12 = var6.valueToJava2D(var7, var2, var11);
      double var14 = var6.valueToJava2D(var9, var2, var11);
      this.maxCandleWidth = Math.abs(var14 - var12);
      if(this.drawVolume) {
         OHLCDataset var16 = (OHLCDataset)var4;
         this.maxVolume = 0.0D;

         for(int var17 = 0; var17 < var16.getSeriesCount(); ++var17) {
            for(int var18 = 0; var18 < var16.getItemCount(var17); ++var18) {
               double var19 = var16.getVolumeValue(var17, var18);
               if(var19 > this.maxVolume) {
                  this.maxVolume = var19;
               }
            }
         }
      }

      return new XYItemRendererState(var5);
   }

   public void drawItem(Graphics2D var1, XYItemRendererState var2, Rectangle2D var3, PlotRenderingInfo var4, XYPlot var5, ValueAxis var6, ValueAxis var7, XYDataset var8, int var9, int var10, CrosshairState var11, int var12) {
      PlotOrientation var14 = var5.getOrientation();
      boolean var13;
      if(var14 == PlotOrientation.HORIZONTAL) {
         var13 = true;
      } else {
         if(var14 != PlotOrientation.VERTICAL) {
            return;
         }

         var13 = false;
      }

      EntityCollection var15 = null;
      if(var4 != null) {
         var15 = var4.getOwner().getEntityCollection();
      }

      OHLCDataset var16 = (OHLCDataset)var8;
      double var17 = var16.getXValue(var9, var10);
      double var19 = var16.getHighValue(var9, var10);
      double var21 = var16.getLowValue(var9, var10);
      double var23 = var16.getOpenValue(var9, var10);
      double var25 = var16.getCloseValue(var9, var10);
      RectangleEdge var27 = var5.getDomainAxisEdge();
      double var28 = var6.valueToJava2D(var17, var3, var27);
      RectangleEdge var30 = var5.getRangeAxisEdge();
      double var31 = var7.valueToJava2D(var19, var3, var30);
      double var33 = var7.valueToJava2D(var21, var3, var30);
      double var35 = var7.valueToJava2D(var23, var3, var30);
      double var37 = var7.valueToJava2D(var25, var3, var30);
      double var39;
      double var41;
      double var46;
      double var49;
      double var51;
      if(this.candleWidth > 0.0D) {
         var39 = this.candleWidth;
         var41 = this.candleWidth;
      } else {
         double var43;
         var43 = 0.0D;
         int var45;
         label113:
         switch(this.autoWidthMethod) {
         case 0:
            var45 = var16.getItemCount(var9);
            if(var13) {
               var43 = var3.getHeight() / (double)var45;
            } else {
               var43 = var3.getWidth() / (double)var45;
            }
            break;
         case 1:
            var45 = var16.getItemCount(var9);
            var46 = -1.0D;
            var43 = var3.getWidth();
            int var62 = 0;

            while(true) {
               if(var62 >= var45) {
                  break label113;
               }

               var49 = var6.valueToJava2D(var16.getXValue(var9, var62), var3, var27);
               if(var46 != -1.0D) {
                  var43 = Math.min(var43, Math.abs(var49 - var46));
               }

               var46 = var49;
               ++var62;
            }
         case 2:
            IntervalXYDataset var48 = (IntervalXYDataset)var8;
            var49 = var6.valueToJava2D(var48.getStartXValue(var9, var10), var3, var5.getDomainAxisEdge());
            var51 = var6.valueToJava2D(var48.getEndXValue(var9, var10), var3, var5.getDomainAxisEdge());
            var43 = Math.abs(var51 - var49);
         }

         var43 -= 2.0D * this.autoWidthGap;
         var43 *= this.autoWidthFactor;
         var43 = Math.min(var43, this.maxCandleWidth);
         var39 = Math.max(Math.min(1.0D, this.maxCandleWidth), var43);
         var41 = Math.max(Math.min(3.0D, this.maxCandleWidth), var43);
      }

      Paint var60 = this.getItemPaint(var9, var10);
      Paint var44 = null;
      if(this.useOutlinePaint) {
         var44 = this.getItemOutlinePaint(var9, var10);
      }

      Stroke var59 = this.getItemStroke(var9, var10);
      var1.setStroke(var59);
      if(this.drawVolume) {
         int var61 = (int)var16.getVolumeValue(var9, var10);
         double var47 = (double)var61 / this.maxVolume;
         if(var13) {
            var49 = var3.getMinX();
            var51 = var3.getMaxX();
         } else {
            var49 = var3.getMinY();
            var51 = var3.getMaxY();
         }

         double var53 = var47 * (var51 - var49);
         var1.setPaint(Color.gray);
         Composite var55 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, 0.3F));
         if(var13) {
            var1.fill(new Double(var49, var28 - var39 / 2.0D, var53, var39));
         } else {
            var1.fill(new Double(var28 - var39 / 2.0D, var51 - var53, var39, var53));
         }

         var1.setComposite(var55);
      }

      if(this.useOutlinePaint) {
         var1.setPaint(var44);
      } else {
         var1.setPaint(var60);
      }

      var46 = Math.max(var35, var37);
      double var63 = Math.min(var35, var37);
      double var50 = Math.max(var23, var25);
      double var52 = Math.min(var23, var25);
      if(var19 > var50) {
         if(var13) {
            var1.draw(new java.awt.geom.Line2D.Double(var31, var28, var46, var28));
         } else {
            var1.draw(new java.awt.geom.Line2D.Double(var28, var31, var28, var46));
         }
      }

      if(var21 < var52) {
         if(var13) {
            var1.draw(new java.awt.geom.Line2D.Double(var33, var28, var63, var28));
         } else {
            var1.draw(new java.awt.geom.Line2D.Double(var28, var33, var28, var63));
         }
      }

      Double var54 = null;
      if(var13) {
         var54 = new Double(var63, var28 - var41 / 2.0D, var46 - var63, var41);
      } else {
         var54 = new Double(var28 - var41 / 2.0D, var63, var41, var46 - var63);
      }

      if(var25 > var23) {
         if(this.upPaint != null) {
            var1.setPaint(this.upPaint);
         } else {
            var1.setPaint(var60);
         }

         var1.fill(var54);
      } else {
         if(this.downPaint != null) {
            var1.setPaint(this.downPaint);
         } else {
            var1.setPaint(var60);
         }

         var1.fill(var54);
      }

      if(this.useOutlinePaint) {
         var1.setPaint(var44);
      } else {
         var1.setPaint(var60);
      }

      var1.draw(var54);
      if(var15 != null) {
         String var64 = null;
         XYToolTipGenerator var56 = this.getToolTipGenerator(var9, var10);
         if(var56 != null) {
            var64 = var56.generateToolTip(var8, var9, var10);
         }

         String var57 = null;
         if(this.getURLGenerator() != null) {
            var57 = this.getURLGenerator().generateURL(var8, var9, var10);
         }

         XYItemEntity var58 = new XYItemEntity(var54, var8, var9, var10, var64, var57);
         var15.add(var58);
      }

   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof CandlestickRenderer)) {
         return false;
      } else {
         CandlestickRenderer var2 = (CandlestickRenderer)var1;
         return this.candleWidth != var2.candleWidth?false:(!PaintUtilities.equal(this.upPaint, var2.upPaint)?false:(!PaintUtilities.equal(this.downPaint, var2.downPaint)?false:(this.drawVolume != var2.drawVolume?false:(this.maxCandleWidthInMilliseconds != var2.maxCandleWidthInMilliseconds?false:(this.autoWidthMethod != var2.autoWidthMethod?false:(this.autoWidthFactor != var2.autoWidthFactor?false:(this.autoWidthGap != var2.autoWidthGap?false:(this.useOutlinePaint != var2.useOutlinePaint?false:super.equals(var1)))))))));
      }
   }

   public Object clone() {
      return super.clone();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.upPaint, var1);
      SerialUtilities.writePaint(this.downPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.upPaint = SerialUtilities.readPaint(var1);
      this.downPaint = SerialUtilities.readPaint(var1);
   }
}
