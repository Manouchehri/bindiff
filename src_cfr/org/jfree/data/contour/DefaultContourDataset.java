/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.contour;

import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import org.jfree.data.Range;
import org.jfree.data.contour.ContourDataset;
import org.jfree.data.xy.AbstractXYZDataset;

public class DefaultContourDataset
extends AbstractXYZDataset
implements ContourDataset {
    protected Comparable seriesKey = null;
    protected Number[] xValues = null;
    protected Number[] yValues = null;
    protected Number[] zValues = null;
    protected int[] xIndex = null;
    boolean[] dateAxis = new boolean[3];

    public DefaultContourDataset() {
    }

    public DefaultContourDataset(Comparable comparable, Object[] arrobject, Object[] arrobject2, Object[] arrobject3) {
        this.seriesKey = comparable;
        this.initialize(arrobject, arrobject2, arrobject3);
    }

    public void initialize(Object[] arrobject, Object[] arrobject2, Object[] arrobject3) {
        int n2;
        this.xValues = new Double[arrobject.length];
        this.yValues = new Double[arrobject2.length];
        this.zValues = new Double[arrobject3.length];
        Vector<Integer> vector = new Vector<Integer>();
        double d2 = 1.123452E31;
        for (int i2 = 0; i2 < this.xValues.length; ++i2) {
            Number number;
            if (arrobject[i2] == null) continue;
            if (arrobject[i2] instanceof Number) {
                number = (Number)arrobject[i2];
            } else if (arrobject[i2] instanceof Date) {
                this.dateAxis[0] = true;
                Date date = (Date)arrobject[i2];
                number = new Long(date.getTime());
            } else {
                number = new Integer(0);
            }
            this.xValues[i2] = new Double(number.doubleValue());
            if (d2 == this.xValues[i2].doubleValue()) continue;
            vector.add(new Integer(i2));
            d2 = this.xValues[i2].doubleValue();
        }
        Object[] arrobject4 = vector.toArray();
        this.xIndex = new int[arrobject4.length];
        for (n2 = 0; n2 < arrobject4.length; ++n2) {
            this.xIndex[n2] = (Integer)arrobject4[n2];
        }
        n2 = 0;
        while (n2 < this.yValues.length) {
            this.yValues[n2] = (Double)arrobject2[n2];
            if (arrobject3[n2] != null) {
                this.zValues[n2] = (Double)arrobject3[n2];
            }
            ++n2;
        }
    }

    public static Object[][] formObjectArray(double[][] arrd) {
        Object[][] arrobject = new Double[arrd.length][arrd[0].length];
        int n2 = 0;
        while (n2 < arrobject.length) {
            for (int i2 = 0; i2 < arrobject[n2].length; ++i2) {
                arrobject[n2][i2] = new Double(arrd[n2][i2]);
            }
            ++n2;
        }
        return arrobject;
    }

    public static Object[] formObjectArray(double[] arrd) {
        Object[] arrobject = new Double[arrd.length];
        int n2 = 0;
        while (n2 < arrobject.length) {
            arrobject[n2] = new Double(arrd[n2]);
            ++n2;
        }
        return arrobject;
    }

    @Override
    public int getItemCount(int n2) {
        if (n2 <= 0) return this.zValues.length;
        throw new IllegalArgumentException("Only one series for contour");
    }

    @Override
    public double getMaxZValue() {
        double d2 = -1.0E20;
        int n2 = 0;
        while (n2 < this.zValues.length) {
            if (this.zValues[n2] != null) {
                d2 = Math.max(d2, this.zValues[n2].doubleValue());
            }
            ++n2;
        }
        return d2;
    }

    @Override
    public double getMinZValue() {
        double d2 = 1.0E20;
        int n2 = 0;
        while (n2 < this.zValues.length) {
            if (this.zValues[n2] != null) {
                d2 = Math.min(d2, this.zValues[n2].doubleValue());
            }
            ++n2;
        }
        return d2;
    }

    @Override
    public Range getZValueRange(Range range, Range range2) {
        double d2 = range.getLowerBound();
        double d3 = range2.getLowerBound();
        double d4 = range.getUpperBound();
        double d5 = range2.getUpperBound();
        double d6 = 1.0E20;
        double d7 = -1.0E20;
        int n2 = 0;
        while (n2 < this.zValues.length) {
            if (this.xValues[n2].doubleValue() >= d2 && this.xValues[n2].doubleValue() <= d4 && this.yValues[n2].doubleValue() >= d3 && this.yValues[n2].doubleValue() <= d5 && this.zValues[n2] != null) {
                d6 = Math.min(d6, this.zValues[n2].doubleValue());
                d7 = Math.max(d7, this.zValues[n2].doubleValue());
            }
            ++n2;
        }
        return new Range(d6, d7);
    }

    public double getMinZValue(double d2, double d3, double d4, double d5) {
        double d6 = 1.0E20;
        int n2 = 0;
        while (n2 < this.zValues.length) {
            if (this.zValues[n2] != null) {
                d6 = Math.min(d6, this.zValues[n2].doubleValue());
            }
            ++n2;
        }
        return d6;
    }

    @Override
    public int getSeriesCount() {
        return 1;
    }

    @Override
    public Comparable getSeriesKey(int n2) {
        if (n2 <= 0) return this.seriesKey;
        throw new IllegalArgumentException("Only one series for contour");
    }

    @Override
    public int[] getXIndices() {
        return this.xIndex;
    }

    @Override
    public Number[] getXValues() {
        return this.xValues;
    }

    @Override
    public Number getX(int n2, int n3) {
        if (n2 <= 0) return this.xValues[n3];
        throw new IllegalArgumentException("Only one series for contour");
    }

    public Number getXValue(int n2) {
        return this.xValues[n2];
    }

    @Override
    public Number[] getYValues() {
        return this.yValues;
    }

    @Override
    public Number getY(int n2, int n3) {
        if (n2 <= 0) return this.yValues[n3];
        throw new IllegalArgumentException("Only one series for contour");
    }

    @Override
    public Number[] getZValues() {
        return this.zValues;
    }

    @Override
    public Number getZ(int n2, int n3) {
        if (n2 <= 0) return this.zValues[n3];
        throw new IllegalArgumentException("Only one series for contour");
    }

    @Override
    public int[] indexX() {
        int[] arrn = new int[this.xValues.length];
        int n2 = 0;
        while (n2 < arrn.length) {
            arrn[n2] = this.indexX(n2);
            ++n2;
        }
        return arrn;
    }

    public int indexX(int n2) {
        int n3 = Arrays.binarySearch(this.xIndex, n2);
        if (n3 < 0) return -1 * n3 - 2;
        return n3;
    }

    public int indexY(int n2) {
        return n2 / this.xValues.length;
    }

    public int indexZ(int n2, int n3) {
        return this.xValues.length * n3 + n2;
    }

    @Override
    public boolean isDateAxis(int n2) {
        if (n2 < 0) return false;
        if (n2 <= 2) return this.dateAxis[n2];
        return false;
    }

    public void setSeriesKeys(Comparable[] arrcomparable) {
        if (arrcomparable.length > 1) {
            throw new IllegalArgumentException("Contours only support one series");
        }
        this.seriesKey = arrcomparable[0];
        this.fireDatasetChanged();
    }
}

