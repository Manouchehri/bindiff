package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.MessageFormat;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class StandardXYSeriesLabelGenerator implements Serializable, Cloneable, XYSeriesLabelGenerator, PublicCloneable {
   private static final long serialVersionUID = 1916017081848400024L;
   public static final String DEFAULT_LABEL_FORMAT = "{0}";
   private String formatPattern;

   public StandardXYSeriesLabelGenerator() {
      this("{0}");
   }

   public StandardXYSeriesLabelGenerator(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'format\' argument.");
      } else {
         this.formatPattern = var1;
      }
   }

   public String generateLabel(XYDataset var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'dataset\' argument.");
      } else {
         String var3 = MessageFormat.format(this.formatPattern, this.createItemArray(var1, var2));
         return var3;
      }
   }

   protected Object[] createItemArray(XYDataset var1, int var2) {
      Object[] var3 = new Object[]{var1.getSeriesKey(var2).toString()};
      return var3;
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardXYSeriesLabelGenerator)) {
         return false;
      } else {
         StandardXYSeriesLabelGenerator var2 = (StandardXYSeriesLabelGenerator)var1;
         return this.formatPattern.equals(var2.formatPattern);
      }
   }
}
