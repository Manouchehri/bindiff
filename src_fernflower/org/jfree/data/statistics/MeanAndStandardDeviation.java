package org.jfree.data.statistics;

import java.io.Serializable;
import org.jfree.util.ObjectUtilities;

public class MeanAndStandardDeviation implements Serializable {
   private static final long serialVersionUID = 7413468697315721515L;
   private Number mean;
   private Number standardDeviation;

   public MeanAndStandardDeviation(double var1, double var3) {
      this(new Double(var1), new Double(var3));
   }

   public MeanAndStandardDeviation(Number var1, Number var2) {
      this.mean = var1;
      this.standardDeviation = var2;
   }

   public Number getMean() {
      return this.mean;
   }

   public Number getStandardDeviation() {
      return this.standardDeviation;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MeanAndStandardDeviation)) {
         return false;
      } else {
         MeanAndStandardDeviation var2 = (MeanAndStandardDeviation)var1;
         return !ObjectUtilities.equal(this.mean, var2.mean)?false:ObjectUtilities.equal(this.standardDeviation, var2.standardDeviation);
      }
   }
}
