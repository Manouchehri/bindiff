package org.jfree.chart.plot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ResourceBundle;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.PlotChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.PlotState;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.chart.plot.Zoomable;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PaintUtilities;
import org.jfree.util.UnitType;

public class ThermometerPlot extends Plot implements Serializable, Cloneable, ValueAxisPlot, Zoomable {
   private static final long serialVersionUID = 4087093313147984390L;
   public static final int UNITS_NONE = 0;
   public static final int UNITS_FAHRENHEIT = 1;
   public static final int UNITS_CELCIUS = 2;
   public static final int UNITS_KELVIN = 3;
   public static final int NONE = 0;
   public static final int RIGHT = 1;
   public static final int LEFT = 2;
   public static final int BULB = 3;
   public static final int NORMAL = 0;
   public static final int WARNING = 1;
   public static final int CRITICAL = 2;
   protected static final int BULB_RADIUS = 40;
   protected static final int BULB_DIAMETER = 80;
   protected static final int COLUMN_RADIUS = 20;
   protected static final int COLUMN_DIAMETER = 40;
   protected static final int GAP_RADIUS = 5;
   protected static final int GAP_DIAMETER = 10;
   protected static final int AXIS_GAP = 10;
   protected static final String[] UNITS = new String[]{"", "°F", "°C", "°K"};
   protected static final int RANGE_LOW = 0;
   protected static final int RANGE_HIGH = 1;
   protected static final int DISPLAY_LOW = 2;
   protected static final int DISPLAY_HIGH = 3;
   protected static final double DEFAULT_LOWER_BOUND = 0.0D;
   protected static final double DEFAULT_UPPER_BOUND = 100.0D;
   private ValueDataset dataset;
   private ValueAxis rangeAxis;
   private double lowerBound;
   private double upperBound;
   private RectangleInsets padding;
   private transient Stroke thermometerStroke;
   private transient Paint thermometerPaint;
   private int units;
   private int valueLocation;
   private int axisLocation;
   private Font valueFont;
   private transient Paint valuePaint;
   private NumberFormat valueFormat;
   private transient Paint mercuryPaint;
   private boolean showValueLines;
   private int subrange;
   private double[][] subrangeInfo;
   private boolean followDataInSubranges;
   private boolean useSubrangePaint;
   private Paint[] subrangePaint;
   private boolean subrangeIndicatorsVisible;
   private transient Stroke subrangeIndicatorStroke;
   private transient Stroke rangeIndicatorStroke;
   protected static ResourceBundle localizationResources = ResourceBundle.getBundle("org.jfree.chart.plot.LocalizationBundle");

   public ThermometerPlot() {
      this(new DefaultValueDataset());
   }

   public ThermometerPlot(ValueDataset var1) {
      this.lowerBound = 0.0D;
      this.upperBound = 100.0D;
      this.thermometerStroke = new BasicStroke(1.0F);
      this.thermometerPaint = Color.black;
      this.units = 2;
      this.valueLocation = 3;
      this.axisLocation = 2;
      this.valueFont = new Font("SansSerif", 1, 16);
      this.valuePaint = Color.white;
      this.valueFormat = new DecimalFormat();
      this.mercuryPaint = Color.lightGray;
      this.showValueLines = false;
      this.subrange = -1;
      this.subrangeInfo = new double[][]{{0.0D, 50.0D, 0.0D, 50.0D}, {50.0D, 75.0D, 50.0D, 75.0D}, {75.0D, 100.0D, 75.0D, 100.0D}};
      this.followDataInSubranges = false;
      this.useSubrangePaint = true;
      this.subrangePaint = new Paint[]{Color.green, Color.orange, Color.red};
      this.subrangeIndicatorsVisible = true;
      this.subrangeIndicatorStroke = new BasicStroke(2.0F);
      this.rangeIndicatorStroke = new BasicStroke(3.0F);
      this.padding = new RectangleInsets(UnitType.RELATIVE, 0.05D, 0.05D, 0.05D, 0.05D);
      this.dataset = var1;
      if(var1 != null) {
         var1.addChangeListener(this);
      }

      NumberAxis var2 = new NumberAxis((String)null);
      var2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      var2.setAxisLineVisible(false);
      this.setRangeAxis(var2);
      this.setAxisRange();
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

   public ValueAxis getRangeAxis() {
      return this.rangeAxis;
   }

   public void setRangeAxis(ValueAxis var1) {
      if(var1 != null) {
         var1.setPlot(this);
         var1.addChangeListener(this);
      }

      if(this.rangeAxis != null) {
         this.rangeAxis.removeChangeListener(this);
      }

      this.rangeAxis = var1;
   }

   public double getLowerBound() {
      return this.lowerBound;
   }

   public void setLowerBound(double var1) {
      this.lowerBound = var1;
      this.setAxisRange();
   }

   public double getUpperBound() {
      return this.upperBound;
   }

   public void setUpperBound(double var1) {
      this.upperBound = var1;
      this.setAxisRange();
   }

   public void setRange(double var1, double var3) {
      this.lowerBound = var1;
      this.upperBound = var3;
      this.setAxisRange();
   }

   public RectangleInsets getPadding() {
      return this.padding;
   }

   public void setPadding(RectangleInsets var1) {
      this.padding = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public Stroke getThermometerStroke() {
      return this.thermometerStroke;
   }

   public void setThermometerStroke(Stroke var1) {
      if(var1 != null) {
         this.thermometerStroke = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Paint getThermometerPaint() {
      return this.thermometerPaint;
   }

   public void setThermometerPaint(Paint var1) {
      if(var1 != null) {
         this.thermometerPaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public int getUnits() {
      return this.units;
   }

   public void setUnits(int var1) {
      if(var1 >= 0 && var1 < UNITS.length && this.units != var1) {
         this.units = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void setUnits(String var1) {
      if(var1 != null) {
         var1 = var1.toUpperCase().trim();

         for(int var2 = 0; var2 < UNITS.length; ++var2) {
            if(var1.equals(UNITS[var2].toUpperCase().trim())) {
               this.setUnits(var2);
               var2 = UNITS.length;
            }
         }

      }
   }

   public int getValueLocation() {
      return this.valueLocation;
   }

   public void setValueLocation(int var1) {
      if(var1 >= 0 && var1 < 4) {
         this.valueLocation = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      } else {
         throw new IllegalArgumentException("Location not recognised.");
      }
   }

   public void setAxisLocation(int var1) {
      if(var1 >= 0 && var1 < 3) {
         this.axisLocation = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      } else {
         throw new IllegalArgumentException("Location not recognised.");
      }
   }

   public int getAxisLocation() {
      return this.axisLocation;
   }

   public Font getValueFont() {
      return this.valueFont;
   }

   public void setValueFont(Font var1) {
      if(var1 != null && !this.valueFont.equals(var1)) {
         this.valueFont = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Paint getValuePaint() {
      return this.valuePaint;
   }

   public void setValuePaint(Paint var1) {
      if(var1 != null && !this.valuePaint.equals(var1)) {
         this.valuePaint = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void setValueFormat(NumberFormat var1) {
      if(var1 != null) {
         this.valueFormat = var1;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public Paint getMercuryPaint() {
      return this.mercuryPaint;
   }

   public void setMercuryPaint(Paint var1) {
      this.mercuryPaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean getShowValueLines() {
      return this.showValueLines;
   }

   public void setShowValueLines(boolean var1) {
      this.showValueLines = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void setSubrangeInfo(int var1, double var2, double var4) {
      this.setSubrangeInfo(var1, var2, var4, var2, var4);
   }

   public void setSubrangeInfo(int var1, double var2, double var4, double var6, double var8) {
      if(var1 >= 0 && var1 < 3) {
         this.setSubrange(var1, var2, var4);
         this.setDisplayRange(var1, var6, var8);
         this.setAxisRange();
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public void setSubrange(int var1, double var2, double var4) {
      if(var1 >= 0 && var1 < 3) {
         this.subrangeInfo[var1][1] = var4;
         this.subrangeInfo[var1][0] = var2;
      }

   }

   public void setDisplayRange(int var1, double var2, double var4) {
      if(var1 >= 0 && var1 < this.subrangeInfo.length && isValidNumber(var4) && isValidNumber(var2)) {
         if(var4 > var2) {
            this.subrangeInfo[var1][3] = var4;
            this.subrangeInfo[var1][2] = var2;
         } else {
            this.subrangeInfo[var1][3] = var2;
            this.subrangeInfo[var1][2] = var4;
         }
      }

   }

   public Paint getSubrangePaint(int var1) {
      return var1 >= 0 && var1 < this.subrangePaint.length?this.subrangePaint[var1]:this.mercuryPaint;
   }

   public void setSubrangePaint(int var1, Paint var2) {
      if(var1 >= 0 && var1 < this.subrangePaint.length && var2 != null) {
         this.subrangePaint[var1] = var2;
         this.notifyListeners(new PlotChangeEvent(this));
      }

   }

   public boolean getFollowDataInSubranges() {
      return this.followDataInSubranges;
   }

   public void setFollowDataInSubranges(boolean var1) {
      this.followDataInSubranges = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public boolean getUseSubrangePaint() {
      return this.useSubrangePaint;
   }

   public void setUseSubrangePaint(boolean var1) {
      this.useSubrangePaint = var1;
      this.notifyListeners(new PlotChangeEvent(this));
   }

   public void draw(Graphics2D var1, Rectangle2D var2, Point2D var3, PlotState var4, PlotRenderingInfo var5) {
      Double var6 = new Double();
      Double var7 = new Double();
      Double var8 = new Double();
      java.awt.geom.Ellipse2D.Double var9 = new java.awt.geom.Ellipse2D.Double();
      java.awt.geom.Ellipse2D.Double var10 = new java.awt.geom.Ellipse2D.Double();
      String var11 = null;
      FontMetrics var12 = null;
      if(var5 != null) {
         var5.setPlotArea(var2);
      }

      RectangleInsets var13 = this.getInsets();
      var13.trim(var2);
      this.drawBackground(var1, var2);
      Rectangle2D var14 = (Rectangle2D)var2.clone();
      this.padding.trim(var14);
      int var15 = (int)(var14.getX() + var14.getWidth() / 2.0D);
      int var16 = (int)(var14.getY() + var14.getHeight() / 2.0D);
      int var17 = (int)(var14.getMinY() + 40.0D);
      int var18 = (int)(var14.getMaxY() - 80.0D);
      java.awt.geom.Rectangle2D.Double var19 = new java.awt.geom.Rectangle2D.Double((double)(var15 - 20), (double)var17, 20.0D, (double)(var18 - var17));
      var9.setFrame((double)(var15 - 40), (double)var18, 80.0D, 80.0D);
      var6.setRoundRect((double)(var15 - 20), var14.getMinY(), 40.0D, (double)(var18 + 80 - var17), 40.0D, 40.0D);
      Area var20 = new Area(var9);
      Area var21 = new Area(var6);
      var20.add(var21);
      var10.setFrame((double)(var15 - 40 + 5), (double)(var18 + 5), 70.0D, 70.0D);
      var7.setRoundRect((double)(var15 - 20 + 5), var14.getMinY() + 5.0D, 30.0D, (double)(var18 + 80 - 10 - var17), 30.0D, 30.0D);
      Area var22 = new Area(var10);
      var21 = new Area(var7);
      var22.add(var21);
      if(this.dataset != null && this.dataset.getValue() != null) {
         double var23 = this.dataset.getValue().doubleValue();
         double var25 = this.rangeAxis.valueToJava2D(var23, var19, RectangleEdge.LEFT);
         byte var27 = 30;
         byte var28 = 15;
         int var29 = var27 / 2;
         int var30 = (int)Math.round(var25);
         if((double)var30 < 5.0D + var14.getMinY()) {
            var30 = (int)(5.0D + var14.getMinY());
            var29 = 40;
         }

         Area var31 = new Area(var10);
         if(var30 < var18 + 40) {
            var8.setRoundRect((double)(var15 - var28), (double)var30, (double)var27, (double)(var18 + 40 - var30), (double)var29, (double)var29);
            var21 = new Area(var8);
            var31.add(var21);
         }

         var1.setPaint(this.getCurrentPaint());
         var1.fill(var31);
         if(this.subrangeIndicatorsVisible) {
            var1.setStroke(this.subrangeIndicatorStroke);
            Range var32 = this.rangeAxis.getRange();
            double var33 = this.subrangeInfo[0][0];
            double var35;
            double var37;
            java.awt.geom.Line2D.Double var39;
            if(var32.contains(var33)) {
               var35 = (double)(var15 + 20 + 2);
               var37 = this.rangeAxis.valueToJava2D(var33, var19, RectangleEdge.LEFT);
               var39 = new java.awt.geom.Line2D.Double(var35, var37, var35 + 10.0D, var37);
               var1.setPaint(this.subrangePaint[0]);
               var1.draw(var39);
            }

            var33 = this.subrangeInfo[1][0];
            if(var32.contains(var33)) {
               var35 = (double)(var15 + 20 + 2);
               var37 = this.rangeAxis.valueToJava2D(var33, var19, RectangleEdge.LEFT);
               var39 = new java.awt.geom.Line2D.Double(var35, var37, var35 + 10.0D, var37);
               var1.setPaint(this.subrangePaint[1]);
               var1.draw(var39);
            }

            var33 = this.subrangeInfo[2][0];
            if(var32.contains(var33)) {
               var35 = (double)(var15 + 20 + 2);
               var37 = this.rangeAxis.valueToJava2D(var33, var19, RectangleEdge.LEFT);
               var39 = new java.awt.geom.Line2D.Double(var35, var37, var35 + 10.0D, var37);
               var1.setPaint(this.subrangePaint[2]);
               var1.draw(var39);
            }
         }

         if(this.rangeAxis != null && this.axisLocation != 0) {
            int var42 = 10;
            if(this.showValueLines) {
               var42 += 40;
            }

            double var34 = 0.0D;
            java.awt.geom.Rectangle2D.Double var44;
            switch(this.axisLocation) {
            case 1:
               var34 = (double)(var15 + 20);
               var44 = new java.awt.geom.Rectangle2D.Double(var34, (double)var17, (double)var42, (double)(var18 - var17 + 1));
               this.rangeAxis.draw(var1, var34, var2, var44, RectangleEdge.RIGHT, (PlotRenderingInfo)null);
               break;
            case 2:
            default:
               var34 = (double)(var15 - 20);
               var44 = new java.awt.geom.Rectangle2D.Double(var34, (double)var17, (double)var42, (double)(var18 - var17 + 1));
               this.rangeAxis.draw(var1, var34, var2, var44, RectangleEdge.LEFT, (PlotRenderingInfo)null);
            }
         }

         var1.setFont(this.valueFont);
         var1.setPaint(this.valuePaint);
         var12 = var1.getFontMetrics();
         switch(this.valueLocation) {
         case 1:
            var1.drawString(this.valueFormat.format(var23), var15 + 20 + 5, var16);
            break;
         case 2:
            String var43 = this.valueFormat.format(var23);
            int var45 = var12.stringWidth(var43);
            var1.drawString(var43, var15 - 20 - 5 - var45, var16);
            break;
         case 3:
            var11 = this.valueFormat.format(var23);
            int var41 = var12.stringWidth(var11) / 2;
            var1.drawString(var11, var15 - var41, var18 + 40 + 5);
         }
      }

      var1.setPaint(this.thermometerPaint);
      var1.setFont(this.valueFont);
      var12 = var1.getFontMetrics();
      int var40 = var15 - 20 - 10 - var12.stringWidth(UNITS[this.units]);
      if((double)var40 > var2.getMinX()) {
         var1.drawString(UNITS[this.units], var40, (int)(var2.getMinY() + 20.0D));
      }

      var1.setStroke(this.thermometerStroke);
      var1.draw(var20);
      var1.draw(var22);
      this.drawOutline(var1, var2);
   }

   public void zoom(double var1) {
   }

   public String getPlotType() {
      return localizationResources.getString("Thermometer_Plot");
   }

   public void datasetChanged(DatasetChangeEvent var1) {
      Number var2 = this.dataset.getValue();
      if(var2 != null) {
         double var3 = var2.doubleValue();
         if(this.inSubrange(0, var3)) {
            this.subrange = 0;
         } else if(this.inSubrange(1, var3)) {
            this.subrange = 1;
         } else if(this.inSubrange(2, var3)) {
            this.subrange = 2;
         } else {
            this.subrange = -1;
         }

         this.setAxisRange();
      }

      super.datasetChanged(var1);
   }

   public Number getMinimumVerticalDataValue() {
      return new java.lang.Double(this.lowerBound);
   }

   public Number getMaximumVerticalDataValue() {
      return new java.lang.Double(this.upperBound);
   }

   public Range getDataRange(ValueAxis var1) {
      return new Range(this.lowerBound, this.upperBound);
   }

   protected void setAxisRange() {
      if(this.subrange >= 0 && this.followDataInSubranges) {
         this.rangeAxis.setRange(new Range(this.subrangeInfo[this.subrange][2], this.subrangeInfo[this.subrange][3]));
      } else {
         this.rangeAxis.setRange(this.lowerBound, this.upperBound);
      }

   }

   public LegendItemCollection getLegendItems() {
      return null;
   }

   public PlotOrientation getOrientation() {
      return PlotOrientation.VERTICAL;
   }

   protected static boolean isValidNumber(double var0) {
      return !java.lang.Double.isNaN(var0) && !java.lang.Double.isInfinite(var0);
   }

   private boolean inSubrange(int var1, double var2) {
      return var2 > this.subrangeInfo[var1][0] && var2 <= this.subrangeInfo[var1][1];
   }

   private Paint getCurrentPaint() {
      Paint var1 = this.mercuryPaint;
      if(this.useSubrangePaint) {
         double var2 = this.dataset.getValue().doubleValue();
         if(this.inSubrange(0, var2)) {
            var1 = this.subrangePaint[0];
         } else if(this.inSubrange(1, var2)) {
            var1 = this.subrangePaint[1];
         } else if(this.inSubrange(2, var2)) {
            var1 = this.subrangePaint[2];
         }
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof ThermometerPlot)) {
         return false;
      } else {
         ThermometerPlot var2 = (ThermometerPlot)var1;
         if(!super.equals(var1)) {
            return false;
         } else if(!ObjectUtilities.equal(this.rangeAxis, var2.rangeAxis)) {
            return false;
         } else if(this.axisLocation != var2.axisLocation) {
            return false;
         } else if(this.lowerBound != var2.lowerBound) {
            return false;
         } else if(this.upperBound != var2.upperBound) {
            return false;
         } else if(!ObjectUtilities.equal(this.padding, var2.padding)) {
            return false;
         } else if(!ObjectUtilities.equal(this.thermometerStroke, var2.thermometerStroke)) {
            return false;
         } else if(!PaintUtilities.equal(this.thermometerPaint, var2.thermometerPaint)) {
            return false;
         } else if(this.units != var2.units) {
            return false;
         } else if(this.valueLocation != var2.valueLocation) {
            return false;
         } else if(!ObjectUtilities.equal(this.valueFont, var2.valueFont)) {
            return false;
         } else if(!PaintUtilities.equal(this.valuePaint, var2.valuePaint)) {
            return false;
         } else if(!ObjectUtilities.equal(this.valueFormat, var2.valueFormat)) {
            return false;
         } else if(!PaintUtilities.equal(this.mercuryPaint, var2.mercuryPaint)) {
            return false;
         } else if(this.showValueLines != var2.showValueLines) {
            return false;
         } else if(this.subrange != var2.subrange) {
            return false;
         } else if(this.followDataInSubranges != var2.followDataInSubranges) {
            return false;
         } else if(!equal(this.subrangeInfo, var2.subrangeInfo)) {
            return false;
         } else if(this.useSubrangePaint != var2.useSubrangePaint) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.subrangePaint.length; ++var3) {
               if(!PaintUtilities.equal(this.subrangePaint[var3], var2.subrangePaint[var3])) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   private static boolean equal(double[][] var0, double[][] var1) {
      if(var0 == null) {
         return var1 == null;
      } else if(var1 == null) {
         return false;
      } else if(var0.length != var1.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.length; ++var2) {
            if(!Arrays.equals(var0[var2], var1[var2])) {
               return false;
            }
         }

         return true;
      }
   }

   public Object clone() {
      ThermometerPlot var1 = (ThermometerPlot)super.clone();
      if(var1.dataset != null) {
         var1.dataset.addChangeListener(var1);
      }

      var1.rangeAxis = (ValueAxis)ObjectUtilities.clone(this.rangeAxis);
      if(var1.rangeAxis != null) {
         var1.rangeAxis.setPlot(var1);
         var1.rangeAxis.addChangeListener(var1);
      }

      var1.valueFormat = (NumberFormat)this.valueFormat.clone();
      var1.subrangePaint = (Paint[])((Paint[])this.subrangePaint.clone());
      return var1;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.thermometerStroke, var1);
      SerialUtilities.writePaint(this.thermometerPaint, var1);
      SerialUtilities.writePaint(this.valuePaint, var1);
      SerialUtilities.writePaint(this.mercuryPaint, var1);
      SerialUtilities.writeStroke(this.subrangeIndicatorStroke, var1);
      SerialUtilities.writeStroke(this.rangeIndicatorStroke, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.thermometerStroke = SerialUtilities.readStroke(var1);
      this.thermometerPaint = SerialUtilities.readPaint(var1);
      this.valuePaint = SerialUtilities.readPaint(var1);
      this.mercuryPaint = SerialUtilities.readPaint(var1);
      this.subrangeIndicatorStroke = SerialUtilities.readStroke(var1);
      this.rangeIndicatorStroke = SerialUtilities.readStroke(var1);
      if(this.rangeAxis != null) {
         this.rangeAxis.addChangeListener(this);
      }

   }

   public void zoomDomainAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
   }

   public void zoomRangeAxes(double var1, PlotRenderingInfo var3, Point2D var4) {
      this.rangeAxis.resizeRange(var1);
   }

   public void zoomDomainAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
   }

   public void zoomRangeAxes(double var1, double var3, PlotRenderingInfo var5, Point2D var6) {
      this.rangeAxis.zoomRange(var1, var3);
   }

   public boolean isDomainZoomable() {
      return false;
   }

   public boolean isRangeZoomable() {
      return true;
   }
}
