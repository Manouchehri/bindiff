package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.util.PublicCloneable;

public class IntervalCategoryItemLabelGenerator extends StandardCategoryItemLabelGenerator implements Serializable, Cloneable, CategoryItemLabelGenerator, PublicCloneable {
   private static final long serialVersionUID = 5056909225610630529L;
   public static final String DEFAULT_LABEL_FORMAT_STRING = "({0}, {1}) = {3} - {4}";

   public IntervalCategoryItemLabelGenerator() {
      super("({0}, {1}) = {3} - {4}", NumberFormat.getInstance());
   }

   public IntervalCategoryItemLabelGenerator(String var1, NumberFormat var2) {
      super(var1, var2);
   }

   public IntervalCategoryItemLabelGenerator(String var1, DateFormat var2) {
      super(var1, var2);
   }

   protected Object[] createItemArray(CategoryDataset var1, int var2, int var3) {
      Object[] var4 = new Object[]{var1.getRowKey(var2).toString(), var1.getColumnKey(var3).toString(), null, null, null};
      Number var5 = var1.getValue(var2, var3);
      if(this.getNumberFormat() != null) {
         var4[2] = this.getNumberFormat().format(var5);
      } else if(this.getDateFormat() != null) {
         var4[2] = this.getDateFormat().format(var5);
      }

      if(var1 instanceof IntervalCategoryDataset) {
         IntervalCategoryDataset var6 = (IntervalCategoryDataset)var1;
         Number var7 = var6.getStartValue(var2, var3);
         Number var8 = var6.getEndValue(var2, var3);
         if(this.getNumberFormat() != null) {
            var4[3] = this.getNumberFormat().format(var7);
            var4[4] = this.getNumberFormat().format(var8);
         } else if(this.getDateFormat() != null) {
            var4[3] = this.getDateFormat().format(var7);
            var4[4] = this.getDateFormat().format(var8);
         }
      }

      return var4;
   }
}
