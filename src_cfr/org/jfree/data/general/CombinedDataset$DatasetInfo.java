/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import org.jfree.data.general.CombinedDataset;
import org.jfree.data.general.SeriesDataset;

class CombinedDataset$DatasetInfo {
    private SeriesDataset data;
    private int series;
    private final CombinedDataset this$0;

    CombinedDataset$DatasetInfo(CombinedDataset combinedDataset, SeriesDataset seriesDataset, int n2) {
        this.this$0 = combinedDataset;
        this.data = seriesDataset;
        this.series = n2;
    }

    static int access$000(CombinedDataset$DatasetInfo combinedDataset$DatasetInfo) {
        return combinedDataset$DatasetInfo.series;
    }

    static SeriesDataset access$100(CombinedDataset$DatasetInfo combinedDataset$DatasetInfo) {
        return combinedDataset$DatasetInfo.data;
    }
}

