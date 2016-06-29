/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.SeriesDataset;

public interface XYDataset
extends SeriesDataset {
    public DomainOrder getDomainOrder();

    public int getItemCount(int var1);

    public Number getX(int var1, int var2);

    public double getXValue(int var1, int var2);

    public Number getY(int var1, int var2);

    public double getYValue(int var1, int var2);
}

