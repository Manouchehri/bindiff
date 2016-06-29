package org.jfree.data.xy;

import org.jfree.data.general.*;
import java.util.*;

public class DefaultIntervalXYDataset extends AbstractIntervalXYDataset
{
    private List seriesKeys;
    private List seriesList;
    
    public DefaultIntervalXYDataset() {
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
    
    public int getItemCount(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Series index out of bounds");
        }
        return ((double[][])this.seriesList.get(n))[0].length;
    }
    
    public double getXValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[0][n2];
    }
    
    public double getYValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[3][n2];
    }
    
    public double getStartXValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[1][n2];
    }
    
    public double getEndXValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[2][n2];
    }
    
    public double getStartYValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[4][n2];
    }
    
    public double getEndYValue(final int n, final int n2) {
        return ((double[][])this.seriesList.get(n))[5][n2];
    }
    
    public Number getEndX(final int n, final int n2) {
        return new Double(this.getEndXValue(n, n2));
    }
    
    public Number getEndY(final int n, final int n2) {
        return new Double(this.getEndYValue(n, n2));
    }
    
    public Number getStartX(final int n, final int n2) {
        return new Double(this.getStartXValue(n, n2));
    }
    
    public Number getStartY(final int n, final int n2) {
        return new Double(this.getStartYValue(n, n2));
    }
    
    public Number getX(final int n, final int n2) {
        return new Double(this.getXValue(n, n2));
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
        if (array.length != 6) {
            throw new IllegalArgumentException("The 'data' array must have length == 6.");
        }
        final int length = array[0].length;
        if (length != array[1].length || length != array[2].length || length != array[3].length || length != array[4].length || length != array[5].length) {
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
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DefaultIntervalXYDataset)) {
            return false;
        }
        final DefaultIntervalXYDataset defaultIntervalXYDataset = (DefaultIntervalXYDataset)o;
        if (!this.seriesKeys.equals(defaultIntervalXYDataset.seriesKeys)) {
            return false;
        }
        for (int i = 0; i < this.seriesList.size(); ++i) {
            final double[][] array = this.seriesList.get(i);
            final double[][] array2 = defaultIntervalXYDataset.seriesList.get(i);
            if (!Arrays.equals(array[0], array2[0])) {
                return false;
            }
            if (!Arrays.equals(array[1], array2[1])) {
                return false;
            }
            if (!Arrays.equals(array[2], array2[2])) {
                return false;
            }
            if (!Arrays.equals(array[3], array2[3])) {
                return false;
            }
            if (!Arrays.equals(array[4], array2[4])) {
                return false;
            }
            if (!Arrays.equals(array[5], array2[5])) {
                return false;
            }
        }
        return true;
    }
    
    public int hashCode() {
        return 29 * this.seriesKeys.hashCode() + this.seriesList.hashCode();
    }
    
    public Object clone() {
        final DefaultIntervalXYDataset defaultIntervalXYDataset = (DefaultIntervalXYDataset)super.clone();
        defaultIntervalXYDataset.seriesKeys = new ArrayList(this.seriesKeys);
        defaultIntervalXYDataset.seriesList = new ArrayList(this.seriesList.size());
        for (int i = 0; i < this.seriesList.size(); ++i) {
            final double[][] array = this.seriesList.get(i);
            final double[] array2 = array[0];
            final double[] array3 = array[1];
            final double[] array4 = array[2];
            final double[] array5 = array[3];
            final double[] array6 = array[4];
            final double[] array7 = array[5];
            final double[] array8 = new double[array2.length];
            final double[] array9 = new double[array3.length];
            final double[] array10 = new double[array4.length];
            final double[] array11 = new double[array5.length];
            final double[] array12 = new double[array6.length];
            final double[] array13 = new double[array7.length];
            System.arraycopy(array2, 0, array8, 0, array2.length);
            System.arraycopy(array3, 0, array9, 0, array3.length);
            System.arraycopy(array4, 0, array10, 0, array4.length);
            System.arraycopy(array5, 0, array11, 0, array5.length);
            System.arraycopy(array6, 0, array12, 0, array6.length);
            System.arraycopy(array7, 0, array13, 0, array7.length);
            defaultIntervalXYDataset.seriesList.add(i, new double[][] { array8, array9, array10, array11, array12, array13 });
        }
        return defaultIntervalXYDataset;
    }
}
