package org.jfree.data.time;

import java.util.Calendar;
import java.util.TimeZone;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.RangeInfo;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.time.DynamicTimeSeriesCollection$ValueSequence;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public class DynamicTimeSeriesCollection extends AbstractIntervalXYDataset implements DomainInfo, RangeInfo, IntervalXYDataset {
   public static final int START = 0;
   public static final int MIDDLE = 1;
   public static final int END = 2;
   private int maximumItemCount;
   protected int historyCount;
   private Comparable[] seriesKeys;
   private Class timePeriodClass;
   protected RegularTimePeriod[] pointsInTime;
   private int seriesCount;
   protected DynamicTimeSeriesCollection$ValueSequence[] valueHistory;
   protected Calendar workingCalendar;
   private int position;
   private boolean domainIsPointsInTime;
   private int oldestAt;
   private int newestAt;
   private long deltaTime;
   private Long domainStart;
   private Long domainEnd;
   private Range domainRange;
   private Float minValue;
   private Float maxValue;
   private Range valueRange;
   static Class class$org$jfree$data$time$Minute;
   static Class class$org$jfree$data$time$Second;
   static Class class$org$jfree$data$time$Hour;

   public DynamicTimeSeriesCollection(int var1, int var2) {
      this(var1, var2, new Millisecond(), TimeZone.getDefault());
      this.newestAt = var2 - 1;
   }

   public DynamicTimeSeriesCollection(int var1, int var2, TimeZone var3) {
      this(var1, var2, new Millisecond(), var3);
      this.newestAt = var2 - 1;
   }

   public DynamicTimeSeriesCollection(int var1, int var2, RegularTimePeriod var3) {
      this(var1, var2, var3, TimeZone.getDefault());
   }

   public DynamicTimeSeriesCollection(int var1, int var2, RegularTimePeriod var3, TimeZone var4) {
      this.maximumItemCount = 2000;
      this.timePeriodClass = class$org$jfree$data$time$Minute == null?(class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")):class$org$jfree$data$time$Minute;
      this.minValue = new Float(0.0F);
      this.maxValue = null;
      this.maximumItemCount = var2;
      this.historyCount = var2;
      this.seriesKeys = new Comparable[var1];

      for(int var5 = 0; var5 < var1; ++var5) {
         this.seriesKeys[var5] = "";
      }

      this.newestAt = var2 - 1;
      this.valueHistory = new DynamicTimeSeriesCollection$ValueSequence[var1];
      this.timePeriodClass = var3.getClass();
      if(this.timePeriodClass == (class$org$jfree$data$time$Second == null?(class$org$jfree$data$time$Second = class$("org.jfree.data.time.Second")):class$org$jfree$data$time$Second)) {
         this.pointsInTime = new Second[var2];
      } else if(this.timePeriodClass == (class$org$jfree$data$time$Minute == null?(class$org$jfree$data$time$Minute = class$("org.jfree.data.time.Minute")):class$org$jfree$data$time$Minute)) {
         this.pointsInTime = new Minute[var2];
      } else if(this.timePeriodClass == (class$org$jfree$data$time$Hour == null?(class$org$jfree$data$time$Hour = class$("org.jfree.data.time.Hour")):class$org$jfree$data$time$Hour)) {
         this.pointsInTime = new Hour[var2];
      }

      this.workingCalendar = Calendar.getInstance(var4);
      this.position = 0;
      this.domainIsPointsInTime = true;
   }

   public synchronized long setTimeBase(RegularTimePeriod var1) {
      if(this.pointsInTime[0] == null) {
         this.pointsInTime[0] = var1;

         for(int var2 = 1; var2 < this.historyCount; ++var2) {
            this.pointsInTime[var2] = this.pointsInTime[var2 - 1].next();
         }
      }

      long var6 = this.pointsInTime[0].getFirstMillisecond(this.workingCalendar);
      long var4 = this.pointsInTime[1].getFirstMillisecond(this.workingCalendar);
      this.deltaTime = var4 - var6;
      this.oldestAt = 0;
      this.newestAt = this.historyCount - 1;
      this.findDomainLimits();
      return this.deltaTime;
   }

   protected void findDomainLimits() {
      long var1 = this.getOldestTime().getFirstMillisecond(this.workingCalendar);
      long var3;
      if(this.domainIsPointsInTime) {
         var3 = this.getNewestTime().getFirstMillisecond(this.workingCalendar);
      } else {
         var3 = this.getNewestTime().getLastMillisecond(this.workingCalendar);
      }

      this.domainStart = new Long(var1);
      this.domainEnd = new Long(var3);
      this.domainRange = new Range((double)var1, (double)var3);
   }

   public int getPosition() {
      return this.position;
   }

   public void setPosition(int var1) {
      this.position = var1;
   }

   public void addSeries(float[] var1, int var2, Comparable var3) {
      this.invalidateRangeInfo();
      if(var1 == null) {
         throw new IllegalArgumentException("TimeSeriesDataset.addSeries(): cannot add null array of values.");
      } else if(var2 >= this.valueHistory.length) {
         throw new IllegalArgumentException("TimeSeriesDataset.addSeries(): cannot add more series than specified in c\'tor");
      } else {
         if(this.valueHistory[var2] == null) {
            this.valueHistory[var2] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            ++this.seriesCount;
         }

         int var5 = var1.length;
         int var6 = this.historyCount;
         boolean var7 = false;
         if(var5 < this.historyCount) {
            var7 = true;
            var6 = var5;
         }

         int var4;
         for(var4 = 0; var4 < var6; ++var4) {
            this.valueHistory[var2].enterData(var4, var1[var4]);
         }

         if(var7) {
            for(var4 = var6; var4 < this.historyCount; ++var4) {
               this.valueHistory[var2].enterData(var4, 0.0F);
            }
         }

         if(var3 != null) {
            this.seriesKeys[var2] = var3;
         }

         this.fireSeriesChanged();
      }
   }

   public void setSeriesKey(int var1, Comparable var2) {
      this.seriesKeys[var1] = var2;
   }

   public void addValue(int var1, int var2, float var3) {
      this.invalidateRangeInfo();
      if(var1 >= this.valueHistory.length) {
         throw new IllegalArgumentException("TimeSeriesDataset.addValue(): series #" + var1 + "unspecified in c\'tor");
      } else {
         if(this.valueHistory[var1] == null) {
            this.valueHistory[var1] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            ++this.seriesCount;
         }

         this.valueHistory[var1].enterData(var2, var3);
         this.fireSeriesChanged();
      }
   }

   public int getSeriesCount() {
      return this.seriesCount;
   }

   public int getItemCount(int var1) {
      return this.historyCount;
   }

   protected int translateGet(int var1) {
      if(this.oldestAt == 0) {
         return var1;
      } else {
         int var2 = var1 + this.oldestAt;
         if(var2 >= this.historyCount) {
            var2 -= this.historyCount;
         }

         return var2;
      }
   }

   public int offsetFromNewest(int var1) {
      return this.wrapOffset(this.newestAt + var1);
   }

   public int offsetFromOldest(int var1) {
      return this.wrapOffset(this.oldestAt + var1);
   }

   protected int wrapOffset(int var1) {
      int var2 = var1;
      if(var1 >= this.historyCount) {
         var2 = var1 - this.historyCount;
      } else if(var1 < 0) {
         var2 = var1 + this.historyCount;
      }

      return var2;
   }

   public synchronized RegularTimePeriod advanceTime() {
      RegularTimePeriod var1 = this.pointsInTime[this.newestAt].next();
      this.newestAt = this.oldestAt;
      boolean var2 = false;
      float var3 = 0.0F;
      if(this.maxValue != null) {
         var3 = this.maxValue.floatValue();
      }

      for(int var4 = 0; var4 < this.getSeriesCount(); ++var4) {
         if(this.valueHistory[var4].getData(this.oldestAt) == var3) {
            var2 = true;
         }

         if(var2) {
            break;
         }
      }

      if(var2) {
         this.invalidateRangeInfo();
      }

      float var9 = 0.0F;

      for(int var5 = 0; var5 < this.getSeriesCount(); ++var5) {
         this.valueHistory[var5].enterData(this.newestAt, var9);
      }

      this.pointsInTime[this.newestAt] = var1;
      ++this.oldestAt;
      if(this.oldestAt >= this.historyCount) {
         this.oldestAt = 0;
      }

      long var10 = this.domainStart.longValue();
      this.domainStart = new Long(var10 + this.deltaTime);
      long var7 = this.domainEnd.longValue();
      this.domainEnd = new Long(var7 + this.deltaTime);
      this.domainRange = new Range((double)var10, (double)var7);
      this.fireSeriesChanged();
      return var1;
   }

   public void invalidateRangeInfo() {
      this.maxValue = null;
      this.valueRange = null;
   }

   protected double findMaxValue() {
      double var1 = 0.0D;

      for(int var3 = 0; var3 < this.getSeriesCount(); ++var3) {
         for(int var4 = 0; var4 < this.historyCount; ++var4) {
            double var5 = this.getYValue(var3, var4);
            if(var5 > var1) {
               var1 = var5;
            }
         }
      }

      return var1;
   }

   public int getOldestIndex() {
      return this.oldestAt;
   }

   public int getNewestIndex() {
      return this.newestAt;
   }

   public void appendData(float[] var1) {
      int var2 = var1.length;
      if(var2 > this.valueHistory.length) {
         throw new IllegalArgumentException("More data than series to put them in");
      } else {
         for(int var3 = 0; var3 < var2; ++var3) {
            if(this.valueHistory[var3] == null) {
               this.valueHistory[var3] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            }

            this.valueHistory[var3].enterData(this.newestAt, var1[var3]);
         }

         this.fireSeriesChanged();
      }
   }

   public void appendData(float[] var1, int var2, int var3) {
      int var4 = var1.length;
      if(var4 > this.valueHistory.length) {
         throw new IllegalArgumentException("More data than series to put them in");
      } else {
         for(int var5 = 0; var5 < var4; ++var5) {
            if(this.valueHistory[var5] == null) {
               this.valueHistory[var5] = new DynamicTimeSeriesCollection$ValueSequence(this, this.historyCount);
            }

            this.valueHistory[var5].enterData(var2, var1[var5]);
         }

         if(var3 > 0) {
            ++var2;
            if(var2 % var3 == 0) {
               this.fireSeriesChanged();
            }
         }

      }
   }

   public RegularTimePeriod getNewestTime() {
      return this.pointsInTime[this.newestAt];
   }

   public RegularTimePeriod getOldestTime() {
      return this.pointsInTime[this.oldestAt];
   }

   public Number getX(int var1, int var2) {
      RegularTimePeriod var3 = this.pointsInTime[this.translateGet(var2)];
      return new Long(this.getX(var3));
   }

   public double getYValue(int var1, int var2) {
      DynamicTimeSeriesCollection$ValueSequence var3 = this.valueHistory[var1];
      return (double)var3.getData(this.translateGet(var2));
   }

   public Number getY(int var1, int var2) {
      return new Float(this.getYValue(var1, var2));
   }

   public Number getStartX(int var1, int var2) {
      RegularTimePeriod var3 = this.pointsInTime[this.translateGet(var2)];
      return new Long(var3.getFirstMillisecond(this.workingCalendar));
   }

   public Number getEndX(int var1, int var2) {
      RegularTimePeriod var3 = this.pointsInTime[this.translateGet(var2)];
      return new Long(var3.getLastMillisecond(this.workingCalendar));
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Comparable getSeriesKey(int var1) {
      return this.seriesKeys[var1];
   }

   protected void fireSeriesChanged() {
      this.seriesChanged(new SeriesChangeEvent(this));
   }

   public double getDomainLowerBound(boolean var1) {
      return this.domainStart.doubleValue();
   }

   public double getDomainUpperBound(boolean var1) {
      return this.domainEnd.doubleValue();
   }

   public Range getDomainBounds(boolean var1) {
      if(this.domainRange == null) {
         this.findDomainLimits();
      }

      return this.domainRange;
   }

   private long getX(RegularTimePeriod var1) {
      switch(this.position) {
      case 0:
         return var1.getFirstMillisecond(this.workingCalendar);
      case 1:
         return var1.getMiddleMillisecond(this.workingCalendar);
      case 2:
         return var1.getLastMillisecond(this.workingCalendar);
      default:
         return var1.getMiddleMillisecond(this.workingCalendar);
      }
   }

   public double getRangeLowerBound(boolean var1) {
      double var2 = Double.NaN;
      if(this.minValue != null) {
         var2 = this.minValue.doubleValue();
      }

      return var2;
   }

   public double getRangeUpperBound(boolean var1) {
      double var2 = Double.NaN;
      if(this.maxValue != null) {
         var2 = this.maxValue.doubleValue();
      }

      return var2;
   }

   public Range getRangeBounds(boolean var1) {
      if(this.valueRange == null) {
         double var2 = this.getRangeUpperBound(var1);
         this.valueRange = new Range(0.0D, var2);
      }

      return this.valueRange;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static int access$000(DynamicTimeSeriesCollection var0) {
      return var0.maximumItemCount;
   }
}
