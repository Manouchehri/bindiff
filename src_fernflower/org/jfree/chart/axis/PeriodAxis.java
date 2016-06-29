package org.jfree.chart.axis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Line2D.Float;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.io.SerialUtilities;
import org.jfree.text.TextUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.TextAnchor;
import org.jfree.util.PublicCloneable;

public class PeriodAxis extends ValueAxis implements Serializable, Cloneable, PublicCloneable {
   private static final long serialVersionUID = 8353295532075872069L;
   private RegularTimePeriod first;
   private RegularTimePeriod last;
   private TimeZone timeZone;
   private Calendar calendar;
   private Class autoRangeTimePeriodClass;
   private Class majorTickTimePeriodClass;
   private boolean minorTickMarksVisible;
   private Class minorTickTimePeriodClass;
   private float minorTickMarkInsideLength;
   private float minorTickMarkOutsideLength;
   private transient Stroke minorTickMarkStroke;
   private transient Paint minorTickMarkPaint;
   private PeriodAxisLabelInfo[] labelInfo;
   static Class class$org$jfree$data$time$Month;
   static Class class$org$jfree$data$time$Year;
   static Class class$java$util$Date;
   static Class class$java$util$TimeZone;

   public PeriodAxis(String var1) {
      this(var1, new Day(), new Day());
   }

   public PeriodAxis(String var1, RegularTimePeriod var2, RegularTimePeriod var3) {
      this(var1, var2, var3, TimeZone.getDefault());
   }

   public PeriodAxis(String var1, RegularTimePeriod var2, RegularTimePeriod var3, TimeZone var4) {
      super(var1, (TickUnitSource)null);
      this.minorTickMarkInsideLength = 0.0F;
      this.minorTickMarkOutsideLength = 2.0F;
      this.minorTickMarkStroke = new BasicStroke(0.5F);
      this.minorTickMarkPaint = Color.black;
      this.first = var2;
      this.last = var3;
      this.timeZone = var4;
      this.calendar = Calendar.getInstance(var4);
      this.autoRangeTimePeriodClass = var2.getClass();
      this.majorTickTimePeriodClass = var2.getClass();
      this.minorTickMarksVisible = false;
      this.minorTickTimePeriodClass = RegularTimePeriod.downsize(this.majorTickTimePeriodClass);
      this.setAutoRange(true);
      this.labelInfo = new PeriodAxisLabelInfo[2];
      this.labelInfo[0] = new PeriodAxisLabelInfo(class$org$jfree$data$time$Month == null?(class$org$jfree$data$time$Month = class$("org.jfree.data.time.Month")):class$org$jfree$data$time$Month, new SimpleDateFormat("MMM"));
      this.labelInfo[1] = new PeriodAxisLabelInfo(class$org$jfree$data$time$Year == null?(class$org$jfree$data$time$Year = class$("org.jfree.data.time.Year")):class$org$jfree$data$time$Year, new SimpleDateFormat("yyyy"));
   }

   public RegularTimePeriod getFirst() {
      return this.first;
   }

   public void setFirst(RegularTimePeriod var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'first\' argument.");
      } else {
         this.first = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public RegularTimePeriod getLast() {
      return this.last;
   }

   public void setLast(RegularTimePeriod var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'last\' argument.");
      } else {
         this.last = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public TimeZone getTimeZone() {
      return this.timeZone;
   }

   public void setTimeZone(TimeZone var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else {
         this.timeZone = var1;
         this.calendar = Calendar.getInstance(var1);
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Class getAutoRangeTimePeriodClass() {
      return this.autoRangeTimePeriodClass;
   }

   public void setAutoRangeTimePeriodClass(Class var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'c\' argument.");
      } else {
         this.autoRangeTimePeriodClass = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Class getMajorTickTimePeriodClass() {
      return this.majorTickTimePeriodClass;
   }

   public void setMajorTickTimePeriodClass(Class var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'c\' argument.");
      } else {
         this.majorTickTimePeriodClass = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public boolean isMinorTickMarksVisible() {
      return this.minorTickMarksVisible;
   }

   public void setMinorTickMarksVisible(boolean var1) {
      this.minorTickMarksVisible = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public Class getMinorTickTimePeriodClass() {
      return this.minorTickTimePeriodClass;
   }

   public void setMinorTickTimePeriodClass(Class var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'c\' argument.");
      } else {
         this.minorTickTimePeriodClass = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Stroke getMinorTickMarkStroke() {
      return this.minorTickMarkStroke;
   }

   public void setMinorTickMarkStroke(Stroke var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'stroke\' argument.");
      } else {
         this.minorTickMarkStroke = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public Paint getMinorTickMarkPaint() {
      return this.minorTickMarkPaint;
   }

   public void setMinorTickMarkPaint(Paint var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'paint\' argument.");
      } else {
         this.minorTickMarkPaint = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public float getMinorTickMarkInsideLength() {
      return this.minorTickMarkInsideLength;
   }

   public void setMinorTickMarkInsideLength(float var1) {
      this.minorTickMarkInsideLength = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public float getMinorTickMarkOutsideLength() {
      return this.minorTickMarkOutsideLength;
   }

   public void setMinorTickMarkOutsideLength(float var1) {
      this.minorTickMarkOutsideLength = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public PeriodAxisLabelInfo[] getLabelInfo() {
      return this.labelInfo;
   }

   public void setLabelInfo(PeriodAxisLabelInfo[] var1) {
      this.labelInfo = var1;
   }

   public Range getRange() {
      return new Range((double)this.first.getFirstMillisecond(this.calendar), (double)this.last.getLastMillisecond(this.calendar));
   }

   public void setRange(Range var1, boolean var2, boolean var3) {
      super.setRange(var1, var2, false);
      long var4 = Math.round(var1.getUpperBound());
      long var6 = Math.round(var1.getLowerBound());
      this.first = this.createInstance(this.autoRangeTimePeriodClass, new Date(var6), this.timeZone);
      this.last = this.createInstance(this.autoRangeTimePeriodClass, new Date(var4), this.timeZone);
   }

   public void configure() {
      if(this.isAutoRange()) {
         this.autoAdjustRange();
      }

   }

   public AxisSpace reserveSpace(Graphics2D var1, Plot var2, Rectangle2D var3, RectangleEdge var4, AxisSpace var5) {
      if(var5 == null) {
         var5 = new AxisSpace();
      }

      if(!this.isVisible()) {
         return var5;
      } else {
         double var6 = this.getFixedDimension();
         if(var6 > 0.0D) {
            var5.ensureAtLeast(var6, var4);
         }

         Rectangle2D var8 = this.getLabelEnclosure(var1, var4);
         double var9 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;

         for(int var15 = 0; var15 < this.labelInfo.length; ++var15) {
            PeriodAxisLabelInfo var16 = this.labelInfo[var15];
            FontMetrics var17 = var1.getFontMetrics(var16.getLabelFont());
            var13 += var16.getPadding().extendHeight((double)var17.getHeight());
         }

         if(RectangleEdge.isTopOrBottom(var4)) {
            var9 = var8.getHeight();
            var5.add(var9 + var13, var4);
         } else if(RectangleEdge.isLeftOrRight(var4)) {
            var11 = var8.getWidth();
            var5.add(var11 + var13, var4);
         }

         double var18 = 0.0D;
         if(this.isTickMarksVisible()) {
            var18 = (double)this.getTickMarkOutsideLength();
         }

         if(this.minorTickMarksVisible) {
            var18 = Math.max(var18, (double)this.minorTickMarkOutsideLength);
         }

         var5.add(var18, var4);
         return var5;
      }
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      AxisState var8 = new AxisState(var2);
      if(this.isAxisLineVisible()) {
         this.drawAxisLine(var1, var2, var5, var6);
      }

      this.drawTickMarks(var1, var8, var5, var6);

      for(int var9 = 0; var9 < this.labelInfo.length; ++var9) {
         var8 = this.drawTickLabels(var9, var1, var8, var5, var6);
      }

      var8 = this.drawLabel(this.getLabel(), var1, var4, var5, var6, var8);
      return var8;
   }

   protected void drawTickMarks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
      if(RectangleEdge.isTopOrBottom(var4)) {
         this.drawTickMarksHorizontal(var1, var2, var3, var4);
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         this.drawTickMarksVertical(var1, var2, var3, var4);
      }

   }

   protected void drawTickMarksHorizontal(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
      ArrayList var5 = new ArrayList();
      double var6 = var3.getX();
      double var8 = var2.getCursor();
      double var10 = (double)this.getTickMarkInsideLength();
      double var12 = (double)this.getTickMarkOutsideLength();
      RegularTimePeriod var14 = RegularTimePeriod.createInstance(this.majorTickTimePeriodClass, this.first.getStart(), this.getTimeZone());
      long var15 = var14.getFirstMillisecond(this.calendar);
      Double var17 = null;
      Double var18 = null;
      long var19 = this.getFirst().getFirstMillisecond(this.calendar);

      for(long var21 = this.getLast().getLastMillisecond(this.calendar); var15 <= var21; var15 = var14.getFirstMillisecond(this.calendar)) {
         var5.add(new NumberTick(new java.lang.Double((double)var15), "", TextAnchor.CENTER, TextAnchor.CENTER, 0.0D));
         var6 = this.valueToJava2D((double)var15, var3, var4);
         if(var4 == RectangleEdge.TOP) {
            var17 = new Double(var6, var8, var6, var8 + var10);
            var18 = new Double(var6, var8, var6, var8 - var12);
         } else if(var4 == RectangleEdge.BOTTOM) {
            var17 = new Double(var6, var8, var6, var8 - var10);
            var18 = new Double(var6, var8, var6, var8 + var12);
         }

         if(var15 > var19) {
            var1.setPaint(this.getTickMarkPaint());
            var1.setStroke(this.getTickMarkStroke());
            var1.draw(var17);
            var1.draw(var18);
         }

         if(this.minorTickMarksVisible) {
            RegularTimePeriod var23 = RegularTimePeriod.createInstance(this.minorTickTimePeriodClass, new Date(var15), this.getTimeZone());

            for(long var24 = var23.getFirstMillisecond(this.calendar); var24 < var14.getLastMillisecond(this.calendar) && var24 < var21; var24 = var23.getFirstMillisecond(this.calendar)) {
               double var26 = this.valueToJava2D((double)var24, var3, var4);
               if(var4 == RectangleEdge.TOP) {
                  var17 = new Double(var26, var8, var26, var8 + (double)this.minorTickMarkInsideLength);
                  var18 = new Double(var26, var8, var26, var8 - (double)this.minorTickMarkOutsideLength);
               } else if(var4 == RectangleEdge.BOTTOM) {
                  var17 = new Double(var26, var8, var26, var8 - (double)this.minorTickMarkInsideLength);
                  var18 = new Double(var26, var8, var26, var8 + (double)this.minorTickMarkOutsideLength);
               }

               if(var24 >= var19) {
                  var1.setPaint(this.minorTickMarkPaint);
                  var1.setStroke(this.minorTickMarkStroke);
                  var1.draw(var17);
                  var1.draw(var18);
               }

               var23 = var23.next();
            }
         }

         var14 = var14.next();
      }

      if(var4 == RectangleEdge.TOP) {
         var2.cursorUp(Math.max(var12, (double)this.minorTickMarkOutsideLength));
      } else if(var4 == RectangleEdge.BOTTOM) {
         var2.cursorDown(Math.max(var12, (double)this.minorTickMarkOutsideLength));
      }

      var2.setTicks(var5);
   }

   protected void drawTickMarksVertical(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
   }

   protected AxisState drawTickLabels(int var1, Graphics2D var2, AxisState var3, Rectangle2D var4, RectangleEdge var5) {
      double var6 = 0.0D;
      FontMetrics var8 = var2.getFontMetrics(this.labelInfo[var1].getLabelFont());
      if(var5 == RectangleEdge.BOTTOM) {
         var6 = this.labelInfo[var1].getPadding().calculateTopOutset((double)var8.getHeight());
      } else if(var5 == RectangleEdge.TOP) {
         var6 = this.labelInfo[var1].getPadding().calculateBottomOutset((double)var8.getHeight());
      }

      var3.moveCursor(var6, var5);
      long var9 = this.first.getFirstMillisecond(this.calendar);
      long var11 = this.last.getLastMillisecond(this.calendar);
      var2.setFont(this.labelInfo[var1].getLabelFont());
      var2.setPaint(this.labelInfo[var1].getLabelPaint());
      RegularTimePeriod var13 = this.labelInfo[var1].createInstance(new Date(var9), this.timeZone);
      RegularTimePeriod var14 = this.labelInfo[var1].createInstance(new Date(var11), this.timeZone);
      String var15 = this.labelInfo[var1].getDateFormat().format(new Date(var13.getMiddleMillisecond(this.calendar)));
      String var16 = this.labelInfo[var1].getDateFormat().format(new Date(var14.getMiddleMillisecond(this.calendar)));
      Rectangle2D var17 = TextUtilities.getTextBounds(var15, var2, var2.getFontMetrics());
      Rectangle2D var18 = TextUtilities.getTextBounds(var16, var2, var2.getFontMetrics());
      double var19 = Math.max(var17.getWidth(), var18.getWidth());
      long var21 = Math.round(this.java2DToValue(var4.getX() + var19 + 5.0D, var4, var5)) - var9;
      long var23 = var13.getLastMillisecond(this.calendar) - var13.getFirstMillisecond(this.calendar);
      int var25 = (int)(var21 / var23) + 1;
      RegularTimePeriod var26 = this.labelInfo[var1].createInstance(new Date(var9), this.timeZone);
      Rectangle2D var27 = null;
      long var28 = 0L;
      float var30 = (float)var3.getCursor();
      TextAnchor var31 = TextAnchor.TOP_CENTER;
      float var32 = (float)var17.getHeight();
      if(var5 == RectangleEdge.TOP) {
         var31 = TextAnchor.BOTTOM_CENTER;
         var32 = -var32;
      }

      while(var26.getFirstMillisecond(this.calendar) <= var11) {
         float var33 = (float)this.valueToJava2D((double)var26.getMiddleMillisecond(this.calendar), var4, var5);
         DateFormat var34 = this.labelInfo[var1].getDateFormat();
         String var35 = var34.format(new Date(var26.getMiddleMillisecond(this.calendar)));
         long var36 = var26.getFirstMillisecond(this.calendar);
         long var38 = var26.getLastMillisecond(this.calendar);
         Rectangle2D var40;
         float var41;
         if(var38 > var11) {
            var40 = TextUtilities.getTextBounds(var35, var2, var2.getFontMetrics());
            if((double)var33 + var40.getWidth() / 2.0D > var4.getMaxX()) {
               var41 = (float)this.valueToJava2D((double)Math.max(var36, var9), var4, var5);
               if(var40.getWidth() < var4.getMaxX() - (double)var41) {
                  var33 = ((float)var4.getMaxX() + var41) / 2.0F;
               } else {
                  var35 = null;
               }
            }
         }

         if(var36 < var9) {
            var40 = TextUtilities.getTextBounds(var35, var2, var2.getFontMetrics());
            if((double)var33 - var40.getWidth() / 2.0D < var4.getX()) {
               var41 = (float)this.valueToJava2D((double)Math.min(var38, var11), var4, var5);
               if(var40.getWidth() < (double)var41 - var4.getX()) {
                  var33 = (var41 + (float)var4.getX()) / 2.0F;
               } else {
                  var35 = null;
               }
            }
         }

         if(var35 != null) {
            var2.setPaint(this.labelInfo[var1].getLabelPaint());
            var27 = TextUtilities.drawAlignedString(var35, var2, var33, var30, var31);
         }

         if(var28 > 0L && this.labelInfo[var1].getDrawDividers()) {
            long var46 = var26.getFirstMillisecond(this.calendar);
            long var42 = (var28 + var46) / 2L;
            float var44 = (float)this.valueToJava2D((double)var42, var4, var5);
            var2.setStroke(this.labelInfo[var1].getDividerStroke());
            var2.setPaint(this.labelInfo[var1].getDividerPaint());
            var2.draw(new Float(var44, var30, var44, var30 + var32));
         }

         var28 = var38;

         for(int var47 = 0; var47 < var25; ++var47) {
            var26 = var26.next();
         }
      }

      double var45 = 0.0D;
      if(var27 != null) {
         var45 = var27.getHeight();
         if(var5 == RectangleEdge.BOTTOM) {
            var45 += this.labelInfo[var1].getPadding().calculateBottomOutset((double)var8.getHeight());
         } else if(var5 == RectangleEdge.TOP) {
            var45 += this.labelInfo[var1].getPadding().calculateTopOutset((double)var8.getHeight());
         }
      }

      var3.moveCursor(var45, var5);
      return var3;
   }

   public List refreshTicks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
      return Collections.EMPTY_LIST;
   }

   public double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      double var5 = java.lang.Double.NaN;
      double var7 = (double)this.first.getFirstMillisecond(this.calendar);
      double var9 = (double)this.last.getLastMillisecond(this.calendar);
      double var11;
      double var13;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var11 = var3.getX();
         var13 = var3.getMaxX();
         if(this.isInverted()) {
            var5 = var13 + (var1 - var7) / (var9 - var7) * (var11 - var13);
         } else {
            var5 = var11 + (var1 - var7) / (var9 - var7) * (var13 - var11);
         }
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var11 = var3.getMinY();
         var13 = var3.getMaxY();
         if(this.isInverted()) {
            var5 = var11 + (var1 - var7) / (var9 - var7) * (var13 - var11);
         } else {
            var5 = var13 - (var1 - var7) / (var9 - var7) * (var13 - var11);
         }
      }

      return var5;
   }

   public double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4) {
      double var5 = java.lang.Double.NaN;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = (double)this.first.getFirstMillisecond(this.calendar);
      double var13 = (double)this.last.getLastMillisecond(this.calendar);
      if(RectangleEdge.isTopOrBottom(var4)) {
         var7 = var3.getX();
         var9 = var3.getMaxX();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var7 = var3.getMaxY();
         var9 = var3.getY();
      }

      if(this.isInverted()) {
         var5 = var13 - (var1 - var7) / (var9 - var7) * (var13 - var11);
      } else {
         var5 = var11 + (var1 - var7) / (var9 - var7) * (var13 - var11);
      }

      return var5;
   }

   protected void autoAdjustRange() {
      Plot var1 = this.getPlot();
      if(var1 != null) {
         if(var1 instanceof ValueAxisPlot) {
            ValueAxisPlot var2 = (ValueAxisPlot)var1;
            Range var3 = var2.getDataRange(this);
            if(var3 == null) {
               var3 = this.getDefaultAutoRange();
            }

            long var4 = Math.round(var3.getUpperBound());
            long var6 = Math.round(var3.getLowerBound());
            this.first = this.createInstance(this.autoRangeTimePeriodClass, new Date(var6), this.timeZone);
            this.last = this.createInstance(this.autoRangeTimePeriodClass, new Date(var4), this.timeZone);
            this.setRange(var3, false, false);
         }

      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof PeriodAxis && super.equals(var1)) {
         PeriodAxis var2 = (PeriodAxis)var1;
         return !this.first.equals(var2.first)?false:(!this.last.equals(var2.last)?false:(!this.timeZone.equals(var2.timeZone)?false:(!this.autoRangeTimePeriodClass.equals(var2.autoRangeTimePeriodClass)?false:(this.isMinorTickMarksVisible() != var2.isMinorTickMarksVisible()?false:(!this.majorTickTimePeriodClass.equals(var2.majorTickTimePeriodClass)?false:(!this.minorTickTimePeriodClass.equals(var2.minorTickTimePeriodClass)?false:(!this.minorTickMarkPaint.equals(var2.minorTickMarkPaint)?false:(!this.minorTickMarkStroke.equals(var2.minorTickMarkStroke)?false:Arrays.equals(this.labelInfo, var2.labelInfo)))))))));
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.getLabel() != null?this.getLabel().hashCode():0;
   }

   public Object clone() {
      PeriodAxis var1 = (PeriodAxis)super.clone();
      var1.timeZone = (TimeZone)this.timeZone.clone();
      var1.labelInfo = new PeriodAxisLabelInfo[this.labelInfo.length];

      for(int var2 = 0; var2 < this.labelInfo.length; ++var2) {
         var1.labelInfo[var2] = this.labelInfo[var2];
      }

      return var1;
   }

   private RegularTimePeriod createInstance(Class var1, Date var2, TimeZone var3) {
      RegularTimePeriod var4 = null;

      try {
         Constructor var5 = var1.getDeclaredConstructor(new Class[]{class$java$util$Date == null?(class$java$util$Date = class$("java.util.Date")):class$java$util$Date, class$java$util$TimeZone == null?(class$java$util$TimeZone = class$("java.util.TimeZone")):class$java$util$TimeZone});
         var4 = (RegularTimePeriod)var5.newInstance(new Object[]{var2, var3});
      } catch (Exception var6) {
         ;
      }

      return var4;
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      SerialUtilities.writeStroke(this.minorTickMarkStroke, var1);
      SerialUtilities.writePaint(this.minorTickMarkPaint, var1);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      this.minorTickMarkStroke = SerialUtilities.readStroke(var1);
      this.minorTickMarkPaint = SerialUtilities.readPaint(var1);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
