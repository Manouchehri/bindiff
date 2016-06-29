package org.jfree.data.time;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.time.TimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.TimePeriodValue;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.util.ObjectUtilities;

public class TimePeriodValuesCollection extends AbstractIntervalXYDataset implements Serializable, DomainInfo, IntervalXYDataset {
   private static final long serialVersionUID = -3077934065236454199L;
   private List data;
   private TimePeriodAnchor xPosition;
   private boolean domainIsPointsInTime;

   public TimePeriodValuesCollection() {
      this((TimePeriodValues)null);
   }

   public TimePeriodValuesCollection(TimePeriodValues var1) {
      this.data = new ArrayList();
      this.xPosition = TimePeriodAnchor.MIDDLE;
      this.domainIsPointsInTime = true;
      if(var1 != null) {
         this.data.add(var1);
         var1.addChangeListener(this);
      }

   }

   public TimePeriodAnchor getXPosition() {
      return this.xPosition;
   }

   public void setXPosition(TimePeriodAnchor var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'position\' argument.");
      } else {
         this.xPosition = var1;
      }
   }

   public boolean getDomainIsPointsInTime() {
      return this.domainIsPointsInTime;
   }

   public void setDomainIsPointsInTime(boolean var1) {
      this.domainIsPointsInTime = var1;
   }

   public int getSeriesCount() {
      return this.data.size();
   }

   public TimePeriodValues getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (TimePeriodValues)this.data.get(var1);
      } else {
         throw new IllegalArgumentException("Index \'series\' out of range.");
      }
   }

   public Comparable getSeriesKey(int var1) {
      return this.getSeries(var1).getKey();
   }

   public void addSeries(TimePeriodValues var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.add(var1);
         var1.addChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public void removeSeries(TimePeriodValues var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.remove(var1);
         var1.removeChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public void removeSeries(int var1) {
      TimePeriodValues var2 = this.getSeries(var1);
      if(var2 != null) {
         this.removeSeries(var2);
      }

   }

   public int getItemCount(int var1) {
      return this.getSeries(var1).getItemCount();
   }

   public Number getX(int var1, int var2) {
      TimePeriodValues var3 = (TimePeriodValues)this.data.get(var1);
      TimePeriodValue var4 = var3.getDataItem(var2);
      TimePeriod var5 = var4.getPeriod();
      return new Long(this.getX(var5));
   }

   private long getX(TimePeriod var1) {
      if(this.xPosition == TimePeriodAnchor.START) {
         return var1.getStart().getTime();
      } else if(this.xPosition == TimePeriodAnchor.MIDDLE) {
         return var1.getStart().getTime() / 2L + var1.getEnd().getTime() / 2L;
      } else if(this.xPosition == TimePeriodAnchor.END) {
         return var1.getEnd().getTime();
      } else {
         throw new IllegalStateException("TimePeriodAnchor unknown.");
      }
   }

   public Number getStartX(int var1, int var2) {
      TimePeriodValues var3 = (TimePeriodValues)this.data.get(var1);
      TimePeriodValue var4 = var3.getDataItem(var2);
      return new Long(var4.getPeriod().getStart().getTime());
   }

   public Number getEndX(int var1, int var2) {
      TimePeriodValues var3 = (TimePeriodValues)this.data.get(var1);
      TimePeriodValue var4 = var3.getDataItem(var2);
      return new Long(var4.getPeriod().getEnd().getTime());
   }

   public Number getY(int var1, int var2) {
      TimePeriodValues var3 = (TimePeriodValues)this.data.get(var1);
      TimePeriodValue var4 = var3.getDataItem(var2);
      return var4.getValue();
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
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
      Range var3 = null;
      Iterator var4 = this.data.iterator();

      while(var4.hasNext()) {
         TimePeriodValues var5 = (TimePeriodValues)var4.next();
         int var6 = var5.getItemCount();
         if(var6 > 0) {
            TimePeriod var7 = var5.getTimePeriod(var5.getMinStartIndex());
            TimePeriod var8 = var5.getTimePeriod(var5.getMaxEndIndex());
            if(this.domainIsPointsInTime) {
               TimePeriod var9;
               if(this.xPosition == TimePeriodAnchor.START) {
                  var9 = var5.getTimePeriod(var5.getMaxStartIndex());
                  var3 = new Range((double)var7.getStart().getTime(), (double)var9.getStart().getTime());
               } else if(this.xPosition == TimePeriodAnchor.MIDDLE) {
                  var9 = var5.getTimePeriod(var5.getMinMiddleIndex());
                  long var10 = var9.getStart().getTime();
                  long var12 = var9.getEnd().getTime();
                  TimePeriod var14 = var5.getTimePeriod(var5.getMaxMiddleIndex());
                  long var15 = var14.getStart().getTime();
                  long var17 = var14.getEnd().getTime();
                  var3 = new Range((double)(var10 + (var12 - var10) / 2L), (double)(var15 + (var17 - var15) / 2L));
               } else if(this.xPosition == TimePeriodAnchor.END) {
                  var9 = var5.getTimePeriod(var5.getMinEndIndex());
                  var3 = new Range((double)var9.getEnd().getTime(), (double)var8.getEnd().getTime());
               }
            } else {
               var3 = new Range((double)var7.getStart().getTime(), (double)var8.getEnd().getTime());
            }

            var2 = Range.combine(var2, var3);
         }
      }

      return var2;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof TimePeriodValuesCollection)) {
         return false;
      } else {
         TimePeriodValuesCollection var2 = (TimePeriodValuesCollection)var1;
         return this.domainIsPointsInTime != var2.domainIsPointsInTime?false:(this.xPosition != var2.xPosition?false:ObjectUtilities.equal(this.data, var2.data));
      }
   }
}
