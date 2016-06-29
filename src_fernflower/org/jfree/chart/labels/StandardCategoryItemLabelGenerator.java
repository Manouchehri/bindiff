package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.util.PublicCloneable;

public class StandardCategoryItemLabelGenerator extends AbstractCategoryItemLabelGenerator implements Serializable, Cloneable, CategoryItemLabelGenerator, PublicCloneable {
   private static final long serialVersionUID = 3499701401211412882L;
   public static final String DEFAULT_LABEL_FORMAT_STRING = "{2}";

   public StandardCategoryItemLabelGenerator() {
      super("{2}", NumberFormat.getInstance());
   }

   public StandardCategoryItemLabelGenerator(String var1, NumberFormat var2) {
      super(var1, var2);
   }

   public StandardCategoryItemLabelGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
   }

   public StandardCategoryItemLabelGenerator(String var1, DateFormat var2) {
      super(var1, var2);
   }

   public String generateLabel(CategoryDataset var1, int var2, int var3) {
      return this.generateLabelString(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof StandardCategoryItemLabelGenerator)?false:super.equals(var1));
   }
}
