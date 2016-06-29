package org.jfree.chart.urls;

import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.xy.XYZDataset;

public interface XYZURLGenerator extends XYURLGenerator {
   String generateURL(XYZDataset var1, int var2, int var3);
}
