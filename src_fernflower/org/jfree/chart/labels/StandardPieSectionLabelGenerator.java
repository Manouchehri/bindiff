package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.AttributedString;
import java.text.NumberFormat;
import org.jfree.chart.labels.AbstractPieItemLabelGenerator;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.util.ObjectList;

public class StandardPieSectionLabelGenerator extends AbstractPieItemLabelGenerator implements Serializable, Cloneable, PieSectionLabelGenerator {
   private static final long serialVersionUID = 3064190563760203668L;
   public static final String DEFAULT_SECTION_LABEL_FORMAT = "{0}";
   private ObjectList attributedLabels;

   public StandardPieSectionLabelGenerator() {
      this("{0}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
   }

   public StandardPieSectionLabelGenerator(String var1) {
      this(var1, NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());
   }

   public StandardPieSectionLabelGenerator(String var1, NumberFormat var2, NumberFormat var3) {
      super(var1, var2, var3);
      this.attributedLabels = new ObjectList();
   }

   public AttributedString getAttributedLabel(int var1) {
      return (AttributedString)this.attributedLabels.get(var1);
   }

   public void setAttributedLabel(int var1, AttributedString var2) {
      this.attributedLabels.set(var1, var2);
   }

   public String generateSectionLabel(PieDataset var1, Comparable var2) {
      return super.generateSectionLabel(var1, var2);
   }

   public AttributedString generateAttributedSectionLabel(PieDataset var1, Comparable var2) {
      return this.getAttributedLabel(var1.getIndex(var2));
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof StandardPieSectionLabelGenerator)) {
         return false;
      } else {
         StandardPieSectionLabelGenerator var2 = (StandardPieSectionLabelGenerator)var1;
         return !this.attributedLabels.equals(var2.attributedLabels)?false:super.equals(var1);
      }
   }

   public Object clone() {
      return super.clone();
   }
}
