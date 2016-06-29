package org.jfree.data.time.ohlc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodAnchor;
import org.jfree.data.time.ohlc.OHLCItem;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.util.ObjectUtilities;

public class OHLCSeriesCollection extends AbstractXYDataset implements Serializable, OHLCDataset {
   private List data;
   private TimePeriodAnchor xPosition;

   public OHLCSeriesCollection() {
      this.xPosition = TimePeriodAnchor.MIDDLE;
      this.data = new ArrayList();
   }

   public void addSeries(OHLCSeries var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'series\' argument.");
      } else {
         this.data.add(var1);
         var1.addChangeListener(this);
         this.fireDatasetChanged();
      }
   }

   public int getSeriesCount() {
      return this.data.size();
   }

   public OHLCSeries getSeries(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (OHLCSeries)this.data.get(var1);
      } else {
         throw new IllegalArgumentException("Series index out of bounds");
      }
   }

   public Comparable getSeriesKey(int var1) {
      return this.getSeries(var1).getKey();
   }

   public int getItemCount(int var1) {
      return this.getSeries(var1).getItemCount();
   }

   protected synchronized long getX(RegularTimePeriod var1) {
      long var2 = 0L;
      if(this.xPosition == TimePeriodAnchor.START) {
         var2 = var1.getFirstMillisecond();
      } else if(this.xPosition == TimePeriodAnchor.MIDDLE) {
         var2 = var1.getMiddleMillisecond();
      } else if(this.xPosition == TimePeriodAnchor.END) {
         var2 = var1.getLastMillisecond();
      }

      return var2;
   }

   public double getXValue(int var1, int var2) {
      OHLCSeries var3 = (OHLCSeries)this.data.get(var1);
      OHLCItem var4 = (OHLCItem)var3.getDataItem(var2);
      RegularTimePeriod var5 = var4.getPeriod();
      return (double)this.getX(var5);
   }

   public Number getX(int var1, int var2) {
      return new Double(this.getXValue(var1, var2));
   }

   public Number getY(int var1, int var2) {
      OHLCSeries var3 = (OHLCSeries)this.data.get(var1);
      OHLCItem var4 = (OHLCItem)var3.getDataItem(var2);
      return new Double(var4.getYValue());
   }

   public double getOpenValue(int var1, int var2) {
      OHLCSeries var3 = (OHLCSeries)this.data.get(var1);
      OHLCItem var4 = (OHLCItem)var3.getDataItem(var2);
      return var4.getOpenValue();
   }

   public Number getOpen(int var1, int var2) {
      return new Double(this.getOpenValue(var1, var2));
   }

   public double getCloseValue(int var1, int var2) {
      OHLCSeries var3 = (OHLCSeries)this.data.get(var1);
      OHLCItem var4 = (OHLCItem)var3.getDataItem(var2);
      return var4.getCloseValue();
   }

   public Number getClose(int var1, int var2) {
      return new Double(this.getCloseValue(var1, var2));
   }

   public double getHighValue(int var1, int var2) {
      OHLCSeries var3 = (OHLCSeries)this.data.get(var1);
      OHLCItem var4 = (OHLCItem)var3.getDataItem(var2);
      return var4.getHighValue();
   }

   public Number getHigh(int var1, int var2) {
      return new Double(this.getHighValue(var1, var2));
   }

   public double getLowValue(int var1, int var2) {
      OHLCSeries var3 = (OHLCSeries)this.data.get(var1);
      OHLCItem var4 = (OHLCItem)var3.getDataItem(var2);
      return var4.getLowValue();
   }

   public Number getLow(int var1, int var2) {
      return new Double(this.getLowValue(var1, var2));
   }

   public Number getVolume(int var1, int var2) {
      return null;
   }

   public double getVolumeValue(int var1, int var2) {
      return Double.NaN;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof OHLCSeriesCollection)) {
         return false;
      } else {
         OHLCSeriesCollection var2 = (OHLCSeriesCollection)var1;
         return ObjectUtilities.equal(this.data, var2.data);
      }
   }

   public Object clone() {
      OHLCSeriesCollection var1 = (OHLCSeriesCollection)super.clone();
      var1.data = (List)ObjectUtilities.deepClone(this.data);
      return var1;
   }
}
