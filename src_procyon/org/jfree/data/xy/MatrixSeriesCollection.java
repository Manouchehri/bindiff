package org.jfree.data.xy;

import java.io.*;
import org.jfree.data.general.*;
import org.jfree.util.*;
import java.util.*;

public class MatrixSeriesCollection extends AbstractXYZDataset implements Serializable, XYZDataset
{
    private static final long serialVersionUID = -3197705779242543945L;
    private List seriesList;
    
    public MatrixSeriesCollection() {
        this(null);
    }
    
    public MatrixSeriesCollection(final MatrixSeries matrixSeries) {
        this.seriesList = new ArrayList();
        if (matrixSeries != null) {
            this.seriesList.add(matrixSeries);
            matrixSeries.addChangeListener(this);
        }
    }
    
    public int getItemCount(final int n) {
        return this.getSeries(n).getItemCount();
    }
    
    public MatrixSeries getSeries(final int n) {
        if (n < 0 || n > this.getSeriesCount()) {
            throw new IllegalArgumentException("Index outside valid range.");
        }
        return this.seriesList.get(n);
    }
    
    public int getSeriesCount() {
        return this.seriesList.size();
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.getSeries(n).getKey();
    }
    
    public Number getX(final int n, final int n2) {
        return new Integer(this.seriesList.get(n).getItemColumn(n2));
    }
    
    public Number getY(final int n, final int n2) {
        return new Integer(this.seriesList.get(n).getItemRow(n2));
    }
    
    public Number getZ(final int n, final int n2) {
        return this.seriesList.get(n).getItem(n2);
    }
    
    public void addSeries(final MatrixSeries matrixSeries) {
        if (matrixSeries == null) {
            throw new IllegalArgumentException("Cannot add null series.");
        }
        this.seriesList.add(matrixSeries);
        matrixSeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    public boolean equals(final Object o) {
        return o != null && (o == this || (o instanceof MatrixSeriesCollection && ObjectUtilities.equal(this.seriesList, ((MatrixSeriesCollection)o).seriesList)));
    }
    
    public int hashCode() {
        return (this.seriesList != null) ? this.seriesList.hashCode() : 0;
    }
    
    public Object clone() {
        final MatrixSeriesCollection collection = (MatrixSeriesCollection)super.clone();
        collection.seriesList = (List)ObjectUtilities.deepClone(this.seriesList);
        return collection;
    }
    
    public void removeAllSeries() {
        for (int i = 0; i < this.seriesList.size(); ++i) {
            ((MatrixSeries)this.seriesList.get(i)).removeChangeListener(this);
        }
        this.seriesList.clear();
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final MatrixSeries matrixSeries) {
        if (matrixSeries == null) {
            throw new IllegalArgumentException("Cannot remove null series.");
        }
        if (this.seriesList.contains(matrixSeries)) {
            matrixSeries.removeChangeListener(this);
            this.seriesList.remove(matrixSeries);
            this.fireDatasetChanged();
        }
    }
    
    public void removeSeries(final int n) {
        if (n < 0 || n > this.getSeriesCount()) {
            throw new IllegalArgumentException("Index outside valid range.");
        }
        this.seriesList.get(n).removeChangeListener(this);
        this.seriesList.remove(n);
        this.fireDatasetChanged();
    }
}
