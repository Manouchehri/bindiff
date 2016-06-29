package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.XYDataset;

public class BoxAndWhiskerXYToolTipGenerator extends StandardXYToolTipGenerator implements Serializable, Cloneable, XYToolTipGenerator {
   private static final long serialVersionUID = -2648775791161459710L;
   public static final String DEFAULT_TOOL_TIP_FORMAT = "X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ";

   public BoxAndWhiskerXYToolTipGenerator() {
      super("X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ", NumberFormat.getInstance(), NumberFormat.getInstance());
   }

   public BoxAndWhiskerXYToolTipGenerator(String var1, DateFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
   }

   protected Object[] createItemArray(XYDataset var1, int var2, int var3) {
      Object[] var4 = new Object[8];
      var4[0] = var1.getSeriesKey(var2).toString();
      Number var5 = var1.getX(var2, var3);
      if(this.getXDateFormat() != null) {
         var4[1] = this.getXDateFormat().format(new Date(var5.longValue()));
      } else {
         var4[1] = this.getXFormat().format(var5);
      }

      NumberFormat var6 = this.getYFormat();
      if(var1 instanceof BoxAndWhiskerXYDataset) {
         BoxAndWhiskerXYDataset var7 = (BoxAndWhiskerXYDataset)var1;
         var4[2] = var6.format(var7.getMeanValue(var2, var3));
         var4[3] = var6.format(var7.getMedianValue(var2, var3));
         var4[4] = var6.format(var7.getMinRegularValue(var2, var3));
         var4[5] = var6.format(var7.getMaxRegularValue(var2, var3));
         var4[6] = var6.format(var7.getQ1Value(var2, var3));
         var4[7] = var6.format(var7.getQ3Value(var2, var3));
      }

      return var4;
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof BoxAndWhiskerXYToolTipGenerator)?false:super.equals(var1));
   }
}
