/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import org.jfree.data.xy.XYDataset;

public interface OHLCDataset
extends XYDataset {
    public Number getHigh(int var1, int var2);

    public double getHighValue(int var1, int var2);

    public Number getLow(int var1, int var2);

    public double getLowValue(int var1, int var2);

    public Number getOpen(int var1, int var2);

    public double getOpenValue(int var1, int var2);

    public Number getClose(int var1, int var2);

    public double getCloseValue(int var1, int var2);

    public Number getVolume(int var1, int var2);

    public double getVolumeValue(int var1, int var2);
}

