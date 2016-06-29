/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.general;

import java.io.Serializable;
import org.jfree.data.general.AbstractDataset;
import org.jfree.data.general.SeriesChangeEvent;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.general.SeriesDataset;

public abstract class AbstractSeriesDataset
extends AbstractDataset
implements Serializable,
SeriesChangeListener,
SeriesDataset {
    private static final long serialVersionUID = -6074996219705033171L;

    protected AbstractSeriesDataset() {
    }

    @Override
    public abstract int getSeriesCount();

    @Override
    public abstract Comparable getSeriesKey(int var1);

    @Override
    public int indexOf(Comparable comparable) {
        int n2 = this.getSeriesCount();
        int n3 = 0;
        while (n3 < n2) {
            if (this.getSeriesKey(n3).equals(comparable)) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    @Override
    public void seriesChanged(SeriesChangeEvent seriesChangeEvent) {
        this.fireDatasetChanged();
    }
}

