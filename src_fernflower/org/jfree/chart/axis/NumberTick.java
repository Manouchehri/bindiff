package org.jfree.chart.axis;

import org.jfree.chart.axis.ValueTick;
import org.jfree.ui.TextAnchor;

public class NumberTick extends ValueTick {
   private Number number;

   public NumberTick(Number var1, String var2, TextAnchor var3, TextAnchor var4, double var5) {
      super(var1.doubleValue(), var2, var3, var4, var5);
      this.number = var1;
   }

   public Number getNumber() {
      return this.number;
   }
}
