package org.jfree.data.time;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.jfree.data.general.Series;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.util.ObjectUtilities;

public class TimeSeries extends Series implements Serializable, Cloneable {
   private static final long serialVersionUID = -5032960206869675528L;
   protected static final String DEFAULT_DOMAIN_DESCRIPTION = "Time";
   protected static final String DEFAULT_RANGE_DESCRIPTION = "Value";
   private String domain;
   private String range;
   protected Class timePeriodClass;
   protected List data;
   private int maximumItemCount;
   private long maximumItemAge;
   static Class class$org$jfree$data$time$Day;
   static Class class$java$lang$Class;
   static Class class$java$util$Date;
   static Class class$java$util$TimeZone;
   static Class class$org$jfree$data$time$RegularTimePeriod;

   public TimeSeries(String var1) {
      this(var1, "Time", "Value", class$org$jfree$data$time$Day == null?(class$org$jfree$data$time$Day = class$("org.jfree.data.time.Day")):class$org$jfree$data$time$Day);
   }

   public TimeSeries(String var1, Class var2) {
      this(var1, "Time", "Value", var2);
   }

   public TimeSeries(String var1, String var2, String var3, Class var4) {
      super(var1);
      this.domain = var2;
      this.range = var3;
      this.timePeriodClass = var4;
      this.data = new ArrayList();
      this.maximumItemCount = Integer.MAX_VALUE;
      this.maximumItemAge = Long.MAX_VALUE;
   }

   public String getDomainDescription() {
      return this.domain;
   }

   public void setDomainDescription(String var1) {
      String var2 = this.domain;
      this.domain = var1;
      this.firePropertyChange("Domain", var2, var1);
   }

   public String getRangeDescription() {
      return this.range;
   }

   public void setRangeDescription(String var1) {
      String var2 = this.range;
      this.range = var1;
      this.firePropertyChange("Range", var2, var1);
   }

   public int getItemCount() {
      return this.data.size();
   }

   public List getItems() {
      return Collections.unmodifiableList(this.data);
   }

   public int getMaximumItemCount() {
      return this.maximumItemCount;
   }

   public void setMaximumItemCount(int var1) {
      if(var1 < 0) {
         throw new IllegalArgumentException("Negative \'maximum\' argument.");
      } else {
         this.maximumItemCount = var1;
         int var2 = this.data.size();
         if(var2 > var1) {
            this.delete(0, var2 - var1 - 1);
         }

      }
   }

   public long getMaximumItemAge() {
      return this.maximumItemAge;
   }

   public void setMaximumItemAge(long var1) {
      if(var1 < 0L) {
         throw new IllegalArgumentException("Negative \'periods\' argument.");
      } else {
         this.maximumItemAge = var1;
         this.removeAgedItems(true);
      }
   }

   public Class getTimePeriodClass() {
      return this.timePeriodClass;
   }

   public TimeSeriesDataItem getDataItem(int var1) {
      return (TimeSeriesDataItem)this.data.get(var1);
   }

   public TimeSeriesDataItem getDataItem(RegularTimePeriod var1) {
      int var2 = this.getIndex(var1);
      return var2 >= 0?(TimeSeriesDataItem)this.data.get(var2):null;
   }

   public RegularTimePeriod getTimePeriod(int var1) {
      return this.getDataItem(var1).getPeriod();
   }

   public RegularTimePeriod getNextTimePeriod() {
      RegularTimePeriod var1 = this.getTimePeriod(this.getItemCount() - 1);
      return var1.next();
   }

   public Collection getTimePeriods() {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < this.getItemCount(); ++var2) {
         var1.add(this.getTimePeriod(var2));
      }

      return var1;
   }

   public Collection getTimePeriodsUniqueToOtherSeries(TimeSeries var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1.getItemCount(); ++var3) {
         RegularTimePeriod var4 = var1.getTimePeriod(var3);
         int var5 = this.getIndex(var4);
         if(var5 < 0) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public int getIndex(RegularTimePeriod var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'period\' argument.");
      } else {
         TimeSeriesDataItem var2 = new TimeSeriesDataItem(var1, -2.147483648E9D);
         return Collections.binarySearch(this.data, var2);
      }
   }

   public Number getValue(int var1) {
      return this.getDataItem(var1).getValue();
   }

   public Number getValue(RegularTimePeriod var1) {
      int var2 = this.getIndex(var1);
      return var2 >= 0?this.getValue(var2):null;
   }

   public void add(TimeSeriesDataItem var1) {
      this.add(var1, true);
   }

   public void add(TimeSeriesDataItem var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'item\' argument.");
      } else if(!var1.getPeriod().getClass().equals(this.timePeriodClass)) {
         StringBuffer var8 = new StringBuffer();
         var8.append("You are trying to add data where the time period class ");
         var8.append("is ");
         var8.append(var1.getPeriod().getClass().getName());
         var8.append(", but the TimeSeries is expecting an instance of ");
         var8.append(this.timePeriodClass.getName());
         var8.append(".");
         throw new SeriesException(var8.toString());
      } else {
         boolean var3 = false;
         int var4 = this.getItemCount();
         if(var4 == 0) {
            this.data.add(var1);
            var3 = true;
         } else {
            RegularTimePeriod var5 = this.getTimePeriod(this.getItemCount() - 1);
            if(var1.getPeriod().compareTo(var5) > 0) {
               this.data.add(var1);
               var3 = true;
            } else {
               int var6 = Collections.binarySearch(this.data, var1);
               if(var6 >= 0) {
                  StringBuffer var7 = new StringBuffer();
                  var7.append("You are attempting to add an observation for ");
                  var7.append("the time period ");
                  var7.append(var1.getPeriod().toString());
                  var7.append(" but the series already contains an observation");
                  var7.append(" for that time period. Duplicates are not ");
                  var7.append("permitted.  Try using the addOrUpdate() method.");
                  throw new SeriesException(var7.toString());
               }

               this.data.add(-var6 - 1, var1);
               var3 = true;
            }
         }

         if(var3) {
            if(this.getItemCount() > this.maximumItemCount) {
               this.data.remove(0);
            }

            this.removeAgedItems(false);
            if(var2) {
               this.fireSeriesChanged();
            }
         }

      }
   }

   public void add(RegularTimePeriod var1, double var2) {
      this.add(var1, var2, true);
   }

   public void add(RegularTimePeriod var1, double var2, boolean var4) {
      TimeSeriesDataItem var5 = new TimeSeriesDataItem(var1, var2);
      this.add(var5, var4);
   }

   public void add(RegularTimePeriod var1, Number var2) {
      this.add(var1, var2, true);
   }

   public void add(RegularTimePeriod var1, Number var2, boolean var3) {
      TimeSeriesDataItem var4 = new TimeSeriesDataItem(var1, var2);
      this.add(var4, var3);
   }

   public void update(RegularTimePeriod var1, Number var2) {
      TimeSeriesDataItem var3 = new TimeSeriesDataItem(var1, var2);
      int var4 = Collections.binarySearch(this.data, var3);
      if(var4 >= 0) {
         TimeSeriesDataItem var5 = (TimeSeriesDataItem)this.data.get(var4);
         var5.setValue(var2);
         this.fireSeriesChanged();
      } else {
         throw new SeriesException("TimeSeries.update(TimePeriod, Number):  period does not exist.");
      }
   }

   public void update(int var1, Number var2) {
      TimeSeriesDataItem var3 = this.getDataItem(var1);
      var3.setValue(var2);
      this.fireSeriesChanged();
   }

   public TimeSeries addAndOrUpdate(TimeSeries var1) {
      TimeSeries var2 = new TimeSeries("Overwritten values from: " + this.getKey(), var1.getTimePeriodClass());

      for(int var3 = 0; var3 < var1.getItemCount(); ++var3) {
         TimeSeriesDataItem var4 = var1.getDataItem(var3);
         TimeSeriesDataItem var5 = this.addOrUpdate(var4.getPeriod(), var4.getValue());
         if(var5 != null) {
            var2.add(var5);
         }
      }

      return var2;
   }

   public TimeSeriesDataItem addOrUpdate(RegularTimePeriod var1, double var2) {
      return this.addOrUpdate(var1, new Double(var2));
   }

   public TimeSeriesDataItem addOrUpdate(RegularTimePeriod var1, Number var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'period\' argument.");
      } else {
         TimeSeriesDataItem var3 = null;
         TimeSeriesDataItem var4 = new TimeSeriesDataItem(var1, var2);
         int var5 = Collections.binarySearch(this.data, var4);
         if(var5 >= 0) {
            TimeSeriesDataItem var6 = (TimeSeriesDataItem)this.data.get(var5);
            var3 = (TimeSeriesDataItem)var6.clone();
            var6.setValue(var2);
            this.removeAgedItems(false);
            this.fireSeriesChanged();
         } else {
            this.data.add(-var5 - 1, new TimeSeriesDataItem(var1, var2));
            if(this.getItemCount() > this.maximumItemCount) {
               this.data.remove(0);
            }

            this.removeAgedItems(false);
            this.fireSeriesChanged();
         }

         return var3;
      }
   }

   public void removeAgedItems(boolean var1) {
      if(this.getItemCount() > 1) {
         long var2 = this.getTimePeriod(this.getItemCount() - 1).getSerialIndex();

         boolean var4;
         for(var4 = false; var2 - this.getTimePeriod(0).getSerialIndex() > this.maximumItemAge; var4 = true) {
            this.data.remove(0);
         }

         if(var4 && var1) {
            this.fireSeriesChanged();
         }
      }

   }

   public void removeAgedItems(long var1, boolean var3) {
      long var4 = Long.MAX_VALUE;

      try {
         Method var6 = (class$org$jfree$data$time$RegularTimePeriod == null?(class$org$jfree$data$time$RegularTimePeriod = class$("org.jfree.data.time.RegularTimePeriod")):class$org$jfree$data$time$RegularTimePeriod).getDeclaredMethod("createInstance", new Class[]{class$java$lang$Class == null?(class$java$lang$Class = class$("java.lang.Class")):class$java$lang$Class, class$java$util$Date == null?(class$java$util$Date = class$("java.util.Date")):class$java$util$Date, class$java$util$TimeZone == null?(class$java$util$TimeZone = class$("java.util.TimeZone")):class$java$util$TimeZone});
         RegularTimePeriod var7 = (RegularTimePeriod)var6.invoke(this.timePeriodClass, new Object[]{this.timePeriodClass, new Date(var1), TimeZone.getDefault()});
         var4 = var7.getSerialIndex();
      } catch (NoSuchMethodException var8) {
         var8.printStackTrace();
      } catch (IllegalAccessException var9) {
         var9.printStackTrace();
      } catch (InvocationTargetException var10) {
         var10.printStackTrace();
      }

      boolean var11;
      for(var11 = false; this.getItemCount() > 0 && var4 - this.getTimePeriod(0).getSerialIndex() > this.maximumItemAge; var11 = true) {
         this.data.remove(0);
      }

      if(var11 && var3) {
         this.fireSeriesChanged();
      }

   }

   public void clear() {
      if(this.data.size() > 0) {
         this.data.clear();
         this.fireSeriesChanged();
      }

   }

   public void delete(RegularTimePeriod var1) {
      int var2 = this.getIndex(var1);
      if(var2 >= 0) {
         this.data.remove(var2);
         this.fireSeriesChanged();
      }

   }

   public void delete(int var1, int var2) {
      if(var2 < var1) {
         throw new IllegalArgumentException("Requires start <= end.");
      } else {
         for(int var3 = 0; var3 <= var2 - var1; ++var3) {
            this.data.remove(var1);
         }

         this.fireSeriesChanged();
      }
   }

   public Object clone() {
      TimeSeries var1 = this.createCopy(0, this.getItemCount() - 1);
      return var1;
   }

   public TimeSeries createCopy(int var1, int var2) {
      if(var1 < 0) {
         throw new IllegalArgumentException("Requires start >= 0.");
      } else if(var2 < var1) {
         throw new IllegalArgumentException("Requires start <= end.");
      } else {
         TimeSeries var3 = (TimeSeries)super.clone();
         var3.data = new ArrayList();
         if(this.data.size() > 0) {
            for(int var4 = var1; var4 <= var2; ++var4) {
               TimeSeriesDataItem var5 = (TimeSeriesDataItem)this.data.get(var4);
               TimeSeriesDataItem var6 = (TimeSeriesDataItem)var5.clone();

               try {
                  var3.add(var6);
               } catch (SeriesException var8) {
                  var8.printStackTrace();
               }
            }
         }

         return var3;
      }
   }

   public TimeSeries createCopy(RegularTimePeriod var1, RegularTimePeriod var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'start\' argument.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Null \'end\' argument.");
      } else if(var1.compareTo(var2) > 0) {
         throw new IllegalArgumentException("Requires start on or before end.");
      } else {
         boolean var3 = false;
         int var4 = this.getIndex(var1);
         if(var4 < 0) {
            var4 = -(var4 + 1);
            if(var4 == this.data.size()) {
               var3 = true;
            }
         }

         int var5 = this.getIndex(var2);
         if(var5 < 0) {
            var5 = -(var5 + 1);
            --var5;
         }

         if(var5 < 0) {
            var3 = true;
         }

         if(var3) {
            TimeSeries var6 = (TimeSeries)super.clone();
            var6.data = new ArrayList();
            return var6;
         } else {
            return this.createCopy(var4, var5);
         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof TimeSeries && super.equals(var1)) {
         TimeSeries var2 = (TimeSeries)var1;
         if(!ObjectUtilities.equal(this.getDomainDescription(), var2.getDomainDescription())) {
            return false;
         } else if(!ObjectUtilities.equal(this.getRangeDescription(), var2.getRangeDescription())) {
            return false;
         } else if(!this.getClass().equals(var2.getClass())) {
            return false;
         } else if(this.getMaximumItemAge() != var2.getMaximumItemAge()) {
            return false;
         } else if(this.getMaximumItemCount() != var2.getMaximumItemCount()) {
            return false;
         } else {
            int var3 = this.getItemCount();
            if(var3 != var2.getItemCount()) {
               return false;
            } else {
               for(int var4 = 0; var4 < var3; ++var4) {
                  if(!this.getDataItem(var4).equals(var2.getDataItem(var4))) {
                     return false;
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.domain != null?this.domain.hashCode():0;
      var1 = 29 * var1 + (this.range != null?this.range.hashCode():0);
      var1 = 29 * var1 + (this.timePeriodClass != null?this.timePeriodClass.hashCode():0);
      var1 = 29 * var1 + this.data.hashCode();
      var1 = 29 * var1 + this.maximumItemCount;
      var1 = 29 * var1 + (int)this.maximumItemAge;
      return var1;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
