package org.jfree.data.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.statistics.SimpleHistogramBin;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class SimpleHistogramDataset extends AbstractIntervalXYDataset implements Serializable, Cloneable, IntervalXYDataset, PublicCloneable {
   private static final long serialVersionUID = 7997996479768018443L;
   private Comparable key;
   private List bins;
   private boolean adjustForBinSize;

   public SimpleHistogramDataset(Comparable var1) {
      this.key = var1;
      this.bins = new ArrayList();
      this.adjustForBinSize = true;
   }

   public boolean getAdjustForBinSize() {
      return this.adjustForBinSize;
   }

   public void setAdjustForBinSize(boolean var1) {
      this.adjustForBinSize = var1;
      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   public int getSeriesCount() {
      return 1;
   }

   public Comparable getSeriesKey(int var1) {
      return this.key;
   }

   public DomainOrder getDomainOrder() {
      return DomainOrder.ASCENDING;
   }

   public int getItemCount(int var1) {
      return this.bins.size();
   }

   public void addBin(SimpleHistogramBin var1) {
      Iterator var2 = this.bins.iterator();

      SimpleHistogramBin var3;
      do {
         if(!var2.hasNext()) {
            this.bins.add(var1);
            Collections.sort(this.bins);
            return;
         }

         var3 = (SimpleHistogramBin)var2.next();
      } while(!var1.overlapsWith(var3));

      throw new RuntimeException("Overlapping bin");
   }

   public void addObservation(double var1) {
      this.addObservation(var1, true);
   }

   public void addObservation(double var1, boolean var3) {
      boolean var4 = false;
      Iterator var5 = this.bins.iterator();

      while(var5.hasNext() && !var4) {
         SimpleHistogramBin var6 = (SimpleHistogramBin)var5.next();
         if(var6.accepts(var1)) {
            var6.setItemCount(var6.getItemCount() + 1);
            var4 = true;
         }
      }

      if(!var4) {
         throw new RuntimeException("No bin.");
      } else {
         if(var3) {
            this.notifyListeners(new DatasetChangeEvent(this, this));
         }

      }
   }

   public void addObservations(double[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.addObservation(var1[var2], false);
      }

      this.notifyListeners(new DatasetChangeEvent(this, this));
   }

   public Number getX(int var1, int var2) {
      return new Double(this.getXValue(var1, var2));
   }

   public double getXValue(int var1, int var2) {
      SimpleHistogramBin var3 = (SimpleHistogramBin)this.bins.get(var2);
      return (var3.getLowerBound() + var3.getUpperBound()) / 2.0D;
   }

   public Number getY(int var1, int var2) {
      return new Double(this.getYValue(var1, var2));
   }

   public double getYValue(int var1, int var2) {
      SimpleHistogramBin var3 = (SimpleHistogramBin)this.bins.get(var2);
      return this.adjustForBinSize?(double)var3.getItemCount() / (var3.getUpperBound() - var3.getLowerBound()):(double)var3.getItemCount();
   }

   public Number getStartX(int var1, int var2) {
      return new Double(this.getStartXValue(var1, var2));
   }

   public double getStartXValue(int var1, int var2) {
      SimpleHistogramBin var3 = (SimpleHistogramBin)this.bins.get(var2);
      return var3.getLowerBound();
   }

   public Number getEndX(int var1, int var2) {
      return new Double(this.getEndXValue(var1, var2));
   }

   public double getEndXValue(int var1, int var2) {
      SimpleHistogramBin var3 = (SimpleHistogramBin)this.bins.get(var2);
      return var3.getUpperBound();
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public double getStartYValue(int var1, int var2) {
      return this.getYValue(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public double getEndYValue(int var1, int var2) {
      return this.getYValue(var1, var2);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof SimpleHistogramDataset)) {
         return false;
      } else {
         SimpleHistogramDataset var2 = (SimpleHistogramDataset)var1;
         return !this.key.equals(var2.key)?false:(this.adjustForBinSize != var2.adjustForBinSize?false:this.bins.equals(var2.bins));
      }
   }

   public Object clone() {
      SimpleHistogramDataset var1 = (SimpleHistogramDataset)super.clone();
      var1.bins = (List)ObjectUtilities.deepClone(this.bins);
      return var1;
   }
}
