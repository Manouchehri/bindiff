package org.jfree.data.xy;

import org.jfree.util.*;
import org.jfree.data.*;
import org.jfree.data.general.*;
import java.util.*;

public class DefaultXYDataset extends AbstractXYDataset implements XYDataset, PublicCloneable
{
    private List seriesKeys;
    private List seriesList;
    
    public DefaultXYDataset() {
        this.seriesKeys = new ArrayList();
        this.seriesList = new ArrayList();
    }
    
    public int getSeriesCount() {
        return this.seriesList.size();
    }
    
    public Comparable getSeriesKey(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds");
        }
        return this.seriesKeys.get(n);
    }
    
    public int indexOf(final Comparable comparable) {
        return this.seriesKeys.indexOf(comparable);
    }
    
    public DomainOrder getDomainOrder() {
        return DomainOrder.NONE;
    }
    
    public int getItemCount(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds");
        }
        return ((double[][])this.seriesList.get(n))[0].length;
    }
    
    public double getXValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[0][n2];
    }
    
    public Number getX(final int n, final int n2) {
        return new Double(this.getXValue(n, n2));
    }
    
    public double getYValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[1][n2];
    }
    
    public Number getY(final int n, final int n2) {
        return new Double(this.getYValue(n, n2));
    }
    
    public void addSeries(final Comparable comparable, final double[][] array) {
        if (comparable == null) {
            throw new IllegalArgumentException("The 'seriesKey' cannot be null.");
        }
        if (array == null) {
            throw new IllegalArgumentException("The 'data' is null.");
        }
        if (array.length != 2) {
            throw new IllegalArgumentException("The 'data' array must have length == 2.");
        }
        if (array[0].length != array[1].length) {
            throw new IllegalArgumentException("The 'data' array must contain two arrays with equal length.");
        }
        final int index = this.indexOf(comparable);
        if (index == -1) {
            this.seriesKeys.add(comparable);
            this.seriesList.add(array);
        }
        else {
            this.seriesList.remove(index);
            this.seriesList.add(index, array);
        }
        this.notifyListeners(new DatasetChangeEvent(this, this));
    }
    
    public void removeSeries(final Comparable comparable) {
        final int index = this.indexOf(comparable);
        if (index >= 0) {
            this.seriesKeys.remove(index);
            this.seriesList.remove(index);
            this.notifyListeners(new DatasetChangeEvent(this, this));
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DefaultXYDataset)) {
            return false;
        }
        final DefaultXYDataset defaultXYDataset = (DefaultXYDataset)o;
        if (!this.seriesKeys.equals(defaultXYDataset.seriesKeys)) {
            return false;
        }
        for (int i = 0; i < this.seriesList.size(); ++i) {
            final double[][] array = this.seriesList.get(i);
            final double[][] array2 = defaultXYDataset.seriesList.get(i);
            if (!Arrays.equals(array[0], array2[0])) {
                return false;
            }
            if (!Arrays.equals(array[1], array2[1])) {
                return false;
            }
        }
        return true;
    }
    
    public int hashCode() {
        return 29 * this.seriesKeys.hashCode() + this.seriesList.hashCode();
    }
    
    public Object clone() {
        final DefaultXYDataset defaultXYDataset = (DefaultXYDataset)super.clone();
        defaultXYDataset.seriesKeys = new ArrayList(this.seriesKeys);
        defaultXYDataset.seriesList = new ArrayList(this.seriesList.size());
        for (int i = 0; i < this.seriesList.size(); ++i) {
            final double[][] array = this.seriesList.get(i);
            final double[] array2 = array[0];
            final double[] array3 = array[1];
            final double[] array4 = new double[array2.length];
            final double[] array5 = new double[array3.length];
            System.arraycopy(array2, 0, array4, 0, array2.length);
            System.arraycopy(array3, 0, array5, 0, array3.length);
            defaultXYDataset.seriesList.add(i, new double[][] { array4, array5 });
        }
        return defaultXYDataset;
    }
}
