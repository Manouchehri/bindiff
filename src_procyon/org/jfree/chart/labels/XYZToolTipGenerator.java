package org.jfree.chart.labels;

import org.jfree.data.xy.*;

public interface XYZToolTipGenerator extends XYToolTipGenerator
{
    String generateToolTip(final XYZDataset p0, final int p1, final int p2);
}
