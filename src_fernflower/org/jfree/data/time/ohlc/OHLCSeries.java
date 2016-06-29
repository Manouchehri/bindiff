package org.jfree.data.time.ohlc;

import org.jfree.data.ComparableObjectItem;
import org.jfree.data.ComparableObjectSeries;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.ohlc.OHLCItem;

public class OHLCSeries extends ComparableObjectSeries {
   public OHLCSeries(Comparable var1) {
      super(var1, true, false);
   }

   public RegularTimePeriod getPeriod(int var1) {
      OHLCItem var2 = (OHLCItem)this.getDataItem(var1);
      return var2.getPeriod();
   }

   public ComparableObjectItem getDataItem(int var1) {
      return super.getDataItem(var1);
   }

   public void add(RegularTimePeriod var1, double var2, double var4, double var6, double var8) {
      if(this.getItemCount() > 0) {
         OHLCItem var10 = (OHLCItem)this.getDataItem(0);
         if(!var1.getClass().equals(var10.getPeriod().getClass())) {
            throw new IllegalArgumentException("Can\'t mix RegularTimePeriod class types.");
         }
      }

      super.add(new OHLCItem(var1, var2, var4, var6, var8), true);
   }
}
