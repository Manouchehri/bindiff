/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.plot;

import org.jfree.data.Range;
import org.jfree.data.contour.ContourDataset;
import org.jfree.data.contour.DefaultContourDataset;

public abstract class ContourPlotUtilities {
    public static Range visibleRange(ContourDataset contourDataset, Range range, Range range2) {
        Range range3 = null;
        return ((DefaultContourDataset)contourDataset).getZValueRange(range, range2);
    }
}

