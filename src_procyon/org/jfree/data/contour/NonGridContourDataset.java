package org.jfree.data.contour;

import org.jfree.data.*;

public class NonGridContourDataset extends DefaultContourDataset
{
    static final int DEFAULT_NUM_X = 50;
    static final int DEFAULT_NUM_Y = 50;
    static final int DEFAULT_POWER = 4;
    
    public NonGridContourDataset() {
    }
    
    public NonGridContourDataset(final String s, final Object[] array, final Object[] array2, final Object[] array3) {
        super(s, array, array2, array3);
        this.buildGrid(50, 50, 4);
    }
    
    public NonGridContourDataset(final String s, final Object[] array, final Object[] array2, final Object[] array3, final int n, final int n2, final int n3) {
        super(s, array, array2, array3);
        this.buildGrid(n, n2, n3);
    }
    
    protected void buildGrid(final int n, final int n2, final int n3) {
        final int n4 = n * n2;
        final double[] array = new double[n4];
        final double[] array2 = new double[n4];
        final double[] array3 = new double[n4];
        double min = 1.0E20;
        for (int i = 0; i < this.xValues.length; ++i) {
            min = Math.min(min, this.xValues[i].doubleValue());
        }
        double max = -1.0E20;
        for (int j = 0; j < this.xValues.length; ++j) {
            max = Math.max(max, this.xValues[j].doubleValue());
        }
        double min2 = 1.0E20;
        for (int k = 0; k < this.yValues.length; ++k) {
            min2 = Math.min(min2, this.yValues[k].doubleValue());
        }
        double max2 = -1.0E20;
        for (int l = 0; l < this.yValues.length; ++l) {
            max2 = Math.max(max2, this.yValues[l].doubleValue());
        }
        final Range range = new Range(min, max);
        final Range range2 = new Range(min2, max2);
        range.getLength();
        range2.getLength();
        final double n5 = range.getLength() / (n - 1);
        final double n6 = range2.getLength() / (n2 - 1);
        double n7 = 0.0;
        for (int n8 = 0; n8 < n; ++n8) {
            if (n8 == 0) {
                n7 = min;
            }
            else {
                n7 += n5;
            }
            double n9 = 0.0;
            for (int n10 = 0; n10 < n2; ++n10) {
                final int n11 = n2 * n8 + n10;
                array[n11] = n7;
                if (n10 == 0) {
                    n9 = min2;
                }
                else {
                    n9 += n6;
                }
                array2[n11] = n9;
            }
        }
        for (int n12 = 0; n12 < array.length; ++n12) {
            double n13 = 0.0;
            array3[n12] = 0.0;
            for (int n14 = 0; n14 < this.xValues.length; ++n14) {
                double n15 = this.distance(this.xValues[n14].doubleValue(), this.yValues[n14].doubleValue(), array[n12], array2[n12]);
                if (n3 != 1) {
                    n15 = Math.pow(n15, n3);
                }
                final double sqrt = Math.sqrt(n15);
                double n16;
                if (sqrt > 0.0) {
                    n16 = 1.0 / sqrt;
                }
                else {
                    n16 = 1.0E20;
                }
                if (this.zValues[n14] != null) {
                    final double[] array4 = array3;
                    final int n17 = n12;
                    array4[n17] += this.zValues[n14].doubleValue() * n16;
                }
                n13 += n16;
            }
            array3[n12] /= n13;
        }
        this.initialize(DefaultContourDataset.formObjectArray(array), DefaultContourDataset.formObjectArray(array2), DefaultContourDataset.formObjectArray(array3));
    }
    
    protected double distance(final double n, final double n2, final double n3, final double n4) {
        final double n5 = n - n3;
        final double n6 = n2 - n4;
        return Math.sqrt(n5 * n5 + n6 * n6);
    }
}
