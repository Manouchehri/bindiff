package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.NumberFormat;
import org.jfree.chart.axis.TickUnit;

public class NumberTickUnit extends TickUnit implements Serializable {
   private static final long serialVersionUID = 3849459506627654442L;
   private NumberFormat formatter;

   public NumberTickUnit(double var1) {
      this(var1, NumberFormat.getNumberInstance());
   }

   public NumberTickUnit(double var1, NumberFormat var3) {
      super(var1);
      if(var3 == null) {
         throw new IllegalArgumentException("Null \'formatter\' argument.");
      } else {
         this.formatter = var3;
      }
   }

   public String valueToString(double var1) {
      return this.formatter.format(var1);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof NumberTickUnit)) {
         return false;
      } else if(!super.equals(var1)) {
         return false;
      } else {
         NumberTickUnit var2 = (NumberTickUnit)var1;
         return this.formatter.equals(var2.formatter);
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 29 * var1 + (this.formatter != null?this.formatter.hashCode():0);
      return var1;
   }
}
