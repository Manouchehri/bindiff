package org.jfree.chart.plot;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.ValueDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;

public class MeterPlot extends Plot implements Serializable, Cloneable {
   private static final long serialVersionUID = 2987472457734470962L;
   static final Paint DEFAULT_DIAL_BACKGROUND_PAINT;
   static final Paint DEFAULT_NEEDLE_PAINT;
   static final Font DEFAULT_VALUE_FONT;
   static final Paint DEFAULT_VALUE_PAINT;
   public static final int DEFAULT_METER_ANGLE = 270;
   public static final float DEFAULT_BORDER_SIZE = 3.0F;
   public static final float DEFAULT_CIRCLE_SIZE = 10.0F;
   public static final Font DEFAULT_LABEL_FONT;
   private ValueDataset dataset;
   private DialShape shape;
   private int meterAngle;
   private Range range;
   private double tickSize;
   private transient Paint tickPaint;
   private String units;
   private Font valueFont;
   private transient Paint valuePaint;
   private boolean drawBorder;
   private transient Paint dialOutlinePaint;
   private transient Paint dialBackgroundPaint;
   private transient Paint needlePaint;
   private boolean tickLabelsVisible;
   private Font tickLabelFont;
   private transient Paint tickLabelPaint;
   private NumberFormat tickLabelFormat;
   protected static ResourceBundle localizationResources;
   private List intervals;

   public MeterPlot() {
      this((ValueDataset)null);
   }

   public MeterPlot(ValueDataset var1) {
      this.shape = DialShape.CIRCLE;
      this.meterAngle = 270;
      this.range = new Range(0.0D, 100.0D);
      this.tickSize = 10.0D;
      this.tickPaint = Color.white;
      this.units = "Units";
      this.needlePaint = DEFAULT_NEEDLE_PAINT;
      this.tickLabelsVisible = true;
      this.tickLabelFont = DEFAULT_LABEL_FONT;
      this.tickLabelPaint = Color.black;
      this.tickLabelFormat = NumberFormat.getInstance();
      this.valueFont = DEFAULT_VALUE_FONT;
      this.valuePaint = DEFAULT_VALUE_PAINT;
      this.dialBackgroundPaint = DEFAULT_DIAL_BACKGROUND_PAINT;
      this.intervals = new ArrayList();
      this.setDataset(var1);
   }

   public DialShape getDialShape() {
      return this.shape;
   }

   public void setDialShape(DialShape var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'shape\' argument.");
      } else {
         this.shape = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public int getMeterAngle() {
      return this.meterAngle;
   }

   public void setMeterAngle(int var1) {
      if(var1 >= 1 && var1 <= 360) {
         this.meterAngle = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      } else {
         throw new IllegalArgumentException("Invalid \'angle\' (" + var1 + ")");
      }
   }

   public Range getRange() {
      return this.range;
   }

   public void setRange(Range var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else if(var1.getLength() <= 0.0D) {
         throw new IllegalArgumentException("Range length must be positive.");
      } else {
         this.range = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public double getTickSize() {
      return this.tickSize;
   }

   public void setTickSize(double var1) {
      if(var1 <= 0.0D) {
         throw new IllegalArgumentException("Requires \'size\' > 0.");
      } else {
         this.tickSize = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getTickPaint() {
      return this.tickPaint;
   }

   public void setTickPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.tickPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public String getUnits() {
      return this.units;
   }

   public void setUnits(String var1) {
      this.units = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getNeedlePaint() {
      return this.needlePaint;
   }

   public void setNeedlePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.needlePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public boolean getTickLabelsVisible() {
      return this.tickLabelsVisible;
   }

   public void setTickLabelsVisible(boolean var1) {
      if(this.tickLabelsVisible != var1) {
         this.tickLabelsVisible = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Font getTickLabelFont() {
      return this.tickLabelFont;
   }

   public void setTickLabelFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         if(!this.tickLabelFont.equals(var1)) {
            this.tickLabelFont = var1;
            this.notifyListeners(new PlotChangeEvent(this));
         }

      }
   }

   public Paint getTickLabelPaint() {
      return this.tickLabelPaint;
   }

   public void setTickLabelPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         if(!this.tickLabelPaint.equals(var1)) {
            this.tickLabelPaint = var1;
            this.notifyListeners(new PlotChangeEvent(this));
         }

      }
   }

   public NumberFormat getTickLabelFormat() {
      return this.tickLabelFormat;
   }

   public void setTickLabelFormat(NumberFormat var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'format\' argument.");
      } else {
         this.tickLabelFormat = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Font getValueFont() {
      return this.valueFont;
   }

   public void setValueFont(Font var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'font\' argument.");
      } else {
         this.valueFont = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getValuePaint() {
      return this.valuePaint;
   }

   public void setValuePaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.valuePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public Paint getDialBackgroundPaint() {
      return this.dialBackgroundPaint;
   }

   public void setDialBackgroundPaint(Paint var1) {
      this.dialBackgroundPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean getDrawBorder() {
      return this.drawBorder;
   }

   public void setDrawBorder(boolean var1) {
      this.drawBorder = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Paint getDialOutlinePaint() {
      return this.dialOutlinePaint;
   }

   public void setDialOutlinePaint(Paint var1) {
      this.dialOutlinePaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public ValueDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(ValueDataset var1) {
      ValueDataset var2 = this.dataset;
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

   public List getIntervals() {
      return Collections.unmodifiableList(this.intervals);
   }

   public void addInterval(MeterInterval var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'interval\' argument.");
      } else {
         this.intervals.add(var1);
         this.notifyListeners(new PlotChangeEvent(this));
      }
   }

   public void clearIntervals() {
      this.intervals.clear();
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public LegendItemCollection getLegendItems() {
      LegendItemCollection var1 = new LegendItemCollection();
      Iterator var2 = this.intervals.iterator();

      while(var2.hasNext()) {
         MeterInterval var3 = (MeterInterval)var2.next();
         Paint var4 = var3.getBackgroundPaint();
         if(var4 == null) {
            var4 = var3.getOutlinePaint();
         }

         LegendItem var5 = new LegendItem(var3.getLabel(), var3.getLabel(), (String)null, (String)null, new Double(-4.0D, -4.0D, 8.0D, 8.0D), var4);
         var1.add(var5);
      }

      return var1;
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      if(var5 != null) {
         var5.setPlotArea(var2);
      }

      RectangleInsets var6 = this.getInsets();
      var6.trim(var2);
      var2.setRect(var2.getX() + 4.0D, var2.getY() + 4.0D, var2.getWidth() - 8.0D, var2.getHeight() - 8.0D);
      if(this.drawBorder) {
         this.drawBackground(var1, var2);
      }

      double var7 = 6.0D;
      double var9 = 6.0D;
      double var11 = var2.getX() + var7 / 2.0D;
      double var13 = var2.getY() + var9 / 2.0D;
      double var15 = var2.getWidth() - var7;
      double var17 = var2.getHeight() - var9 + (this.meterAngle <= 180 && this.shape != DialShape.CIRCLE?var2.getHeight() / 1.25D:0.0D);
      double var19 = Math.min(var15, var17) / 2.0D;
      var11 = (var11 + var11 + var15) / 2.0D - var19;
      var13 = (var13 + var13 + var17) / 2.0D - var19;
      var15 = 2.0D * var19;
      var17 = 2.0D * var19;
      Double var21 = new Double(var11, var13, var15, var17);
      Double var22 = new Double(var21.getX() - 4.0D, var21.getY() - 4.0D, var21.getWidth() + 8.0D, var21.getHeight() + 8.0D);
      double var23 = var21.getCenterX();
      double var25 = var21.getCenterY();
      ValueDataset var27 = this.getDataset();
      if(var27 != null) {
         double var28 = this.range.getLowerBound();
         double var30 = this.range.getUpperBound();
         Shape var32 = var1.getClip();
         var1.clip(var22);
         Composite var33 = var1.getComposite();
         var1.setComposite(AlphaComposite.getInstance(3, this.getForegroundAlpha()));
         if(this.dialBackgroundPaint != null) {
            this.fillArc(var1, var22, var28, var30, this.dialBackgroundPaint, true);
         }

         this.drawTicks(var1, var21, var28, var30);
         this.drawArcForInterval(var1, var21, new MeterInterval("", this.range, this.dialOutlinePaint, new BasicStroke(1.0F), (Paint)null));
         Iterator var34 = this.intervals.iterator();

         while(var34.hasNext()) {
            MeterInterval var35 = (MeterInterval)var34.next();
            this.drawArcForInterval(var1, var21, var35);
         }

         Number var52 = var27.getValue();
         if(var52 != null) {
            double var36 = var52.doubleValue();
            this.drawValueLabel(var1, var21);
            if(this.range.contains(var36)) {
               var1.setPaint(this.needlePaint);
               var1.setStroke(new BasicStroke(2.0F));
               double var38 = var21.getWidth() / 2.0D + 3.0D + 15.0D;
               double var40 = this.valueToAngle(var36);
               double var42 = var23 + var38 * Math.cos(3.141592653589793D * (var40 / 180.0D));
               double var44 = var25 - var38 * Math.sin(3.141592653589793D * (var40 / 180.0D));
               Polygon var46 = new Polygon();
               if((var40 <= 135.0D || var40 >= 225.0D) && (var40 >= 45.0D || var40 <= -45.0D)) {
                  var46.addPoint((int)(var23 - 2.5D), (int)var25);
                  var46.addPoint((int)(var23 + 2.5D), (int)var25);
               } else {
                  double var47 = var25 - 2.5D;
                  double var49 = var25 + 2.5D;
                  var46.addPoint((int)var23, (int)var47);
                  var46.addPoint((int)var23, (int)var49);
               }

               var46.addPoint((int)var42, (int)var44);
               var1.fill(var46);
               java.awt.geom.Ellipse2D.Double var51 = new java.awt.geom.Ellipse2D.Double(var23 - 5.0D, var25 - 5.0D, 10.0D, 10.0D);
               var1.fill(var51);
            }
         }

         var1.setClip(var32);
         var1.setComposite(var33);
      }

      if(this.drawBorder) {
         this.drawOutline(var1, var2);
      }

   }

   protected void drawArcForInterval(Graphics2D var1, Rectangle2D var2, MeterInterval var3) {
      double var4 = var3.getRange().getLowerBound();
      double var6 = var3.getRange().getUpperBound();
      Paint var8 = var3.getOutlinePaint();
      Stroke var9 = var3.getOutlineStroke();
      Paint var10 = var3.getBackgroundPaint();
      if(var10 != null) {
         this.fillArc(var1, var2, var4, var6, var10, false);
      }

      if(var8 != null) {
         if(var9 != null) {
            this.drawArc(var1, var2, var4, var6, var8, var9);
         }

         this.drawTick(var1, var2, var4, true);
         this.drawTick(var1, var2, var6, true);
      }

   }

   protected void drawArc(Graphics2D var1, Rectangle2D var2, double var3, double var5, Paint var7, Stroke var8) {
      double var9 = this.valueToAngle(var5);
      double var11 = this.valueToAngle(var3);
      double var13 = var11 - var9;
      double var15 = var2.getX();
      double var17 = var2.getY();
      double var19 = var2.getWidth();
      double var21 = var2.getHeight();
      var1.setPaint(var7);
      var1.setStroke(var8);
      if(var7 != null && var8 != null) {
         java.awt.geom.Arc2D.Double var23 = new java.awt.geom.Arc2D.Double(var15, var17, var19, var21, var9, var13, 0);
         var1.setPaint(var7);
         var1.setStroke(var8);
         var1.draw(var23);
      }

   }

   protected void fillArc(Graphics2D var1, Rectangle2D var2, double var3, double var5, Paint var7, boolean var8) {
      if(var7 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument");
      } else {
         double var9 = this.valueToAngle(var5);
         double var11 = this.valueToAngle(var3);
         double var13 = var11 - var9;
         double var15 = var2.getX();
         double var17 = var2.getY();
         double var19 = var2.getWidth();
         double var21 = var2.getHeight();
         boolean var23 = false;
         byte var25;
         if(this.shape == DialShape.PIE) {
            var25 = 2;
         } else if(this.shape == DialShape.CHORD) {
            if(var8 && this.meterAngle > 180) {
               var25 = 1;
            } else {
               var25 = 2;
            }
         } else {
            if(this.shape != DialShape.CIRCLE) {
               throw new IllegalStateException("DialShape not recognised.");
            }

            var25 = 2;
            if(var8) {
               var13 = 360.0D;
            }
         }

         var1.setPaint(var7);
         java.awt.geom.Arc2D.Double var24 = new java.awt.geom.Arc2D.Double(var15, var17, var19, var21, var9, var13, var25);
         var1.fill(var24);
      }
   }

   public double valueToAngle(double var1) {
      var1 -= this.range.getLowerBound();
      double var3 = (double)(180 + (this.meterAngle - 180) / 2);
      return var3 - var1 / this.range.getLength() * (double)this.meterAngle;
   }

   protected void drawTicks(Graphics2D var1, Rectangle2D var2, double var3, double var5) {
      for(double var7 = var3; var7 <= var5; var7 += this.tickSize) {
         this.drawTick(var1, var2, var7);
      }

   }

   protected void drawTick(Graphics2D var1, Rectangle2D var2, double var3) {
      this.drawTick(var1, var2, var3, false);
   }

   protected void drawTick(Graphics2D var1, Rectangle2D var2, double var3, boolean var5) {
      double var6 = this.valueToAngle(var3);
      double var8 = var2.getCenterX();
      double var10 = var2.getCenterY();
      var1.setPaint(this.tickPaint);
      var1.setStroke(new BasicStroke(2.0F));
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = var2.getWidth() / 2.0D + 3.0D;
      double var18 = var16 - 15.0D;
      double var20 = var8 + var16 * Math.cos(3.141592653589793D * (var6 / 180.0D));
      double var22 = var10 - var16 * Math.sin(3.141592653589793D * (var6 / 180.0D));
      var12 = var8 + var18 * Math.cos(3.141592653589793D * (var6 / 180.0D));
      var14 = var10 - var18 * Math.sin(3.141592653589793D * (var6 / 180.0D));
      java.awt.geom.Line2D.Double var24 = new java.awt.geom.Line2D.Double(var20, var22, var12, var14);
      var1.draw(var24);
      if(this.tickLabelsVisible && var5) {
         String var25 = this.tickLabelFormat.format(var3);
         var1.setFont(this.tickLabelFont);
         var1.setPaint(this.tickLabelPaint);
         FontMetrics var26 = var1.getFontMetrics();
         Rectangle2D var27 = TextUtilities.getTextBounds(var25, var1, var26);
         double var28 = var12;
         if(var6 != 90.0D && var6 != 270.0D) {
            if(var6 < 90.0D || var6 > 270.0D) {
               var28 = var12 - var27.getWidth();
            }
         } else {
            var28 = var12 - var27.getWidth() / 2.0D;
         }

         double var30;
         if((var6 <= 135.0D || var6 >= 225.0D) && var6 <= 315.0D && var6 >= 45.0D) {
            var30 = var14 + var27.getHeight() / 2.0D;
         } else {
            var30 = var14 - var27.getHeight() / 2.0D;
         }

         var1.drawString(var25, (float)var28, (float)var30);
      }

   }

   protected void drawValueLabel(Graphics2D var1, Rectangle2D var2) {
      var1.setFont(this.valueFont);
      var1.setPaint(this.valuePaint);
      String var3 = "No value";
      if(this.dataset != null) {
         Number var4 = this.dataset.getValue();
         if(var4 != null) {
            var3 = this.tickLabelFormat.format(var4.doubleValue()) + " " + this.units;
         }
      }

      float var6 = (float)var2.getCenterX();
      float var5 = (float)var2.getCenterY() + 10.0F;
      TextUtilities.drawAlignedString(var3, var1, var6, var5, TextAnchor.TOP_CENTER);
   }

   public String getPlotType() {
      return localizationResources.getString("Meter_Plot");
   }

   public void zoom(double var1) {
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MeterPlot)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         MeterPlot var2 = (MeterPlot)var1;
         return !ObjectUtilities.equal(this.units, var2.units)?false:(!ObjectUtilities.equal(this.range, var2.range)?false:(!ObjectUtilities.equal(this.intervals, var2.intervals)?false:(!PaintUtilities.equal(this.dialOutlinePaint, var2.dialOutlinePaint)?false:(this.shape != var2.shape?false:(!PaintUtilities.equal(this.dialBackgroundPaint, var2.dialBackgroundPaint)?false:(!PaintUtilities.equal(this.needlePaint, var2.needlePaint)?false:(!ObjectUtilities.equal(this.valueFont, var2.valueFont)?false:(!PaintUtilities.equal(this.valuePaint, var2.valuePaint)?false:(!PaintUtilities.equal(this.tickPaint, var2.tickPaint)?false:(this.tickSize != var2.tickSize?false:(this.tickLabelsVisible != var2.tickLabelsVisible?false:(!ObjectUtilities.equal(this.tickLabelFont, var2.tickLabelFont)?false:(!PaintUtilities.equal(this.tickLabelPaint, var2.tickLabelPaint)?false:(!ObjectUtilities.equal(this.tickLabelFormat, var2.tickLabelFormat)?false:(this.drawBorder != var2.drawBorder?false:this.meterAngle == var2.meterAngle)))))))))))))));
      }
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writePaint(this.dialBackgroundPaint, var1);
      SerialUtilities.writePaint(this.needlePaint, var1);
      SerialUtilities.writePaint(this.valuePaint, var1);
      SerialUtilities.writePaint(this.tickPaint, var1);
      SerialUtilities.writePaint(this.tickLabelPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.dialBackgroundPaint = SerialUtilities.readPaint(var1);
      this.needlePaint = SerialUtilities.readPaint(var1);
      this.valuePaint = SerialUtilities.readPaint(var1);
      this.tickPaint = SerialUtilities.readPaint(var1);
      this.tickLabelPaint = SerialUtilities.readPaint(var1);
      if(this.dataset != null) {
         this.dataset.addChangeListener(this);
      }

   }

   public Object clone() {
      MeterPlot var1 = (MeterPlot)super.clone();
      var1.tickLabelFormat = (NumberFormat)this.tickLabelFormat.clone();
      var1.intervals = new ArrayList(this.intervals);
      if(var1.dataset != null) {
         var1.dataset.addChangeListener(var1);
      }

      return var1;
   }

   static {
      DEFAULT_DIAL_BACKGROUND_PAINT = Color.black;
      DEFAULT_NEEDLE_PAINT = Color.green;
      DEFAULT_VALUE_FONT = new Font("SansSerif", 1, 12);
      DEFAULT_VALUE_PAINT = Color.yellow;
      DEFAULT_LABEL_FONT = new Font("SansSerif", 1, 10);
      localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");
   }
}
