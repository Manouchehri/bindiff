package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.axis.ValueTick;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.data.Range;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ArrayUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class FastScatterPlot extends Plot implements Serializable, Cloneable, ValueAxisPlot, Zoomable {
   private static final long serialVersionUID = 7871545897358563521L;
   public static final Stroke DEFAULT_GRIDLINE_STROKE = new BasicStroke(0.5F, 0, 2, 0.0F, new float[]{2.0F, 2.0F}, 0.0F);
   public static final Paint DEFAULT_GRIDLINE_PAINT;
   private float[][] data;
   private Range xDataRange;
   private Range yDataRange;
   private ValueAxis domainAxis;
   private ValueAxis rangeAxis;
   private transient Paint paint;
   private boolean domainGridlinesVisible;
   private transient Stroke domainGridlineStroke;
   private transient Paint domainGridlinePaint;
   private boolean rangeGridlinesVisible;
   private transient Stroke rangeGridlineStroke;
   private transient Paint rangeGridlinePaint;
   protected static ResourceBundle localizationResources;

   public FastScatterPlot() {
      this((float[][])null, new NumberAxis("X"), new NumberAxis("Y"));
   }

   public FastScatterPlot(float[][] var1, ValueAxis var2, ValueAxis var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'domainAxis\' argument.");
      } else if(var3 == null) {
         throw new IllegalArgumentException("Null \'rangeAxis\' argument.");
      } else {
         this.data = var1;
         this.xDataRange = this.calculateXDataRange(var1);
         this.yDataRange = this.calculateYDataRange(var1);
         this.domainAxis = var2;
         this.domainAxis.setPlot(this);
         this.domainAxis.addChangeListener(this);
         this.rangeAxis = var3;
         this.rangeAxis.setPlot(this);
         this.rangeAxis.addChangeListener(this);
         this.paint = Color.red;
         this.domainGridlinesVisible = true;
         this.domainGridlinePaint = DEFAULT_GRIDLINE_PAINT;
         this.domainGridlineStroke = DEFAULT_GRIDLINE_STROKE;
         this.rangeGridlinesVisible = true;
         this.rangeGridlinePaint = DEFAULT_GRIDLINE_PAINT;
         this.rangeGridlineStroke = DEFAULT_GRIDLINE_STROKE;
      }
   }

   public String getPlotType() {
      return localizationResources.getString("Fast_Scatter_Plot");
   }

   public float[][] getData() {
      return this.data;
   }

   public void setData(float[][] var1) {
      this.data = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public PlotOrientation getOrientation() {
      return PlotOrientation.VERTICAL;
   }

   public ValueAxis getDomainAxis() {
      return this.domainAxis;
   }

   public void setDomainAxis(ValueAxis var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'axis\' argument.");
      } else {
         this.domainAxis = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public ValueAxis getRangeAxis() {
      return this.rangeAxis;
   }

   public void setRangeAxis(ValueAxis var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'axis\' argument.");
      } else {
         this.rangeAxis = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getPaint() {
      return this.paint;
   }

   public void setPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.paint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean isDomainGridlinesVisible() {
      return this.domainGridlinesVisible;
   }

   public void setDomainGridlinesVisible(boolean var1) {
      if(this.domainGridlinesVisible != var1) {
         this.domainGridlinesVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getDomainGridlineStroke() {
      return this.domainGridlineStroke;
   }

   public void setDomainGridlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.domainGridlineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getDomainGridlinePaint() {
      return this.domainGridlinePaint;
   }

   public void setDomainGridlinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.domainGridlinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean isRangeGridlinesVisible() {
      return this.rangeGridlinesVisible;
   }

   public void setRangeGridlinesVisible(boolean var1) {
      if(this.rangeGridlinesVisible != var1) {
         this.rangeGridlinesVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Stroke getRangeGridlineStroke() {
      return this.rangeGridlineStroke;
   }

   public void setRangeGridlineStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.rangeGridlineStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getRangeGridlinePaint() {
      return this.rangeGridlinePaint;
   }

   public void setRangeGridlinePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.rangeGridlinePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      if(var5 != null) {
         var5.setPlotArea(var2);
      }

      RectangleInsets var6 = this.getInsets();
      var6.trim(var2);
      AxisSpace var7 = new AxisSpace();
      var7 = this.domainAxis.reserveSpace(var1, this, var2, RectangleEdge.BOTTOM, var7);
      var7 = this.rangeAxis.reserveSpace(var1, this, var2, RectangleEdge.LEFT, var7);
      Rectangle2D var8 = var7.shrink(var2, (Rectangle2D)null);
      if(var5 != null) {
         var5.setDataArea(var8);
      }

      this.drawBackground(var1, var8);
      AxisState var9 = this.domainAxis.draw(var1, var8.getMaxY(), var2, var8, RectangleEdge.BOTTOM, var5);
      AxisState var10 = this.rangeAxis.draw(var1, var8.getMinX(), var2, var8, RectangleEdge.LEFT, var5);
      this.drawDomainGridlines(var1, var8, var9.getTicks());
      this.drawRangeGridlines(var1, var8, var10.getTicks());
      Shape var11 = var1.getClip();
      Composite var12 = var1.getComposite();
      var1.clip(var8);
      var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
      this.render(var1, var8, var5, (CrosshairState)null);
      var1.setClip(var11);
      var1.setComposite(var12);
      this.drawOutline(var1, var8);
   }

   public void render(Graphics2D var1, Rectangle2D var2, PlotRenderingInfo var3, CrosshairState var4) {
      var1.setPaint(this.paint);
      if(this.data != null) {
         for(int var5 = 0; var5 < this.data[0].length; ++var5) {
            float var6 = this.data[0][var5];
            float var7 = this.data[1][var5];
            int var8 = (int)this.domainAxis.valueToJava2D((double)var6, var2, RectangleEdge.BOTTOM);
            int var9 = (int)this.rangeAxis.valueToJava2D((double)var7, var2, RectangleEdge.LEFT);
            var1.fillRect(var8, var9, 1, 1);
         }
      }

   }

   protected void drawDomainGridlines(Graphics2D var1, Rectangle2D var2, List var3) {
      if(this.isDomainGridlinesVisible()) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            ValueTick var5 = (ValueTick)var4.next();
            double var6 = this.domainAxis.valueToJava2D(var5.getValue(), var2, RectangleEdge.BOTTOM);
            Double var8 = new Double(var6, var2.getMinY(), var6, var2.getMaxY());
            var1.setPaint(this.getDomainGridlinePaint());
            var1.setStroke(this.getDomainGridlineStroke());
            var1.draw(var8);
         }
      }

   }

   protected void drawRangeGridlines(Graphics2D var1, Rectangle2D var2, List var3) {
      if(this.isRangeGridlinesVisible()) {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            ValueTick var5 = (ValueTick)var4.next();
            double var6 = this.rangeAxis.valueToJava2D(var5.getValue(), var2, RectangleEdge.LEFT);
            Double var8 = new Double(var2.getMinX(), var6, var2.getMaxX(), var6);
            var1.setPaint(this.getRangeGridlinePaint());
            var1.setStroke(this.getRangeGridlineStroke());
            var1.draw(var8);
         }
      }

   }

   public Range getDataRange(ValueAxis var1) {
      Range var2 = null;
      if(var1 == this.domainAxis) {
         var2 = this.xDataRange;
      } else if(var1 == this.rangeAxis) {
         var2 = this.yDataRange;
      }

      return var2;
   }

   private Range calculateXDataRange(float[][] var1) {
      Range var2 = null;
      if(var1 != null) {
         float var3 = Float.POSITIVE_INFINITY;
         float var4 = Float.NEGATIVE_INFINITY;

         for(int var5 = 0; var5 < var1[0].length; ++var5) {
            float var6 = var1[0][var5];
            if(var6 < var3) {
               var3 = var6;
            }

            if(var6 > var4) {
               var4 = var6;
            }
         }

         if(var3 <= var4) {
            var2 = new Range((double)var3, (double)var4);
         }
      }

      return var2;
   }

   private Range calculateYDataRange(float[][] var1) {
      Range var2 = null;
      if(var1 != null) {
         float var3 = Float.POSITIVE_INFINITY;
         float var4 = Float.NEGATIVE_INFINITY;

         for(int var5 = 0; var5 < var1[0].length; ++var5) {
            float var6 = var1[1][var5];
            if(var6 < var3) {
               var3 = var6;
            }

            if(var6 > var4) {
               var4 = var6;
            }
         }

         if(var3 <= var4) {
            var2 = new Range((double)var3, (double)var4);
         }
      }

      return var2;
   }

   public void zoomDomainAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
      this.domainAxis.resizeRange(var1);
   }

   public void zoomDomainAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
      this.domainAxis.zoomRange(var1, var3);
   }

   public void zoomRangeAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
      this.rangeAxis.resizeRange(var1);
   }

   public void zoomRangeAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
      this.rangeAxis.zoomRange(var1, var3);
   }

   public boolean isDomainZoomable() {
      return true;
   }

   public boolean isRangeZoomable() {
      return true;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof FastScatterPlot)) {
         return false;
      } else {
         FastScatterPlot var2 = (FastScatterPlot)var1;
         return !ArrayUtilities.equal(this.data, var2.data)?false:(!ObjectUtilities.equal(this.domainAxis, var2.domainAxis)?false:(!ObjectUtilities.equal(this.rangeAxis, var2.rangeAxis)?false:(!PaintUtilities.equal(this.paint, var2.paint)?false:(this.domainGridlinesVisible != var2.domainGridlinesVisible?false:(!PaintUtilities.equal(this.domainGridlinePaint, var2.domainGridlinePaint)?false:(!ObjectUtilities.equal(this.domainGridlineStroke, var2.domainGridlineStroke)?false:(!this.rangeGridlinesVisible == var2.rangeGridlinesVisible?false:(!PaintUtilities.equal(this.rangeGridlinePaint, var2.rangeGridlinePaint)?false:ObjectUtilities.equal(this.rangeGridlineStroke, var2.rangeGridlineStroke)))))))));
      }
   }

   public Object clone() {
      FastScatterPlot var1 = (FastScatterPlot)super.clone();
      if(this.data != null) {
         var1.data = ArrayUtilities.clone(this.data);
      }

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

      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.paint, var1);
      SerialUtilities.writeStroke(this.domainGridlineStroke, var1);
      SerialUtilities.writePaint(this.domainGridlinePaint, var1);
      SerialUtilities.writeStroke(this.rangeGridlineStroke, var1);
      SerialUtilities.writePaint(this.rangeGridlinePaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.paint = SerialUtilities.readPaint(var1);
      this.domainGridlineStroke = SerialUtilities.readStroke(var1);
      this.domainGridlinePaint = SerialUtilities.readPaint(var1);
      this.rangeGridlineStroke = SerialUtilities.readStroke(var1);
      this.rangeGridlinePaint = SerialUtilities.readPaint(var1);
      if(this.domainAxis != null) {
         this.domainAxis.addChangeListener(this);
      }

      if(this.rangeAxis != null) {
         this.rangeAxis.addChangeListener(this);
      }

   }

   static {
      DEFAULT_GRIDLINE_PAINT = Color.lightGray;
      localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   }
}
