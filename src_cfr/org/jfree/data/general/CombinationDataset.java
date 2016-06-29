/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import org.jfree.data.general.SeriesDataset;

public interface CombinationDataset {
    public SeriesDataset getParent();

    public int[] getMap();
}

