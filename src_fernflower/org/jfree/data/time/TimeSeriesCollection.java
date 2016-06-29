package org.jfree.data.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.ObjectUtilities;

public class TimeSeriesCollection extends AbstractIntervalXYDataset implements Serializable, DomainInfo, IntervalXYDataset, XYDataset {
   private static final long serialVersionUID = 834149929022371137L;
   private List data;
   private Calendar workingCalendar;
   private TimePeriodAnchor xPosition;
   private boolean domainIsPointsInTime;

   public TimeSeriesCollection() {
      this((TimeSeries)null, TimeZone.getDefault());
   }

   public TimeSeriesCollection(TimeZone var1) {
      this((TimeSeries)null, var1);
   }

   public TimeSeriesCollection(TimeSeries var1) {
      this(var1, TimeZone.getDefault());
   }

   public TimeSeriesCollection(TimeSeries var1, TimeZone var2) {
      if(var2 == null) {
         var2 = TimeZone.getDefault();
      }

      this.workingCalendar = Calendar.getInstance(var2);
      this.data = new ArrayList();
      if(var1 != null) {
         this.data.add(var1);
         var1.addChangeListener(this);
      }

      this.xPosition = TimePeriodAnchor.START;
      this.domainIsPointsInTime = true;
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

   public List getSeries() {
      return Collections.unmodifiableList(this.data);
   }

   public int getSeriesCount() {
      return this.data.size();
   }

   public TimeSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (TimeSeries)this.data.get(var1);
      } else {
         throw new IllegalArgumentException("The \'series\' argument is out of bounds (" + var1 + ").");
      }
   }

   public TimeSeries getSeries(String var1) {
      TimeSeries var2 = null;
      Iterator var3 = this.data.iterator();

      while(var3.hasNext()) {
         TimeSeries var4 = (TimeSeries)var3.next();
         Comparable var5 = var4.getKey();
         if(var5 != null && var5.equals(var1)) {
            var2 = var4;
         }
      }

      return var2;
   }

   public Comparable getSeriesKey(int var1) {
      return this.getSeries(var1).getKey();
   }

   public void addSeries(TimeSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.add(var1);
         var1.addChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public void removeSeries(TimeSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.remove(var1);
         var1.removeChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public void removeSeries(int var1) {
      TimeSeries var2 = this.getSeries(var1);
      if(var2 != null) {
         this.removeSeries(var2);
      }

   }

   public void removeAllSeries() {
      for(int var1 = 0; var1 < this.data.size(); ++var1) {
         TimeSeries var2 = (TimeSeries)this.data.get(var1);
         var2.removeChangeListener(this);
      }

      this.data.clear();
      this.fireDatasetChanged();
   }

   public int getItemCount(int var1) {
      return this.getSeries(var1).getItemCount();
   }

   public double getXValue(int var1, int var2) {
      TimeSeries var3 = (TimeSeries)this.data.get(var1);
      TimeSeriesDataItem var4 = var3.getDataItem(var2);
      RegularTimePeriod var5 = var4.getPeriod();
      return (double)this.getX(var5);
   }

   public Number getX(int var1, int var2) {
      TimeSeries var3 = (TimeSeries)this.data.get(var1);
      TimeSeriesDataItem var4 = var3.getDataItem(var2);
      RegularTimePeriod var5 = var4.getPeriod();
      return new Long(this.getX(var5));
   }

   protected synchronized long getX(RegularTimePeriod var1) {
      long var2 = 0L;
      if(this.xPosition == TimePeriodAnchor.START) {
         var2 = var1.getFirstMillisecond(this.workingCalendar);
      } else if(this.xPosition == TimePeriodAnchor.MIDDLE) {
         var2 = var1.getMiddleMillisecond(this.workingCalendar);
      } else if(this.xPosition == TimePeriodAnchor.END) {
         var2 = var1.getLastMillisecond(this.workingCalendar);
      }

      return var2;
   }

   public synchronized Number getStartX(int var1, int var2) {
      TimeSeries var3 = (TimeSeries)this.data.get(var1);
      TimeSeriesDataItem var4 = var3.getDataItem(var2);
      return new Long(var4.getPeriod().getFirstMillisecond(this.workingCalendar));
   }

   public synchronized Number getEndX(int var1, int var2) {
      TimeSeries var3 = (TimeSeries)this.data.get(var1);
      TimeSeriesDataItem var4 = var3.getDataItem(var2);
      return new Long(var4.getPeriod().getLastMillisecond(this.workingCalendar));
   }

   public Number getY(int var1, int var2) {
      TimeSeries var3 = (TimeSeries)this.data.get(var1);
      TimeSeriesDataItem var4 = var3.getDataItem(var2);
      return var4.getValue();
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public int[] getSurroundingItems(int var1, long var2) {
      int[] var4 = new int[]{-1, -1};
      TimeSeries var5 = this.getSeries(var1);

      for(int var6 = 0; var6 < var5.getItemCount(); ++var6) {
         Number var7 = this.getX(var1, var6);
         long var8 = var7.longValue();
         if(var8 <= var2) {
            var4[0] = var6;
         }

         if(var8 >= var2) {
            var4[1] = var6;
            break;
         }
      }

      return var4;
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
      Range var2 = null;
      Iterator var3 = this.data.iterator();

      while(var3.hasNext()) {
         TimeSeries var4 = (TimeSeries)var3.next();
         int var5 = var4.getItemCount();
         if(var5 > 0) {
            RegularTimePeriod var6 = var4.getTimePeriod(0);
            RegularTimePeriod var7 = var4.getTimePeriod(var5 - 1);
            Range var8;
            if(!var1) {
               var8 = new Range((double)this.getX(var6), (double)this.getX(var7));
            } else {
               var8 = new Range((double)var6.getFirstMillisecond(this.workingCalendar), (double)var7.getLastMillisecond(this.workingCalendar));
            }

            var2 = Range.combine(var2, var8);
         }
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TimeSeriesCollection)) {
         return false;
      } else {
         TimeSeriesCollection var2 = (TimeSeriesCollection)var1;
         return this.xPosition != var2.xPosition?false:(this.domainIsPointsInTime != var2.domainIsPointsInTime?false:ObjectUtilities.equal(this.data, var2.data));
      }
   }

   public int hashCode() {
      int var1 = this.data.hashCode();
      var1 = 29 * var1 + (this.workingCalendar != null?this.workingCalendar.hashCode():0);
      var1 = 29 * var1 + (this.xPosition != null?this.xPosition.hashCode():0);
      var1 = 29 * var1 + (this.domainIsPointsInTime?1:0);
      return var1;
   }
}
