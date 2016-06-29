/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

public class DefaultXYZDataset
extends AbstractXYZDataset
implements XYZDataset {
    private List seriesKeys = new ArrayList();
    private List seriesList = new ArrayList();

    @Override
    public int getSeriesCount() {
        return this.seriesList.size();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 < this.getSeriesCount()) return (Comparable)this.seriesKeys.get(n2);
        throw new IllegalArgumentException("Series index out of bounds");
    }

    @Override
    public int indexOf(Comparable comparable) {
        return this.seriesKeys.indexOf(comparable);
    }

    @Override
    public DomainOrder getDomainOrder() {
        return DomainOrder.NONE;
    }

    @Override
    public int getItemCount(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Series index out of bounds");
        if (n2 >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds");
        }
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[0].length;
    }

    @Override
    public double getXValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[0][n3];
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Double(this.getXValue(n2, n3));
    }

    @Override
    public double getYValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[1][n3];
    }

    @Override
    public Number getY(int n2, int n3) {
        return new Double(this.getYValue(n2, n3));
    }

    @Override
    public double getZValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[2][n3];
    }

    @Override
    public Number getZ(int n2, int n3) {
        return new Double(this.getZValue(n2, n3));
    }

    public void addSeries(Comparable comparable, double[][] arrd) {
        if (comparable == null) {
            throw new IllegalArgumentException("The 'seriesKey' cannot be null.");
        }
        if (arrd == null) {
            throw new IllegalArgumentException("The 'data' is null.");
        }
        if (arrd.length != 3) {
            throw new IllegalArgumentException("The 'data' array must have length == 3.");
        }
        if (arrd[0].length != arrd[1].length) throw new IllegalArgumentException("The 'data' array must contain three arrays all having the same length.");
        if (arrd[0].length != arrd[2].length) {
            throw new IllegalArgumentException("The 'data' array must contain three arrays all having the same length.");
        }
        int n2 = this.indexOf(comparable);
        if (n2 == -1) {
            this.seriesKeys.add(comparable);
            this.seriesList.add(arrd);
        } else {
            this.seriesList.remove(n2);
            this.seriesList.add(n2, arrd);
        }
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public void removeSeries(Comparable comparable) {
        int n2 = this.indexOf(comparable);
        if (n2 < 0) return;
        this.seriesKeys.remove(n2);
        this.seriesList.remove(n2);
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultXYZDataset)) {
            return false;
        }
        DefaultXYZDataset defaultXYZDataset = (DefaultXYZDataset)object;
        if (!this.seriesKeys.equals(defaultXYZDataset.seriesKeys)) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.seriesList.size()) {
            double[][] arrd;
            double[] arrd2;
            double[][] arrd3 = (double[][])this.seriesList.get(n2);
            double[] arrd4 = arrd3[0];
            if (!Arrays.equals(arrd4, arrd2 = (arrd = (double[][])defaultXYZDataset.seriesList.get(n2))[0])) {
                return false;
            }
            double[] arrd5 = arrd3[1];
            double[] arrd6 = arrd[1];
            if (!Arrays.equals(arrd5, arrd6)) {
                return false;
            }
            double[] arrd7 = arrd3[2];
            double[] arrd8 = arrd[2];
            if (!Arrays.equals(arrd7, arrd8)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public int hashCode() {
        int n2 = this.seriesKeys.hashCode();
        return 29 * n2 + this.seriesList.hashCode();
    }

    @Override
    public Object clone() {
        DefaultXYZDataset defaultXYZDataset = (DefaultXYZDataset)super.clone();
        defaultXYZDataset.seriesKeys = new ArrayList(this.seriesKeys);
        defaultXYZDataset.seriesList = new ArrayList(this.seriesList.size());
        int n2 = 0;
        while (n2 < this.seriesList.size()) {
            double[][] arrd = (double[][])this.seriesList.get(n2);
            double[] arrd2 = arrd[0];
            double[] arrd3 = arrd[1];
            double[] arrd4 = arrd[2];
            double[] arrd5 = new double[arrd2.length];
            double[] arrd6 = new double[arrd3.length];
            double[] arrd7 = new double[arrd4.length];
            System.arraycopy(arrd2, 0, arrd5, 0, arrd2.length);
            System.arraycopy(arrd3, 0, arrd6, 0, arrd3.length);
            System.arraycopy(arrd4, 0, arrd7, 0, arrd4.length);
            defaultXYZDataset.seriesList.add(n2, new double[][]{arrd5, arrd6, arrd7});
            ++n2;
        }
        return defaultXYZDataset;
    }
}

