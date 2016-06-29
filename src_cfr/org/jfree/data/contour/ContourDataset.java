/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.contour;

import org.jfree.data.Range;
import org.jfree.data.xy.XYZDataset;

public interface ContourDataset
extends XYZDataset {
    public double getMinZValue();

    public double getMaxZValue();

    public Number[] getXValues();

    public Number[] getYValues();

    public Number[] getZValues();

    public int[] indexX();

    public int[] getXIndices();

    public Range getZValueRange(Range var1, Range var2);

    public boolean isDateAxis(int var1);
}

