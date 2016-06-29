package org.jfree.data.time;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.util.PublicCloneable;

public class TimeTableXYDataset extends AbstractIntervalXYDataset implements Cloneable, DomainInfo, IntervalXYDataset, TableXYDataset, PublicCloneable {
   private DefaultKeyedValues2D values;
   private boolean domainIsPointsInTime;
   private TimePeriodAnchor xPosition;
   private Calendar workingCalendar;

   public TimeTableXYDataset() {
      this(TimeZone.getDefault(), Locale.getDefault());
   }

   public TimeTableXYDataset(TimeZone var1) {
      this(var1, Locale.getDefault());
   }

   public TimeTableXYDataset(TimeZone var1, Locale var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'zone\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'locale\' argument.");
      } else {
         this.values = new DefaultKeyedValues2D(true);
         this.workingCalendar = Calendar.getInstance(var1, var2);
         this.xPosition = TimePeriodAnchor.START;
      }
   }

   public boolean getDomainIsPointsInTime() {
      return this.domainIsPointsInTime;
   }

   public void setDomainIsPointsInTime(boolean var1) {
      this.domainIsPointsInTime = var1;
      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   public TimePeriodAnchor getXPosition() {
      return this.xPosition;
   }

   public void setXPosition(TimePeriodAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'anchor\' argument.");
      } else {
         this.xPosition = var1;
         this.notifyListeners(new DatasetChangeEvent(this, this));
      }
   }

   public void add(TimePeriod var1, double var2, String var4) {
      this.add(var1, new Double(var2), var4, true);
   }

   public void add(TimePeriod var1, Number var2, String var3, boolean var4) {
      this.values.addValue(var2, var1, var3);
      if(var4) {
         this.fireDatasetChanged();
      }

   }

   public void remove(TimePeriod var1, String var2) {
      this.remove(var1, var2, true);
   }

   public void remove(TimePeriod var1, String var2, boolean var3) {
      this.values.removeValue(var1, var2);
      if(var3) {
         this.fireDatasetChanged();
      }

   }

   public TimePeriod getTimePeriod(int var1) {
      return (TimePeriod)this.values.getRowKey(var1);
   }

   public int getItemCount() {
      return this.values.getRowCount();
   }

   public int getItemCount(int var1) {
      return this.getItemCount();
   }

   public int getSeriesCount() {
      return this.values.getColumnCount();
   }

   public Comparable getSeriesKey(int var1) {
      return this.values.getColumnKey(var1);
   }

   public Number getX(int var1, int var2) {
      return new Double(this.getXValue(var1, var2));
   }

   public double getXValue(int var1, int var2) {
      TimePeriod var3 = (TimePeriod)this.values.getRowKey(var2);
      return (double)this.getXValue(var3);
   }

   public Number getStartX(int var1, int var2) {
      return new Double(this.getStartXValue(var1, var2));
   }

   public double getStartXValue(int var1, int var2) {
      TimePeriod var3 = (TimePeriod)this.values.getRowKey(var2);
      return (double)var3.getStart().getTime();
   }

   public Number getEndX(int var1, int var2) {
      return new Double(this.getEndXValue(var1, var2));
   }

   public double getEndXValue(int var1, int var2) {
      TimePeriod var3 = (TimePeriod)this.values.getRowKey(var2);
      return (double)var3.getEnd().getTime();
   }

   public Number getY(int var1, int var2) {
      return this.values.getValue(var2, var1);
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   private long getXValue(TimePeriod var1) {
      long var2 = 0L;
      if(this.xPosition == TimePeriodAnchor.START) {
         var2 = var1.getStart().getTime();
      } else if(this.xPosition == TimePeriodAnchor.MIDDLE) {
         long var4 = var1.getStart().getTime();
         long var6 = var1.getEnd().getTime();
         var2 = var4 + (var6 - var4) / 2L;
      } else if(this.xPosition == TimePeriodAnchor.END) {
         var2 = var1.getEnd().getTime();
      }

      return var2;
   }

   public double getDomainLowerBound(boolean var1) {
      double var2 = Double.NaN;
      Range var4 = this.getDomainBounds(var1);
      if(var4 != null) {
         var2 = var4.getLowerBound();
      }

      return var2;
   }

   public double getDomainUpperBound(boolean var1) {
      double var2 = Double.NaN;
      Range var4 = this.getDomainBounds(var1);
      if(var4 != null) {
         var2 = var4.getUpperBound();
      }

      return var2;
   }

   public Range getDomainBounds(boolean var1) {
      List var2 = this.values.getRowKeys();
      if(var2.isEmpty()) {
         return null;
      } else {
         TimePeriod var3 = (TimePeriod)var2.get(0);
         TimePeriod var4 = (TimePeriod)var2.get(var2.size() - 1);
         return var1 && !this.domainIsPointsInTime?new Range((double)var3.getStart().getTime(), (double)var4.getEnd().getTime()):new Range((double)this.getXValue(var3), (double)this.getXValue(var4));
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TimeTableXYDataset)) {
         return false;
      } else {
         TimeTableXYDataset var2 = (TimeTableXYDataset)var1;
         return this.domainIsPointsInTime != var2.domainIsPointsInTime?false:(this.xPosition != var2.xPosition?false:(!this.workingCalendar.getTimeZone().equals(var2.workingCalendar.getTimeZone())?false:this.values.equals(var2.values)));
      }
   }

   public Object clone() {
      TimeTableXYDataset var1 = (TimeTableXYDataset)super.clone();
      var1.values = (DefaultKeyedValues2D)this.values.clone();
      var1.workingCalendar = (Calendar)this.workingCalendar.clone();
      return var1;
   }
}
