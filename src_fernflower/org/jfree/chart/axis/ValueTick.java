package org.jfree.chart.axis;

import org.jfree.chart.axis.Tick;
import org.jfree.ui.TextAnchor;

public abstract class ValueTick extends Tick {
   private double value;

   public ValueTick(double var1, String var3, TextAnchor var4, TextAnchor var5, double var6) {
      super(var3, var4, var5, var6);
      this.value = var1;
   }

   public double getValue() {
      return this.value;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof ValueTick && super.equals(var1)) {
         ValueTick var2 = (ValueTick)var1;
         return this.value == var2.value;
      } else {
         return false;
      }
   }
}
