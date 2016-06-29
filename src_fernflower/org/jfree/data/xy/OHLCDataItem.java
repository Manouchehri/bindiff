package org.jfree.data.xy;

import java.io.Serializable;
import java.util.Date;

public class OHLCDataItem implements Serializable, Comparable {
   private static final long serialVersionUID = 7753817154401169901L;
   private Date date;
   private Number open;
   private Number high;
   private Number low;
   private Number close;
   private Number volume;

   public OHLCDataItem(Date var1, double var2, double var4, double var6, double var8, double var10) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'date\' argument.");
      } else {
         this.date = var1;
         this.open = new Double(var2);
         this.high = new Double(var4);
         this.low = new Double(var6);
         this.close = new Double(var8);
         this.volume = new Double(var10);
      }
   }

   public Date getDate() {
      return this.date;
   }

   public Number getOpen() {
      return this.open;
   }

   public Number getHigh() {
      return this.high;
   }

   public Number getLow() {
      return this.low;
   }

   public Number getClose() {
      return this.close;
   }

   public Number getVolume() {
      return this.volume;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof OHLCDataItem)) {
         return false;
      } else {
         OHLCDataItem var2 = (OHLCDataItem)var1;
         return !this.date.equals(var2.date)?false:(!this.high.equals(var2.high)?false:(!this.low.equals(var2.low)?false:(!this.open.equals(var2.open)?false:this.close.equals(var2.close))));
      }
   }

   public int compareTo(Object var1) {
      if(var1 instanceof OHLCDataItem) {
         OHLCDataItem var2 = (OHLCDataItem)var1;
         return this.date.compareTo(var2.date);
      } else {
         throw new ClassCastException("OHLCDataItem.compareTo().");
      }
   }
}
