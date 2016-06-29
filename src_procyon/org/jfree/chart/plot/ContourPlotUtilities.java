package org.jfree.chart.plot;

import org.jfree.data.*;
import org.jfree.data.contour.*;

public abstract class ContourPlotUtilities
{
    public static Range visibleRange(final ContourDataset contourDataset, final Range range, final Range range2) {
        return ((DefaultContourDataset)contourDataset).getZValueRange(range, range2);
    }
}
