package org.jfree.chart.axis;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;

public class TickUnits implements Serializable, Cloneable, TickUnitSource {
   private static final long serialVersionUID = 1134174035901467545L;
   private List tickUnits = new ArrayList();

   public void add(TickUnit var1) {
      if(var1 == null) {
         throw new NullPointerException("Null \'unit\' argument.");
      } else {
         this.tickUnits.add(var1);
         Collections.sort(this.tickUnits);
      }
   }

   public int size() {
      return this.tickUnits.size();
   }

   public TickUnit get(int var1) {
      return (TickUnit)this.tickUnits.get(var1);
   }

   public TickUnit getLargerTickUnit(TickUnit var1) {
      int var2 = Collections.binarySearch(this.tickUnits, var1);
      if(var2 >= 0) {
         ++var2;
      } else {
         var2 = -var2;
      }

      return (TickUnit)this.tickUnits.get(Math.min(var2, this.tickUnits.size() - 1));
   }

   public TickUnit getCeilingTickUnit(TickUnit var1) {
      int var2 = Collections.binarySearch(this.tickUnits, var1);
      if(var2 >= 0) {
         return (TickUnit)this.tickUnits.get(var2);
      } else {
         var2 = -(var2 + 1);
         return (TickUnit)this.tickUnits.get(Math.min(var2, this.tickUnits.size() - 1));
      }
   }

   public TickUnit getCeilingTickUnit(double var1) {
      return this.getCeilingTickUnit(new NumberTickUnit(var1, NumberFormat.getInstance()));
   }

   public Object clone() {
      TickUnits var1 = (TickUnits)super.clone();
      var1.tickUnits = new ArrayList(this.tickUnits);
      return var1;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(var1 instanceof TickUnits) {
         TickUnits var2 = (TickUnits)var1;
         return var2.tickUnits.equals(this.tickUnits);
      } else {
         return false;
      }
   }
}
