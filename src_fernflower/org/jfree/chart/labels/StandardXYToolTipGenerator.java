package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractXYItemLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.PublicCloneable;

public class StandardXYToolTipGenerator extends AbstractXYItemLabelGenerator implements Serializable, Cloneable, XYToolTipGenerator, PublicCloneable {
   private static final long serialVersionUID = -3564164459039540784L;
   public static final String DEFAULT_TOOL_TIP_FORMAT = "{0}: ({1}, {2})";

   public static StandardXYToolTipGenerator getTimeSeriesInstance() {
      return new StandardXYToolTipGenerator("{0}: ({1}, {2})", DateFormat.getInstance(), NumberFormat.getInstance());
   }

   public StandardXYToolTipGenerator() {
      this("{0}: ({1}, {2})", NumberFormat.getNumberInstance(), NumberFormat.getNumberInstance());
   }

   public StandardXYToolTipGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
   }

   public StandardXYToolTipGenerator(String var1, DateFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
   }

   public StandardXYToolTipGenerator(String var1, NumberFormat var2, DateFormat var3) {
      super(var1, var2, var3);
   }

   public StandardXYToolTipGenerator(String var1, DateFormat var2, DateFormat var3) {
      super(var1, var2, var3);
   }

   public String generateToolTip(XYDataset var1, int var2, int var3) {
      return this.generateLabelString(var1, var2, var3);
   }

   public boolean equals(Object var1) {
      return var1 == this?true:(!(var1 instanceof StandardXYToolTipGenerator)?false:super.equals(var1));
   }

   public Object clone() {
      return super.clone();
   }
}
