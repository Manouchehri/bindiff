/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.xy.XYZDataset;

public interface IntervalXYZDataset
extends XYZDataset {
    public Number getStartXValue(int var1, int var2);

    public Number getEndXValue(int var1, int var2);

    public Number getStartYValue(int var1, int var2);

    public Number getEndYValue(int var1, int var2);

    public Number getStartZValue(int var1, int var2);

    public Number getEndZValue(int var1, int var2);
}

