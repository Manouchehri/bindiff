package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.NumberFormat;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.util.PublicCloneable;

public class BoxAndWhiskerToolTipGenerator extends StandardCategoryToolTipGenerator implements Serializable, Cloneable, CategoryToolTipGenerator, PublicCloneable {
   private static final long serialVersionUID = -6076837753823076334L;
   public static final String DEFAULT_TOOL_TIP_FORMAT = "X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ";

   public BoxAndWhiskerToolTipGenerator() {
      super("X: {1} Mean: {2} Median: {3} Min: {4} Max: {5} Q1: {6} Q3: {7} ", NumberFormat.getInstance());
   }

   public BoxAndWhiskerToolTipGenerator(String var1, NumberFormat var2) {
      super(var1, var2);
   }

   protected Object[] createItemArray(CategoryDataset var1, int var2, int var3) {
      Object[] var4 = new Object[8];
      var4[0] = var1.getRowKey(var2);
      Number var5 = var1.getValue(var2, var3);
      NumberFormat var6 = this.getNumberFormat();
      var4[1] = var6.format(var5);
      if(var1 instanceof BoxAndWhiskerCategoryDataset) {
         BoxAndWhiskerCategoryDataset var7 = (BoxAndWhiskerCategoryDataset)var1;
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
      return var1 == this?true:(var1 instanceof BoxAndWhiskerToolTipGenerator?super.equals(var1):false);
   }
}
