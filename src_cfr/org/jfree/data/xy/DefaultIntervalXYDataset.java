/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractIntervalXYDataset;

public class DefaultIntervalXYDataset
extends AbstractIntervalXYDataset {
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
    public double getYValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[3][n3];
    }

    @Override
    public double getStartXValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[1][n3];
    }

    @Override
    public double getEndXValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[2][n3];
    }

    @Override
    public double getStartYValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[4][n3];
    }

    @Override
    public double getEndYValue(int n2, int n3) {
        double[][] arrd = (double[][])this.seriesList.get(n2);
        return arrd[5][n3];
    }

    @Override
    public Number getEndX(int n2, int n3) {
        return new Double(this.getEndXValue(n2, n3));
    }

    @Override
    public Number getEndY(int n2, int n3) {
        return new Double(this.getEndYValue(n2, n3));
    }

    @Override
    public Number getStartX(int n2, int n3) {
        return new Double(this.getStartXValue(n2, n3));
    }

    @Override
    public Number getStartY(int n2, int n3) {
        return new Double(this.getStartYValue(n2, n3));
    }

    @Override
    public Number getX(int n2, int n3) {
        return new Double(this.getXValue(n2, n3));
    }

    @Override
    public Number getY(int n2, int n3) {
        return new Double(this.getYValue(n2, n3));
    }

    public void addSeries(Comparable comparable, double[][] arrd) {
        if (comparable == null) {
            throw new IllegalArgumentException("The 'seriesKey' cannot be null.");
        }
        if (arrd == null) {
            throw new IllegalArgumentException("The 'data' is null.");
        }
        if (arrd.length != 6) {
            throw new IllegalArgumentException("The 'data' array must have length == 6.");
        }
        int n2 = arrd[0].length;
        if (n2 != arrd[1].length) throw new IllegalArgumentException("The 'data' array must contain two arrays with equal length.");
        if (n2 != arrd[2].length) throw new IllegalArgumentException("The 'data' array must contain two arrays with equal length.");
        if (n2 != arrd[3].length) throw new IllegalArgumentException("The 'data' array must contain two arrays with equal length.");
        if (n2 != arrd[4].length) throw new IllegalArgumentException("The 'data' array must contain two arrays with equal length.");
        if (n2 != arrd[5].length) {
            throw new IllegalArgumentException("The 'data' array must contain two arrays with equal length.");
        }
        int n3 = this.indexOf(comparable);
        if (n3 == -1) {
            this.seriesKeys.add(comparable);
            this.seriesList.add(arrd);
        } else {
            this.seriesList.remove(n3);
            this.seriesList.add(n3, arrd);
        }
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof DefaultIntervalXYDataset)) {
            return false;
        }
        DefaultIntervalXYDataset defaultIntervalXYDataset = (DefaultIntervalXYDataset)object;
        if (!this.seriesKeys.equals(defaultIntervalXYDataset.seriesKeys)) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.seriesList.size()) {
            double[][] arrd;
            double[] arrd2;
            double[][] arrd3 = (double[][])this.seriesList.get(n2);
            double[] arrd4 = arrd3[0];
            if (!Arrays.equals(arrd4, arrd2 = (arrd = (double[][])defaultIntervalXYDataset.seriesList.get(n2))[0])) {
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
            double[] arrd9 = arrd3[3];
            double[] arrd10 = arrd[3];
            if (!Arrays.equals(arrd9, arrd10)) {
                return false;
            }
            double[] arrd11 = arrd3[4];
            double[] arrd12 = arrd[4];
            if (!Arrays.equals(arrd11, arrd12)) {
                return false;
            }
            double[] arrd13 = arrd3[5];
            double[] arrd14 = arrd[5];
            if (!Arrays.equals(arrd13, arrd14)) {
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
        DefaultIntervalXYDataset defaultIntervalXYDataset = (DefaultIntervalXYDataset)super.clone();
        defaultIntervalXYDataset.seriesKeys = new ArrayList(this.seriesKeys);
        defaultIntervalXYDataset.seriesList = new ArrayList(this.seriesList.size());
        int n2 = 0;
        while (n2 < this.seriesList.size()) {
            double[][] arrd = (double[][])this.seriesList.get(n2);
            double[] arrd2 = arrd[0];
            double[] arrd3 = arrd[1];
            double[] arrd4 = arrd[2];
            double[] arrd5 = arrd[3];
            double[] arrd6 = arrd[4];
            double[] arrd7 = arrd[5];
            double[] arrd8 = new double[arrd2.length];
            double[] arrd9 = new double[arrd3.length];
            double[] arrd10 = new double[arrd4.length];
            double[] arrd11 = new double[arrd5.length];
            double[] arrd12 = new double[arrd6.length];
            double[] arrd13 = new double[arrd7.length];
            System.arraycopy(arrd2, 0, arrd8, 0, arrd2.length);
            System.arraycopy(arrd3, 0, arrd9, 0, arrd3.length);
            System.arraycopy(arrd4, 0, arrd10, 0, arrd4.length);
            System.arraycopy(arrd5, 0, arrd11, 0, arrd5.length);
            System.arraycopy(arrd6, 0, arrd12, 0, arrd6.length);
            System.arraycopy(arrd7, 0, arrd13, 0, arrd7.length);
            defaultIntervalXYDataset.seriesList.add(n2, new double[][]{arrd8, arrd9, arrd10, arrd11, arrd12, arrd13});
            ++n2;
        }
        return defaultIntervalXYDataset;
    }
}

