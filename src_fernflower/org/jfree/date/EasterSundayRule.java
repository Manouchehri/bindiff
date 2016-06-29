package org.jfree.date;

import org.jfree.date.AnnualDateRule;
import org.jfree.date.SerialDate;

public class EasterSundayRule extends AnnualDateRule {
   public SerialDate getDate(int var1) {
      int var2 = var1 % 19;
      int var3 = var1 / 100;
      int var4 = (var3 - var3 / 4 - (8 * var3 + 13) / 25 + 19 * var2 + 15) % 30;
      int var5 = var4 - var4 / 28 * (1 - var4 / 28 * 29 / (var4 + 1) * (21 - var2) / 11);
      int var6 = (var1 + var1 / 4 + var5 + 2 - var3 + var3 / 4) % 7;
      int var7 = var5 - var6;
      int var8 = 3 + (var7 + 40) / 44;
      int var9 = var7 + 28 - 31 * (var8 / 4);
      return SerialDate.createInstance(var9, var8, var1);
   }
}
