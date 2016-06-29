package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class StandardXYItemLabelGenerator extends AbstractXYItemLabelGenerator implements Serializable, Cloneable, XYItemLabelGenerator, PublicCloneable {
   private static final long serialVersionUID = 7807668053171837925L;
   public static final String DEFAULT_ITEM_LABEL_FORMAT = "{2}";

   public StandardXYItemLabelGenerator() {
      this("{2}", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
   }

   public StandardXYItemLabelGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
   }

   public StandardXYItemLabelGenerator(String var1, DateFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
   }

   public StandardXYItemLabelGenerator(String var1, NumberFormat var2, DateFormat var3) {
      super(var1, var2, var3);
   }

   public StandardXYItemLabelGenerator(String var1, DateFormat var2, DateFormat var3) {
      super(var1, var2, var3);
   }

   public String generateLabel(XYDataset var1, int var2, int var3) {
      return this.generateLabelString(var1, var2, var3);
   }

   public Object clone() {
      return super.clone();
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof StandardXYItemLabelGenerator)?false:super.equals(var1));
   }
}
