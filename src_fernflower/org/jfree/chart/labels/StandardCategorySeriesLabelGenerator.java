package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.PublicCloneable;

public class StandardCategorySeriesLabelGenerator implements Serializable, Cloneable, CategorySeriesLabelGenerator, PublicCloneable {
   private static final long serialVersionUID = 4630760091523940820L;
   public static final String DEFAULT_LABEL_FORMAT = "{0}";
   private String formatPattern;

   public StandardCategorySeriesLabelGenerator() {
      this("{0}");
   }

   public StandardCategorySeriesLabelGenerator(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'format\' argument.");
      } else {
         this.formatPattern = var1;
      }
   }

   public String generateLabel(CategoryDataset var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         String var3 = MessageFormat.format(this.formatPattern, this.createItemArray(var1, var2));
         return var3;
      }
   }

   protected Object[] createItemArray(CategoryDataset var1, int var2) {
      Object[] var3 = new Object[]{var1.getRowKey(var2).toString()};
      return var3;
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardCategorySeriesLabelGenerator)) {
         return false;
      } else {
         StandardCategorySeriesLabelGenerator var2 = (StandardCategorySeriesLabelGenerator)var1;
         return this.formatPattern.equals(var2.formatPattern);
      }
   }
}
