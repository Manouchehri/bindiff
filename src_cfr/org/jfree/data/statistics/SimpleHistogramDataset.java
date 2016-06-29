/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.statistics.SimpleHistogramBin;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class SimpleHistogramDataset
extends AbstractIntervalXYDataset
implements Serializable,
Cloneable,
IntervalXYDataset,
PublicCloneable {
    private static final long serialVersionUID = 7997996479768018443L;
    private Comparable key;
    private List bins;
    private boolean adjustForBinSize;

    public SimpleHistogramDataset(Comparable comparable) {
        this.key = comparable;
        this.bins = new ArrayList();
        this.adjustForBinSize = true;
    }

    public boolean getAdjustForBinSize() {
        return this.adjustForBinSize;
    }

    public void setAdjustForBinSize(boolean bl2) {
        this.adjustForBinSize = bl2;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    @Override
    public int getSeriesCount() {
        return 1;
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.key;
    }

    @Override
    public DomainOrder getDomainOrder() {
        return DomainOrder.ASCENDING;
    }

    @Override
    public int getItemCount(int n2) {
        return this.bins.size();
    }

    public void addBin(SimpleHistogramBin simpleHistogramBin) {
        SimpleHistogramBin simpleHistogramBin2;
        Iterator iterator = this.bins.iterator();
        do {
            if (iterator.hasNext()) continue;
            this.bins.add(simpleHistogramBin);
            Collections.sort(this.bins);
            return;
        } while (!simpleHistogramBin.overlapsWith(simpleHistogramBin2 = (SimpleHistogramBin)iterator.next()));
        throw new RuntimeException("Overlapping bin");
    }

    public void addObservation(double d2) {
        this.addObservation(d2, true);
    }

    public void addObservation(double d2, boolean bl2) {
        boolean bl3 = false;
        Iterator iterator = this.bins.iterator();
        while (iterator.hasNext()) {
            if (!bl3) {
                SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)iterator.next();
                if (!simpleHistogramBin.accepts(d2)) continue;
                simpleHistogramBin.setItemCount(simpleHistogramBin.getItemCount() + 1);
                bl3 = true;
                continue;
            }
            if (bl3) break;
            throw new RuntimeException("No bin.");
        }
        if (!bl2) return;
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public void addObservations(double[] arrd) {
        int n2 = 0;
        do {
            if (n2 >= arrd.length) {
                this.notifyListeners(new DatasetChangeEvent(this, this));
                return;
            }
            this.addObservation(arrd[n2], false);
            ++n2;
        } while (true);
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Double(this.getXValue(n2, n3));
    }

    @Override
    public double getXValue(int n2, int n3) {
        SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)this.bins.get(n3);
        return (simpleHistogramBin.getLowerBound() + simpleHistogramBin.getUpperBound()) / 2.0;
    }

    @Override
    public Number getY(int n2, int n3) {
        return new Double(this.getYValue(n2, n3));
    }

    @Override
    public double getYValue(int n2, int n3) {
        SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)this.bins.get(n3);
        if (!this.adjustForBinSize) return simpleHistogramBin.getItemCount();
        return (double)simpleHistogramBin.getItemCount() / (simpleHistogramBin.getUpperBound() - simpleHistogramBin.getLowerBound());
    }

    @Override
    public Number getStartX(int n2, int n3) {
        return new Double(this.getStartXValue(n2, n3));
    }

    @Override
    public double getStartXValue(int n2, int n3) {
        SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)this.bins.get(n3);
        return simpleHistogramBin.getLowerBound();
    }

    @Override
    public Number getEndX(int n2, int n3) {
        return new Double(this.getEndXValue(n2, n3));
    }

    @Override
    public double getEndXValue(int n2, int n3) {
        SimpleHistogramBin simpleHistogramBin = (SimpleHistogramBin)this.bins.get(n3);
        return simpleHistogramBin.getUpperBound();
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public double getStartYValue(int n2, int n3) {
        return this.getYValue(n2, n3);
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return this.getY(n2, n3);
    }

    @Override
    public double getEndYValue(int n2, int n3) {
        return this.getYValue(n2, n3);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SimpleHistogramDataset)) {
            return false;
        }
        SimpleHistogramDataset simpleHistogramDataset = (SimpleHistogramDataset)object;
        if (!this.key.equals(simpleHistogramDataset.key)) {
            return false;
        }
        if (this.adjustForBinSize != simpleHistogramDataset.adjustForBinSize) {
            return false;
        }
        if (this.bins.equals(simpleHistogramDataset.bins)) return true;
        return false;
    }

    @Override
    public Object clone() {
        SimpleHistogramDataset simpleHistogramDataset = (SimpleHistogramDataset)super.clone();
        simpleHistogramDataset.bins = (List)ObjectUtilities.deepClone(this.bins);
        return simpleHistogramDataset;
    }
}

