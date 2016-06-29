/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.renderer.xy;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYDataset;

public class CyclicXYItemRenderer$OverwriteDataSet
implements XYDataset {
    protected XYDataset delegateSet;
    Double[] x;
    Double[] y;

    public CyclicXYItemRenderer$OverwriteDataSet(double[] arrd, double[] arrd2, XYDataset xYDataset) {
        this.delegateSet = xYDataset;
        this.x = new Double[arrd.length];
        this.y = new Double[arrd2.length];
        int n2 = 0;
        while (n2 < arrd.length) {
            this.x[n2] = new Double(arrd[n2]);
            this.y[n2] = new Double(arrd2[n2]);
            ++n2;
        }
    }

    @Override
    public DomainOrder getDomainOrder() {
        return DomainOrder.NONE;
    }

    @Override
    public int getItemCount(int n2) {
        return this.x.length;
    }

    @Override
    public Number getX(int n2, int n3) {
        return this.x[n3];
    }

    @Override
    public double getXValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getX(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public Number getY(int n2, int n3) {
        return this.y[n3];
    }

    @Override
    public double getYValue(int n2, int n3) {
        double d2 = Double.NaN;
        Number number = this.getY(n2, n3);
        if (number == null) return d2;
        return number.doubleValue();
    }

    @Override
    public int getSeriesCount() {
        return this.delegateSet.getSeriesCount();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.delegateSet.getSeriesKey(n2);
    }

    @Override
    public int indexOf(Comparable comparable) {
        return this.delegateSet.indexOf(comparable);
    }

    @Override
    public void addChangeListener(DatasetChangeListener datasetChangeListener) {
    }

    @Override
    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {
    }

    @Override
    public DatasetGroup getGroup() {
        return this.delegateSet.getGroup();
    }

    @Override
    public void setGroup(DatasetGroup datasetGroup) {
    }
}

