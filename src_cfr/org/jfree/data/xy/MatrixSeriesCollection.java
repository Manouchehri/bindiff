/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.xy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.general.SeriesChangeListener;
import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.MatrixSeries;
import org.jfree.data.xy.XYZDataset;
import org.jfree.util.ObjectUtilities;

public class MatrixSeriesCollection
extends AbstractXYZDataset
implements Serializable,
XYZDataset {
    private static final long serialVersionUID = -3197705779242543945L;
    private List seriesList = new ArrayList();

    public MatrixSeriesCollection() {
        this(null);
    }

    public MatrixSeriesCollection(MatrixSeries matrixSeries) {
        if (matrixSeries == null) return;
        this.seriesList.add(matrixSeries);
        matrixSeries.addChangeListener(this);
    }

    @Override
    public int getItemCount(int n2) {
        return this.getSeries(n2).getItemCount();
    }

    public MatrixSeries getSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index outside valid range.");
        if (n2 <= this.getSeriesCount()) return (MatrixSeries)this.seriesList.get(n2);
        throw new IllegalArgumentException("Index outside valid range.");
    }

    @Override
    public int getSeriesCount() {
        return this.seriesList.size();
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        return this.getSeries(n2).getKey();
    }

    @Override
    public Number getX(int n2, int n3) {
        MatrixSeries matrixSeries = (MatrixSeries)this.seriesList.get(n2);
        int n4 = matrixSeries.getItemColumn(n3);
        return new Integer(n4);
    }

    @Override
    public Number getY(int n2, int n3) {
        MatrixSeries matrixSeries = (MatrixSeries)this.seriesList.get(n2);
        int n4 = matrixSeries.getItemRow(n3);
        return new Integer(n4);
    }

    @Override
    public Number getZ(int n2, int n3) {
        MatrixSeries matrixSeries = (MatrixSeries)this.seriesList.get(n2);
        return matrixSeries.getItem(n3);
    }

    public void addSeries(MatrixSeries matrixSeries) {
        if (matrixSeries == null) {
            throw new IllegalArgumentException("Cannot add null series.");
        }
        this.seriesList.add(matrixSeries);
        matrixSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof MatrixSeriesCollection)) return false;
        MatrixSeriesCollection matrixSeriesCollection = (MatrixSeriesCollection)object;
        return ObjectUtilities.equal(this.seriesList, matrixSeriesCollection.seriesList);
    }

    public int hashCode() {
        if (this.seriesList == null) return 0;
        int n2 = this.seriesList.hashCode();
        return n2;
    }

    @Override
    public Object clone() {
        MatrixSeriesCollection matrixSeriesCollection = (MatrixSeriesCollection)super.clone();
        matrixSeriesCollection.seriesList = (List)ObjectUtilities.deepClone(this.seriesList);
        return matrixSeriesCollection;
    }

    public void removeAllSeries() {
        int n2 = 0;
        do {
            if (n2 >= this.seriesList.size()) {
                this.seriesList.clear();
                this.fireDatasetChanged();
                return;
            }
            MatrixSeries matrixSeries = (MatrixSeries)this.seriesList.get(n2);
            matrixSeries.removeChangeListener(this);
            ++n2;
        } while (true);
    }

    public void removeSeries(MatrixSeries matrixSeries) {
        if (matrixSeries == null) {
            throw new IllegalArgumentException("Cannot remove null series.");
        }
        if (!this.seriesList.contains(matrixSeries)) return;
        matrixSeries.removeChangeListener(this);
        this.seriesList.remove(matrixSeries);
        this.fireDatasetChanged();
    }

    public void removeSeries(int n2) {
        if (n2 < 0) throw new IllegalArgumentException("Index outside valid range.");
        if (n2 > this.getSeriesCount()) {
            throw new IllegalArgumentException("Index outside valid range.");
        }
        MatrixSeries matrixSeries = (MatrixSeries)this.seriesList.get(n2);
        matrixSeries.removeChangeListener(this);
        this.seriesList.remove(n2);
        this.fireDatasetChanged();
    }
}

