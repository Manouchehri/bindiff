package org.jfree.data.general;

import java.util.ArrayList;
import java.util.List;
import org.jfree.data.general.CombinationDataset;
import org.jfree.data.general.CombinedDataset$DatasetInfo;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.SeriesDataset;
import org.jfree.data.general.SubSeriesDataset;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;

public class CombinedDataset extends AbstractIntervalXYDataset implements CombinationDataset, IntervalXYDataset, OHLCDataset, XYDataset {
   private List datasetInfo = new ArrayList();

   public CombinedDataset() {
   }

   public CombinedDataset(SeriesDataset[] var1) {
      this.add(var1);
   }

   public void add(SeriesDataset var1) {
      this.fastAdd(var1);
      DatasetChangeEvent var2 = new DatasetChangeEvent(this, this);
      this.notifyListeners(var2);
   }

   public void add(SeriesDataset[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.fastAdd(var1[var2]);
      }

      DatasetChangeEvent var3 = new DatasetChangeEvent(this, this);
      this.notifyListeners(var3);
   }

   public void add(SeriesDataset var1, int var2) {
      this.add((SeriesDataset)(new SubSeriesDataset(var1, var2)));
   }

   private void fastAdd(SeriesDataset var1) {
      for(int var2 = 0; var2 < var1.getSeriesCount(); ++var2) {
         this.datasetInfo.add(new CombinedDataset$DatasetInfo(this, var1, var2));
      }

   }

   public int getSeriesCount() {
      return this.datasetInfo.size();
   }

   public Comparable getSeriesKey(int var1) {
      CombinedDataset$DatasetInfo var2 = this.getDatasetInfo(var1);
      return CombinedDataset$DatasetInfo.access$100(var2).getSeriesKey(CombinedDataset$DatasetInfo.access$000(var2));
   }

   public Number getX(int var1, int var2) {
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return ((XYDataset)CombinedDataset$DatasetInfo.access$100(var3)).getX(CombinedDataset$DatasetInfo.access$000(var3), var2);
   }

   public Number getY(int var1, int var2) {
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return ((XYDataset)CombinedDataset$DatasetInfo.access$100(var3)).getY(CombinedDataset$DatasetInfo.access$000(var3), var2);
   }

   public int getItemCount(int var1) {
      CombinedDataset$DatasetInfo var2 = this.getDatasetInfo(var1);
      return ((XYDataset)CombinedDataset$DatasetInfo.access$100(var2)).getItemCount(CombinedDataset$DatasetInfo.access$000(var2));
   }

   public Number getHigh(int var1, int var2) {
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(var3)).getHigh(CombinedDataset$DatasetInfo.access$000(var3), var2);
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
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(var3)).getLow(CombinedDataset$DatasetInfo.access$000(var3), var2);
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
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(var3)).getOpen(CombinedDataset$DatasetInfo.access$000(var3), var2);
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
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(var3)).getClose(CombinedDataset$DatasetInfo.access$000(var3), var2);
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
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return ((OHLCDataset)CombinedDataset$DatasetInfo.access$100(var3)).getVolume(CombinedDataset$DatasetInfo.access$000(var3), var2);
   }

   public double getVolumeValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getVolume(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getStartX(int var1, int var2) {
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return CombinedDataset$DatasetInfo.access$100(var3) instanceof IntervalXYDataset?((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(var3)).getStartX(CombinedDataset$DatasetInfo.access$000(var3), var2):this.getX(var1, var2);
   }

   public Number getEndX(int var1, int var2) {
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return CombinedDataset$DatasetInfo.access$100(var3) instanceof IntervalXYDataset?((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(var3)).getEndX(CombinedDataset$DatasetInfo.access$000(var3), var2):this.getX(var1, var2);
   }

   public Number getStartY(int var1, int var2) {
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return CombinedDataset$DatasetInfo.access$100(var3) instanceof IntervalXYDataset?((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(var3)).getStartY(CombinedDataset$DatasetInfo.access$000(var3), var2):this.getY(var1, var2);
   }

   public Number getEndY(int var1, int var2) {
      CombinedDataset$DatasetInfo var3 = this.getDatasetInfo(var1);
      return CombinedDataset$DatasetInfo.access$100(var3) instanceof IntervalXYDataset?((IntervalXYDataset)CombinedDataset$DatasetInfo.access$100(var3)).getEndY(CombinedDataset$DatasetInfo.access$000(var3), var2):this.getY(var1, var2);
   }

   public SeriesDataset getParent() {
      SeriesDataset var1 = null;

      for(int var2 = 0; var2 < this.datasetInfo.size(); ++var2) {
         SeriesDataset var3 = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(var2));
         if(!(var3 instanceof CombinationDataset)) {
            return null;
         }

         SeriesDataset var4 = ((CombinationDataset)var3).getParent();
         if(var1 == null) {
            var1 = var4;
         } else if(var1 != var4) {
            return null;
         }
      }

      return var1;
   }

   public int[] getMap() {
      int[] var1 = null;

      for(int var2 = 0; var2 < this.datasetInfo.size(); ++var2) {
         SeriesDataset var3 = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(var2));
         if(!(var3 instanceof CombinationDataset)) {
            return null;
         }

         int[] var4 = ((CombinationDataset)var3).getMap();
         if(var4 == null) {
            return null;
         }

         var1 = this.joinMap(var1, var4);
      }

      return var1;
   }

   public int getChildPosition(Dataset var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.datasetInfo.size(); ++var3) {
         SeriesDataset var4 = CombinedDataset$DatasetInfo.access$100(this.getDatasetInfo(var3));
         if(var4 instanceof CombinedDataset) {
            int var5 = ((CombinedDataset)var4).getChildPosition(var1);
            if(var5 >= 0) {
               return var2 + var5;
            }

            ++var2;
         } else {
            if(var1 == var4) {
               return var2;
            }

            ++var2;
         }
      }

      return -1;
   }

   private CombinedDataset$DatasetInfo getDatasetInfo(int var1) {
      return (CombinedDataset$DatasetInfo)this.datasetInfo.get(var1);
   }

   private int[] joinMap(int[] var1, int[] var2) {
      if(var1 == null) {
         return var2;
      } else if(var2 == null) {
         return var1;
      } else {
         int[] var3 = new int[var1.length + var2.length];
         System.arraycopy(var1, 0, var3, 0, var1.length);
         System.arraycopy(var2, 0, var3, var1.length, var2.length);
         return var3;
      }
   }
}
