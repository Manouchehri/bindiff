package org.jfree.chart.axis;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.DateAxis$1;
import org.jfree.chart.axis.DateAxis$DefaultTimeline;
import org.jfree.chart.axis.DateTick;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.Timeline;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.AxisChangeEvent;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.ValueAxisPlot;
import org.jfree.data.Range;
import org.jfree.data.time.DateRange;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Year;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class DateAxis extends ValueAxis implements Serializable, Cloneable {
   private static final long serialVersionUID = -1013460999649007604L;
   public static final DateRange DEFAULT_DATE_RANGE = new DateRange();
   public static final double DEFAULT_AUTO_RANGE_MINIMUM_SIZE_IN_MILLISECONDS = 2.0D;
   public static final DateTickUnit DEFAULT_DATE_TICK_UNIT = new DateTickUnit(2, 1, new SimpleDateFormat());
   public static final Date DEFAULT_ANCHOR_DATE = new Date();
   private DateTickUnit tickUnit;
   private DateFormat dateFormatOverride;
   private DateTickMarkPosition tickMarkPosition;
   private static final Timeline DEFAULT_TIMELINE = new DateAxis$DefaultTimeline((DateAxis$1)null);
   private TimeZone timeZone;
   private Timeline timeline;

   public DateAxis() {
      this((String)null);
   }

   public DateAxis(String var1) {
      this(var1, TimeZone.getDefault());
   }

   public DateAxis(String var1, TimeZone var2) {
      super(var1, createStandardDateTickUnits(var2));
      this.tickMarkPosition = DateTickMarkPosition.START;
      this.setTickUnit(DEFAULT_DATE_TICK_UNIT, false, false);
      this.setAutoRangeMinimumSize(2.0D);
      this.setRange(DEFAULT_DATE_RANGE, false, false);
      this.dateFormatOverride = null;
      this.timeZone = var2;
      this.timeline = DEFAULT_TIMELINE;
   }

   public TimeZone getTimeZone() {
      return this.timeZone;
   }

   public void setTimeZone(TimeZone var1) {
      if(!this.timeZone.equals(var1)) {
         this.timeZone = var1;
         this.setStandardTickUnits(createStandardDateTickUnits(var1));
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public Timeline getTimeline() {
      return this.timeline;
   }

   public void setTimeline(Timeline var1) {
      if(this.timeline != var1) {
         this.timeline = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public DateTickUnit getTickUnit() {
      return this.tickUnit;
   }

   public void setTickUnit(DateTickUnit var1) {
      this.setTickUnit(var1, true, true);
   }

   public void setTickUnit(DateTickUnit var1, boolean var2, boolean var3) {
      this.tickUnit = var1;
      if(var3) {
         this.setAutoTickUnitSelection(false, false);
      }

      if(var2) {
         this.notifyListeners(new AxisChangeEvent(this));
      }

   }

   public DateFormat getDateFormatOverride() {
      return this.dateFormatOverride;
   }

   public void setDateFormatOverride(DateFormat var1) {
      this.dateFormatOverride = var1;
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public void setRange(Range var1) {
      this.setRange(var1, true, true);
   }

   public void setRange(Range var1, boolean var2, boolean var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'range\' argument.");
      } else {
         if(!(var1 instanceof DateRange)) {
            var1 = new DateRange((Range)var1);
         }

         super.setRange((Range)var1, var2, var3);
      }
   }

   public void setRange(Date var1, Date var2) {
      if(var1.getTime() >= var2.getTime()) {
         throw new IllegalArgumentException("Requires \'lower\' < \'upper\'.");
      } else {
         this.setRange(new DateRange(var1, var2));
      }
   }

   public void setRange(double var1, double var3) {
      if(var1 >= var3) {
         throw new IllegalArgumentException("Requires \'lower\' < \'upper\'.");
      } else {
         this.setRange(new DateRange(var1, var3));
      }
   }

   public Date getMinimumDate() {
      Date var1 = null;
      Range var2 = this.getRange();
      if(var2 instanceof DateRange) {
         DateRange var3 = (DateRange)var2;
         var1 = var3.getLowerDate();
      } else {
         var1 = new Date((long)var2.getLowerBound());
      }

      return var1;
   }

   public void setMinimumDate(Date var1) {
      this.setRange(new DateRange(var1, this.getMaximumDate()), true, false);
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public Date getMaximumDate() {
      Date var1 = null;
      Range var2 = this.getRange();
      if(var2 instanceof DateRange) {
         DateRange var3 = (DateRange)var2;
         var1 = var3.getUpperDate();
      } else {
         var1 = new Date((long)var2.getUpperBound());
      }

      return var1;
   }

   public void setMaximumDate(Date var1) {
      this.setRange(new DateRange(this.getMinimumDate(), var1), true, false);
      this.notifyListeners(new AxisChangeEvent(this));
   }

   public DateTickMarkPosition getTickMarkPosition() {
      return this.tickMarkPosition;
   }

   public void setTickMarkPosition(DateTickMarkPosition var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else {
         this.tickMarkPosition = var1;
         this.notifyListeners(new AxisChangeEvent(this));
      }
   }

   public void configure() {
      if(this.isAutoRange()) {
         this.autoAdjustRange();
      }

   }

   public boolean isHiddenValue(long var1) {
      return !this.timeline.containsDomainValue(new Date(var1));
   }

   public double valueToJava2D(double var1, Rectangle2D var3, RectangleEdge var4) {
      var1 = (double)this.timeline.toTimelineValue((long)var1);
      DateRange var5 = (DateRange)this.getRange();
      double var6 = (double)this.timeline.toTimelineValue(var5.getLowerDate());
      double var8 = (double)this.timeline.toTimelineValue(var5.getUpperDate());
      double var10 = 0.0D;
      double var12;
      double var14;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var12 = var3.getX();
         var14 = var3.getMaxX();
         if(this.isInverted()) {
            var10 = var14 + (var1 - var6) / (var8 - var6) * (var12 - var14);
         } else {
            var10 = var12 + (var1 - var6) / (var8 - var6) * (var14 - var12);
         }
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var12 = var3.getMinY();
         var14 = var3.getMaxY();
         if(this.isInverted()) {
            var10 = var12 + (var1 - var6) / (var8 - var6) * (var14 - var12);
         } else {
            var10 = var14 - (var1 - var6) / (var8 - var6) * (var14 - var12);
         }
      }

      return var10;
   }

   public double dateToJava2D(Date var1, Rectangle2D var2, RectangleEdge var3) {
      double var4 = (double)var1.getTime();
      return this.valueToJava2D(var4, var2, var3);
   }

   public double java2DToValue(double var1, Rectangle2D var3, RectangleEdge var4) {
      DateRange var5 = (DateRange)this.getRange();
      double var6 = (double)this.timeline.toTimelineValue(var5.getLowerDate());
      double var8 = (double)this.timeline.toTimelineValue(var5.getUpperDate());
      double var10 = 0.0D;
      double var12 = 0.0D;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var10 = var3.getX();
         var12 = var3.getMaxX();
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var10 = var3.getMaxY();
         var12 = var3.getY();
      }

      double var14;
      if(this.isInverted()) {
         var14 = var8 - (var1 - var10) / (var12 - var10) * (var8 - var6);
      } else {
         var14 = var6 + (var1 - var10) / (var12 - var10) * (var8 - var6);
      }

      return (double)this.timeline.toMillisecond((long)var14);
   }

   public Date calculateLowestVisibleTickValue(DateTickUnit var1) {
      return this.nextStandardDate(this.getMinimumDate(), var1);
   }

   public Date calculateHighestVisibleTickValue(DateTickUnit var1) {
      return this.previousStandardDate(this.getMaximumDate(), var1);
   }

   protected Date previousStandardDate(Date var1, DateTickUnit var2) {
      Calendar var10 = Calendar.getInstance(this.timeZone);
      var10.setTime(var1);
      int var11 = var2.getCount();
      int var12 = var10.get(var2.getCalendarField());
      int var13 = var11 * (var12 / var11);
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      byte var22;
      switch(var2.getUnit()) {
      case 0:
         byte var27;
         byte var28;
         if(this.tickMarkPosition == DateTickMarkPosition.START) {
            var28 = 0;
            var27 = 1;
         } else if(this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
            var28 = 6;
            var27 = 1;
         } else {
            var28 = 11;
            var27 = 31;
         }

         var10.clear(14);
         var10.set(var13, var28, var27, 0, 0, 0);
         Date var21 = var10.getTime();
         if(var21.getTime() >= var1.getTime()) {
            var10.set(1, var13 - 1);
            var21 = var10.getTime();
         }

         return var21;
      case 1:
         var9 = var10.get(1);
         var10.clear(14);
         var10.set(var9, var13, 1, 0, 0, 0);
         Month var17 = new Month(var10.getTime());
         Date var18 = this.calculateDateForPosition(var17, this.tickMarkPosition);
         long var19 = var18.getTime();
         if(var19 > var1.getTime()) {
            var17 = (Month)var17.previous();
            var18 = this.calculateDateForPosition(var17, this.tickMarkPosition);
         }

         return var18;
      case 2:
         var9 = var10.get(1);
         var8 = var10.get(2);
         byte var24;
         boolean var25;
         boolean var26;
         if(this.tickMarkPosition == DateTickMarkPosition.START) {
            var24 = 0;
            var25 = false;
            var26 = false;
         } else if(this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
            var24 = 12;
            var25 = false;
            var26 = false;
         } else {
            var24 = 23;
            var25 = true;
            var26 = true;
         }

         var10.clear(14);
         var10.set(var9, var8, var13, var24, 0, 0);
         Date var16 = var10.getTime();
         if(var16.getTime() >= var1.getTime()) {
            var10.set(5, var13 - 1);
            var16 = var10.getTime();
         }

         return var16;
      case 3:
         var9 = var10.get(1);
         var8 = var10.get(2);
         var7 = var10.get(5);
         byte var23;
         if(this.tickMarkPosition == DateTickMarkPosition.START) {
            var23 = 0;
            var22 = 0;
         } else if(this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
            var23 = 30;
            var22 = 0;
         } else {
            var23 = 59;
            var22 = 59;
         }

         var10.clear(14);
         var10.set(var9, var8, var7, var13, var23, var22);
         Date var15 = var10.getTime();
         if(var15.getTime() >= var1.getTime()) {
            var10.set(11, var13 - 1);
            var15 = var10.getTime();
         }

         return var15;
      case 4:
         var9 = var10.get(1);
         var8 = var10.get(2);
         var7 = var10.get(5);
         var6 = var10.get(11);
         if(this.tickMarkPosition == DateTickMarkPosition.START) {
            var22 = 0;
         } else if(this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
            var22 = 30;
         } else {
            var22 = 59;
         }

         var10.clear(14);
         var10.set(var9, var8, var7, var6, var13, var22);
         Date var14 = var10.getTime();
         if(var14.getTime() >= var1.getTime()) {
            var10.set(12, var13 - 1);
            var14 = var10.getTime();
         }

         return var14;
      case 5:
         var9 = var10.get(1);
         var8 = var10.get(2);
         var7 = var10.get(5);
         var6 = var10.get(11);
         var5 = var10.get(12);
         short var3;
         if(this.tickMarkPosition == DateTickMarkPosition.START) {
            var3 = 0;
         } else if(this.tickMarkPosition == DateTickMarkPosition.MIDDLE) {
            var3 = 500;
         } else {
            var3 = 999;
         }

         var10.set(14, var3);
         var10.set(var9, var8, var7, var6, var5, var13);
         return var10.getTime();
      case 6:
         var9 = var10.get(1);
         var8 = var10.get(2);
         var7 = var10.get(5);
         var6 = var10.get(11);
         var5 = var10.get(12);
         int var4 = var10.get(13);
         var10.set(var9, var8, var7, var6, var5, var4);
         var10.set(14, var13);
         return var10.getTime();
      default:
         return null;
      }
   }

   private Date calculateDateForPosition(RegularTimePeriod var1, DateTickMarkPosition var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else {
         Date var3 = null;
         if(var2 == DateTickMarkPosition.START) {
            var3 = new Date(var1.getFirstMillisecond());
         } else if(var2 == DateTickMarkPosition.MIDDLE) {
            var3 = new Date(var1.getMiddleMillisecond());
         } else if(var2 == DateTickMarkPosition.END) {
            var3 = new Date(var1.getLastMillisecond());
         }

         return var3;
      }
   }

   protected Date nextStandardDate(Date var1, DateTickUnit var2) {
      Date var3 = this.previousStandardDate(var1, var2);
      Calendar var4 = Calendar.getInstance(this.timeZone);
      var4.setTime(var3);
      var4.add(var2.getCalendarField(), var2.getCount());
      return var4.getTime();
   }

   public static TickUnitSource createStandardDateTickUnits() {
      return createStandardDateTickUnits(TimeZone.getDefault());
   }

   public static TickUnitSource createStandardDateTickUnits(TimeZone var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else {
         TickUnits var1 = new TickUnits();
         SimpleDateFormat var2 = new SimpleDateFormat("HH:mm:ss.SSS");
         SimpleDateFormat var3 = new SimpleDateFormat("HH:mm:ss");
         SimpleDateFormat var4 = new SimpleDateFormat("HH:mm");
         SimpleDateFormat var5 = new SimpleDateFormat("d-MMM, HH:mm");
         SimpleDateFormat var6 = new SimpleDateFormat("d-MMM");
         SimpleDateFormat var7 = new SimpleDateFormat("MMM-yyyy");
         SimpleDateFormat var8 = new SimpleDateFormat("yyyy");
         var2.setTimeZone(var0);
         var3.setTimeZone(var0);
         var4.setTimeZone(var0);
         var5.setTimeZone(var0);
         var6.setTimeZone(var0);
         var7.setTimeZone(var0);
         var8.setTimeZone(var0);
         var1.add(new DateTickUnit(6, 1, var2));
         var1.add(new DateTickUnit(6, 5, 6, 1, var2));
         var1.add(new DateTickUnit(6, 10, 6, 1, var2));
         var1.add(new DateTickUnit(6, 25, 6, 5, var2));
         var1.add(new DateTickUnit(6, 50, 6, 10, var2));
         var1.add(new DateTickUnit(6, 100, 6, 10, var2));
         var1.add(new DateTickUnit(6, 250, 6, 10, var2));
         var1.add(new DateTickUnit(6, 500, 6, 50, var2));
         var1.add(new DateTickUnit(5, 1, 6, 50, var3));
         var1.add(new DateTickUnit(5, 5, 5, 1, var3));
         var1.add(new DateTickUnit(5, 10, 5, 1, var3));
         var1.add(new DateTickUnit(5, 30, 5, 5, var3));
         var1.add(new DateTickUnit(4, 1, 5, 5, var4));
         var1.add(new DateTickUnit(4, 2, 5, 10, var4));
         var1.add(new DateTickUnit(4, 5, 4, 1, var4));
         var1.add(new DateTickUnit(4, 10, 4, 1, var4));
         var1.add(new DateTickUnit(4, 15, 4, 5, var4));
         var1.add(new DateTickUnit(4, 20, 4, 5, var4));
         var1.add(new DateTickUnit(4, 30, 4, 5, var4));
         var1.add(new DateTickUnit(3, 1, 4, 5, var4));
         var1.add(new DateTickUnit(3, 2, 4, 10, var4));
         var1.add(new DateTickUnit(3, 4, 4, 30, var4));
         var1.add(new DateTickUnit(3, 6, 3, 1, var4));
         var1.add(new DateTickUnit(3, 12, 3, 1, var5));
         var1.add(new DateTickUnit(2, 1, 3, 1, var6));
         var1.add(new DateTickUnit(2, 2, 3, 1, var6));
         var1.add(new DateTickUnit(2, 7, 2, 1, var6));
         var1.add(new DateTickUnit(2, 15, 2, 1, var6));
         var1.add(new DateTickUnit(1, 1, 2, 1, var7));
         var1.add(new DateTickUnit(1, 2, 2, 1, var7));
         var1.add(new DateTickUnit(1, 3, 1, 1, var7));
         var1.add(new DateTickUnit(1, 4, 1, 1, var7));
         var1.add(new DateTickUnit(1, 6, 1, 1, var7));
         var1.add(new DateTickUnit(0, 1, 1, 1, var8));
         var1.add(new DateTickUnit(0, 2, 1, 3, var8));
         var1.add(new DateTickUnit(0, 5, 0, 1, var8));
         var1.add(new DateTickUnit(0, 10, 0, 1, var8));
         var1.add(new DateTickUnit(0, 25, 0, 5, var8));
         var1.add(new DateTickUnit(0, 50, 0, 10, var8));
         var1.add(new DateTickUnit(0, 100, 0, 20, var8));
         return var1;
      }
   }

   protected void autoAdjustRange() {
      Plot var1 = this.getPlot();
      if(var1 != null) {
         if(var1 instanceof ValueAxisPlot) {
            ValueAxisPlot var2 = (ValueAxisPlot)var1;
            Object var3 = var2.getDataRange(this);
            if(var3 == null) {
               if(this.timeline instanceof SegmentedTimeline) {
                  var3 = new DateRange((double)((SegmentedTimeline)this.timeline).getStartTime(), (double)(((SegmentedTimeline)this.timeline).getStartTime() + 1L));
               } else {
                  var3 = new DateRange();
               }
            }

            long var4 = this.timeline.toTimelineValue((long)((Range)var3).getUpperBound());
            long var8 = (long)this.getFixedAutoRange();
            long var6;
            if((double)var8 > 0.0D) {
               var6 = var4 - var8;
            } else {
               var6 = this.timeline.toTimelineValue((long)((Range)var3).getLowerBound());
               double var10 = (double)(var4 - var6);
               long var12 = (long)this.getAutoRangeMinimumSize();
               if(var10 < (double)var12) {
                  long var14 = (long)((double)var12 - var10) / 2L;
                  var4 += var14;
                  var6 -= var14;
               }

               var4 += (long)(var10 * this.getUpperMargin());
               var6 -= (long)(var10 * this.getLowerMargin());
            }

            var4 = this.timeline.toMillisecond(var4);
            var6 = this.timeline.toMillisecond(var6);
            DateRange var16 = new DateRange(new Date(var6), new Date(var4));
            this.setRange(var16, false, false);
         }

      }
   }

   protected void selectAutoTickUnit(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      if(RectangleEdge.isTopOrBottom(var3)) {
         this.selectHorizontalAutoTickUnit(var1, var2, var3);
      } else if(RectangleEdge.isLeftOrRight(var3)) {
         this.selectVerticalAutoTickUnit(var1, var2, var3);
      }

   }

   protected void selectHorizontalAutoTickUnit(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      long var4 = 0L;
      if(this.timeline instanceof SegmentedTimeline) {
         var4 = ((SegmentedTimeline)this.timeline).getStartTime();
      }

      double var6 = this.valueToJava2D((double)var4 + 0.0D, var2, var3);
      double var8 = this.estimateMaximumTickLabelWidth(var1, this.getTickUnit());
      TickUnitSource var10 = this.getStandardTickUnits();
      TickUnit var11 = var10.getCeilingTickUnit(this.getTickUnit());
      double var12 = this.valueToJava2D((double)var4 + var11.getSize(), var2, var3);
      double var14 = Math.abs(var12 - var6);
      double var16 = var8 / var14 * var11.getSize();
      DateTickUnit var18 = (DateTickUnit)var10.getCeilingTickUnit(var16);
      double var19 = this.valueToJava2D((double)var4 + var18.getSize(), var2, var3);
      double var21 = Math.abs(var19 - var6);
      var8 = this.estimateMaximumTickLabelWidth(var1, var18);
      if(var8 > var21) {
         var18 = (DateTickUnit)var10.getLargerTickUnit(var18);
      }

      this.setTickUnit(var18, false, false);
   }

   protected void selectVerticalAutoTickUnit(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      TickUnitSource var4 = this.getStandardTickUnits();
      double var5 = this.valueToJava2D(0.0D, var2, var3);
      double var7 = this.getRange().getLength() / 10.0D;
      DateTickUnit var9 = (DateTickUnit)var4.getCeilingTickUnit(var7);
      double var10 = this.estimateMaximumTickLabelHeight(var1, var9);
      double var12 = this.valueToJava2D(var9.getSize(), var2, var3);
      double var14 = Math.abs(var12 - var5);
      double var16 = var10 / var14 * var9.getSize();
      DateTickUnit var18 = (DateTickUnit)var4.getCeilingTickUnit(var16);
      double var19 = this.estimateMaximumTickLabelHeight(var1, var18);
      double var21 = this.valueToJava2D(var18.getSize(), var2, var3);
      double var23 = Math.abs(var21 - var5);
      DateTickUnit var25;
      if(var19 < var23) {
         var25 = var18;
      } else {
         var25 = (DateTickUnit)var4.getLargerTickUnit(var18);
      }

      this.setTickUnit(var25, false, false);
   }

   private double estimateMaximumTickLabelWidth(Graphics2D var1, DateTickUnit var2) {
      RectangleInsets var3 = this.getTickLabelInsets();
      double var4 = var3.getLeft() + var3.getRight();
      Font var6 = this.getTickLabelFont();
      FontRenderContext var7 = var1.getFontRenderContext();
      LineMetrics var8 = var6.getLineMetrics("ABCxyz", var7);
      if(this.isVerticalTickLabels()) {
         var4 += (double)var8.getHeight();
      } else {
         DateRange var9 = (DateRange)this.getRange();
         Date var10 = var9.getLowerDate();
         Date var11 = var9.getUpperDate();
         String var12 = null;
         String var13 = null;
         DateFormat var14 = this.getDateFormatOverride();
         if(var14 != null) {
            var12 = var14.format(var10);
            var13 = var14.format(var11);
         } else {
            var12 = var2.dateToString(var10);
            var13 = var2.dateToString(var11);
         }

         FontMetrics var15 = var1.getFontMetrics(var6);
         double var16 = (double)var15.stringWidth(var12);
         double var18 = (double)var15.stringWidth(var13);
         var4 += Math.max(var16, var18);
      }

      return var4;
   }

   private double estimateMaximumTickLabelHeight(Graphics2D var1, DateTickUnit var2) {
      RectangleInsets var3 = this.getTickLabelInsets();
      double var4 = var3.getTop() + var3.getBottom();
      Font var6 = this.getTickLabelFont();
      FontRenderContext var7 = var1.getFontRenderContext();
      LineMetrics var8 = var6.getLineMetrics("ABCxyz", var7);
      if(!this.isVerticalTickLabels()) {
         var4 += (double)var8.getHeight();
      } else {
         DateRange var9 = (DateRange)this.getRange();
         Date var10 = var9.getLowerDate();
         Date var11 = var9.getUpperDate();
         String var12 = null;
         String var13 = null;
         DateFormat var14 = this.getDateFormatOverride();
         if(var14 != null) {
            var12 = var14.format(var10);
            var13 = var14.format(var11);
         } else {
            var12 = var2.dateToString(var10);
            var13 = var2.dateToString(var11);
         }

         FontMetrics var15 = var1.getFontMetrics(var6);
         double var16 = (double)var15.stringWidth(var12);
         double var18 = (double)var15.stringWidth(var13);
         var4 += Math.max(var16, var18);
      }

      return var4;
   }

   public List refreshTicks(Graphics2D var1, AxisState var2, Rectangle2D var3, RectangleEdge var4) {
      List var5 = null;
      if(RectangleEdge.isTopOrBottom(var4)) {
         var5 = this.refreshTicksHorizontal(var1, var3, var4);
      } else if(RectangleEdge.isLeftOrRight(var4)) {
         var5 = this.refreshTicksVertical(var1, var3, var4);
      }

      return var5;
   }

   protected List refreshTicksHorizontal(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      if(this.isAutoTickUnitSelection()) {
         this.selectAutoTickUnit(var1, var2, var3);
      }

      DateTickUnit var6 = this.getTickUnit();
      Date var7 = this.calculateLowestVisibleTickValue(var6);
      Date var8 = this.getMaximumDate();

      while(var7.before(var8)) {
         if(!this.isHiddenValue(var7.getTime())) {
            DateFormat var10 = this.getDateFormatOverride();
            String var9;
            if(var10 != null) {
               var9 = var10.format(var7);
            } else {
               var9 = this.tickUnit.dateToString(var7);
            }

            TextAnchor var11 = null;
            TextAnchor var12 = null;
            double var13 = 0.0D;
            if(this.isVerticalTickLabels()) {
               var11 = TextAnchor.CENTER_RIGHT;
               var12 = TextAnchor.CENTER_RIGHT;
               if(var3 == RectangleEdge.TOP) {
                  var13 = 1.5707963267948966D;
               } else {
                  var13 = -1.5707963267948966D;
               }
            } else if(var3 == RectangleEdge.TOP) {
               var11 = TextAnchor.BOTTOM_CENTER;
               var12 = TextAnchor.BOTTOM_CENTER;
            } else {
               var11 = TextAnchor.TOP_CENTER;
               var12 = TextAnchor.TOP_CENTER;
            }

            DateTick var15 = new DateTick(var7, var9, var11, var12, var13);
            var4.add(var15);
            var7 = var6.addToDate(var7);
            switch(var6.getUnit()) {
            case 0:
               var7 = this.calculateDateForPosition(new Year(var7), this.tickMarkPosition);
               break;
            case 1:
               var7 = this.calculateDateForPosition(new Month(var7), this.tickMarkPosition);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            }
         } else {
            var7 = var6.rollDate(var7);
         }
      }

      return var4;
   }

   protected List refreshTicksVertical(Graphics2D var1, Rectangle2D var2, RectangleEdge var3) {
      ArrayList var4 = new ArrayList();
      Font var5 = this.getTickLabelFont();
      var1.setFont(var5);
      if(this.isAutoTickUnitSelection()) {
         this.selectAutoTickUnit(var1, var2, var3);
      }

      DateTickUnit var6 = this.getTickUnit();
      Date var7 = this.calculateLowestVisibleTickValue(var6);
      Date var8 = this.getMaximumDate();

      while(var7.before(var8)) {
         if(!this.isHiddenValue(var7.getTime())) {
            DateFormat var10 = this.getDateFormatOverride();
            String var9;
            if(var10 != null) {
               var9 = var10.format(var7);
            } else {
               var9 = this.tickUnit.dateToString(var7);
            }

            TextAnchor var11 = null;
            TextAnchor var12 = null;
            double var13 = 0.0D;
            if(this.isVerticalTickLabels()) {
               var11 = TextAnchor.BOTTOM_CENTER;
               var12 = TextAnchor.BOTTOM_CENTER;
               if(var3 == RectangleEdge.LEFT) {
                  var13 = -1.5707963267948966D;
               } else {
                  var13 = 1.5707963267948966D;
               }
            } else if(var3 == RectangleEdge.LEFT) {
               var11 = TextAnchor.CENTER_RIGHT;
               var12 = TextAnchor.CENTER_RIGHT;
            } else {
               var11 = TextAnchor.CENTER_LEFT;
               var12 = TextAnchor.CENTER_LEFT;
            }

            DateTick var15 = new DateTick(var7, var9, var11, var12, var13);
            var4.add(var15);
            var7 = var6.addToDate(var7);
         } else {
            var7 = var6.rollDate(var7);
         }
      }

      return var4;
   }

   public AxisState draw(Graphics2D var1, double var2, Rectangle2D var4, Rectangle2D var5, RectangleEdge var6, PlotRenderingInfo var7) {
      AxisState var8;
      if(!this.isVisible()) {
         var8 = new AxisState(var2);
         List var9 = this.refreshTicks(var1, var8, var5, var6);
         var8.setTicks(var9);
         return var8;
      } else {
         var8 = this.drawTickMarksAndLabels(var1, var2, var4, var5, var6);
         var8 = this.drawLabel(this.getLabel(), var1, var4, var5, var6, var8);
         return var8;
      }
   }

   public void zoomRange(double var1, double var3) {
      double var5 = (double)this.timeline.toTimelineValue((long)this.getRange().getLowerBound());
      double var7 = (double)(this.timeline.toTimelineValue((long)this.getRange().getUpperBound()) - this.timeline.toTimelineValue((long)this.getRange().getLowerBound()));
      DateRange var9 = null;
      if(this.isInverted()) {
         var9 = new DateRange((double)this.timeline.toMillisecond((long)(var5 + var7 * (1.0D - var3))), (double)this.timeline.toMillisecond((long)(var5 + var7 * (1.0D - var1))));
      } else {
         var9 = new DateRange((double)this.timeline.toMillisecond((long)(var5 + var7 * var1)), (double)this.timeline.toMillisecond((long)(var5 + var7 * var3)));
      }

      this.setRange(var9);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DateAxis)) {
         return false;
      } else {
         DateAxis var2 = (DateAxis)var1;
         return !ObjectUtilities.equal(this.tickUnit, var2.tickUnit)?false:(!ObjectUtilities.equal(this.dateFormatOverride, var2.dateFormatOverride)?false:(!ObjectUtilities.equal(this.tickMarkPosition, var2.tickMarkPosition)?false:(!ObjectUtilities.equal(this.timeline, var2.timeline)?false:super.equals(var1))));
      }
   }

   public int hashCode() {
      return this.getLabel() != null?this.getLabel().hashCode():0;
   }

   public Object clone() {
      DateAxis var1 = (DateAxis)super.clone();
      if(this.dateFormatOverride != null) {
         var1.dateFormatOverride = (DateFormat)this.dateFormatOverride.clone();
      }

      return var1;
   }
}
