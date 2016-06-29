/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.data.contour;

import org.jfree.data.Range;
import org.jfree.data.contour.DefaultContourDataset;

public class NonGridContourDataset
extends DefaultContourDataset {
    static final int DEFAULT_NUM_X = 50;
    static final int DEFAULT_NUM_Y = 50;
    static final int DEFAULT_POWER = 4;

    public NonGridContourDataset() {
    }

    public NonGridContourDataset(String string, Object[] arrobject, Object[] arrobject2, Object[] arrobject3) {
        super((Comparable)((Object)string), arrobject, arrobject2, arrobject3);
        this.buildGrid(50, 50, 4);
    }

    public NonGridContourDataset(String string, Object[] arrobject, Object[] arrobject2, Object[] arrobject3, int n2, int n3, int n4) {
        super((Comparable)((Object)string), arrobject, arrobject2, arrobject3);
        this.buildGrid(n2, n3, n4);
    }

    protected void buildGrid(int n2, int n3, int n4) {
        int n5;
        double d2;
        int n6;
        int n7 = n2 * n3;
        double[] arrd = new double[n7];
        double[] arrd2 = new double[n7];
        double[] arrd3 = new double[n7];
        double d3 = 1.0E20;
        for (int i2 = 0; i2 < this.xValues.length; ++i2) {
            d3 = Math.min(d3, this.xValues[i2].doubleValue());
        }
        double d4 = -1.0E20;
        for (int i3 = 0; i3 < this.xValues.length; ++i3) {
            d4 = Math.max(d4, this.xValues[i3].doubleValue());
        }
        double d5 = 1.0E20;
        for (int i4 = 0; i4 < this.yValues.length; ++i4) {
            d5 = Math.min(d5, this.yValues[i4].doubleValue());
        }
        double d6 = -1.0E20;
        for (int i5 = 0; i5 < this.yValues.length; ++i5) {
            d6 = Math.max(d6, this.yValues[i5].doubleValue());
        }
        Range range = new Range(d3, d4);
        Range range2 = new Range(d5, d6);
        range.getLength();
        range2.getLength();
        double d7 = range.getLength() / (double)(n2 - 1);
        double d8 = range2.getLength() / (double)(n3 - 1);
        double d9 = 0.0;
        int n8 = 0;
        do {
            if (n8 >= n2) break;
            d9 = n8 == 0 ? d3 : (d9 += d7);
            d2 = 0.0;
            for (n5 = 0; n5 < n3; ++n5) {
                n6 = n3 * n8 + n5;
                arrd[n6] = d9;
                d2 = n5 == 0 ? d5 : (d2 += d8);
                arrd2[n6] = d2;
            }
            ++n8;
        } while (true);
        n8 = 0;
        do {
            double d10;
            if (n8 >= arrd.length) {
                this.initialize(NonGridContourDataset.formObjectArray(arrd), NonGridContourDataset.formObjectArray(arrd2), NonGridContourDataset.formObjectArray(arrd3));
                return;
            }
            d2 = 0.0;
            arrd3[n8] = 0.0;
            for (n5 = 0; n5 < this.xValues.length; d2 += d10, ++n5) {
                n6 = (int)this.xValues[n5].doubleValue();
                double d11 = this.yValues[n5].doubleValue();
                d10 = this.distance(n6, d11, arrd[n8], arrd2[n8]);
                if (n4 != 1) {
                    d10 = Math.pow(d10, n4);
                }
                d10 = (d10 = Math.sqrt(d10)) > 0.0 ? 1.0 / d10 : 1.0E20;
                if (this.zValues[n5] == null) continue;
                double[] arrd4 = arrd3;
                int n9 = n8;
                arrd4[n9] = arrd4[n9] + this.zValues[n5].doubleValue() * d10;
            }
            arrd3[n8] = arrd3[n8] / d2;
            ++n8;
        } while (true);
    }

    protected double distance(double d2, double d3, double d4, double d5) {
        double d6 = d2 - d4;
        double d7 = d3 - d5;
        return Math.sqrt(d6 * d6 + d7 * d7);
    }
}

