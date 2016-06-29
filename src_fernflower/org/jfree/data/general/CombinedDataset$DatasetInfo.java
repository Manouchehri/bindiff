package org.jfree.data.general;

import org.jfree.data.general.CombinedDataset;
import org.jfree.data.general.SeriesDataset;

class CombinedDataset$DatasetInfo {
   private SeriesDataset data;
   private int series;
   private final CombinedDataset this$0;

   CombinedDataset$DatasetInfo(CombinedDataset var1, SeriesDataset var2, int var3) {
      this.this$0 = var1;
      this.data = var2;
      this.series = var3;
   }

   static int access$000(CombinedDataset$DatasetInfo var0) {
      return var0.series;
   }

   static SeriesDataset access$100(CombinedDataset$DatasetInfo var0) {
      return var0.data;
   }
}
