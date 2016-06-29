package org.jfree.chart.axis;

import java.util.Date;
import org.jfree.chart.axis.ValueTick;
import org.jfree.ui.TextAnchor;
import org.jfree.util.ObjectUtilities;

public class DateTick extends ValueTick {
   private Date date;

   public DateTick(Date var1, String var2, TextAnchor var3, TextAnchor var4, double var5) {
      super((double)var1.getTime(), var2, var3, var4, var5);
      this.date = var1;
   }

   public Date getDate() {
      return this.date;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof DateTick && super.equals(var1)) {
         DateTick var2 = (DateTick)var1;
         return ObjectUtilities.equal(this.date, var2.date);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.date.hashCode();
   }
}
