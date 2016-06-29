package org.jfree.data.time.ohlc;

import java.io.Serializable;

public class OHLC implements Serializable {
   private double open;
   private double close;
   private double high;
   private double low;

   public OHLC(double var1, double var3, double var5, double var7) {
      this.open = var1;
      this.close = var7;
      this.high = var3;
      this.low = var5;
   }

   public double getOpen() {
      return this.open;
   }

   public double getClose() {
      return this.close;
   }

   public double getHigh() {
      return this.high;
   }

   public double getLow() {
      return this.low;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof OHLC)) {
         return false;
      } else {
         OHLC var2 = (OHLC)var1;
         return this.open != var2.open?false:(this.close != var2.close?false:(this.high != var2.high?false:this.low == var2.low));
      }
   }
}
