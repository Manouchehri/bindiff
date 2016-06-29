package org.jfree.data.statistics;

import java.io.Serializable;
import org.jfree.util.PublicCloneable;

public class SimpleHistogramBin implements Serializable, Cloneable, Comparable, PublicCloneable {
   private static final long serialVersionUID = 3480862537505941742L;
   private double lowerBound;
   private double upperBound;
   private boolean includeLowerBound;
   private boolean includeUpperBound;
   private int itemCount;

   public SimpleHistogramBin(double var1, double var3) {
      this(var1, var3, true, true);
   }

   public SimpleHistogramBin(double var1, double var3, boolean var5, boolean var6) {
      if(var1 >= var3) {
         throw new IllegalArgumentException("Invalid bounds");
      } else {
         this.lowerBound = var1;
         this.upperBound = var3;
         this.includeLowerBound = var5;
         this.includeUpperBound = var6;
         this.itemCount = 0;
      }
   }

   public double getLowerBound() {
      return this.lowerBound;
   }

   public double getUpperBound() {
      return this.upperBound;
   }

   public int getItemCount() {
      return this.itemCount;
   }

   public void setItemCount(int var1) {
      this.itemCount = var1;
   }

   public boolean accepts(double var1) {
      return Double.isNaN(var1)?false:(var1 < this.lowerBound?false:(var1 > this.upperBound?false:(var1 == this.lowerBound?this.includeLowerBound:(var1 == this.upperBound?this.includeUpperBound:true))));
   }

   public boolean overlapsWith(SimpleHistogramBin var1) {
      return this.upperBound < var1.lowerBound?false:(this.lowerBound > var1.upperBound?false:(this.upperBound == var1.lowerBound?this.includeUpperBound && var1.includeLowerBound:(this.lowerBound != var1.upperBound?true:this.includeLowerBound && var1.includeUpperBound)));
   }

   public int compareTo(Object var1) {
      if(!(var1 instanceof SimpleHistogramBin)) {
         return 0;
      } else {
         SimpleHistogramBin var2 = (SimpleHistogramBin)var1;
         return this.lowerBound < var2.lowerBound?-1:(this.lowerBound > var2.lowerBound?1:(this.upperBound < var2.upperBound?-1:(this.upperBound > var2.upperBound?1:0)));
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof SimpleHistogramBin)) {
         return false;
      } else {
         SimpleHistogramBin var2 = (SimpleHistogramBin)var1;
         return this.lowerBound != var2.lowerBound?false:(this.upperBound != var2.upperBound?false:(this.includeLowerBound != var2.includeLowerBound?false:(this.includeUpperBound != var2.includeUpperBound?false:this.itemCount == var2.itemCount)));
      }
   }

   public Object clone() {
      return super.clone();
   }
}
