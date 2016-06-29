package org.jfree.data.general;

import org.jfree.data.general.CombinationDataset;
import org.jfree.data.general.SeriesDataset;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;

public class SubSeriesDataset extends AbstractIntervalXYDataset implements CombinationDataset, IntervalXYDataset, OHLCDataset {
   private SeriesDataset parent;
   private int[] map;

   public SubSeriesDataset(SeriesDataset var1, int[] var2) {
      this.parent = null;
      this.parent = var1;
      this.map = var2;
   }

   public SubSeriesDataset(SeriesDataset var1, int var2) {
      this(var1, new int[]{var2});
   }

   public Number getHigh(int var1, int var2) {
      return ((OHLCDataset)this.parent).getHigh(this.map[var1], var2);
   }

   public double getHighValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getHigh(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getLow(int var1, int var2) {
      return ((OHLCDataset)this.parent).getLow(this.map[var1], var2);
   }

   public double getLowValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getLow(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getOpen(int var1, int var2) {
      return ((OHLCDataset)this.parent).getOpen(this.map[var1], var2);
   }

   public double getOpenValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getOpen(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getClose(int var1, int var2) {
      return ((OHLCDataset)this.parent).getClose(this.map[var1], var2);
   }

   public double getCloseValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getClose(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getVolume(int var1, int var2) {
      return ((OHLCDataset)this.parent).getVolume(this.map[var1], var2);
   }

   public double getVolumeValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getVolume(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getX(int var1, int var2) {
      return ((XYDataset)this.parent).getX(this.map[var1], var2);
   }

   public Number getY(int var1, int var2) {
      return ((XYDataset)this.parent).getY(this.map[var1], var2);
   }

   public int getItemCount(int var1) {
      return ((XYDataset)this.parent).getItemCount(this.map[var1]);
   }

   public int getSeriesCount() {
      return this.map.length;
   }

   public Comparable getSeriesKey(int var1) {
      return this.parent.getSeriesKey(this.map[var1]);
   }

   public Number getStartX(int var1, int var2) {
      return this.parent instanceof IntervalXYDataset?((IntervalXYDataset)this.parent).getStartX(this.map[var1], var2):this.getX(var1, var2);
   }

   public Number getEndX(int var1, int var2) {
      return this.parent instanceof IntervalXYDataset?((IntervalXYDataset)this.parent).getEndX(this.map[var1], var2):this.getX(var1, var2);
   }

   public Number getStartY(int var1, int var2) {
      return this.parent instanceof IntervalXYDataset?((IntervalXYDataset)this.parent).getStartY(this.map[var1], var2):this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      return this.parent instanceof IntervalXYDataset?((IntervalXYDataset)this.parent).getEndY(this.map[var1], var2):this.getY(var1, var2);
   }

   public SeriesDataset getParent() {
      return this.parent;
   }

   public int[] getMap() {
      return (int[])((int[])this.map.clone());
   }
}
