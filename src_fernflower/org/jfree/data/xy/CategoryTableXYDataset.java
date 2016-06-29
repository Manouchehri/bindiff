package org.jfree.data.xy;

import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DomainInfo;
import org.jfree.data.Range;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.IntervalXYDelegate;
import org.jfree.data.xy.TableXYDataset;

public class CategoryTableXYDataset extends AbstractIntervalXYDataset implements DomainInfo, IntervalXYDataset, TableXYDataset {
   private DefaultKeyedValues2D values = new DefaultKeyedValues2D(true);
   private IntervalXYDelegate intervalDelegate = new IntervalXYDelegate(this);

   public CategoryTableXYDataset() {
      this.addChangeListener(this.intervalDelegate);
   }

   public void add(double var1, double var3, String var5) {
      this.add(new Double(var1), new Double(var3), var5, true);
   }

   public void add(Number var1, Number var2, String var3, boolean var4) {
      this.values.addValue(var2, (Comparable)var1, var3);
      if(var4) {
         this.fireDatasetChanged();
      }

   }

   public void remove(double var1, String var3) {
      this.remove(new Double(var1), var3, true);
   }

   public void remove(Number var1, String var2, boolean var3) {
      this.values.removeValue((Comparable)var1, var2);
      if(var3) {
         this.fireDatasetChanged();
      }

   }

   public int getSeriesCount() {
      return this.values.getColumnCount();
   }

   public Comparable getSeriesKey(int var1) {
      return this.values.getColumnKey(var1);
   }

   public int getItemCount() {
      return this.values.getRowCount();
   }

   public int getItemCount(int var1) {
      return this.getItemCount();
   }

   public Number getX(int var1, int var2) {
      return (Number)this.values.getRowKey(var2);
   }

   public Number getStartX(int var1, int var2) {
      return this.intervalDelegate.getStartX(var1, var2);
   }

   public Number getEndX(int var1, int var2) {
      return this.intervalDelegate.getEndX(var1, var2);
   }

   public Number getY(int var1, int var2) {
      return this.values.getValue(var2, var1);
   }

   public Number getStartY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.getY(var1, var2);
   }

   public double getDomainLowerBound(boolean var1) {
      return this.intervalDelegate.getDomainLowerBound(var1);
   }

   public double getDomainUpperBound(boolean var1) {
      return this.intervalDelegate.getDomainUpperBound(var1);
   }

   public Range getDomainBounds(boolean var1) {
      return var1?this.intervalDelegate.getDomainBounds(var1):DatasetUtilities.iterateDomainBounds(this, var1);
   }

   public double getIntervalPositionFactor() {
      return this.intervalDelegate.getIntervalPositionFactor();
   }

   public void setIntervalPositionFactor(double var1) {
      this.intervalDelegate.setIntervalPositionFactor(var1);
      this.fireDatasetChanged();
   }

   public double getIntervalWidth() {
      return this.intervalDelegate.getIntervalWidth();
   }

   public void setIntervalWidth(double var1) {
      this.intervalDelegate.setFixedIntervalWidth(var1);
      this.fireDatasetChanged();
   }

   public boolean isAutoWidth() {
      return this.intervalDelegate.isAutoWidth();
   }

   public void setAutoWidth(boolean var1) {
      this.intervalDelegate.setAutoWidth(var1);
      this.fireDatasetChanged();
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof CategoryTableXYDataset)) {
         return false;
      } else {
         CategoryTableXYDataset var2 = (CategoryTableXYDataset)var1;
         return !this.intervalDelegate.equals(var2.intervalDelegate)?false:this.values.equals(var2.values);
      }
   }
}
