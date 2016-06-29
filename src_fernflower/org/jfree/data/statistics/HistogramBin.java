package org.jfree.data.statistics;

import java.io.Serializable;

public class HistogramBin implements Serializable, Cloneable {
   private static final long serialVersionUID = 7614685080015589931L;
   private int count;
   private double startBoundary;
   private double endBoundary;

   public HistogramBin(double var1, double var3) {
      if(var1 > var3) {
         throw new IllegalArgumentException("HistogramBin():  startBoundary > endBoundary.");
      } else {
         this.count = 0;
         this.startBoundary = var1;
         this.endBoundary = var3;
      }
   }

   public int getCount() {
      return this.count;
   }

   public void incrementCount() {
      ++this.count;
   }

   public double getStartBoundary() {
      return this.startBoundary;
   }

   public double getEndBoundary() {
      return this.endBoundary;
   }

   public double getBinWidth() {
      return this.endBoundary - this.startBoundary;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(var1 instanceof HistogramBin) {
         HistogramBin var2 = (HistogramBin)var1;
         boolean var3 = var2.startBoundary == this.startBoundary;
         boolean var4 = var2.endBoundary == this.endBoundary;
         boolean var5 = var2.count == this.count;
         return var3 && var4 && var5;
      } else {
         return false;
      }
   }

   public Object clone() {
      return super.clone();
   }
}
