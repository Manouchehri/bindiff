/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.labels;

import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYZDataset;

public interface XYZToolTipGenerator
extends XYToolTipGenerator {
    public String generateToolTip(XYZDataset var1, int var2, int var3);
}

