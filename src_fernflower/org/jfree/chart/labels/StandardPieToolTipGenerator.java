package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractPieItemLabelGenerator;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.PublicCloneable;

public class StandardPieToolTipGenerator extends AbstractPieItemLabelGenerator implements Serializable, Cloneable, PieToolTipGenerator, PublicCloneable {
   private static final long serialVersionUID = 2995304200445733779L;
   public static final String DEFAULT_TOOLTIP_FORMAT = "{0}: ({1}, {2})";
   public static final String DEFAULT_SECTION_LABEL_FORMAT = "{0} = {1}";

   public StandardPieToolTipGenerator() {
      this("{0} = {1}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
   }

   public StandardPieToolTipGenerator(String var1) {
      this(var1, NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
   }

   public StandardPieToolTipGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
   }

   public String generateToolTip(PieDataset var1, Comparable var2) {
      return this.generateSectionLabel(var1, var2);
   }

   public Object clone() {
      return super.clone();
   }
}
