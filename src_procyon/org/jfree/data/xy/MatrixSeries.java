package org.jfree.data.xy;

import org.jfree.data.general.*;
import java.io.*;

public class MatrixSeries extends Series implements Serializable
{
    private static final long serialVersionUID = 7934188527308315704L;
    protected double[][] data;
    
    public MatrixSeries(final String s, final int n, final int n2) {
        super(s);
        this.data = new double[n][n2];
        this.zeroAll();
    }
    
    public int getColumnsCount() {
        return this.data[0].length;
    }
    
    public Number getItem(final int n) {
        return new Double(this.get(this.getItemRow(n), this.getItemColumn(n)));
    }
    
    public int getItemColumn(final int n) {
        return n % this.getColumnsCount();
    }
    
    public int getItemCount() {
        return this.getRowCount() * this.getColumnsCount();
    }
    
    public int getItemRow(final int n) {
        return n / this.getColumnsCount();
    }
    
    public int getRowCount() {
        return this.data.length;
    }
    
    public double get(final int n, final int n2) {
        return this.data[n][n2];
    }
    
    public void update(final int n, final int n2, final double n3) {
        this.data[n][n2] = n3;
        this.fireSeriesChanged();
    }
    
    public void zeroAll() {
        final int rowCount = this.getRowCount();
        final int columnsCount = this.getColumnsCount();
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnsCount; ++j) {
                this.data[i][j] = 0.0;
            }
        }
        this.fireSeriesChanged();
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MatrixSeries)) {
            return false;
        }
        final MatrixSeries matrixSeries = (MatrixSeries)o;
        if (this.getRowCount() != matrixSeries.getRowCount()) {
            return false;
        }
        if (this.getColumnsCount() != matrixSeries.getColumnsCount()) {
            return false;
        }
        for (int i = 0; i < this.getRowCount(); ++i) {
            for (int j = 0; j < this.getColumnsCount(); ++j) {
                if (this.get(i, j) != matrixSeries.get(i, j)) {
                    return false;
                }
            }
        }
        return super.equals(o);
    }
}
