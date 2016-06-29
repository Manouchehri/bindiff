package org.jfree.chart.labels;

import java.text.AttributedString;
import org.jfree.data.general.PieDataset;

public interface PieSectionLabelGenerator {
   String generateSectionLabel(PieDataset var1, Comparable var2);

   AttributedString generateAttributedSectionLabel(PieDataset var1, Comparable var2);
}
