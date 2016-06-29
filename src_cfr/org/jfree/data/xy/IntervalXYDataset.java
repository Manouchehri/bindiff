/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.xy.XYDataset;

public interface IntervalXYDataset
extends XYDataset {
    public Number getStartX(int var1, int var2);

    public double getStartXValue(int var1, int var2);

    public Number getEndX(int var1, int var2);

    public double getEndXValue(int var1, int var2);

    public Number getStartY(int var1, int var2);

    public double getStartYValue(int var1, int var2);

    public Number getEndY(int var1, int var2);

    public double getEndYValue(int var1, int var2);
}

