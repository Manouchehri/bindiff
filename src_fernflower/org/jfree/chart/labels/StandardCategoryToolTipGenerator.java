package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.data.category.CategoryDataset;

public class StandardCategoryToolTipGenerator extends AbstractCategoryItemLabelGenerator implements Serializable, CategoryToolTipGenerator {
   private static final long serialVersionUID = -6768806592218710764L;
   public static final String DEFAULT_TOOL_TIP_FORMAT_STRING = "({0}, {1}) = {2}";

   public StandardCategoryToolTipGenerator() {
      super("({0}, {1}) = {2}", NumberFormat.getInstance());
   }

   public StandardCategoryToolTipGenerator(String var1, NumberFormat var2) {
      super(var1, var2);
   }

   public StandardCategoryToolTipGenerator(String var1, DateFormat var2) {
      super(var1, var2);
   }

   public String generateToolTip(CategoryDataset var1, int var2, int var3) {
      return this.generateLabelString(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof StandardCategoryToolTipGenerator)?false:super.equals(var1));
   }
}
