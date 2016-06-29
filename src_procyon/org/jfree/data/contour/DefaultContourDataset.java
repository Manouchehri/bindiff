package org.jfree.data.contour;

import org.jfree.data.xy.*;
import org.jfree.data.*;
import java.util.*;

public class DefaultContourDataset extends AbstractXYZDataset implements ContourDataset
{
    protected Comparable seriesKey;
    protected Number[] xValues;
    protected Number[] yValues;
    protected Number[] zValues;
    protected int[] xIndex;
    boolean[] dateAxis;
    
    public DefaultContourDataset() {
        this.seriesKey = null;
        this.xValues = null;
        this.yValues = null;
        this.zValues = null;
        this.xIndex = null;
        this.dateAxis = new boolean[3];
    }
    
    public DefaultContourDataset(final Comparable seriesKey, final Object[] array, final Object[] array2, final Object[] array3) {
        this.seriesKey = null;
        this.xValues = null;
        this.yValues = null;
        this.zValues = null;
        this.xIndex = null;
        this.dateAxis = new boolean[3];
        this.seriesKey = seriesKey;
        this.initialize(array, array2, array3);
    }
    
    public void initialize(final Object[] array, final Object[] array2, final Object[] array3) {
        this.xValues = new Double[array.length];
        this.yValues = new Double[array2.length];
        this.zValues = new Double[array3.length];
        final Vector vector = new Vector<Integer>();
        double doubleValue = 1.123452E31;
        for (int i = 0; i < this.xValues.length; ++i) {
            if (array[i] != null) {
                Number n;
                if (array[i] instanceof Number) {
                    n = (Number)array[i];
                }
                else if (array[i] instanceof Date) {
                    this.dateAxis[0] = true;
                    n = new Long(((Date)array[i]).getTime());
                }
                else {
                    n = new Integer(0);
                }
                this.xValues[i] = new Double(n.doubleValue());
                if (doubleValue != this.xValues[i].doubleValue()) {
                    vector.add(new Integer(i));
                    doubleValue = this.xValues[i].doubleValue();
                }
            }
        }
        final Object[] array4 = vector.toArray();
        this.xIndex = new int[array4.length];
        for (int j = 0; j < array4.length; ++j) {
            this.xIndex[j] = (int)array4[j];
        }
        for (int k = 0; k < this.yValues.length; ++k) {
            this.yValues[k] = (Double)array2[k];
            if (array3[k] != null) {
                this.zValues[k] = (Double)array3[k];
            }
        }
    }
    
    public static Object[][] formObjectArray(final double[][] array) {
        final Double[][] array2 = new Double[array.length][array[0].length];
        for (int i = 0; i < array2.length; ++i) {
            for (int j = 0; j < array2[i].length; ++j) {
                array2[i][j] = new Double(array[i][j]);
            }
        }
        return array2;
    }
    
    public static Object[] formObjectArray(final double[] array) {
        final Double[] array2 = new Double[array.length];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = new Double(array[i]);
        }
        return array2;
    }
    
    public int getItemCount(final int n) {
        if (n > 0) {
            throw new IllegalArgumentException("Only one series for contour");
        }
        return this.zValues.length;
    }
    
    public double getMaxZValue() {
        double max = -1.0E20;
        for (int i = 0; i < this.zValues.length; ++i) {
            if (this.zValues[i] != null) {
                max = Math.max(max, this.zValues[i].doubleValue());
            }
        }
        return max;
    }
    
    public double getMinZValue() {
        double min = 1.0E20;
        for (int i = 0; i < this.zValues.length; ++i) {
            if (this.zValues[i] != null) {
                min = Math.min(min, this.zValues[i].doubleValue());
            }
        }
        return min;
    }
    
    public Range getZValueRange(final Range range, final Range range2) {
        final double lowerBound = range.getLowerBound();
        final double lowerBound2 = range2.getLowerBound();
        final double upperBound = range.getUpperBound();
        final double upperBound2 = range2.getUpperBound();
        double min = 1.0E20;
        double max = -1.0E20;
        for (int i = 0; i < this.zValues.length; ++i) {
            if (this.xValues[i].doubleValue() >= lowerBound && this.xValues[i].doubleValue() <= upperBound && this.yValues[i].doubleValue() >= lowerBound2 && this.yValues[i].doubleValue() <= upperBound2 && this.zValues[i] != null) {
                min = Math.min(min, this.zValues[i].doubleValue());
                max = Math.max(max, this.zValues[i].doubleValue());
            }
        }
        return new Range(min, max);
    }
    
    public double getMinZValue(final double n, final double n2, final double n3, final double n4) {
        double min = 1.0E20;
        for (int i = 0; i < this.zValues.length; ++i) {
            if (this.zValues[i] != null) {
                min = Math.min(min, this.zValues[i].doubleValue());
            }
        }
        return min;
    }
    
    public int getSeriesCount() {
        return 1;
    }
    
    public Comparable getSeriesKey(final int n) {
        if (n > 0) {
            throw new IllegalArgumentException("Only one series for contour");
        }
        return this.seriesKey;
    }
    
    public int[] getXIndices() {
        return this.xIndex;
    }
    
    public Number[] getXValues() {
        return this.xValues;
    }
    
    public Number getX(final int n, final int n2) {
        if (n > 0) {
            throw new IllegalArgumentException("Only one series for contour");
        }
        return this.xValues[n2];
    }
    
    public Number getXValue(final int n) {
        return this.xValues[n];
    }
    
    public Number[] getYValues() {
        return this.yValues;
    }
    
    public Number getY(final int n, final int n2) {
        if (n > 0) {
            throw new IllegalArgumentException("Only one series for contour");
        }
        return this.yValues[n2];
    }
    
    public Number[] getZValues() {
        return this.zValues;
    }
    
    public Number getZ(final int n, final int n2) {
        if (n > 0) {
            throw new IllegalArgumentException("Only one series for contour");
        }
        return this.zValues[n2];
    }
    
    public int[] indexX() {
        final int[] array = new int[this.xValues.length];
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.indexX(i);
        }
        return array;
    }
    
    public int indexX(final int n) {
        final int binarySearch = Arrays.binarySearch(this.xIndex, n);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        return -1 * binarySearch - 2;
    }
    
    public int indexY(final int n) {
        return n / this.xValues.length;
    }
    
    public int indexZ(final int n, final int n2) {
        return this.xValues.length * n2 + n;
    }
    
    public boolean isDateAxis(final int n) {
        return n >= 0 && n <= 2 && this.dateAxis[n];
    }
    
    public void setSeriesKeys(final Comparable[] array) {
        if (array.length > 1) {
            throw new IllegalArgumentException("Contours only support one series");
        }
        this.seriesKey = array[0];
        this.fireDatasetChanged();
    }
}
