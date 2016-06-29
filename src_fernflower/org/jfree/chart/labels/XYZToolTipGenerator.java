package org.jfree.chart.labels;

import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYZDataset;

public interface XYZToolTipGenerator extends XYToolTipGenerator {
   String generateToolTip(XYZDataset var1, int var2, int var3);
}
