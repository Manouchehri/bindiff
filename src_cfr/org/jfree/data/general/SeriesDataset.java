/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import org.jfree.data.general.Dataset;

public interface SeriesDataset
extends Dataset {
    public int getSeriesCount();

    public Comparable getSeriesKey(int var1);

    public int indexOf(Comparable var1);
}

