/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import org.jfree.data.general.Series;

public class MatrixSeries
extends Series
implements Serializable {
    private static final long serialVersionUID = 7934188527308315704L;
    protected double[][] data;

    public MatrixSeries(String string, int n2, int n3) {
        super((Comparable)((Object)string));
        this.data = new double[n2][n3];
        this.zeroAll();
    }

    public int getColumnsCount() {
        return this.data[0].length;
    }

    public Number getItem(int n2) {
        int n3 = this.getItemRow(n2);
        int n4 = this.getItemColumn(n2);
        return new Double(this.get(n3, n4));
    }

    public int getItemColumn(int n2) {
        return n2 % this.getColumnsCount();
    }

    public int getItemCount() {
        return this.getRowCount() * this.getColumnsCount();
    }

    public int getItemRow(int n2) {
        return n2 / this.getColumnsCount();
    }

    public int getRowCount() {
        return this.data.length;
    }

    public double get(int n2, int n3) {
        return this.data[n2][n3];
    }

    public void update(int n2, int n3, double d2) {
        this.data[n2][n3] = d2;
        this.fireSeriesChanged();
    }

    public void zeroAll() {
        int n2 = this.getRowCount();
        int n3 = this.getColumnsCount();
        int n4 = 0;
        do {
            if (n4 >= n2) {
                this.fireSeriesChanged();
                return;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                this.data[n4][i2] = 0.0;
            }
            ++n4;
        } while (true);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MatrixSeries)) {
            return false;
        }
        MatrixSeries matrixSeries = (MatrixSeries)object;
        if (this.getRowCount() != matrixSeries.getRowCount()) {
            return false;
        }
        if (this.getColumnsCount() != matrixSeries.getColumnsCount()) {
            return false;
        }
        int n2 = 0;
        while (n2 < this.getRowCount()) {
            for (int i2 = 0; i2 < this.getColumnsCount(); ++i2) {
                if (this.get(n2, i2) == matrixSeries.get(n2, i2)) continue;
                return false;
            }
            ++n2;
        }
        return super.equals(object);
    }
}

